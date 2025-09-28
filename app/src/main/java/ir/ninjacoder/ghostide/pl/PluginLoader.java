package ir.ninjacoder.ghostide.pl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.activities.CodeEditorActivity;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.List;
import dalvik.system.InMemoryDexClassLoader;

public class PluginLoader {

  private FileManagerActivity fileManagerActivity;
  private CodeEditorActivity codeEditorActivity;
  private CodeEditor editor;
  private Context context;

  public PluginLoader setEditor(CodeEditor editor) {
    this.editor = editor;
    if (editor != null) {
      this.context = editor.getContext();
    }
    return this;
  }

  public PluginLoader setFileManagerActivity(FileManagerActivity activity) {
    this.fileManagerActivity = activity;
    if (context == null) {
      this.context = activity;
    }
    return this;
  }

  public PluginLoader setCodeEditorActivity(CodeEditorActivity activity) {
    this.codeEditorActivity = activity;
    if (context == null) {
      this.context = activity;
    }
    return this;
  }

  public void loadAllPlugins(String configPath) {
    if (context == null) {
      Log.e("PluginLoader", "Context تنظیم نشده است");
      return;
    }

    List<PluginConfig.PluginInfo> plugins = JsonFileManager.loadMainConfig(configPath);

    if (plugins.isEmpty()) {
      Log.d("PluginLoader", "هیچ پلاگینی در کانفیگ یافت نشد");
      Toast.makeText(context, "هیچ پلاگینی یافت نشد", Toast.LENGTH_SHORT).show();
      return;
    }

    Log.d("PluginLoader", "تعداد پلاگین‌ها در کانفیگ: " + plugins.size());

    int loadedCount = 0;
    for (PluginConfig.PluginInfo pluginInfo : plugins) {
      if (loadSinglePlugin(pluginInfo)) {
        loadedCount++;
      }
    }

    Toast.makeText(
            context,
            loadedCount + " پلاگین از " + plugins.size() + " با موفقیت لود شد",
            Toast.LENGTH_SHORT)
        .show();
  }

  private boolean loadSinglePlugin(PluginConfig.PluginInfo pluginInfo) {
    try {
      Log.d("PluginLoader", "در حال لود پلاگین: " + pluginInfo.getName());

      PluginManifest manifest = JsonFileManager.loadPluginManifest(pluginInfo.getDir());
      if (manifest == null) {
        Log.e("PluginLoader", "Manifest پلاگین یافت نشد: " + pluginInfo.getDir());
        return false;
      }

      File dexFile = new File(manifest.getDexpath());
      if (!dexFile.exists()) {
        Log.e("PluginLoader", "فایل DEX وجود ندارد: " + manifest.getDexpath());
        return false;
      }

      FileInputStream fis = new FileInputStream(dexFile);
      byte[] dexBytes = new byte[(int) dexFile.length()];
      fis.read(dexBytes);
      fis.close();

      ByteBuffer dexBuffer = ByteBuffer.wrap(dexBytes);
      InMemoryDexClassLoader classLoader =
          new InMemoryDexClassLoader(dexBuffer, getClass().getClassLoader());

      String fullClassName = manifest.getPkgname() + "." + manifest.getDexname();
      Class<?> pluginClass = classLoader.loadClass(fullClassName);

      if (!PluginManagerCompat.class.isAssignableFrom(pluginClass)) {
        Log.e(
            "PluginLoader",
            "کلاس پلاگین باید PluginManagerCompat را پیاده سازی کند: " + fullClassName);
        return false;
      }

      PluginManagerCompat pluginInstance = (PluginManagerCompat) pluginClass.newInstance();

      // فراخوانی getEditor فقط اگر editor وجود دارد
      if (editor != null) {
        pluginInstance.getEditor(editor);
      }

      if (fileManagerActivity != null) {
        pluginInstance.getFileManagerAc(fileManagerActivity);
      }

      if (codeEditorActivity != null) {
        pluginInstance.getCodeEditorAc(codeEditorActivity);
      }

      String pluginName = pluginInstance.setName();
      boolean isUsing = pluginInstance.hasuseing();

      Log.d("PluginLoader", "پلاگین با موفقیت لود شد: " + pluginName + " - فعال: " + isUsing);
      return true;

    } catch (Exception e) {
      Log.e("PluginLoader", "خطا در لود پلاگین: " + pluginInfo.getName(), e);
      return false;
    }
  }
}
