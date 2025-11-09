package io.github.rosemoe.sora.model;

public class Inlay {
  public final int line;
  public final int column;
  public final String text;
  public final int color;

  public Inlay(int line, int column, String text, int color) {
    this.line = line;
    this.column = column;
    this.text = text;
    this.color = color;
  }
}
