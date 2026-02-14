package io.github.rosemoe.sora.widget.icon;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import io.github.rosemoe.sora.event.EventManager;
import io.github.rosemoe.sora.event.IconSpanEvent;
import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.text.ContentLine;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.layout.Layout;

public class IconSpanManager {
  private static final String TAG = "IconSpanManager";
  private static final float ICON_PADDING_DP = 4;
  private static final float RIGHT_MARGIN_DP = 10;
  private static final float MIN_DISTANCE_FROM_TEXT_DP = 8;

  private final CodeEditor editor;
  private final List<IconSpan> iconSpans;
  private final List<IconSpanInfo> iconInfos;
  private final Paint iconPaint;
  private float iconPadding;
  private float rightMargin;
  private float minDistanceFromText;

  private static class IconSpanInfo {
    final IconSpan span;
    final Rect rect;

    IconSpanInfo(IconSpan span, Rect rect) {
      this.span = span;
      this.rect = rect;
    }
  }

  public IconSpanManager(CodeEditor editor) {
    this.editor = editor;
    this.iconSpans = new CopyOnWriteArrayList<>();
    this.iconInfos = new ArrayList<>();
    this.iconPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    this.iconPaint.setFilterBitmap(true);
    this.iconPaint.setDither(true);
    updateDensity();
  }

  private void updateDensity() {
    float dpUnit = editor.getDpUnit();
    iconPadding = dpUnit * ICON_PADDING_DP;
    rightMargin = dpUnit * RIGHT_MARGIN_DP;
    minDistanceFromText = dpUnit * MIN_DISTANCE_FROM_TEXT_DP;
  }

  public void addIconSpan(IconSpan iconSpan) {
    if (iconSpan == null) return;

    // حذف آیکون‌های قبلی در همان موقعیت
    removeIconSpanAt(iconSpan.getLine(), iconSpan.getColumn());

    iconSpans.add(iconSpan);
    sortIconSpans();
    clearIconInfos();
    editor.invalidate();
  }

  public void addIconSpans(List<IconSpan> newIconSpans) {
    if (newIconSpans == null || newIconSpans.isEmpty()) return;

    for (IconSpan span : newIconSpans) {
      removeIconSpanAt(span.getLine(), span.getColumn());
    }

    iconSpans.addAll(newIconSpans);
    sortIconSpans();
    clearIconInfos();
    editor.invalidate();
  }

  public void removeIconSpan(IconSpan iconSpan) {
    if (iconSpan != null) {
      iconSpans.remove(iconSpan);
      clearIconInfos();
      editor.invalidate();
    }
  }

  public void removeIconSpanAt(int line, int column) {
    boolean removed = false;
    for (int i = iconSpans.size() - 1; i >= 0; i--) {
      IconSpan span = iconSpans.get(i);
      if (span.getLine() == line && span.getColumn() == column) {
        iconSpans.remove(i);
        removed = true;
      }
    }
    if (removed) {
      clearIconInfos();
      editor.invalidate();
    }
  }

  public void removeIconSpansForLine(int line) {
    boolean removed = false;
    for (int i = iconSpans.size() - 1; i >= 0; i--) {
      if (iconSpans.get(i).getLine() == line) {
        iconSpans.remove(i);
        removed = true;
      }
    }
    if (removed) {
      clearIconInfos();
      editor.invalidate();
    }
  }

  public void clearIconSpans() {
    iconSpans.clear();
    clearIconInfos();
    editor.invalidate();
  }

  private void clearIconInfos() {
    iconInfos.clear();
  }

  private void sortIconSpans() {
    iconSpans.sort(
        (a, b) -> {
          if (a.getLine() != b.getLine()) {
            return Integer.compare(a.getLine(), b.getLine());
          }
          return Integer.compare(a.getColumn(), b.getColumn());
        });
  }

  public IconSpan getIconSpanAt(float x, float y) {
    for (IconSpanInfo info : iconInfos) {
      if (info.rect != null && info.rect.contains((int) x, (int) y)) {
        return info.span;
      }
    }
    return null;
  }

  public List<IconSpan> getIconSpans() {
    return new ArrayList<>(iconSpans);
  }

