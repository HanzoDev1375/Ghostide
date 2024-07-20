package Ninja.coder.Ghostemane.code.Welcome;

import Ninja.coder.Ghostemane.code.MainActivity;
import Ninja.coder.Ghostemane.code.activities.StreamSoftAppActivity;
import Ninja.coder.Ghostemane.code.tasks.app.ProgressDialogCompat;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import Ninja.coder.Ghostemane.code.utils.SetThemeForJson;
import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.github.appintro.AppIntro;
import com.github.appintro.AppIntro2;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;
import com.hzy.lib7z.IExtractCallback;
import com.hzy.lib7z.Z7Extractor;
import java.io.File;

public class SplashWord extends AppIntro2 {
  protected ProgressDialogCompat dialog;

  @Override
  public void onCreate(Bundle arg0) {
    super.onCreate(arg0);
    // TODO: Implement this method
    dialog = new ProgressDialogCompat(this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);

    var mypath = getFilesDir().getAbsolutePath() + "/" + "databins";
    var pythonPath =
        getFilesDir().getAbsolutePath() + File.separator + "files" + File.separator + "env.sh";
    var phpPath =
        getFilesDir().getAbsolutePath() + File.separator + "lib" + File.separator + "libx265.so";
    var ghostPath = "/storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost";

    TestFragment t1 =
        TestFragment.newIns(
            "filePer.json", "به گوست وب خوش امدید لطفا مجوز فایل را بدهید", "مجوز فایل", false);
    t1.setCallBack(
        () -> {
          Toast.makeText(getApplicationContext(), "2", 1).show();
        });

    addSlide(t1);

    TestFragment t2 =
        TestFragment.newIns(
            "theme.json", "لطفا تم را نصب کنید", "تم", !FileUtil.isExistFile(ghostPath));
    t2.setCallBack(
        () -> {
          try {
            if (!FileUtil.isExistFile(ghostPath)) {
              SetThemeForJson.winterToPath();
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
            "phpitem.json", "لطفا php را نصب کنید", "نصب php", !FileUtil.isExistFile(phpPath));
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
            "python.json",
            "پایتون را نصب کنید سپس وارد برنامه شوید ",
            "نصب پایتون",
            !FileUtil.isExistFile(pythonPath));
    t4.setCallBack(
        () -> {
          try {
            if (!FileUtil.isExistFile(mypath)) {
              nameFile("databins.7z");
            } else if (!FileUtil.isExistFile(pythonPath)) {
              nameFile("python.7z");
              // start

            }
          } catch (Exception err) {
            Log.e("Error", err.getLocalizedMessage());
          }
        });

    addSlide(t4);

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

    String[] item = {
      Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    askForPermissions(item, 1);
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
                            dialog.setProgress((int) tr);
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
