package ir.ninjacoder.prograsssheet.search.interfaces;

import java.util.HashMap;
import java.util.List;

public interface SearchListener {
  void onSearchStarted();

  void onProgress(int current, int total);

  void onFileFound(HashMap<String, Object> file);

  void onSearchCompleted(List<HashMap<String, Object>> results);

  void onError(String error);
}
