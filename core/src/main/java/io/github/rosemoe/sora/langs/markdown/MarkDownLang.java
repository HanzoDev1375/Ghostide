package io.github.rosemoe.sora.langs.markdown;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.widget.SymbolPairMatch;

public class MarkDownLang implements EditorLanguage {

  @Override
  public CharSequence format(CharSequence text) {
    // TODO: Implement this method
    return text;
  }

  @Override
  public boolean useTab() {
    // TODO: Implement this method
    return true;
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    // TODO: Implement this method
    return new MarkDownCodeAnalyzer();
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    // TODO: Implement this method
    return null;
  }

  @Override
  public int getIndentAdvance(String content) {
    // TODO: Implement this method
    return 0;
  }

  @Override
  public NewlineHandler[] getNewlineHandlers() {
    // TODO: Implement this method
    return null;
  }

  @Override
  public SymbolPairMatch getSymbolPairs() {
    return new SymbolPairMatch.DefaultSymbolPairs();
  }

  @Override
  public boolean isAutoCompleteChar(char ch) {
    return false;
  }
}
