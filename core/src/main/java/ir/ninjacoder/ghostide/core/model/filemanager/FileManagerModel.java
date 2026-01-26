package ir.ninjacoder.ghostide.core.model.filemanager;

public class FileManagerModel {
  private String path;
  private boolean isNewItem;
  private boolean isRenameItem;

  public String getPath() {
    return this.path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public boolean isNewItem() {
    return this.isNewItem;
  }

  public void setNewItem(boolean isNewItem) {
    this.isNewItem = isNewItem;
  }

  public boolean isRenameItem() {
    return this.isRenameItem;
  }

  public void setRenameItem(boolean isRenameItem) {
    this.isRenameItem = isRenameItem;
  }

  @Override
  public String toString() {
    return "FileManagerModel[path="
        + path
        + ", isNewItem="
        + isNewItem
        + ", isRenameItem="
        + isRenameItem
        + "]";
  }
}
