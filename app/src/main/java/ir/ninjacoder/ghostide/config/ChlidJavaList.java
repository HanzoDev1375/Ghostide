package ir.ninjacoder.ghostide.config;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import android.graphics.Color;
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
            listJava.add(new JavaModel("Method ", n.getNameAsString(), Color.YELLOW));
          }

          @Override
          public void visit(EnumDeclaration n, Void arg) {
            super.visit(n, arg);
            listJava.add(
                new JavaModel("Enum ", n.getNameAsString(), Color.parseColor("#FFFF3784")));
          }

          @Override
          public void visit(VariableDeclarator n, Void arg) {
            super.visit(n, arg);
            listJava.add(
                new JavaModel("Variable ", n.getNameAsString(), Color.parseColor("#FFFF8737")));
          }

          @Override
          public void visit(AnnotationDeclaration n, Void arg1) {
            super.visit(n, arg1);
            listJava.add(
                new JavaModel("Annotation ", n.getNameAsString(), Color.parseColor("#FFFFD437")));
          }

          @Override
          public void visit(ClassOrInterfaceType n, Void arg1) {
            super.visit(n, arg1);
            listJava.add(new JavaModel("Class ", n.getNameAsString(), Color.BLUE));
          }

          @Override
          public void visit(ConstructorDeclaration n, Void arg1) {
            super.visit(n, arg1);
            listJava.add(new JavaModel("Constructor ", n.getNameAsString(), Color.CYAN));
          }

          @Override
          public void visit(PackageDeclaration n, Void arg1) {
            super.visit(n, arg1);
            listJava.add(new JavaModel("Package ", n.getNameAsString(), Color.RED));
          }

          @Override
          public void visit(TypeParameter n, Void arg1) {
            super.visit(n, arg1);
            listJava.add(new JavaModel("TypeParameter ", n.getNameAsString(), Color.CYAN));
          }
        },
        null);
  }

  public static List<String> getPhpMethodsList(Context context) {
    String appLibDirPath = context.getApplicationInfo().nativeLibraryDir;
    String phpLibPath = appLibDirPath + "/libphp-8.2.8.so";

    List<String> methods = new ArrayList<>();

    try {
      Process process = Runtime.getRuntime().exec(new String[] {"objdump", "-T", phpLibPath});
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains(".text") && line.contains("g    DF")) {
          String[] parts = line.split("\\s+");
          if (parts.length > 5) {
            methods.add(parts[parts.length - 1]);
          }
        }
      }

      reader.close();
      Collections.sort(methods);

    } catch (Exception e) {
      e.printStackTrace();
      methods.add("Error: " + e.getMessage());
    }

    return methods;
  }
}
