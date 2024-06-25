package com.quickersilver.themeengine;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.BoolRes;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.IntegerRes;

public class Extensions {

  public static boolean isDarkMode(Context context) {
    return (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK)
        == Configuration.UI_MODE_NIGHT_YES;
  }

  @ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
  public static boolean hasS() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S;
  }

  public static boolean getBooleanSafe(Context context, @BoolRes int res, boolean defaultValue) {
    try {
      return context.getResources().getBoolean(res);
    } catch (Resources.NotFoundException e) {
      return defaultValue;
    }
  }

  public static int getIntSafe(Context context, @IntegerRes int res, int defaultValue) {
    try {
      return context.getResources().getInteger(res);
    } catch (Resources.NotFoundException e) {
      return defaultValue;
    }
  }
}
