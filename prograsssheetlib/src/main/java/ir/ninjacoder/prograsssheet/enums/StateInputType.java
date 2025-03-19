package ir.ninjacoder.prograsssheet.enums;

public enum StateInputType {
  TEXT(0),
  NUMBER(1),
  PASSWORD(2),
  NUMBERSIGNED(3),
  NUMBERDECIMAL(4);
  int type;

  public int getType() {
    return type;
  }

  StateInputType(int type) {
    this.type = type;
  }
}
