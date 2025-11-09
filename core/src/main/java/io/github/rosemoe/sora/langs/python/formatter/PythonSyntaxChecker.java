package io.github.rosemoe.sora.langs.python.formatter;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PythonSyntaxChecker {
  private final List<CodeIssue> issues = new ArrayList<>();

  public static class CodeIssue {
    public final int line;
    public final int column;
    public final String message;
    public final String type; // "error" or "warning"
    public final String suggestion;

    public CodeIssue(int line, int column, String message, String type, String suggestion) {
      this.line = line;
      this.column = column;
      this.message = message;
      this.type = type;
      this.suggestion = suggestion;
    }
  }

  public void checkSyntax(Context context, String pythonCode) {
    issues.clear();
    try {
      String jsonResult = runSyntaxCheck(context, pythonCode);
      parseIssues(jsonResult);
    } catch (Exception e) {
      addIssue(0, 0, "خطا در اجرای بررسی: " + e.getMessage(), "error", null);
    }
  }

  private void addIssue(int line, int column, String message, String type, String suggestion) {
    issues.add(new CodeIssue(line, column, message, type, suggestion));
  }

  public List<CodeIssue> getIssues() {
    return new ArrayList<>(issues);
  }

  public List<CodeIssue> getErrors() {
    List<CodeIssue> errors = new ArrayList<>();
    for (CodeIssue issue : issues) {
      if ("error".equals(issue.type)) {
        errors.add(issue);
      }
    }
    return errors;
  }

  public List<CodeIssue> getWarnings() {
    List<CodeIssue> warnings = new ArrayList<>();
    for (CodeIssue issue : issues) {
      if ("warning".equals(issue.type)) {
        warnings.add(issue);
      }
    }
    return warnings;
  }

  public List<CodeIssue> getTypo() {
    List<CodeIssue> typo = new ArrayList<>();
    for (CodeIssue issue : issues) {
      if ("typo".equals(issue.type)) {
        typo.add(issue);
      }
    }
    return typo;
  }

  public boolean hasErrors() {
    for (CodeIssue issue : issues) {
      if ("error".equals(issue.type)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasWarnings() {
    for (CodeIssue issue : issues) {
      if ("warning".equals(issue.type)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasTypo() {
    for (CodeIssue iss : issues) {
      if ("typo".equals(iss.type)) {
        return true;
      }
    }
    return false;
  }

  private String runSyntaxCheck(Context context, String code)
      throws IOException, InterruptedException {
    File tempFile = File.createTempFile("py_", ".py", context.getCacheDir());
    try (FileWriter writer = new FileWriter(tempFile)) {
      writer.write(code);
    }

    Process process =
        new ProcessBuilder()
            .command("sh", "-c", createPythonCommand(context, tempFile))
            .redirectErrorStream(true)
            .start();

    StringBuilder result = new StringBuilder();
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        result.append(line);
      }
    }

    process.waitFor();
    tempFile.delete();
    return result.toString();
  }

  private String createPythonCommand(Context context, File tempFile) {
    String pythonPath = context.getApplicationInfo().nativeLibraryDir;
    String pythonHome = context.getFilesDir() + "/usr";

    return String.format(
        "export PYTHONHOME=%s && export LD_LIBRARY_PATH=%s/lib && %s/libpython3.so %s %s",
        pythonHome,
        pythonHome,
        pythonPath,
        new File(context.getFilesDir(), "python_checker.py").getAbsolutePath(),
        tempFile.getAbsolutePath());
  }

  private void parseIssues(String json) {
    try {
      JSONArray issuesArray = new JSONArray(json);
      for (int i = 0; i < issuesArray.length(); i++) {
        JSONObject issue = issuesArray.getJSONObject(i);
        addIssue(
            issue.optInt("line", 0),
            issue.optInt("column", 0),
            issue.optString("message", "Unknown issue"),
            issue.optString("type", "error"),
            issue.optString("suggestion", null));
      }
    } catch (Exception e) {
      addIssue(0, 0, "خطا در پردازش نتیجه: " + e.getMessage(), "error", null);
    }
  }
}
