package com.ninjacoder.jgit.childer;

import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SettingCompat {
  public static final String THEMEAPPPATH = "/sdcard/Ghostweb/theme/appthemes.json";
  private File file;
  private Map<String, Object> themeMap;
  private boolean isCustomTheme;

  public SettingCompat(File file) {
    this.file = file;
    if (isCustomTheme) {
      if (!file.exists()) {
        createDefaultJsonFile();
      }
      loadThemeData();
    }
  }

  private void createDefaultJsonFile() {
    Map<String, Object> defaultTheme = new HashMap<>();

    defaultTheme.put("fabbackground", "#FF6200EE"); // بنفش متریال دیزاین
    defaultTheme.put("rootbackground", "#FF121212"); // مشکی تاریک
    defaultTheme.put("navcolor", "#FF000000"); // مشکی خالص
    defaultTheme.put("fabiconcolor", "#FFFFFFFF"); // سفید
    defaultTheme.put("fabtextcolor", "#FF03DAC5"); // فیروزه‌ای
    defaultTheme.put("textcolor", "#FFE1E1E1"); // سفید روشن
    defaultTheme.put("iconcolor", "#FFBB86FC"); // بنفش روشن
    defaultTheme.put("settingbordercolor", "#FF3700B3"); // بنفش تیره
    defaultTheme.put("statuscolor", "#FF018786"); // سبز-آبی
    defaultTheme.put("tabbackgroundlaayout", "#FF1E1E1E"); // خاکستری بسیار تیره
    defaultTheme.put("tablayouttextcolor", "#FFBB86FC"); // بنفش روشن
    defaultTheme.put("filemangerbackground", "#FF1E1E1E");
    defaultTheme.put("filemanagerbordercolor", "#FF3700B3");

    // تنظیمات سایزها
    defaultTheme.put("borderfabsize", 25);
    defaultTheme.put("textsizefab", 16);
    defaultTheme.put("filemanagerbordersize", 2);

    // تنظیمات divider
    defaultTheme.put("dividershow", true);
    defaultTheme.put("dividercolor", "#FF3700B3");

    String json = GsonUtils.toJson(defaultTheme);
    FileIOUtils.writeFileFromString(file, json);
  }

  private void loadThemeData() {
    String json = FileIOUtils.readFile2String(file);
    if (json != null && !json.isEmpty()) {
      themeMap = GsonUtils.fromJson(json, new TypeToken<Map<String, Object>>() {}.getType());
    }
  }

  // متدهای Getter برای دسترسی به مقادیر
  public String getFabBackground() {
    return themeMap != null ? (String) themeMap.get("fabbackground") : null;
  }

  public String getFabIconColor() {
    return themeMap != null ? (String) themeMap.get("fabiconcolor") : null;
  }

  public String getFabTextColor() {
    return themeMap != null ? (String) themeMap.get("fabtextcolor") : null;
  }

  public String getTextColor() {
    return themeMap != null ? (String) themeMap.get("textcolor") : null;
  }

  public String getIconColor() {
    return themeMap != null ? (String) themeMap.get("iconcolor") : null;
  }

  public String getSettingBorderColor() {
    return themeMap != null ? (String) themeMap.get("settingbordercolor") : null;
  }

  public String getRootBackground() {
    return themeMap != null ? (String) themeMap.get("rootbackground") : null;
  }

  public String getNavColor() {
    return themeMap != null ? (String) themeMap.get("navcolor") : null;
  }

  public String getStatusColor() {
    return themeMap != null ? (String) themeMap.get("statuscolor") : null;
  }

  public int getBorderFabSize() {
    return themeMap != null ? ((Double) themeMap.get("borderfabsize")).intValue() : 0;
  }

  public int getTextSizeFab() {
    return themeMap != null ? ((Double) themeMap.get("textsizefab")).intValue() : 0;
  }

  public String getTabBackgroundLayout() {
    return themeMap != null ? (String) themeMap.get("tabbackgroundlaayout") : null;
  }

  public String getTabLayoutTextColor() {
    return themeMap != null ? (String) themeMap.get("tablayouttextcolor") : null;
  }

  public String getFileManagerBackground() {
    return themeMap != null ? (String) themeMap.get("filemangerbackground") : null;
  }

  public int getFileManagerBorderSize() {
    return themeMap != null ? ((Double) themeMap.get("filemanagerbordersize")).intValue() : 0;
  }

  public String getFileManagerBorderColor() {
    return themeMap != null ? (String) themeMap.get("filemanagerbordercolor") : null;
  }

  public boolean isDividerShow() {
    return themeMap != null ? (Boolean) themeMap.get("dividershow") : false;
  }

  public String getDividerColor() {
    return themeMap != null ? (String) themeMap.get("dividercolor") : null;
  }

  public boolean getIsCustomTheme() {
    return this.isCustomTheme;
  }

  public void setIsCustomTheme(boolean isCustomTheme) {
    this.isCustomTheme = isCustomTheme;
  }
}
