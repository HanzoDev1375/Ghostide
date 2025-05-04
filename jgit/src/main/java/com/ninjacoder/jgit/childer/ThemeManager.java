package com.ninjacoder.jgit.childer;

import java.io.File;

public class ThemeManager {
  private static SettingCompat instance;

  public static SettingCompat getInstance() {
    if (instance == null) {
      File themeFile = new File(SettingCompat.THEMEAPPPATH);
      instance = new SettingCompat(themeFile);
      instance.setIsCustomTheme(true); // فعال کردن تم سفارشی
    }
    return instance;
  }
}
