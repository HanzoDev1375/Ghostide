package io.github.rosemoe.sora.langs.sql;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.widget.SymbolPairMatch;

public class MySqlLang implements EditorLanguage {

  @Override
  public CharSequence format(CharSequence text) {
    try {

      String[] options =
          new String[] {
            "-f", "ANSI",
            "-t", "2",
            "--keywordSpelling", "UPPER",
            "--functionSpelling", "CAMEL",
            "--objectSpelling", "LOWER",
            "--separation", "BEFORE",
            "--squareBracketQuotation", "AUTO"
          };
      return JSQLFormatter.format(text.toString(),options);
    } catch (Exception err) {

    }
    return text;
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new MySqlCodeAnalyzer();
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
    return true;
  }
}
