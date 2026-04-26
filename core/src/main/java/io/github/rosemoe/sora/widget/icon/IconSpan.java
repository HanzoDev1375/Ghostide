// IconSpan.java
package io.github.rosemoe.sora.widget.icon;

import android.graphics.drawable.Drawable;

public class IconSpan {
  private final Drawable icon;
  private final int colorFilter;
  private final int line;
  private final int column;
  private final int iconSize;
  public static final int LEFTALIGN = 0;
  public static final int RIGHTALIGN = 1;
  private final int align;
  private final int backgroundColor;
  private final boolean drawBackground;

  public IconSpan(Drawable icon, int colorFilter, int line, int column, int iconSize) {
    this(icon, colorFilter, line, column, iconSize, 0, 0, false);
  }

  public IconSpan(Drawable icon, int colorFilter, int line, int column, int iconSize, int align) {
    this(icon, colorFilter, line, column, iconSize, align, 0, false);
  }

  public IconSpan(
      Drawable icon,
      int colorFilter,
      int line,
      int column,
      int iconSize,
      int align,
      int backgroundColor,
      boolean drawBackground) {
    this.icon = icon;
    this.colorFilter = colorFilter;
    this.line = line;
    this.column = column;
    this.iconSize = iconSize;
    this.align = align;
    this.backgroundColor = backgroundColor;
    this.drawBackground = drawBackground;
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

  public boolean isLeftAligned() {
    return align == 0;
  }

  public int getBackgroundColor() {
    return backgroundColor;
  }

  public boolean shouldDrawBackground() {
    return drawBackground;
  }
}
