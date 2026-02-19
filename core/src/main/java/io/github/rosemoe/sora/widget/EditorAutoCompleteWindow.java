package io.github.rosemoe.sora.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.CharPosition;
import io.github.rosemoe.sora.text.Cursor;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import ir.ninjacoder.ghostide.core.R;

public class EditorAutoCompleteWindow extends EditorPopupWindow {

  private final CodeEditor mEditor;
  private final ListView listview1;
  private final LinearProgressIndicator progress;
  private final CoordinatorLayout root;
  private final MaterialCardView card;
  private final GradientDrawable bg = new GradientDrawable();

  private EditorCompletionAdapter mAdapter = new CustomAdGhostWeb();
  private AutoCompleteProvider mProvider;

  private String mLastPrefix = "";
  private long mRequestTime;
  private int mCurrent = -1;
  private int mMaxHeight;
  private boolean mCancelShowUp;
  private boolean mLoading;
  private final ExecutorService executor = Executors.newFixedThreadPool(5);
  private Future<?> runningTask;
  private long loadingStart;

  public EditorAutoCompleteWindow(CodeEditor editor) {
    super(editor, FEATURE_SCROLL_AS_CONTENT | FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED);
    mEditor = editor;

    View v =
        LayoutInflater.from(editor.getContext()).inflate(R.layout.auto_textlayout, null, false);
    setContentView(v);

    root = v.findViewById(R.id.rootcoordinator);
    listview1 = v.findViewById(R.id.auto_listiviewHelper);
    progress = v.findViewById(R.id.barText);
    card = v.findViewById(R.id.auto_card_view);

    applyColorScheme();
    root.setBackground(bg);

    card.setCardBackgroundColor(Color.TRANSPARENT);
    card.setStrokeWidth(0);

    listview1.setAdapter(mAdapter);
    listview1.setDividerHeight(0);
    listview1.setOverScrollMode(ListView.OVER_SCROLL_NEVER);
    listview1.setVerticalScrollBarEnabled(false);
    listview1.setHorizontalScrollBarEnabled(false);
    listview1.setSelector(colorAccentDialog());
    listview1.setEmptyView(progress);
    progress.setIndeterminate(true);
    progress.setWaveAmplitude(5);
    progress.setWavelength(2);
    //  progress.setTrackCornerRadius(20);
    progress.setTrackColor(getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER));

    LayoutTransition lt = new LayoutTransition();
    lt.enableTransitionType(LayoutTransition.CHANGING);
    listview1.setLayoutTransition(lt);

    getPopup().setAnimationStyle(R.style.hso);

