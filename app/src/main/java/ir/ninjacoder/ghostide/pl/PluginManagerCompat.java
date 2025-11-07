package ir.ninjacoder.ghostide.pl;

import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.activities.CodeEditorActivity;

public interface PluginManagerCompat {

  void getEditor(CodeEditor editor);

  String setName();

  boolean hasuseing();

  void getFileManagerAc(FileManagerActivity activity);

  void getCodeEditorAc(CodeEditorActivity activity);

  String langModel();
}
