package ir.ninjacoder.ghostide.core.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.ninjacoder.jgit.databinding.LayoutGitpullBinding;
import com.ninjacoder.jgit.databinding.SheetAddPluginBinding;
import ir.ninjacoder.ghostide.core.R;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ir.ninjacoder.ghostide.core.adapter.PluginAdapter;
import ir.ninjacoder.ghostide.core.model.PlModel;
import ir.ninjacoder.ghostide.core.pl.PluginLoaderImpl;
import ir.ninjacoder.ghostide.core.pl.PluginManifest;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.prograsssheet.databinding.LayoutPluginActivityBinding;
import java.util.ArrayList;
import java.util.List;

public class PluginManagerActivity extends BaseCompat {

  private List<PlModel> originalList;
  private PluginAdapter adapter;
  private Gson gson;
  private PluginManifest manifest;
  private LayoutPluginActivityBinding bind;
  private SheetAddPluginBinding currentSheet;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    bind = LayoutPluginActivityBinding.inflate(getLayoutInflater());
    setContentView(bind.getRoot());
    setSupportActionBar(bind.toolbar);
    gson = new GsonBuilder().setPrettyPrinting().create();

    // اول همه چیز را مخفی کن
    bind.empty.setVisibility(View.GONE);
    bind.rvplugin.setVisibility(View.GONE);
    bind.inputpluginsearch.setVisibility(View.GONE);

