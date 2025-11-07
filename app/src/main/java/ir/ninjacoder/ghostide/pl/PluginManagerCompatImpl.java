package ir.ninjacoder.ghostide.pl;

import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.activities.CodeEditorActivity;

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
