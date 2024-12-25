package ir.ninjacoder.ghostide.filehelper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileNio {

  public static void makeFile(String filePath) throws IOException {
    Files.createFile(Paths.get(filePath));
  }

  public static void makeFolder(String folderPath) throws IOException {
    Files.createDirectories(Paths.get(folderPath));
  }

  public static void removeFile(String filePath) throws IOException {
    Files.delete(Paths.get(filePath));
  }

  public static void copyFileOrFolder(String source, String destination) throws IOException {

    Path sourcePath = Paths.get(source);
    Path destinationPath = Paths.get(destination);
    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
  }

  public static void moveFileOrFolder(String source, String destination) throws IOException {
    Path sourcePath = Paths.get(source);
    Path destinationPath = Paths.get(destination);
    Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
  }
}
