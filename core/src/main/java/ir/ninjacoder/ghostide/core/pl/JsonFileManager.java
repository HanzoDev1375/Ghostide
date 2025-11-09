package ir.ninjacoder.ghostide.core.pl;

import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import ir.ninjacoder.ghostide.core.pl.PluginConfig;
import ir.ninjacoder.ghostide.core.pl.PluginManifest;

public class JsonFileManager {
  private static final String TAG = "JsonFileManager";
  private static final Gson gson = new Gson();

  public static List<PluginConfig.PluginInfo> loadMainConfig(String configPath) {
    try {
      File configFile = new File(configPath);
      if (!configFile.exists()) {
        Log.w(TAG, "فایل کانفیگ وجود ندارد: " + configPath);
        return new ArrayList<>();
      }

      FileReader reader = new FileReader(configFile);
      PluginConfig.PluginInfo[] pluginsArray =
          gson.fromJson(reader, PluginConfig.PluginInfo[].class);
      reader.close();

      List<PluginConfig.PluginInfo> plugins = new ArrayList<>();
      if (pluginsArray != null) {
        for (PluginConfig.PluginInfo plugin : pluginsArray) {
          if (plugin.isIsusing()) {
            plugins.add(plugin);
            Log.d(
                TAG,
                "پلاگین فعال بارگذاری شد: " + plugin.getName() + " - نوع: " + plugin.getType());
          } else {
            Log.d(TAG, "پلاگین غیرفعال نادیده گرفته شد: " + plugin.getName());
          }
        }
      }
      return plugins;

    } catch (Exception e) {
      Log.e(TAG, "خطا در خواندن کانفیگ", e);
      return new ArrayList<>();
    }
  }

  public static PluginManifest loadPluginManifest(String manifestPath) {
    try {
      File manifestFile = new File(manifestPath);
      if (!manifestFile.exists()) {
        Log.e(TAG, "فایل manifest وجود ندارد: " + manifestPath);
        return null;
      }

      FileReader reader = new FileReader(manifestFile);
      PluginManifest manifest = gson.fromJson(reader, PluginManifest.class);
      reader.close();

      return manifest;
    } catch (Exception e) {
      Log.e(TAG, "خطا در خواندن manifest", e);
      return null;
    }
  }

  public static boolean saveMainConfig(String configPath, List<PluginConfig.PluginInfo> plugins) {
    try {
      File configFile = new File(configPath);
      FileWriter writer = new FileWriter(configFile);
      gson.toJson(plugins.toArray(new PluginConfig.PluginInfo[0]), writer);
      writer.close();
      Log.d(TAG, "کانفیگ با موفقیت ذخیره شد");
      return true;
    } catch (Exception e) {
      Log.e(TAG, "خطا در ذخیره کانفیگ", e);
      return false;
    }
  }
}