    setItemClick();
  }

  /* ================= API قدیمی (سازگاری کامل) ================= */

  public void setAdapter(EditorCompletionAdapter adapter) {
    if (adapter != null) {
      mAdapter = adapter;
      listview1.setAdapter(adapter);
    }
  }

  public String getPrefix() {
    return mLastPrefix;
  }

  public int getCurrentPosition() {
    return mCurrent;
  }

  public void select() {
    select(mCurrent);
  }

  public boolean trySelect() {
    if (mAdapter.getCount() <= 0) return false;

    if (mCurrent == -1) {
      select(0);
    } else {
      setItemClick();
    }
    return true;
  }

  public void setItemClick() {
    listview1.setOnItemClickListener(
        (p, v, pos, id) -> {
          try {
            select(pos);
          } catch (Exception e) {
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
          }
        });
  }

  /* ================= عملکرد سریع ================= */

  public void setProvider(AutoCompleteProvider provider) {
    mProvider = provider;
  }

  public void setPrefix(String prefix) {
    if (mCancelShowUp || mProvider == null) return;
    if (prefix.equals(mLastPrefix)) return;

    mLastPrefix = prefix;
    mRequestTime = System.currentTimeMillis();
    setLoading(true);

    if (runningTask != null) runningTask.cancel(true);

    final long time = mRequestTime;
    final TextAnalyzeResult colors = mEditor.getTextAnalyzeResult();
    final int line = mEditor.getCursor().getLeftLine();
    final int col = mEditor.getCursor().getLeftColumn();

    runningTask =
        executor.submit(
            () -> {
              try {
                Thread.sleep(120);
                if (Thread.currentThread().isInterrupted()) return;

                List<CompletionItem> items =
                    mProvider.getAutoCompleteItems(prefix, colors, line, col);

                displayResults(items, time);

              } catch (InterruptedException ignored) {
              } catch (Exception e) {
                displayResults(new ArrayList<>(), time);
              }
            });
  }

  private synchronized void displayResults(List<CompletionItem> results, long time) {
    if (time != mRequestTime) return;

    mEditor.post(
        () -> {
          setLoading(false);

          if (results == null || results.isEmpty()) {
            mEditor.clearGhostText();
            hide();
            return;
          }

          mAdapter.attachValues(this, results);
          mAdapter.notifyDataSetChanged();

          mCurrent = -1;
          int height = Math.min((int) (mAdapter.getItemHeight() * results.size()), mMaxHeight);
          setSize(getWidth(), height);
          show();

          if (!results.isEmpty() && mLastPrefix != null && !mLastPrefix.isEmpty()) {
            var firstItem = results.get(0);
            // better
            if (firstItem.label != null && firstItem.label.contains(mLastPrefix)) {
              var remaining = firstItem.label.substring(mLastPrefix.length());
              if (!remaining.isEmpty()) {
                mEditor.setGhostText(
                    mEditor.getCursor().getLeftLine(),
                    mEditor.getCursor().getLeftColumn(),
                    remaining);
              } else {
                mEditor.clearGhostText(); // clear
              }
            }
          }
        });
  }

  public void moveDown() {
    if (mCurrent + 1 >= mAdapter.getCount()) return;
    mCurrent++;
    mAdapter.notifyDataSetChanged();
    listview1.smoothScrollToPosition(mCurrent);
  }

  public void moveUp() {
    if (mCurrent <= 0) return;
    mCurrent--;
    mAdapter.notifyDataSetChanged();
    listview1.smoothScrollToPosition(mCurrent);
  }

  public void select(int pos) {
    if (pos < 0) {
      mEditor.getCursor().onCommitText("\n");
      return;
    }

    CompletionItem item = mAdapter.getItem(pos);
    Cursor c = mEditor.getCursor();

    if (!c.isSelected()) {
      mCancelShowUp = true;

      int len = mLastPrefix.length();
      if (mLastPrefix.contains(".")) {
        len -= mLastPrefix.lastIndexOf('.') + 1;
      }

      mEditor
          .getText()
          .delete(c.getLeftLine(), c.getLeftColumn() - len, c.getLeftLine(), c.getLeftColumn());

      c.onCommitText(item.commit);

      if (item.cursorOffset != item.commit.length()) {
        int delta = item.commit.length() - item.cursorOffset;
        int newPos = Math.max(c.getLeft() - delta, 0);
        CharPosition cp = c.getIndexer().getCharPosition(newPos);
        mEditor.setSelection(cp.line, cp.column);
      }

      mCancelShowUp = false;
    }

    hide();
  }

  public void setLoading(boolean state) {
    mLoading = state;
    if (state) {
      loadingStart = SystemClock.uptimeMillis();
      mEditor.postDelayed(
          () -> {
            if (mLoading && SystemClock.uptimeMillis() - loadingStart > 150) {
              progress.setVisibility(View.VISIBLE);
            }
          },
          150);
    } else {
      progress.setVisibility(View.GONE);
    }
  }

  public void applyColorScheme() {
    bg.setShape(GradientDrawable.RECTANGLE);
    bg.setCornerRadius(55);
    bg.setColor(getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_BG));
    bg.setStroke(2, getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER));
  }

  public CompletionItem getFirstItem() {
    if (mAdapter == null || mAdapter.getCount() == 0) return null;
    return mAdapter.getItem(0);
  }

  protected MaterialShapeDrawable colorAccentDialog() {
    MaterialShapeDrawable d =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 20f).build());

    d.setFillColor(ColorStateList.valueOf(getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_BG)));
    d.setStroke(
        2f, ColorStateList.valueOf(getThemeColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER)));
    return d;
  }

  protected int getThemeColor(int type) {
    return mEditor.getColorScheme().getColor(type);
  }

  public Context getContext() {
    return mEditor.getContext();
  }

  public void setMaxHeight(int h) {
    mMaxHeight = h;
  }

  public void hide() {
    super.dismiss();
    mEditor.clearGhostText();
  }

  public void cancelCompletion() {
    mLastPrefix = "";
    mRequestTime = -1;
    mCurrent = -1;
    mLoading = false;
    progress.setVisibility(View.GONE);

    if (runningTask != null) {
      runningTask.cancel(true);
      runningTask = null;
    }

    mAdapter.attachValues(this, new ArrayList<>());
    mAdapter.notifyDataSetChanged();

    hide();
  }
}
