package ir.ninjacoder.prograsssheet.enums;

public enum StateMod {
  PROGRASSV(0),
  PROGRASSH(1);
  int modstate;

  StateMod(int modstate) {
    this.modstate = modstate;
  }

  public int getModstate() {
    return this.modstate;
  }
}
