package ir.ninjacoder.prograsssheet.filemanagerwindows;

import androidx.annotation.Nullable;

public class FileModel {
  @Nullable private String path;
  @Nullable private int resicon;

  public FileModel(String path) {
    this.path = path;
  }

  public String getPath() {
    return this.path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public int getResicon() {
    return this.resicon;
  }

  public void setResicon(int resicon) {
    this.resicon = resicon;
  }
}
