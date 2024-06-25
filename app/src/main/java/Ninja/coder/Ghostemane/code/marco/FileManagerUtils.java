package Ninja.coder.Ghostemane.code.marco;

import Ninja.coder.Ghostemane.code.activities.BaseCompat;
import Ninja.coder.Ghostemane.code.tasks.app.ProgressDialogCompat;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.app.ProgressDialog;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.hzy.lib7z.IExtractCallback;
import com.hzy.lib7z.Z7Extractor;

public class FileManagerUtils {

  protected static String iconFile = "/storage/emulated/0/GhostWebIDE/icon.zip";
  private static String iconPath = "/storage/emulated/0/GhostWebIDE/";
  protected BaseCompat compat;

  public FileManagerUtils(BaseCompat compat) {
    this.compat = compat;
    init();
  }

  public void init() {
    Extract_icon();
  }

  private void Extract_icon() {
    if (FileUtil.isExistFile(iconFile)) {
      FileUtil.makeDir(iconPath);
      var dialogCompat = new ProgressDialogCompat(compat, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
      dialogCompat.setTitle("install Icon");
      dialogCompat.setProgressStyle(ProgressDialogCompat.STYLE_HORIZONTAL);
      dialogCompat.setMax(100);
      dialogCompat.show();
      dialogCompat.setProgressDrawable(
          new ColorDrawable(MaterialColors.getColor(compat, ColorAndroid12.colorOnSurface, 0)));
      dialogCompat.getWindow().setBackgroundDrawable(custom());
      AssetManager manager = compat.getAssets();
      new Thread(
              () -> {
                Z7Extractor.extractAsset(
                    manager,
                    "icon.7z",
                    iconPath,
                    new IExtractCallback() {

                      @Override
                      public void onError(int code, String massges) {
                        runInUi(
                            () -> {
                              dialogCompat.setMessage("Error " + code + " " + manager);
                            });
                      }

                      @Override
                      public void onGetFileNum(int arg0) {}

                      @Override
                      public void onProgress(String name, long size) {
                        runInUi(
                            () -> {
                              dialogCompat.setProgress((int) size);
                              dialogCompat.setMessage(name);
                            });
                      }

                      @Override
                      public void onStart() {
                        runInUi(
                            () -> {
                              dialogCompat.setMessage("Start unzip icon..");
                            });
                      }

                      @Override
                      public void onSucceed() {
                        runInUi(
                            () -> {
                              if (dialogCompat != null) {
                                dialogCompat.dismiss();
                              }
                            });
                      }
                    });
              })
          .start();
    }
  }

  public void MakeFolders() {}

  protected void runInUi(Runnable run) {
    var hb = new Handler(Looper.getMainLooper());
    if (hb != null) {
      hb.post(run);
    }
  }

  private MaterialShapeDrawable custom() {
    var myShap =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.CUT, 20f).build());
    myShap.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(compat, ColorAndroid12.Back, 0)));
    myShap.setStroke(
        0.5f,
        ColorStateList.valueOf(MaterialColors.getColor(compat, ColorAndroid12.colorOnSurface, 0)));
    return myShap;
  }
}
