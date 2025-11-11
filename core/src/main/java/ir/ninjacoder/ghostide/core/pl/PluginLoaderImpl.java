package ir.ninjacoder.ghostide.core.pl;

import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.core.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.core.activities.CodeEditorActivity;
import ir.ninjacoder.prograsssheet.listchild.Child;

public class PluginLoaderImpl {

  private static final String DEFAULT_CONFIG_PATH =
      "/storage/emulated/0/GhostWebIDE/plugins/config.json";

  // برای FileManagerActivity (بدون CodeEditor)
  public PluginLoaderImpl runInFileManager(FileManagerActivity fmActivity) {
    PluginLoader loader = new PluginLoader().setFileManagerActivity(fmActivity);
    loader.loadAllPlugins(DEFAULT_CONFIG_PATH);
    return this;
  }

  // برای CodeEditorActivity (با CodeEditor) - نسخه جدید با پارامتر fileType
  public PluginLoaderImpl runInCodeEditor(
      CodeEditor editor, CodeEditorActivity ceActivity, String fileType) {
    PluginLoader loader =
        new PluginLoader()
            .setEditor(editor)
            .setCodeEditorActivity(ceActivity)
            .setFileType(fileType);
    loader.loadAllPlugins(DEFAULT_CONFIG_PATH);
    return this;
  }

  public PluginLoaderImpl runInFileManager(FileManagerActivity fmActivity, String configPath) {
    PluginLoader loader = new PluginLoader().setFileManagerActivity(fmActivity);
    loader.loadAllPlugins(configPath);
    return this;
  }

  public void registerChildForFileManager(Child child) {
    PluginChildRegistry.registerFileManagerChild(child);
  }

  public void registerChildForCodeEditor(Child child) {
    PluginChildRegistry.registerCodeEditorChild(child);
  }
}