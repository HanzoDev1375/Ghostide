package io.github.rosemoe.sora.data;

public class GhostText {
  public int line;
  public int column;
  public String text;
  public boolean visible;

  public GhostText(int line, int column, String text) {
    this.line = line;
    this.column = column;
    this.text = text;
    this.visible = true;
  }
}
