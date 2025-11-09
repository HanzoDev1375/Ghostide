package io.github.rosemoe.sora.langs.java;

import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.github.javaparser.Position;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.ninjacoder.jgit.SimpleMarkdownRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.github.rosemoe.sora.event.ScrollEvent;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import io.github.rosemoe.sora.widget.EditorPopupWindow;
import ir.ninjacoder.ghostide.core.IdeEditor;

public class FieldUsageChecker {
  private static float[] buffer;

  public static void showWarningIfCursorOnField(IdeEditor editor) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(editor.getTextAsString());
      List<UnusedField> unusedFields = getUnusedFields(cu);
      List<UnusedLocalVariable> unusedLocalVars = getUnusedLocalVariables(cu);

      int cursorLine = editor.getCursor().getLeftLine();
      int cursorColumn = editor.getCursor().getLeftColumn();

      for (UnusedField warning : unusedFields) {
        int declarationLineInEditor = warning.declarationLine - 1;

        if (declarationLineInEditor == cursorLine) {
          String lineText = editor.getText().getLineString(cursorLine);
          if (lineText.contains(warning.fieldName)) {
            int fieldStart = lineText.indexOf(warning.fieldName);
            int fieldEnd = fieldStart + warning.fieldName.length();

            if (cursorColumn >= fieldStart && cursorColumn <= fieldEnd) {
              String message = "*not used*  " + "**" + warning.fieldName + "**";
              // استفاده از PowerMenu به جای EditorToolTipWindow
              showPowerMenuAtCursor(editor, message);
              return;
            }
          }
        }
      }

