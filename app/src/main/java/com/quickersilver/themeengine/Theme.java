package com.quickersilver.themeengine;

import androidx.annotation.ColorRes;
import androidx.annotation.StyleRes;
import Ninja.coder.Ghostemane.code.R;

public enum Theme {
  AMBER(R.style.Theme_ThemeEngine_Amber, R.color.amber_theme_primary),
  BLUE(R.style.Theme_ThemeEngine_Blue, R.color.blue_theme_primary),
  RED(R.style.Theme_ThemeEngine_RED, R.color.red_theme_primary),
  GREEN(R.style.Theme_ThemeEngine_Green, R.color.green_theme_primary),
  BLUEDARK(R.style.Theme_ThemeEngine_BlueDark, R.color.bluedark_theme_onPrimary),
  YELLODRAK(R.style.Theme_ThemeEngine_YellowDark, R.color.yellowdark_theme_primary),
  POPDRAK(R.style.Theme_ThemeEngine_DARKVIOLET, R.color.darkviolet_theme_primary),
  LIGHTBROWN(R.style.Theme_ThemeEngine_LIGHTBROWN, R.color.lightbrown_theme_primary);

  @StyleRes private final int themeId;

  @ColorRes private final int primaryColor;

  Theme(@StyleRes int themeId, @ColorRes int primaryColor) {
    this.themeId = themeId;
    this.primaryColor = primaryColor;
  }

  @StyleRes
  public int getThemeId() {
    return themeId;
  }

  @ColorRes
  public int getPrimaryColor() {
    return primaryColor;
  }
}
