package ir.ninjacoder.ghostide.Welcome;

import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.activities.StreamSoftAppActivity;
import ir.ninjacoder.ghostide.utils.FileUtil;
import ir.ninjacoder.ghostide.utils.ThemeUtils;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.github.appintro.AppIntro2;
import com.github.appintro.AppIntroPageTransformerType;
import com.hzy.lib7z.IExtractCallback;
import com.hzy.lib7z.Z7Extractor;
import ir.ninjacoder.prograsssheet.PrograssSheet;
import ir.ninjacoder.prograsssheet.enums.StateMod;
import java.io.File;

public class SplashWord extends AppIntro2 {
  protected PrograssSheet dialog;

  @Override
  public void onCreate(Bundle arg0) {
    super.onCreate(arg0);
    // TODO: Implement this method
    dialog = new PrograssSheet(this);
    dialog.setMode(StateMod.PROGRASSV);
    dialog.setCancelable(false);

    var mypath = getFilesDir().getAbsolutePath() + "/" + "databins";
    var pythonPath =
        getFilesDir().getAbsolutePath() + File.separator + "env.sh";
    var phpPath =
        getFilesDir().getAbsolutePath() + File.separator + "lib" + File.separator + "libx265.so";
    var ghostPath = "/storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost";
    var ghostStyle = "/storage/emulated/0/GhostWebIDE/theme/style.ghost";

    TestFragment t1 =
        TestFragment.newIns(
            "prm.json",
            "Permissions",
            "Submit all files",
            true);
    t1.setCallBack(
        () -> {
          
        });

    addSlide(t1);

    TestFragment t2 =
        TestFragment.newIns(
            "theme.json",
            getString(R.string.inittheme),
            getString(R.string.theme),
            !FileUtil.isExistFile(ghostPath) || !FileUtil.isExistFile(ghostStyle));
    t2.setCallBack(
        () -> {
          FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/");
          FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/.icon");
          FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/android");
          FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/theme");
          FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/ninjacoder");
          FileUtil.makeDir("/storage/emulated/0/ghostweb/icon/vector");
          FileUtil.makeDir("/storage/emulated/0/ghostweb/icon/svg");
          FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/font");
          FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/apk");
          FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/appicon");
          try {
            if (!FileUtil.isExistFile(ghostPath)) {
              ThemeUtils.winterToPath();
            } else {
              Log.e("File is ExistFile", "");
            }
          } catch (Exception err) {
            Log.e("Error ", err.getLocalizedMessage());
          }
        });

    addSlide(t2);
    TestFragment t3 =
        TestFragment.newIns(
            "phpitem.json", "Php", getString(R.string.initphp), !FileUtil.isExistFile(phpPath));
    t3.setCallBack(
        () -> {
          try {
            if (!FileUtil.isExistFile(phpPath)) {
              nameFile("lib.7z");
            }
          } catch (Exception err) {
            Log.e("Error ", err.getLocalizedMessage());
          }
        });

    addSlide(t3);
    TestFragment t4 =
        TestFragment.newIns(
            "python.json", getString(R.string.initpy), "Python", !FileUtil.isExistFile(pythonPath));
    t4.setCallBack(
        () -> {
          try {
            if (!FileUtil.isExistFile(pythonPath)) {
              nameFile("python.7z");
              // start
            }
          } catch (Exception err) {
            Log.e("Error", err.getLocalizedMessage());
          }
        });

    if (!FileUtil.isExistFile(mypath)) {
      nameFile("databins.7z");
    } else {
      Log.d("Done", "");
    }

    addSlide(t4);
    var gccAngelpath =
        getFilesDir().getAbsolutePath()
            + File.separator
            + "c_compiler"
            + File.separator
            + "gcc"
            + File.separator
            + "plugin_version";

    setTransformer(AppIntroPageTransformerType.Zoom.INSTANCE);
    showStatusBar(true);
    setSystemBackButtonLocked(false);
    setWizardMode(true);
    setImmersiveMode();
    setIndicatorEnabled(true);
    setButtonsEnabled(true);
    setProgressIndicator();
    setNextArrowColor(Color.YELLOW);
    setSkipArrowColor(Color.RED);
    setBarColor(0);
    setNavBarColor(0);
  }

  @Override
  protected void onSkipPressed(Fragment currentFragment) {
    super.onSkipPressed(currentFragment);
    startActivity(new Intent(this, StreamSoftAppActivity.class));
  }

  @Override
  protected void onDonePressed(Fragment currentFragment) {
    super.onDonePressed(currentFragment);
    startActivity(new Intent(this, StreamSoftAppActivity.class));
  }

  void nameFile(String name) {
    dialog.show();
    new Thread(
            () -> {
              AssetManager manager = getAssets();
              Z7Extractor.extractAsset(
                  manager,
                  name,
                  getFilesDir().getAbsolutePath(),
                  new IExtractCallback() {

                    @Override
                    public void onError(int arg0, String arg1) {}

                    @Override
                    public void onGetFileNum(int arg0) {}

                    @Override
                    public void onProgress(String s, long tr) {
                      runOnUiThread(
                          () -> {
                            dialog.setPrograss((int) tr, false);
                          });
                    }

                    @Override
                    public void onStart() {
                      runOnUiThread(
                          () -> {
                            dialog.setTitle("Start...");
                          });
                    }

                    @Override
                    public void onSucceed() {
                      Log.i("TAG", "all file unziped");
                      runOnUiThread(() -> dialog.dismiss());
                    }
                  });
            })
        .start();
  }

  
}