  public List<IconSpan> getIconSpansForLine(int line) {
    List<IconSpan> result = new ArrayList<>();
    for (IconSpan span : iconSpans) {
      if (span.getLine() == line) {
        result.add(span);
      }
    }
    return result;
  }

  public void drawIconSpans(Canvas canvas) {
    updateDensity();

    int firstVisibleRow = editor.getFirstVisibleRow();
    int lastVisibleRow = editor.getLastVisibleRow();

    Layout layout = editor.getLayout();
    Content text = editor.getText();
    float textRegionStart = editor.measureTextRegionOffset();
    float offsetX = editor.getOffsetX();
    float offsetY = editor.getOffsetY();

    // Clear previous icon infos
    iconInfos.clear();

    for (IconSpan span : iconSpans) {
      try {
        int line = span.getLine();
        int column = span.getColumn();

        // Check if line is valid
        if (line < 0 || line >= text.getLineCount()) continue;

        // Get row for this line
        int row = -1;
        for (int r = firstVisibleRow; r <= lastVisibleRow; r++) {
          if (layout.getLineNumberForRow(r) == line) {
            row = r;
            break;
          }
        }

        // If line is not visible, skip
        if (row < 0 || row < firstVisibleRow || row > lastVisibleRow) continue;

        ContentLine contentLine = text.getLine(line);
        int columnCount = contentLine.length();

        // Adjust column if needed
        int actualColumn = Math.min(column, columnCount);

        // Get character position
        float[] charOffset = layout.getCharLayoutOffset(line, actualColumn);
        if (charOffset == null || charOffset.length < 2) continue;

        // Calculate position
        float charX = charOffset[1] + textRegionStart - offsetX;
        float rowTop = editor.getRowTop(row) - offsetY;
        float rowHeight = editor.getRowHeight();

        // Icon size
        int iconSize = (int) (span.getIconSize() * editor.getDpUnit());
        if (iconSize <= 0) iconSize = (int) (rowHeight * 0.7f);

        float iconX;
        float iconY = rowTop + (rowHeight - iconSize) / 2f;

        // Measure character width
        float charWidth = 0;
        if (actualColumn < columnCount) {
          charWidth = editor.measureText(contentLine, actualColumn, 1, line);
        }

        if (span.isRightAligned()) {
          // Right-aligned: place to the right of character
          float desiredX = charX + charWidth + iconPadding;

          // If goes off screen, place at right margin
          if (desiredX + iconSize > editor.getWidth()) {
            iconX = editor.getWidth() - iconSize - rightMargin;
          } else {
            iconX = desiredX;
          }
        } else {
          // Left-aligned: place to the left of character
          iconX = charX - iconSize - iconPadding;

          // If goes off left edge, place to the right of character
          if (iconX < minDistanceFromText) {
            iconX = charX + charWidth + iconPadding;
          }
        }

        // Create rectangle for icon
        Rect iconRect =
            new Rect((int) iconX, (int) iconY, (int) (iconX + iconSize), (int) (iconY + iconSize));

        // Store for click detection
        iconInfos.add(new IconSpanInfo(span, iconRect));

        // Draw icon
        Drawable icon = span.getIcon();
        if (icon != null) {
          icon.setBounds(iconRect);

          if (span.getColorFilter() != 0) {
            icon.setColorFilter(span.getColorFilter(), android.graphics.PorterDuff.Mode.SRC_IN);
          } else {
            icon.clearColorFilter();
          }

          icon.draw(canvas);
        }

      } catch (Exception e) {
        Log.e(TAG, "Error drawing icon span", e);
      }
    }
  }

  public boolean handleIconClick(
      EventManager eventManager, float x, float y, MotionEvent causingEvent) {
    IconSpan clickedIcon = getIconSpanAt(x, y);
    if (clickedIcon != null) {
      try {
        eventManager.dispatchEvent(new IconSpanEvent(editor,clickedIcon,causingEvent));
        return true;
      } catch (Exception e) {
        Log.e(TAG, "Error handling icon click", e);
      }
    }
    return false;
  }

  public void onSizeChanged() {
    clearIconInfos();
  }

  public void onTextChanged() {
    clearIconInfos();
  }

  public void onZoomChanged() {
    clearIconInfos();
  }

  public void onScrollChanged() {
    clearIconInfos();
  }
}
