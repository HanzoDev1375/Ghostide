package io.github.rosemoe.sora.langs.Javacc;

import Ninja.coder.Ghostemane.code.IdeEditor;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.langs.java.JavaAutoComplete;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import java.lang.ref.WeakReference;

public class JavaccLang implements EditorLanguage {

  private IdeEditor editor;
  private WeakReference<IdeEditor> work;

  public JavaccLang(IdeEditor editor) {
    this.editor = editor;
    work = new WeakReference<>(editor);
  }

  @Override
  public CharSequence format(CharSequence text) {
    return text;
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new JavaccCodeAnalyzer(editor);
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    var java = new JavaAutoComplete(editor);
    java.setKeywords(JavaLanguage.keywords);
    return java;
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
  public boolean isAutoCompleteChar(char ch) {
    return Character.isLetter(ch)
        || Character.isDigit(ch)
        || ch == '<'
        || ch == '/'
        || ch == ':'
        || ch == '.'
        || ch == '!'
        || ch == '<'
        || ch == '?'
        || ch == '-'
        || ch == '+'
        || ch == '$'
        || ch == '#'
        || ch == '*'
        || Character.isJavaIdentifierStart(ch)
        || Character.isJavaIdentifierPart(ch);
  }

  @Override
  public boolean useTab() {
    return true;
  }

  @Override
  public SymbolPairMatch getSymbolPairs() {
    return new SymbolPairMatch.DefaultSymbolPairs();
  }

  public WeakReference<IdeEditor> getWork() {
    return this.work;
  }
}
