package Ninja.coder.Ghostemane.code.utils;

import Ninja.coder.Ghostemane.code.ApplicationLoader;
import Ninja.coder.Ghostemane.code.IdeEditor;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.widget.*;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
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

public class ColorAndroid12 {
  public static boolean Android12 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S;
  public static int Back = R.attr.colorSurface;
  public static int colorAccent = R.attr.colorAccent;
  public static int TvColor = R.attr.colorPrimary;
  public static int SecColor = R.attr.colorPrimaryContainer;  
  public static int ColorNormal = R.attr.colorControlNormal;
  public static int ColorAConNormal = R.attr.colorControlActivated;
  public static int SubTitle = R.attr.colorPrimaryFixedDim;
  public static int ButtonBack = R.attr.colorSecondary;
  public static int FabBack = R.attr.colorOnPrimary;
  public static int ColorFilter = R.attr.colorOnPrimaryContainer;
  public static int TvColorFab = R.attr.colorOnSecondaryFixed;
  public static int colorOnSurface = R.attr.colorOnSurface;

  public static void setColorBackground(View view) {

    view.setBackgroundColor(MaterialColors.getColor(view, Back));
  }

  public static void setColorBackground(Window view) {

    if (view != null)
      view.getDecorView().setBackgroundColor(MaterialColors.getColor(view.getContext(), Back, 0));
  }

  public static void setTextColor(TextView v) {

    v.setTextColor(MaterialColors.getColor(v, TvColor));
  }

  public static void setTextColor(AppCompatTextView view) {
    setTextColor(view);
  }

  public static void setToolbarinit(Toolbar toolbar) {
    if (ApplicationLoader.getThememanagersoft().contains("thememanagersoft")) {

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
        //   window.setStatusBarColor(MaterialColors.getColor(window.getContext(), Back,
        // Color.BLACK));
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

  public static void animateLayoutChanges(View view) {
    var autoTransition = new AutoTransition();
    autoTransition.setDuration((short) 200);
    TransitionManager.beginDelayedTransition((ViewGroup) view, autoTransition);
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
    return MaterialColors.getColor(ApplicationLoader.getContext(), color, 0);
  }

  static int get(int color, IdeEditor editor) {
    return MaterialColors.getColor(editor, color);
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
}
