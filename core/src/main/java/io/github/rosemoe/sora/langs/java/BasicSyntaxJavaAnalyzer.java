package io.github.rosemoe.sora.langs.java;

import com.github.javaparser.*;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.type.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.diagnostics.*;

import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.core.IdeEditor;
import java.util.*;

public class BasicSyntaxJavaAnalyzer implements CodeAnalyzer {

  private final IdeEditor editor;
  private final Map<String, ImportInfo> imports = new HashMap<>();
  private final Map<String, ParamInfo> params = new HashMap<>();

  private final Map<String, Boolean> usedImports = new HashMap<>();
  private final Map<String, Boolean> usedParams = new HashMap<>();

  private static class ImportInfo {
    int startIndex;
    int endIndex;
    boolean isStatic;

    ImportInfo(int startIndex, int endIndex, boolean isStatic) {
      this.startIndex = startIndex;
      this.endIndex = endIndex;
      this.isStatic = isStatic;
    }
  }

  private static class ParamInfo {
    int startIndex;
    int endIndex;

    ParamInfo(int startIndex, int endIndex) {
      this.startIndex = startIndex;
      this.endIndex = endIndex;
    }
  }

  public BasicSyntaxJavaAnalyzer(IdeEditor editor) {
    this.editor = editor;
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult colors,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    if (editor != null) editor.clearDiagnostics();

    imports.clear();
    params.clear();
    usedImports.clear();
    usedParams.clear();

    String code = content.toString();

    try {
      CompilationUnit cu = StaticJavaParser.parse(code);

      for (ImportDeclaration imp : cu.getImports()) {
        if (!imp.isAsterisk() && imp.getRange().isPresent()) {
          var r = imp.getRange().get();
          int start = getCharIndex(code, r.begin);
          int end = getCharIndex(code, r.end) + 1;
          String name = imp.getNameAsString();
          imports.put(name, new ImportInfo(start, end, imp.isStatic()));
          usedImports.put(getSimpleName(name), false);
        }
      }

      for (MethodDeclaration method : cu.findAll(MethodDeclaration.class)) {
        for (Parameter p : method.getParameters()) {
          if (p.getName().getRange().isPresent()) {
            var r = p.getName().getRange().get();
            int start = getCharIndex(code, r.begin);
            int end = getCharIndex(code, r.end) + 1;
            String key = method.getNameAsString() + "|" + p.getNameAsString();
            params.put(key, new ParamInfo(start, end));
            usedParams.put(key, false);
          }
        }
      }

      cu.accept(
          new VoidVisitorAdapter<Void>() {
            MethodDeclaration currentMethod = null;

            @Override
            public void visit(MethodDeclaration n, Void arg) {
              MethodDeclaration prev = currentMethod;
              currentMethod = n;
              super.visit(n, arg);
              currentMethod = prev;
            }

            @Override
            public void visit(NameExpr n, Void arg) {
              if (currentMethod != null) {
                String key = currentMethod.getNameAsString() + "|" + n.getNameAsString();
                if (usedParams.containsKey(key)) usedParams.put(key, true);
              }
              super.visit(n, arg);
            }

            @Override
            public void visit(ClassOrInterfaceType n, Void arg) {
              String name = n.getNameAsString();
              if (usedImports.containsKey(name)) usedImports.put(name, true);
              super.visit(n, arg);
            }

            @Override
            public void visit(ObjectCreationExpr n, Void arg) {
              String name = n.getType().getNameAsString();
              if (usedImports.containsKey(name)) usedImports.put(name, true);
              super.visit(n, arg);
            }

            @Override
            public void visit(MethodCallExpr n, Void arg) {
              if (!n.getScope().isPresent()) {
                String name = n.getNameAsString();
                if (usedImports.containsKey(name)) usedImports.put(name, true);
              }
              super.visit(n, arg);
            }
          },
          null);

      for (Map.Entry<String, ImportInfo> entry : imports.entrySet()) {
        String name = entry.getKey();
        ImportInfo pos = entry.getValue();
        boolean used = usedImports.getOrDefault(getSimpleName(name), false);
        if (!used && editor != null) {
          editor.addDiagnostic(
              new Diagnostic(
                  pos.startIndex,
                  pos.endIndex,
                  "Unused import: " + name,
                  DiagnosticsState.UNUSED,
                  getColorEditor(EditorColorScheme.jsfun)));
        }
      }

      for (Map.Entry<String, ParamInfo> entry : params.entrySet()) {
        String key = entry.getKey();
        ParamInfo pos = entry.getValue();
        boolean used = usedParams.getOrDefault(key, false);
        if (!used && editor != null) {
          editor.addDiagnostic(
              new Diagnostic(
                  pos.startIndex,
                  pos.endIndex,
                  "Unused parameter: " + key.split("\\|")[1],
                  DiagnosticsState.UNUSED,
                  getColorEditor(EditorColorScheme.javaparament)));
        }
      }

      if (editor != null) editor.showCurrentDiagnostic();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private int getCharIndex(String code, com.github.javaparser.Position pos) {
    int line = pos.line;
    int column = pos.column;
    int currentLine = 1;
    int offset = 0;
    for (int i = 0; i < code.length(); i++) {
      if (currentLine == line) return offset + column - 1;
      if (code.charAt(i) == '\n') currentLine++;
      offset++;
    }
    return code.length();
  }

  private static String getSimpleName(String name) {
    int idx = name.lastIndexOf('.');
    return idx == -1 ? name : name.substring(idx + 1);
  }

  int getColorEditor(int id) {
    return editor.getColorScheme().getColor(id);
  }
}
