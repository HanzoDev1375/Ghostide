package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.marco.WallpaperParallaxEffect;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import Ninja.coder.Ghostemane.code.utils.ReSizeApp;
import Ninja.coder.Ghostemane.code.utils.SetThemeForJson;
import Ninja.coder.Ghostemane.code.widget.BlurImage;
import android.animation.ObjectAnimator;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.io.File;

public class BaseCompat extends AppCompatActivity {
  protected static String color = "#ff201B16";
  protected static int SDKINT = Build.VERSION.SDK_INT;
  protected static int SDKVERSION = Build.VERSION_CODES.LOLLIPOP;
  protected static String packApp = "Ninja.coder.Ghostemane.code";
  protected AlertDialog db;
  protected File file;
  protected MaterialAlertDialogBuilder dialogerror;
  protected GradientDrawable gb = new GradientDrawable();
  private SharedPreferences thememanagersoft;
  private WallpaperParallaxEffect effect;
  private static String ThemePath = "/storage/emulated/0/GhostWebIDE/theme/GhostThemeapp.ghost";

  @Nullable
  @Override
  protected void onCreate(@Nullable Bundle saveInStatous) {
    super.onCreate(saveInStatous);
    initErrorDialogpackageAPP();
    AppMozer();
    thememanagersoft = getSharedPreferences("thememanagersoft", MODE_PRIVATE);

    initParseWallpapaer();
    if (Build.VERSION.SDK_INT >= 28)
      getWindow()
          .setNavigationBarDividerColor(MaterialColors.getColor(this, ColorAndroid12.TvColor, 0));
    /// using system Wallpapar
    if (Build.VERSION.SDK_INT >= 21)
      getWindow().setNavigationBarColor(MaterialColors.getColor(this, ColorAndroid12.Back, 0));
    if (Build.VERSION.SDK_INT >= 21)
      getWindow().setStatusBarColor(MaterialColors.getColor(this, ColorAndroid12.Back, 0));

    setBackGroundIsMobile();
  }

  private BaseCompat initErrorDialogpackageAPP() {
    if (!getApplicationContext().getPackageManager().equals(packApp)) {

    } else {
      dialogErrors(
          "Package name error",
          "You have changed the package name of the program and this made the program unable to run");
    }
    return this;
  }

  public BaseCompat typefaceAsster(EditText editText, String typeNameFont) {
    editText.setTypeface(Typeface.createFromAsset(getAssets(), typeNameFont));
    return this;
  }

  public BaseCompat typefaceAsster(TextView editText, String typeNameFont) {
    editText.setTypeface(Typeface.createFromAsset(getAssets(), typeNameFont));
    return this;
  }

  public BaseCompat typefaceinFile(TextView textView, File file) {
    textView.setTypeface(Typeface.createFromFile(file));
    return this;
  }

  public BaseCompat typefaceinFile(EditText textView, File file) {

    textView.setTypeface(Typeface.createFromFile(file));
    return this;
  }

  protected BaseCompat dialogColor(
      int color, MaterialAlertDialogBuilder dialogBuilder, int Stoker) {
    gb.setColor(color);
    gb.setStroke(1, Stoker);
    gb.setCornerRadius((float) 20);
    dialogBuilder.setBackground(gb);
    return this;
  }

  public BaseCompat dialogErrors(String title, String msg) {
    dialogerror = new MaterialAlertDialogBuilder(BaseCompat.this);
    dialogerror.setTitle(title);
    dialogerror.setMessage(msg);

    dialogerror.setPositiveButton(
        "exit",
        (d, v) -> {
          finishAffinity();
        });
    dialogColor(Color.RED, dialogerror, Color.BLACK);
    dialogerror.show();
    return this;
  }

  public BaseCompat pass() {
    return this;
  }

