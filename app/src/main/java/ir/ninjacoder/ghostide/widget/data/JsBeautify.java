package ir.ninjacoder.ghostide.widget.data;

import android.util.Log;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsBeautify {

  public static String jsBeautify(String jsCode) {
    Context rhinoContext = Context.enter();
    rhinoContext.setOptimizationLevel(-1);

    try {
      Scriptable scope = rhinoContext.initStandardObjects();
      try (InputStream isBeautify =
          GhostIdeAppLoader.getContext().getAssets().open("beautify.js")) {
        rhinoContext.evaluateReader(
            scope, new InputStreamReader(isBeautify), "beautify.js", 1, null);
      }
      Object check =
          rhinoContext.evaluateString(scope, "typeof js_beautify === 'function'", "check", 1, null);
      if (!check.equals(Boolean.TRUE)) {
        throw new RuntimeException("js_beautify not loaded correctly");
      }
      scope.put("jsCode", scope, jsCode);
      ///   scope.put("indentSize", scope, indentSize);
      Object result = rhinoContext.evaluateString(scope, "js_beautify(jsCode)", "inline", 1, null);

      return Context.toString(result);

    } catch (Exception e) {
      Log.e("Error", e.getLocalizedMessage());
    } finally {
      Context.exit();
    }
	return "";
  }
}
