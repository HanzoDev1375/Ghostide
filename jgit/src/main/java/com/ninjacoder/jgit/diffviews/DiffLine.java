package com.ninjacoder.jgit.diffviews;

public class DiffLine {
  public enum LineType {
    NORMAL,
    ADDED,
    REMOVED,
    HEADER,
    CONTEXT
  }

  private String text;
  private LineType type;
  private int lineNumber;

  public DiffLine(String text, LineType type, int lineNumber) {
    this.text = text;
    this.type = type;
    this.lineNumber = lineNumber;
  }

  public String getText() {
    return text;
  }

  public LineType getType() {
    return type;
  }

  public int getLineNumber() {
    return lineNumber;
  }
}
