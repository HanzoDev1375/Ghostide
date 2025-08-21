package io.github.rosemoe.sora.widget;

import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.marco.RegexUtilCompat;
import ir.ninjacoder.ghostide.utils.DataUtil;
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

  public static void getNumberColor(Token token, int line, int column, TextAnalyzeResult result) {
    String text = token.getText();
    var colors = result;

    try {
      int color = 0;
      if (text.matches("\\d{1,3}\\%?\\s*,\\s*\\d{1,3}\\%?\\s*,\\s*\\d{1,3}\\%?")) {
        String[] values = text.split("\\s*,\\s*");

        if (values.length == 3) {
          int r = parseColorValue(values[0].trim());
          int g = parseColorValue(values[1].trim());
          int b = parseColorValue(values[2].trim());

          r = Math.max(0, Math.min(255, r));
          g = Math.max(0, Math.min(255, g));
          b = Math.max(0, Math.min(255, b));

          color = Color.rgb(r, g, b);
          System.out.println("Color from numbers: " + "r: " + r + " g: " + g + " b: " + b);

          colors.addIfNeeded(line, column, EditorColorScheme.LITERAL);

          Span span =
              Span.obtain(
                  column,
                  TextStyle.makeStyle(
                      ColorUtils.calculateLuminance(color) > 0.5
                          ? EditorColorScheme.black
                          : EditorColorScheme.white,
                      0,
                      false,
                      true,
                      false,
                      false,
                      true));

          if (span != null) {
            span.setBackgroundColorMy(color);
            colors.add(line, span);
          }

          // Setting the span to cover whole text
          Span fullTextSpan =
              Span.obtain(
                  column + text.length(),
                  TextStyle.makeStyle(
                      ColorUtils.calculateLuminance(color) > 0.5
                          ? EditorColorScheme.black
                          : EditorColorScheme.white,
                      0,
                      false,
                      true,
                      false,
                      false,
                      true));

          fullTextSpan.setBackgroundColorMy(color);
          colors.add(line, fullTextSpan);

          Span endSpan =
              Span.obtain(
                  column + text.length(), TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));

          endSpan.setBackgroundColorMy(Color.TRANSPARENT);
          colors.add(line, endSpan);
        } else {
          throw new IllegalArgumentException("Invalid number color format");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  private static int parseColorValue(String value) {
    if (value.endsWith("%")) {
      double percent = Double.parseDouble(value.substring(0, value.length() - 1));
      return (int) Math.round(percent * 2.55); 
    } else {
      return Integer.parseInt(value);
    }
  }

  public static void getHexColor(Token token, int line, int column, TextAnalyzeResult result) {
    var text1 = token.getText();
    var colors = result;

    try {
      int color = 0;
      if (text1.startsWith("rgb") || text1.startsWith("hsl")) {
        String rgbValues = text1.substring(4, text1.length() - 1);
        String[] rgb = rgbValues.split(",");
        if (rgb.length == 3) {
          int r = Integer.parseInt(rgb[0].trim());
          int g = Integer.parseInt(rgb[1].trim());
          int b = Integer.parseInt(rgb[2].trim());
          r = Math.max(0, Math.min(255, r));
          g = Math.max(0, Math.min(255, g));
          b = Math.max(0, Math.min(255, b));
          color = Color.rgb(r, g, b);
          System.out.println("Color rgb : " + "r: " + r + " g: " + g + " b: " + b);

          colors.addIfNeeded(line, column, EditorColorScheme.LITERAL);

          Span span =
              Span.obtain(
                  column,
                  TextStyle.makeStyle(
                      ColorUtils.calculateLuminance(color) > 0.5
                          ? EditorColorScheme.black
                          : EditorColorScheme.white,
                      0,
                      false,
                      true,
                      false,
                      false,
                      true));
          if (span != null) {
            span.setBackgroundColorMy(color);
            colors.add(line, span);
          }

          // Setting the span to cover whole text
          Span fullTextSpan =
              Span.obtain(
                  column + text1.length(),
                  TextStyle.makeStyle(
                      ColorUtils.calculateLuminance(color) > 0.5
                          ? EditorColorScheme.black
                          : EditorColorScheme.white,
                      0,
                      false,
                      true,
                      false,
                      false,
                      true));
          fullTextSpan.setBackgroundColorMy(color);
          colors.add(line, fullTextSpan);

          Span endSpan =
              Span.obtain(
                  column + text1.length(), TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
          endSpan.setBackgroundColorMy(Color.TRANSPARENT);
          colors.add(line, endSpan);
        } else {
          throw new IllegalArgumentException("Invalid RGB format");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    // getHslColor(token,line,column,result);
  }

  public static void setColorBinery(Token token, int line, int column, TextAnalyzeResult result) {
    var text = token.getText();
    int color;
    try {

      if (text.startsWith("0x")) {
        color = Color.parseColor(text.replace("0x", "#"));
        result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
        Span span =
            Span.obtain(
                column,
                ColorUtils.calculateLuminance(color) > 0.5
                    ? EditorColorScheme.black
                    : EditorColorScheme.white);
        span.setBackgroundColorMy(color);
        result.add(line, span);
        Span middle = Span.obtain(column + text.length(), EditorColorScheme.LITERAL);
        middle.setBackgroundColorMy(Color.TRANSPARENT);
        result.add(line, middle);
        Span end =
            Span.obtain(column + text.length(), TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
        end.setBackgroundColorMy(Color.TRANSPARENT);
        result.add(line, end);
      }
    } catch (Exception e) {

    }
  }

  public static void getHslColor(Token token, int line, int column, TextAnalyzeResult result) {
    var text1 = token.getText();
    var colors = result;

    try {
      if (text1.startsWith("hsla") || text1.startsWith("rgba")) {
        String rgbValues = text1.substring(5, text1.length() - 1);
        String[] hsl = rgbValues.split(",");
        if (hsl.length >= 3) {
          float h = Float.parseFloat(hsl[0].trim()); // Hue
          float s = Float.parseFloat(hsl[1].trim().replace("%", "")) / 100f; // Saturation
          float l = Float.parseFloat(hsl[2].trim().replace("%", "")) / 100f; // Lightness
          float alpha =
              (hsl.length == 4) ? Float.parseFloat(hsl[3].trim()) : 1.0f; // Alpha (شفافیت)

          // تبدیل HSL به HSV
          float[] hsv = new float[3];
          hslToHsv(h, s, l, hsv);
          int color = Color.HSVToColor(hsv); // تبدیل به RGB

          // اگر شفافیت وجود داشته باشد
          if (alpha < 1.0f) {
            color =
                Color.argb(
                    Math.round(alpha * 255),
                    Color.red(color),
                    Color.green(color),
                    Color.blue(color));
          }

          System.out.println(
              "Color hsl : " + "h: " + h + " s: " + s + " l: " + l + " alpha: " + alpha);

          colors.addIfNeeded(line, column, EditorColorScheme.LITERAL);

          Span span =
              Span.obtain(
                  column,
                  TextStyle.makeStyle(
                      ColorUtils.calculateLuminance(color) > 0.5
                          ? EditorColorScheme.black
                          : EditorColorScheme.white,
                      0,
                      false,
                      true,
                      false,
                      false,
                      true));
          if (span != null) {
            span.setBackgroundColorMy(color);
            colors.add(line, span);
          }

          // تنظیم span برای پوشش کل متن
          Span fullTextSpan =
              Span.obtain(
                  column + text1.length(),
                  TextStyle.makeStyle(
                      ColorUtils.calculateLuminance(color) > 0.5
                          ? EditorColorScheme.black
                          : EditorColorScheme.white,
                      0,
                      false,
                      true,
                      false,
                      false,
                      true));
          fullTextSpan.setBackgroundColorMy(color);
          colors.add(line, fullTextSpan);

          Span endSpan =
              Span.obtain(
                  column + text1.length(), TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
          endSpan.setBackgroundColorMy(Color.TRANSPARENT);
          colors.add(line, endSpan);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // تابع برای تبدیل HSL به HSV
  private static void hslToHsv(float h, float s, float l, float[] hsv) {
    float v = l + s * Math.min(l, 1 - l);
    float newS = v == 0 ? 0 : (2 * (1 - (l / v)));
    hsv[0] = h; // Hue
    hsv[1] = newS; // Saturation
    hsv[2] = v; // Value
  }

  public static void initColor(
      Token token, int line, int column, TextAnalyzeResult result, boolean using) {}

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
