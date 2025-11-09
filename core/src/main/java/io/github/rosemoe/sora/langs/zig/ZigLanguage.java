package io.github.rosemoe.sora.langs.zig;

import com.ninjacoder.jgit.childer.CharParser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import ir.ninjacoder.codesnap.antlr4.zig.ZigLexer;
import ir.ninjacoder.ghostide.core.IdeEditor;

public class ZigLanguage implements EditorLanguage {
  private IdeEditor editor;

  public ZigLanguage(IdeEditor editor) {
    this.editor = editor;
  }

  @Override
  public CharSequence format(CharSequence text) {
    return text;
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new ZigCodeAnalyzer(editor);
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    return new ZigAutoComplete();
  }

  @Override
  public int getIndentAdvance(String content) {
    try {
      var lexer = new ZigLexer(CharStreams.fromReader(new StringReader(content)));
      Token token;
      int advance = 0;
      while (((token = lexer.nextToken()) != null && token.getType() != token.EOF)) {
        switch (token.getType()) {
          case ZigLexer.LBRACE:
            advance++;
            break;
          case ZigLexer.RBRACE:
            advance--;
            break;
        }
      }
      advance = Math.max(0, advance);
      return advance * 4;
    } catch (Throwable e) {

    }
    return 0;
  }

  @Override
  public NewlineHandler[] getNewlineHandlers() {
    return null;
  }

  @Override
  public SymbolPairMatch getSymbolPairs() {
    return new SymbolPairMatch.DefaultSymbolPairs();
  }

  @Override
 public boolean isAutoCompleteChar(char ch) {
    return CharParser.parserChar(ch);
  }

  @Override
  public boolean useTab() {
    return true;
  }
}
