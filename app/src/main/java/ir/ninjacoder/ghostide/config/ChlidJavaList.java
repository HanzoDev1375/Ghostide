package ir.ninjacoder.ghostide.config;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.util.ArrayList;
import java.util.List;

public class ChlidJavaList {

  private String code;

  public ChlidJavaList(String code) {
    this.code = code;
  }

  public List<String> getAllMethod() {
    List<String> child = new ArrayList<>();

    CompilationUnit cu = StaticJavaParser.parse(code);
    VoidVisitorAdapter<Void> methodNameVisitor =
        new VoidVisitorAdapter<Void>() {
          @Override
          public void visit(MethodDeclaration n, Void arg) {
            super.visit(n, arg);
            // چاپ نام توابع
            System.out.println("Method Name: " + n.getNameAsString());
            child.add(n.getNameAsString());
          }
        };
    methodNameVisitor.visit(cu, null);

    return child;
  }

  public List<String> getAllEnum() {
    List<String> child = new ArrayList<>();

    CompilationUnit cu = StaticJavaParser.parse(code);
    VoidVisitorAdapter<Void> methodNameVisitor =
        new VoidVisitorAdapter<Void>() {
          @Override
          public void visit(EnumDeclaration n, Void arg) {
            super.visit(n, arg);
            // چاپ نام توابع
            System.out.println("" + n.getNameAsString());
            child.add(n.getNameAsString());
          }
        };
    methodNameVisitor.visit(cu, null);

    return child;
  }

  public List<String> getAllVariable() {
    List<String> child = new ArrayList<>();

    CompilationUnit cu = StaticJavaParser.parse(code);
    VoidVisitorAdapter<Void> methodNameVisitor =
        new VoidVisitorAdapter<Void>() {
          @Override
          public void visit(VariableDeclarator n, Void arg) {
            super.visit(n, arg);
            // چاپ نام توابع
            System.out.println("Variable Name: " + n.getNameAsString());

            child.add(n.getNameAsString());
          }
        };
    methodNameVisitor.visit(cu, null);

    return child;
  }

  public List<String> getAllFileds() {
    List<String> child = new ArrayList<>();

    CompilationUnit cu = StaticJavaParser.parse(code);
    FieldNameVisitor fieldNameVisitor = new FieldNameVisitor();
    fieldNameVisitor.visit(cu, null);
    List<String> fields = fieldNameVisitor.getFields();

    System.out.println("Fields:");
    for (String field : fields) {

      child.add(field);
    }

    return child;
  }

  class FieldNameVisitor extends VoidVisitorAdapter<Void> {
    private List<String> fields = new ArrayList<>();

    @Override
    public void visit(FieldDeclaration n, Void arg) {
      super.visit(n, arg);
      for (VariableDeclarator var : n.getVariables()) {
        System.out.println("Field Name: " + var.getNameAsString());
        fields.add(var.getNameAsString());
      }
    }

    public List<String> getFields() {
      return fields;
    }
  }
}
