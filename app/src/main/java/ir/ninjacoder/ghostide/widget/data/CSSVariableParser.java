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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import static io.github.rosemoe.sora.langs.xml.analyzer.Utils.setSpanEFO2;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.jsoup.Jsoup;

public class CSSVariableParser {

  private final IdeEditor outputEditText;
  private int line, col;
  private final int VARIABLE_NAME_COLOR = Color.TRANSPARENT;
  private final int DEFAULT_VALUE_COLOR = Color.TRANSPARENT;

  public CSSVariableParser(IdeEditor editText) {
    this.outputEditText = editText;
  }

  public void highlightVariables(TextAnalyzeResult result, String cssContent) {
    var doc = Jsoup.parse(cssContent);
	var variables = parseCSSVariables(cssContent);
	var d = doc.select("style");
	d.forEach(ic ->{
		highlightVariableUsages(result,ic.data(),variables);
	});
    highlightVariableUsages(result, cssContent, variables);
  }

  private void highlightVariableUsages(
      TextAnalyzeResult result, String cssContent, Map<String, VariableInfo> variables) {
    Pattern pattern = Pattern.compile("var\\(\\s*(--[a-zA-Z0-9-]+)\\s*\\)");
    Matcher matcher = pattern.matcher(cssContent);
    int[] lineOffsets = calculateLineOffsets(cssContent);

    while (matcher.find()) {
      String varName = matcher.group(1);
      if (variables.containsKey(varName)) {
        int start = matcher.start(1); 
        int[] lineCol = getExactLineColumn(lineOffsets, start);
        int line = lineCol[0];
        int col = lineCol[1];
        int color =
            variables.get(varName).value != null
                ? parseColorFromValue(variables.get(varName).value)
                : VARIABLE_NAME_COLOR;
        setSpanEFO2(result, line, col, color, true, false);
      }
    }
  }

  private int[] calculateLineOffsets(String text) {
    List<Integer> offsets = new ArrayList<>();
    offsets.add(0);
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == '\n') {
        offsets.add(i + 1);
      }
    }
    return offsets.stream().mapToInt(i -> i).toArray();
  }

  private int[] getExactLineColumn(int[] lineOffsets, int position) {
    int line = 1;
    for (; line < lineOffsets.length; line++) {
      if (lineOffsets[line] > position) {
        break;
      }
    }
    line--;
    int col = position - lineOffsets[line] + 1;
    return new int[] {line + 1, col};
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

      if (value.startsWith("#")) {
        if (value.length() == 4) {
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

      if (value.startsWith("rgb(") || value.startsWith("rgba(")) {
        String[] parts = value.replaceAll("[rgba()]", "").split(",");
        int r = Integer.parseInt(parts[0].trim());
        int g = Integer.parseInt(parts[1].trim());
        int b = Integer.parseInt(parts[2].trim());
        int a = parts.length > 3 ? (int) (Float.parseFloat(parts[3].trim()) * 255) : 255;
        return Color.argb(a, r, g, b);
      }

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
