package ir.ninjacoder.ghostide.model;

import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.GsonBuilder;
import com.ninjacoder.jgit.databinding.SearchLayoutBinderBinding;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.adapter.ThemeAdapter;
import ir.ninjacoder.ghostide.utils.FileUtil;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadTheme {
  private Map<String, Object> map = new HashMap<>();
  private HashMap<String, Object> add = new HashMap<>();
  private HashMap<String, Object> file = new HashMap<>();

  private List<String> key = new ArrayList<>();
  private List<HashMap<String, Object>> list = new ArrayList<>();
  private List<HashMap<String, Object>> filteredList = new ArrayList<>();
  private SearchLayoutBinderBinding bind;

  private ThemeAdapter adapter;

  public void runinSheet(Context context, IdeEditor editor) {
    runinSheet(context, editor, "/storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost");
  }

  public void runinSheet(Context context, IdeEditor editor, String pathuser) {
      bind = SearchLayoutBinderBinding.inflate(LayoutInflater.from(context));
    RecyclerView listview = bind.rvsearchmain;
    MaterialAlertDialogBuilder sheet = new MaterialAlertDialogBuilder(context);
    sheet.setTitle("Theme Manager");
    sheet.setPositiveButton("dismiss", null);
    sheet.setCancelable(false);

    sheet.setNegativeButton(
        "save",
        (c, d) -> {
          try {
            file = new HashMap<>();
            for (int f = 0; f < list.size(); f++) {
              file.put(list.get(f).get("key").toString(), list.get(f).get("hex").toString());
            }
            var gson = new GsonBuilder().setPrettyPrinting().create();
            FileUtil.writeFile(pathuser, gson.toJson(file));
            ThreadUtils.runOnUiThread(
                () -> {
                  ((AppCompatActivity)context).recreate();
                });

          } catch (Exception err) {
            err.printStackTrace();
          }
        });
    EditText searchEditText = bind.searchbar.getEditText();
    searchEditText.setHint("Search...");
    sheet.setView(bind.getRoot());
    if (sheet != null) {
      sheet.show();
    }
    try {
      map =
          new Gson()
              .fromJson(
                  new FileReader(pathuser), new TypeToken<HashMap<String, Object>>() {}.getType());
      getAllKeysFromMap(map, key);
      for (int i = 0; i < key.size(); i++) {
        add = new HashMap<>();
        add.put("hex", map.get(key.get(i)).toString());
        add.put("key", key.get(i));
        list.add(add);
      }
      bind.emptyviewtree.setVisibility(list.isEmpty() ? View.VISIBLE  : View.GONE);
      filteredList.addAll(list);
      listview.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
      adapter = new ThemeAdapter(filteredList, editor);
      listview.setAdapter(adapter);
      searchEditText.addTextChangedListener(
          new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              filter(charSequence.toString());
              adapter.setSearchText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
          });

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void filter(String text) {
    filteredList.clear();
    if (text.isEmpty()) {
      filteredList.addAll(list);
    } else {
      text = text.toLowerCase();
      for (HashMap<String, Object> item : list) {
        if (item.get("key").toString().toLowerCase().contains(text)) {
          filteredList.add(item);
        }
      }
    }
    adapter.notifyDataSetChanged();
  }

  public void getAllKeysFromMap(Map<String, Object> map, List<String> output) {
    if (output == null) return;
    output.clear();
    if (map == null || map.size() < 1) return;
    for (Map.Entry<String, Object> entry : map.entrySet()) {
      output.add(entry.getKey());
    }
  }
}
