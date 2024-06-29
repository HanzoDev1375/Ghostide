package io.github.rosemoe.sora.widget;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import androidx.core.graphics.ColorUtils;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.antlr.v4.runtime.Token;

public class ListCss3Color {

  public static void getColor(
      Token token, int line, int column, TextAnalyzeResult result, int color) {

    try {
      result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
      int wordLength = token.getText().length(); // طول کلمه‌ی به رنگ قرمز
      int endOfRed = column + wordLength;
      // test
      if (ColorUtils.calculateLuminance(color) > 0.5) {
        Span span =
            Span.obtain(
                column,
                TextStyle.makeStyle(EditorColorScheme.black, 0, false, false, false, false, true));
        if (span != null) {
          span.setUnderlineColor(color);
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
          span.setUnderlineColor(color);
          span.setBackgroundColorMy(color);
          result.add(line, span);
        }
      }

      Span middle = Span.obtain(endOfRed, EditorColorScheme.LITERAL);
      middle.setUnderlineColor(Color.TRANSPARENT);
      middle.setBackgroundColorMy(Color.TRANSPARENT);
      result.add(line, middle);

      Span end = Span.obtain(endOfRed, TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
      end.setUnderlineColor(Color.TRANSPARENT);
      end.setBackgroundColorMy(Color.TRANSPARENT);
      result.add(line, end);
    } catch (Exception ignore) {
      result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
    }
  }

  public static void getHexColor(Token token, int line, int column, TextAnalyzeResult result) {}

  public static void initColor(
      Token token, int line, int column, TextAnalyzeResult result, boolean using) {
    var text = token.getText();

    if (using) {

      if (text.equals("aliceblue")) {
        getColor(token, line, column, result, Color.parseColor("#F0F8FF"));
      } else if (text.equals("antiquewhite")) {
        getColor(token, line, column, result, Color.parseColor("#FAEBD7"));
      } else if (text.equals("aquamarine")) {
        getColor(token, line, column, result, Color.parseColor("#7FFFD4"));
      } else if (text.equals("azure")) {
        getColor(token, line, column, result, Color.parseColor("#F0FFFF"));
      } else if (text.equals("beige")) {
        getColor(token, line, column, result, Color.parseColor("#F5F5DC"));
      } else if (text.equals("bisque")) {
        getColor(token, line, column, result, Color.parseColor("#FFE4C4"));
      } else if (text.matches("\\bblack\\b")) {
        getColor(token, line, column, result, Color.parseColor("#000000"));
      } else if (text.equals("blanchedalmond")) {
        getColor(token, line, column, result, Color.parseColor("#FFEBCD"));
      } else if (text.equals("blue")) {
        getColor(token, line, column, result, Color.parseColor("#0062FF"));
      } else if (text.equals("blueviolet")) {
        getColor(token, line, column, result, Color.parseColor("#8A2BE2"));
      } else if (text.equals("brown")) {
        getColor(token, line, column, result, Color.parseColor("#A52A2A"));
      } else if (text.equals("burlywood")) {
        getColor(token, line, column, result, Color.parseColor("#DEB887"));
      } else if (text.equals("cadetblue")) {
        getColor(token, line, column, result, Color.parseColor("#5F9EA0"));
      } else if (text.equals("chartreuse")) {
        getColor(token, line, column, result, Color.parseColor("#7FFF00"));
      } else if (text.equals("chocolate")) {
        getColor(token, line, column, result, Color.parseColor("#D2691E"));
      } else if (text.equals("coral")) {
        getColor(token, line, column, result, Color.parseColor("#FF7F50"));
      } else if (text.equals("cornflowerblue")) {
        getColor(token, line, column, result, Color.parseColor("#6495ED"));
      } else if (text.equals("cornsilk")) {
        getColor(token, line, column, result, Color.parseColor("#FFF8DC"));
      } else if (text.equals("crimson")) {
        getColor(token, line, column, result, Color.parseColor("#DC143C"));
      } else if (text.equals("cyan")) {
        getColor(token, line, column, result, Color.parseColor("#00FFFF"));
      } else if (text.equals("darkblue")) {
        getColor(token, line, column, result, Color.parseColor("#00008B"));
      } else if (text.equals("darkcyan")) {
        getColor(token, line, column, result, Color.parseColor("#008B8B"));
      } else if (text.equals("darkgoldenrod")) {
        getColor(token, line, column, result, Color.parseColor("#B8860B"));
      } else if (text.equals("darkgrey")) {
        getColor(token, line, column, result, Color.parseColor("#A9A9A9"));
      } else if (text.equals("darkgreen")) {
        getColor(token, line, column, result, Color.parseColor("#006400"));
      } else if (text.equals("darkkhaki")) {
        getColor(token, line, column, result, Color.parseColor("#BDB76B"));
      } else if (text.equals("darkmagenta")) {
        getColor(token, line, column, result, Color.parseColor("#8B008B"));
      } else if (text.equals("darkolivegreen")) {
        getColor(token, line, column, result, Color.parseColor("#556B2F"));
      } else if (text.equals("darkorange")) {
        getColor(token, line, column, result, Color.parseColor("#FF8C00"));
      } else if (text.equals("darkorchid")) {
        getColor(token, line, column, result, Color.parseColor("#9932CC"));
      } else if (text.equals("darkred")) {
        getColor(token, line, column, result, Color.parseColor("#8B0000"));
      } else if (text.equals("darksalmon")) {
        getColor(token, line, column, result, Color.parseColor("#E9967A"));
      } else if (text.equals("darkseagreen")) {
        getColor(token, line, column, result, Color.parseColor("#8FBC8F"));
      } else if (text.equals("darkslateblue")) {
        getColor(token, line, column, result, Color.parseColor("#483D8B"));
      } else if (text.equals("darkslategray") || text.equals("darkslategrey")) {
        getColor(token, line, column, result, Color.parseColor("#2F4F4F"));
      } else if (text.equals("darkturquoise")) {
        getColor(token, line, column, result, Color.parseColor("#00CED1"));
      } else if (text.equals("darkviolet")) {
        getColor(token, line, column, result, Color.parseColor("#9400D3"));
      } else if (text.equals("deeppink")) {
        getColor(token, line, column, result, Color.parseColor("#FF1493"));
      } else if (text.equals("deepskyblue")) {
        getColor(token, line, column, result, Color.parseColor("#00BFFF"));
      } else if (text.equals("dimgray") || text.equals("dimgrey")) {
        getColor(token, line, column, result, Color.parseColor("#696969"));
      } else if (text.equals("dodgerblue")) {
        getColor(token, line, column, result, Color.parseColor("#1E90FF"));
      } else if (text.equals("firebrick")) {
        getColor(token, line, column, result, Color.parseColor("#B22222"));
      } else if (text.equals("floralwhite")) {
        getColor(token, line, column, result, Color.parseColor("#FFFAF0"));
      } else if (text.equals("forestgreen")) {
        getColor(token, line, column, result, Color.parseColor("#228B22"));
      } else if (text.equals("fuchsia")) {
        getColor(token, line, column, result, Color.parseColor("#FF00FF"));
      } else if (text.equals("gainsboro")) {
        getColor(token, line, column, result, Color.parseColor("#DCDCDC"));
      } else if (text.equals("ghostwhite")) {
        getColor(token, line, column, result, Color.parseColor("#F8F8FF"));
      } else if (text.equals("gold")) {
        getColor(token, line, column, result, Color.parseColor("#FFD700"));
      } else if (text.equals("goldenrod")) {
        getColor(token, line, column, result, Color.parseColor("#DAA520"));
      } else if (text.equals("grey")) {
        getColor(token, line, column, result, Color.parseColor("#808080"));
      } else if (text.equals("green")) {
        getColor(token, line, column, result, Color.parseColor("#008000"));
      } else if (text.equals("greenyellow")) {
        getColor(token, line, column, result, Color.parseColor("#ADFF2F"));
      } else if (text.equals("cornflowerblue")) {
        getColor(token, line, column, result, Color.parseColor("#6495ED"));
      } else if (text.equals("honeydew")) {
        getColor(token, line, column, result, Color.parseColor("#F0FFF0"));
      } else if (text.equals("hotpink")) {
        getColor(token, line, column, result, Color.parseColor("#FF69B4"));
      } else if (text.equals("indianred")) {
        getColor(token, line, column, result, Color.parseColor("#CD5C5C"));
      } else if (text.equals("indigo")) {
        getColor(token, line, column, result, Color.parseColor("#4B0082"));
      } else if (text.equals("ivory")) {
        getColor(token, line, column, result, Color.parseColor("#FFFFF0"));
      } else if (text.equals("khaki")) {
        getColor(token, line, column, result, Color.parseColor("#F0E68C"));
      } else if (text.equals("lavender")) {
        getColor(token, line, column, result, Color.parseColor("#E6E6FA"));
      } else if (text.equals("lavenderblush")) {
        getColor(token, line, column, result, Color.parseColor("#FFF0F5"));
      } else if (text.equals("lawngreen")) {
        getColor(token, line, column, result, Color.parseColor("#7CFC00"));
      } else if (text.equals("lemonchiffon")) {
        getColor(token, line, column, result, Color.parseColor("#FFFACD"));
      } else if (text.equals("lightblue")) {
        getColor(token, line, column, result, Color.parseColor("#ADD8E6"));
      } else if (text.equals("lightcoral")) {
        getColor(token, line, column, result, Color.parseColor("#F08080"));
      } else if (text.equals("lightcyan")) {
        getColor(token, line, column, result, Color.parseColor("#E0FFFF"));
      } else if (text.equals("lightgoldenrodyellow")) {
        getColor(token, line, column, result, Color.parseColor("#FAFAD2"));
      } else if (text.equals("lightgray") || text.equals("lightgrey")) {
        getColor(token, line, column, result, Color.parseColor("#D3D3D3"));
      } else if (text.equals("lightgreen")) {
        getColor(token, line, column, result, Color.parseColor("#90EE90"));
      } else if (text.equals("lightpink")) {
        getColor(token, line, column, result, Color.parseColor("#FFB6C1"));
      } else if (text.equals("lightsalmon")) {
        getColor(token, line, column, result, Color.parseColor("#FFA07A"));
      } else if (text.equals("lightseagreen")) {
        getColor(token, line, column, result, Color.parseColor("#20B2AA"));
      } else if (text.equals("lightskyblue")) {
        getColor(token, line, column, result, Color.parseColor("#87CEFA"));
      } else if (text.equals("lightslategray") || text.equals("lightslategrey")) {
        getColor(token, line, column, result, Color.parseColor("#778899"));
      } else if (text.equals("lightsteelblue")) {
        getColor(token, line, column, result, Color.parseColor("#B0C4DE"));
      } else if (text.equals("lightyellow")) {
        getColor(token, line, column, result, Color.parseColor("#FFFFE0"));
      } else if (text.equals("lime")) {
        getColor(token, line, column, result, Color.parseColor("#00FF00"));
      } else if (text.equals("limegreen")) {
        getColor(token, line, column, result, Color.parseColor("#32CD32"));
      } else if (text.equals("linen")) {
        getColor(token, line, column, result, Color.parseColor("#FAF0E6"));
      } else if (text.equals("magenta")) {
        getColor(token, line, column, result, Color.parseColor("#FF00FF"));
      } else if (text.equals("maroon")) {
        getColor(token, line, column, result, Color.parseColor("#800000"));
      } else if (text.equals("mediumaquamarine")) {
        getColor(token, line, column, result, Color.parseColor("#66CDAA"));
      } else if (text.equals("mediumblue")) {
        getColor(token, line, column, result, Color.parseColor("#0000CD"));
      } else if (text.equals("mediumorchid")) {
        getColor(token, line, column, result, Color.parseColor("#BA55D3"));
      } else if (text.equals("mediumpurple")) {
        getColor(token, line, column, result, Color.parseColor("#9370DB"));
      } else if (text.equals("mediumseagreen")) {
        getColor(token, line, column, result, Color.parseColor("#3CB371"));
      } else if (text.equals("mediumslateblue")) {
        getColor(token, line, column, result, Color.parseColor("#7B68EE"));
      } else if (text.equals("mediumspringgreen")) {
        getColor(token, line, column, result, Color.parseColor("#00FA9A"));
      } else if (text.equals("mediumturquoise")) {
        getColor(token, line, column, result, Color.parseColor("#48D1CC"));
      } else if (text.equals("mediumvioletred")) {
        getColor(token, line, column, result, Color.parseColor("#C71585"));
      } else if (text.equals("cornflowerblue")) {
        getColor(token, line, column, result, Color.parseColor("#6495ED"));
      } else if (text.equals("midnightblue")) {
        getColor(token, line, column, result, Color.parseColor("#191970"));
      } else if (text.equals("mintcream")) {
        getColor(token, line, column, result, Color.parseColor("#F5FFFA"));
      } else if (text.equals("mistyrose")) {
        getColor(token, line, column, result, Color.parseColor("#FFE4E1"));
      } else if (text.equals("moccasin")) {
        getColor(token, line, column, result, Color.parseColor("#FFE4B5"));
      } else if (text.equals("navajowhite")) {
        getColor(token, line, column, result, Color.parseColor("#FFDEAD"));
      } else if (text.equals("navy")) {
        getColor(token, line, column, result, Color.parseColor("#000080"));
      } else if (text.equals("oldlace")) {
        getColor(token, line, column, result, Color.parseColor("#FDF5E6"));
      } else if (text.equals("olivedrab")) {
        getColor(token, line, column, result, Color.parseColor("#6B8E23"));
      } else if (text.equals("orange")) {
        getColor(token, line, column, result, Color.parseColor("#FFA500"));
      } else if (text.equals("orangered")) {
        getColor(token, line, column, result, Color.parseColor("#FF4500"));
      } else if (text.equals("orchid")) {
        getColor(token, line, column, result, Color.parseColor("#DA70D6"));
      } else if (text.equals("palegoldenrod")) {
        getColor(token, line, column, result, Color.parseColor("#EEE8AA"));
      } else if (text.equals("palegreen")) {
        getColor(token, line, column, result, Color.parseColor("#98FB98"));
      } else if (text.equals("paleturquoise")) {
        getColor(token, line, column, result, Color.parseColor("#AFEEEE"));
      } else if (text.equals("palevioletred")) {
        getColor(token, line, column, result, Color.parseColor("#DB7093"));
      } else if (text.equals("papayawhip")) {
        getColor(token, line, column, result, Color.parseColor("#FFEFD5"));
      } else if (text.equals("peachpuff")) {
        getColor(token, line, column, result, Color.parseColor("#FFDAB9"));
      } else if (text.equals("peru")) {
        getColor(token, line, column, result, Color.parseColor("#CD853F"));
      } else if (text.equals("pink")) {
        getColor(token, line, column, result, Color.parseColor("#FFC0CB"));
      } else if (text.equals("plum")) {
        getColor(token, line, column, result, Color.parseColor("#DDA0DD"));
      } else if (text.equals("powderblue")) {
        getColor(token, line, column, result, Color.parseColor("#B0E0E6"));
      } else if (text.equals("purple")) {
        getColor(token, line, column, result, Color.parseColor("#800080"));
      } else if (text.equals("rosybrown")) {
        getColor(token, line, column, result, Color.parseColor("#BC8F8F"));
      } else if (text.equals("cornflowerblue")) {
        getColor(token, line, column, result, Color.parseColor("#6495ED"));
      } else if (text.equals("royalblue")) {
        getColor(token, line, column, result, Color.parseColor("#4169E1"));
      } else if (text.equals("saddlebrown")) {
        getColor(token, line, column, result, Color.parseColor("#8B4513"));
      } else if (text.equals("salmon")) {
        getColor(token, line, column, result, Color.parseColor("#FA8072"));
      } else if (text.equals("sandybrown")) {
        getColor(token, line, column, result, Color.parseColor("#F4A460"));
      } else if (text.equals("seagreen")) {
        getColor(token, line, column, result, Color.parseColor("#2E8B57"));
      } else if (text.equals("seashell")) {
        getColor(token, line, column, result, Color.parseColor("#FFF5EE"));
      } else if (text.equals("sienna")) {
        getColor(token, line, column, result, Color.parseColor("#A0522D"));
      } else if (text.equals("silver")) {
        getColor(token, line, column, result, Color.parseColor("#C0C0C0"));
      } else if (text.equals("skyblue")) {
        getColor(token, line, column, result, Color.parseColor("#87CEEB"));
      } else if (text.equals("slateblue")) {
        getColor(token, line, column, result, Color.parseColor("#6A5ACD"));
      } else if (text.equals("slategrey")) {
        getColor(token, line, column, result, Color.parseColor("#708090"));
      } else if (text.equals("snow")) {
        getColor(token, line, column, result, Color.parseColor("#FFFAFA"));
      } else if (text.equals("springgreen")) {
        getColor(token, line, column, result, Color.parseColor("#00FF7F"));
      } else if (text.equals("steelblue")) {
        getColor(token, line, column, result, Color.parseColor("#4682B4"));
      } else if (text.equals("tan")) {
        getColor(token, line, column, result, Color.parseColor("#D2B48C"));
      } else if (text.equals("teal")) {
        getColor(token, line, column, result, Color.parseColor("#008080"));
      } else if (text.equals("thistle")) {
        getColor(token, line, column, result, Color.parseColor("#D8BFD8"));
      } else if (text.equals("tomato")) {
        getColor(token, line, column, result, Color.parseColor("#FF6347"));
      } else if (text.equals("turquoise")) {
        getColor(token, line, column, result, Color.parseColor("#40E0D0"));
      } else if (text.equals("violet")) {
        getColor(token, line, column, result, Color.parseColor("#EE82EE"));
      } else if (text.equals("wheat")) {
        getColor(token, line, column, result, Color.parseColor("#F5DEB3"));
      } else if (text.equals("white")) {
        getColor(token, line, column, result, Color.parseColor("#FFFFFF"));
      } else if (text.equals("whitesmoke")) {
        getColor(token, line, column, result, Color.parseColor("#F5F5F5"));
      } else if (text.equals("yellow")) {
        getColor(token, line, column, result, Color.parseColor("#FFFF00"));
      } else if (text.equals("yellowgreen")) {
        getColor(token, line, column, result, Color.parseColor("#9ACD32"));
      } else if (text.equals("cornflowerblue")) {
        getColor(token, line, column, result, Color.parseColor("#6495ED"));
      } else if (text.equals("red")) {
        getColor(token, line, column, result, Color.parseColor("#f00000"));
      }
    }
  }

  public static long withoutCompletion(int id) {
    return TextStyle.makeStyle(id, 0, true, false, false, false, true);
  }

  public static long forString() {
    return TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, false, false);
  }
  void test(Canvas c){
    
  }
}
