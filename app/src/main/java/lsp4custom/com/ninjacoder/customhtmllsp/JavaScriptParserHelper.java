package lsp4custom.com.ninjacoder.customhtmllsp;

import io.github.rosemoe.sora.langs.javascript.JavaScriptLexer;
import io.github.rosemoe.sora.langs.javascript.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.ArrayList;
import java.util.List;

public class JavaScriptParserHelper {
  public static List<String> extractJavaScriptMethods(String jsCode) {
    List<String> methods = new ArrayList<>();

    CharStream input = CharStreams.fromString(jsCode);
    var lexer = new JavaScriptLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    JavaScriptParser parser = new JavaScriptParser(tokens);

    ParseTreeWalker walker = new ParseTreeWalker();
    JavaScriptMethodListener listener = new JavaScriptMethodListener();
    walker.walk(listener, parser.program());

    return listener.getMethods();
  }

  public static List<String> extractJavaScriptVariables(String jsCode) {
    List<String> variables = new ArrayList<>();

    CharStream input = CharStreams.fromString(jsCode);
    JavaScriptLexer lexer = new JavaScriptLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    JavaScriptParser parser = new JavaScriptParser(tokens);

    ParseTreeWalker walker = new ParseTreeWalker();
    JavaScriptVariableListener listener = new JavaScriptVariableListener();
    walker.walk(listener, parser.program());

    return listener.getVariables();
  }
}

class JavaScriptMethodListener extends JavaScriptParserBaseListener {
  private List<String> methods = new ArrayList<>();

  @Override
  public void enterFunctionDeclaration(JavaScriptParser.FunctionDeclarationContext ctx) {
    String methodName = ctx.identifier().getText();
    methods.add(methodName);
  }

  @Override
  public void enterMethodDefinition(JavaScriptParser.MethodDefinitionContext ctx) {
    String methodName = ctx.classElementName().getText();
    methods.add(methodName);
  }

  public List<String> getMethods() {
    return methods;
  }
}

class JavaScriptVariableListener extends JavaScriptParserBaseListener {
  private List<String> variables = new ArrayList<>();

  @Override
  public void enterVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
    String varName = ctx.assignable().getText();
    variables.add(varName);
  }

  public List<String> getVariables() {
    return variables;
  }
}
