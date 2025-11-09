package io.github.rosemoe.sora.event;


import io.github.rosemoe.sora.widget.CodeEditor;

public class PublishSearchResultEvent extends Event {
  private CodeEditor editor;

  public PublishSearchResultEvent(CodeEditor editor) {
    super(editor);
    this.editor = editor;
  }
}
