package io.github.rosemoe.sora.langs.java;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.Position;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FieldUsageChecker {

  public static void run(String token, TextAnalyzeResult result) {

    CompilationUnit cu = StaticJavaParser.parse(token);

    List<UnusedField> unusedFields = getUnusedFields(cu);

    for (UnusedField unusedField : unusedFields) {
      Utils.setSpanEFO(
          result,
          unusedField.declarationLine,
          unusedField.declarationColumn + unusedField.fieldName.length(),
          EditorColorScheme.COMMENT,
          false,
          true);
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

  private static FieldPosition getFieldDeclarationPosition(CompilationUnit cu, String fieldName) {
    FieldDeclarationFinder finder = new FieldDeclarationFinder(fieldName);
    cu.accept(finder, null);
    return finder.getDeclarationPosition();
  }

  /** دریافت تمام نام فیلدهای کلاس */
  public static List<String> getAllFieldNames(CompilationUnit cu) {
    List<String> fieldNames = new ArrayList<>();

    cu.accept(
        new VoidVisitorAdapter<Void>() {
          @Override
          public void visit(FieldDeclaration fd, Void arg) {
            for (VariableDeclarator vd : fd.getVariables()) {
              fieldNames.add(vd.getNameAsString());
            }
            super.visit(fd, arg);
          }
        },
        null);

    return fieldNames;
  }

  /** بررسی آیا فیلد خاصی استفاده شده است یا نه */
  public static boolean isFieldUsed(CompilationUnit cu, String fieldName) {
    FieldUsageVisitor visitor = new FieldUsageVisitor(fieldName);
    cu.accept(visitor, null);
    return visitor.isFieldUsed();
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

  /** ویزیتر برای پیدا کردن موقعیت تعریف فیلد */
  private static class FieldDeclarationFinder extends VoidVisitorAdapter<Void> {
    private final String targetFieldName;
    private FieldPosition declarationPosition = new FieldPosition(-1, -1);

    public FieldDeclarationFinder(String fieldName) {
      this.targetFieldName = fieldName;
    }

    @Override
    public void visit(FieldDeclaration fd, Void arg) {
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

      inFieldDeclaration = true;
      super.visit(fd, arg);
      inFieldDeclaration = false;
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
}
