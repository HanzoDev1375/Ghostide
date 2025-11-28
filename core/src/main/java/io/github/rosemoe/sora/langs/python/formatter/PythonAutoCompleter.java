package io.github.rosemoe.sora.langs.python.formatter;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.rosemoe.sora.data.CompletionItem;

public class PythonAutoCompleter {

  private static final String TAG = "PythonAutoCompleter";
  private static final String CACHE_FILE = "python_completion_cache.json";
  private static final long CACHE_DURATION = 300000;
  private static final int MAX_CACHE_ENTRIES = 500;

  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private final Map<String, CacheEntry> memoryCache = new HashMap<>();
  private File cacheFile;
  private boolean cacheLoaded = false;

  private static class CacheEntry {
    long timestamp;
    List<CompletionItem> items;

    CacheEntry(List<CompletionItem> items) {
      this.timestamp = System.currentTimeMillis();
      this.items = items;
    }

    boolean isValid() {
      return System.currentTimeMillis() - timestamp < CACHE_DURATION;
    }
  }

  public synchronized List<CompletionItem> complete(
      Context context, String code, int line, int column, String prefix) {

    if (!cacheLoaded) {
      loadCache(context);
    }

    String cacheKey = generateCacheKey(code, line, column, prefix);

    CacheEntry cached = memoryCache.get(cacheKey);
    if (cached != null && cached.isValid()) {
      return cached.items;
    }

    try {
      String json = runAutoComplete(context, code, line, column);
      List<CompletionItem> result = parseCompletions(json, prefix);

      CacheEntry newEntry = new CacheEntry(result);
      memoryCache.put(cacheKey, newEntry);

      new Thread(() -> saveCache(context)).start();

      return result;
    } catch (Exception e) {
      Log.e(TAG, "Error in completion", e);
      return new ArrayList<>();
    }
  }

  private String generateCacheKey(String code, int line, int column, String prefix) {
    int codeHash = code.hashCode();
    return line + ":" + column + ":" + prefix + ":" + codeHash;
  }

  private void loadCache(Context context) {
    try {
      cacheFile = new File(context.getCacheDir(), CACHE_FILE);
      if (!cacheFile.exists()) {
        cacheLoaded = true;
        return;
      }

      Type cacheType = new TypeToken<Map<String, CacheEntry>>() {}.getType();
      try (FileReader reader = new FileReader(cacheFile)) {
        Map<String, CacheEntry> loadedCache = gson.fromJson(reader, cacheType);
        if (loadedCache != null) {
          for (Map.Entry<String, CacheEntry> entry : loadedCache.entrySet()) {
            if (entry.getValue().isValid()) {
              memoryCache.put(entry.getKey(), entry.getValue());
            }
          }

          if (memoryCache.size() > MAX_CACHE_ENTRIES) {
            trimCache();
          }
        }
      }
      cacheLoaded = true;
      Log.d(TAG, "Cache loaded with " + memoryCache.size() + " entries");
    } catch (Exception e) {
      Log.e(TAG, "Error loading cache", e);
      cacheLoaded = true;
    }
  }

  private void saveCache(Context context) {
    try {
      synchronized (memoryCache) {
        Map<String, CacheEntry> validCache = new HashMap<>();
        for (Map.Entry<String, CacheEntry> entry : memoryCache.entrySet()) {
          if (entry.getValue().isValid()) {
            validCache.put(entry.getKey(), entry.getValue());
          }
        }

        if (cacheFile == null) {
          cacheFile = new File(context.getCacheDir(), CACHE_FILE);
        }

        try (FileWriter writer = new FileWriter(cacheFile)) {
          gson.toJson(validCache, writer);
        }
      }
      Log.d(TAG, "Cache saved with " + memoryCache.size() + " entries");
    } catch (Exception e) {
      Log.e(TAG, "Error saving cache", e);
    }
  }

