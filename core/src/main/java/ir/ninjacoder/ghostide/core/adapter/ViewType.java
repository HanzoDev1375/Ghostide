package ir.ninjacoder.ghostide.core.adapter;

public enum ViewType {
  ROW(0),
  GRID(1),
  MOERNGRIDE(2);

  private int value;

  ViewType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
