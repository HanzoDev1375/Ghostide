package ir.ninjacoder.ghostide.core.pl;

import android.content.Context;
import android.util.Log;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import dalvik.system.InMemoryDexClassLoader;
import io.github.rosemoe.sora.widget.CodeEditor;
import ir.ninjacoder.ghostide.core.activities.CodeEditorActivity;
import ir.ninjacoder.ghostide.core.activities.FileManagerActivity;

public class PluginLoader {

  private FileManagerActivity fileManagerActivity;
  private CodeEditorActivity codeEditorActivity;
  private BaseCompat basecompat;
  private CodeEditor editor;
  private Context context;
  private String currentFileType;

  private List<InMemoryDexClassLoader> activeClassLoaders = new ArrayList<>();

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

  public PluginLoader setBaseCompatActivity(BaseCompat activity) {
    this.basecompat = activity;
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

  public PluginLoader setFileType(String fileType) {
    this.currentFileType = fileType;
    return this;
  }

  public void clearAllPlugins() {
    activeClassLoaders.clear();

    System.gc();
    Log.d("PluginLoader", "تمامی پلاگین‌ها پاک شدند");
  }

  public void reloadAllPlugins(String configPath) {
    clearAllPlugins();
    loadAllPlugins(configPath);
  }

  public void loadAllPlugins(String configPath) {
    if (context == null) {
      Log.e("PluginLoader", "Context تنظیم نشده است");
      return;
    }

    List<PluginConfig.PluginInfo> plugins = JsonFileManager.loadMainConfig(configPath);

    if (plugins.isEmpty()) {
      Log.d("PluginLoader", "هیچ پلاگین فعالی در کانفیگ یافت نشد");
      
      return;
    }

    Log.d(
        "PluginLoader",
        "تعداد پلاگینهای فعال: " + plugins.size() + " - نوع فایل جاری: " + currentFileType);

    int loadedCount = 0;
    for (PluginConfig.PluginInfo pluginInfo : plugins) {
      if (loadSinglePlugin(pluginInfo)) {
        loadedCount++;
      }
    }
  }

  private boolean loadSinglePlugin(PluginConfig.PluginInfo pluginInfo) {
    try {
      Log.d("PluginLoader", "در حال لود پلاگین: " + pluginInfo.getName());

      if (!pluginInfo.isIsusing()) {
        Log.d("PluginLoader", "پلاگین غیرفعال است: " + pluginInfo.getName());
        return false;
      }

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

      activeClassLoaders.add(classLoader);

      Class<?> pluginClass = null;

      if (manifest.getDexname() != null && !manifest.getDexname().isEmpty()) {
        try {
          String fullClassName = manifest.getPkgname() + "." + manifest.getDexname();
          pluginClass = classLoader.loadClass(fullClassName);
          Log.d("PluginLoader", "کلاس از طریق manifest پیدا شد: " + fullClassName);
        } catch (ClassNotFoundException e) {
          Log.w("PluginLoader", "کلاس مشخص شده در manifest پیدا نشد، جستجوی خودکار شروع می‌شود");
        }
      }

      if (pluginClass == null) {
        pluginClass =
            PluginClassFinder.findPluginCompatibleClass(classLoader, manifest.getPkgname());
        if (pluginClass != null) {
          Log.d("PluginLoader", "کلاس از طریق جستجوی خودکار پیدا شد: " + pluginClass.getName());
        }
      }

      if (pluginClass == null) {
        Log.e("PluginLoader", "هیچ کلاس سازگاری پیدا نشد برای پلاگین: " + pluginInfo.getName());
        return false;
      }

      if (!PluginManagerCompat.class.isAssignableFrom(pluginClass)) {
        Log.e(
            "PluginLoader",
            "کلاس پلاگین باید PluginManagerCompat را پیاده سازی کند: " + pluginClass.getName());
        return false;
      }

      PluginManagerCompat pluginInstance = (PluginManagerCompat) pluginClass.newInstance();

      String pluginSupportedType = pluginInstance.langModel();
      boolean shouldApplyPlugin = true;

      if (pluginInfo.getType() != null && !pluginInfo.getType().isEmpty()) {
        pluginSupportedType = pluginInfo.getType();
      }

      if (pluginSupportedType != null
          && !pluginSupportedType.isEmpty()
          && currentFileType != null) {
        String[] supportedTypes = pluginSupportedType.split(",");
        shouldApplyPlugin = false;
        for (String type : supportedTypes) {
          if (type.trim().equalsIgnoreCase(currentFileType)) {
            shouldApplyPlugin = true;
            break;
          }
        }

        Log.d(
            "PluginLoader",
            "بررسی تطابق نوع فایل - پلاگین: "
                + pluginSupportedType
                + " - فایل جاری: "
                + currentFileType
                + " - اعمال: "
                + shouldApplyPlugin);
      }

      if (shouldApplyPlugin) {
        if (editor != null) {
          pluginInstance.getEditor(editor);
        }

        if (fileManagerActivity != null) {
          pluginInstance.getFileManagerAc(fileManagerActivity);
        }

        if (codeEditorActivity != null) {
          pluginInstance.getCodeEditorAc(codeEditorActivity);
        }
        if(basecompat != null) {
        	pluginInstance.getBaseCompat(basecompat);
        }

        String pluginName = pluginInstance.setName();
        boolean isUsing = pluginInstance.hasuseing();

        Log.d(
            "PluginLoader",
            "پلاگین با موفقیت لود شد: "
                + pluginName
                + " - فعال: "
                + isUsing
                + " - برای فایل: "
                + pluginSupportedType);
        return true;
      } else {
        Log.d(
            "PluginLoader",
            "پلاگین "
                + pluginInfo.getName()
                + " برای فایل نوع "
                + pluginSupportedType
                + " است و اعمال نشد (فایل جاری: "
                + currentFileType
                + ")");
        return false;
      }

    } catch (Exception e) {
      Log.e("PluginLoader", "خطا در لود پلاگین: " + pluginInfo.getName(), e);
      return false;
    }
  }
}
