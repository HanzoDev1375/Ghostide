package io.github.rosemoe.sora.diagnostics;

import android.graphics.Color;
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

  private int darkenColor(int color, float factor) {
    int alpha = Color.alpha(color);
    int red = Math.max(0, (int) (Color.red(color) * (1 - factor)));
    int green = Math.max(0, (int) (Color.green(color) * (1 - factor)));
    int blue = Math.max(0, (int) (Color.blue(color) * (1 - factor)));
    return Color.argb(alpha, red, green, blue);
  }
}
