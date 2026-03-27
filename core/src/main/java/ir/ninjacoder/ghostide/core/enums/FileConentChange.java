package ir.ninjacoder.ghostide.core.enums;

import ir.ninjacoder.ghostide.core.R;

public enum FileConentChange {
  COPYING(R.drawable.ic_copy_black_24px),
  MOVEING(R.drawable.ic_move_black_24px),
  NONE(R.drawable.create);
  int value;

  public int getValue() {
    return value;
  }

  FileConentChange(int value) {
    this.value = value;
  }
}
