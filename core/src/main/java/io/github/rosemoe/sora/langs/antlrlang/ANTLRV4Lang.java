package io.github.rosemoe.sora.langs.antlrlang;

import com.khubla.antlr4formatter.Antlr4Formatter;
import com.khubla.antlr4formatter.Antlr4FormatterException;

import org.antlr.parser.antlr4.ANTLRv4Lexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.text.TextUtils;
import io.github.rosemoe.sora.widget.SymbolPairMatch;

public class ANTLRV4Lang implements EditorLanguage {

  private final NewlineHandler[] newLineHandlers =
      new NewlineHandler[] {
        new BraceHandler(), new TwoIndentHandler(), new JavaDocStartHandler(), new JavaDocHandler()
      };
  public static String[] word = {
    "lexer",
    "mode",
    "options",
    "grammar",
    "import",
    "channel",
    "pushMode",
    "fragment",
    "parser",
    "public",
    "private",
    "try",
    "catch",
    "return",
    "locals",
    "throws",
    "finally",
    "->",
    "EOF",
    "HIDDEN",
    "type"
  };

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new ANTLRV4CodeAnalyzer();
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    var key = new Antlr4AutoText();
    key.setKeywords(word);
    return key;
  }

  @Override
  public boolean isAutoCompleteChar(char ch) {
    return MyCharacter.isJavaIdentifierPart(ch)
        || MyCharacter.isJavaIdentifierStart(ch)
        || ch == '.'
        || ch == ',';
  }

  @Override
  public int getIndentAdvance(String content) {
    try {
      ANTLRv4Lexer lexer = new ANTLRv4Lexer(CharStreams.fromReader(new StringReader(content)));
      Token token;
      int advance = 0;
      while (((token = lexer.nextToken()) != null && token.getType() != token.EOF)) {
        switch (token.getType()) {
          case ANTLRv4Lexer.LPAREN:
            advance++;
            break;
          case ANTLRv4Lexer.RPAREN:
            advance--;
            break;
        }
      }
      advance = Math.max(0, advance);
      return advance * 4;
    } catch (Exception err) {

    }
    return 0;
  }

  @Override
  public boolean useTab() {
    return true;
  }

  @Override
  public CharSequence format(CharSequence text) {
    try {

      return getG4Format(text.toString());
    } catch (Antlr4FormatterException err) {
      return err.getLocalizedMessage();
    }
  }

  @Override
  public SymbolPairMatch getSymbolPairs() {
    return new SymbolPairMatch.DefaultSymbolPairs();
  }

  @Override
  public NewlineHandler[] getNewlineHandlers() {
    return newLineHandlers;
  }

  class BraceHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.endsWith("{") && afterText.startsWith("}");
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
      //  Log.d("BeforeText", beforeText);
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

  public String getG4Format(String code) throws Antlr4FormatterException {
    return Antlr4Formatter.format(code);
  }
}
