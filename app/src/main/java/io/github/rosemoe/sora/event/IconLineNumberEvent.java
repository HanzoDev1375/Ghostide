package io.github.rosemoe.sora.event;

import io.github.rosemoe.sora.widget.CodeEditor;

public class IconLineNumberEvent extends Event {
  private CodeEditor editor;
  private float x;
  private float y;

  public IconLineNumberEvent(CodeEditor editor, float x, float y) {
    super(editor);
    this.editor = editor;
    this.x = x;
    this.y = y;
  }

  public CodeEditor getEditor() {
    return this.editor;
  }

  public float getX() {
    return this.x;
  }

  public float getY() {
    return this.y;
  }
}
