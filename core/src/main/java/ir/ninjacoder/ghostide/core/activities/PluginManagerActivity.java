package ir.ninjacoder.ghostide.core.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import ir.ninjacoder.ghostide.core.R;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ir.ninjacoder.ghostide.core.adapter.PluginAdapter;
import ir.ninjacoder.ghostide.core.model.PlModel;
import ir.ninjacoder.ghostide.core.pl.PluginLoaderImpl;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.prograsssheet.databinding.LayoutPluginActivityBinding;
import java.util.ArrayList;
import java.util.List;

public class PluginManagerActivity extends BaseCompat {
  private List<PlModel> originalList;
  private PluginAdapter adapter;
  private Gson gson;
  private LayoutPluginActivityBinding bind;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    bind = LayoutPluginActivityBinding.inflate(getLayoutInflater());
    setContentView(bind.getRoot());
    gson = new GsonBuilder().setPrettyPrinting().create(); // برای فرمت کردن
    loadPluginData();
    setupSearch();
    setSupportActionBar(bind.toolbar);
    bind.fabmod.setIconResource(R.drawable.ic_add);
    bind.fabmod.setOnClickListener(
        it -> {
          DataUtil.showMessage(it.getContext(), "Soon");
        });
  }

  private void loadPluginData() {
    String jsonData = FileUtil.readFile(PluginLoaderImpl.DEFAULT_CONFIG_PATH);
    originalList = gson.fromJson(jsonData, new TypeToken<List<PlModel>>() {}.getType());

    adapter =
        new PluginAdapter(
            originalList,
            new PluginAdapter.OnPluginStateChangeListener() {
              @Override
              public void onPluginStateChanged() {
                savePluginData();
              }
            });

    bind.rvplugin.setLayoutManager(new LinearLayoutManager(this));
    bind.rvplugin.setAdapter(adapter);
  }

  private void savePluginData() {
    String updatedJson = gson.toJson(originalList);
    FileUtil.writeFile(PluginLoaderImpl.DEFAULT_CONFIG_PATH, updatedJson);
  }

  private void setupSearch() {
    bind.inputpluginsearch
        .getEditText()
        .addTextChangedListener(
            new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

              @Override
              public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.filter(s.toString());

                if (s.length() > 0) {
                  bind.inputpluginsearch.setEndIconVisible(true);
                } else {
                  bind.inputpluginsearch.setEndIconVisible(false);
                }
              }

              @Override
              public void afterTextChanged(Editable s) {}
            });

    bind.inputpluginsearch.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
    bind.inputpluginsearch.setEndIconVisible(false);
  }
}
