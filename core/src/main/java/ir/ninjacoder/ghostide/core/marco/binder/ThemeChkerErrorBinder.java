package ir.ninjacoder.ghostide.core.marco.binder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

import ir.ninjacoder.ghostide.core.utils.FileUtil;

public class ThemeChkerErrorBinder {

  public static boolean runbinder(String ghostFile) {
    try {
      if (ghostFile.endsWith(".ghost")) {

        Map<String, String> map =
            new Gson()
                .fromJson(
                    FileUtil.readFile(ghostFile),
                    new TypeToken<Map<String, String>>() {}.getType());

        if (map == null) return false;
        String[] expectedKeys = {
          "javastring",
          "javafield",
          "tabimagecolorfilter",
          "fabbackgroundcolorcolor",
          "backgroundcolorlinear",
          "htmlstr",
          "operator",
          "pysymbol",
          "pykeyword",
          "text_normal",
          "line_number_background",
          "selection_handle",
          "phpkeyword",
          "tabback",
          "javafun",
          "keyword",
          "jsfun",
          "auto_comp_panel_corner",
          "pycolormatch3",
          "pycolormatch4",
          "htmltag",
          "phphtmlkeyword",
          "htmlattrname",
          "pycolormatch1",
          "phpsymbol",
          "pycolormatch2",
          "javaparament",
          "identifier_name",
          "ninja",
          "toolbarcolor",
          "pynumber",
          "javatype",
          "fabcolorstroker",
          "htmlblocknormal",
          "auto_comp_panel_bg",
          "tabtextcolor",
          "csskeyword",
          "block_line",
          "htmlblockhash",
          "literal",
          "toolbartextcolor",
          "phphtmlattr",
          "line_number",
          "block_line_current",
          "selection_insert",
          "whole_background",
          "attribute_name",
          "textcolorigor",
          "javanumber",
          "menubackground",
          "jsattr",
          "imagecolor",
          "javakeyword",
          "phpcolormatch3",
          "phpcolormatch2",
          "phpcolormatch5",
          "phpattr",
          "phpcolormatch4",
          "jsstring",
          "phpcolormatch6",
          "line_divider",
          "fabimagecolor",
          "html_tag",
          "textcolorforgrand",
          "javaoprator",
          "phpcolormatch1",
          "current_line",
          "htmlattr",
          "htmlsymbol",
          "pystring",
          "print",
          "jskeyword",
          "textcolorhder",
          "syombolbartextcolor",
          "displaytextcolortab",
          "comment",
          "attribute_value",
          "textcolorinier",
          "jsoprator",
          "non_printable_char",
          "tskeyword",
          "tsattr",
          "tssymbols",
          "tscolormatch1",
          "tscolormatch2",
          "tscolormatch3",
          "tscolormatch4",
          "tscolormatch5",
          "tscolormatch6",
          "tscolormatch7",
          "breaklevel1",
          "breaklevel2",
          "breaklevel3",
          "breaklevel4",
          "breaklevel5",
          "breaklevel6",
          "breaklevel7",
          "breaklevel8",
          "javakeywordoprator",
          "menuPosBackground",
          "menuPosTextColor",
          "navstatusbar"
        };

        for (String key : expectedKeys) {
          if (!map.containsKey(key)) {
            return false;
          }
        }

        return true;
      } else if (ghostFile.equals("style.ghost")) {
        return true;
      }

    } catch (Exception e) {
      
    }
    return false;
  }
}
