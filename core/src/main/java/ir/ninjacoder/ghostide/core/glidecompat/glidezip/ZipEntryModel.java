package ir.ninjacoder.ghostide.core.glidecompat.glidezip;

public class ZipEntryModel {
  public final String zipFilePath;
  public final String entryPath;

  public ZipEntryModel(String zipFilePath, String entryPath) {
    this.zipFilePath = zipFilePath;
    this.entryPath = entryPath;
  }
}
