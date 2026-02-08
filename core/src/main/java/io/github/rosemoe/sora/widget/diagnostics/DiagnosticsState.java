package io.github.rosemoe.sora.diagnostics;

import android.graphics.Color;

public enum DiagnosticsState {
  ERROR(0, Color.RED),
  WARNING(1, Color.YELLOW),
  TYPO(2, Color.GREEN),
  DEPRECATED(3, Color.parseColor("#323232")),
  NONE(4);

  int value;
  int color;

  DiagnosticsState(int color) {
    this.color = color;
  }

  DiagnosticsState(int value, int color) {
    this.value = value;
    this.color = color;
  }

  public int getValue() {
    return this.value;
  }

  public int getColor() {
    return this.color;
  }
}
