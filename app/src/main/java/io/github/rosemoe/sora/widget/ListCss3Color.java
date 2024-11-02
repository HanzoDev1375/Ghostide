package io.github.rosemoe.sora.widget;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import Ninja.coder.Ghostemane.code.marco.RegexUtilCompat;
import Ninja.coder.Ghostemane.code.utils.DataUtil;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.Log;
import androidx.core.graphics.ColorUtils;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.antlr.v4.runtime.Token;

public class ListCss3Color {
  private static List<Map<String, String>> colorList = new ArrayList<>();

  public static void getColor(
      Token token, int line, int column, TextAnalyzeResult result, int color) {

    try {
      result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
      int wordLength = token.getText().length(); // طول کلمه‌ی به رنگ قرمز
      int endOfRed = column + wordLength;
      // test
      String tokenText = token.getText();

      // چک کردن اینکه آیا کلمه فقط حروف انگلیسی است
      if (tokenText.matches("\\b[a-z]+\\b")) {

        if (ColorUtils.calculateLuminance(color) > 0.5) {
          Span span =
              Span.obtain(
                  column,
                  TextStyle.makeStyle(
                      EditorColorScheme.black, 0, false, false, false, false, true));
          if (span != null) {

            span.setBackgroundColorMy(color);
            result.add(line, span);
          }
        } else if (ColorUtils.calculateLuminance(color) <= 0.5) {
          Span span =
              Span.obtain(
                  column,
                  TextStyle.makeStyle(
                      EditorColorScheme.TEXT_NORMAL, 0, false, false, false, false, true));
          if (span != null) {

            span.setBackgroundColorMy(color);
            result.add(line, span);
          }
        }

        Span middle = Span.obtain(endOfRed, EditorColorScheme.LITERAL);

        middle.setBackgroundColorMy(Color.TRANSPARENT);
        result.add(line, middle);

        Span end = Span.obtain(endOfRed, TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));

        end.setBackgroundColorMy(Color.TRANSPARENT);
        result.add(line, end);
      }
    } catch (Exception ignore) {
      result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
    }
  }

  public static void getHexColor(Token token, int line, int column, TextAnalyzeResult result) {
    var text1 = token.getText();
    var colors = result;
    try {
      int color = Color.parseColor("\"" + text1 + "\"");
      colors.addIfNeeded(line, column, EditorColorScheme.LITERAL);
      if (ColorUtils.calculateLuminance(color) > 0.5) {
        Span span =
            Span.obtain(
                column + 1,
                TextStyle.makeStyle(EditorColorScheme.black, 0, false, false, false, false, true));
        if (span != null) {
          span.setBackgroundColorMy(color);
          colors.add(line, span);
        }
      } else if (ColorUtils.calculateLuminance(color) <= 0.5) {
        Span span =
            Span.obtain(
                column + 1,
                TextStyle.makeStyle(
                    EditorColorScheme.TEXT_NORMAL, 0, false, false, false, false, true));
        if (span != null) {
          span.setBackgroundColorMy(color);
          colors.add(line, span);
        }
      }

      Span middle = Span.obtain(column + text1.length() - 1, EditorColorScheme.LITERAL);
      middle.setBackgroundColorMy(Color.TRANSPARENT);
      colors.add(line, middle);

      Span end =
          Span.obtain(column + text1.length(), TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
      end.setBackgroundColorMy(Color.TRANSPARENT);
      colors.add(line, end);

    } catch (Exception ignore) {
      ignore.printStackTrace();
    }
  }

  public static void initColor(
      Token token, int line, int column, TextAnalyzeResult result, boolean using) {
    var text = token.getText();

    if (using) {

      try {
        var input = ApplicationLoader.getContext().getAssets().open("colors.json");
        colorList =
            new Gson()
                .fromJson(
                    DataUtil.copyFromInputStream(input),
                    new TypeToken<List<Map<String, String>>>() {}.getType());
        colorList.forEach(
            it -> {
              if (it.get("colorName") != null) {
                if (getRegex("\\b" + it.get("colorName") + "\\b", text)) {
                  getColor(token, line, column, result, Color.parseColor(it.get("cssColor")));
                }
              }
              
            });

      } catch (Exception err) {
        Log.e("ErrorColorNotFound", err.getLocalizedMessage());
      }
    }
  }

  public static long withoutCompletion(int id) {
    return TextStyle.makeStyle(id, 0, true, false, false, false, true);
  }

  public static long forString() {
    return TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, false, false);
  }

  public static boolean getRegex(String regex, String text) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    return matcher.matches();
  }
}