  private void trimCache() {
    if (memoryCache.size() <= MAX_CACHE_ENTRIES) return;

    List<Map.Entry<String, CacheEntry>> entries = new ArrayList<>(memoryCache.entrySet());
    entries.sort((e1, e2) -> Long.compare(e2.getValue().timestamp, e1.getValue().timestamp));

    Map<String, CacheEntry> newCache = new HashMap<>();
    for (int i = 0; i < MAX_CACHE_ENTRIES && i < entries.size(); i++) {
      Map.Entry<String, CacheEntry> entry = entries.get(i);
      newCache.put(entry.getKey(), entry.getValue());
    }

    memoryCache.clear();
    memoryCache.putAll(newCache);
  }

  private String runAutoComplete(Context context, String code, int line, int column)
      throws IOException, InterruptedException {
    File tempFile = File.createTempFile("temp_code_", ".py", context.getCacheDir());
    try (FileWriter writer = new FileWriter(tempFile)) {
      writer.write(code);
    }

    Process process =
        new ProcessBuilder()
            .command("sh", "-c", createAutoCompleteCommand(context, tempFile, line, column))
            .redirectErrorStream(true)
            .start();

    StringBuilder result = new StringBuilder();
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      String lineOut;
      while ((lineOut = reader.readLine()) != null) {
        result.append(lineOut);
      }
    }

    int exitCode = process.waitFor();
    tempFile.delete();

    if (exitCode != 0) {
      throw new IOException("Python process exited with code: " + exitCode);
    }

    return result.toString();
  }

  private String createAutoCompleteCommand(Context context, File tempFile, int line, int column) {
    String nativeLibPath = context.getApplicationInfo().nativeLibraryDir;
    String usrDir = context.getFilesDir().getAbsolutePath() + "/usr";

    return String.format(
        "export PYTHONHOME=%s && export LD_LIBRARY_PATH=%s/lib && %s/libpython3.so %s %s %d %d",
        usrDir,
        usrDir,
        nativeLibPath,
        new File(context.getFilesDir(), "autocomplete.py").getAbsolutePath(),
        tempFile.getAbsolutePath(),
        line,
        column);
  }

  private List<CompletionItem> parseCompletions(String jsonStr, String prefix) {
    List<CompletionItem> results = new ArrayList<>();
    if (jsonStr == null || jsonStr.trim().isEmpty()) {
      return results;
    }

    try {
      String userFilter =
          (prefix.lastIndexOf('.') >= 0) ? prefix.substring(prefix.lastIndexOf('.') + 1) : prefix;
      try (StringReader reader = new StringReader(jsonStr);
          JsonReader jsonReader = new JsonReader(reader)) {

        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
          PythonLsp item = readPythonLsp(jsonReader);
          if (userFilter.isEmpty() || item.getLabel().contains(userFilter)) {
            results.add(new CompletionItem(item.getLabel(), item.getCommit(), item.getDesc()));
          }
          if (results.size() > 50) {
            break;
          }
        }
        jsonReader.endArray();
      }
    } catch (Exception e) {
      Log.e(TAG, "Error parsing completion JSON", e);
    }
    return results;
  }

  private PythonLsp readPythonLsp(JsonReader reader) throws IOException {
    String label = "";
    String commit = "";
    String desc = "";

    reader.beginObject();
    while (reader.hasNext()) {
      String name = reader.nextName();
      switch (name) {
        case "label":
          label = reader.nextString();
          break;
        case "commit":
          commit = reader.nextString();
          break;
        case "desc":
          desc = reader.nextString();
          break;
        default:
          reader.skipValue();
          break;
      }
    }
    reader.endObject();

    return new PythonLsp(label, commit, desc);
  }

  class PythonLsp {
    private final String label;
    private final String commit;
    private final String desc;

    public PythonLsp(String label, String commit, String desc) {
      this.label = label;
      this.commit = commit;
      this.desc = desc;
    }

    public String getLabel() {
      return this.label;
    }

    public String getCommit() {
      return this.commit;
    }

    public String getDesc() {
      return this.desc;
    }
  }
}
