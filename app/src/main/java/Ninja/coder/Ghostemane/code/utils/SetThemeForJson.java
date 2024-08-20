package Ninja.coder.Ghostemane.code.utils;

import Ninja.coder.Ghostemane.code.marco.ColorCompat;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.SetThemeForJson;
import Ninja.coder.Ghostemane.code.widget.ExrtaFab;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.FileIOUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

public class SetThemeForJson {
  protected HashMap<String, Object> map = new HashMap<>();
  private Timer timer = new Timer();
  private TimerTask task;

  public SetThemeForJson() {}

  public SetThemeForJson(HashMap<String, Object> maps) {
    this.map = maps;
  }

  public SetThemeForJson setShowTheme() {
    if (map.containsKey("Title")) {
      map.put("Title", Color.parseColor("#FF84A9FF"));
    } else {
      map.put("Title", Color.BLUE);
    }
    if (map.containsKey("BackGround")) {
      map.put("BackGround", Color.parseColor("#FFFF84FA"));
    } else {
      map.put("BackGround", Color.DKGRAY);
    }
    return this;
  }

  public SetThemeForJson setThemeCodeEditor(
      CodeEditor editor, HashMap<String, Object> imap, boolean chackHashMap, Activity x) {

    /// app theme
    getColor(imap, editor, "BLOCK_LINE", EditorColorScheme.BLOCK_LINE, "#ff28ffae");
    getColor(imap, editor, "OPERATOR", EditorColorScheme.OPERATOR, "#ff43ffd5");
    getColor(imap, editor, "BLOCK_LINE_CURRENT", EditorColorScheme.BLOCK_LINE_CURRENT, "#ff28ffae");
    getColor(imap, editor, "NON_PRINTABLE_CHAR", EditorColorScheme.NON_PRINTABLE_CHAR, "#ffa10370");
    getColor(imap, editor, "CURRENT_LINE", EditorColorScheme.CURRENT_LINE, "#ff6b90ff");
    getColor(imap, editor, "SELECTION_HANDLE", EditorColorScheme.SELECTION_HANDLE, "#ff2a6373");
    getColor(imap, editor, "LINE_NUMBER", EditorColorScheme.LINE_NUMBER, "#ffff0017");
    getColor(imap, editor, "LINE_DIVIDER", EditorColorScheme.LINE_DIVIDER, "#1d000000");
    getColor(imap, editor, "ATTRIBUTE_VALUE", EditorColorScheme.ATTRIBUTE_VALUE, "#ffa6ffa1");
    getColor(imap, editor, "ATTRIBUTE_NAME", EditorColorScheme.ATTRIBUTE_NAME, "#ffff1723");
    getColor(imap, editor, "TEXT_NORMAL", EditorColorScheme.TEXT_NORMAL, "#ffffffff");
    getColor(imap, editor, "IDENTIFIER_NAME", EditorColorScheme.IDENTIFIER_NAME, "#501910");
    getColor(imap, editor, "COMMENT", EditorColorScheme.COMMENT, "#424242");
    getColor(imap, editor, "KEYWORD", EditorColorScheme.KEYWORD, "#ff1081");
    getColor(imap, editor, "print", EditorColorScheme.print, "#ffa801");
    getColor(imap, editor, "Ninja", EditorColorScheme.Ninja, "#ffe200");
    getColor(imap, editor, "AUTO_COMP_PANEL_BG", EditorColorScheme.AUTO_COMP_PANEL_BG, "#ff000000");
    getColor(
        imap,
        editor,
        "AUTO_COMP_PANEL_CORNER",
        EditorColorScheme.AUTO_COMP_PANEL_CORNER,
        "#fffffffd");
    getColor(
        imap,
        editor,
        "LINE_NUMBER_BACKGROUND",
        EditorColorScheme.LINE_NUMBER_BACKGROUND,
        "#fff00000");
    getColor(imap, editor, "WHOLE_BACKGROUND", EditorColorScheme.WHOLE_BACKGROUND, "#02FFFFFF");
    getColor(imap, editor, "HTML_TAG", EditorColorScheme.HTML_TAG, "#ffc84100");
    getColor(imap, editor, "LITERAL", EditorColorScheme.LITERAL, "#ff2017");
    // new theme color editor bind in SCROLLBAR
    getColor(imap, editor, "print", EditorColorScheme.SCROLL_BAR_THUMB, "#ff3500");
    getColor(imap, editor, "ninja", EditorColorScheme.SCROLL_BAR_THUMB_PRESSED, "#ffacd9");
    getColor(
        imap, editor, "AUTO_COMP_PANEL_CORNER", EditorColorScheme.SCROLL_BAR_TRACK, "#ffee3201");
    // css colors
    editor.getColorScheme().setColor(EditorColorScheme.red, ColorCompat.RED);
    editor.getColorScheme().setColor(EditorColorScheme.aliceblue, ColorCompat.ALICEBLUE);
    // new colors
    editor.getColorScheme().setColor(EditorColorScheme.antiquewhite, ColorCompat.ANTIQUEWHITE);
    editor.getColorScheme().setColor(EditorColorScheme.aqua, ColorCompat.AQUA);
    editor.getColorScheme().setColor(EditorColorScheme.aquamarine, ColorCompat.AQUAMARINE);
    editor.getColorScheme().setColor(EditorColorScheme.azure, ColorCompat.AZURE);
    editor.getColorScheme().setColor(EditorColorScheme.beige, ColorCompat.BEIGE);
    editor.getColorScheme().setColor(EditorColorScheme.bisque, ColorCompat.BISQUE);
    editor.getColorScheme().setColor(EditorColorScheme.black, ColorCompat.BLACK);
    editor.getColorScheme().setColor(EditorColorScheme.blanchedalmond, ColorCompat.BLANCHEDALMOND);
    editor.getColorScheme().setColor(EditorColorScheme.blue, ColorCompat.BLUE);
    editor.getColorScheme().setColor(EditorColorScheme.blueviolet, ColorCompat.BLUEVIOLET);
    editor.getColorScheme().setColor(EditorColorScheme.brown, ColorCompat.BROWN);
    editor.getColorScheme().setColor(EditorColorScheme.white, ColorCompat.WHITE);

    // install color log
    editor.getColorScheme().setColor(EditorColorScheme.COLOR_DEBUG, Color.BLUE);
    editor.getColorScheme().setColor(EditorColorScheme.COLOR_ERROR, Color.RED);
    editor.getColorScheme().setColor(EditorColorScheme.COLOR_WARNING, Color.YELLOW);
    editor.getColorScheme().setColor(EditorColorScheme.COLOR_LOG, Color.GREEN);
    editor.getColorScheme().setColor(EditorColorScheme.COLOR_TIP, Color.CYAN);

    return this;
  }

