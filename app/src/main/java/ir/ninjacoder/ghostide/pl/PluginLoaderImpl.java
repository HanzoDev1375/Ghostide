package ir.ninjacoder.ghostide.pl;

import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.activities.CodeEditorActivity;

public class PluginLoaderImpl {

  private static final String DEFAULT_CONFIG_PATH =
      "/storage/emulated/0/GhostWebIDE/plugins/config.json";

  // برای FileManagerActivity (بدون CodeEditor)
  public PluginLoaderImpl runInFileManager(FileManagerActivity fmActivity) {
    PluginLoader loader = new PluginLoader().setFileManagerActivity(fmActivity);
    loader.loadAllPlugins(DEFAULT_CONFIG_PATH);
    return this;
  }

  // برای CodeEditorActivity (با CodeEditor)
  public PluginLoaderImpl runInCodeEditor(CodeEditor editor, CodeEditorActivity ceActivity) {
    PluginLoader loader = new PluginLoader().setEditor(editor).setCodeEditorActivity(ceActivity);
    loader.loadAllPlugins(DEFAULT_CONFIG_PATH);
    return this;
  }

  // متدهای با مسیر کانفیگ دلخواه
  public PluginLoaderImpl runInFileManager(FileManagerActivity fmActivity, String configPath) {
    PluginLoader loader = new PluginLoader().setFileManagerActivity(fmActivity);
    loader.loadAllPlugins(configPath);
    return this;
  }

  public PluginLoaderImpl runInCodeEditor(
      CodeEditor editor, CodeEditorActivity ceActivity, String configPath) {
    PluginLoader loader = new PluginLoader().setEditor(editor).setCodeEditorActivity(ceActivity);
    loader.loadAllPlugins(configPath);
    return this;
  }
}
