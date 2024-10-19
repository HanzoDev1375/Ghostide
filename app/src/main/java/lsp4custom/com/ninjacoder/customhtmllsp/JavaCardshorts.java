package lsp4custom.com.ninjacoder.customhtmllsp;

import io.github.rosemoe.sora.data.CompletionItem;
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
      item.add(css("foreach", "foreach", forEachLoop()));
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
    for(element : iterable) {
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
}
