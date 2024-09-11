package Ninja.coder.Ghostemane.code.model;

import Ninja.coder.Ghostemane.code.adapter.ThemeAdpter;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.ListView;
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

  public void runinSheet(Context context) {
    ListView listview = new ListView(context);
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

    ListView.LayoutParams param =
        new ListView.LayoutParams(
            ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT);
    listview.setDividerHeight(0);
    listview.setScrollBarSize(0);
    listview.setEdgeEffectColor(0);

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
      for (int koss_ninja_coder = 0; koss_ninja_coder < (int) (key.size()); koss_ninja_coder++) {
        add = new HashMap<>();
        add.put("hex", map.get(key.get((int) (koss_ninja_coder))).toString());
        add.put("key", key.get((int) (koss_ninja_coder)));
        list.add(add);
      }
      listview.setAdapter(new ThemeAdpter(list));
      ((BaseAdapter) listview.getAdapter()).notifyDataSetChanged();
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
