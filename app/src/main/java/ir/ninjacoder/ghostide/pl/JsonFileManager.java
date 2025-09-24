package ir.ninjacoder.ghostide.pl;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
          plugins.add(plugin);
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
}
