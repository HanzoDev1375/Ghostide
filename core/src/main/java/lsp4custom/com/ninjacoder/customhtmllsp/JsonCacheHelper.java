package lsp4custom.com.ninjacoder.customhtmllsp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import io.github.rosemoe.sora.data.CompletionItem;

public class JsonCacheHelper {
  private static final String TAG = "JsonCacheHelper";
  private static final Gson gson = new Gson();

  public static void saveToJson(File cacheFile, List<CompletionItem> items) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(cacheFile))) {
      writer.write(gson.toJson(items));
      Log.i(TAG, "Saved to JSON: " + cacheFile.getName());
    } catch (IOException e) {
      Log.e(TAG, "Save failed", e);
    }
  }

  public static List<CompletionItem> loadFromJson(File cacheFile) {
    try (BufferedReader reader = new BufferedReader(new FileReader(cacheFile))) {
      Type type = new TypeToken<List<CompletionItem>>() {}.getType();
      return gson.fromJson(reader, type);
    } catch (IOException e) {
      Log.e(TAG, "Load failed", e);
      return null;
    }
  }
}
