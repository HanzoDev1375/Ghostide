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

  private final Context context;
  private static final String TAG = "PythonAutoCompleter";

  public PythonAutoCompleter(Context context) {
    this.context = context;
  }

  public List<CompletionItem> getCompletions(String sourceCode, int line, int column) {
    File tempFile = null;
    try {
      // ایجاد فایل موقت
      tempFile = File.createTempFile("temp_py", ".py", context.getCacheDir());
      try (FileWriter writer = new FileWriter(tempFile)) {
        writer.write(sourceCode);
      }

      // مسیرهای ضروری - مطابق الگوی شما
      String pythonHome = context.getFilesDir().getAbsolutePath() + "/usr";
      String pythonLib = pythonHome + "/lib";
      String pythonBinary = pythonLib + "/libpython3.so";
      String sitePackages = pythonHome + "/lib/python3.11/site-packages";
      String autocompleteScript =
          new File(context.getFilesDir(), "autocomplete.py").getAbsolutePath();

      // ساخت دستور اجرا - مطابق الگوی شما با اصلاحات لازم
      String command =
          String.format(
              "export PYTHONHOME=%s && "
                  + "export PYTHONPATH=%s:%s && "
                  + "export LD_LIBRARY_PATH=%s && "
                  + "cd %s && "
                  + "%s %s %s %d %d",
              pythonHome,
              pythonLib,
              sitePackages,
              pythonLib,
              tempFile.getParent(),
              pythonBinary,
              autocompleteScript,
              tempFile.getName(),
              line + 1,
              column);

      Log.d(TAG, "Executing command: " + command);

      // تنظیم مجوز اجرا
      new File(pythonBinary).setExecutable(true);

      Process process = Runtime.getRuntime().exec(new String[] {"sh", "-c", command});

      // خواندن خروجی
      StringBuilder output = new StringBuilder();
      try (BufferedReader reader =
          new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        String lineStr;
        while ((lineStr = reader.readLine()) != null) {
          output.append(lineStr);
        }
      }

      // خواندن خطاها
      StringBuilder errors = new StringBuilder();
      try (BufferedReader errorReader =
          new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
        String errorLine;
        while ((errorLine = errorReader.readLine()) != null) {
          errors.append(errorLine).append("\n");
        }
      }

      int exitCode = process.waitFor();
      if (exitCode != 0) {
        Log.e(TAG, "Python completion error:\n" + errors);
        return new ArrayList<>();
      }

      return parseJsonCompletions(output.toString());

    } catch (Exception e) {
      Log.e(TAG, "Error in Python completion", e);
      return new ArrayList<>();
    } finally {
      if (tempFile != null) {
        tempFile.delete();
      }
    }
  }

  private List<CompletionItem> parseJsonCompletions(String jsonStr) {
    List<CompletionItem> result = new ArrayList<>();
    if (jsonStr == null || jsonStr.trim().isEmpty()) {
      return result;
    }

    try {
      JSONArray jsonArray = new JSONArray(jsonStr);
      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject obj = jsonArray.getJSONObject(i);
        CompletionItem item =
            new CompletionItem(
                obj.getString("label"),
                obj.optString("commit", obj.getString("label")),
                obj.optString("desc", ""));
        result.add(item);
      }
    } catch (Exception e) {
      Log.e(TAG, "Error parsing JSON", e);
    }
    return result;
  }
}
