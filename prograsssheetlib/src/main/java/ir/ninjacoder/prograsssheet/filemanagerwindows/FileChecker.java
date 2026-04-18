package ir.ninjacoder.prograsssheet.filemanagerwindows;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FileChecker {
  private final ExecutorService executorService;

  public FileChecker() {
    this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
  }

  Future<Boolean> hasFileAsync(String directoryPath, String type) {
    if (directoryPath == null || directoryPath.trim().isEmpty()) {
      return CompletableFuture.completedFuture(false);
    }
    File directory = new File(directoryPath);
    if (!directory.exists() || !directory.isDirectory()) {
      return CompletableFuture.completedFuture(false);
    }

    return executorService.submit(
        new Callable<Boolean>() {

          @Override
          public Boolean call() {

            File[] files = directory.listFiles();
            if (files != null) {
              for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(type)) {
                  return true;
                }
              }
            }
            return false;
          }
        });
  }

  public void shutdown() {
    executorService.shutdown();
  }
  
  @Override
  protected void finalize() throws Throwable {
    super.finalize();
    shutdown();
  }
  

  public boolean hasFileBlocking(String directoryPath, String type) {
    try {
      Future<Boolean> future = hasFileAsync(directoryPath, type);
      return future.get();
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
