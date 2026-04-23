package ir.ninjacoder.ghostide.core.editor;

import android.content.Context;
import android.view.LayoutInflater;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ninjacoder.jgit.databinding.SheetAddPluginBinding;
import ir.ninjacoder.ghostide.core.marco.binder.bindchilder.GhostToast;
import ir.ninjacoder.ghostide.core.model.PlModel;
import ir.ninjacoder.ghostide.core.model.PluginMetaData;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import ir.ninjacoder.prograsssheet.enums.StateMod;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.ZipFile;

public class PluginExtractor {
  private String constPath = "/storage/emulated/0/GhostWebIDE/plugins/";
  private List<PlModel> listPlugin = new ArrayList<>();
  private PluginextractorFace helper;
  private String pgbPath;
  private Context context;
  private Gson gson = new GsonBuilder().setPrettyPrinting().create();
  SheetAddPluginBinding bind;
  private BottomSheetDialog dialog;
  private PlModel model;
  private PluginMetaData meta;
  private String fileNameWithoutExt;
  private String configPath = "/storage/emulated/0/GhostWebIDE/plugins/config.json";

  public PluginExtractor(PluginextractorFace helper, String pgbPath, Context context) {
    this.helper = helper;
    this.pgbPath = pgbPath;
    this.context = context;
    bind = SheetAddPluginBinding.inflate(LayoutInflater.from(context));
    dialog = new BottomSheetDialog(context);
    dialog.setContentView(bind.getRoot());
    dialog.show();

    try {
      init();
    } catch (Exception err) {
      err.printStackTrace();
    }
  }

  void init() throws Exception {
    File file = new File(pgbPath);
    File configFile = new File(configPath);

    if (configFile.exists()) {
      String existingJson = FileUtil.readFile(configPath);
      if (existingJson != null && !existingJson.isEmpty()) {
        listPlugin = gson.fromJson(existingJson, new TypeToken<List<PlModel>>() {}.getType());
      } else {
        listPlugin = new ArrayList<>();
      }
    } else {
      listPlugin = new ArrayList<>();
    }

    if (file.getName().endsWith(".pgb")) {
      fileNameWithoutExt = file.getName().replace(".pgb", "");
      String pluginFolderPath = constPath + fileNameWithoutExt;
      bind.editName.setText(fileNameWithoutExt);
      bind.editDir.setText(pluginFolderPath);
      bind.inputType.setHint(".json,.kt");
      bind.inputIcon.setHint("Type Icon dir");
    }

    try (ZipFile zipFile = new ZipFile(pgbPath)) {
      var metadataHeader = zipFile.getFileHeader("metadata.json");
      if (metadataHeader != null) {
        try (var inputStream = zipFile.getInputStream(metadataHeader);
             var reader = new InputStreamReader(inputStream)) {
          meta = gson.fromJson(reader, PluginMetaData.class);
          if (meta != null) {
            bind.editName.setText(meta.getPluginName());
            bind.editDir.setText(meta.getPluginPath());
            bind.editDev.setText(meta.getPluginName());
            bind.editType.setText(meta.getPluginType());
            bind.editIcon.setText(meta.getPluginIcon());
            bind.checkUsing.setChecked(meta.getPluginUsing());
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    String finalPluginName = bind.editName.getText().toString();
    String finalPluginPath = bind.editDir.getText().toString();

    model = new PlModel(
        finalPluginName,
        finalPluginPath,
        bind.editDev.getText().toString(),
        bind.checkUsing.isChecked(),
        bind.editType.getText().toString(),
        bind.editIcon.getText().toString()
    );

    boolean isDuplicate = false;
    for (PlModel existing : listPlugin) {
      if (existing.getName().equals(model.getName())) {
        isDuplicate = true;
        break;
      }
    }

    final boolean finalIsDuplicate = isDuplicate;

    bind.sheetok.setOnClickListener(v -> {
      dialog.dismiss();

      if (finalIsDuplicate) {
        GhostToast.showWarning(context, "This plugin already exists!");
        return;
      }

      listPlugin.add(model);
      FileUtil.writeFile(configPath, gson.toJson(listPlugin));

      String pluginName = file.getName().replace(".pgb", "");
      String extractPath = constPath + pluginName + "/";

      File dir = new File(extractPath);
      if (!dir.exists()) {
        dir.mkdirs();
      }

      extractZipFile(pgbPath, extractPath);
    });
  }

  private void extractZipFile(String zipPath, String destinationPath) {
    PrograssSheet sheet = new PrograssSheet(context);
    sheet.setMode(StateMod.PROGRASSV);
    sheet.setTitle("Loading....");
    sheet.setSubTitle("Loading...");
    sheet.show();

    new Thread(() -> {
      try {
        ZipFile zipFile = new ZipFile(zipPath);
        zipFile.extractAll(destinationPath);

        File metadataFile = new File(destinationPath + "metadata.json");
        if (metadataFile.exists()) {
          metadataFile.delete();
        }

        ThreadUtils.runOnUiThread(() -> {
          helper.onPluginExtractorDone();
          sheet.dismiss();
        });

      } catch (Exception e) {
        e.printStackTrace();
        ThreadUtils.runOnUiThread(() -> {
          helper.onPluginExtractorError();
          sheet.dismiss();
          GhostToast.showError(context, e.getMessage());
          ClipboardUtils.copyText(e.getMessage());
        });
      }
    }).start();
  }
}