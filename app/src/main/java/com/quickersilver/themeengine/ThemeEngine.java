package com.quickersilver.themeengine;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import Ninja.coder.Ghostemane.code.R;

/** ThemeEngine class to manage theme-related preferences and behaviors */
public class ThemeEngine {
  private final SharedPreferences prefs;

  private static final String THEME_MODE = "theme_mode";
  private static final String DYNAMIC_THEME = "dynamic_theme";
  private static final String APP_THEME = "app_theme";
  private static final String TRUE_BLACK = "true_black";
  private static final String FIRST_START = "first_start";

  private boolean isFirstStart() {
    return prefs.getBoolean(FIRST_START, true);
  }

  private void setFirstStart(boolean value) {
    prefs.edit().putBoolean(FIRST_START, value).apply();
  }

  private ThemeEngine(Context context) {
    prefs = context.getSharedPreferences("theme_engine_prefs", Context.MODE_PRIVATE);

    if (isFirstStart()) {
      setDefaultValues(context);
      setFirstStart(false);
    }
  }

  /**
   * Returns current theme mode. Setting this property applies the given theme mode to the activity.
   */
  public int getThemeMode() {
    return prefs.getInt(THEME_MODE, ThemeMode.AUTO);
  }

  public void setThemeMode(int value) {
    if (value < 0 || value > 2) {
      throw new IllegalArgumentException(
          "Incompatible value! Set this property with help of ThemeMode object.");
    }
    prefs.edit().putInt(THEME_MODE, value).apply();
    AppCompatDelegate.setDefaultNightMode(
        value == ThemeMode.LIGHT
            ? AppCompatDelegate.MODE_NIGHT_NO
            : value == ThemeMode.DARK
                ? AppCompatDelegate.MODE_NIGHT_YES
                : AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
  }

  private int getNightMode() {
    int themeMode = getThemeMode();
    return themeMode == ThemeMode.LIGHT
        ? AppCompatDelegate.MODE_NIGHT_NO
        : themeMode == ThemeMode.DARK
            ? AppCompatDelegate.MODE_NIGHT_YES
            : AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
  }

  /**
   * Returns true if Dynamic Colors are enabled, false otherwise. Setting this property to true
   * enables dynamic colors, false disables dynamic colors. Keep in mind that dynamic colors will
   * work only on Android 12 i.e. API 31 and higher devices. And call Activity.recreate() after
   * changing this property so that the changes get applied to the activity.
   */
  public boolean isDynamicTheme() {
    return prefs.getBoolean(DYNAMIC_THEME, Build.VERSION.SDK_INT >= Build.VERSION_CODES.S);
  }

  public void setDynamicTheme(boolean value) {
    prefs.edit().putBoolean(DYNAMIC_THEME, value).apply();
  }

  /**
   * Get current app theme.
   *
   * @return a dynamic theme if dynamic theme is enabled or a static theme otherwise.
   */
  public int getTheme() {
    return (hasS() && isDynamicTheme())
        ? R.style.Theme_ThemeEngine_Dynamic
        : getStaticTheme().getThemeId();
  }

  /** Get current static app theme, the theme which is used when dynamic color is disabled */
  public Theme getStaticTheme() {
    int ordinal = prefs.getInt(APP_THEME, 0);
    return Theme.values()[ordinal];
  }

  public void setStaticTheme(Theme value) {
    prefs.edit().putInt(APP_THEME, value.ordinal()).apply();
  }

  /** Resets static theme */
  public void resetTheme() {
    prefs.edit().remove(APP_THEME).apply();
  }

  public boolean isTrueBlack() {
    return prefs.getBoolean(TRUE_BLACK, false);
  }

  public void setTrueBlack(boolean value) {
    prefs.edit().putBoolean(TRUE_BLACK, value).apply();
  }

  private void setDefaultValues(Context context) {
    setTrueBlack(context.getResources().getBoolean(R.bool.true_black));
    setThemeMode(context.getResources().getInteger(R.integer.theme_mode));
    prefs
        .edit()
        .putInt(APP_THEME, context.getResources().getInteger(R.integer.static_theme))
        .apply();
    setDynamicTheme(context.getResources().getBoolean(R.bool.dynamic_theme) && hasS());
  }

  private boolean hasS() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S;
  }

  private static ThemeEngine INSTANCE;

  public static synchronized ThemeEngine getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new ThemeEngine(context);
    }
    return INSTANCE;
  }

  /**
   * Applies themes and night mode to all activities by registering a ActivityLifecycleCallbacks to
   * your application.
   *
   * @param application Target Application
   */
  public static void applyToActivities(@NonNull Application application) {
    application.registerActivityLifecycleCallbacks(new ThemeEngineActivityCallback());
  }

  /**
   * Applies themes and night mode to given activity
   *
   * @param activity Target activity
   */
  public static void applyToActivity(@NonNull Activity activity) {
    ThemeEngine instance = getInstance(activity);
    activity.getTheme().applyStyle(instance.getTheme(), true);
    if (instance.isTrueBlack()) {
      activity.getTheme().applyStyle(R.style.ThemeOverlay_Black, true);
    }
    AppCompatDelegate.setDefaultNightMode(instance.getNightMode());
  }
}

class ThemeEngineActivityCallback implements Application.ActivityLifecycleCallbacks {
  @Override
  public void onActivityPreCreated(@NonNull Activity activity, Bundle savedInstanceState) {
    ThemeEngine.applyToActivity(activity);
  }

  @Override
  public void onActivityCreated(@NonNull Activity activity, Bundle savedInstanceState) {}

  @Override
  public void onActivityStarted(@NonNull Activity activity) {}

  @Override
  public void onActivityResumed(@NonNull Activity activity) {}

  @Override
  public void onActivityPaused(@NonNull Activity activity) {}

  @Override
  public void onActivityStopped(@NonNull Activity activity) {}

  @Override
  public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {}

  @Override
  public void onActivityDestroyed(@NonNull Activity activity) {}
}
