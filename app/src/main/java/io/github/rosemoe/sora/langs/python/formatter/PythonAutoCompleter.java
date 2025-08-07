package io.github.rosemoe.sora.langs.python.formatter;

import android.content.Context;
import android.util.Log;
import io.github.rosemoe.sora.data.CompletionItem;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PythonAutoCompleter {

  private static final String TAG = "PythonAutoCompleter";

  public List<CompletionItem> complete(
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
      JSONArray arr = new JSONArray(jsonStr);
      for (int i = 0; i < arr.length(); i++) {
        JSONObject obj = arr.getJSONObject(i);
        String label = obj.optString("label");
        String commit = obj.optString("commit");
        String desc = obj.optString("desc","");
        prefix = obj.optString("prefix");
        if (label.startsWith(prefix)) {
          results.add(new CompletionItem(label, commit, desc));
        }
      }
    } catch (Exception e) {
      Log.e(TAG, "Error parsing completion JSON", e);
    }
    return results;
  }
}
