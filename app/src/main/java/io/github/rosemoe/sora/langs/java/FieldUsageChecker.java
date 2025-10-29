package io.github.rosemoe.sora.langs.java;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.Position;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.body.Parameter;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.tooltip.ToolItemPop;
import ir.ninjacoder.ghostide.IdeEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FieldUsageChecker {
  public static void showWarningIfCursorOnField(IdeEditor editor) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(editor.getTextAsString());
      List<UnusedField> unusedFields = getUnusedFields(cu);

      int cursorLine = editor.getCursor().getLeftLine();
      int cursorColumn = editor.getCursor().getLeftColumn();

      for (UnusedField warning : unusedFields) {
        if (warning.declarationLine == cursorLine + 1) {
          String lineText = editor.getText().getLineString(cursorLine);
          if (lineText.contains(warning.fieldName)) {
            int fieldStart = lineText.indexOf(warning.fieldName);
            int fieldEnd = fieldStart + warning.fieldName.length();

            if (cursorColumn >= fieldStart && cursorColumn <= fieldEnd) {
              String message = "⚠️ فیلد استفاده نشده: " + warning.fieldName;

              PowerMenu powerMenu =
                  new PowerMenu.Builder(editor.getContext())
                      .addItem(new PowerMenuItem(message))
                      .setIsMaterial(true)
                      .setShowBackground(false)
                      .setAnimation(MenuAnimation.ELASTIC_CENTER)
                      .setMenuRadius(20f)
                      .setTextSize(14)
                      .setAutoDismiss(true)
                      .build();

              powerMenu.showAsAnchorLeftTop(editor);
              return;
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
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
            // بررسی می‌کنیم که فیلد public یا public static نباشد
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
            // پارامترهای متد
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
            // پارامترهای constructor
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
          public void visit(com.github.javaparser.ast.body.VariableDeclarator vd, Void arg) {
            // متغیرهای محلی داخل بلاک‌ها
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
  private static boolean isInMethodOrBlock(com.github.javaparser.ast.body.VariableDeclarator vd) {
    return vd.getParentNode().isPresent()
        && (vd.getParentNode().get() instanceof com.github.javaparser.ast.body.FieldDeclaration)
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
