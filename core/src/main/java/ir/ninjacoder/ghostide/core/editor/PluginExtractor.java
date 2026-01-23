package ir.ninjacoder.ghostide.core.editor;

import android.content.Context;
import android.view.LayoutInflater;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ninjacoder.jgit.databinding.SheetAddPluginBinding;
import ir.ninjacoder.ghostide.core.activities.FileManagerActivity;
import ir.ninjacoder.ghostide.core.marco.HsiZip;
import ir.ninjacoder.ghostide.core.model.PlModel;
import ir.ninjacoder.ghostide.core.model.PluginMetaData;
import ir.ninjacoder.ghostide.core.pl.PluginManifest;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PluginExtractor implements HsiZip.OnCallBack {
    // تغییر مسیر به محل مورد نظر شما
    private String constPath = "/storage/emulated/0/GhostWebIDE/plugins/";
    private List<PlModel> listPlugin = new ArrayList<>();
    private PluginextractorFace helper;
    private String pgbPath;
    private Context context;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private HsiZip unzipData;
    SheetAddPluginBinding bind;
    private BottomSheetDialog dialog;
   
    private String fileNameWithoutExt, manifestPath;

    // مسیر فایل کانفیگ
    private String configPath = "/storage/emulated/0/GhostWebIDE/plugins/config.json";

    public PluginExtractor(PluginextractorFace helper, String pgbPath, Context context) {
        this.helper = helper;
        this.pgbPath = pgbPath;
        this.context = context;
        bind = SheetAddPluginBinding.inflate(LayoutInflater.from(context));
        dialog = new BottomSheetDialog(context);
        dialog.setContentView(bind.getRoot());
        dialog.show();
        unzipData = new HsiZip(context, this);
        init();
    }

    void init() {
        File file = new File(pgbPath);

        // خواندن کانفیگ از مسیر صحیح
        File configFile = new File(configPath);
        if (configFile.exists()) {
            listPlugin = gson.fromJson(FileUtil.readFile(configPath), new TypeToken<
                    List<PlModel>>() {}.getType());
        } else {
            listPlugin = new ArrayList<>();
        }

        if (file.getName().endsWith(".pgb")) {
            fileNameWithoutExt = file.getName().replace(".pgb", "");
            manifestPath = constPath + fileNameWithoutExt + "/manifest.json";
            bind.editName.setText(fileNameWithoutExt);
            bind.editDir.setText(manifestPath);
            bind.inputType.setHint(".json,.kt");
            bind.inputIcon.setHint("Type Icon dir");
        }

        bind.sheetok.setOnClickListener(
                v -> {
                    dialog.dismiss();
                    PlModel model = new PlModel(
                    fileNameWithoutExt,
                    manifestPath,
                    bind.editDev.getText().toString(),
                    bind.checkUsing.isChecked(),
                    bind.editType.getText().toString(),
                    bind.editIcon.getText().toString());
                    listPlugin.add(model);
                    FileUtil.writeFile(configPath, gson.toJson(listPlugin));
                    String pluginName = file.getName().replace(".pgb", "");
                    String extractPath = constPath + File.separator;

                    File dir = new File(extractPath);
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    unzipData.execute(pgbPath, extractPath);
                });
    }

    @Override
    public void onError() {
        helper.onPluginExtractorError();
    }

    @Override
    public void onResult() {
        helper.onPluginExtractorDone();
    }

    
}
