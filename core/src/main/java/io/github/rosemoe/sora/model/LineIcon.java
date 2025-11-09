package io.github.rosemoe.sora.model;

/** Line icon line number code by ninja coder */
public class LineIcon {
  private int iconRes;
  private int lineNumber;

  public LineIcon(int iconRes, int lineNumber) {
    this.iconRes = iconRes;
    this.lineNumber = lineNumber;
  }

  public int getIconRes() {
    return this.iconRes;
  }

  public int getLineNumber() {
    return this.lineNumber;
  }
}
