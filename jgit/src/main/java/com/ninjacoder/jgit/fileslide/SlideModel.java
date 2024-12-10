package com.ninjacoder.jgit.fileslide;

import java.io.File;

public class SlideModel {

  private File file;
  private int icon;

  public SlideModel(File file, int icon) {
    this.file = file;
    this.icon = icon;
  }

  public File getFile() {
    return this.file;
  }

  public int getIcon() {
    return this.icon;
  }
}
