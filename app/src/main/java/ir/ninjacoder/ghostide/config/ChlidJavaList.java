package ir.ninjacoder.ghostide.config;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.EnumDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.TypeExpr;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import ir.ninjacoder.ghostide.model.JavaModel;
import java.util.ArrayList;
import java.util.List;

public class ChlidJavaList {

  private String code;
  private List<JavaModel> listJava = new ArrayList<>();

  public ChlidJavaList(String code, List<JavaModel> listJava) {
    this.code = code;
    this.listJava = listJava;
    run();
  }

  void run() {
    var cu = StaticJavaParser.parse(code);
    cu.accept(
        new VoidVisitorAdapter<Void>() {
          @Override
          public void visit(MethodDeclaration n, Void arg) {
            super.visit(n, arg);
            listJava.add(new JavaModel("Method ", n.getNameAsString()));
          }

          @Override
          public void visit(EnumDeclaration n, Void arg) {
            super.visit(n, arg);
            listJava.add(new JavaModel("Enum ", n.getNameAsString()));
          }

          @Override
          public void visit(VariableDeclarator n, Void arg) {
            super.visit(n, arg);
            listJava.add(new JavaModel("Variable ", n.getNameAsString()));
          }

          @Override
          public void visit(AnnotationDeclaration n, Void arg1) {
            super.visit(n, arg1);
            listJava.add(new JavaModel("Annotation ", n.getNameAsString()));
          }

          @Override
          public void visit(ClassOrInterfaceType n, Void arg1) {
            super.visit(n, arg1);
            listJava.add(new JavaModel("Class ", n.getNameAsString()));
          }

          @Override
          public void visit(ConstructorDeclaration n, Void arg1) {
            super.visit(n, arg1);
            listJava.add(new JavaModel("Constructor ", n.getNameAsString()));
          }

          @Override
          public void visit(PackageDeclaration n, Void arg1) {
            super.visit(n, arg1);
            listJava.add(new JavaModel("Package ", n.getNameAsString()));
          }

          @Override
          public void visit(TypeParameter n, Void arg1) {
            super.visit(n, arg1);

            listJava.add(new JavaModel("TypeParameter ", n.getNameAsString()));
          }
        },
        null);
  }
}
