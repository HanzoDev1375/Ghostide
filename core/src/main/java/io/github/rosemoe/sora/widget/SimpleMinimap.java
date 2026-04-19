package io.github.rosemoe.sora.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.MotionEvent;

import io.github.rosemoe.sora.event.EditorTouchEvents;
import io.github.rosemoe.sora.event.ScrollEvent;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.event.SelectionChangeEvent;
import java.util.List;

import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.graphics.BubbleHelper;
import io.github.rosemoe.sora.widget.layout.Row;
import io.github.rosemoe.sora.widget.layout.RowIterator;

public class SimpleMinimap {

  private static final int CHAR_HEIGHT_PX = 10;
  private static final float WIDTH_RATIO = 0.12f;
  private static final int CONTENT_ALPHA = 180;

  private final CodeEditor editor;
  private final Paint bgPaint = new Paint();
  private final Paint viewPaint = new Paint();
  private final Paint borderPaint = new Paint();
  private final Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private final RectF rect = new RectF();
  private final RectF viewRect = new RectF();
  private final Path bubblePath = new Path();
  private final RectF bubbleRect = new RectF();

  private Bitmap bitmap;
  private int[] pixelBuffer;
  private int bitmapWidth = -1;
  private int bitmapHeight = -1;
  private int lastLineCount = -1;
  private boolean dirty = true;
  private boolean enabled = false;
  private float dp;
  private boolean showingLineInfo = false;
  private int currentLineNumber = 0;
  private float infoX = 0, infoY = 0;
  private long hideInfoTime = 0;
  private static final long INFO_DURATION = 800; // 800 میلی‌ثانیه

  private CharRenderer charRenderer;

  public SimpleMinimap(CodeEditor editor) {
    this.editor = editor;
    this.dp = editor.getDpUnit();
    this.charRenderer = new CharRenderer(CHAR_HEIGHT_PX);
    initPaints();
    setupListeners();
  }

  private void initPaints() {
    bgPaint.setColor(editor.getColorScheme().getColor(EditorColorScheme.WHOLE_BACKGROUND));
    bgPaint.setStyle(Paint.Style.FILL);
    viewPaint.setColor(Color.parseColor("#40FFFFFF"));
    viewPaint.setStyle(Paint.Style.FILL);
    borderPaint.setColor(Color.parseColor("#80FFFFFF"));
    borderPaint.setStyle(Paint.Style.STROKE);
    borderPaint.setStrokeWidth(dp * 1.5f);
    textPaint.setTextSize(dp * 12);
    textPaint.setColor(Color.WHITE);
    textPaint.setTextAlign(Paint.Align.CENTER);
    textPaint.setFakeBoldText(true);
  }

