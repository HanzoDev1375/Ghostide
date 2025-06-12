package ir.ninjacoder.ghostide.utils;

import android.Manifest;
import android.app.Activity;
import android.os.Environment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import android.content.Intent;
import android.provider.Settings;
import android.net.Uri;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ThreadUtils;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.ImportDeclaration;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.transition.platform.MaterialSharedAxis;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.marco.WavyUnderlineSpan;
import ir.ninjacoder.ghostide.model.ObjectClassName;
import ir.ninjacoder.ghostide.utils.FileUtil;
import ir.ninjacoder.ghostide.widget.ExrtaFab;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.*;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.transition.AutoTransition;
import com.google.android.material.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import java.io.IOException;
import java.io.InputStream;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.common.reflect.TypeToken;
import java.util.List;
import java.io.InputStreamReader;

public class ObjectUtils {
  public static boolean Android12 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S;
  public static boolean Api28 = Build.VERSION.SDK_INT >= 28;
  public static int Back = R.attr.colorSurface;
  public static int colorAccent = R.attr.colorSurface;
  public static int TvColor = R.attr.colorPrimary;
  public static int SecColor = R.attr.colorPrimaryContainer;
  public static int ColorNormal = R.attr.colorControlNormal;
  public static int ColorAConNormal = R.attr.colorControlActivated;
  public static int SubTitle = R.attr.colorPrimaryFixedDim;
  public static int ButtonBack = R.attr.colorSecondary;
  public static int colorOnPrimaryFixed = R.attr.colorOnPrimaryFixed;
  public static int FabBack = R.attr.colorOnPrimary;
  public static int ColorFilter = R.attr.colorOnPrimaryContainer;
  public static int TvColorFab = R.attr.colorOnSecondaryFixed;
  public static int colorOnSurface = R.attr.colorOnSurface;
  public static String name = "";

  public static void setColorBackground(View view) {

    view.setBackgroundColor(MaterialColors.getColor(view, Back));
  }

  public static void setColorBackground(Window view) {

    if (view != null)
      view.getDecorView().setBackgroundColor(MaterialColors.getColor(view.getContext(), Back, 0));
  }

  public static void setNavColor(int color, Activity app) {
    if (Api28) app.getWindow().setNavigationBarDividerColor(color);
  }

  public static void setTextColor(TextView v) {

    v.setTextColor(MaterialColors.getColor(v, TvColor));
  }

  public static void setTextColor(AppCompatTextView view) {
    setTextColor(view);
  }

  public static void setToolbarinit(Toolbar toolbar) {
    if (GhostIdeAppLoader.getThememanagersoft().contains("thememanagersoft")) {

      toolbar.setBackgroundColor(android.R.color.transparent);
      toolbar.setTitleTextColor(MaterialColors.getColor(toolbar, TvColor));
      toolbar.setSubtitleTextColor(MaterialColors.getColor(toolbar, SubTitle));
    } else {
      if (toolbar != null)
        toolbar.setBackgroundTintList(
            ColorStateList.valueOf(MaterialColors.getColor(toolbar, Back)));
      toolbar.setTitleTextColor(MaterialColors.getColor(toolbar, TvColor));
      toolbar.setSubtitleTextColor(MaterialColors.getColor(toolbar, SubTitle));
      try {
        toolbar
            .getNavigationIcon()
            .setColorFilter(MaterialColors.getColor(toolbar, TvColor), PorterDuff.Mode.SRC_IN);
      } catch (Exception err) {
        Log.e("Error not Found color icon ", err.getMessage());
      }
    }
  }

