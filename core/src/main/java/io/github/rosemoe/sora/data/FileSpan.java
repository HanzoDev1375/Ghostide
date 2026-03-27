package io.github.rosemoe.sora.data;

public class FileSpan {
  private final String path;
  private final int line;
  private final int startColumn;
  private final int endColumn;
  private int color;
  private boolean underline;

  public FileSpan(String path, int line, int startColumn, int endColumn) {
    this.path = path;
    this.line = line;
    this.startColumn = startColumn;
    this.endColumn = endColumn;
  }

  public String getPath() {
    return this.path;
  }

  public int getLine() {
    return this.line;
  }

  public int getStartColumn() {
    return this.startColumn;
  }

  public int getEndColumn() {
    return this.endColumn;
  }

  public int getColor() {
    return this.color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public boolean isUnderline() {
    return underline;
  }

  public void setUnderline(boolean underline) {
    this.underline = underline;
  }
}
