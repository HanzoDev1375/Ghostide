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
import com.skydoves.powermenu.PowerMenu;
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
    getColor(imap, editor, "whole_background", EditorColorScheme.WHOLE_BACKGROUND, "#02FFFFFF");
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
    getColor(imap, editor, "htmlattrname", EditorColorScheme.htmlattrname, "#ff620a");
    getColor(imap, editor, "htmlstr", EditorColorScheme.htmlstr, "#ff620a");
    getColor(imap, editor, "csskeyword", EditorColorScheme.csskeyword, "#ff620a");
    getColor(imap, editor, "htmlsymbol", EditorColorScheme.htmlsymbol, "#ff620a");
    getColor(imap, editor, "htmlblockhash", EditorColorScheme.htmlblockhash, "#ff620a");
    getColor(imap, editor, "htmlblocknormal", EditorColorScheme.htmlblocknormal, "#ff620a");
    getColor(imap, editor, "jskeyword", EditorColorScheme.jskeyword, "#ff620a");
    getColor(imap, editor, "jsfun", EditorColorScheme.jsfun, "#ff620a");
    getColor(imap, editor, "jsoprator", EditorColorScheme.jsoprator, "#ff620a");
    getColor(imap, editor, "jsattr", EditorColorScheme.jsattr, "#ff620a");
    getColor(imap, editor, "jsstring", EditorColorScheme.jsstring, "#ff620a");

    
    editor.getColorScheme().setColor(EditorColorScheme.red, ColorCompat.RED);
    editor.getColorScheme().setColor(EditorColorScheme.aliceblue, ColorCompat.ALICEBLUE);
    
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
      Hsi.setStatusBarColor(
          imap.containsKey("backgroundcolorlinear")
              ? Color.parseColor(imap.get("backgroundcolorlinear").toString())
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
            map.containsKey("fabimagecolor")
                ? Color.parseColor(map.get("fabimagecolor").toString())
                : MaterialColors.getColor(fab, ColorAndroid12.TvColor)));
    return this;
  }

  public SetThemeForJson setFabColorHint(
      ExtendedFloatingActionButton fab, HashMap<String, Object> imap) {
    fab.setBackgroundTintList(
        ColorStateList.valueOf(
            map.containsKey("fabbackgroundcolorcolor")
                ? Color.parseColor(map.get("fabbackgroundcolorcolor").toString())
                : MaterialColors.getColor(fab, ColorAndroid12.Back)));

    return this;
  }

  public SetThemeForJson subPowerMenu(PowerMenu menu, HashMap<String, Object> map) {
    menu.setTextColor(
        map.containsKey("toolbartextcolor")
            ? Color.parseColor(map.get("toolbartextcolor").toString())
            : Color.parseColor("#fff"));
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

  public SetThemeForJson buildandpost() {

    return this;
  }

  public static void winterToPath() {
    Map<String, String> map = new HashMap<>();
    map.put("toolbartextcolor", "#ffffffff");
    map.put("block_line_current", "#ff2e99ff");
    map.put("line_divider", "#1d000000");
    map.put("syombolbartextcolor", "#ffffe8e8");
    map.put("html_tag", "#ffff8be5");
    map.put("fabcolorstroker", "#ffe8e8ff");
    map.put("line_number", "#ffffffff");
    map.put("keyword", "#ffff7f74");
    map.put("auto_comp_panel_corner", "#ffff8a5d");
    map.put("selection_handle", "#ff49736e");
    map.put("tabimagecolorfilter", "#ffffffff");
    map.put("auto_comp_panel_bg", "#ff323232");
    map.put("comment", "#626262");
    map.put("toolbarcolor", "#2e000000");
    map.put("identifier_name", "#fff08d6d");
    map.put("displaytextcolortab", "#ffffe58b");
    map.put("non_printable_char", "#ff6b90ff");
    map.put("selection_insert", "#ff2a6373");
    map.put("ninja", "#ffddaeff");
    map.put("textcolorhder", "#ff522012");
    map.put("tabtextcolor", "#ffc9eaff");
    map.put("block_line", "#ff5effaa");
    map.put("menubackground", "#ff000000");
    map.put("literal", "#ffbcf5ff");
    map.put("fabbackgroundcolorcolor", "#ff000000");
    map.put("attribute_value", "#ff8bf4ff");
    map.put("tabback", "#ff1e5e71");
    map.put("textcolorforgrand", "#424242");
    map.put("imagecolor", "#ffe8e8ff");
    map.put("text_normal", "#ffffffff");
    map.put("attribute_name", "#ffa1e3ff");
    map.put("print", "#ffecffa1");
    map.put("operator", "#ff43ffd5");
    map.put("current_line", "#20171717");
    map.put("whole_background", "#02FFFFFF");
    map.put("backgroundcolorlinear", "#2b000000");
    map.put("fabimagecolor", "#ffffffff");
    map.put("line_number_background", "#00FFFFFF");
    map.put("textcolorigor", "#ffb34192");
    map.put("textcolorinier", "#ffb36262");
    map.put("javakeyword", "#ff6060");
    map.put("javaoprator", "#4fc3f7");
    map.put("javafun", "#afb42b");
    map.put("javafield", "#f0be4b");
    map.put("javatype", "#64b5f6");
    map.put("javaparament", "#4fc3f7");
    map.put("javanumber", "#8bc34a");
    map.put("javastring", "#8bc34a");
    map.put("htmltag", "#ff6060"); 
    map.put("htmlattr", "#ff6060"); 
    map.put("htmlattrname", "#3357FF"); 
    map.put("htmlstr", "#FFC300"); 
    map.put("csskeyword", "#DAF7A6"); 
    map.put("htmlsymbol", "#FF33A8"); 
    map.put("htmlblockhash", "#C70039"); 
    map.put("htmlblocknormal", "#900C3F"); 
    map.put("jskeyword", "#581845"); 
    map.put("jsfun", "#900C3F"); 
    map.put("jsoprator", "#FF5733"); 
    map.put("jsattr", "#33FF57"); 
    map.put("jsstring", "#FFC300");
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
