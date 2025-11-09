package lsp4custom.com.ninjacoder.customhtmllsp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import io.github.rosemoe.sora.data.CompletionItem;

// private class
/** this class in private dont edit and call */

/**
 * // وقتی کاربر در حال تایپ مسیر است String currentFilePath = "/path/to/current/file"; String
 * userTypedPrefix = "src/ma";
 *
 * <p>List<CompletionItem> suggestions = PathCompleter.getPathCompletions(currentFilePath,
 * userTypedPrefix); or using addall
 */
class PathCompleter {
  private static Map<String, File[]> cache = new HashMap<>();

  protected static List<CompletionItem> getPathCompletions(String currentPath, String prefix) {
    List<CompletionItem> completions = new ArrayList<>();

    try {
      File directory = resolveDirectory(currentPath, prefix);
      if (directory == null || !directory.exists()) {
        return completions;
      }

      // Clear cache to get fresh list of files
      cache.remove(directory.getAbsolutePath());
      File[] allFiles =
          cache.computeIfAbsent(
              directory.getAbsolutePath(),
              k -> Optional.ofNullable(directory.listFiles()).orElse(new File[0]));

      String finalPrefix = extractFinalPrefix(prefix);
      String basePath = buildBasePath(prefix);

      for (File file : allFiles) {
        if (shouldIncludeFile(file, finalPrefix, prefix)) {
          CompletionItem item = new CompletionItem();
          item.label = file.getName();
          item.jdir = file.getAbsolutePath();
          item.commit = basePath + file.getName() + (file.isDirectory() ? "/" : "");
          item.desc = file.isFile() ? "File" : "Folder";
		  item.cursorOffset(item.commit.length() - 1);
          completions.add(item);
        }
      }
      if (finalPrefix != null && !finalPrefix.isEmpty()) {
        completions =
            completions.stream()
                .filter(it -> it.label.startsWith(finalPrefix))
                .collect(Collectors.toList());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return completions;
  }

  private static boolean shouldIncludeFile(File file, String finalPrefix, String fullPrefix) {
    // Handle cases where prefix ends with / (looking for contents of a directory)
    if (fullPrefix.endsWith("/")) {
      return true; // Show all contents if user typed a directory path ending with /
    }
    return file.getName().toLowerCase().startsWith(finalPrefix.toLowerCase());
  }

  private static String buildBasePath(String prefix) {
    if (prefix.isEmpty()) {
      return "";
    }
    if (prefix.endsWith("/")) {
      return prefix;
    }
    if (prefix.contains("/")) {
      return prefix.substring(0, prefix.lastIndexOf('/') + 1);
    }
    return prefix.startsWith("./") ? "./" : prefix.startsWith("../") ? "../" : "";
  }

  private static File resolveDirectory(String currentPath, String prefix) {
    if (prefix.startsWith("../")) {
      int parentLevel = countParentLevels(prefix);
      String resolvedPath = navigateUp(currentPath, parentLevel);
      return new File(resolvedPath);
    } else if (prefix.contains("/")) {
      String pathPart = prefix.substring(0, prefix.lastIndexOf('/'));
      return new File(currentPath + File.separator + pathPart);
    }
    return new File(currentPath);
  }

  private static int countParentLevels(String path) {
    return (int) path.chars().filter(ch -> ch == '.').count() / 2;
  }

  private static String navigateUp(String path, int levels) {
    for (int i = 0; i < levels; i++) {
      path = path.substring(0, path.lastIndexOf(File.separator));
    }
    return path;
  }

  private static String extractFinalPrefix(String prefix) {
    if (prefix.contains("/")) {
      return prefix.substring(prefix.lastIndexOf('/') + 1);
    }
    return prefix;
  }
}
