package lsp4custom.com.ninjacoder.customhtmllsp;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.github.javaparser.printer.DefaultPrettyPrinter;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import io.github.rosemoe.sora.data.CompletionItem;
import java.io.StringReader;
import java.util.List;

public class JavaCardshorts extends Css3Server {

  private List<CompletionItem> item;

  private String prf;

  public JavaCardshorts(List<CompletionItem> item, String prf) {
    this.item = item;
    this.prf = prf;
    asChild();
  }

  void asChild() {
    boolean isLen = prf.length() > 0;
    if ("forloop".startsWith(prf) && isLen) {
      item.add(css("forloop", "forloop", forLoop()));
    }
    if ("foreach".startsWith(prf) && isLen) {
      item.add(css("foreach", "foreach", format(forEachLoop())));
    }
    if ("trycatch".startsWith(prf) && isLen) {
      item.add(css("trycatch", "trycatch", tryCatchBlock()));
    }
    if ("ifStatement".startsWith(prf) && isLen) {
      item.add(css("ifStatement", "ifStatement", ifStatement()));
    }
    if ("switchStatement".startsWith(prf) && isLen) {
      item.add(css("switchStatement", "switchStatement", switchStatement()));
    }

    if ("methodDefinition".startsWith(prf) && isLen) {
      item.add(css("methodDefinition", "methodDefinition", methodDefinition()));
    }
    if ("classDefinition".startsWith(prf) && isLen) {
      item.add(css("classDefinition", "classDefinition", classDefinition()));
    }
    if ("mainMethod".startsWith(prf) && isLen) {
      item.add(css("mainMethod", "mainMethod", mainMethod()));
    }
  }

  private String forLoop() {
    return """
    for(int i = 0; i < count; ++i) {
        // TODO: implement logic here
    }
    """;
  }

  private String forEachLoop() {
    return """
    for(var element : iterable) {
        // TODO: process element
    }
    """;
  }

  private String tryCatchBlock() {
    return """
    try {
        // TODO: risky operation
    } catch(Exception err) {
        // TODO: handle exception
    }
    """;
  }

  String ifStatement() {
    return """
    if(condition) {
        // TODO: implement logic when condition is true
    } else {
        // TODO: implement logic when condition is false (optional)
    }
    """;
  }

  private String switchStatement() {
    return """
    switch(variable) {
        case value1:
            // TODO: handle case 1
            break;
        case value2:
            // TODO: handle case 2
            break;
        default:
            // TODO: handle default case
            break;
    }
    """;
  }

  private String methodDefinition() {
    return """
    public int methodName(int parameter) {
        // TODO: implement method logic
      return parameter;
    }
    """;
  }

  private String classDefinition() {
    return """
    public class ClassName {
        // TODO: define class members and methods
    }
    """;
  }

  private String mainMethod() {
    return """
    public static void main(String[] args) {
        // TODO: implement main logic
    }
    """;
  }

  String format(String code) {
    try {
      CompilationUnit cu = StaticJavaParser.parse(code);

      DefaultPrinterConfiguration configuration = new DefaultPrinterConfiguration();
      DefaultPrettyPrinter printer = new DefaultPrettyPrinter(configuration);

      String formattedCode = printer.print(cu);
      System.out.println(formattedCode);
      return formattedCode;
    } catch (Throwable t) {
      System.err.println("An error occurred during code formatting: " + t.getMessage());
      return code; // Return the original code if an error occurs
    }
  }
}
