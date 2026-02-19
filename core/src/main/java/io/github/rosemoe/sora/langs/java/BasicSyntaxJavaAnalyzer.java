package io.github.rosemoe.sora.langs.java;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.github.javaparser.*;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.CharPosition;
import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.model.Inlay;
import io.github.rosemoe.sora.model.InlayAlign;
import io.github.rosemoe.sora.diagnostics.*;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.core.IdeEditor;
import java.util.*;
import ir.ninjacoder.ghostide.core.R;
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
  private static final int ICON_TEXT_PADDING = 8;

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

    // پاک کردن وضعیت قبلی
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

      // مرحله 1: جمع‌آوری اطلاعات import
      for (ImportDeclaration imp : cu.getImports()) {
        if (imp.getRange().isPresent()) {
          Range r = imp.getRange().get();

          // استفاده از متد جدید برای محاسبه دقیق آفست
          int start = getCharOffsetFromPosition(r.begin);
          int end = getCharOffsetFromPosition(r.end);

          // محاسبه اند واقعی import (بدون فاصله‌های اضافی)
          int actualEnd = calculateActualEnd(content, end);



          importMap.put(
              imp.getNameAsString(),
              new ImportInfo(start, actualEnd, imp.getNameAsString(), imp.isStatic()));
        }
      }

      // مرحله 2: جمع‌آوری اطلاعات متدها
      for (MethodDeclaration m : cu.findAll(MethodDeclaration.class)) {
        List<String> names = new ArrayList<>();
        List<String> types = new ArrayList<>();
        int methodLine = m.getRange().map(r -> r.begin.line).orElse(0);

        for (Parameter p : m.getParameters()) {
          names.add(p.getNameAsString());
          types.add(p.getType().asString());
          if (p.getName().getRange().isPresent()) {
            Range r = p.getName().getRange().get();

            // محاسبه دقیق آفست برای پارامتر
            int start = getCharOffsetFromPosition(r.begin);
            int end = getCharOffsetFromPosition(r.end);

            // محاسبه اند واقعی
            int actualEnd = calculateActualEnd(content, end);

            paramMap.put(
                m.getNameAsString() + "|" + p.getNameAsString(),
                new ParamInfo(start, actualEnd, p.getNameAsString(), m.getNameAsString()));
          }
        }
        methodMap.put(
            m.getNameAsString() + "|" + names.size(),
            new MethodInfo(m.getNameAsString(), names, types, methodLine));
      }

      // مرحله 3: تحلیل استفاده‌ها
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

                // محاسبه دقیق آفست برای نمایش inlay
                int start = getCharOffsetFromPosition(r.begin);
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

                  // ایجاد inlay با فاصله مناسب
                  Inlay inlay =
                      new Inlay(
                          start,
                          color,
                          0xFFFFFFFF,
                          InlayAlign.LEFT,
                          " " + method.paramNames.get(i) + " ",
                          id,
                          false);
                  // فعال کردن خط زیر وقتی می‌خوای inlay رو اضافه کنی
                  // editor.addInlay(inlay);
                }
              }
            }
          },
          null);

      // مرحله 4: اضافه کردن diagnostic برای import‌های استفاده نشده
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

      // مرحله 5: اضافه کردن diagnostic و آیکون برای پارامترهای استفاده نشده
      for (Map.Entry<String, ParamInfo> e : paramMap.entrySet()) {
        if (!usedParams.contains(e.getKey())) {
          

    
          editor.addDiagnostic(
              new Diagnostic(
                  e.getValue().start,
                  e.getValue().end,
                  "Parameter '" + e.getValue().name + "' is never used",
                  DiagnosticsState.UNUSEDWAVE,
                  editor.getColorScheme().getColor(EditorColorScheme.javaparament)));
        }
      }

      // نمایش diagnosticها
      if (editor != null) editor.showCurrentDiagnostic();

    } catch (Exception e) {
      // خطاهای parse رو نادیده بگیر
    }
  }

  /**
   * متد جدید برای محاسبه آفست دقیق با استفاده از Content این متد مثل متد داخل CodeEditor عمل می‌کنه
   */
  private int getCharOffsetFromPosition(Position pos) {
    try {
      Content text = editor.getText();
      if (text == null) return 0;

      // خط در JavaParser از 1 شروع میشه، ولی در Content از 0
      int lineIndex = pos.line - 1;
      int columnIndex = pos.column - 1;

      // بررسی محدوده
      if (lineIndex < 0 || lineIndex >= text.getLineCount()) {
        return 0;
      }

      // اگه ستون از طول خط بیشتر باشه، به آخر خط برمی‌گردونیم
      int lineLength = text.getColumnCount(lineIndex);
      if (columnIndex > lineLength) {
        columnIndex = lineLength;
      }

      return text.getCharIndex(lineIndex, columnIndex);

    } catch (Exception e) {
      // در صورت خطا، از متد قدیمی استفاده کن
      return getOffsetFallback(pos);
    }
  }

  /** متد جایگزین برای وقتی که Content در دسترس نیست */
  private int getOffsetFallback(Position pos) {
    int line = 1, col = 1;
    for (int i = 0; i < currentCode.length(); i++) {
      if (line == pos.line && col == pos.column) return i;
      if (currentCode.charAt(i) == '\n') {
        line++;
        col = 1;
      } else {
        col++;
      }
    }
    return currentCode.length();
  }

  /** محاسبه اند واقعی (بدون در نظر گرفتن فاصله‌های بعد از کلمه) */
  private int calculateActualEnd(CharSequence text, int endPos) {
    if (endPos >= text.length()) return endPos;

    int i = endPos;
    while (i < text.length()) {
      char c = text.charAt(i);
      // اگه به فاصله یا tab یا newline برسیم، متوقف میشیم
      if (c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == ';' || c == ',' || c == ')') {
        break;
      }
      i++;
    }
    return i;
  }

  private String getSimpleName(String name) {
    int dot = name.lastIndexOf('.');
    return dot == -1 ? name : name.substring(dot + 1);
  }
}
