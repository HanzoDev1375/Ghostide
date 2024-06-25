package io.github.rosemoe.sora.langs.ghostthemelang.ghostlang;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.langs.ghostthemelang.TokenCompat;
import io.github.rosemoe.sora.langs.ghostthemelang.ghostcodeanalyzer.GhostCodeAnalyzer;
import io.github.rosemoe.sora.langs.internal.MyCharacter;

import io.github.rosemoe.sora.text.TextUtils;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import io.github.rosemoe.sora.interfaces.EditorLanguage;

public class ghostlangs implements EditorLanguage {

  private final NewlineHandler[] newLineHandlers =
      new NewlineHandler[] {
        new BraceHandler(), new TwoIndentHandler(), new JavaDocStartHandler(), new JavaDocHandler()
      };

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new GhostCodeAnalyzer();
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    return null;
  }

  @Override
  public boolean isAutoCompleteChar(char ch) {
    return MyCharacter.isJavaIdentifierPart(ch) || ch == '{' || ch == '}' || ch == '.';
  }

  /**
   * @Override public int getIndentAdvance(String content) { JavaTextTokenizer t = new
   * JavaTextTokenizer(content); Tokens token; int advance = 0; while ((token = t.directNextToken())
   * != Tokens.EOF) { switch (token) { case LBRACE: advance++; break;
   *
   * <p>} } /// advance = Math.max(0, advance); // return advance * 4; // }
   */
  @Override
  public int getIndentAdvance(String content) {

    try {
      GhostTextTokenizer g = new GhostTextTokenizer(content);
      TokenCompat compat;
      int userAdd = 0;
      while ((compat = g.directNextToken()) != TokenCompat.EOF) {
        switch (compat) {
          case LBRACE:
            userAdd++;
            break;
        }
      }
      userAdd = Math.max(0, userAdd);
    } catch (Exception err) {
      Log.e("Tag", err.getMessage());
    }
    return 0;
  }

  @Override
  public boolean useTab() {
    return true;
  }

  @Override
  public CharSequence format(CharSequence text) {
    return formatJson(text.toString());
  }

  @Override
  public SymbolPairMatch getSymbolPairs() {
    return new SymbolPairMatch.DefaultSymbolPairs();
  }

  @Override
  public NewlineHandler[] getNewlineHandlers() {
    return newLineHandlers;
  }

  private String formatJson(String code) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    JsonParser jp = new JsonParser();
    JsonElement je = jp.parse(code);
    return gson.toJson(je);
  }

  class BraceHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.endsWith("{") && afterText.startsWith("}")
          || beforeText.endsWith("(") && afterText.startsWith(")");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceBefore = getIndentAdvance(beforeText);
      int advanceAfter = getIndentAdvance(afterText);
      String text;
      StringBuilder sb =
          new StringBuilder("\n")
              .append(TextUtils.createIndent(count + advanceBefore, tabSize, useTab()))
              .append('\n')
              .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()));
      int shiftLeft = text.length() + 1;
      return new HandleResult(sb, shiftLeft);
    }
  }

  class JavaDocStartHandler implements NewlineHandler {

    private boolean shouldCreateEnd = true;

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.trim().startsWith("/**");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceAfter = getIndentAdvance(afterText);
      String text = "";
      StringBuilder sb =
          new StringBuilder()
              .append("\n")
              .append(TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
              .append(" * ");
      if (shouldCreateEnd) {
        sb.append("\n")
            .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
            .append(" */");
      }
      return new HandleResult(sb, text.length() + 4);
    }
  }

  class JavaDocHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.trim().startsWith("*") && !beforeText.trim().startsWith("*/");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceAfter = getIndentAdvance(afterText);
      StringBuilder sb =
          new StringBuilder()
              .append("\n")
              .append(TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
              .append("* ");
      return new HandleResult(sb, 0);
    }
  }

  class TwoIndentHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      Log.d("BeforeText", beforeText);
      if (beforeText.replace("\r", "").trim().startsWith(".")) {
        return false;
      }
      return beforeText.endsWith(")") && !afterText.startsWith(";");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceAfter = getIndentAdvance(afterText) + (4 * 2);
      String text;
      StringBuilder sb =
          new StringBuilder()
              .append('\n')
              .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()));
      int shiftLeft = 0;
      return new HandleResult(sb, shiftLeft);
    }
  }
}