    // بررسی وجود فایل config.json
    String configPath = PluginLoaderImpl.DEFAULT_CONFIG_PATH;
    if (!FileUtil.isExistFile(configPath)) {
      // فایل وجود ندارد
      bind.empty.setVisibility(View.VISIBLE);
      bind.emptyicon.setImageResource(R.drawable.drawer_item5);
      bind.fabmod.hide();
    } else {
      // فایل وجود دارد
      bind.fabmod.show();
      bind.fabmod.setIconResource(R.drawable.ic_add);
      bind.fabmod.setOnClickListener(v -> showAddPluginDialog());

      loadPluginData();
    }
  }

  private void loadPluginData() {
    String configPath = PluginLoaderImpl.DEFAULT_CONFIG_PATH;
    if (!FileUtil.isExistFile(configPath)) {
      showEmptyState();
      return;
    }

    String jsonData = FileUtil.readFile(configPath);
    if (jsonData == null || jsonData.trim().isEmpty()) {
      originalList = new ArrayList<>();
    } else {
      try {
        originalList = gson.fromJson(jsonData, new TypeToken<List<PlModel>>() {}.getType());
        if (originalList == null) {
          originalList = new ArrayList<>();
        }
      } catch (Exception e) {
        originalList = new ArrayList<>();
        FileUtil.writeFile(configPath, "[]"); // ریست کردن فایل خراب
      }
    }

    // اطمینان از اینکه هیچ آیتمی null نباشد و using مقدار داشته باشد
    for (int i = originalList.size() - 1; i >= 0; i--) {
      PlModel model = originalList.get(i);
      if (model == null) {
        originalList.remove(i);
        continue;
      }
    }

    if (originalList.isEmpty()) {
      showEmptyState();
    } else {
      showPluginList();
    }
  }

  private void showEmptyState() {
    bind.empty.setVisibility(View.VISIBLE);
    bind.emptyicon.setImageResource(R.drawable.drawer_item5);
    bind.rvplugin.setVisibility(View.GONE);
    bind.inputpluginsearch.setVisibility(View.GONE);
    bind.fabmod.hide();
  }

  private void showPluginList() {
    bind.empty.setVisibility(View.GONE);
    bind.rvplugin.setVisibility(View.VISIBLE);
    bind.inputpluginsearch.setVisibility(View.VISIBLE);
    bind.fabmod.show();

    // ایجاد adapter با لیست تمیز شده
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

    setupSearch();
  }

  private void savePluginData() {
    if (originalList != null) {
      String updatedJson = gson.toJson(originalList);
      FileUtil.writeFile(PluginLoaderImpl.DEFAULT_CONFIG_PATH, updatedJson);
    }
  }

  private void showAddPluginDialog() {
    currentSheet = SheetAddPluginBinding.inflate(getLayoutInflater());
    BottomSheetDialog builder = new BottomSheetDialog(this);
    builder.setContentView(currentSheet.getRoot());

    currentSheet.checkUsing.setText("Using Plugin?");
    currentSheet.checkUsing.setChecked(true);

    String basePluginPath = "/storage/emulated/0/GhostWebIDE/plugins/";
    currentSheet.editDir.setHint("manifestName");

    currentSheet.sheetno.setOnClickListener(v -> builder.dismiss());
    currentSheet.sheetok.setOnClickListener(
        v -> {
          String name = currentSheet.editName.getText().toString().trim();
          String dirInput = currentSheet.editDir.getText().toString().trim();
          String dev = currentSheet.editDev.getText().toString().trim();
          String type = currentSheet.editType.getText().toString().trim();
          String icon = currentSheet.editIcon.getText().toString().trim();
          boolean isUsing = currentSheet.checkUsing.isChecked();

          if (name.isEmpty()) {
            currentSheet.editName.setError("Plugin name is required.");
            return;
          }
          if (dirInput.isEmpty()) {
            currentSheet.editDir.setError("The plugin path is required.");
            return;
          }
          String dir = basePluginPath + dirInput + "manifest.json";
          PlModel newPlugin = new PlModel(name, dir, dev, isUsing, type, icon);
          if (originalList == null) {
            originalList = new ArrayList<>();
          }
          originalList.add(newPlugin);
          savePluginData();
          DataUtil.showMessage(this, "Plugin added successfully.");
          builder.dismiss();
          loadPluginData();
          createManifestForPlugin(dir);
        });

    builder.show();
  }

  private void createManifestForPlugin(String pluginDir) {
    if (pluginDir == null || pluginDir.isEmpty()) {
      DataUtil.showMessage(this, "Invalid plugin directory");
      return;
    }
    if (pluginDir.endsWith("/manifest.json")) {
      pluginDir = pluginDir.substring(0, pluginDir.length() - "/manifest.json".length());
    }
    if (pluginDir.endsWith("/")) {
      pluginDir = pluginDir.substring(0, pluginDir.length() - 1);
    }

    String manifestPath = pluginDir + "/manifest.json";
    if (!FileUtil.isDirectory(pluginDir)) {
      FileUtil.makeDir(pluginDir);
    }
    if (!FileUtil.isExistFile(manifestPath)) {
      PluginManifest defaultManifest = new PluginManifest();
      defaultManifest.setDexpath("");
      defaultManifest.setDexname("");
      defaultManifest.setPkgname("");

      String json = gson.toJson(defaultManifest);
      FileUtil.writeFile(manifestPath, json);
    }

    // ویرایش manifest
    editManifest(manifestPath);
  }

  private void editManifest(String manifestPath) {
    String jsonContent = FileUtil.readFile(manifestPath);
    if (jsonContent == null || jsonContent.isEmpty()) {
      DataUtil.showMessage(this, "Error reading manifest.json");
      return;
    }

    try {
      manifest = gson.fromJson(jsonContent, PluginManifest.class);
      if (manifest == null) {
        manifest = new PluginManifest();
      }
      LayoutGitpullBinding binding = LayoutGitpullBinding.inflate(getLayoutInflater());
      var dialog = new MaterialAlertDialogBuilder(this);
      dialog.setTitle("Plugin Manifest");
      dialog.setView(binding.getRoot());
      dialog.setCancelable(false);

      dialog.setPositiveButton(
          "Save",
          (d, which) -> {
            manifest.setDexpath(binding.userName.getEditText().getText().toString().trim());
            manifest.setDexname(binding.remote.getEditText().getText().toString().trim());
            manifest.setPkgname(binding.token.getEditText().getText().toString().trim());

            String updatedJson = gson.toJson(manifest);
            FileUtil.writeFile(manifestPath, updatedJson);
            DataUtil.showMessage(this, "Changes saved");
          });

      dialog.setNegativeButton("Cancel", null);
      binding
          .userName
          .getEditText()
          .setText(manifest.getDexpath() != null ? manifest.getDexpath() : "");
      binding
          .remote
          .getEditText()
          .setText(manifest.getDexname() != null ? manifest.getDexname() : "");
      binding
          .token
          .getEditText()
          .setText(manifest.getPkgname() != null ? manifest.getPkgname() : "");

      binding.userName.setHint("Dex Path");
      binding.remote.setHint("Dex Name");
      binding.token.setHint("Package Name");

      dialog.show();
    } catch (Exception e) {
      DataUtil.showMessage(this, "Error parsing manifest: " + e.getMessage());
    }
  }

  private void setupSearch() {
    if (adapter == null) return;

    bind.inputpluginsearch
        .getEditText()
        .addTextChangedListener(
            new TextWatcher() {
              @Override
              public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

              @Override
              public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (adapter != null) {
                  adapter.filter(s.toString());
                }
                bind.inputpluginsearch.setEndIconVisible(s.length() > 0);
              }

              @Override
              public void afterTextChanged(Editable s) {}
            });

    bind.inputpluginsearch.setEndIconMode(TextInputLayout.END_ICON_CLEAR_TEXT);
    bind.inputpluginsearch.setEndIconVisible(false);
  }

  @Override
  protected void onResume() {
    super.onResume();
    if (originalList != null) {
      loadPluginData();
    }
  }
}
