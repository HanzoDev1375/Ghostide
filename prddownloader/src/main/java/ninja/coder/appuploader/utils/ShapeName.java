package ninja.coder.appuploader.utils;

public enum ShapeName {
  LINENORMAL(0),
  LINEROUND(1);

  int value;

  ShapeName(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
