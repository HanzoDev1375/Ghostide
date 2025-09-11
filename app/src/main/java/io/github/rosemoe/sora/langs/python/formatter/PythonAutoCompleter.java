package io.github.rosemoe.sora.langs.python.formatter;

import android.content.Context;
import android.util.Log;
import com.google.gson.stream.JsonReader;
import io.github.rosemoe.sora.data.CompletionItem;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PythonAutoCompleter {

  private static final String TAG = "PythonAutoCompleter";

  public synchronized List<CompletionItem> complete(
      Context context, String code, int line, int column, String prefix) {
    try {
      String json = runAutoComplete(context, code, line, column);
      return parseCompletions(json, prefix);
    } catch (Exception e) {
      Log.e(TAG, "Error in completion", e);
      return new ArrayList<>();
    }
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

    process.waitFor();
    tempFile.delete();
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
