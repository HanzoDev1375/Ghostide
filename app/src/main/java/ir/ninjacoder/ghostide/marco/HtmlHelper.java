package ir.ninjacoder.ghostide.marco;

import android.text.Html;
import android.text.Spanned;

public class HtmlHelper {
  public static final String COLOR_RED = "red";
  public static final String COLOR_BLUE = "blue";
  public static final String COLOR_GREEN = "green";
  public static final String COLOR_GOLD = "gold";

  public static Spanned getFontName(String colorHtml, String text) {
    return Html.fromHtml("<font color = \"" + colorHtml + "\">" + text + "</font>");
  }

  public static Spanned getH1(String txt) {
    return Html.fromHtml("<h1>" + txt + "</h1>");
  }

  public static Spanned getH2(String txt) {
    return Html.fromHtml("<h2>" + txt + "</h2>");
  }

  public static Spanned getH3(String txt) {
    return Html.fromHtml("<h3>" + txt + "</h3>");
  }

  public static Spanned getH4(String txt) {
    return Html.fromHtml("<h4>" + txt + "</h4>");
  }

  public static Spanned getH5(String txt) {
    return Html.fromHtml("<h5>" + txt + "</h5>");
  }

  public static Spanned getH6(String txt) {
    return Html.fromHtml("<h6>" + txt + "</h6>");
  }

  public static Spanned getBoldText(String txt) {
    return Html.fromHtml("<b>" + txt + "</b>");
  }

  public static Spanned getCustomColorFont(
      String color1, String color2, String color3, String color4, String text) {
    String htmlText =
        "<font color=\""
            + color1
            + "\">"
            + text
            + "</font>"
            + "<font color=\""
            + color2
            + "\">"
            + text
            + "</font>"
            + "<font color=\""
            + color3
            + "\">"
            + text
            + "</font>"
            + "<font color=\""
            + color4
            + "\">"
            + text
            + "</font>";
    return Html.fromHtml(htmlText);
  }
}
