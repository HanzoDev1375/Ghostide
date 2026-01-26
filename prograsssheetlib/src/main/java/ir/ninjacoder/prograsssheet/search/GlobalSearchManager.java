package ir.ninjacoder.prograsssheet.search;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import ir.ninjacoder.prograsssheet.search.interfaces.SearchListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GlobalSearchManager {

  private ExecutorService executor;
  private Handler mainHandler;
  private volatile boolean stopSearch = false;
  private int totalFiles = 0;
  private int scannedFiles = 0;

  public GlobalSearchManager() {
    this.executor = Executors.newFixedThreadPool(2);
    this.mainHandler = new Handler(Looper.getMainLooper());
  }

  public void search(
      String rootPath,
      String query,
      boolean regexMode,
      boolean caseSensitive,
      boolean searchInFiles,
      boolean searchInFolders,
      boolean searchInHidden,
      SearchListener listener) {

    stopSearch = false;
    totalFiles = 0;
    scannedFiles = 0;

    executor.execute(
        () -> {
          mainHandler.post(listener::onSearchStarted);

          try {
            Log.d("GlobalSearchManager", "Counting files in: " + rootPath);
            totalFiles = countFiles(new File(rootPath), searchInHidden);
            Log.d("GlobalSearchManager", "Total files/folders to scan: " + totalFiles);

            List<HashMap<String, Object>> results = new ArrayList<>();
            Pattern pattern = null;

            if (regexMode) {
              int flags = caseSensitive ? 0 : Pattern.CASE_INSENSITIVE;
              pattern = Pattern.compile(query, flags);
            }

            performSearch(
                new File(rootPath),
                query,
                pattern,
                regexMode,
                caseSensitive,
                searchInFiles,
                searchInFolders,
                searchInHidden,
                results,
                listener);

            if (!stopSearch) {
              mainHandler.post(
                  () -> {
                    Log.d(
                        "GlobalSearchManager",
                        "Search completed, total results: " + results.size());
                    listener.onSearchCompleted(results);
                  });
            }

          } catch (Exception e) {
            Log.e("GlobalSearchManager", "Search error: " + e.getMessage(), e);
            mainHandler.post(() -> listener.onError(e.getMessage()));
          }
        });
  }

  private int countFiles(File directory, boolean includeHidden) {
    if (stopSearch) return 0;

    int count = 0;
    File[] files = directory.listFiles();
    if (files == null) {
      Log.w("GlobalSearchManager", "Cannot list files in: " + directory.getAbsolutePath());
      return 0;
    }

    for (File file : files) {
      if (stopSearch) break;

      if (!includeHidden && file.isHidden()) continue;

      count++;
      if (file.isDirectory()) {
        count += countFiles(file, includeHidden);
      }
    }

    return count;
  }

  private void performSearch(
      File directory,
      String query,
      Pattern pattern,
      boolean regexMode,
      boolean caseSensitive,
      boolean searchInFiles,
      boolean searchInFolders,
      boolean searchInHidden,
      List<HashMap<String, Object>> results,
      SearchListener listener) {

    if (stopSearch) return;

    File[] files = directory.listFiles();
    if (files == null) {
      Log.w("GlobalSearchManager", "Cannot list files in: " + directory.getAbsolutePath());
      return;
    }

    Log.d(
        "GlobalSearchManager",
        "Searching in: " + directory.getAbsolutePath() + " (" + files.length + " items)");

    for (File file : files) {
      if (stopSearch) break;

      scannedFiles++;

      if (scannedFiles % 100 == 0) {
        mainHandler.post(() -> listener.onProgress(scannedFiles, totalFiles));
      }

      if (!searchInHidden && file.isHidden()) {
        continue;
      }

      String fileName = file.getName();
      String filePath = file.getAbsolutePath();
      boolean isMatch = false;

      if (regexMode && pattern != null) {
        Matcher matcher = pattern.matcher(fileName);
        isMatch = matcher.find();
      } else {
        if (caseSensitive) {
          isMatch = fileName.contains(query);
        } else {
          isMatch = fileName.toLowerCase().contains(query.toLowerCase());
        }
      }

      if (isMatch) {
        boolean isDirectory = file.isDirectory();

        if ((isDirectory && searchInFolders) || (!isDirectory && searchInFiles)) {
          HashMap<String, Object> result = new HashMap<>();
          result.put("path", filePath);
          result.put("name", fileName);
          result.put("isDirectory", isDirectory);
          result.put("size", file.length());
          result.put("lastModified", file.lastModified());
          result.put("parent", file.getParent());

          results.add(result);
          Log.d("GlobalSearchManager", "MATCH: " + filePath + " (dir: " + isDirectory + ")");
          mainHandler.post(() -> listener.onFileFound(result));
        }
      }

      if (file.isDirectory()) {
        performSearch(
            file,
            query,
            pattern,
            regexMode,
            caseSensitive,
            searchInFiles,
            searchInFolders,
            searchInHidden,
            results,
            listener);
      }
    }
  }

  public void stop() {
    stopSearch = true;
  }

  public void destroy() {
    stop();
    if (executor != null) {
      executor.shutdownNow();
    }
  }
}
