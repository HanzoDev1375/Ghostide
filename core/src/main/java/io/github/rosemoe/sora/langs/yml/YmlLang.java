package io.github.rosemoe.sora.langs.yml;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import ir.ninjacoder.ghostide.core.config.JacksonFormatter;

public class YmlLang implements EditorLanguage {

  @Override
  public CharSequence format(CharSequence code) {
    try {
      var format = new JacksonFormatter();
      return format.formatYml(code.toString());
    } catch (Exception err) {
      return code;
    }
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new YmlCodeAnalyzer();
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
    return null;
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
