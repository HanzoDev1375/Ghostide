package io.github.rosemoe.sora.langs.less;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.widget.CodeEditor;

public class LessCodeAnalyzer implements CodeAnalyzer {
  private CodeEditor editor;

  public LessCodeAnalyzer(CodeEditor editor) {
    this.editor = editor;
  }

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {}
}