  public static void setStausBar(Window window) {

    if (window != null) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

        window.setNavigationBarColor(
            MaterialColors.getColor(window.getContext(), Back, Color.BLACK));
      }

    } else {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.setStatusBarColor(Color.parseColor("#201B16"));
        window.setNavigationBarColor(Color.parseColor("#201B16"));
      }
    }
  }

  public static void setButtonColor(Button button) {

    button.setBackgroundTintList(
        ColorStateList.valueOf(MaterialColors.getColor(button, ButtonBack)));
  }

  public static void setButtonColor(MaterialButton button) {
    setButtonColor(button);
  }

  public static MaterialAlertDialogBuilder getNewColor(Context context) {
    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
    builder.setBackground(getColor(context, 20));
    return builder;
  }

  public static MaterialShapeDrawable getColor(Context context, int size) {
    MaterialShapeDrawable shapeDrawable =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, size).build());

    shapeDrawable.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(context, Back, 0)));
    shapeDrawable.setStroke(
        1, ColorStateList.valueOf(MaterialColors.getColor(context, SubTitle, 0)));

    return shapeDrawable;
  }

  public static void setColorFilter(ImageView view) {
    if (view == null) return;

    view.setColorFilter(MaterialColors.getColor(view, colorOnSurface), PorterDuff.Mode.SRC_IN);
  }

  public static void setColorFilter(ImageView view, int color) {
    if (view == null) return;

    view.setColorFilter(color, PorterDuff.Mode.SRC_IN);
  }

  public static void setColorFilter(AppCompatImageView view) {
    setColorFilter(view);
  }

  public static void setColorFilter(ExtendedFloatingActionButton view) {
    setColorFilter(view);
  }

  public static void setFab(ExtendedFloatingActionButton fb) {

    fb.setTextColor(MaterialColors.getColor(fb, TvColor));
    fb.setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(fb, ColorFilter)));
    fb.setStrokeWidth(0);
    fb.setBackgroundTintList(ColorStateList.valueOf(MaterialColors.getColor(fb, Back)));
    fb.setIconTint(ColorStateList.valueOf(MaterialColors.getColor(fb, TvColor)));
  }

  public static void setFabColor(FloatingActionButton button) {
    if (button == null) return;
    if (Android12) {
      button.setBackgroundTintList(
          ColorStateList.valueOf(MaterialColors.getColor(button, SecColor)));
    } else {
      button.setBackgroundTintList(ColorStateList.valueOf(0xFFEBE68D));
    }
    setColorFilter(button);
  }

  public static void CollapsingToolbarLayout(CollapsingToolbarLayout layout) {

    layout.setBackgroundTintList(ColorStateList.valueOf(MaterialColors.getColor(layout, Back)));
  }

  public static void EdittextColor(EditText edittext) {

    edittext.setHintTextColor(MaterialColors.getColor(edittext, TvColor));
    edittext.setTextColor(MaterialColors.getColor(edittext, TvColor));
  }

  public static void shap(View view) {
    var shaps =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 99f).build());

    shaps.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(view.getContext(), FabBack, 0)));
    shaps.setStroke(
        1, ColorStateList.valueOf(MaterialColors.getColor(view.getContext(), TvColor, 0)));

    view.setBackground(shaps);
  }

  public static void shap(View view, int colors) {
    var shaps =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 34f).build());

    shaps.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(view.getContext(), colors, 0)));

    view.setBackground(shaps);
  }

  public static void shapeView(View view) {
    var shaps =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 99).build());

    shaps.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(view.getContext(), FabBack, 0)));
    shaps.setStroke(
        1, ColorStateList.valueOf(MaterialColors.getColor(view.getContext(), TvColor, 0)));

    view.setBackground(shaps);
  }

  public static void shapeViews(View view) {
    var shaps =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 24).build());

    shaps.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(view.getContext(), FabBack, 0)));
    shaps.setStroke(
        1, ColorStateList.valueOf(MaterialColors.getColor(view.getContext(), TvColor, 0)));

    view.setBackground(shaps);
  }

  public static void notShap(View view) {
    var shaps =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 99).build());

    shaps.setFillColor(
        ColorStateList.valueOf(MaterialColors.getColor(view.getContext(), FabBack, 0)));
    view.setBackground(shaps);
  }

  public static void PrograssBarColor(ProgressBar bar) {

    if (android.os.Build.VERSION.SDK_INT >= 21) {
      bar.getIndeterminateDrawable()
          .setColorFilter(MaterialColors.getColor(bar, TvColor), PorterDuff.Mode.SRC_IN);
    }
  }

  public static void shp(View v) {
    var shap =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 20f).build());
    if (v != null) {
      shap.setStroke(1f, ColorStateList.valueOf(MaterialColors.getColor(v, TvColor)));
      shap.setFillColor(ColorStateList.valueOf(MaterialColors.getColor(v, Back)));
      v.setBackground((Drawable) shap);
    }
  }

  public static void RevendColorInImageView(View view, ImageView img) {
    var bitmapDrawable = (BitmapDrawable) img.getDrawable();
    var bitmap = bitmapDrawable.getBitmap();
    var averageColor = getAverageColor(bitmap);
    var back =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 20).build());
    back.setFillColor(ColorStateList.valueOf(averageColor));
    view.setBackground(back);
  }

  private static int getAverageColor(Bitmap bitmap) {
    int red = 0, green = 0, blue = 0;
    var pixelCount = 0;

    for (int x = 0; x < bitmap.getWidth(); x++) {
      for (int y = 0; y < bitmap.getHeight(); y++) {
        int color = bitmap.getPixel(x, y);
        red += Color.red(color);
        green += Color.green(color);
        blue += Color.blue(color);
        pixelCount++;
      }
    }

    red /= pixelCount;
    green /= pixelCount;
    blue /= pixelCount;

    return Color.rgb(red, green, blue);
  }

  private static int makeDarkerColor(int color) {
    var factor = 0.8f;
    var red = (int) (Color.red(color) * factor);
    var green = (int) (Color.green(color) * factor);
    var blue = (int) (Color.blue(color) * factor);

    return Color.rgb(red, green, blue);
  }

  public static void runOnUiThread(Runnable run) {
    if (run != null) {
      var handler = new Handler(Looper.getMainLooper());
      handler.post(run);
    }
  }

  public static int getColors(int color) {
    return MaterialColors.getColor(GhostIdeAppLoader.getContext(), color, 0);
  }

  static int get(int color, IdeEditor editor) {
    return MaterialColors.getColor(editor, color);
  }

  static int getweb(int color, WebView v) {
    return MaterialColors.getColor(v, color);
  }

  public static String loadErudaMaterial3(WebView v) {
    int colorPrimary = R.attr.colorPrimary;
    int colorOnPrimary = R.attr.colorOnPrimary;
    int colorPrimaryContainer = R.attr.colorPrimaryContainer;
    int colorPrimaryFixed = R.attr.colorPrimaryFixed;
    int colorPrimaryFixedDim = R.attr.colorPrimaryFixedDim;
    int colorSecondary = R.attr.colorSecondary;
    int colorOnSecondary = R.attr.colorOnSecondary;
    int colorSecondaryFixed = R.attr.colorSecondaryFixed;
    int colorSecondaryFixedDim = R.attr.colorSecondaryFixedDim;
    int colorTertiary = R.attr.colorTertiary;
    int colorSurfaces = R.attr.colorSurface;
    int colorOnTertiaryContainer = R.attr.colorOnTertiaryContainer;
    int colorOnTertiaryFixedVariant = R.attr.colorOnTertiaryFixedVariant;
    int colorTertiaryFixedDim = R.attr.colorTertiaryFixedDim;
    String erudaPath = "file:///android_asset/eruda.js";
    return "(function(){"
        + "var script = document.createElement('script');"
        + "script.src = '"
        + erudaPath
        + "';"
        + "document.body.appendChild(script);"
        + "eruda.init({"
        + "    defaults: {"
        + "        displaySize: 77,"
        + "        transparency: 1,"
        + "    }"
        + "});"
        + "eruda.util.evalCss.setTheme({"
        + "    consoleWarnBackground: '"
        + getweb(colorPrimary, v)
        + "',"
        + "    consoleWarnForeground: '"
        + getweb(colorOnPrimary, v)
        + "',"
        + "    consoleWarnBorder: '"
        + getweb(colorPrimaryContainer, v)
        + "',"
        + "    consoleErrorBackground: '"
        + getweb(colorSecondary, v)
        + "',"
        + "    consoleErrorForeground: '"
        + getweb(colorOnSecondary, v)
        + "',"
        + "    consoleErrorBorder: '"
        + getweb(colorSecondaryFixed, v)
        + "',"
        + "    light: '"
        + getweb(colorPrimaryFixed, v)
        + "',"
        + "    dark: '"
        + getweb(colorPrimaryFixedDim, v)
        + "',"
        + "    darkerBackground: '"
        + getweb(colorSecondaryFixedDim, v)
        + "',"
        + "    background: '"
        + getweb(colorTertiary, v)
        + "',"
        + "    foreground: '"
        + getweb(colorSurfaces, v)
        + "',"
        + "    selectForeground: '"
        + getweb(colorOnTertiaryContainer, v)
        + "',"
        + "    accent: '"
        + getweb(colorOnTertiaryFixedVariant, v)
        + "',"
        + "    highlight: '"
        + getweb(colorTertiaryFixedDim, v)
        + "',"
        + "    border: '"
        + getweb(colorPrimary, v)
        + "',"
        + "    primary: '"
        + getweb(colorOnPrimary, v)
        + "',"
        + "    contrast: '"
        + getweb(colorPrimaryContainer, v)
        + "',"
        + "    varColor: '"
        + getweb(colorPrimaryFixed, v)
        + "',"
        + "    stringColor: '"
        + getweb(colorPrimaryFixedDim, v)
        + "',"
        + "    keywordColor: '"
        + getweb(colorSecondary, v)
        + "',"
        + "    numberColor: '"
        + getweb(colorOnSecondary, v)
        + "',"
        + "    operatorColor: '"
        + getweb(colorSecondaryFixed, v)
        + "',"
        + "    linkColor: '"
        + getweb(colorSecondaryFixedDim, v)
        + "',"
        + "    textColor: '"
        + getweb(colorTertiary, v)
        + "',"
        + "    tagNameColor: '"
        + getweb(colorSurfaces, v)
        + "',"
        + "    functionColor: '"
        + getweb(colorOnTertiaryContainer, v)
        + "',"
        + "    attributeNameColor: '"
        + getweb(colorOnTertiaryFixedVariant, v)
        + "',"
        + "    commentColor: '"
        + getweb(colorTertiaryFixedDim, v)
        + "',"
        + "    cssProperty: '"
        + getweb(colorPrimary, v)
        + "'"
        + "});"
        + "})();";
  }

  public static void tryToRunThemeMaterial(IdeEditor editor) {
    int colorPrimary = R.attr.colorPrimary;
    int colorOnPrimary = R.attr.colorOnPrimary;
    int colorPrimaryContainer = R.attr.colorPrimaryContainer;
    int colorPrimaryFixed = R.attr.colorPrimaryFixed;
    int colorPrimaryFixedDim = R.attr.colorPrimaryFixedDim;
    int colorSecondary = R.attr.colorSecondary;
    int colorOnSecondary = R.attr.colorOnSecondary;
    int colorSecondaryFixed = R.attr.colorSecondaryFixed;
    int colorSecondaryFixedDim = R.attr.colorSecondaryFixedDim;
    int colorTertiary = R.attr.colorTertiary;
    int colorOnTertiaryContainer = R.attr.colorOnTertiaryContainer;
    int colorOnTertiaryFixedVariant = R.attr.colorOnTertiaryFixedVariant;
    int colorTertiaryFixedDim = R.attr.colorTertiaryFixedDim;

    editor.getColorScheme().setColor(EditorColorScheme.TEXT_NORMAL, get(colorPrimary, editor));
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.AUTO_COMP_PANEL_BG, get(colorOnPrimary, editor));
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER, get(colorPrimary, editor));
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.HTML_TAG, get(colorPrimaryContainer, editor));

    editor
        .getColorScheme()
        .setColor(EditorColorScheme.ATTRIBUTE_VALUE, get(colorPrimaryFixed, editor));
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.ATTRIBUTE_NAME, get(colorPrimaryFixedDim, editor));
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.IDENTIFIER_NAME, get(colorSecondary, editor));
    editor.getColorScheme().setColor(EditorColorScheme.IDENTIFIER_VAR, get(colorSecondary, editor));
    editor.getColorScheme().setColor(EditorColorScheme.LITERAL, get(colorOnSecondary, editor));
    editor.getColorScheme().setColor(EditorColorScheme.OPERATOR, get(colorSecondaryFixed, editor));
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.KEYWORD, get(colorSecondaryFixedDim, editor));
    editor.getColorScheme().setColor(EditorColorScheme.BLOCK_LINE, get(colorTertiary, editor));
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.BLOCK_LINE_CURRENT, get(colorOnTertiaryContainer, editor));
    editor.getColorScheme().setColor(EditorColorScheme.WHOLE_BACKGROUND, get(Back, editor));
    editor.getColorScheme().setColor(EditorColorScheme.CURRENT_LINE, 0);
    editor.getColorScheme().setColor(EditorColorScheme.LINE_NUMBER, get(colorPrimary, editor));
    editor.getColorScheme().setColor(EditorColorScheme.LINE_DIVIDER, 0);
    editor
        .getColorScheme()
        .setColor(EditorColorScheme.Ninja, get(colorOnTertiaryFixedVariant, editor));
    editor.getColorScheme().setColor(EditorColorScheme.print, get(colorTertiaryFixedDim, editor));
    editor.getColorScheme().setColor(EditorColorScheme.LINE_NUMBER_BACKGROUND, 0);
  }

  public static void animSlatic(View view) {
    if (view != null) {
      view.animate()
          .scaleX(1.9f)
          .setInterpolator(new AccelerateDecelerateInterpolator())
          .setDuration(300)
          .withEndAction(
              new Runnable() {
                @Override
                public void run() {
                  view.animate()
                      .scaleX(1f)
                      .setInterpolator(new AccelerateDecelerateInterpolator())
                      .setDuration(300)
                      .start();
                }
              })
          .start();
    }
  }

  public static void showViewWithAnimation(View view) {

    Transition sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.Z, true);
    TransitionManager.beginDelayedTransition((ViewGroup) view, sharedAxis);

    if (view.getVisibility() != View.VISIBLE) {
      view.setVisibility(View.VISIBLE);
    }
  }

  public static void hideViewWithAnimation(View view, ExrtaFab fab) {

    Transition sharedAxis = new MaterialSharedAxis(MaterialSharedAxis.Z, false);
    TransitionManager.beginDelayedTransition((ViewGroup) view, sharedAxis);
    if (view.getVisibility() == View.VISIBLE) {
      view.setVisibility(View.GONE);
    }
  }

  public static Drawable getCircularProgress() {
    var app = new CircularProgressDrawable(GhostIdeAppLoader.getContext());
    app.setStrokeWidth(6f);
    app.setCenterRadius(10f);
    app.setArrowEnabled(true);
    app.setStrokeCap(Paint.Cap.ROUND);
    app.setArrowScale(10f);
    app.setColorSchemeColors(getColorApl());
    app.start();

    return app;
  }

  public static int[] getColorApl() {
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

    return apl;
  }

  public static void setSaveToBitMap(Bitmap bitmap, String path) {
    FileUtil.makeDir(path.substring(0, path.lastIndexOf(File.separator)));
    try (var fileOutputStream = new FileOutputStream(path)) {
      bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
      fileOutputStream.flush();
    } catch (IOException err) {
      Log.e("Error to Winter bitmap", err.getMessage());
    }
  }

  public static Bitmap captureAppIco(View view, int size, int cardRadius) {
    Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);

    Canvas canvas = new Canvas(bitmap);

    Path path = new Path();
    RectF rect = new RectF(0, 0, view.getWidth(), view.getHeight());
    path.addRoundRect(rect, cardRadius, cardRadius, Path.Direction.CW);
    canvas.clipPath(path);
    view.draw(canvas);

    Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
    bitmap.recycle();

    return scaledBitmap;
  }

  public static Bitmap captureForeground(
      View view, int size, boolean score, boolean pattern, View pattView, View scoreView, View bg) {

    bg.setVisibility(View.INVISIBLE);
    if (!score) scoreView.setVisibility(View.INVISIBLE);
    if (!pattern) pattView.setVisibility(View.INVISIBLE);

    int padding = 75;

    Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);

    Canvas canvas = new Canvas(bitmap);
    Drawable bgDrawable = view.getBackground();

    if (bgDrawable != null) {
      bgDrawable.draw(canvas);
    } else {
      view.draw(canvas);
    }

    Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, size, size, true);
    int paddedSize = size + (padding * 2);
    Bitmap paddedBitmap = Bitmap.createBitmap(paddedSize, paddedSize, Bitmap.Config.ARGB_8888);

    Canvas paddedCanvas = new Canvas(paddedBitmap);
    paddedCanvas.drawBitmap(scaledBitmap, padding, padding, null);

    bg.setVisibility(View.VISIBLE);
    if (score) scoreView.setVisibility(View.VISIBLE);
    if (pattern) pattView.setVisibility(View.VISIBLE);

    bitmap.recycle();
    scaledBitmap.recycle();

    return paddedBitmap;
  }

  public static boolean checkAndRequestFullStoragePermission(AppCompatActivity app) {
    var context = app;
    if (Environment.isExternalStorageManager()) {
      return true;
    } else if (ContextCompat.checkSelfPermission(app, Manifest.permission.READ_EXTERNAL_STORAGE)
        == PackageManager.PERMISSION_GRANTED) {
      return true;
    } else {

      if (ActivityCompat.shouldShowRequestPermissionRationale(
          app, Manifest.permission.READ_EXTERNAL_STORAGE)) {}

      ActivityCompat.requestPermissions(
          app, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
      if (Android12) {
        try {
          Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
          Uri uri = Uri.fromParts("package", context.getPackageName(), null);
          intent.setData(uri);
          intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          context.startActivity(intent);
          return true;
        } catch (Exception ex) {
          Log.e("Error runtime premisssion: ", ex.getLocalizedMessage());
        }
      }

      return false;
    }
  }

  public static String getClassNameFormImport(String code) {
    if (code.length() > 0) {
      var cu = StaticJavaParser.parse(code);
      if (cu != null) {
        cu.findAll(ImportDeclaration.class)
            .forEach(
                it -> {
                  name = it.getName().getIdentifier();
                });
      }
    }
    return name;
  }

  public static String findClassData(String code) throws Exception {
    Class cls = Class.forName(code);
    String text = cls.getName();
    text += "\n\n// Annotations (if it's empty means there's nothing)";
    for (var a : cls.getDeclaredAnnotations()) {
      text += "\n\n" + a.toString();
    }

    text += "\n\n// Fields (if it's empty means there's nothing)";
    for (var f : cls.getDeclaredFields()) {
      text += "\n\n" + f.toString();
    }

    text += "\n\n// Constructors (if it's empty means there's nothing)";
    for (var c : cls.getDeclaredConstructors()) {
      text += "\n\n" + c.toString();
    }

    text += "\n\n// Methods (if it's empty means there's nothing)";
    for (var m : cls.getDeclaredMethods()) {
      text += "\n\n" + m.toString();
    }

    text += "\n\n// Classes (if it's empty means there's nothing)";
    for (var c : cls.getDeclaredClasses()) {
      text += "\n\n" + c.toString();
    }

    return text;
  }

  public static String[] getClassNamesFromJson(InputStream jsonInputStream) {
    Gson gson = new Gson();
    Type listType = new TypeToken<List<ObjectClassName>>() {}.getType();
    List<ObjectClassName> classNames =
        gson.fromJson(new InputStreamReader(jsonInputStream), listType);
    String[] classNameArray = new String[classNames.size()];
    for (int i = 0; i < classNames.size(); i++) {
      classNameArray[i] = classNames.get(i).getClassName();
    }
    return classNameArray;
  }

  public static String[] getFull_packageFromJson(InputStream jsonInputStream) {
    Gson gson = new Gson();
    Type listType = new TypeToken<List<ObjectClassName>>() {}.getType();
    List<ObjectClassName> classNames =
        gson.fromJson(new InputStreamReader(jsonInputStream), listType);
    String[] classNameArray = new String[classNames.size()];
    for (int i = 0; i < classNames.size(); i++) {
      classNameArray[i] = classNames.get(i).getFull_package();
    }
    return classNameArray;
  }

  public static String[] getFull_package() throws Exception {
    return getFull_packageFromJson(
        GhostIdeAppLoader.getContext().getAssets().open("class_info.json"));
  }

  public static String[] getClassNameObject() throws Exception {
    return getClassNamesFromJson(
        GhostIdeAppLoader.getContext().getAssets().open("class_info.json"));
  }

  /**
   * using in code like recyclerview1.addOnScrollListener(new RecyclerView.OnScrollListener()
   * { @Override public void onScrollStateChanged(RecyclerView recyclerView, int _scrollState) {
   * super.onScrollStateChanged(recyclerView, _scrollState); LinearLayoutManager layoutManager =
   * note: adding int to local var in activity your app code by ninja coder int p =
   * ObjectUtils.getPositionRecyclerView
   *
   * <p>} @Override public void onScrolled(RecyclerView recyclerView, int _offsetX, int _offsetY) {
   * super.onScrolled(recyclerView, _offsetX, _offsetY);
   *
   * <p>} });
   */
  public static int getPositionRecyclerView(RecyclerView rv) {
    GridLayoutManager layoutManager = (GridLayoutManager) rv.getLayoutManager();
    return layoutManager.findFirstVisibleItemPosition();
  }

  public static void setRecyclerViewPosition(RecyclerView rv) {
    ((GridLayoutManager) rv.getLayoutManager())
        .scrollToPositionWithOffset(getPositionRecyclerView(rv), 1);
  }

  public static void setHighlightSearchText(TextView textView, String fullText, String searchText) {
    if (searchText.isEmpty()) {
      textView.setText(fullText);
      return;
    }
    var spannableString = new SpannableString(fullText);
    int startPos = fullText.toLowerCase().indexOf(searchText.toLowerCase());
    int endPos = startPos + searchText.length();
    if (startPos != -1) {
      spannableString.setSpan(
          new ForegroundColorSpan(Color.CYAN),
          startPos,
          endPos,
          SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    textView.setText(spannableString);
  }

  public static void addStarToTab(int pos, TabLayout tab) {
    TabLayout.Tab tabInstance = tab.getTabAt(pos);
    if (tabInstance != null) {
      String tabText = tabInstance.getText().toString();
      if (!tabText.startsWith("*")) {
        SpannableString spannableText = new SpannableString("*" + tabText);
        spannableText.setSpan(
            new ForegroundColorSpan(Color.GREEN),
            0,
            spannableText.length(),
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tabInstance.setText(spannableText);
      }
    }
  }

  public static void addStarToTabError(int pos, TabLayout tab) {
    TabLayout.Tab tabInstance = tab.getTabAt(pos);
    if (tabInstance != null) {
      String tabText = tabInstance.getText() != null ? tabInstance.getText().toString() : "";
      if (!tabText.startsWith("*")) {
        String newText = "*" + tabText;
        SpannableString spannableText = new SpannableString(newText);

        // ستاره سفید
        spannableText.setSpan(
            new ForegroundColorSpan(Color.WHITE), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // خط موج‌دار قرمز برای متن اصلی
        WavyUnderlineSpan mycustomSpan = new WavyUnderlineSpan();
        mycustomSpan.setEnabled(true);
        mycustomSpan.setMod(WavyUnderlineSpan.StatosMod.ERROR);

        spannableText.setSpan(
            mycustomSpan, 1, newText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tabInstance.setText(spannableText);
      }
    }
  }

  public static void removedStarToTab(int pos, TabLayout tab) {
    TabLayout.Tab tabInstance = tab.getTabAt(pos);
    if (tabInstance != null) {
      String tabText = tabInstance.getText().toString();
      if (tabText.startsWith("*")) {
        tabInstance.setText(tabText.substring(1));
      }
    }
  }

  public static void runAndPostInTime(Runnable runs, long time) {
    ThreadUtils.runOnUiThreadDelayed(runs, time);
  }

  public static void runAndPostInTime(Runnable runs) {
    ThreadUtils.runOnUiThreadDelayed(runs, 2000); // 2s
  }
}
