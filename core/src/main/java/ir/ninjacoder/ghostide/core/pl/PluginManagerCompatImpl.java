package ir.ninjacoder.ghostide.core.pl;

import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.core.activities.CodeEditorActivity;
import ir.ninjacoder.ghostide.core.activities.FileManagerActivity;

public class PluginManagerCompatImpl implements PluginManagerCompat {

  @Override
  public void getEditor(CodeEditor editor) {}

  @Override
  public boolean hasuseing() {
    return false;
  }

  @Override
  public String setName() {
    return "پلاگین پیش‌فرض";
  }

  @Override
  public void getCodeEditorAc(CodeEditorActivity activity) {}

  @Override
  public void getFileManagerAc(FileManagerActivity activity) {}

  @Override
  public String langModel() {

    return null;
  }
}
