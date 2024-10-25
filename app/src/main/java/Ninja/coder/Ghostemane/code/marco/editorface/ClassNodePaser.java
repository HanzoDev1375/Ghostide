package Ninja.coder.Ghostemane.code.marco.editorface;

import Ninja.coder.Ghostemane.code.utils.FileUtil;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.github.javaparser.printer.DefaultPrettyPrinter;
import java.util.Optional;

class ClassNodePaser {

  private String path;
  private String paster;

  public ClassNodePaser(String path, String paster) {
    this.path = path;
    this.paster = paster;
  }

  void init() {
    FileUtil.writeFile(path + findClassName(paster) + ".java", format(paster));
  }

  private String findClassName(String javaCode) throws Exception {
    var cu = StaticJavaParser.parse(javaCode);
    Optional<ClassOrInterfaceDeclaration> firstClass =
        cu.findFirst(ClassOrInterfaceDeclaration.class);
    return firstClass.map(ClassOrInterfaceDeclaration::getNameAsString).orElse("Main");
  }

  static String format(String code) {
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