  public BaseCompat ClickEffcat(View view) {
    view.setOnTouchListener(
        (v, event) -> {
          switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
              {
                ObjectAnimator scaleX = new ObjectAnimator();
                scaleX.setTarget(view);
                scaleX.setPropertyName("scaleX");
                scaleX.setFloatValues(0.9f);
                scaleX.setDuration((int) 5);
                scaleX.start();
                ObjectAnimator scaleY = new ObjectAnimator();
                scaleY.setTarget(view);
                scaleY.setPropertyName("scaleY");
                scaleY.setFloatValues(0.9f);
                scaleY.setDuration((int) 5);
                scaleY.start();
                break;
              }
            case MotionEvent.ACTION_UP:
              {
                ObjectAnimator scaleX = new ObjectAnimator();
                scaleX.setTarget(view);
                scaleX.setPropertyName("scaleX");
                scaleX.setFloatValues((float) 1);
                scaleX.setDuration((int) 5);
                scaleX.start();
                ObjectAnimator scaleY = new ObjectAnimator();
                scaleY.setTarget(view);
                scaleY.setPropertyName("scaleY");
                scaleY.setFloatValues((float) 1);
                scaleY.setDuration((int) 5);
                scaleY.start();
                break;
              }
          }
          return false;
        });
    return this;
  }

  public BaseCompat autoColorText(TextView textView) {
    if (textView != null) {
      textView.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFCB07D")));
    }
    return this;
  }

  public BaseCompat setFitWindows(Toolbar toolbar) {
    toolbar.setFitsSystemWindows(true);
    return this;
  }

  public BaseCompat setFitWindows(CoordinatorLayout coordinatorLayout) {
    coordinatorLayout.setFitsSystemWindows(true);
    return this;
  }

  public BaseCompat setFitWindows(LinearLayout linearLayout) {
    linearLayout.setFitsSystemWindows(true);
    return this;
  }

  public BaseCompat setFitWindows(AppBarLayout appBarLayout) {
    try {
      appBarLayout.setFitsSystemWindows(true);
    } catch (Exception exception) {
      throw new RuntimeException(exception.toString());
    }
    return this;
  }

  public BaseCompat WindowsMath(DrawerLayout layout, CoordinatorLayout coordinatorLayout) {
    try {
      layout.setDrawerListener(
          new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
              View getView = coordinatorLayout;
              float translationOffset = (drawerView.getWidth() * slideOffset) * 0.03f;
              float scaleOffset = 1 - (slideOffset * 0.0515f);
              getView.setScaleX(scaleOffset);
              getView.setScaleY(scaleOffset);
              getView.setTranslationX(translationOffset);
              getView.setPivotX(getView.getMeasuredWidth());
              getView.setPivotY(0);
              getView.invalidate();
            }

            @Override
            public void onDrawerOpened(View drawerView) {}

            @Override
            public void onDrawerClosed(View drawerView) {}

            @Override
            public void onDrawerStateChanged(int newState) {}
          });
    } catch (Exception exception) {
      throw new RuntimeException(exception.toString());
    }
    return this;
  }

  public BaseCompat WindowsSetLiner(RecyclerView recyclerView) {
    try {
      ViewCompat.setOnApplyWindowInsetsListener(
          recyclerView,
          new OnApplyWindowInsetsListener() {
            @Override
            public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
              v.setPadding(0, 0, 0, insets.getSystemWindowInsetBottom());
              return insets;
            }
          });
    } catch (Exception exception) {
      throw new RuntimeException(exception.getMessage());
    }
    return this;
  }

  public void initWindowsCompatMath() {
    WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
  }

  public BaseCompat autoSize(TextView textView, float size) {
    ReSizeApp.resize(textView, this, size);
    return this;
  }

  public BaseCompat autoSize(TextView textView) {
    ReSizeApp.resize(textView, this);
    return this;
  }

  public BaseCompat colorPrograssBar(ProgressBar bar) {
    int[] apl = {
      Color.parseColor("#FFFFB584"),
      Color.parseColor("#FFFF8884"),
      Color.parseColor("#FFDAFF84"),
      Color.parseColor("#FF84FFB1"),
      Color.parseColor("#FF84FFD8"),
      Color.parseColor("#FF84FDFF"),
      Color.parseColor("#FF84D4FF"),
      Color.parseColor("#FF8A84FF"),
      Color.parseColor("#FFB584FF"),
      Color.parseColor("#FFF984FF"),
      Color.parseColor("#FFFF84D6"),
      Color.parseColor("#FFFF84B3")
    };
    CircularProgressDrawable app = new CircularProgressDrawable(this);
    app.setStrokeWidth(6f);
    app.setCenterRadius(10f);
    app.setArrowEnabled(true);
    app.setStrokeCap(Paint.Cap.ROUND);
    app.setArrowScale(10f);
    app.setColorSchemeColors(apl);
    app.start();
    bar.setIndeterminateDrawable((Drawable) app);
    return this;
  }

  public BaseCompat setShapeListSet(ListView fab) {
    MaterialShapeDrawable shapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.CUT, 13f).build());
    shapeDrawable.setFillColor(ColorStateList.valueOf(0xFFFCB07D));
    fab.setSelector(shapeDrawable);
    return this;
  }

  private void AppMozer() {
    String packageName = "HR.Blockly";
    PackageManager packageManager = getPackageManager();
    try {
      packageManager.getPackageInfo(packageName, 0);
      DialogUnsitallApp(packageName);
    } catch (PackageManager.NameNotFoundException e) {

    }
  }

  private void DialogUnsitallApp(String packageName) {
    MaterialAlertDialogBuilder di = new MaterialAlertDialogBuilder(BaseCompat.this);
    di.setTitle("حذف برنامه مضر");
    di.setMessage(
        "ببخشید برنامه با نام (بلاکلی) یک بدافزار است که اطلاعات شما را سرقت میکند لطفا برای حذف برنامه گزینه حذف را بزنید.");
    di.setCancelable(false);
    di.setPositiveButton(
        "حذف",
        (p1, d2) -> {
          Uri packageURI = Uri.parse("package:".concat(packageName));
          Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
          startActivity(uninstallIntent);
        });
    di.show();
  }

  public void initParseWallpapaer() {

    effect = new WallpaperParallaxEffect(this);
    effect.setCallback(
        (offsetX, offsetY, angle) -> {
          float progress = 1.0f;
          var views = getWindow().getDecorView();
          views.setTranslationX(offsetX * progress);
          views.setTranslationY(offsetY * progress);
        });
    effect.setEnabled(thememanagersoft.contains("effect") ? true : false);
  }

  public interface BaseInterfaceCompat {
    int result();

    void RoadFile(File f);

    void nullU();
  }

  public void getGitHub() {
    var i = new Intent();
    i.setData(Uri.parse("https://github.com/appt2/Ghost-web-ide"));
    i.setAction(Intent.ACTION_VIEW);
    startActivity(i);
  }

  public void setLink(String site) {
    var i = new Intent();
    i.setData(Uri.parse(site));
    i.setAction(Intent.ACTION_VIEW);
    startActivity(i);
  }

  public void Wall() {
    var data = thememanagersoft.contains("br") ? thememanagersoft.getFloat("br", 2) : 3;
    BlurImage.setBlurInWallpaperMobile(this, data, getWindow().getDecorView());
    if (Build.VERSION.SDK_INT >= 21) getWindow().setNavigationBarColor(0);
    if (Build.VERSION.SDK_INT >= 21) getWindow().setStatusBarColor(0);
  }

  public void NoWall() {
    try {
      getWindow()
          .getDecorView()
          .setBackgroundColor(MaterialColors.getColor(this, ColorAndroid12.Back, 0));
      if (Build.VERSION.SDK_INT >= 21)
        getWindow().setNavigationBarColor(MaterialColors.getColor(this, ColorAndroid12.Back, 0));
      if (Build.VERSION.SDK_INT >= 21)
        getWindow().setStatusBarColor(MaterialColors.getColor(this, ColorAndroid12.Back, 0));
    } catch (Exception err) {

    }
  }

  public void setBackGroundIsMobile() {

    if (thememanagersoft.getString("thememanagersoft", "").equals("ok")) {
      Wall();
    } else {

    }
    thememanagersoft.registerOnSharedPreferenceChangeListener(
        new SharedPreferences.OnSharedPreferenceChangeListener() {

          @Override
          public void onSharedPreferenceChanged(SharedPreferences sh, String key) {
            if (key.equals("thememanagersoft")) {
              String datapost = sh.getString("thememanagersoft", "");
              if (datapost.equals("ok")) {
                Wall();
                recreate();
              }
            }
          }
        });

    thememanagersoft.unregisterOnSharedPreferenceChangeListener(
        new SharedPreferences.OnSharedPreferenceChangeListener() {

          @Override
          public void onSharedPreferenceChanged(SharedPreferences sh, String key) {
            if (key.equals("thememanagersoft")) {
              String datapost = sh.getString("thememanagersoft", "");
              if (datapost.equals("no")) {
                NoWall();
                recreate();
              }
            }
          }
        });
  }

  public int colors() {
    return MaterialColors.getColor(getWindow().getDecorView(), ColorAndroid12.Back, 0);
  }

  public void ThemeChaker() {
    try {
      if (!FileUtil.isExistFile(ThemePath)) {
        SetThemeForJson.winterToPath();
        Toast.makeText(getApplicationContext(), "Theme the Maket in " + ThemePath.trim(), 2).show();
      }
    } catch (Exception err) {
      Log.e("Error Theme not Setup ", err.getLocalizedMessage());
    }
  }
}
