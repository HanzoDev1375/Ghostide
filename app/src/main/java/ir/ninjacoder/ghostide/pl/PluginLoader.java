package ir.ninjacoder.ghostide.pl;

import android.util.Log;
import android.widget.Toast;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.List;
import dalvik.system.InMemoryDexClassLoader;

public class PluginLoader {

  public void loadAllPlugins(CodeEditor editor, String configPath) {
    var context = editor.getContext();
    List<PluginConfig.PluginInfo> plugins = JsonFileManager.loadMainConfig(configPath);

    if (plugins.isEmpty()) {
      Log.d("PluginLoader", "هیچ پلاگینی در کانفیگ یافت نشد");
      Toast.makeText(context, "هیچ پلاگینی یافت نشد", Toast.LENGTH_SHORT).show();
      return;
    }

    Log.d("PluginLoader", "تعداد پلاگین‌ها در کانفیگ: " + plugins.size());

    int loadedCount = 0;
    for (PluginConfig.PluginInfo pluginInfo : plugins) {
      if (loadSinglePlugin(editor, pluginInfo)) {
        loadedCount++;
      }
    }

    Toast.makeText(
            context,
            loadedCount + " پلاگین از " + plugins.size() + " با موفقیت لود شد",
            Toast.LENGTH_SHORT)
        .show();
  }

  private boolean loadSinglePlugin(CodeEditor editor, PluginConfig.PluginInfo pluginInfo) {
    var context = editor.getContext();
    try {
      Log.d("PluginLoader", "در حال لود پلاگین: " + pluginInfo.getName());

      // بارگذاری manifest پلاگین
      PluginManifest manifest = JsonFileManager.loadPluginManifest(pluginInfo.getDir());
      if (manifest == null) {
        Log.e("PluginLoader", "Manifest پلاگین یافت نشد: " + pluginInfo.getDir());
        return false;
      }

      // بررسی وجود فایل DEX
      File dexFile = new File(manifest.getDexpath());
      if (!dexFile.exists()) {
        Log.e("PluginLoader", "فایل DEX وجود ندارد: " + manifest.getDexpath());
        return false;
      }

      // خواندن فایل DEX
      FileInputStream fis = new FileInputStream(dexFile);
      byte[] dexBytes = new byte[(int) dexFile.length()];
      fis.read(dexBytes);
      fis.close();

      // ایجاد ClassLoader و لود کلاس
      ByteBuffer dexBuffer = ByteBuffer.wrap(dexBytes);
      InMemoryDexClassLoader classLoader =
          new InMemoryDexClassLoader(dexBuffer, getClass().getClassLoader());

      String fullClassName = manifest.getPkgname() + "." + manifest.getDexname();
      Class<?> pluginClass = classLoader.loadClass(fullClassName);

      // بررسی اینکه کلاس PluginManagerCompat را پیاده سازی کرده باشد
      if (!PluginManagerCompat.class.isAssignableFrom(pluginClass)) {
        Log.e(
            "PluginLoader",
            "کلاس پلاگین باید PluginManagerCompat را پیاده سازی کند: " + fullClassName);
        return false;
      }

      // ایجاد نمونه از پلاگین
      PluginManagerCompat pluginInstance = (PluginManagerCompat) pluginClass.newInstance();

      // فراخوانی متدهای اینترفیس
      pluginInstance.getEditor(editor);

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
