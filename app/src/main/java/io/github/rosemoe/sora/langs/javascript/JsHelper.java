package io.github.rosemoe.sora.langs.javascript;

import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.tools.shell.Global;

public class JsHelper {
  public static List<String> getJsMethod(String code) {
    List<String> functionList = new ArrayList<>();
    Context context = Context.enter();
    try {
      String javascriptCode = code;
      Scriptable scope = new Global(context);
      context.evaluateString(scope, javascriptCode, "inline", 1, null);
      Object functionObj = scope.get("add", scope);
      if (functionObj instanceof Function) {
        Function function = (Function) functionObj;
        String functionAsString = function.toString();
        functionList.add(functionAsString);
      }
    } finally {
      Context.exit();
    }
    return functionList;
  }
}
