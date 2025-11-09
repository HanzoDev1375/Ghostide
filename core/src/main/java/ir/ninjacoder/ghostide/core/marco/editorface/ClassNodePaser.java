package ir.ninjacoder.ghostide.core.marco.editorface;

import android.content.SharedPreferences;
import android.util.Log;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.comments.JavadocComment;
import com.github.javaparser.printer.DefaultPrettyPrinter;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import ir.ninjacoder.ghostide.core.utils.FileUtil;

public class ClassNodePaser {

  private String path;
  private String javaCode;
  private SharedPreferences unitCommentName;
  public ClassNodePaser(
      String path, String javaCode, String authorName, String additionalComments) {
    this.path = path;
    this.javaCode = addAuthorComment(javaCode, authorName, additionalComments);
    init();
  }

  public ClassNodePaser(String path, String javaCode) {
    this.path = path;
    this.javaCode = addAuthorComment(javaCode, "Ninjacoder", "Comment by ghost ide");
    init();
  }

  void init() {
    try {
      String packagePath = findPackageName(javaCode);
      if (!packagePath.isEmpty()) {
        createDirectory(Paths.get(path, packagePath));
      }
      String className = findClassName(javaCode);

      FileUtil.writeFile(
          Paths.get(path, packagePath, className + ".java").toString(), format(javaCode));
      Log.w("Class Mod : ", Paths.get(path, packagePath, className + ".java").toString());
    } catch (Exception err) {
      Log.e("Error", "An error occurred during initialization: " + err.getMessage());
    }
  }

  private void createDirectory(Path dirPath) throws Exception {
    if (!Files.exists(dirPath)) {
      Files.createDirectories(dirPath);
      Log.i("Directory Created", dirPath.toString());
    }
  }

  private String findPackageName(String javaCode) throws Exception {
    var cu = StaticJavaParser.parse(javaCode);
    Optional<PackageDeclaration> packageDeclaration = cu.findFirst(PackageDeclaration.class);
    return packageDeclaration.map(pd -> pd.getNameAsString().replace(".", "/")).orElse("");
  }

  private String findClassName(String javaCode) throws Exception {
    var cu = StaticJavaParser.parse(javaCode);
    Optional<ClassOrInterfaceDeclaration> firstClass =
        cu.findFirst(ClassOrInterfaceDeclaration.class);
    return firstClass.map(ClassOrInterfaceDeclaration::getNameAsString).orElse("Main");
  }

  private String addAuthorComment(String javaCode, String authorName, String additionalComments) {
    CompilationUnit cu = StaticJavaParser.parse(javaCode);
    StringBuilder builder = new StringBuilder();
    builder.append(additionalComments).append("\n");
    builder.append("@author: ").append(authorName).append("\n");
    JavadocComment javadoc = new JavadocComment(builder.toString());
    cu.setComment(javadoc);
    return cu.toString();
  }

  String format(String code) {
    try {
      var cu = StaticJavaParser.parse(code);
      var configuration = new DefaultPrinterConfiguration();
      var printer = new DefaultPrettyPrinter(configuration);
      return printer.print(cu);
    } catch (Throwable t) {
      System.err.println("An error occurred during code formatting: " + t.getMessage());
      return code;
    }
  }
}
