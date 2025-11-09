package ir.ninjacoder.ghostide.core.activities;

import android.app.ProgressDialog;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.hzy.lib7z.Z7Extractor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.marco.HsiZip;
import ir.ninjacoder.ghostide.core.utils.AssetsSoft;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class PluginManagerActivity extends BaseCompat {

  protected AssetsSoft soft;
  private Toolbar _toolbar;
  private AppBarLayout _app_bar;
  private CoordinatorLayout _coordinator;

  private LinearLayout linear1;
  private LinearLayout linear2;
  private LinearLayout linear4;
  private LinearLayout linear5;
  private TextView textview1;
  private LinearLayout fileChker;
  private TextView textview2;
  private LinearLayout fileChker2;
  private TextView textview3;
  private LinearLayout linear6;
  private String keyboardName = "rkr.simplekeyboard.inputmethod";
  private ProgressDialog dialog;
  private RecyclerView rv_pl;
  private List<ir.ninjacoder.ghostide.PluginManager.ModelPackage.PackageModels> model;
  private ir.ninjacoder.ghostide.PluginManager.ModelPackage.WorkPackageManager work;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.plugin_manager);
    initialize(_savedInstanceState);
    initializeLogic();
  }

  private void initialize(Bundle _savedInstanceState) {
    _app_bar = findViewById(R.id._app_bar);
    _coordinator = findViewById(R.id._coordinator);
    _toolbar = findViewById(R.id._toolbar);
    setSupportActionBar(_toolbar);
    rv_pl = findViewById(R.id.rv_pl);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    _toolbar.setNavigationOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _v) {
            finish();
          }
        });
    linear1 = findViewById(R.id.linear1);
    linear2 = findViewById(R.id.linear2);
    linear4 = findViewById(R.id.linear4);
    linear5 = findViewById(R.id.linear5);
    textview1 = findViewById(R.id.textview1);
    fileChker = findViewById(R.id.fileChker);
    textview2 = findViewById(R.id.textview2);
    fileChker2 = findViewById(R.id.fileChker2);
    textview3 = findViewById(R.id.textview3);
    linear6 = findViewById(R.id.linear6);
    model = new ArrayList<>();
    model.add(
        new ir.ninjacoder.ghostide.PluginManager.ModelPackage.PackageModels(
            "rkr.simplekeyboard.inputmethod",
            "rkr.simplekeyboard.inputmethod.latin.settings.SettingsActivity",
            true,
            true));
    rv_pl.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    rv_pl.setAdapter(
        new ir.ninjacoder.ghostide.PluginManager.ModelPackage.PackageAd(
            model,
            this,
            new ir.ninjacoder.ghostide.PluginManager.ModelPackage.PackageAd.OnClick() {

              @Override
              public void Click(View view, int pos) {}
            }));

    linear2.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if (!FileUtil.isExistFile(
                getFilesDir().getAbsolutePath()
                    + File.separator
                    + "files"
                    + File.separator
                    + "env.sh")) {
              fileChker.setBackground(
                  new GradientDrawable() {
                    public GradientDrawable getIns(int a, int b) {
                      this.setCornerRadius(a);
                      this.setColor(b);
                      return this;
                    }
                  }.getIns((int) 99, Color.parseColor("#FFF44336")));

              try {
                AlertDialog dialog =
                    new MaterialAlertDialogBuilder(PluginManagerActivity.this)
                        .setTitle("Loading...")
                        .setMessage("")
                        .setPositiveButton("Done", null)
                        .setCancelable(false)
                        .create();
                dialog.show();
                new Thread(
                        new Runnable() {
                          @Override
                          public void run() {
                            AssetManager assetManager = getApplicationContext().getAssets();

                            Z7Extractor.extractAsset(
                                assetManager,
                                "python.7z",
                                getFilesDir().getAbsolutePath(),
                                new com.hzy.lib7z.IExtractCallback() {
                                  @Override
                                  public void onProgress(final String name, final long size) {
                                    runOnUiThread(
                                        () -> {
                                          dialog.setMessage(name);
                                        });
                                  }

                                  @Override
                                  public void onError(int errorCode, final String error) {
                                    runOnUiThread(
                                        () -> {
                                          dialog.setMessage(
                                              "CodeError " + errorCode + "Error " + error);
                                        });
                                  }

                                  @Override
                                  public void onSucceed() {
                                    runOnUiThread(
                                        () -> {
                                          if (dialog != null) dialog.dismiss();
                                          fileChker.setBackground(
                                              new GradientDrawable() {
                                                public GradientDrawable getIns(int a, int b) {
                                                  this.setCornerRadius(a);
                                                  this.setColor(b);
                                                  return this;
                                                }
                                              }.getIns((int) 99, 0xFF4CAF50));
                                        });
                                  }

                                  @Override
                                  public void onStart() {
                                    runOnUiThread(
                                        () -> {
                                          dialog.setMessage("Starting...");
                                          fileChker.setBackground(
                                              new GradientDrawable() {
                                                public GradientDrawable getIns(int a, int b) {
                                                  this.setCornerRadius(a);
                                                  this.setColor(b);
                                                  return this;
                                                }
                                              }.getIns((int) 99, 0xFFF44336));
                                        });
                                  }

                                  @Override
                                  public void onGetFileNum(int size) {}
                                });
                          }
                        })
                    .start();
              } catch (Exception E) {
                Toast.makeText(getApplicationContext(), E.getMessage(), Toast.LENGTH_SHORT).show();
              }

            } else {
              fileChker.setBackground(
                  new GradientDrawable() {
                    public GradientDrawable getIns(int a, int b) {
                      this.setCornerRadius(a);
                      this.setColor(b);
                      return this;
                    }
                  }.getIns((int) 99, 0xFF4CAF50));
            }
          }
        });

    linear5.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if (!FileUtil.isExistFile(
                getFilesDir().getAbsolutePath() + File.separator + "libaom.so")) {
              linear6.setBackground(
                  new GradientDrawable() {
                    public GradientDrawable getIns(int a, int b) {
                      this.setCornerRadius(a);
                      this.setColor(b);
                      return this;
                    }
                  }.getIns((int) 99, 0xFFF44336));

              try {
                AlertDialog dialog =
                    new MaterialAlertDialogBuilder(PluginManagerActivity.this)
                        .setTitle("Loading...")
                        .setMessage("")
                        .setPositiveButton("Done", null)
                        .setCancelable(false)
                        .create();
                dialog.show();
                new Thread(
                        new Runnable() {
                          @Override
                          public void run() {
                            AssetManager assetManager = getApplicationContext().getAssets();

                            Z7Extractor.extractAsset(
                                assetManager,
                                "lib.7z",
                                getFilesDir().getAbsolutePath(),
                                new com.hzy.lib7z.IExtractCallback() {
                                  @Override
                                  public void onProgress(final String name, final long size) {
                                    runOnUiThread(
                                        () -> {
                                          dialog.setMessage(name);
                                        });
                                  }

                                  @Override
                                  public void onError(int errorCode, final String error) {
                                    runOnUiThread(
                                        () -> {
                                          dialog.setMessage(
                                              "CodeError " + errorCode + "Error " + error);
                                        });
                                  }

                                  @Override
                                  public void onSucceed() {
                                    runOnUiThread(
                                        () -> {
                                          if (dialog != null) dialog.dismiss();
                                          linear6.setBackground(
                                              new GradientDrawable() {
                                                public GradientDrawable getIns(int a, int b) {
                                                  this.setCornerRadius(a);
                                                  this.setColor(b);
                                                  return this;
                                                }
                                              }.getIns((int) 99, 0xFF4CAF50));
                                        });
                                  }

                                  @Override
                                  public void onStart() {
                                    runOnUiThread(
                                        () -> {
                                          dialog.setMessage("Starting...");
                                          linear6.setBackground(
                                              new GradientDrawable() {
                                                public GradientDrawable getIns(int a, int b) {
                                                  this.setCornerRadius(a);
                                                  this.setColor(b);
                                                  return this;
                                                }
                                              }.getIns(99, 0xFFF44336));
                                        });
                                  }

                                  @Override
                                  public void onGetFileNum(int size) {}
                                });
                          }
                        })
                    .start();
              } catch (Exception E) {
                Toast.makeText(getApplicationContext(), E.getMessage(), Toast.LENGTH_SHORT).show();
              }

            } else {
              linear6.setBackground(
                  new GradientDrawable() {
                    public GradientDrawable getIns(int a, int b) {
                      this.setCornerRadius(a);
                      this.setColor(b);
                      return this;
                    }
                  }.getIns((int) 99, 0xFF4CAF50));
            }
          }
        });
  }

  private void initializeLogic() {

    soft = new AssetsSoft();

    // soft.z();
    dialog = new ProgressDialog(PluginManagerActivity.this);
    if (!FileUtil.isExistFile(
        getFilesDir().getAbsolutePath() + File.separator + "files" + File.separator + "env.sh")) {
      fileChker.setBackground(
          new GradientDrawable() {
            public GradientDrawable getIns(int a, int b) {
              this.setCornerRadius(a);
              this.setColor(b);
              return this;
            }
          }.getIns((int) 99, 0xFFF44336));
    } else {
      fileChker.setBackground(
          new GradientDrawable() {
            public GradientDrawable getIns(int a, int b) {
              this.setCornerRadius(a);
              this.setColor(b);
              return this;
            }
          }.getIns(99, 0xFF4CAF50));
    }
    if (!FileUtil.isExistFile(getFilesDir().getAbsolutePath().concat("gcc.zip"))) {
      fileChker2.setBackground(
          new GradientDrawable() {
            public GradientDrawable getIns(int a, int b) {
              this.setCornerRadius(a);
              this.setColor(b);
              return this;
            }
          }.getIns(99, 0xFF4CAF50));
    } else {
      fileChker2.setBackground(
          new GradientDrawable() {
            public GradientDrawable getIns(int a, int b) {
              this.setCornerRadius(a);
              this.setColor(b);
              return this;
            }
          }.getIns(99, 0xFFF44336));
    }
    //// data/user/0/ir.ninjacoder.ghostide/files/lib
    if (FileUtil.isExistFile(
        getFilesDir().getAbsolutePath()
            + File.separator
            + "files"
            + File.separator
            + "libs"
            + File.separator
            + "libaom.so")) {
      linear6.setBackground(
          new GradientDrawable() {
            public GradientDrawable getIns(int a, int b) {
              this.setCornerRadius(a);
              this.setColor(b);
              return this;
            }
          }.getIns(99, 0xFFF44336));
    } else {
      linear6.setBackground(
          new GradientDrawable() {
            public GradientDrawable getIns(int a, int b) {
              this.setCornerRadius(a);
              this.setColor(b);
              return this;
            }
          }.getIns((int) 99, 0xFF4CAF50));
    }
    ObjectUtils.setToolbarinit(_toolbar);
    _clickAnimation(linear2);
    _clickAnimation(linear4);
    _clickAnimation(linear5);
    linear2.setElevation((float) 3);
    linear4.setElevation((float) 3);
    ObjectUtils.setTextColor(textview1);
    ObjectUtils.setTextColor(textview2);
    ObjectUtils.setTextColor(textview3);
  }

  public void _clickAnimation(final View _view) {
    ScaleAnimation fade_in =
        new ScaleAnimation(
            0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
    fade_in.setDuration(300);
    fade_in.setFillAfter(true);
    _view.startAnimation(fade_in);
  }

  public void _hsiunzip(final String _input, final String _output) {
    HsiZip task =
        new HsiZip(
            this,
            new HsiZip.OnCallBack() {

              @Override
              public void onError() {}

              @Override
              public void onResult() {}
            });
    task.execute(_input, _output);
  }

  public void showMessage(String _s) {
    Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
  }
}