  private void setupListeners() {
    editor.subscribeEvent(
        ScrollEvent.class,
        (event, unsubscribe) -> {
          if (enabled) {
            dirty = true;
            editor.postInvalidate();
          }
        });
    editor.subscribeEvent(
        ContentChangeEvent.class,
        (event, unsubscribe) -> {
          if (enabled) {
            dirty = true;
            editor.postInvalidate();
          }
        });
    editor.subscribeEvent(
        SelectionChangeEvent.class,
        (event, unsubscribe) -> {
          if (enabled) {
            dirty = true;
            editor.postInvalidate();
          }
        });
    editor.subscribeEvent(
        EditorTouchEvents.class,
        (e, un) -> {
          var event = e.getEvent();
          float x = event.getX();
          float y = event.getY();

          if (event.getAction() == MotionEvent.ACTION_DOWN && this.contains(x, y)) {
            this.handleTouch(x, y);
          }
        });
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
    if (enabled) {
      dirty = true;
      editor.invalidate();
    }
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void update() {
    if (enabled) {
      dirty = true;
      editor.invalidate();
    }
  }

  public boolean contains(float x, float y) {
    return enabled && rect.contains(x, y);
  }

  public void handleTouch(float x, float y) {
    if (!enabled) return;

    // محاسبه لاین بر اساس موقعیت کلیک
    float totalHeight = editor.getLayout().getLayoutHeight();
    if (totalHeight <= 0) return;

    float percent = (y - rect.top) / rect.height();
    percent = Math.max(0f, Math.min(1f, percent));

    int line = (int) (percent * editor.getLineCount());
    line = Math.max(0, Math.min(editor.getLineCount() - 1, line));

    // نمایش اطلاعات
    currentLineNumber = line + 1; // +1 چون خطوط از 1 شروع میشن
    infoX = x;
    infoY = y - dp * 20;
    showingLineInfo = true;
    hideInfoTime = System.currentTimeMillis() + INFO_DURATION;
    // editor.jumpToLine(line);
    editor.postInvalidate();
    editor.postDelayed(
        () -> {
          if (showingLineInfo && System.currentTimeMillis() >= hideInfoTime) {
            showingLineInfo = false;
            editor.invalidate();
          }
        },
        INFO_DURATION);
  }

  public void draw(Canvas canvas, int rightEdge) {
    if (!enabled) return;
    if (editor.getText() == null || editor.getText().getLineCount() <= 0) return;

    updateBitmapIfNeeded();

    float margin = dp * 8;
    float miniWidth = editor.getWidth() * WIDTH_RATIO;
    float left = rightEdge - miniWidth - margin;
    float top = margin;
    rect.set(left, top, left + miniWidth, editor.getHeight() - margin);

    canvas.drawRoundRect(rect, dp * 6, dp * 6, bgPaint);
    canvas.drawRoundRect(rect, dp * 6, dp * 6, borderPaint);

    if (bitmap != null && !bitmap.isRecycled()) {
      canvas.save();
      canvas.clipRect(rect);
      canvas.drawBitmap(bitmap, null, rect, null);
      drawViewport(canvas);
      canvas.restore();
    }
    if (showingLineInfo) {
      drawLineInfoBubble(canvas);
    }
  }

  private void drawLineInfoBubble(Canvas canvas) {
    String text = "Line " + currentLineNumber;
    float textWidth = textPaint.measureText(text);
    float padding = dp * 8;
    float bubbleWidth = textWidth + padding * 2;
    float bubbleHeight = dp * 24;

    bubbleRect.set(infoX - bubbleWidth / 2, infoY - bubbleHeight, infoX + bubbleWidth / 2, infoY);

    // اطمینان از اینکه داخل صفحه باشه
    if (bubbleRect.left < 0) {
      bubbleRect.offset(-bubbleRect.left, 0);
    }
    if (bubbleRect.right > editor.getWidth()) {
      bubbleRect.offset(editor.getWidth() - bubbleRect.right, 0);
    }
    if (bubbleRect.top < 0) {
      bubbleRect.offset(0, -bubbleRect.top);
    }

    // رسم بالون با استفاده از BubbleHelper
    BubbleHelper.buildBubblePath(bubblePath, bubbleRect);

    Paint bubblePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    bubblePaint.setColor(0xCC333333);
    bubblePaint.setStyle(Paint.Style.FILL);
    canvas.drawPath(bubblePath, bubblePaint);

    // حاشیه بالون
    Paint borderPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    borderPaint2.setColor(0xFFFFFFFF);
    borderPaint2.setStyle(Paint.Style.STROKE);
    borderPaint2.setStrokeWidth(dp);
    canvas.drawPath(bubblePath, borderPaint2);

    // رسم متن
    float textX = bubbleRect.centerX();
    float textY = bubbleRect.centerY() + (textPaint.getTextSize() / 3);
    canvas.drawText(text, textX, textY, textPaint);
  }

  private void updateBitmapIfNeeded() {
    charRenderer.updateTypeface(editor.getTypefaceText());

    int lineCount = editor.getLineCount();
    int requiredWidth = computeWidth();
    int requiredHeight = editor.getHeight();

    if (!dirty
        && lastLineCount == lineCount
        && bitmapWidth == requiredWidth
        && bitmapHeight == requiredHeight) {
      return;
    }

    ensureBitmap(requiredWidth, requiredHeight);
    bitmapWidth = requiredWidth;
    bitmapHeight = requiredHeight;

    if (pixelBuffer == null || pixelBuffer.length != requiredWidth * requiredHeight) {
      pixelBuffer = new int[requiredWidth * requiredHeight];
    }

    java.util.Arrays.fill(pixelBuffer, Color.TRANSPARENT);
    renderAllLines(lineCount);

    if (bitmap == null || bitmap.isRecycled()) {
      bitmap = Bitmap.createBitmap(requiredWidth, requiredHeight, Bitmap.Config.ARGB_8888);
    }
    bitmap.setPixels(pixelBuffer, 0, requiredWidth, 0, 0, requiredWidth, requiredHeight);

    lastLineCount = lineCount;
    dirty = false;
  }

  private int computeWidth() {
    int ratioWidth = (int) (editor.getWidth() * WIDTH_RATIO);
    int minWidth = (int) (dp * 15);
    int maxWidth = (int) (dp * 120);
    return Math.max(minWidth, Math.min(maxWidth, ratioWidth));
  }

  private void ensureBitmap(int width, int height) {
    if (bitmap != null && bitmap.getWidth() == width && bitmap.getHeight() == height) {
      return;
    }
    if (bitmap != null && !bitmap.isRecycled()) {
      bitmap.recycle();
    }
    bitmap = Bitmap.createBitmap(Math.max(1, width), Math.max(1, height), Bitmap.Config.ARGB_8888);
  }

  private void renderAllLines(int lineCount) {
    for (int line = 0; line < lineCount; line++) {
      int top = line * CHAR_HEIGHT_PX;
      if (top >= bitmapHeight) break;
      renderLine(line, top);
    }
  }

  private void renderLine(int line, int top) {
    String lineText = editor.getText().getLineString(line);
    if (lineText == null || lineText.isEmpty()) return;

    List<Span> spans = editor.getSpansForLine(line);
    int x = 0;
    int spanIndex = 0;
    int col = 0;

    while (col < lineText.length() && x < bitmapWidth) {
      while (spanIndex + 1 < spans.size() && spans.get(spanIndex + 1).column <= col) {
        spanIndex++;
      }

      int colorId =
          spans.isEmpty()
              ? EditorColorScheme.TEXT_NORMAL
              : spans.get(spanIndex).getForegroundColorId();
      if (colorId == 0) colorId = EditorColorScheme.TEXT_NORMAL;

      int color = applyAlpha(editor.getColorScheme().getColor(colorId), CONTENT_ALPHA);
      char ch = lineText.charAt(col);
      x += renderChar(ch, x, top, color);
      col++;
    }
  }

  private int renderChar(char ch, int x, int top, int color) {
    if (ch == ' ') {
      return charRenderer.getCharWidth(' ');
    }
    if (ch == '\t') {
      int tabW = editor.getTabWidth() * charRenderer.getCharWidth(' ');
      int remainder = x % tabW;
      return remainder == 0 ? tabW : tabW - remainder;
    }

    char renderChar = charRenderer.isVisibleAscii(ch) ? ch : charRenderer.mapToVisible(ch);
    int width = charRenderer.getCharWidth(renderChar);
    charRenderer.blit(pixelBuffer, bitmapWidth, bitmapHeight, renderChar, x, top, color);
    return width;
  }

  private void drawViewport(Canvas canvas) {
    if (bitmap == null || bitmap.getHeight() <= 0) return;

    float height = editor.getHeight();
    float totalHeight = editor.getLayout().getLayoutHeight();
    if (totalHeight <= 0) return;

    float viewHeight = (height / totalHeight) * rect.height();
    float viewTop = rect.top + ((float) editor.getOffsetY() / totalHeight) * rect.height();

    viewTop = Math.max(rect.top, Math.min(rect.bottom - viewHeight, viewTop));

    viewRect.set(rect.left, viewTop, rect.right, viewTop + viewHeight);
    canvas.drawRoundRect(viewRect, dp * 4, dp * 4, viewPaint);
    canvas.drawRoundRect(viewRect, dp * 4, dp * 4, borderPaint);
  }

  private int applyAlpha(int color, int alpha) {
    return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
  }

  // ==================== CharRenderer ====================

  private static class CharRenderer {
    private final int charHeight;
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final int[] glyphWidths = new int[95];
    private Bitmap[] glyphBitmaps = new Bitmap[95];

    CharRenderer(int height) {
      this.charHeight = height;
      paint.setTextSize(height);
      paint.setColor(Color.WHITE);
    }

    void updateTypeface(Typeface tf) {
      if (tf != paint.getTypeface()) {
        paint.setTypeface(tf);
        for (int i = 0; i < glyphBitmaps.length; i++) {
          if (glyphBitmaps[i] != null) {
            glyphBitmaps[i].recycle();
            glyphBitmaps[i] = null;
          }
        }
      }
    }

    boolean isVisibleAscii(char ch) {
      return ch >= 33 && ch <= 126;
    }

    char mapToVisible(char ch) {
      return isVisibleAscii(ch) ? ch : (char) (33 + (ch % 94));
    }

    int getCharWidth(char ch) {
      int idx = ch - 33;
      if (idx < 0 || idx >= glyphWidths.length) return charHeight / 2;
      if (glyphWidths[idx] == 0) {
        glyphWidths[idx] = Math.max(1, (int) paint.measureText(String.valueOf(ch)));
      }
      return glyphWidths[idx];
    }

    void blit(int[] pixels, int stride, int bufferHeight, char ch, int left, int top, int color) {
      int idx = ch - 33;
      if (idx < 0 || idx >= glyphBitmaps.length) return;

      Bitmap glyph = glyphBitmaps[idx];
      if (glyph == null) {
        glyph = renderGlyph(ch);
        glyphBitmaps[idx] = glyph;
      }
      if (glyph == null) return;

      int width = glyph.getWidth();
      int height = glyph.getHeight();
      int startX = Math.max(0, left);
      int endX = Math.min(stride, left + width);
      int startY = Math.max(0, top);
      int endY = Math.min(bufferHeight, top + height);

      for (int y = startY; y < endY; y++) {
        int dstRow = y * stride;
        for (int x = startX; x < endX; x++) {
          int pixel = glyph.getPixel(x - left, y - top);
          int alpha = (pixel >> 24) & 0xFF;
          if (alpha > 0) {
            pixels[dstRow + x] = mergeColor(color, alpha);
          }
        }
      }
    }

    private Bitmap renderGlyph(char ch) {
      int width = getCharWidth(ch);
      if (width <= 0 || charHeight <= 0) return null;
      Bitmap bmp = Bitmap.createBitmap(width, charHeight, Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bmp);
      canvas.drawColor(Color.TRANSPARENT, android.graphics.PorterDuff.Mode.CLEAR);
      canvas.drawText(String.valueOf(ch), 0, charHeight - paint.descent(), paint);
      return bmp;
    }

    private int mergeColor(int color, int alpha) {
      return Color.argb(
          (alpha * Color.alpha(color)) / 255,
          Color.red(color),
          Color.green(color),
          Color.blue(color));
    }
  }
}
