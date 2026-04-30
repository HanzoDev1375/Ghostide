package io.github.rosemoe.sora.text;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.data.ObjectAllocator;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;

public class TextAnalyzer {

  private static final String TAG = "TextAnalyzer";
  private static final int MAX_LINES_FOR_FULL_ANALYSIS = 3000;
  private static final int MAX_BUFFER_SIZE = 100_000;

  private static final AtomicInteger sThreadId = new AtomicInteger(0);

  public final RecycleObjContainer mObjContainer = new RecycleObjContainer();
  private final Object mLock = new Object();
  private final CodeAnalyzer mCodeAnalyzer;

  public long mOpStartTime;

  private volatile TextAnalyzeResult mResult;
  private Callback mCallback;
  private AnalyzeThread mThread;
  private ExecutorService mBackgroundExecutor;
  private Future<?> mBackgroundTask;

  private Content mLastContent;
  private int mLastAnalyzedLineCount;
  private final AtomicBoolean mIsAnalyzing = new AtomicBoolean(false);

  public TextAnalyzer(CodeAnalyzer codeAnalyzer0) {
    if (codeAnalyzer0 == null) {
      throw new IllegalArgumentException();
    }
    mResult = new TextAnalyzeResult();
    mResult.addNormalIfNull();
    mCodeAnalyzer = codeAnalyzer0;
    mBackgroundExecutor =
        Executors.newSingleThreadExecutor(
            r -> {
              Thread t = new Thread(r, "TextAnalyzer-Background");
              t.setDaemon(true);
              t.setPriority(Thread.MIN_PRIORITY);
              return t;
            });
  }

  private static int nextThreadId() {
    return sThreadId.incrementAndGet();
  }

  private AnalyzeThread.Delegate createDelegate() {
    if (mThread != null && mThread.isAlive()) {
      return mThread.new Delegate();
    }
    return new AnalyzeThread(mLock, mCodeAnalyzer).new Delegate();
  }

  public void setCallback(Callback cb) {
    mCallback = cb;
  }

  public void shutdown() {
    final AnalyzeThread thread = mThread;
    if (thread != null && thread.isAlive()) {
      thread.interrupt();
      mThread = null;
    }
    if (mBackgroundExecutor != null && !mBackgroundExecutor.isShutdown()) {
      mBackgroundExecutor.shutdown();
    }
    if (mBackgroundTask != null && !mBackgroundTask.isDone()) {
      mBackgroundTask.cancel(true);
    }
  }

  public void notifyRecycle() {
    mObjContainer.recycle();
  }

  public synchronized void analyze(Content origin, boolean bg) {
    if (origin == null) return;

    if (mIsAnalyzing.get()) {
      AnalyzeThread thread = mThread;
      if (thread != null && thread.isAlive()) {
        thread.requestRestart(origin);
        synchronized (mLock) {
          mLock.notify();
        }
      }
      return;
    }

    boolean isLargeFile = origin.length() > 1_000_000;
    boolean canIncremental = mLastContent != null && !isLargeFile;

    if (bg) {
      scheduleBackgroundAnalysis(origin, canIncremental);
    } else {
      performImmediateAnalysis(origin, canIncremental);
    }

    mLastContent = origin;
    mLastAnalyzedLineCount = origin.getLineCount();
  }

  public synchronized void analyze(Content content) {
    analyze(content, shouldBackgroundAnalyze(content));
  }

  private boolean shouldBackgroundAnalyze(Content content) {
    if (content.length() > 500_000) {
      return true;
    }
    if (content.length() < 50_000) {
      return false;
    }
    return mIsAnalyzing.get();
  }

  private void performImmediateAnalysis(Content origin, boolean incremental) {
    mIsAnalyzing.set(true);

    AnalyzeThread thread = mThread;
    if (thread == null || !thread.isAlive()) {
      thread = mThread = new AnalyzeThread(mLock, mCodeAnalyzer);
      thread.setName("TextAnalyze-" + nextThreadId());
      thread.setDaemon(true);
      thread.setPriority(Thread.MAX_PRIORITY);
      thread.start();
    }

    thread.setContent(origin, !incremental);
    synchronized (mLock) {
      mLock.notify();
    }
  }

  private void scheduleBackgroundAnalysis(Content origin, boolean incremental) {
    if (mBackgroundTask != null && !mBackgroundTask.isDone()) {
      mBackgroundTask.cancel(true);
    }

    mBackgroundTask =
        mBackgroundExecutor.submit(
            () -> {
              try {
                performBackgroundAnalysis(origin, incremental);
              } catch (Exception e) {
                Log.e(TAG, "Background analysis failed", e);
              }
            });
  }

  private void performBackgroundAnalysis(Content origin, boolean incremental) {
    mIsAnalyzing.set(true);
    mOpStartTime = System.currentTimeMillis();

    try {
      TextAnalyzeResult result = new TextAnalyzeResult();
      var delegate = createDelegate();
      int lineCount = origin.getLineCount();
      if (lineCount > MAX_LINES_FOR_FULL_ANALYSIS) {
        analyzeInChunks(origin, result, delegate, lineCount);
      } else {
        StringBuilder buffer = new StringBuilder(Math.min(origin.length(), MAX_BUFFER_SIZE));
        origin.appendToStringBuilder(buffer);
        mCodeAnalyzer.analyze(buffer, result, delegate);
      }

      result.addNormalIfNull();
      result.runBeforePublish();

      updateResult(result);

    } catch (Exception e) {
      Log.e(TAG, "Analysis error", e);
    } finally {
      mIsAnalyzing.set(false);
    }
  }

