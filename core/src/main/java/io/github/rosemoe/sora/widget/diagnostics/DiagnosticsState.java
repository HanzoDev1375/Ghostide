package io.github.rosemoe.sora.diagnostics;

import android.graphics.Color;

public enum DiagnosticsState {
  ERROR(0, Color.RED),
  WARNING(1, Color.YELLOW),
  TYPO(2, Color.GREEN),
  DEPRECATED(3, Color.parseColor("#FF333333")),
  UNUSED(4, Color.parseColor("#FF595959")),
  NONE(5);

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

  public void setColor(int color) {
    this.color = color;
  }
}