  protected void getColor(
      HashMap<String, Object> imap,
      CodeEditor editor,
      String key,
      int colorValue,
      String colorNull) {
    editor
        .getColorScheme()
        .setColor(
            imap.containsKey(key) ? colorValue : Color.parseColor(colorNull),
            imap.containsKey(key)
                ? Color.parseColor(imap.get(key).toString())
                : Color.parseColor(colorNull));
  }

  public SetThemeForJson setHashMapInabel(boolean isEnabel, HashMap<String, Object> imap) {
    if (isEnabel) {
      isEnabel = true;
      imap = new HashMap<>();
    } else {
      isEnabel = false;
      imap = null;
    }

    return this;
  }

  @Deprecated
  private SetThemeForJson dialogError(Activity x) {

    return this;
  }

  public SetThemeForJson AddthemetoSattos(Activity a, HashMap<String, Object> imap) {

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
      Window Hsi = a.getWindow();
      Hsi.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      Hsi.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      Hsi.setStatusBarColor(
          imap.containsKey("BackgroundColorLinear")
              ? Color.parseColor(imap.get("BackgroundColorLinear").toString())
              : Color.parseColor("#FF281B26"));
    }

    return this;
  }

  public SetThemeForJson addTextColor(
      TextView id, String datatype, int color, Activity x, HashMap<String, Object> imap2) {
    id.setTextColor(
        imap2.containsKey(datatype)
            ? Color.parseColor(imap2.get(datatype).toString())
            : 0xFFFFE5FC);
    return this;
  }

  public SetThemeForJson addBackground(
      Activity c, HashMap<String, Object> imap, String datatype, View object, int color) {
    object.setBackgroundColor(
        imap.containsKey(datatype) ? Color.parseColor(imap.get(datatype).toString()) : 0xFF281B26);

    return this;
  }

  public SetThemeForJson addImageColor(
      ImageView id, Activity c, String datatype, HashMap<String, Object> map, int color) {
    id.setColorFilter(
        map.containsKey(datatype) ? Color.parseColor(map.get(datatype).toString()) : 0xFFDE7CD1,
        PorterDuff.Mode.MULTIPLY);

    return this;
  }

  public SetThemeForJson setFabBackground(
      ExtendedFloatingActionButton fab, HashMap<String, Object> map) {
    fab.setIconTint(
        ColorStateList.valueOf(
            map.containsKey("FabImageColor")
                ? Color.parseColor(map.get("FabImageColor").toString())
                : MaterialColors.getColor(fab, ColorAndroid12.TvColor)));
    return this;
  }

  public SetThemeForJson setFabColorHint(
      ExtendedFloatingActionButton fab, HashMap<String, Object> imap) {
    fab.setBackgroundTintList(
        ColorStateList.valueOf(
            map.containsKey("FabBackgroundColorColor")
                ? Color.parseColor(map.get("FabBackgroundColorColor").toString())
                : MaterialColors.getColor(fab, ColorAndroid12.Back)));

    return this;
  }

  public SetThemeForJson buildandpost() {

    return this;
  }

  public static void winterToPath() {
    Map<String, String> map = new HashMap<>();
    map.put("ToolbarTextColor", "#ffffffff");
    map.put("BLOCK_LINE_CURRENT", "#ff2e99ff");
    map.put("LINE_DIVIDER", "#1d000000");
    map.put("SyombolBarTextColor", "#ffffe8e8");
    map.put("HTML_TAG", "#ffff8be5");
    map.put("FabColorStroker", "#ffe8e8ff");
    map.put("LINE_NUMBER", "#ffffffff");
    map.put("KEYWORD", "#ffff7f74");
    map.put("AUTO_COMP_PANEL_CORNER", "#ffff8a5d");
    map.put("SELECTION_HANDLE", "#ff49736e");
    map.put("TabImageColorFilter", "#ffffffff");
    map.put("AUTO_COMP_PANEL_BG", "#ff323232");
    map.put("COMMENT", "#626262");
    map.put("ToolbarColor", "#2e000000");
    map.put("IDENTIFIER_NAME", "#fff08d6d");
    map.put("DisplayTextColorTab", "#ffffe58b");
    map.put("NON_PRINTABLE_CHAR", "#ff6b90ff");
    map.put("SELECTION_INSERT", "#ff2a6373");
    map.put("Ninja", "#ffddaeff");
    map.put("TEXTCOLORHDER", "#ff522012");
    map.put("TabTextColor", "#ffc9eaff");
    map.put("BLOCK_LINE", "#ff5effaa");
    map.put("MenuBackground", "#ff000000");
    map.put("LITERAL", "#ffbcf5ff");
    map.put("FabBackgroundColorColor", "#ff000000");
    map.put("ATTRIBUTE_VALUE", "#ff8bf4ff");
    map.put("TabBack", "#ff1e5e71");
    map.put("TEXTCOLORFORGRAND", "#424242");
    map.put("ImageColor", "#ffe8e8ff");
    map.put("TEXT_NORMAL", "#ffffffff");
    map.put("ATTRIBUTE_NAME", "#ffa1e3ff");
    map.put("print", "#ffecffa1");
    map.put("OPERATOR", "#ff43ffd5");
    map.put("CURRENT_LINE", "#20171717");
    map.put("WHOLE_BACKGROUND", "#02FFFFFF");
    map.put("BackgroundColorLinear", "#2b000000");
    map.put("FabImageColor", "#ffffffff");
    map.put("LINE_NUMBER_BACKGROUND", "#00FFFFFF");
    map.put("TEXTCOLORIGOR", "#ffb34192");
    map.put("TEXTCOLORINIER", "#ffb36262");
    String path =
        FileUtil.getExternalStorageDir()
            + File.separator
            + "GhostWebIDE"
            + File.separator
            + "theme"
            + File.separator
            + "GhostThemeapp.ghost";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    FileIOUtils.writeFileFromString(path, gson.toJson(map));
    // FileUtil.writeFile(path, gson.toJson(sortedMap));
    Map<String, Boolean> StyleText = new HashMap<>();
    StyleText.put("isBold", true);
    StyleText.put("isItalic", false);
    StyleText.put("isStrike", false);
    StyleText.put("isLine", false);
    var customPath =
        FileUtil.getExternalStorageDir()
            + File.separator
            + "GhostWebIDE"
            + File.separator
            + "theme"
            + File.separator
            + "style.ghost";
    Gson styleGson = new GsonBuilder().setPrettyPrinting().create();
    FileIOUtils.writeFileFromString(customPath, gson.toJson(StyleText));
  }


  public static void LoadStyle(Map<String, Boolean> map) {
    map = new Gson().fromJson(setReloadStyle(), new TypeToken<Map<String, Boolean>>() {}.getType());
  }

  public static String setReloadTheme() {
    return FileUtil.readFile(
        FileUtil.getExternalStorageDir()
            + File.separator
            + "GhostWebIDE"
            + File.separator
            + "theme"
            + File.separator
            + "style.ghost");
  }

  public static String setReloadStyle() {
    return FileUtil.readFile(
        FileUtil.getExternalStorageDir()
            + File.separator
            + "GhostWebIDE"
            + File.separator
            + "theme"
            + File.separator
            + "style.ghost");
  }
}
