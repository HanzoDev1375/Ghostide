package ir.ninjacoder.prograsssheet.fileinfo;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

public class FileInfoModel {
  private final String fileName;
  private final String fileHint;

  public FileInfoModel(String fileName, String fileHint) {
    this.fileName = fileName;
    this.fileHint = fileHint;
    
    
  }

  public String getFileName() {
    return this.fileName;
  }

  public String getFileHint() {
    return this.fileHint;
  }
  
}
