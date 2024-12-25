package ir.ninjacoder.ghostide.databin;

import ir.ninjacoder.ghostide.utils.FileUtil;

import android.content.Context;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OpenLastFile {
  public static final String openFilePath =
      "/storage/emulated/0/GhostWebIDE/ninjacoder/openFile.json";

  private String get() {
    List<Map<String, String>> map = new ArrayList<>();
    map =
        new Gson()
            .fromJson(
                FileUtil.readFile(openFilePath),
                new TypeToken<List<Map<String, String>>>() {}.getType());
    if (isNotJsonIsNull()) {
      for (var it : map) {
        return it.get("path");
      }
    }
    return "[]";
  }

  public void runAsDialogChild(Context context, OnOpenFileChange open) {
    var dialog = new MaterialAlertDialogBuilder(context);
    dialog.setTitle("Open Loast file?");
    dialog.setMessage("Now Open File " + get() + " in Editor?");
    dialog.setPositiveButton(
        android.R.string.ok,
        (___, __) -> {
          open.open(get());
        });
    dialog.show();
  }

  boolean isNotJsonIsNull() {
    JsonParser parser = new JsonParser();
    JsonElement jsonElement = parser.parse(FileUtil.readFile(openFilePath));
    if (jsonElement.isJsonArray()) {
      return true;
    } else if (jsonElement.isJsonNull()) {
      return false;
    }
    return false;
  }

  public interface OnOpenFileChange {
    void open(String path);
  }
}
