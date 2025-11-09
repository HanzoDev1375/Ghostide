package io.github.rosemoe.sora.langs.sql;

public class Comment implements Comparable<Comment> {
  protected boolean newLine;
  protected boolean extraNewLine;
  protected int absolutePosition;
  protected int relativePosition;
  protected String text;

  public Comment(int absolutePosition, String text) {
    this.absolutePosition = absolutePosition;
    this.text = text;
  }

  @Override
  public int compareTo(Comment o) {
    return Integer.compare(absolutePosition, o.absolutePosition);
  }

  @Override
  public String toString() {
    return text;
  }
}
