package io.github.rosemoe.sora.diagnostics;

public class Diagnostic {
  int start, end;
  String text;
  DiagnosticsState state;

  public Diagnostic(int start, int end, String text, DiagnosticsState state) {
    this.start = start;
    this.end = end;
    this.text = text;
    this.state = state;
  }

  public int getStart() {
    return this.start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return this.end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public DiagnosticsState getState() {
    return this.state;
  }

  public void setState(DiagnosticsState state) {
    this.state = state;
  }
}