  private void analyzeInChunks(
      Content content, TextAnalyzeResult result, AnalyzeThread.Delegate delegate, int totalLines) {
    int chunkSize = 500;
    StringBuilder chunkBuffer = new StringBuilder();

    for (int i = 0; i < totalLines; i += chunkSize) {
      if (delegate.shouldAnalyze()) return;

      chunkBuffer.setLength(0);
      int endLine = Math.min(i + chunkSize, totalLines);

      for (int j = i; j < endLine; j++) {
        if (j > i) chunkBuffer.append('\n');
        chunkBuffer.append(content.getLineString(j));
      }

      TextAnalyzeResult chunkResult = new TextAnalyzeResult();
      mCodeAnalyzer.analyze(chunkBuffer, chunkResult, delegate);

      mergeResults(result, chunkResult, i);
    }

    result.determine(totalLines - 1);
  }

  private void mergeResults(TextAnalyzeResult target, TextAnalyzeResult source, int startLine) {
    List<List<Span>> sourceSpans = source.getSpanMap();
    List<List<Span>> targetSpans = target.getSpanMap();

    for (int i = 0; i < sourceSpans.size(); i++) {
      int targetLine = startLine + i;
      while (targetSpans.size() <= targetLine) {
        targetSpans.add(new ArrayList<>());
      }
      targetSpans.get(targetLine).addAll(sourceSpans.get(i));
    }

    for (BlockLine block : source.getBlocks()) {
      block.startLine += startLine;
      block.endLine += startLine;
      target.addBlockLine(block);
    }
  }

  private void updateResult(TextAnalyzeResult newResult) {
    mObjContainer.blockLines = mResult.mBlocks;
    mObjContainer.spanMap = mResult.mSpanMap;
    mResult = newResult;

    if (mCallback != null) {
      try {
        mCallback.onAnalyzeDone(TextAnalyzer.this);
      } catch (Exception e) {
        Log.e(TAG, "Callback error", e);
      }
    }
  }

  public TextAnalyzeResult getResult() {
    return mResult;
  }

  public interface Callback {
    void onAnalyzeDone(TextAnalyzer analyzer);
  }

  public static class RecycleObjContainer {
    public List<List<Span>> spanMap;
    public List<BlockLine> blockLines;

    void recycle() {
      ObjectAllocator.recycleBlockLines(blockLines);
      SpanRecycler.getInstance().recycle(spanMap);
      clear();
    }

    void clear() {
      spanMap = null;
      blockLines = null;
    }
  }

  public class AnalyzeThread extends Thread {

    private final CodeAnalyzer codeAnalyzer;
    private final Object lock;
    private volatile boolean waiting = false;
    private Content content;
    private boolean forceFullAnalysis = false;

    public AnalyzeThread(Object lock, CodeAnalyzer a) {
      this.lock = lock;
      this.codeAnalyzer = a;
    }

    public void setContent(Content content, boolean forceFull) {
      this.content = content;
      this.forceFullAnalysis = forceFull;
      this.waiting = false;
    }

    public void requestRestart(Content newContent) {
      this.content = newContent;
      this.waiting = true;
    }

    @Override
    public void run() {
      try {
        StringBuilder buffer = new StringBuilder();

        while (!isInterrupted()) {
          if (content == null) {
            waitForContent();
            continue;
          }

          TextAnalyzeResult result = new TextAnalyzeResult();
          Delegate d = new Delegate();
          mOpStartTime = System.currentTimeMillis();

          do {
            waiting = false;

            if (forceFullAnalysis) {
              buffer.setLength(0);
              int maxLen = Math.min(content.length(), MAX_BUFFER_SIZE);
              buildLimitedBuffer(content, buffer, maxLen);
              codeAnalyzer.analyze(buffer, result, d);
            } else {
              analyzeLinesQuick(content, result, d);
            }

          } while (waiting && !isInterrupted());

          if (!waiting) {
            mObjContainer.blockLines = mResult.mBlocks;
            mObjContainer.spanMap = mResult.mSpanMap;
            mResult = result;
            result.addNormalIfNull();
            result.runBeforePublish();

            notifyCallback();
          }

          if (!waiting) {
            waitForContent();
          }
        }
      } catch (InterruptedException e) {
        Log.d(TAG, "Analyze thread interrupted");
      } catch (Exception ex) {
        Log.e(TAG, "Analyze thread error", ex);
      } finally {
        mIsAnalyzing.set(false);
      }
    }

    private void waitForContent() throws InterruptedException {
      synchronized (lock) {
        lock.wait();
      }
    }

    private void notifyCallback() {
      if (mCallback != null) {
        try {
          mCallback.onAnalyzeDone(TextAnalyzer.this);
        } catch (Exception e) {
          Log.e(TAG, "Callback error", e);
        }
      }
    }

    private void analyzeLinesQuick(Content content, TextAnalyzeResult result, Delegate d) {
      int lineCount = content.getLineCount();
      int maxLines = Math.min(lineCount, 2000);

      for (int i = 0; i < maxLines; i++) {
        if (d.shouldAnalyze() || isInterrupted()) return;

        String line = content.getLineString(i);

        TextAnalyzeResult lineResult = new TextAnalyzeResult();
        codeAnalyzer.analyze(line, lineResult, d);
      }

      result.determine(maxLines - 1);
    }

    private void buildLimitedBuffer(Content content, StringBuilder sb, int maxLen) {
      boolean first = true;
      final int lines = content.getLineCount();

      for (int i = 0; i < lines && sb.length() < maxLen; i++) {
        if (!first) {
          sb.append('\n');
        } else {
          first = false;
        }
        content.getLine(i).appendTo(sb);
      }
    }

    public class Delegate {
      public boolean shouldAnalyze() {
        return !waiting && !isInterrupted();
      }
    }
  }
}
