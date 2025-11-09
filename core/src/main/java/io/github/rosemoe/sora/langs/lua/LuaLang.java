package io.github.rosemoe.sora.langs.lua;

import com.ninjacoder.jgit.childer.CharParser;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.widget.SymbolPairMatch;

public class LuaLang implements EditorLanguage {

  @Override
  public CharSequence format(CharSequence text) {
    return text;
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new LuaCodeAnalyzer();
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    return new LuaAutoComplete();
  }

  @Override
  public int getIndentAdvance(String content) {
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
