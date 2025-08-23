package io.github.rosemoe.sora.langs.rust;

import com.ninjacoder.jgit.childer.CharParser;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import ir.ninjacoder.ghostide.IdeEditor;

public class RustLang implements EditorLanguage {
  private IdeEditor editor;

  public RustLang(IdeEditor editor) {
    this.editor = editor;
  }

  @Override
  public CharSequence format(CharSequence text) {
    return text;
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new RustCodeAnalyzer(editor);
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
    return CharParser.parserChar(ch);
  }

  @Override
  public boolean useTab() {
    return false;
  }
}
