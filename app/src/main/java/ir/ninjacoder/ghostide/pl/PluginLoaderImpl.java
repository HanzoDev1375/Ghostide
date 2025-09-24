package ir.ninjacoder.ghostide.pl;

import io.github.rosemoe.sora.widget.CodeEditor;

public class PluginLoaderImpl {

  private static final String DEFAULT_CONFIG_PATH =
      "/storage/emulated/0/ghostide/plugins/config.json";

  // این متد تمام پلاگین‌ها را از config.json اجرا می‌کند
  public PluginLoaderImpl run(CodeEditor editor) {
    PluginLoader loader = new PluginLoader();
    loader.loadAllPlugins(editor, DEFAULT_CONFIG_PATH);
    return this;
  }

  // متد اضافی اگر بخواهید مسیر کانفیگ عوض شود
  public PluginLoaderImpl run(CodeEditor editor, String configPath) {
    PluginLoader loader = new PluginLoader();
    loader.loadAllPlugins(editor, configPath);
    return this;
  }
}
