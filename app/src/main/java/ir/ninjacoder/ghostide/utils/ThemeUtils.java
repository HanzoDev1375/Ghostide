package ir.ninjacoder.ghostide.utils;

import android.os.Build;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.activities.BaseCompat;
import ir.ninjacoder.ghostide.activities.CodeEditorActivity;
import ir.ninjacoder.ghostide.marco.ColorCompat;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.FileIOUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.skydoves.powermenu.PowerMenu;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ThemeUtils {
  protected HashMap<String, Object> map = new HashMap<>();
  private Timer timer = new Timer();
  private TimerTask task;

  public ThemeUtils() {}

  public ThemeUtils(HashMap<String, Object> maps) {
    this.map = maps;
  }

  public ThemeUtils setShowTheme() {
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

  public ThemeUtils setThemeCodeEditor(
      CodeEditor editor, HashMap<String, Object> imap, boolean chackHashMap, Activity x) {
    getColor(imap, editor, "block_line", EditorColorScheme.BLOCK_LINE, "#ff28ffae");
    getColor(imap, editor, "OPERATOR", EditorColorScheme.OPERATOR, "#ff43ffd5");
    getColor(imap, editor, "block_line_current", EditorColorScheme.BLOCK_LINE_CURRENT, "#ff28ffae");
    getColor(imap, editor, "non_printable_char", EditorColorScheme.NON_PRINTABLE_CHAR, "#ffa10370");
    getColor(imap, editor, "current_line", EditorColorScheme.CURRENT_LINE, "#ff6b90ff");
    getColor(imap, editor, "selection_handle", EditorColorScheme.SELECTION_HANDLE, "#ff2a6373");
    getColor(imap, editor, "line_number", EditorColorScheme.LINE_NUMBER, "#ffff0017");
    getColor(imap, editor, "line_divider", EditorColorScheme.LINE_DIVIDER, "#1d000000");
    getColor(imap, editor, "attribute_value", EditorColorScheme.ATTRIBUTE_VALUE, "#ffa6ffa1");
    getColor(imap, editor, "attribute_name", EditorColorScheme.ATTRIBUTE_NAME, "#ffff1723");
    getColor(imap, editor, "text_normal", EditorColorScheme.TEXT_NORMAL, "#ffffffff");
    getColor(imap, editor, "identifier_name", EditorColorScheme.IDENTIFIER_NAME, "#501910");
    getColor(imap, editor, "comment", EditorColorScheme.COMMENT, "#424242");
    getColor(imap, editor, "keyword", EditorColorScheme.KEYWORD, "#ff1081");
    getColor(imap, editor, "print", EditorColorScheme.print, "#ffa801");
    getColor(imap, editor, "ninja", EditorColorScheme.Ninja, "#ffe200");
    getColor(imap, editor, "breaklevel1", EditorColorScheme.breaklevel1, "#ff5733");
    getColor(imap, editor, "breaklevel2", EditorColorScheme.breaklevel2, "#33c4ff");
    getColor(imap, editor, "breaklevel3", EditorColorScheme.breaklevel3, "#75ff33");
    getColor(imap, editor, "breaklevel4", EditorColorScheme.breaklevel4, "#ff33a1");
    getColor(imap, editor, "breaklevel5", EditorColorScheme.breaklevel5, "#ffd633");
    getColor(imap, editor, "breaklevel6", EditorColorScheme.breaklevel6, "#ff8c33");
    getColor(imap, editor, "breaklevel7", EditorColorScheme.breaklevel7, "#3347ff");
    getColor(imap, editor, "javakeywordoprator", EditorColorScheme.javakeywordoprator, "#ff3371");
    getColor(imap, editor, "breaklevel8", EditorColorScheme.breaklevel8, "#ec33ff");

    getColor(imap, editor, "auto_comp_panel_bg", EditorColorScheme.AUTO_COMP_PANEL_BG, "#ff000000");
    getColor(
        imap,
        editor,
        "auto_comp_panel_corner",
        EditorColorScheme.AUTO_COMP_PANEL_CORNER,
        "#fffffffd");
    getColor(
        imap,
        editor,
        "line_number_background",
        EditorColorScheme.LINE_NUMBER_BACKGROUND,
        "#fff00000");
    //  getColor(imap, editor, "whole_background", EditorColorScheme.WHOLE_BACKGROUND, "#02FFFFFF");
    getColor(imap, editor, "html_tag", EditorColorScheme.HTML_TAG, "#ffc84100");
    getColor(imap, editor, "literal", EditorColorScheme.LITERAL, "#ff2017");

    getColor(imap, editor, "print", EditorColorScheme.SCROLL_BAR_THUMB, "#ff3500");
    getColor(imap, editor, "ninja", EditorColorScheme.SCROLL_BAR_THUMB_PRESSED, "#ffacd9");
    getColor(
        imap, editor, "auto_comp_panel_corner", EditorColorScheme.SCROLL_BAR_TRACK, "#ffee3201");
    getColor(imap, editor, "javakeyword", EditorColorScheme.javakeyword, "#592370");
    getColor(imap, editor, "javaoprator", EditorColorScheme.javaoprator, "#672907");
    getColor(imap, editor, "javafun", EditorColorScheme.javafun, "#592370");
    getColor(imap, editor, "javafield", EditorColorScheme.javafield, "#672907");
    getColor(imap, editor, "javatype", EditorColorScheme.javatype, "#337291");
    getColor(imap, editor, "javaparament", EditorColorScheme.javaparament, "#336108");
    getColor(imap, editor, "javanumber", EditorColorScheme.javanumber, "#ff620a");
    getColor(imap, editor, "javastring", EditorColorScheme.javastring, "#ff7dd1");

    getColor(imap, editor, "htmltag", EditorColorScheme.htmltag, "#ff6060");
    getColor(imap, editor, "htmlattr", EditorColorScheme.htmlattr, "#4fc3f7");
    getColor(imap, editor, "htmlattrname", EditorColorScheme.htmlattrname, "#ffab40");
    getColor(imap, editor, "htmlstr", EditorColorScheme.htmlstr, "#81c784");
    getColor(imap, editor, "csskeyword", EditorColorScheme.csskeyword, "#64b5f6");
    getColor(imap, editor, "htmlsymbol", EditorColorScheme.htmlsymbol, "#ba68c8");
    getColor(imap, editor, "htmlblockhash", EditorColorScheme.htmlblockhash, "#ff7043");
    getColor(imap, editor, "htmlblocknormal", EditorColorScheme.htmlblocknormal, "#90caf9");
    getColor(imap, editor, "jskeyword", EditorColorScheme.jskeyword, "#64b5f6");
    getColor(imap, editor, "jsfun", EditorColorScheme.jsfun, "#ffd54f");
    getColor(imap, editor, "jsoprator", EditorColorScheme.jsoprator, "#4db6ac");
    getColor(imap, editor, "jsattr", EditorColorScheme.jsattr, "#ffab40");
    getColor(imap, editor, "jsstring", EditorColorScheme.jsstring, "#81c784");

    getColor(imap, editor, "pystring", EditorColorScheme.pystring, "#ff7d51");
    getColor(imap, editor, "pykeyword", EditorColorScheme.pykeyword, "#51ff7d");
    getColor(imap, editor, "pysymbol", EditorColorScheme.pysymbol, "#7d51ff");
    getColor(imap, editor, "pynumber", EditorColorScheme.pynumber, "#ff51ec");
    getColor(imap, editor, "pycolormatch1", EditorColorScheme.pycolormatch1, "#ffd151");
    getColor(imap, editor, "pycolormatch2", EditorColorScheme.pycolormatch2, "#51d1ff");
    getColor(imap, editor, "pycolormatch3", EditorColorScheme.pycolormatch3, "#51ff92");
    getColor(imap, editor, "pycolormatch4", EditorColorScheme.pycolormatch4, "#ff51a2");
    getColor(imap, editor, "phpkeyword", EditorColorScheme.phpkeyword, "#0000ff");
    getColor(imap, editor, "phpattr", EditorColorScheme.phpattr, "#ff8c00");
    getColor(imap, editor, "phpsymbol", EditorColorScheme.phpsymbol, "#b22222");
    getColor(imap, editor, "phphtmlattr", EditorColorScheme.phphtmlattr, "#8a2be2");
    getColor(imap, editor, "phphtmlkeyword", EditorColorScheme.phphtmlkeyword, "#32cd32");
    getColor(imap, editor, "phpcolormatch1", EditorColorScheme.phpcolormatch1, "#ff69b4");
    getColor(imap, editor, "phpcolormatch2", EditorColorScheme.phpcolormatch2, "#ffa500");
    getColor(imap, editor, "phpcolormatch3", EditorColorScheme.phpcolormatch3, "#1e90ff");
    getColor(imap, editor, "phpcolormatch4", EditorColorScheme.phpcolormatch4, "#ff51a2");
    getColor(imap, editor, "phpcolormatch5", EditorColorScheme.phpcolormatch5, "#7fff00");
    getColor(imap, editor, "phpcolormatch6", EditorColorScheme.phpcolormatch6, "#ff4500");
    getColor(imap, editor, "tskeyword", EditorColorScheme.tskeyword, "#00ff7f");
    getColor(imap, editor, "tsattr", EditorColorScheme.tsattr, "#1e90ff");
    getColor(imap, editor, "tssymbols", EditorColorScheme.tssymbols, "#ff1493");
    getColor(imap, editor, "tscolormatch1", EditorColorScheme.tscolormatch1, "#ffd700");
    getColor(imap, editor, "tscolormatch2", EditorColorScheme.tscolormatch2, "#ff6347");
    getColor(imap, editor, "tscolormatch3", EditorColorScheme.tscolormatch3, "#7b68ee");
    getColor(imap, editor, "tscolormatch4", EditorColorScheme.tscolormatch4, "#32cd32");
    getColor(imap, editor, "tscolormatch5", EditorColorScheme.tscolormatch5, "#ff4500");
    getColor(imap, editor, "tscolormatch6", EditorColorScheme.tscolormatch6, "#ff8c00");
    getColor(imap, editor, "tscolormatch7", EditorColorScheme.tscolormatch7, "#20b2aa");

    // fa: اینجا برای رنگ بندی بدون تم جیسون است
    // اگر برای تم عادی میخواهید میتوانید از این روش کمک بگیرید
    // en: Here's to coloring without Json theme
    // If you want a normal theme, you can use this method
    editor.getColorScheme().setColor(EditorColorScheme.red, ColorCompat.RED);
    editor.getColorScheme().setColor(EditorColorScheme.aliceblue, ColorCompat.ALICEBLUE);
    editor.getColorScheme().setColor(EditorColorScheme.antiquewhite, ColorCompat.ANTIQUEWHITE);
    editor.getColorScheme().setColor(EditorColorScheme.aqua, ColorCompat.AQUA);
    editor.getColorScheme().setColor(EditorColorScheme.aquamarine, ColorCompat.AQUAMARINE);
    editor.getColorScheme().setColor(EditorColorScheme.azure, ColorCompat.AZURE);
    editor.getColorScheme().setColor(EditorColorScheme.beige, ColorCompat.BEIGE);
    editor.getColorScheme().setColor(EditorColorScheme.bisque, ColorCompat.BISQUE);
    editor.getColorScheme().setColor(EditorColorScheme.black, ColorCompat.BLACK);
    editor.getColorScheme().setColor(EditorColorScheme.gold, ColorCompat.GOLD);
    editor.getColorScheme().setColor(EditorColorScheme.blanchedalmond, ColorCompat.BLANCHEDALMOND);
    editor.getColorScheme().setColor(EditorColorScheme.blue, ColorCompat.BLUE);
    editor.getColorScheme().setColor(EditorColorScheme.green, Color.GREEN);
    editor.getColorScheme().setColor(EditorColorScheme.orange, ColorCompat.ORANGE);
    editor.getColorScheme().setColor(EditorColorScheme.blueviolet, ColorCompat.BLUEVIOLET);
    editor.getColorScheme().setColor(EditorColorScheme.brown, ColorCompat.BROWN);
    editor.getColorScheme().setColor(EditorColorScheme.white, ColorCompat.WHITE);
    editor.getColorScheme().setColor(EditorColorScheme.COLOR_DEBUG, Color.BLUE);
    editor.getColorScheme().setColor(EditorColorScheme.COLOR_ERROR, Color.RED);
    editor.getColorScheme().setColor(EditorColorScheme.COLOR_WARNING, Color.YELLOW);
    editor.getColorScheme().setColor(EditorColorScheme.COLOR_LOG, Color.GREEN);
    editor.getColorScheme().setColor(EditorColorScheme.COLOR_TIP, Color.CYAN);
    editor.getColorScheme().setColor(EditorColorScheme.searchcolor1, Color.parseColor("#ACF85D5D"));
    editor.getColorScheme().setColor(EditorColorScheme.searchcolor2, Color.parseColor("#AC6CF85D"));
    editor.getColorScheme().setColor(EditorColorScheme.searchcolor3, Color.parseColor("#AC22F8FF"));
    editor.getColorScheme().setColor(EditorColorScheme.searchcolor4, Color.parseColor("#ACFF22CF"));
    editor.getColorScheme().setColor(EditorColorScheme.searchcolor5, Color.parseColor("#ACB4DA43"));
    editor.getColorScheme().setColor(EditorColorScheme.searchcolor6, Color.parseColor("#ACAA6CFB"));
    editor.getColorScheme().setColor(EditorColorScheme.LINE_NUMBER_PANEL_TEXT, Color.WHITE);
    // برای افکت ها حتما باید ترنس پرنت باشه مگر نه افکت نمایش داده نمیشه
    editor.getColorScheme().setColor(EditorColorScheme.WHOLE_BACKGROUND, Color.TRANSPARENT);

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

  public ThemeUtils setHashMapInabel(boolean isEnabel, HashMap<String, Object> imap) {
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
  private ThemeUtils dialogError(Activity x) {

    return this;
  }

  public ThemeUtils AddthemetoSattos(Activity a, HashMap<String, Object> imap) {

    return this;
  }

  public ThemeUtils addTextColor(
      TextView id, String datatype, int color, Activity x, HashMap<String, Object> imap2) {
    id.setTextColor(
        imap2.containsKey(datatype)
            ? Color.parseColor(imap2.get(datatype).toString())
            : 0xFFFFE5FC);
    return this;
  }

  public ThemeUtils addBackground(
      Activity c, HashMap<String, Object> imap, String datatype, View object, int color) {
    object.setBackgroundColor(
        imap.containsKey(datatype) ? Color.parseColor(imap.get(datatype).toString()) : 0xFF281B26);
    return this;
  }

  public ThemeUtils addImageColor(
      ImageView id, Activity c, String datatype, HashMap<String, Object> map, int color) {
    id.setColorFilter(
        map.containsKey(datatype) ? Color.parseColor(map.get(datatype).toString()) : 0xFFDE7CD1,
        PorterDuff.Mode.MULTIPLY);

    return this;
  }

  public ThemeUtils addWindowsNavColor(Activity app, HashMap<String, Object> map, String key) {
    //    ObjectUtils.setNavColor(
    //        map.containsKey(key) ? Color.parseColor(map.get(key).toString()) :
    // Color.TRANSPARENT,app);
    return this;
  }

  public ThemeUtils setFabBackground(
      ExtendedFloatingActionButton fab, HashMap<String, Object> map) {
    fab.setIconTint(
        ColorStateList.valueOf(
            map.containsKey("fabimagecolor")
                ? Color.parseColor(map.get("fabimagecolor").toString())
                : MaterialColors.getColor(fab, ObjectUtils.TvColor)));
    fab.setBackgroundTintList(
        ColorStateList.valueOf(
            map.containsKey("fabbackgroundcolorcolor")
                ? Color.parseColor(map.get("fabbackgroundcolorcolor").toString())
                : Color.BLACK));
    return this;
  }

  public ThemeUtils subPowerMenu(PowerMenu menu, HashMap<String, Object> map) {
    menu.setTextColor(
        map.containsKey("toolbartextcolor")
            ? Color.parseColor(map.get("toolbartextcolor").toString())
            : Color.parseColor("#ffffff"));
    menu.setMenuColor(
        map.containsKey("menubackground")
            ? Color.parseColor(map.get("menubackground").toString())
            : Color.parseColor("#ff000000"));
    menu.setIconColor(
        map.containsKey("tabimagecolorfilter")
            ? Color.parseColor(map.get("tabimagecolorfilter").toString())
            : Color.parseColor("#fff472"));

    return this;
  }

  void setTransparentSystemBars(
      CoordinatorLayout coordinator, LinearLayout mainContent, Window window) {
    window.setStatusBarColor(Color.TRANSPARENT);
    window.setNavigationBarColor(Color.TRANSPARENT);
    coordinator.setFitsSystemWindows(true);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      coordinator.setOnApplyWindowInsetsListener(
          (v, insets) -> {
            int top = insets.getSystemWindowInsetTop();
            int bottom = insets.getSystemWindowInsetBottom();

            mainContent.setPadding(0, top, 0, bottom);

            return insets;
          });
    }
  }

  public ThemeUtils setStatusNavColor(
      BaseCompat base,
      HashMap<String, Object> id,
      String key,
      CoordinatorLayout layout,
      LinearLayout getPass) {
    if (id.containsKey(key)) {
      String colorStr = id.get(key).toString();
      if ((colorStr.startsWith("#")
          && colorStr.length() == 9
          && colorStr.substring(1, 3).equals("00"))) {

        setTransparentSystemBars(layout, getPass, base.getWindow());
      } else {

        base.getWindow().setStatusBarColor(Color.parseColor(colorStr));
        base.getWindow().setNavigationBarColor(Color.parseColor(colorStr));
      }
    } else {
      setTransparentSystemBars(layout, getPass, base.getWindow());
    }
    return this;
  }

  public ThemeUtils buildandpost() {

    return this;
  }

  public static Map<String, String> getMapObjectTheme() {
    Map<String, String> map = new HashMap<>();
    map.put("toolbartextcolor", "#ffffaab1");
    map.put("block_line_current", "#ffe14ba7");
    map.put("line_divider", "#ff4b0600");
    map.put("syombolbartextcolor", "#ffc5984d");
    map.put("html_tag", "#80CBC4");
    map.put("fabcolorstroker", "#4DFFFFFF");
    map.put("line_number", "#ffee9191");
    map.put("keyword", "#FFAB40");
    map.put("auto_comp_panel_corner", "#FF8A65");
    map.put("selection_handle", "#66BB6A");
    map.put("tabimagecolorfilter", "#B0BEC5");
    map.put("auto_comp_panel_bg", "#263238");
    map.put("comment", "#757575");
    map.put("toolbarcolor", "#121212");
    map.put("identifier_name", "#FF9E80");
    map.put("displaytextcolortab", "#FFD54F");
    map.put("non_printable_char", "#90CAF9");
    map.put("selection_insert", "#4DB6AC");
    map.put("ninja", "#E1BEE7");
    map.put("textcolorhder", "#FFAB91");
    map.put("tabtextcolor", "#ffff8ea2");
    map.put("block_line", "#fffa928b");
    map.put("menubackground", "#ff1e0004");
    map.put("literal", "#fff6b76d");
    map.put("fabbackgroundcolorcolor", "#ff250009");
    map.put("attribute_value", "#80DEEA");
    map.put("tabback", "#ff510002");
    map.put("textcolorforgrand", "#ffffaabf");
    map.put("imagecolor", "#B0BEC5");
    map.put("text_normal", "#FFFFFF");
    map.put("attribute_name", "#64B5F6");
    map.put("print", "#FF8A65");
    map.put("operator", "#FFB74D");
    map.put("current_line", "#52240005");
    map.put("whole_background", "#1E1E1E");
    map.put("backgroundcolorlinear", "#1B1110");
    map.put("fabimagecolor", "#ffff9c9c");
    map.put("line_number_background", "#00000000");
    map.put("textcolorigor", "#F06292");
    map.put("textcolorinier", "#ffef929f");
    map.put("javakeyword", "#FFAC80");
    map.put("javaoprator", "#90CAF9");
    map.put("javafun", "#FFCC60");
    map.put("javafield", "#E8BF6A");
    map.put("javatype", "#64B5F6");
    map.put("javaparament", "#FFAB40");
    map.put("javanumber", "#A5D6A7");
    map.put("javastring", "#E0E0E0");
    map.put("htmltag", "#FFAB49");
    map.put("htmlattr", "#FFAB80");
    map.put("htmlattrname", "#64B5F6");
    map.put("htmlstr", "#E8BF6A");
    map.put("csskeyword", "#81D4FA");
    map.put("htmlsymbol", "#FF33A8");
    map.put("htmlblockhash", "#FF5252");
    map.put("htmlblocknormal", "#FF4081");
    map.put("jskeyword", "#FFAB40");
    map.put("jsfun", "#FFCC80");
    map.put("jsoprator", "#FF5252");
    map.put("jsattr", "#64B5F6");
    map.put("jsstring", "#FFCC80");
    map.put("pystring", "#FFCC80");
    map.put("pykeyword", "#FFAB40");
    map.put("pysymbol", "#64B5F6");
    map.put("pynumber", "#A5D6A7");
    map.put("pycolormatch1", "#FFFF33");
    map.put("pycolormatch2", "#33FFFF");
    map.put("pycolormatch3", "#FF33FF");
    map.put("pycolormatch4", "#FFC300");
    map.put("phpkeyword", "#FF5733");
    map.put("phpattr", "#33FF57");
    map.put("phpsymbol", "#09EB9E");
    map.put("phphtmlattr", "#F0E68C");
    map.put("phphtmlkeyword", "#FF33F6");
    map.put("phpcolormatch1", "#FF8C00");
    map.put("phpcolormatch2", "#00FA9A");
    map.put("phpcolormatch3", "#FF8282");
    map.put("phpcolormatch4", "#FFD700");
    map.put("phpcolormatch5", "#FF69B4");
    map.put("phpcolormatch6", "#20B2AA");
    map.put("tskeyword", "#FF5733");
    map.put("tsattr", "#ffff8e95");
    map.put("tssymbols", "#3357FF");
    map.put("tscolormatch1", "#F5D04D");
    map.put("tscolormatch2", "#D04DF5");
    map.put("tscolormatch3", "#FFDA44");
    map.put("tscolormatch4", "#1FA3A5");
    map.put("tscolormatch5", "#ACAA6C");
    map.put("tscolormatch6", "#fff3ff9c");
    map.put("tscolormatch7", "#ffff80d3");
    map.put("breaklevel1", "#FF5733");
    map.put("breaklevel2", "#33FF57");
    map.put("breaklevel3", "#3357FF");
    map.put("breaklevel4", "#FF33A1");
    map.put("breaklevel5", "#FFF733");
    map.put("breaklevel6", "#FF8C33");
    map.put("breaklevel7", "#33FFF5");
    map.put("menuPosBackground", "#ff1e0100");
    map.put("menuPosTextColor", "#ffff8ea2");
    map.put("breaklevel8", "#F1C40F");
    map.put("javakeywordoprator", "#E8B25B");
    map.put("navstatusbar", "#1B1110");
    return map;
  }

  public static Map<String, Boolean> getMapStyleText() {
    Map<String, Boolean> styleLine = new HashMap<>();
    styleLine.put("isBold", true);
    styleLine.put("isItalic", false);
    styleLine.put("isStrike", false);
    styleLine.put("isLine", false);
    styleLine.put("isPhpBold", false);

    return styleLine;
  }

  public static void winterToPath() {
    Map<String, String> map = getMapObjectTheme();
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

    Map<String, Boolean> StyleText = getMapStyleText();

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
            + "GhostThemeapp.ghost");
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

  public static String themeLoad() {
    return setReloadTheme();
  }

  public static String themeAsString() {
    return """
    {
      "javafield": "#E8BF6A",
      "tabimagecolorfilter": "#B0BEC5",
      "fabbackgroundcolorcolor": "#ff250009",
      "htmlstr": "#E8BF6A",
      "pykeyword": "#FFAB40",
      "text_normal": "#FFFFFF",
      "tskeyword": "#FF5733",
      "line_number_background": "#00000000",
      "auto_comp_panel_corner": "#FF8A65",
      "menuPosBackground": "#ff1e0100",
      "breaklevel8": "#F1C40F",
      "breaklevel7": "#33FFF5",
      "phpsymbol": "#09EB9E",
      "breaklevel6": "#FF8C33",
      "breaklevel5": "#FFF733",
      "breaklevel4": "#FF33A1",
      "breaklevel3": "#3357FF",
      "breaklevel2": "#33FF57",
      "breaklevel1": "#FF5733",
      "toolbarcolor": "#121212",
      "pynumber": "#A5D6A7",
      "javatype": "#64B5F6",
      "auto_comp_panel_bg": "#263238",
      "tssymbols": "#3357FF",
      "csskeyword": "#81D4FA",
      "literal": "#fff6b76d",
      "toolbartextcolor": "#ffffaab1",
      "phphtmlattr": "#F0E68C",
      "line_number": "#ffee9191",
      "block_line_current": "#ffe14ba7",
      "tscolormatch3": "#FFDA44",
      "whole_background": "#1E1E1E",
      "tscolormatch4": "#1FA3A5",
      "attribute_name": "#64B5F6",
      "tscolormatch1": "#F5D04D",
      "tscolormatch2": "#D04DF5",
      "tscolormatch7": "#ffff80d3",
      "javanumber": "#A5D6A7",
      "javakeywordoprator": "#E8B25B",
      "menubackground": "#ff1e0004",
      "tscolormatch5": "#ACAA6C",
      "javakeyword": "#FFAC80",
      "tscolormatch6": "#fff3ff9c",
      "phpcolormatch3": "#FF8282",
      "phpcolormatch2": "#00FA9A",
      "phpcolormatch5": "#FF69B4",
      "phpcolormatch4": "#FFD700",
      "phpcolormatch6": "#20B2AA",
      "line_divider": "#ff4b0600",
      "fabimagecolor": "#ffff9c9c",
      "textcolorforgrand": "#ffffaabf",
      "navstatusbar": "#1B1110",
      "phpcolormatch1": "#FF8C00",
      "current_line": "#52240005",
      "pystring": "#FFCC80",
      "jskeyword": "#FFAB40",
      "textcolorinier": "#ffef929f",
      "javastring": "#E0E0E0",
      "tsattr": "#ffff8e95",
      "backgroundcolorlinear": "#1B1110",
      "operator": "#FFB74D",
      "pysymbol": "#64B5F6",
      "selection_handle": "#66BB6A",
      "phpkeyword": "#FF5733",
      "tabback": "#ff510002",
      "javafun": "#FFCC60",
      "keyword": "#FFAB40",
      "jsfun": "#FFCC80",
      "pycolormatch3": "#FF33FF",
      "pycolormatch4": "#FFC300",
      "htmltag": "#FFAB49",
      "phphtmlkeyword": "#FF33F6",
      "htmlattrname": "#64B5F6",
      "pycolormatch1": "#FFFF33",
      "pycolormatch2": "#33FFFF",
      "javaparament": "#FFAB40",
      "identifier_name": "#FF9E80",
      "ninja": "#E1BEE7",
      "fabcolorstroker": "#4DFFFFFF",
      "htmlblocknormal": "#FF4081",
      "tabtextcolor": "#ffff8ea2",
      "block_line": "#fffa928b",
      "htmlblockhash": "#FF5252",
      "menuPosTextColor": "#ffff8ea2",
      "selection_insert": "#4DB6AC",
      "textcolorigor": "#F06292",
      "jsattr": "#64B5F6",
      "imagecolor": "#B0BEC5",
      "phpattr": "#33FF57",
      "jsstring": "#FFCC80",
      "html_tag": "#80CBC4",
      "javaoprator": "#90CAF9",
      "htmlattr": "#FFAB80",
      "htmlsymbol": "#FF33A8",
      "print": "#FF8A65",
      "textcolorhder": "#FFAB91",
      "syombolbartextcolor": "#ffc5984d",
      "displaytextcolortab": "#FFD54F",
      "comment": "#757575",
      "attribute_value": "#80DEEA",
      "jsoprator": "#FF5252",
      "non_printable_char": "#90CAF9"
    }
    """;
  }
}
