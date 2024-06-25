package io.github.rosemoe.sora.langs.python;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.langs.IdentifierAutoComplete;
import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.text.TextUtils;
import io.github.rosemoe.sora.widget.SymbolPairMatch;

public class PythonLanguage implements EditorLanguage {
  public static final String[] keywords = {
    "and",
    "as",
    "assert",
    "break",
    "class",
    "continue",
    "def",
    "del",
    "elif",
    "else",
    "except",
    "exec",
    "finally",
    "for",
    "from",
    "global",
    "if",
    "import",
    "in",
    "is",
    "lambda",
    "not",
    "or",
    "pass",
    "raise",
    "return",
    "try",
    "while",
    "with",
    "yield"
  };
  public static final String[] oprator = {"list", "range", "print"};

  public static final String[] utils = {"forEach"};
  private NewlineHandler[] newlineHandlers =
      new NewlineHandler[] {new ColonHandler(), new PyDocHandler(), new PyDocStartHandler()};

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new PythonCodeAnalyzer();
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    return new PythonAutoComplete();
  }

  @Override
  public boolean isAutoCompleteChar(char ch) {
    return MyCharacter.isJavaIdentifierPart(ch);
  }

  @Override
  public int getIndentAdvance(String content) {
    Token token;
    int advance = 0;
    boolean openBlock = false;
    try {
      PythonLexer lexer = new PythonLexer(CharStreams.fromReader(new StringReader(content)));
      while (((token = lexer.nextToken()) != null && token.getType() != token.EOF)) {
        switch (token.getType()) {
          case PythonLexer.CLASS:
          case PythonLexer.DEF:
          case PythonLexer.IF:
          case PythonLexer.ELIF:
          case PythonLexer.FOR:
          case PythonLexer.WHILE:
          case PythonLexer.ELSE:
          case PythonLexer.TRY:
          case PythonLexer.EXCEPT:
            openBlock = !openBlock;
            break;
          case PythonLexer.COLON:
            advance++;
            break;
          case PythonLexer.CONTINUE:
          case PythonLexer.BREAK:
            openBlock = !openBlock;
            advance--;
            break;
        }
      }
      advance = Math.max(0, advance);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return openBlock ? advance * 4 : 0;
  }

  @Override
  public boolean useTab() {
    return true;
  }

  @Override
  public CharSequence format(CharSequence text) {
    return text;
  }

  @Override
  public SymbolPairMatch getSymbolPairs() {
    return null;
  }

  @Override
  public NewlineHandler[] getNewlineHandlers() {
    return newlineHandlers;
  }

  class ColonHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.endsWith(":");
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

  class PyDocHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.trim().startsWith("#") && !beforeText.trim().startsWith("#");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceAfter = getIndentAdvance(afterText);
      StringBuilder sb =
          new StringBuilder()
              .append("\n")
              .append(TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
              .append(" ");
      return new HandleResult(sb, 0);
    }
  }

  class PyDocStartHandler implements NewlineHandler {

    private boolean shouldCreateEnd = true;

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.trim().startsWith("##");
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
              .append(" # ");
      if (shouldCreateEnd) {
        sb.append("\n")
            .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
            .append(" ##");
      }
      return new HandleResult(sb, text.length() + 4);
    }
  }
}
