/*
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/sora-editor
 *    Copyright (C) 2020-2022  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 */
package io.github.rosemoe.sora.widget;

import android.util.SparseIntArray;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class manages the colors of editor. You can use color ids that are not in pre-defined id
 * pool due to new languages.
 *
 * <p>This is also the default color scheme of editor. Be careful to change this class, because this
 * can cause its subclasses behave differently and some subclasses did not apply their default
 * colors to some color ids. So change to this can cause sub themes to change as well.
 *
 * <p>Typically, you can use this class to set color of editor directly with {@link #setColor(int,
 * int)} in a thread with looper.
 *
 * <p>gd.setColor(0xFF1F1B1C); gd.setStroke(1,0xFFFFB49D); However, we also accept you to extend
 * this class to customize your own ColorScheme to use different default colors. Subclasses is
 * expected to override {@link #applyDefault()} to define colors, though other methods are not
 * final. After overriding this method, you will have to call super class's applyDefault() and then
 * a series of {@link #setColor(int, int)} calls to apply your colors.
 *
 * <p>Note that new colors can be added in newer version of editor, it is dangerous not to call
 * super.applyDefault(), which can cause newer editor works wrongly.
 *
 * <p>For more pre-defined color schemes, please turn to package
 * io.github.rosemoe.editor.widget.schemes
 *
 * <p>Thanks to liyujiang-gzu (GitHub @liyujiang-gzu) for contribution to color schemes
 *
 * @author Rose
 */
public class EditorColorScheme {
  // ----------------Issue colors----------------
  public static final int PROBLEM_TYPO = 37;
  public static final int PROBLEM_WARNING = 36;
  public static final int PROBLEM_ERROR = 35;
  public static final int PROBLEM_UNUSED = 47;
  // -----------------Highlight colors-----------
  public static final int ATTRIBUTE_VALUE = 34;
  public static final int ATTRIBUTE_NAME = 33;
  public static final int HTML_TAG = 32;
  public static final int ANNOTATION = 28;
  public static final int FUNCTION_NAME = 27;
  public static final int IDENTIFIER_NAME = 26;
  public static final int IDENTIFIER_VAR = 25;
  public static final int LITERAL = 24;
  public static final int OPERATOR = 23;
  public static final int COMMENT = 22;
  public static final int KEYWORD = 21;
  // -------------View colors---------------------
  public static final int NON_PRINTABLE_CHAR = 31;

  /** Use zero if the text color should not be changed */
  public static final int TEXT_SELECTED = 30;

  public static final int MATCHED_TEXT_BACKGROUND = 29;
  public static final int AUTO_COMP_PANEL_CORNER = 20;
  public static final int AUTO_COMP_PANEL_BG = 19;

  /** No longer supported */
  public static final int LINE_BLOCK_LABEL = 18;

  public static final int LINE_NUMBER_PANEL_TEXT = 17;
  public static final int LINE_NUMBER_PANEL = 16;
  public static final int BLOCK_LINE_CURRENT = 15;
  public static final int BLOCK_LINE = 14;
  public static final int BLOCK_LINE_SELECTOR = 8028;
  public static final int SCROLL_BAR_TRACK = 13;
  public static final int SCROLL_BAR_THUMB_PRESSED = 12;
  public static final int SCROLL_BAR_THUMB = 11;
  public static final int UNDERLINE = 10;
  public static final int CURRENT_LINE = 9;
  public static final int SELECTION_HANDLE = 8;
  public static final int SELECTION_INSERT = 7;
  public static final int SELECTED_TEXT_BACKGROUND = 6;
  public static final int TEXT_NORMAL = 5;
  public static final int WHOLE_BACKGROUND = 4;
  public static final int LINE_NUMBER_BACKGROUND = 3;
  public static final int LINE_NUMBER = 2;
  public static final int LINE_DIVIDER = 1;
  public static final int print = 8000;
  public static final int Ninja = 10000;
  public static final int Pro = 202020;
  public static final int PBG = 3010;
  public static final int STO = 50500;

  /** Color Text Custom ad Ghost web ide */
  public static final int TEXTCOLORINIER = 401;

  public static final int TEXTCOLORHDER = 402;
  public static final int TEXTCOLORFORGRAND = 403;
  public static final int TEXTCOLORIGOR = 404;
  public static final int aliceblue = 40181;
  public static final int antiquewhite = 30001;
  public static final int aqua = 3482;
  public static final int aquamarine = 2392;
  public static final int azure = 4837;
  public static final int beige = 9093;
  public static final int bisque = 233;
  public static final int black = 2492;
  public static final int blanchedalmond = 283;
  public static final int blue = 1223;
  public static final int blueviolet = 733;
  public static final int brown = 50282;
  public static final int burlywood = 52292;
  public static final int cadetblue = 67359;
  public static final int chartreuse = 682422;
  public static final int chocolate = 68340;
  public static final int coral = 14029;
  public static final int cornflowerblue = 44957;
  public static final int cornsilk = 674620;
  public static final int crimson = 6820;
  public static final int cyan = 73910;
  public static final int darkblue = 73027;
  public static final int darkcyan = 6929013;
  public static final int darkgoldenrod = 96028;
  public static final int darkgray = 301748;
  public static final int darkgreen = 672910;
  public static final int darkkhaki = 2492959;
  public static final int darkmagenta = 10329;
  public static final int darkolivegreen = 5726200;
  public static final int darkorange = 6819100;
  public static final int darkorchid = 140277;
  public static final int darkred = 58291;
  public static final int darksalmon = 5827293;
  public static final int darkseagreen = 9341;
  public static final int darkslateblue = 562955157;
  public static final int darkslategray = 57291;
  public static final int darkturquoise = 205837;
  public static final int darkviolet = 50271;
  public static final int deeppink = 58261;
  public static final int deepskyblue = 1492337;
  public static final int dimgray = 39339;
  public static final int dodgerblue = 56170;
  public static final int firebrick = 71341;
  public static final int floralwhite = 38037;
  public static final int forestgreen = 38458;
  public static final int fuchsia = 4715249;
  public static final int gainsboro = 69302;
  public static final int ghostwhite = 37220;
  public static final int gold = 48292;
  public static final int goldenrod = 3738229;
  public static final int gray = 384830;
  public static final int green = 70202;
  public static final int greenyellow = 57393;
  public static final int honeydew = 382020;
  public static final int hotpink = 57293;
  public static final int indianred = 57292;
  public static final int indigo = 6701;
  public static final int ivory = 90248;
  public static final int khaki = 77029;
  public static final int lavender = 835710;
  public static final int lavenderblush = 75702;
  public static final int lawngreen = 45820;
  public static final int lemonchiffon = 49272;
  public static final int lightblue = 561957;
  public static final int lightcoral = 570271;
  public static final int lightcyan = 58293;
  public static final int lightgoldenrodyellow = 602721;
  public static final int lightgray = 3839229;
  public static final int lightgreen = 2738391;
  public static final int lightpink = 29304828;
  public static final int lightsalmon = 3739292;
  public static final int lightseagreen = 1382728;
  public static final int lightskyblue = 28389292;
  public static final int lightslategray = 28382929;
  public static final int lightsteelblue = 28482910;
  public static final int lightyellow = 28479929;
  public static final int lime = 50171;
  public static final int limegreen = 30170;
  public static final int linen = 672919;
  public static final int magenta = 2747204;
  public static final int maroon = 38487;
  public static final int mediumaquamarine = 998101;
  public static final int mediumblue = 2838299;
  public static final int mediumorchid = 393892;
  public static final int mediumpurple = 144922;
  public static final int mediumseagreen = 242932;
  public static final int mediumslateblue = 5719139;
  public static final int mediumspringgreen = 384729;
  public static final int mediumturquoise = 37372;
  public static final int mediumvioletred = 5829293;
  public static final int midnightblue = 374729;
  public static final int mintcream = 38520;
  public static final int mistyrose = 83779;
  public static final int moccasin = 34882;
  public static final int navajowhite = 3838237;
  public static final int navy = 2489292;
  public static final int oldlace = 1032719;
  public static final int olive = 2838900;
  public static final int olivedrab = 37376682;
  public static final int orange = 6719457;
  public static final int orangered = 2482902;
  public static final int orchid = 264201272;
  public static final int palegoldenrod = 90271737;
  public static final int palegreen = 6573027;
  public static final int paleturquoise = 2739248;
  public static final int palevioletred = 2840471;
  public static final int papayawhip = 9739374;
  public static final int peachpuff = 2744073;
  public static final int peru = 2749358;
  public static final int pink = 37499473;
  public static final int plum = 28482034;
  public static final int powderblue = 384728;
  public static final int purple = 69104826;
  public static final int rebeccapurple = 2749348;
  public static final int red = 30018;
  public static final int rosybrown = 5729973;
  public static final int royalblue = 3472928;
  public static final int saddlebrown = 348384;
  public static final int salmon = 24820247;
  public static final int sandybrown = 3482472;
  public static final int seagreen = 3582926;
  public static final int seashell = 358203;
  public static final int sienna = 247272;
  public static final int silver = 35820472;
  public static final int skyblue = 3582017;
  public static final int slateblue = 358726;
  public static final int slategray = 248247;
  public static final int snow = 357204472;
  public static final int springgreen = 35824261;
  public static final int steelblue = 35828472;
  public static final int tan = 3818383;
  public static final int teal = 239128;
  public static final int thistle = 4729237;
  public static final int tomato = 27382;
  public static final int turquoise = 238293;
  public static final int violet = 67292;
  public static final int wheat = 24027;
  public static final int white = 197;
  public static final int whitesmoke = 2472829;
  public static final int yellow = 34838;
  public static final int yellowgreen = 23392371;
  /* colors log */
  public static final int COLOR_DEBUG = 8020;
  public static final int COLOR_ERROR = 7001;
  public static final int COLOR_TIP = 10284;
  public static final int COLOR_WARNING = 3028;
  public static final int COLOR_LOG = 9023;
  public static final int STATIC_SPAN_BACKGROUND = 80129;
  public static final int STATIC_SPAN_FOREGROUND = 8010;

  /// for java
  public static final int javakeyword = 3823;
  public static final int javaoprator = 1629;
  public static final int javafun = 7382;
  public static final int javafield = 7249;
  public static final int javatype = 6202;
  public static final int javaparament = 5517;
  public static final int javanumber = 1372;
  public static final int javastring = 8362;
  public static final int javakeywordoprator = 72081;

  /// for html
  public static final int htmltag = 1733;
  public static final int htmlattr = 2800;
  public static final int htmlattrname = 6200;
  public static final int htmlstr = 271;
  public static final int csskeyword = 2733;
  public static final int htmlsymbol = 37233;
  public static final int htmlblockhash = 3017;
  public static final int htmlblocknormal = 3820;
  public static final int jskeyword = 3833;
  public static final int jsfun = 3729;
  public static final int jsoprator = 7863;
  public static final int jsattr = 3733;
  public static final int jsstring = 5739;

  /// for python
  public static final int pystring = 27392;
  public static final int pykeyword = 28910;
  public static final int pysymbol = 47207;
  public static final int pynumber = 39910;
  public static final int pycolormatch1 = 2061;
  public static final int pycolormatch2 = 2061;
  public static final int pycolormatch3 = 2061;
  public static final int pycolormatch4 = 2061;

  public static final int searchcolor1 = 70108;
  public static final int searchcolor2 = 38292;
  public static final int searchcolor3 = 6281;
  public static final int searchcolor4 = 47282;
  public static final int searchcolor5 = 729237;
  public static final int searchcolor6 = 272838;

  // from php
  public static final int phpkeyword = 7100;
  public static final int phpattr = 20017;
  public static final int phpsymbol = 1061;
  public static final int phphtmlattr = 71071;
  public static final int phphtmlkeyword = 20179;
  public static final int phpcolormatch1 = 49971;
  public static final int phpcolormatch2 = 4182;
  public static final int phpcolormatch3 = 5720;
  public static final int phpcolormatch4 = 71592;
  public static final int phpcolormatch5 = 24810;
  public static final int phpcolormatch6 = 10372;

  // from typescript
  public static final int tskeyword = 210710;
  public static final int tsattr = 109871;
  public static final int tssymbols = 69160;
  public static final int tscolormatch1 = 73103;
  public static final int tscolormatch2 = 29483;
  public static final int tscolormatch3 = 59273;
  public static final int tscolormatch4 = 58373;
  public static final int tscolormatch5 = 27301;
  public static final int tscolormatch6 = 72630;
  public static final int tscolormatch7 = 48284;

  // braket
  public static final int breaklevel1 = 20189;
  public static final int breaklevel2 = 4820;
  public static final int breaklevel3 = 23189;
  public static final int breaklevel4 = 27493;
  public static final int breaklevel5 = 94733;
  public static final int breaklevel6 = 6727;
  public static final int breaklevel7 = 24702;
  public static final int breaklevel8 = 3749;
  public static final int wars = 12820;

  /** Min pre-defined color id */
  protected static final int START_COLOR_ID = 1;

  /** Max pre-defined color id */
  protected static final int END_COLOR_ID = 37;

  public static final int FOREGROUND = 923381;

  /** Real color saver */
  protected final SparseIntArray mColors;

  /** Host editor object */
  private List<WeakReference<CodeEditor>> mEditors;

  /**
   * Create a new ColorScheme for the given editor
   *
   * @param editor Host editor
   */
  EditorColorScheme(CodeEditor editor) {
    this();
    attachEditor(editor);
  }

  /** For sub-classes */
  public EditorColorScheme() {
    mColors = new SparseIntArray();
    mEditors = new ArrayList<>();
    applyDefault();
  }

  /**
   * Subscribe changes
   *
   * <p>Called by editor
   */
  void attachEditor(CodeEditor editor) {
    Objects.requireNonNull(editor);
    for (var ref : mEditors) {
      if (ref.get() == editor) {
        return;
      }
    }
    mEditors.add(new WeakReference<>(editor));
    editor.onColorFullUpdate();
  }

  /** Unsubscribe changes */
  void detachEditor(CodeEditor editor) {
    var itr = mEditors.iterator();
    while (itr.hasNext()) {
      if (itr.next().get() == editor) {
        itr.remove();
        break;
      }
    }
  }

  /** Apply default colors */
  public void applyDefault() {
    for (int i = START_COLOR_ID; i <= END_COLOR_ID; i++) {
      applyDefault(i);
    }
  }

  /**
   * Apply default color for the given type
   *
   * @param type The type
   */
  private void applyDefault(int type) {
    int color = mColors.get(type);
    switch (type) {
      case TEXTCOLORINIER:
      case TEXTCOLORHDER:
      case TEXTCOLORFORGRAND:
      case TEXTCOLORIGOR:
      case LITERAL:
      case javakeyword:
      case javafun:
      case javafield:
      case javatype:
      case javaparament:
      case javanumber:
      case javastring:
        color = 0xFF505050;
        break;

      case LINE_NUMBER:
        color = 0xFF505050;
        break;
      case LINE_NUMBER_BACKGROUND:
      case LINE_DIVIDER:
        color = 0xeeeeeeee;
        break;
      case LINE_NUMBER_PANEL_TEXT:
        color = 0xFFFCB07D;
        break;
      case AUTO_COMP_PANEL_BG:
        color = 0xFF201B16;
        break;
      case AUTO_COMP_PANEL_CORNER:
        color = 0xffFFDCBD;
        break;
      case OPERATOR:
        color = 0xFF0066D6;
        break;
      case TEXT_NORMAL:
        color = 0xFF333333;
        break;
      case SELECTION_INSERT:
        color = 0xdd536dfe;
        break;
      case UNDERLINE:
        color = 0xff000000;
        break;
      case SELECTION_HANDLE:
        color = 0xff536dfe;
        break;
      case ANNOTATION:
        color = 0xFF03A9F4;
        break;
      case CURRENT_LINE:
        color = 0x10000000;
        break;
      case SELECTED_TEXT_BACKGROUND:
        color = 0x2D3F51B5;
        break;
      case KEYWORD:
        color = 0xFF2196F3;
        break;
      case COMMENT:
        color = 0xffa8a8a8;
        break;
      case SCROLL_BAR_THUMB:
        color = 0xffd8d8d8;
        break;
      case SCROLL_BAR_THUMB_PRESSED:
        color = 0xFF27292A;
        break;
      case BLOCK_LINE:
        color = 0xffdddddd;
        break;
      case LINE_BLOCK_LABEL:
      case SCROLL_BAR_TRACK:
      case TEXT_SELECTED:
        color = 0;
        break;
      case LINE_NUMBER_PANEL:
        color = 0xdd000000;
        break;
      case BLOCK_LINE_CURRENT:
        color = 0xff999999;
        break;
      case PROBLEM_UNUSED: 
        color = 0xFF9399B2; 
        break;
      case IDENTIFIER_VAR:
      case IDENTIFIER_NAME:
      case FUNCTION_NAME:
      case searchcolor1:
      case searchcolor2:
      case searchcolor3:
      case searchcolor4:
      case searchcolor5:
      case searchcolor6:
        color = 0xff333333;
        break;
      case MATCHED_TEXT_BACKGROUND:
        color = 0xffffff00;
        break;
      case NON_PRINTABLE_CHAR:
        color = 0xeecccccc;
        break;
      case PROBLEM_ERROR:
        color = 0xffff0000;
        break;
      case PROBLEM_WARNING:
        color = 0xfffff100;
        break;
      case BLOCK_LINE_SELECTOR:
        color = 0x643A93FF;
        break;
      case PROBLEM_TYPO:
        color = 0xffffffff;
        break;
    }

    setColor(type, color);
  }

  /**
   * Apply a new color for the given type
   *
   * @param type The type
   * @param color New color
   */
  public void setColor(int type, int color) {
    // Do not change if the old value is the same as new value
    // due to avoid unnecessary invalidate() calls
    int old = getColor(type);
    if (old == color) {
      return;
    }

    mColors.put(type, color);

    // Notify the editor
    var itr = mEditors.iterator();
    while (itr.hasNext()) {
      var editor = itr.next().get();
      if (editor == null) {
        itr.remove();
      } else {
        editor.onColorUpdated(type);
      }
    }
  }

  /**
   * Get color by type
   *
   * @param type The type
   * @return The color for type
   */
  public int getColor(int type) {
    return mColors.get(type);
  }
}
