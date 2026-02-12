package io.github.rosemoe.sora.diagnostics;

import androidx.core.graphics.ColorUtils;

public class Diagnostic {
  int start, end;
  String text;
  DiagnosticsState state;
  int color; // custom color

  public Diagnostic(int start, int end, String text, DiagnosticsState state, int color) {
    this.start = start;
    this.end = end;
    this.text = text;
    this.state = state;
    this.color = color;
  }

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

  public int getColor() {
    return darkenColor(this.color, 0.3f);
  }

  int darkenColor(int color, float darkenFactor) {
    darkenFactor = Math.max(0, Math.min(1, darkenFactor));
    float[] hsl = new float[3];
    ColorUtils.colorToHSL(color, hsl);
    hsl[2] = hsl[2] * (1 - darkenFactor);
    return ColorUtils.HSLToColor(hsl);
  }
}
