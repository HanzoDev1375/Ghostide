package io.github.rosemoe.sora.data;

public class LinkSpan {
  private final String url;
  private final int line;
  private final int startColumn;
  private final int endColumn;
  private int color;
  private boolean underline;

  public LinkSpan(String url, int line, int startColumn, int endColumn) {
    this.url = url;
    this.line = line;
    this.startColumn = startColumn;
    this.endColumn = endColumn;
    this.color = color;
    this.underline = true;
  }

  public String getUrl() {
    return url;
  }

  public int getLine() {
    return line;
  }

  public int getStartColumn() {
    return startColumn;
  }

  public int getEndColumn() {
    return endColumn;
  }

  public int getColor() {
    return color;
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
