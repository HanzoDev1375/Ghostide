package ir.ninjacoder.ghostide.core.model.filemanager;

public class FileManagerModel {
  private String filePath;
  private FileState filestate = FileState.NORMAL;

  public FileManagerModel(String filePath, FileState filestate) {
    this.filePath = filePath;
    this.filestate = filestate;
  }

  public String getFilePath() {
    return this.filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public FileState getFilestate() {
    return this.filestate;
  }

  public void setFilestate(FileState filestate) {
    this.filestate = filestate;
  }
}
