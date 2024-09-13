package Ninja.coder.Ghostemane.code.model;

import Ninja.coder.Ghostemane.code.IdeEditor;
import Ninja.coder.Ghostemane.code.adapter.ThemeAdapter;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoadTheme {

  protected static final String ThemePath =
      "/storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost";
  private HashMap<String, Object> map = new HashMap<>();
  private HashMap<String, Object> add = new HashMap<>();
  private HashMap<String, Object> file = new HashMap<>();

  private ArrayList<String> key = new ArrayList<>();
  private ArrayList<HashMap<String, Object>> list = new ArrayList<>();

  public void runinSheet(Context context,IdeEditor editor) {
    RecyclerView listview = new RecyclerView(context);
    MaterialAlertDialogBuilder sheet = new MaterialAlertDialogBuilder(context);
    sheet.setTitle("Theme Maanager");
    sheet.setPositiveButton("dismiss", null);
    sheet.setCancelable(false);

    sheet.setNegativeButton(
        "save",
        (c, d) -> {
          try {
            file = new HashMap<>();
            for (int f = 0; f < (int) (list.size()); f++) {
              file.put(
                  list.get((int) f).get("key").toString(), list.get((int) f).get("hex").toString());
            }
            FileUtil.writeFile(
                "/storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost",
                new Gson().toJson(file));

          } catch (Exception err) {
            err.printStackTrace();
          }
        });

    RecyclerView.LayoutParams param =
        new RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);

    if (listview != null) {
      sheet.setView(listview);
    }
    if (sheet != null) {
      sheet.show();
    }
    try {
      map =
          new Gson()
              .fromJson(
                  new FileReader(ThemePath), new TypeToken<HashMap<String, Object>>() {}.getType());
      getAllKeysFromMap(map, key);
      for (int i = 0; i < (int) (key.size()); i++) {
        add = new HashMap<>();
        add.put("hex", map.get(key.get((int) i)).toString());
        add.put("key", key.get((int) i));
        list.add(add);
      }
      listview.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
      listview.setAdapter(new ThemeAdapter(list,editor));

    } catch (Exception e) {

    }
  }

  public void getAllKeysFromMap(Map<String, Object> _map, ArrayList<String> _output) {
    if (_output == null) return;
    _output.clear();
    if (_map == null || _map.size() < 1) return;
    for (Map.Entry<String, Object> _entry : _map.entrySet()) {
      _output.add(_entry.getKey());
    }
  }
}
