package ir.ninjacoder.prograsssheet.enums;

public enum ModBackground {
  TOP(0),
  MIDDLE(1),
  BOTTOM(2),
  NONE(3);

  int value;

  ModBackground(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
