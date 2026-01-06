package ir.ninjacoder.ghostide.core.pl;

import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;
import ir.ninjacoder.ghostide.core.activities.CodeEditorActivity;
import ir.ninjacoder.ghostide.core.activities.FileManagerActivity;

public interface PluginManagerCompat {

  void getEditor(CodeEditor editor);

  String setName();

  boolean hasuseing();

  void getFileManagerAc(FileManagerActivity activity);

  void getCodeEditorAc(CodeEditorActivity activity);

  void getBaseCompat(BaseCompat activity);

  String langModel();

  default String versionCode() {
    return "1.0";
  }
}
