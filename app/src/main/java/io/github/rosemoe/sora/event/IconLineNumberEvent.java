package io.github.rosemoe.sora.event;

import io.github.rosemoe.sora.widget.CodeEditor;

public class IconLineNumberEvent extends Event {
  public IconLineNumberEvent(CodeEditor editor) {
    super(editor);
  }
}
