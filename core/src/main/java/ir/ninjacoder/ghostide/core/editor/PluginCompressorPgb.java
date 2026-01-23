package ir.ninjacoder.ghostide.core.editor;

import android.content.Context;

import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ir.ninjacoder.ghostide.core.model.PlModel;
import ir.ninjacoder.ghostide.core.model.PluginMetaData;
import ir.ninjacoder.ghostide.core.pl.PluginManifest;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import ir.ninjacoder.prograsssheet.enums.StateMod;

import net.lingala.zip4j.ZipFile;

import java.io.File;
import java.util.List;

public class PluginCompressorPgb {

  private static final String PLUGIN_ROOT = "/storage/emulated/0/GhostWebIDE/plugins/";

  private static final String CONFIG_PATH = PLUGIN_ROOT + "config.json";

  private final PluginextractorFace helper;
  private final Context context;
  private final String clickedPath;
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  private PrograssSheet sheet;

  public PluginCompressorPgb(PluginextractorFace helper, Context context, String clickedPath) {

    this.helper = helper;
    this.context = context;
    this.clickedPath = clickedPath;
    sheet = new PrograssSheet(context);
    init();
  }

  private void init() {
    new MaterialAlertDialogBuilder(context)
        .setTitle("Make Pgb File?")
        .setPositiveButton(android.R.string.ok, (d, w) -> startCompress())
        .setNegativeButton(android.R.string.no, (d, w) -> sheet.dismiss())
        .show();
  }

  private void startCompress() {
    sheet.setTitle("Loading...");
    sheet.setMode(StateMod.PROGRASSH);
    sheet.show();

    new Thread(
            () -> {
              try {

                /* ---------- 1. نرمال‌سازی مسیر کلیک ---------- */
                File clicked = new File(clickedPath).getCanonicalFile();

                if (!clicked.getAbsolutePath().startsWith(PLUGIN_ROOT)) {
                  throw new IllegalStateException("Outside plugin root");
                }

                /* ---------- 2. خواندن config ---------- */
                List<PlModel> plugins =
                    gson.fromJson(
                        FileUtil.readFile(CONFIG_PATH),
                        new TypeToken<List<PlModel>>() {}.getType());

                if (plugins == null || plugins.isEmpty()) {
                  throw new IllegalStateException("config.json empty");
                }

                /* ---------- 3. پیدا کردن پلاگین فقط از config ---------- */
                PlModel target = null;
                File pluginDir = null;

                for (PlModel it : plugins) {

                  File dirFromConfig = new File(it.getDir()).getCanonicalFile();

                  File baseDir =
                      dirFromConfig.isDirectory() ? dirFromConfig : dirFromConfig.getParentFile();

                  if (baseDir == null) continue;

                  if (clicked.getAbsolutePath().startsWith(baseDir.getAbsolutePath())) {

                    target = it;
                    pluginDir = baseDir;
                    break;
                  }
                }

                if (target == null || pluginDir == null) {
                  throw new IllegalStateException("Plugin not registered in config");
                }

                /* ---------- 4. بررسی manifest ---------- */
                File manifestFile = new File(pluginDir, "manifest.json");

                if (!manifestFile.exists()) {
                  throw new IllegalStateException("manifest.json missing");
                }

                PluginManifest manifest =
                    gson.fromJson(
                        FileUtil.readFile(manifestFile.getAbsolutePath()), PluginManifest.class);

                if (manifest == null) {
                  throw new IllegalStateException("Invalid manifest");
                }

                /* ---------- 5. ساخت metadata ---------- */
                PluginMetaData metaData =
                    new PluginMetaData(
                        target.getName(),
                        pluginDir.getAbsolutePath(),
                        target.getIcon(),
                        target.getIsusing(),
                        target.getType(),
                        manifest.getDexname(),
                        manifest.getDexpath(),
                        manifest.getPkgname());

                String metaPath = context.getCacheDir() + "/metadata.json";

                FileUtil.writeFile(metaPath, gson.toJson(metaData));

                /* ---------- 6. ساخت pgb ---------- */
                String outZip = pluginDir.getAbsolutePath() + ".pgb";

                ZipFile zipFile = new ZipFile(outZip);

                File[] files = pluginDir.listFiles();
                if (files != null) {
                  for (File f : files) {
                    if (f.isDirectory()) {
                      zipFile.addFolder(f);
                    } else {
                      zipFile.addFile(f);
                    }
                  }
                }

                zipFile.addFile(new File(metaPath));
                FileUtil.deleteFile(metaPath);

                ThreadUtils.runOnUiThread(
                    () -> {
                      try {
                        zipFile.close();
                      } catch (Exception err) {

                      }
                      sheet.dismiss();
                      helper.onPluginExtractorDone();
                    });

              } catch (Exception e) {
                ThreadUtils.runOnUiThread(
                    () -> {
                      sheet.dismiss();
                      helper.onPluginExtractorError();
                    });
              }
            })
        .start();
  }
}
