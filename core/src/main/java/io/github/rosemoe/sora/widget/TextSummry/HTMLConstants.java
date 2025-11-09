package io.github.rosemoe.sora.widget.TextSummry;

import io.github.rosemoe.sora.widget.EditorColorScheme;

public class HTMLConstants {
  public String HTMLTAG = "Html tag";
  public String Attribute = "Attribute";
  public String JsKey = "Js Keyword";
  public String PhpKeys = "Php_keyword";
  public String Emmet = "Emmet_Spined";
  public String EmmetTagFor = "Emmet_Tag_Repeaters";
  public String TagOne = "One Tag";
  public String CssKey = "Css3 Keyword";
  public String CssColor = "Css3 Colors";
  public String CssAttractions = "Css Attractions";
  public String PhpFun = "Function_php";
  public String RandomColor = "RandomColor";

  // for regex
  public String ColorRegex3item = "(\\#[a-zA-Z-0-9]{3})";

  public HTMLConstants() {}

  public static int get(int i) {
    int mcolorid2;
   if (i >= 14) 
        i = ((i - 1) % 13) + 1;
    switch (i) {
      case 1:
        mcolorid2 = EditorColorScheme.breaklevel1;
        break;
      case 2:
        mcolorid2 = EditorColorScheme.breaklevel2;
        break;
      case 3:
        mcolorid2 = EditorColorScheme.breaklevel3;
        break;
      case 4:
        mcolorid2 = EditorColorScheme.breaklevel4;
        break;
      case 5:
        mcolorid2 = EditorColorScheme.breaklevel5;
        break;
      case 6:
        mcolorid2 = EditorColorScheme.breaklevel6;
        break;
      case 7:
        mcolorid2 = EditorColorScheme.breaklevel7;
        break;
      case 8:
        mcolorid2 = EditorColorScheme.breaklevel8;
        break;
      case 9:
        mcolorid2 = EditorColorScheme.breaklevel1;
        break;
      case 10:
        mcolorid2 = EditorColorScheme.breaklevel2;
        break;
      case 11:
        mcolorid2 = EditorColorScheme.breaklevel3;
        break;
      case 12:
        mcolorid2 = EditorColorScheme.breaklevel4;
        break;
      case 13:
        mcolorid2 = EditorColorScheme.breaklevel6;
        break;
      case 14:
        mcolorid2 = EditorColorScheme.breaklevel1;
        break;
      case 15:
        mcolorid2 = EditorColorScheme.breaklevel7;
        break;
      case 16:
        mcolorid2 = EditorColorScheme.breaklevel8;
        break;
      default:
        mcolorid2 = EditorColorScheme.htmlblocknormal; // رنگ پیش‌فرض
        break;
    }
    return mcolorid2;
  }
}
