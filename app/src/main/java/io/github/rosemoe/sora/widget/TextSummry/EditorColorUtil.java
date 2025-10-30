package io.github.rosemoe.sora.widget.TextSummry;

import ir.ninjacoder.ghostide.IdeEditor;

class EditorColorUtil {
  public static int get(IdeEditor editor, int color) {
    return editor.getColorScheme().getColor(color);
  }
}
