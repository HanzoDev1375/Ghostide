package com.ninjacoder.jgit.diffviews;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.*;
import android.text.TextPaint;
import android.util.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class GitDiffViewer extends View {
  private List<DiffLine> diffLines;
  private TextPaint textPaint;
  private TextPaint lineNumberPaint;
  private TextPaint selectionPaint;
  private DiffTheme theme;

  private float lineHeight = 60f;
  private float textSize = 32f;
  private float lineNumberWidth = 80f;

  private float scrollX = 0f;
  private float scrollY = 0f;
  private float scaleFactor = 1f;

  private ScaleGestureDetector scaleDetector;
  private OverScroller scroller;
  private VelocityTracker velocityTracker;
  private float lastX, lastY;
  private int ptrId = -1;

  private Paint bgPaint;
  private Paint lineNumberBgPaint;
  private Paint separatorPaint;
  private Paint horizontalLinePaint;

  private float cachedMaxTextWidth = -1;
  private float cachedTextSize = -1;
  private float[] lineWidths;

  private boolean isSelecting = false;
  private int selectionStartLine = -1;
  private int selectionEndLine = -1;
  private int selectionStartChar = -1;
  private int selectionEndChar = -1;
  private RectF selectionRect;

  private Handler longPressHandler;
  private Runnable longPressRunnable;
  private boolean isLongPress = false;
  private float downX, downY;

  private PopupWindow popupWindow;
  private LinearLayout popupLayout;

  public GitDiffViewer(Context context) {
    super(context);
    init(context);
  }

  public GitDiffViewer(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  private void init(Context context) {
    diffLines = new ArrayList<>();
    theme = new DiffTheme();
    longPressHandler = new Handler();

    textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    textPaint.setTextSize(textSize);
    textPaint.setTypeface(Typeface.MONOSPACE);

    lineNumberPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    lineNumberPaint.setTextSize(textSize * 0.85f);
    lineNumberPaint.setTypeface(Typeface.MONOSPACE);
    lineNumberPaint.setTextAlign(Paint.Align.CENTER);

    selectionPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    selectionPaint.setColor(Color.argb(100, 50, 150, 255));

    bgPaint = new Paint();
    lineNumberBgPaint = new Paint();
    separatorPaint = new Paint();
    horizontalLinePaint = new Paint();

    selectionRect = new RectF();

    scaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    scroller = new OverScroller(context);
    velocityTracker = VelocityTracker.obtain();

    setFocusable(true);
    setLayerType(LAYER_TYPE_HARDWARE, null);

    longPressRunnable =
        new Runnable() {
          @Override
          public void run() {
            isLongPress = true;
            startSelection(downX, downY);
            showPopupWindow();
          }
        };
  }

  public void applyDarkTheme() {
    theme.setDarkTheme();
    invalidate();
  }

  public void applyLightTheme() {
    theme.setLightTheme();
    invalidate();
  }

  public void applyMonokaiTheme() {
    theme.setMonokaiTheme();
    invalidate();
  }

  public void applyGitHubTheme() {
    theme.setGitHubTheme();
    invalidate();
  }

  public void applyDraculaTheme() {
    theme.setDraculaTheme();
    invalidate();
  }

  public DiffTheme getDiffTheme() {
    return theme;
  }

  public void setDiffTheme(DiffTheme t) {
    this.theme = t;
    invalidate();
  }

  public List<DiffLine> getDiffLines() {
    return diffLines;
  }

  public void parseDiffOutput(String diff) {
    List<DiffLine> lines = new ArrayList<>();
    String[] split = diff.split("\n");
    int oldNum = 0, newNum = 0;

    for (String line : split) {
      if (line.trim().isEmpty()) continue;

      if (line.startsWith("diff --git")
          || line.startsWith("index ")
          || line.startsWith("--- ")
          || line.startsWith("+++ ")) {
        lines.add(new DiffLine(line, DiffLine.LineType.HEADER, 0));
      } else if (line.startsWith("@@")) {
        lines.add(new DiffLine(line, DiffLine.LineType.HEADER, 0));
        int[] nums = extractNums(line);
        oldNum = nums[0] - 1;
        newNum = nums[1] - 1;
      } else if (line.startsWith("+")) {
        lines.add(new DiffLine(line, DiffLine.LineType.ADDED, ++newNum));
      } else if (line.startsWith("-")) {
        lines.add(new DiffLine(line, DiffLine.LineType.REMOVED, ++oldNum));
      } else if (line.startsWith(" ")) {
        lines.add(new DiffLine(line, DiffLine.LineType.NORMAL, ++newNum));
        oldNum++;
      }
    }
    setDiffLines(lines);
  }

  private int[] extractNums(String h) {
    try {
      String[] p = h.split(" ");
      return new int[] {
        Integer.parseInt(p[1].substring(1).split(",")[0]),
        Integer.parseInt(p[2].substring(1).split(",")[0])
      };
    } catch (Exception e) {
      return new int[] {1, 1};
    }
  }

  public void setDiffLines(List<DiffLine> lines) {
    this.diffLines = lines != null ? lines : new ArrayList<>();
    scrollX = 0;
    scrollY = 0;
    cachedMaxTextWidth = -1;
    lineWidths = null;
    clearSelection();
    invalidate();
  }

  private void cacheLineWidths() {
    if (lineWidths != null && lineWidths.length == diffLines.size()) return;
    lineWidths = new float[diffLines.size()];
    for (int i = 0; i < diffLines.size(); i++) {
      lineWidths[i] = textPaint.measureText(diffLines.get(i).getText());
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (diffLines.isEmpty()) return;

    float lh = lineHeight * scaleFactor;
    float ts = textSize * scaleFactor;
    float lnw = lineNumberWidth * scaleFactor;

    textPaint.setTextSize(ts);
    lineNumberPaint.setTextSize(ts * 0.85f);

    int start = (int) (scrollY / lh);
    if (start < 0) start = 0;
    int end = start + (int) (getHeight() / lh) + 2;
    if (end > diffLines.size()) end = diffLines.size();

    canvas.drawColor(theme.getNormalLineBg());

    for (int i = start; i < end; i++) {
      DiffLine line = diffLines.get(i);
      float top = i * lh - scrollY;
      float bottom = top + lh;

      bgPaint.setColor(getBg(line));
      canvas.drawRect(0, top, getWidth(), bottom, bgPaint);

      if (isSelecting && i >= selectionStartLine && i <= selectionEndLine) {
        drawSelection(canvas, i, top, bottom, lnw);
      }

      float numR = lnw - scrollX;
      if (numR > 0) {
        lineNumberBgPaint.setColor(theme.getLineNumberBg());
        canvas.drawRect(0, top, numR, bottom, lineNumberBgPaint);
        separatorPaint.setColor(theme.getSeparatorColor());
        canvas.drawLine(numR, top, numR, bottom, separatorPaint);
        if (line.getLineNumber() > 0 && line.getType() != DiffLine.LineType.HEADER) {
          lineNumberPaint.setColor(theme.getLineNumberTextColor());
          canvas.drawText("" + line.getLineNumber(), numR / 2, bottom - lh * 0.2f, lineNumberPaint);
        }
      }

      float tx = lnw + 20 * scaleFactor - scrollX;
      float ty = bottom - lh * 0.2f;
      textPaint.setColor(getTc(line));
      canvas.save();
      canvas.clipRect(lnw > scrollX ? lnw - scrollX : 0, top, getWidth(), bottom);
      canvas.drawText(line.getText(), tx, ty, textPaint);
      canvas.restore();

      horizontalLinePaint.setColor(theme.getHorizontalLineColor());
      canvas.drawLine(0, bottom, getWidth(), bottom, horizontalLinePaint);
    }
  }

  private void drawSelection(Canvas canvas, int lineIndex, float top, float bottom, float lnw) {
    String text = diffLines.get(lineIndex).getText();
    float textStartX = lnw + 20 * scaleFactor - scrollX;

    int startChar = (lineIndex == selectionStartLine) ? selectionStartChar : 0;
    int endChar = (lineIndex == selectionEndLine) ? selectionEndChar : text.length();

    if (startChar >= text.length() || endChar < 0) return;

    float selStartX = textStartX + textPaint.measureText(text.substring(0, startChar));
    float selEndX = textStartX + textPaint.measureText(text.substring(0, endChar));

    selectionRect.set(selStartX, top, selEndX, bottom);
    canvas.drawRect(selectionRect, selectionPaint);
  }

  private void startSelection(float x, float y) {
    float lh = lineHeight * scaleFactor;
    int lineIndex = (int) ((y + scrollY) / lh);

    if (lineIndex >= 0 && lineIndex < diffLines.size()) {
      isSelecting = true;
      selectionStartLine = lineIndex;
      selectionEndLine = lineIndex;

      float lnw = lineNumberWidth * scaleFactor;
      float textStartX = lnw + 20 * scaleFactor;
      String text = diffLines.get(lineIndex).getText();

      int charIndex = getCharIndexAtPosition(text, x + scrollX - textStartX);
      selectionStartChar = Math.max(0, Math.min(charIndex, text.length()));
      selectionEndChar = selectionStartChar;

      invalidate();
    }
  }

  private void updateSelection(float x, float y) {
    if (!isSelecting) return;

    float lh = lineHeight * scaleFactor;
    int lineIndex = (int) ((y + scrollY) / lh);

    if (lineIndex >= 0 && lineIndex < diffLines.size()) {
      int tempEndLine = lineIndex;
      float lnw = lineNumberWidth * scaleFactor;
      float textStartX = lnw + 20 * scaleFactor;
      String text = diffLines.get(lineIndex).getText();
      int tempEndChar =
          Math.max(
              0, Math.min(getCharIndexAtPosition(text, x + scrollX - textStartX), text.length()));

      if (selectionStartLine < tempEndLine
          || (selectionStartLine == tempEndLine && selectionStartChar <= tempEndChar)) {
        selectionEndLine = tempEndLine;
        selectionEndChar = tempEndChar;
      } else {
        selectionEndLine = selectionStartLine;
        selectionEndChar = selectionStartChar;
        selectionStartLine = tempEndLine;
        selectionStartChar = tempEndChar;
      }

      invalidate();
    }
  }

  private int getCharIndexAtPosition(String text, float x) {
    if (x <= 0 || text == null || text.isEmpty()) return 0;

    float currentX = 0;
    for (int i = 0; i < text.length(); i++) {
      float charWidth = textPaint.measureText(text.charAt(i) + "");
      if (currentX + charWidth / 2 > x) return i;
      currentX += charWidth;
    }
    return text.length();
  }

  private void clearSelection() {
    isSelecting = false;
    selectionStartLine = -1;
    selectionEndLine = -1;
    selectionStartChar = -1;
    selectionEndChar = -1;
    dismissPopupWindow();
    invalidate();
  }

  private void showPopupWindow() {
    dismissPopupWindow();

    popupLayout = new LinearLayout(getContext());
    popupLayout.setOrientation(LinearLayout.HORIZONTAL);
    popupLayout.setBackgroundColor(Color.rgb(50, 50, 50));
    popupLayout.setPadding(20, 20, 20, 20);

    Button selectAllBtn = new Button(getContext());
    selectAllBtn.setText("همه");
    selectAllBtn.setTextColor(Color.WHITE);
    selectAllBtn.setBackgroundColor(Color.rgb(70, 130, 180));
    selectAllBtn.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            selectAll();
          }
        });

    Button copyBtn = new Button(getContext());
    copyBtn.setText("copy");
    copyBtn.setTextColor(Color.WHITE);
    copyBtn.setBackgroundColor(Color.rgb(60, 179, 113));
    copyBtn.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            copySelection();
          }
        });

    Button cancelBtn = new Button(getContext());
    cancelBtn.setText("بستن");
    cancelBtn.setTextColor(Color.WHITE);
    cancelBtn.setBackgroundColor(Color.rgb(220, 20, 60));
    cancelBtn.setOnClickListener(
        new OnClickListener() {
          @Override
          public void onClick(View v) {
            clearSelection();
          }
        });

    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    params.setMargins(10, 0, 10, 0);

    popupLayout.addView(selectAllBtn, params);
    popupLayout.addView(copyBtn, params);
    popupLayout.addView(cancelBtn, params);

    popupWindow =
        new PopupWindow(
            popupLayout,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            true);
    popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    popupWindow.setOutsideTouchable(true);
    popupWindow.setOnDismissListener(
        new PopupWindow.OnDismissListener() {
          @Override
          public void onDismiss() {
            if (!isSelecting) {
              clearSelection();
            }
          }
        });

    float lh = lineHeight * scaleFactor;
    int yOffset = (int) (selectionStartLine * lh - scrollY) - 150;
    popupWindow.showAtLocation(
        this, Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, Math.max(0, yOffset));
  }

  private void selectAll() {
    if (diffLines.isEmpty()) return;

    isSelecting = true;
    selectionStartLine = 0;
    selectionStartChar = 0;
    selectionEndLine = diffLines.size() - 1;
    selectionEndChar = diffLines.get(selectionEndLine).getText().length();
    invalidate();
    Toast.makeText(getContext(), "همه متن انتخاب شد", Toast.LENGTH_SHORT).show();
  }

  private void copySelection() {
    String selectedText = getSelectedText();
    if (!selectedText.isEmpty()) {
      android.content.ClipboardManager clipboard =
          (android.content.ClipboardManager)
              getContext().getSystemService(Context.CLIPBOARD_SERVICE);
      ClipData clip = ClipData.newPlainText("diff_text", selectedText);
      clipboard.setPrimaryClip(clip);
      Toast.makeText(getContext(), "کپی شد", Toast.LENGTH_SHORT).show();
    }
    clearSelection();
  }

  private String getSelectedText() {
    if (!isSelecting || diffLines.isEmpty()) return "";

    StringBuilder sb = new StringBuilder();
    for (int i = selectionStartLine; i <= selectionEndLine; i++) {
      if (i >= diffLines.size()) break;

      String text = diffLines.get(i).getText();
      int startChar = (i == selectionStartLine) ? selectionStartChar : 0;
      int endChar = (i == selectionEndLine) ? selectionEndChar : text.length();

      if (startChar < endChar && startChar < text.length()) {
        sb.append(text.substring(startChar, Math.min(endChar, text.length())));
      }
      if (i < selectionEndLine) sb.append("\n");
    }
    return sb.toString();
  }

  private void dismissPopupWindow() {
    if (popupWindow != null && popupWindow.isShowing()) {
      popupWindow.dismiss();
    }
    popupWindow = null;
    popupLayout = null;
  }

  private int getBg(DiffLine l) {
    switch (l.getType()) {
      case ADDED:
        return theme.getAddedLineBg();
      case REMOVED:
        return theme.getRemovedLineBg();
      case HEADER:
        return theme.getHeaderLineBg();
      default:
        return theme.getNormalLineBg();
    }
  }

  private int getTc(DiffLine l) {
    switch (l.getType()) {
      case ADDED:
        return theme.getAddedTextColor();
      case REMOVED:
        return theme.getRemovedTextColor();
      case HEADER:
        return theme.getHeaderTextColor();
      default:
        return theme.getNormalTextColor();
    }
  }
  public void applyMaterial3(){
    theme.applyMaterial3(getContext());
  }
  private float maxSX() {
    if (cachedMaxTextWidth >= 0 && textSize * scaleFactor == cachedTextSize) {
      return Math.max(
          0, lineNumberWidth * scaleFactor + cachedMaxTextWidth + 40 * scaleFactor - getWidth());
    }
    cacheLineWidths();
    float w = 0;
    if (lineWidths != null) {
      for (float width : lineWidths) {
        if (width > w) w = width;
      }
    }
    cachedMaxTextWidth = w;
    cachedTextSize = textSize * scaleFactor;
    return Math.max(0, lineNumberWidth * scaleFactor + w + 40 * scaleFactor - getWidth());
  }

  private float maxSY() {
    return Math.max(0, diffLines.size() * lineHeight * scaleFactor - getHeight());
  }

  private void clamp() {
    float maxScrollX = maxSX();
    float maxScrollY = maxSY();
    if (scrollX < 0) scrollX = 0;
    else if (scrollX > maxScrollX) scrollX = maxScrollX;
    if (scrollY < 0) scrollY = 0;
    else if (scrollY > maxScrollY) scrollY = maxScrollY;
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    scaleDetector.onTouchEvent(event);
    velocityTracker.addMovement(event);

    switch (event.getActionMasked()) {
      case MotionEvent.ACTION_DOWN:
        downX = event.getX();
        downY = event.getY();
        ptrId = event.getPointerId(0);
        lastX = event.getX();
        lastY = event.getY();
        scroller.forceFinished(true);
        isLongPress = false;
        longPressHandler.postDelayed(longPressRunnable, 500);
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;

      case MotionEvent.ACTION_MOVE:
        if (Math.abs(event.getX() - downX) > 20 || Math.abs(event.getY() - downY) > 20) {
          longPressHandler.removeCallbacks(longPressRunnable);
        }

        if (scaleDetector.isInProgress()) return true;

        if (isLongPress && isSelecting) {
          updateSelection(event.getX(), event.getY());
          return true;
        }

        int idx = event.findPointerIndex(ptrId);
        if (idx < 0) return true;

        float dx = lastX - event.getX(idx);
        float dy = lastY - event.getY(idx);
        lastX = event.getX(idx);
        lastY = event.getY(idx);

        scrollX += dx;
        scrollY += dy;
        clamp();
        invalidate();
        return true;

      case MotionEvent.ACTION_UP:
      case MotionEvent.ACTION_CANCEL:
        longPressHandler.removeCallbacks(longPressRunnable);

        if (isLongPress && isSelecting) {
          return true;
        }

        velocityTracker.computeCurrentVelocity(1000, 8000);
        float velocityX = velocityTracker.getXVelocity(ptrId);
        float velocityY = velocityTracker.getYVelocity(ptrId);

        scroller.fling(
            (int) scrollX,
            (int) scrollY,
            (int) -velocityX,
            (int) -velocityY,
            0,
            (int) maxSX(),
            0,
            (int) maxSY());

        velocityTracker.clear();
        ptrId = -1;
        getParent().requestDisallowInterceptTouchEvent(false);
        postInvalidateOnAnimation();
        return true;
    }
    return super.onTouchEvent(event);
  }

  @Override
  public void computeScroll() {
    if (scroller.computeScrollOffset()) {
      scrollX = scroller.getCurrX();
      scrollY = scroller.getCurrY();
      clamp();
      postInvalidateOnAnimation();
    }
    super.computeScroll();
  }

  private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private float fx, fy;

    @Override
    public boolean onScaleBegin(ScaleGestureDetector d) {
      fx = d.getFocusX() + scrollX;
      fy = d.getFocusY() + scrollY;
      scroller.forceFinished(true);
      return true;
    }

    @Override
    public boolean onScale(ScaleGestureDetector d) {
      float os = scaleFactor;
      scaleFactor *= d.getScaleFactor();
      scaleFactor = Math.max(0.5f, Math.min(3f, scaleFactor));
      scrollX = fx * (scaleFactor / os) - d.getFocusX();
      scrollY = fy * (scaleFactor / os) - d.getFocusY();
      cachedMaxTextWidth = -1;
      clamp();
      invalidate();
      return true;
    }
  }
}
