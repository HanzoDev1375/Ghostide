package io.github.rosemoe.sora.event;

import androidx.annotation.NonNull;
import io.github.rosemoe.sora.widget.CodeEditor;

public class TextSizeChangeEvent extends Event {
  private CodeEditor editor;
  private float oldTextSize;
  private float newTextSize;

  public TextSizeChangeEvent(@NonNull CodeEditor editor, float oldTextSize, float newTextSize) {
    super(editor);
    this.editor = editor;
    this.oldTextSize = oldTextSize;
    this.newTextSize = newTextSize;
  }

  public CodeEditor getEditor() {
    return this.editor;
  }

  public float getOldTextSize() {
    return this.oldTextSize;
  }

  public float getNewTextSize() {
    return this.newTextSize;
  }
}
