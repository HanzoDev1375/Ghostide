package ir.ninjacoder.ghostide.pl;

import io.github.rosemoe.sora.widget.CodeEditor;

public interface PluginManagerCompat {

  void getEditor(CodeEditor editor);

  String setName();

  boolean hasuseing();
}
