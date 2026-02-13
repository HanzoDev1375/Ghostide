package io.github.rosemoe.sora.model;

public enum InlayAlign {
  LEFT(0),
  RIGHT(1), // not impl
  TOP(2); // not impl
  int value;

  InlayAlign(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
