package ir.ninjacoder.ghostide.enums;

public enum Mode {
  CXX(0),
  CLANG(1),
  NOMOD(2),
  WEB(3);

  private int value;

  Mode(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
