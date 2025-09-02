package ninjacoder.ghostide.androidtools.r8.android;

import java.net.URI;
import javax.tools.*;
import java.util.*;

public class JavaAnalyzer {

  public static List<CodeLine> analyze(String code) {
    List<CodeLine> errorsList = new ArrayList<>();
    String[] lines = code.split("\n");

    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

    JavaFileObject file = new JavaSourceFromString("Main", code);
    Iterable<? extends JavaFileObject> compilationUnits = Collections.singletonList(file);

    compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits).call();

    for (Diagnostic<? extends JavaFileObject> diag : diagnostics.getDiagnostics()) {
      if (diag.getKind() == Diagnostic.Kind.ERROR) {
        int index = (int) (diag.getLineNumber() - 1);
        if (index >= 0 && index < lines.length) {
          errorsList.add(
              new CodeLine(
                  lines[index],
                  diag.getMessage(null),
                  (int) diag.getLineNumber(),
                  (int) diag.getColumnNumber(),
                  true,
                  false));
        }
      }
      if (diag.getKind() == Diagnostic.Kind.MANDATORY_WARNING
          || diag.getKind() == Diagnostic.Kind.WARNING) {
        int index = (int) (diag.getLineNumber() - 1);
        if (index >= 0 && index < lines.length) {
          errorsList.add(
              new CodeLine(
                  lines[index],
                  diag.getMessage(null),
                  (int) diag.getLineNumber(),
                  (int) diag.getColumnNumber(),
                  false,
                  true));
        }
      }
    }

    try {
      fileManager.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return errorsList; // اگر هیچ خطایی نبود، لیست خالی برمی‌گرده
  }

  static class JavaSourceFromString extends SimpleJavaFileObject {
    final String code;

    JavaSourceFromString(String name, String code) {
      super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
      this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
      return code;
    }
  }
}
