package lsp4custom.com.ninjacoder.customhtmllsp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.rosemoe.sora.langs.javascript.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import lsp4custom.com.ninjacoder.customhtmllsp.js.JsKind;
import lsp4custom.com.ninjacoder.customhtmllsp.js.NodeJsModel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JavaScriptParserHelper {

  public static synchronized List<NodeJsModel> getCompletion(String jsCode, String prefix,int d,int f) {
    List<String> logs = new ArrayList<>();
    try {
      logs.add("=== شروع پردازش کد ===");
      logs.add("پریفیکس: " + prefix);

      CharStream input = CharStreams.fromString(jsCode);
      JavaScriptLexer lexer = new JavaScriptLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      tokens.fill();

      JavaScriptParser parser = new JavaScriptParser(tokens);
      EnhancedCompletionListener listener = new EnhancedCompletionListener(logs);
      ParseTreeWalker walker = new ParseTreeWalker();
      walker.walk(listener, parser.program());

      if (prefix != null && prefix.contains(".")) {
        int lastDot = prefix.lastIndexOf('.');
        String variableName = (lastDot != -1) ? prefix.substring(0, lastDot) : prefix;
        logs.add("جستجوی اعضای متغیر: " + variableName);

        List<NodeJsModel> members = listener.getClassMembersForVariable(variableName);
        logs.add("اعضای کلاس برگردانده شد: " + members.size() + " عضو");
        saveLogJson(logs);
        return members;
      }

      List<NodeJsModel> all = listener.getAllAvailableSuggestions();
      logs.add("تمام پیشنهادات جمع‌آوری شد: " + all.size() + " پیشنهاد");
      saveLogJson(logs);
      return all;

    } catch (Exception e) {
      logs.add("Exception: " + e.getMessage());
      saveLogJson(logs);
      e.printStackTrace();
      return getDefaultSuggestions();
    }
  }

  private static void saveLogJson(List<String> logs) {
    try (FileWriter writer = new FileWriter("/sdcard/apk/log.json")) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      gson.toJson(logs, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static List<NodeJsModel> getDefaultSuggestions() {
    List<NodeJsModel> suggestions = new ArrayList<>();
    suggestions.add(new NodeJsModel("toString", JsKind.Method));
    suggestions.add(new NodeJsModel("valueOf", JsKind.Method));
    suggestions.add(new NodeJsModel("length", JsKind.Property));
    suggestions.add(new NodeJsModel("constructor", JsKind.Property));
    suggestions.add(new NodeJsModel("push", JsKind.Method));
    suggestions.add(new NodeJsModel("pop", JsKind.Method));
    suggestions.add(new NodeJsModel("forEach", JsKind.Method));
    suggestions.add(new NodeJsModel("map", JsKind.Method));
    suggestions.add(new NodeJsModel("filter", JsKind.Method));
    return suggestions;
  }

  private static class EnhancedCompletionListener extends JavaScriptParserBaseListener {

    private final List<String> logs;
    private final Map<String, List<NodeJsModel>> classMembers = new HashMap<>();
    private final Map<String, String> variableTypes = new HashMap<>();
    private String currentClass = null;

    public EnhancedCompletionListener(List<String> logs) {
      this.logs = logs;
    }

    @Override
    public void enterClassDeclaration(JavaScriptParser.ClassDeclarationContext ctx) {
      try {
        String className = ctx.identifier() != null ? ctx.identifier().getText() : "AnonymousClass";
        classMembers.putIfAbsent(className, new ArrayList<>());
        classMembers.get(className).add(new NodeJsModel(className, JsKind.Class));
        currentClass = className;
        logs.add("کلاس پیدا شد: " + className);
      } catch (Exception e) {
        logs.add("Exception in enterClassDeclaration: " + e.getMessage());
      }
    }

    @Override
    public void exitClassDeclaration(JavaScriptParser.ClassDeclarationContext ctx) {
      currentClass = null;
    }

    @Override
    public void enterMethodDefinition(JavaScriptParser.MethodDefinitionContext ctx) {
      try {
        if (currentClass != null) {
          String methodName = ctx.classElementName().getText();
          classMembers.get(currentClass).add(new NodeJsModel(methodName, JsKind.Method));
          logs.add("متد اضافه شد: " + methodName + " به کلاس " + currentClass);
        }
      } catch (Exception e) {
        logs.add("Exception in enterMethodDefinition: " + e.getMessage());
      }
    }

    @Override
    public void enterFieldDefinition(JavaScriptParser.FieldDefinitionContext ctx) {
      try {
        if (currentClass != null) {
          String fieldName = ctx.classElementName().getText();
          classMembers.get(currentClass).add(new NodeJsModel(fieldName, JsKind.Property));
          logs.add("فیلد اضافه شد: " + fieldName + " به کلاس " + currentClass);
        }
      } catch (Exception e) {
        logs.add("Exception in enterFieldDefinition: " + e.getMessage());
      }
    }

    @Override
    public void enterVariableDeclaration(JavaScriptParser.VariableDeclarationContext ctx) {
      try {
        if (ctx.assignable() != null && ctx.assignable().getText() != null) {
          String varName = ctx.assignable().getText();
          logs.add("متغیر پیدا شد: " + varName);

          if (ctx.singleExpression() != null) {
            String className = extractClassNameFromExpression(ctx.singleExpression());
            if (className != null) {
              variableTypes.put(varName, className);
              logs.add("متغیر " + varName + " از نوع: " + className);
            }
          }
        }
      } catch (Exception e) {
        logs.add("Exception in enterVariableDeclaration: " + e.getMessage());
      }
    }

    private String extractClassNameFromExpression(JavaScriptParser.SingleExpressionContext ctx) {
      // new MyClass()
      if (ctx instanceof JavaScriptParser.NewExpressionContext) {
        JavaScriptParser.NewExpressionContext newCtx = (JavaScriptParser.NewExpressionContext) ctx;
        String text = newCtx.getText().substring(4).trim(); // حذف "new "
        int paren = text.indexOf('(');
        if (paren != -1) text = text.substring(0, paren).trim();
        return text;
      }
      return null;
    }

    public List<NodeJsModel> getClassMembersForVariable(String variableName) {
      if (variableTypes.containsKey(variableName)) {
        String className = variableTypes.get(variableName);
        if (classMembers.containsKey(className)) {
          return classMembers.get(className);
        }
      }
      return getDefaultSuggestions();
    }

    public List<NodeJsModel> getAllAvailableSuggestions() {
      Set<NodeJsModel> all = new LinkedHashSet<>();
      for (List<NodeJsModel> list : classMembers.values()) {
        all.addAll(list);
      }
      for (String var : variableTypes.keySet()) {
        all.add(new NodeJsModel(var, JsKind.Var));
      }
      all.addAll(getDefaultSuggestions());
      return new ArrayList<>(all);
    }
  }
}
