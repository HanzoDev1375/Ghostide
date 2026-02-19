package io.github.rosemoe.sora.data;

import java.util.regex.Pattern;

public class RegexSpan {
  private final String regex;
  private final Pattern pattern;
  private final int line;
  private final int startColumn;
  private final int endColumn;
  private int color;
  private boolean underline;
  private boolean bold;
  private boolean italic;
  private String matchedText;

  public RegexSpan(String regex, int line, int startColumn, int endColumn) {
    this.regex = regex;
    this.pattern = Pattern.compile(regex);
    this.line = line;
    this.startColumn = startColumn;
    this.endColumn = endColumn;
    this.color = color;
    this.underline = true;
  }

  public RegexSpan(String regex, int line, int startColumn, int endColumn, String matchedText) {
    this(regex, line, startColumn, endColumn);
    this.matchedText = matchedText;
  }

  public String getRegex() {
    return regex;
  }

  public Pattern getPattern() {
    return pattern;
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

  public boolean isBold() {
    return bold;
  }

  public void setBold(boolean bold) {
    this.bold = bold;
  }

  public boolean isItalic() {
    return italic;
  }

  public void setItalic(boolean italic) {
    this.italic = italic;
  }

  public String getMatchedText() {
    return matchedText;
  }

  public void setMatchedText(String matchedText) {
    this.matchedText = matchedText;
  }

  public boolean contains(int column) {
    return column >= startColumn && column < endColumn;
  }

  @Override
  public String toString() {
    return "RegexSpan{"
        + "regex='"
        + regex
        + '\''
        + ", line="
        + line
        + ", startColumn="
        + startColumn
        + ", endColumn="
        + endColumn
        + ", matchedText='"
        + matchedText
        + '\''
        + '}';
  }
}
