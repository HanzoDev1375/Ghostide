package Ninja.coder.Ghostemane.code.marco;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;

public class CharUtil {
  private int WhitespacesCount = 0;
  private int CharactersCountWithoutSpaces = 0;
  private int UppercasesCount = 0;
  protected String textView;
  protected TextView result;

  /** tnks for com.androiddevs.textanalyzer fixed code by ninja coder */
  public CharUtil(String textView, TextView result) {
    this.textView = textView;
    this.result = result;
    var builder = new StringBuilder();
    builder.append("W ").append(String.valueOf(getWhiteSpacesCount(textView))).append(" ");
    builder
        .append("C ")
        .append(String.valueOf(getCharactersCountWithoutSpaces(textView)))
        .append(" ");
    builder.append("B ").append(String.valueOf(getBytesCount(textView))).append(" ");
    builder.append("U ").append(String.valueOf(getUppercasesCount(textView))).append(" ");
    result.setText(builder.toString());
    result.setSingleLine(true);
    result.setEllipsize(TextUtils.TruncateAt.END);
  }

  public int getCharactersCount(final String Text) {
    int CharactersCount = Text.length();
    return CharactersCount;
  }

  public int getWordsCount(final String Text) {
    String[] Words = Text.split("\\s+");
    int WordsCount = Words.length;
    return WordsCount;
  }

  public int getSentencesCount(final String Text) {
    String[] Sentences = Text.split("[.!?]+\\s*");
    int SentencesCount = Sentences.length;
    return SentencesCount;
  }

  public int getParagraphsCount(final String Text) {
    String[] Paragraphs = Text.split("\n\n");
    int ParagraphsCount = Paragraphs.length;
    return ParagraphsCount;
  }

  public int getWhiteSpacesCount(final String Text) {
    WhitespacesCount = 0;
    for (int i = 0; i < Text.length(); i++) {
      if (Character.isWhitespace(Text.charAt(i))) {
        WhitespacesCount++;
      }
    }
    return WhitespacesCount;
  }

  public int getCharactersCountWithoutSpaces(final String Text) {
    CharactersCountWithoutSpaces = getCharactersCount(Text) - getWhiteSpacesCount(Text);
    return CharactersCountWithoutSpaces;
  }

  public int getBytesCount(final String Text) {
    int BytesCount = Text.getBytes().length;
    return BytesCount;
  }

  public int getUppercasesCount(final String Text) {
    UppercasesCount = 0;
    for (int i = 0; i < Text.length(); i++) {
      if (Character.isUpperCase(Text.charAt(i))) {
        UppercasesCount++;
      }
    }
    return UppercasesCount;
  }
}
