package ir.ninjacoder.ghostide.core.model.filemanager;

import android.graphics.Color;

public enum FileState {
  NORMAL(0),
  RENAME(1, Color.parseColor("#5cbff1")),
  ADD(2, Color.parseColor("#4CAF50")),
  SELECTBELITEM(3, Color.parseColor("#ff8ff1")),
  SEARCH(4, Color.parseColor("#ffff11"));
  int id;
  int color;

  FileState(int id) {
    this.id = id;
  }

  FileState(int id, int color) {
    this.id = id;
    this.color = color;
  }

  public int getId() {
    return this.id;
  }

  public int getColor() {
    return this.color;
  }
}
