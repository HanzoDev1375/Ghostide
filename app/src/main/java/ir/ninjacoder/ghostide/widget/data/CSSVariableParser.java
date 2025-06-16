package ir.ninjacoder.ghostide.widget.data;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.EditText;
import com.helger.css.ECSSVersion;
import com.helger.css.decl.*;
import com.helger.css.reader.CSSReader;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import ir.ninjacoder.ghostide.IdeEditor;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import static io.github.rosemoe.sora.langs.xml.analyzer.Utils.setSpanEFO2;

public class CSSVariableParser {

  private final IdeEditor outputEditText;
  private int line, col;
  private final int VARIABLE_NAME_COLOR = Color.parseColor("#FF00FF"); // بنفش برای نام متغیرها
  private final int DEFAULT_VALUE_COLOR = Color.parseColor("#000000"); // سیاه برای مقادیر نامعتبر

  public CSSVariableParser(IdeEditor editText) {
    this.outputEditText = editText;
  }

  public void highlightVariables(TextAnalyzeResult result, String cssContent) {
    Map<String, VariableInfo> variables = parseCSSVariables(cssContent);

    for (Map.Entry<String, VariableInfo> entry : variables.entrySet()) {
      String varName = entry.getKey();
      VariableInfo varInfo = entry.getValue();
      int color = parseColorFromValue(varInfo.value);
      setSpanEFO2(result, varInfo.line, varInfo.col, color, true, false);
    }
  }

  private Map<String, VariableInfo> parseCSSVariables(String cssContent) {
    Map<String, VariableInfo> variables = new HashMap<>();
    try {
      CascadingStyleSheet css =
          CSSReader.readFromString(cssContent, StandardCharsets.UTF_8, ECSSVersion.CSS30);
      if (css != null) {
        for (ICSSTopLevelRule rule : css.getAllRules()) {
          if (rule instanceof CSSStyleRule) {
            CSSStyleRule styleRule = (CSSStyleRule) rule;
            for (CSSDeclaration declaration : styleRule.getAllDeclarations()) {
              String property = declaration.getProperty();
              if (property.startsWith("--")) {
                CSSExpression expression = declaration.getExpression();
                int line = declaration.getSourceLocation().getLastTokenBeginLineNumber();
                int col = declaration.getSourceLocation().getLastTokenBeginColumnNumber();
                if (expression != null) {
                  variables.put(
                      property, new VariableInfo(expression.getAsCSSString().trim(), line, col));
                }
              }
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return variables;
  }

  private int parseColorFromValue(String value) {
    try {
      // پردازش رنگ‌های HEX
      if (value.startsWith("#")) {
        if (value.length() == 4) { // فرمت کوتاه (#RGB)
          value =
              "#"
                  + value.charAt(1)
                  + value.charAt(1)
                  + value.charAt(2)
                  + value.charAt(2)
                  + value.charAt(3)
                  + value.charAt(3);
        }
        return Color.parseColor(value);
      }

      // پردازش rgb() و rgba()
      if (value.startsWith("rgb(") || value.startsWith("rgba(")) {
        String[] parts = value.replaceAll("[rgba()]", "").split(",");
        int r = Integer.parseInt(parts[0].trim());
        int g = Integer.parseInt(parts[1].trim());
        int b = Integer.parseInt(parts[2].trim());
        int a = parts.length > 3 ? (int) (Float.parseFloat(parts[3].trim()) * 255) : 255;
        return Color.argb(a, r, g, b);
      }

      // پردازش نام رنگ‌ها (مثل red, blue)
      return Color.parseColor(value.toLowerCase());
    } catch (Exception e) {
      return DEFAULT_VALUE_COLOR;
    }
  }

  class VariableInfo {
    String value;
    int line;
    int col;

    public VariableInfo(String value, int line, int col) {
      this.value = value;
      this.line = line;
      this.col = col;
    }
  }
}
