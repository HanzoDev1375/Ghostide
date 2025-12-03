package io.github.rosemoe.sora.model;

public class Inlay {
  public int line;
  public int column;
  public String text;
  public int color;
  public int background;

  public Inlay(int line, int column, String text, int color, int background) {
    this.line = line;
    this.column = column;
    this.text = text;
    this.color = color;
    this.background = background;
    
  }

  public int getLine() {
    return this.line;
  }

  public int getColumn() {
    return this.column;
  }

  public String getText() {
    return this.text;
  }

  public int getColor() {
    return this.color;
  }

  public int getBackground() {
    return this.background;
  }
}
