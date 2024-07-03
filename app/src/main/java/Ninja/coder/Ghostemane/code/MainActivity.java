package Ninja.coder.Ghostemane.code;

import Ninja.coder.Ghostemane.code.activities.BaseCompat;
import Ninja.coder.Ghostemane.code.activities.FileDirActivity;
import Ninja.coder.Ghostemane.code.activities.StreamSoftAppActivity;
import Ninja.coder.Ghostemane.code.utils.AssetsSoft;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import Ninja.coder.Ghostemane.code.utils.SetThemeForJson;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.hzy.lib7z.IExtractCallback;
import com.hzy.lib7z.Z7Extractor;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseCompat {

  protected AssetsSoft soft;
  private Timer _timer = new Timer();
  private String bin = "";
  private Intent gotopage = new Intent();
  private TimerTask ask;

  private SharedPreferences setac;
  private TextView tv_main;
  protected LinearProgressIndicator prograssBar;
  protected LinearLayout layout_main;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.main);
    initialize(_savedInstanceState);
    tv_main = findViewById(R.id.tv_main_unzip);
    layout_main = findViewById(R.id.layout_vis_main);
    prograssBar = findViewById(R.id.prograssBar_Main_UnZip);

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            == PackageManager.PERMISSION_DENIED
        || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_DENIED
        || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_DENIED) {
      ActivityCompat.requestPermissions(
          this,
          new String[] {
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
          },
          1000);
    } else {
      initializeLogic();
    }
  }

  @Override
  public void onRequestPermissionsResult(
      int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == 1000) {
      initializeLogic();
    }
  }

  private void initialize(Bundle _savedInstanceState) {
    setac = getSharedPreferences("setac", Activity.MODE_PRIVATE);
    ThemeChaker();
  }

  private void initializeLogic() {
    var mypath = getFilesDir().getAbsolutePath() + "/" + "databins";

    if (!FileUtil.isExistFile(mypath)) {
      nameFile("databins.7z");

    } else if (!FileUtil.isExistFile(
        getFilesDir().getAbsolutePath() + File.separator + "files" + File.separator + "env.sh")) {
      nameFile("python.7z");
      // start
    } else {
      startApp();
    }
    if (!FileUtil.isExistFile(
        getFilesDir().getAbsolutePath() + File.separator + "lib" + File.separator + "libx265.so")) {
      nameFile("lib.7z");
    } else {
      startApp();
    }
    if (!FileUtil.isExistFile("/storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost")) {
      SetThemeForJson.winterToPath();
    } else {
      Log.e("File is ExistFile", "");
      startApp();
    }

    if (!FileUtil.isExistFile("/storage/emulated/0/GhostWebIDE/android/android.jar")) {
      var asster = getAssets();
      Z7Extractor.extractAsset(
          asster,
          "android.7z",
          "/storage/emulated/0/GhostWebIDE/android/",
          new IExtractCallback() {

            @Override
            public void onError(int arg0, String arg1) {}

            @Override
            public void onGetFileNum(int arg0) {}

            @Override
            public void onProgress(String arg0, long arg1) {}

            @Override
            public void onStart() {}

            @Override
            public void onSucceed() {
              Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
            }
          });
    } else {
      
    }

    if (!FileUtil.isExistFile(getFilesDir().getAbsolutePath() + File.separator + "php.ini")) {
      var softApi = new AssetsSoft();
      softApi.copyOneFileFromAssets("php.ini", getFilesDir().getAbsolutePath() + "/", this);
    } else Log.e("File Copyed", AssetsSoft.class.getSimpleName());

    FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/");
    FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/.icon");
    FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/android");
    FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/theme");
    FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/ninjacoder");
    FileUtil.makeDir("/storage/emulated/0/ghostweb/icon/vector");
    FileUtil.makeDir("/storage/emulated/0/ghostweb/icon/svg");
    FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/font");
    FileUtil.makeDir("/storage/emulated/0/GhostWebIDE/apk");
  }

  void startApp() {
    ask =
        new TimerTask() {
          @Override
          public void run() {
            runOnUiThread(
                () -> {
                  if (setac.getString("ac", "").equals("true")) {
                    gotopage.setClass(getApplicationContext(), FileDirActivity.class);
                    gotopage.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(gotopage);
                  } else {
                    if (setac.getString("ac", "").equals("false")) {
                      gotopage.setClass(getApplicationContext(), StreamSoftAppActivity.class);
                      gotopage.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                      startActivity(gotopage);
                    } else {
                      gotopage.setClass(getApplicationContext(), StreamSoftAppActivity.class);
                      gotopage.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                      startActivity(gotopage);
                    }
                  }
                });
          }
        };

    _timer.schedule(ask, 3000);
  }

  void nameFile(String name) {
    layout_main.setVisibility(View.VISIBLE);
    new Thread(
            () -> {
              AssetManager manager = getAssets();
              Z7Extractor.extractAsset(
                  manager,
                  name,
                  getFilesDir().getAbsolutePath(),
                  new IExtractCallback() {

                    @Override
                    public void onError(int arg0, String arg1) {
                      startApp();
                    }

                    @Override
                    public void onGetFileNum(int arg0) {}

                    @Override
                    public void onProgress(String s, long tr) {
                      runOnUiThread(
                          () -> {
                            tv_main.setText(s);

                            prograssBar.setProgressCompat((int) tr, true);
                          });
                    }

                    @Override
                    public void onStart() {
                      runOnUiThread(
                          () -> {
                            tv_main.setText("Start...");
                          });
                    }

                    @Override
                    public void onSucceed() {
                      Log.i("TAG", "all file unziped");
                    }
                  });
            })
        .start();
  }
}