      for (UnusedLocalVariable localVar : unusedLocalVars) {
        int declarationLineInEditor = localVar.declarationLine - 1;

        if (declarationLineInEditor == cursorLine) {
          String lineText = editor.getText().getLineString(cursorLine);
          if (lineText.contains(localVar.variableName)) {
            int varStart = lineText.indexOf(localVar.variableName);
            int varEnd = varStart + localVar.variableName.length();

            if (cursorColumn >= varStart && cursorColumn <= varEnd) {
              String message = "*not used* " + "**" + localVar.variableName + "**";
              showPowerMenuAtCursor(editor, message);
              return;
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void showPowerMeniAtCutsorByCustomView(IdeEditor editor, View v) {
    try {
      EditorPopupWindow popupWindow =
          new EditorPopupWindow(
              (CodeEditor) editor,
              EditorPopupWindow.FEATURE_SCROLL_AS_CONTENT
                  | EditorPopupWindow.FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED);
      popupWindow.setContentView(v);
      popupWindow.setOutsideTouchable(true);
      buffer = new float[2];
      v.measure(
          View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
          View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

      int width = v.getMeasuredWidth();
      int height = v.getMeasuredHeight();
      popupWindow.setSize(width, height);
      var selection = editor.getCursor().left();
      float charX = editor.getCharOffsetX(selection.getLine(), selection.getColumn());
      float charY =
          editor.getCharOffsetY(selection.getLine(), selection.getColumn()) - editor.getRowHeight();

      var locationBuffer = new int[2];
      editor.getLocationInWindow(locationBuffer);
      float restAbove = charY + locationBuffer[1];
      float restBottom = editor.getHeight() - charY - editor.getRowHeight();

      boolean completionShowing = editor.getAutoCompleteWindow().isShowing();
      float windowY;
      if (restAbove > restBottom || completionShowing) {
        windowY = charY - popupWindow.getHeight();
      } else {
        windowY = charY + editor.getRowHeight() * 1.5f;
      }

      if (completionShowing && windowY < 0) {
        return;
      }

      float windowX = Math.max(charX - popupWindow.getWidth() / 2f, 0f);
      popupWindow.setLocationAbsolutely((int) windowX, (int) windowY);
      popupWindow.show();
      editor.subscribeEvent(
          ScrollEvent.class,
          (event, unsubscribe) -> {
            if (popupWindow.isShowing()) {
              if (!isSelectionVisible(editor)) {
                popupWindow.dismiss();
              } else {
                popupWindow.show();
              }
            }
          });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static boolean isSelectionVisible(IdeEditor editor) {
    var selection = editor.getCursor().left();
    editor.getLayout().getCharLayoutOffset(selection.getLine(), selection.getColumn(), buffer);
    return buffer[0] >= editor.getOffsetY()
        && buffer[0] - editor.getRowHeight() <= editor.getOffsetY() + editor.getHeight()
        && buffer[1] >= editor.getOffsetX()
        && buffer[1] - 100f <= editor.getOffsetX() + editor.getWidth();
  }

  public static void showPowerMenuAtCursor(IdeEditor editor, String message) {
    try {
      // ایجاد EditorPopupWindow
      EditorPopupWindow popupWindow =
          new EditorPopupWindow(
              (CodeEditor) editor,
              EditorPopupWindow.FEATURE_SCROLL_AS_CONTENT
                  | EditorPopupWindow.FEATURE_SHOW_OUTSIDE_VIEW_ALLOWED);
      TextView textView = new TextView(editor.getContext());
      textView.setSingleLine(true);
      textView.setPadding(32, 16, 32, 16);
      textView.setBackgroundColor(
          editor.getColorScheme().getColor(EditorColorScheme.AUTO_COMP_PANEL_BG));
      textView.setTextSize(14);
      textView.setTextColor(editor.getColorScheme().getColor(EditorColorScheme.TEXT_NORMAL));

      // رندر متن markdown
      var render = new SimpleMarkdownRenderer();
      var result =
          render.render(
              message,
              editor.getColorScheme().getColor(EditorColorScheme.KEYWORD),
              Color.CYAN,
              Color.YELLOW,
              Typeface.MONOSPACE);
      textView.setText(result);
      popupWindow.setContentView(textView);
      popupWindow.setOutsideTouchable(true);

      textView.measure(
          View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
          View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

      int width = textView.getMeasuredWidth();
      int height = textView.getMeasuredHeight();
      popupWindow.setSize(width, height);
      var selection = editor.getCursor().left();
      float charX = editor.getCharOffsetX(selection.getLine(), selection.getColumn());
      float charY =
          editor.getCharOffsetY(selection.getLine(), selection.getColumn()) - editor.getRowHeight();

      var locationBuffer = new int[2];
      editor.getLocationInWindow(locationBuffer);
      float restAbove = charY + locationBuffer[1];
      float restBottom = editor.getHeight() - charY - editor.getRowHeight();

      boolean completionShowing = editor.getAutoCompleteWindow().isShowing();
      float windowY;
      if (restAbove > restBottom || completionShowing) {
        windowY = charY - popupWindow.getHeight();
      } else {
        windowY = charY + editor.getRowHeight() * 1.5f;
      }

      if (completionShowing && windowY < 0) {
        return;
      }

      float windowX = Math.max(charX - popupWindow.getWidth() / 2f, 0f);
      popupWindow.setLocationAbsolutely((int) windowX, (int) windowY);
      popupWindow.show();
      popupWindow.dismissByTime();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static int selectTop(IdeEditor editor, RectF rect, int popupHeight) {
    int rowHeight = editor.getRowHeight();
    if (rect.top - rowHeight * 3 / 2F > popupHeight) {
      return (int) (rect.top - rowHeight * 3 / 2 - popupHeight);
    } else {
      return (int) (rect.bottom + rowHeight / 2);
    }
  }

  public static void run(String token, TextAnalyzeResult result) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(token);
      List<UnusedField> unusedFields = getUnusedFields(cu);
      List<UnusedLocalVariable> unusedLocalVars = getUnusedLocalVariables(cu);
      for (UnusedField unusedField : unusedFields) {
        Utils.setWaringSpan(result, unusedField.declarationLine, unusedField.declarationColumn);
      }

      for (UnusedLocalVariable unusedLocalVar : unusedLocalVars) {
        Utils.setWaringSpan(
            result, unusedLocalVar.declarationLine, unusedLocalVar.declarationColumn);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<UnusedField> getUnusedFields(CompilationUnit cu) {
    List<String> allFieldNames = getAllFieldNames(cu);
    List<UnusedField> unusedFields = new ArrayList<>();

    for (String fieldName : allFieldNames) {
      if (!isFieldUsed(cu, fieldName)) {

        FieldPosition declarationPos = getFieldDeclarationPosition(cu, fieldName);
        unusedFields.add(new UnusedField(fieldName, declarationPos.line, declarationPos.column));
      }
    }

    return unusedFields;
  }

  public static List<UnusedLocalVariable> getUnusedLocalVariables(CompilationUnit cu) {
    List<LocalVariableInfo> allLocalVars = getAllLocalVariables(cu);
    List<UnusedLocalVariable> unusedLocalVars = new ArrayList<>();

    for (LocalVariableInfo localVar : allLocalVars) {
      if (!isLocalVariableUsed(cu, localVar)) {
        unusedLocalVars.add(
            new UnusedLocalVariable(
                localVar.variableName, localVar.declarationLine, localVar.declarationColumn));
      }
    }

    return unusedLocalVars;
  }

  private static FieldPosition getFieldDeclarationPosition(CompilationUnit cu, String fieldName) {
    FieldDeclarationFinder finder = new FieldDeclarationFinder(fieldName);
    cu.accept(finder, null);
    return finder.getDeclarationPosition();
  }

  /** دریافت تمام نام فیلدهای کلاس (فقط فیلدهای غیر-public) */
  public static List<String> getAllFieldNames(CompilationUnit cu) {
    List<String> fieldNames = new ArrayList<>();

    cu.accept(
        new VoidVisitorAdapter<Void>() {
          @Override
          public void visit(FieldDeclaration fd, Void arg) {

            if (!fd.isPublic()) {
              for (VariableDeclarator vd : fd.getVariables()) {
                fieldNames.add(vd.getNameAsString());
              }
            }
            super.visit(fd, arg);
          }
        },
        null);

    return fieldNames;
  }

  /** دریافت تمام متغیرهای محلی */
  public static List<LocalVariableInfo> getAllLocalVariables(CompilationUnit cu) {
    List<LocalVariableInfo> localVars = new ArrayList<>();

    cu.accept(
        new VoidVisitorAdapter<Void>() {
          @Override
          public void visit(MethodDeclaration md, Void arg) {

            for (Parameter param : md.getParameters()) {
              Optional<Position> begin = param.getName().getBegin();
              if (begin.isPresent()) {
                localVars.add(
                    new LocalVariableInfo(
                        param.getNameAsString(), begin.get().line, begin.get().column));
              }
            }
            super.visit(md, arg);
          }

          @Override
          public void visit(ConstructorDeclaration cd, Void arg) {

            for (Parameter param : cd.getParameters()) {
              Optional<Position> begin = param.getName().getBegin();
              if (begin.isPresent()) {
                localVars.add(
                    new LocalVariableInfo(
                        param.getNameAsString(), begin.get().line, begin.get().column));
              }
            }
            super.visit(cd, arg);
          }

          @Override
          public void visit(VariableDeclarator vd, Void arg) {

            if (isInMethodOrBlock(vd)) {
              Optional<Position> begin = vd.getName().getBegin();
              if (begin.isPresent()) {
                localVars.add(
                    new LocalVariableInfo(
                        vd.getNameAsString(), begin.get().line, begin.get().column));
              }
            }
            super.visit(vd, arg);
          }

          @Override
          public void visit(ForStmt forStmt, Void arg) {

            forStmt
                .getInitialization()
                .forEach(
                    expr -> {
                      if (expr instanceof VariableDeclarationExpr) {
                        VariableDeclarationExpr varExpr = (VariableDeclarationExpr) expr;
                        for (VariableDeclarator vd : varExpr.getVariables()) {
                          Optional<Position> begin = vd.getName().getBegin();
                          if (begin.isPresent()) {
                            localVars.add(
                                new LocalVariableInfo(
                                    vd.getNameAsString(), begin.get().line, begin.get().column));
                          }
                        }
                      }
                    });
            super.visit(forStmt, arg);
          }

          @Override
          public void visit(CatchClause catchClause, Void arg) {
            Optional<Position> begin = catchClause.getParameter().getName().getBegin();
            if (begin.isPresent()) {
              localVars.add(
                  new LocalVariableInfo(
                      catchClause.getParameter().getNameAsString(),
                      begin.get().line,
                      begin.get().column));
            }
            super.visit(catchClause, arg);
          }
        },
        null);

    return localVars;
  }

  /** بررسی آیا متغیر محلی استفاده شده است یا نه */
  public static boolean isLocalVariableUsed(CompilationUnit cu, LocalVariableInfo localVar) {
    LocalVariableUsageVisitor visitor =
        new LocalVariableUsageVisitor(
            localVar.variableName, localVar.declarationLine, localVar.declarationColumn);
    cu.accept(visitor, null);
    return visitor.isVariableUsed();
  }

  /** بررسی آیا فیلد خاصی استفاده شده است یا نه */
  public static boolean isFieldUsed(CompilationUnit cu, String fieldName) {
    FieldUsageVisitor visitor = new FieldUsageVisitor(fieldName);
    cu.accept(visitor, null);
    return visitor.isFieldUsed();
  }

  /** بررسی آیا VariableDeclarator داخل متد یا بلاک است */
  private static boolean isInMethodOrBlock(VariableDeclarator vd) {
    return vd.getParentNode().isPresent()
        && (vd.getParentNode().get() instanceof FieldDeclaration)
            == false;
  }

  /** کلاس برای ذخیره موقعیت */
  public static class FieldPosition {
    public final int line;
    public final int column;

    public FieldPosition(int line, int column) {
      this.line = line;
      this.column = column;
    }
  }

  /** کلاس برای ذخیره اطلاعات فیلد استفاده نشده */
  public static class UnusedField {
    public final String fieldName;
    public final int declarationLine;
    public final int declarationColumn;

    public UnusedField(String fieldName, int declarationLine, int declarationColumn) {
      this.fieldName = fieldName;
      this.declarationLine = declarationLine;
      this.declarationColumn = declarationColumn;
    }
  }

  /** کلاس برای ذخیره اطلاعات متغیر محلی */
  public static class LocalVariableInfo {
    public final String variableName;
    public final int declarationLine;
    public final int declarationColumn;

    public LocalVariableInfo(String variableName, int declarationLine, int declarationColumn) {
      this.variableName = variableName;
      this.declarationLine = declarationLine;
      this.declarationColumn = declarationColumn;
    }
  }

  /** کلاس برای ذخیره اطلاعات متغیر محلی استفاده نشده */
  public static class UnusedLocalVariable {
    public final String variableName;
    public final int declarationLine;
    public final int declarationColumn;

    public UnusedLocalVariable(String variableName, int declarationLine, int declarationColumn) {
      this.variableName = variableName;
      this.declarationLine = declarationLine;
      this.declarationColumn = declarationColumn;
    }
  }

  /** ویزیتر برای پیدا کردن موقعیت تعریف فیلد */
  private static class FieldDeclarationFinder extends VoidVisitorAdapter<Void> {
    private final String targetFieldName;
    private FieldPosition declarationPosition = new FieldPosition(-1, -1);

    public FieldDeclarationFinder(String fieldName) {
      this.targetFieldName = fieldName;
    }

    @Override
    public void visit(FieldDeclaration fd, Void arg) {
      if (!fd.isPublic()) {
        for (VariableDeclarator vd : fd.getVariables()) {
          if (vd.getNameAsString().equals(targetFieldName)) {
            Optional<Position> beginPosition = vd.getName().getBegin();
            if (beginPosition.isPresent()) {
              Position pos = beginPosition.get();
              declarationPosition = new FieldPosition(pos.line, pos.column);
            }
            break;
          }
        }
      }
      super.visit(fd, arg);
    }

    public FieldPosition getDeclarationPosition() {
      return declarationPosition;
    }
  }

  /** ویزیتر مخصوص برای بررسی استفاده از فیلد */
  private static class FieldUsageVisitor extends VoidVisitorAdapter<Void> {
    private final String targetFieldName;
    private boolean fieldUsed = false;
    private boolean inFieldDeclaration = false;

    public FieldUsageVisitor(String fieldName) {
      this.targetFieldName = fieldName;
    }

    @Override
    public void visit(FieldDeclaration fd, Void arg) {

      if (!fd.isPublic()) {
        inFieldDeclaration = true;
        super.visit(fd, arg);
        inFieldDeclaration = false;
      } else {
        super.visit(fd, arg);
      }
    }

    @Override
    public void visit(SimpleName name, Void arg) {
      if (name.asString().equals(targetFieldName) && !inFieldDeclaration) {
        fieldUsed = true;
      }
      super.visit(name, arg);
    }

    public boolean isFieldUsed() {
      return fieldUsed;
    }
  }

  private static class LocalVariableUsageVisitor extends VoidVisitorAdapter<Void> {
    private final String targetVariableName;
    private final int declarationLine;
    private final int declarationColumn;
    private boolean variableUsed = false;
    private boolean inDeclaration = false;

    public LocalVariableUsageVisitor(String variableName, int declLine, int declColumn) {
      this.targetVariableName = variableName;
      this.declarationLine = declLine;
      this.declarationColumn = declColumn;
    }

    @Override
    public void visit(VariableDeclarator vd, Void arg) {

      Optional<Position> begin = vd.getName().getBegin();
      if (begin.isPresent()
          && begin.get().line == declarationLine
          && begin.get().column == declarationColumn) {
        inDeclaration = true;
        super.visit(vd, arg);
        inDeclaration = false;
      } else {
        super.visit(vd, arg);
      }
    }

    @Override
    public void visit(Parameter param, Void arg) {
      Optional<Position> begin = param.getName().getBegin();
      if (begin.isPresent()
          && begin.get().line == declarationLine
          && begin.get().column == declarationColumn) {
        inDeclaration = true;
        super.visit(param, arg);
        inDeclaration = false;
      } else {
        super.visit(param, arg);
      }
    }

    @Override
    public void visit(SimpleName name, Void arg) {
      if (name.asString().equals(targetVariableName) && !inDeclaration) {
        variableUsed = true;
      }
      super.visit(name, arg);
    }

    public boolean isVariableUsed() {
      return variableUsed;
    }
  }
}
