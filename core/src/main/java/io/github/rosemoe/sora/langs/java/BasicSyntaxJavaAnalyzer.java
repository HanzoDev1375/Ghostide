package io.github.rosemoe.sora.langs.java;

import com.github.javaparser.*;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.model.Inlay;
import io.github.rosemoe.sora.model.InlayAlign;
import io.github.rosemoe.sora.diagnostics.*;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.core.IdeEditor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BasicSyntaxJavaAnalyzer implements CodeAnalyzer {
  private final IdeEditor editor;
  private final Map<String, MethodInfo> methodMap = new ConcurrentHashMap<>();
  private final Map<String, ImportInfo> importMap = new ConcurrentHashMap<>();
  private final Map<String, ParamInfo> paramMap = new ConcurrentHashMap<>();
  private final Set<String> usedImports = ConcurrentHashMap.newKeySet();
  private final Set<String> usedParams = ConcurrentHashMap.newKeySet();
  private final Set<String> activeHints = ConcurrentHashMap.newKeySet();
  private String currentCode = "";

  private static class MethodInfo {
    String name;
    List<String> paramNames;
    List<String> paramTypes;
    int line;

    MethodInfo(String name, List<String> paramNames, List<String> paramTypes, int line) {
      this.name = name;
      this.paramNames = paramNames;
      this.paramTypes = paramTypes;
      this.line = line;
    }
  }

  private static class ImportInfo {
    int start;
    int end;
    String name;
    boolean isStatic;

    ImportInfo(int start, int end, String name, boolean isStatic) {
      this.start = start;
      this.end = end;
      this.name = name;
      this.isStatic = isStatic;
    }
  }

  private static class ParamInfo {
    int start;
    int end;
    String name;
    String method;

    ParamInfo(int start, int end, String name, String method) {
      this.start = start;
      this.end = end;
      this.name = name;
      this.method = method;
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
    if (editor == null) return;
    editor.clearDiagnostics();
    editor.getInlays().removeIf(in -> in.getId() != null && in.getId().startsWith("param:"));

    currentCode = content.toString();
    if (currentCode.trim().isEmpty()) return;

    methodMap.clear();
    importMap.clear();
    paramMap.clear();
    usedImports.clear();
    usedParams.clear();
    activeHints.clear();

    try {
      CompilationUnit cu = StaticJavaParser.parse(currentCode);

      for (ImportDeclaration imp : cu.getImports()) {
        if (imp.getRange().isPresent()) {
          Range r = imp.getRange().get();
          int start = getOffset(currentCode, r.begin);
          int end = getOffset(currentCode, r.end) + 1;
          importMap.put(
              imp.getNameAsString(),
              new ImportInfo(start, end, imp.getNameAsString(), imp.isStatic()));
        }
      }

      for (MethodDeclaration m : cu.findAll(MethodDeclaration.class)) {
        List<String> names = new ArrayList<>();
        List<String> types = new ArrayList<>();
        int methodLine = m.getRange().map(r -> r.begin.line).orElse(0);

        for (Parameter p : m.getParameters()) {
          names.add(p.getNameAsString());
          types.add(p.getType().asString());
          if (p.getName().getRange().isPresent()) {
            Range r = p.getName().getRange().get();
            int start = getOffset(currentCode, r.begin);
            int end = getOffset(currentCode, r.end) + 1;
            paramMap.put(
                m.getNameAsString() + "|" + p.getNameAsString(),
                new ParamInfo(start, end, p.getNameAsString(), m.getNameAsString()));
          }
        }
        methodMap.put(
            m.getNameAsString() + "|" + names.size(),
            new MethodInfo(m.getNameAsString(), names, types, methodLine));
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
                usedParams.add(currentMethod.getNameAsString() + "|" + n.getNameAsString());
              }
              super.visit(n, arg);
            }

            @Override
            public void visit(ClassOrInterfaceType n, Void arg) {
              usedImports.add(n.getNameAsString());
              super.visit(n, arg);
            }

            @Override
            public void visit(ObjectCreationExpr n, Void arg) {
              usedImports.add(n.getType().getNameAsString());
              super.visit(n, arg);
            }

            @Override
            public void visit(MethodCallExpr n, Void arg) {
              super.visit(n, arg);
              if (!n.getRange().isPresent()) return;

              String name = n.getNameAsString();
              int argCount = n.getArguments().size();
              MethodInfo method = methodMap.get(name + "|" + argCount);
              if (method == null) return;

              NodeList<Expression> args = n.getArguments();
              for (int i = 0; i < args.size() && i < method.paramNames.size(); i++) {
                Expression argExpr = args.get(i);
                if (!argExpr.getRange().isPresent()) continue;

                Range r = argExpr.getRange().get();
                int start = getOffset(currentCode, r.begin);
                String id = "param:" + start + ":" + name + ":" + i;

                if (!activeHints.contains(id)) {
                  activeHints.add(id);
                  int color = 0x4D000000;
                  switch (i % 8) {
                    case 0:
                      color = 0x4D4CAF50;
                      break;
                    case 1:
                      color = 0x4D2196F3;
                      break;
                    case 2:
                      color = 0x4DFF9800;
                      break;
                    case 3:
                      color = 0x4DE91E63;
                      break;
                    case 4:
                      color = 0x4D9C27B0;
                      break;
                    case 5:
                      color = 0x4D00BCD4;
                      break;
                    case 6:
                      color = 0x4DFF5722;
                      break;
                    case 7:
                      color = 0x4D607D8B;
                      break;
                  }
                  Inlay inlay =
                      new Inlay(
                          start,
                          color,
                          0xFFFFFFFF,
                          InlayAlign.LEFT,
                          " " + method.paramNames.get(i) + " ",
                          id,
                          false);
               //   editor.addInlay(inlay);
                }
              }
            }
          },
          null);

      for (Map.Entry<String, ImportInfo> e : importMap.entrySet()) {
        String simpleName = getSimpleName(e.getKey());
        if (!usedImports.contains(simpleName)) {
          editor.addDiagnostic(
              new Diagnostic(
                  e.getValue().start,
                  e.getValue().end,
                  "Unused import: " + simpleName,
                  DiagnosticsState.UNUSED,
                  editor.getColorScheme().getColor(EditorColorScheme.jsfun)));
        }
      }

      for (Map.Entry<String, ParamInfo> e : paramMap.entrySet()) {
        if (!usedParams.contains(e.getKey())) {
          editor.addDiagnostic(
              new Diagnostic(
                  e.getValue().start,
                  e.getValue().end,
                  "Parameter '" + e.getValue().name + "' is never used",
                  DiagnosticsState.UNUSED,
                  editor.getColorScheme().getColor(EditorColorScheme.javaparament)));
        }
      }

      if (editor != null) editor.showCurrentDiagnostic();

    } catch (Exception e) {
      /* ignore parse errors */
    }
  }

  private int getOffset(String text, Position pos) {
    int line = 1, col = 1;
    for (int i = 0; i < text.length(); i++) {
      if (line == pos.line && col == pos.column) return i;
      if (text.charAt(i) == '\n') {
        line++;
        col = 1;
      } else {
        col++;
      }
    }
    return text.length();
  }

  private String getSimpleName(String name) {
    int dot = name.lastIndexOf('.');
    return dot == -1 ? name : name.substring(dot + 1);
  }
}
