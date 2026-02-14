package io.github.rosemoe.sora.widget.icon;

import android.graphics.drawable.Drawable;

public class IconSpan {
  private final Drawable icon;
  private final int colorFilter;
  private final int line;
  private final int column;
  private final int iconSize;
  private final int align; // 0: left, 1: right

  public IconSpan(Drawable icon, int colorFilter, int line, int column, int iconSize) {
    this(icon, colorFilter, line, column, iconSize, 0);
  }

  public IconSpan(Drawable icon, int colorFilter, int line, int column, int iconSize, int align) {
    this.icon = icon;
    this.colorFilter = colorFilter;
    this.line = line;
    this.column = column;
    this.iconSize = iconSize;
    this.align = align;
  }

  public Drawable getIcon() {
    return icon;
  }

  public int getColorFilter() {
    return colorFilter;
  }

  public int getLine() {
    return line;
  }

  public int getColumn() {
    return column;
  }

  public int getIconSize() {
    return iconSize;
  }

  public int getAlign() {
    return align;
  }

  public boolean isRightAligned() {
    return align == 1;
  }
}