package io.github.rosemoe.sora.langs.python.formatter;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PythonCodeAnalyzerAst {
  private final List<CodeElement> elements = new ArrayList<>();

  public static class CodeElement {
    public final String type; // "class", "method", "function", "variable", "import", etc.
    public final String name;
    public final int line;
    public final int column;
    public final int endLine;
    public final int endColumn;

    public CodeElement(String type, String name, int line, int column, int endLine, int endColumn) {
      this.type = type;
      this.name = name;
      this.line = line;
      this.column = column;
      this.endLine = endLine;
      this.endColumn = endColumn;
    }
  }

  public void analyze(Context context, String pythonCode) {
    elements.clear();
    try {
      String jsonResult = runAnalysis(context, pythonCode);
      parseElements(jsonResult);
    } catch (Exception e) {
      // Handle error
    }
  }

  public List<CodeElement> getElements() {
    return new ArrayList<>(elements);
  }

  public List<CodeElement> getMethods() {
    return filterElements("method");
  }

  public List<CodeElement> getFunctions() {
    return filterElements("function");
  }

  public List<CodeElement> getClasses() {
    return filterElements("class");
  }

  public List<CodeElement> getVariables() {
    return filterElements("variable");
  }

  public List<CodeElement> getImports() {
    return filterElements("import");
  }

  private List<CodeElement> filterElements(String type) {
    List<CodeElement> filtered = new ArrayList<>();
    for (CodeElement element : elements) {
      if (type.equals(element.type)) {
        filtered.add(element);
      }
    }
    return filtered;
  }

  private String runAnalysis(Context context, String code)
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
        new File(context.getFilesDir(), "python_analyzer.py").getAbsolutePath(),
        tempFile.getAbsolutePath());
  }

  private void parseElements(String json) {
    try {
      JSONArray elementsArray = new JSONArray(json);
      for (int i = 0; i < elementsArray.length(); i++) {
        JSONObject element = elementsArray.getJSONObject(i);
        CodeElement codeElement =
            new CodeElement(
                element.getString("type"),
                element.getString("name"),
                element.getInt("line"),
                element.getInt("column"),
                element.optInt("end_line", element.getInt("line")),
                element.optInt("end_column", element.getInt("column")));
        elements.add(codeElement);
      }
    } catch (Exception e) {
      // Handle parsing error
    }
  }
}
