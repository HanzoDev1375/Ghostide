package io.github.rosemoe.sora.event;

import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class ColorSchemeUpdateEvent extends Event {

  public ColorSchemeUpdateEvent(CodeEditor editor) {
    super(editor);
  }

  public EditorColorScheme getColorScheme() {
    EditorColorScheme mcolor = getEditor().getColorScheme();
    if (mcolor == null) return null;
    return mcolor;
  }
}
