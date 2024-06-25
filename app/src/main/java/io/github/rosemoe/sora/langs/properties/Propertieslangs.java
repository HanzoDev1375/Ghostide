package io.github.rosemoe.sora.langs.properties;

import Ninja.coder.Ghostemane.code.config.JacksonFormatter;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import io.github.rosemoe.sora.interfaces.NewlineHandler;

public class Propertieslangs implements EditorLanguage {

  @Override
  public CharSequence format(CharSequence text) {
    try {
      JacksonFormatter format = new JacksonFormatter();
      return format.formatProp(text.toString());
    } catch (Exception err) {

    }
    return text;
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new ProAnalyzer();
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    return null;
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
    return false;
  }

  @Override
  public boolean useTab() {
    return false;
  }
}
