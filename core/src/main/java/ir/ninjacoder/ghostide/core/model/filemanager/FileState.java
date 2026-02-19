package ir.ninjacoder.ghostide.core.model.filemanager;

import android.graphics.Color;

public enum FileState {
  NORMAL(0),
  RENAME(1, Color.parseColor("#FF00FF8C")),
  ADD(2, Color.parseColor("#4CAF50")),
  SELECTBELITEM(3, Color.parseColor("#FFFF5900")),
  SEARCH(4, Color.parseColor("#FFBF00")),
  ARCHIVES(5,Color.parseColor("#FFE60B")),
  DELETED(6, 0);
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