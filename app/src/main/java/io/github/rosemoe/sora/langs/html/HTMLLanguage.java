/*
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/CodeEditor
 *    Copyright (C) 2020-2021  Rosemoe
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
package io.github.rosemoe.sora.langs.html;

import ir.ninjacoder.ghostide.IdeEditor;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.text.TextUtils;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import ir.ninjacoder.ghostide.widget.data.ColorChecker;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.StringReader;
import java.util.Arrays;

public class HTMLLanguage implements EditorLanguage {
  private IdeEditor editor;
  public HTMLLanguage(IdeEditor editor) {
    this.editor = editor;
  }

  public static final String[] JS = {
    "abstract",
    "else",
    "instanceof",
    "super",
    "boolean",
    "enum",
    "int",
    "switch",
    "break",
    "export",
    "interface",
    "synchronized",
    "byte",
    "extends",
    "let",
    "this",
    "case",
    "false",
    "long",
    "throw",
    "catch",
    "final",
    "native",
    "throws",
    "char",
    "finally",
    "new",
    "transient",
    "class",
    "float",
    "null",
    "true",
    "const",
    "for",
    "package",
    "try",
    "continue",
    "function",
    "private",
    "typeof",
    "debugger",
    "goto",
    "protected",
    "var",
    "default",
    "if",
    "public",
    "void",
    "delete",
    "implements",
    "return",
    "volatile",
    "do",
    "import",
    "short",
    "while",
    "double",
    "in",
    "static",
    "with",
    "of",
    "console.log",
    "prototype",
    "alert",
    "support.function",
    "yield",
    "async",
    "document",
    "arguments",
    "parseInt",
    "await",
    "undefined",
    "parseFloat",
    "get",
    "storage.type",
    "infinity",
    "escape",
    "__count__",
    "__parent__",
    "__proto__",
    "window",
    "eval",
    "getElementById",
    "getElementByClass"
  };
  public static final String[] PHP = {
    "__halt_compiler",
    "abstract",
    "array",
    "and",
    "as",
    "break",
    "callable",
    "case",
    "catch",
    "class",
    "clone",
    "const",
    "continue",
    "declare",
    "default",
    "do",
    "die",
    "echo",
    "else",
    "elseif",
    "empty",
    "enddeclare",
    "endfor",
    "endforeach",
    "endif",
    "endswitch",
    "endwhile",
    "eval",
    "extends",
    "final",
    "finally",
    "fn",
    "for",
    "foreach",
    "function",
    "global",
    "goto",
    "if",
    "implements",
    "include",
    "include_once",
    "instanceof",
    "insteadof",
    "interface",
    "isset",
    "list",
    "namespace",
    "new",
    "or",
    "print",
    "private",
    "protected",
    "public",
    "require",
    "require_once",
    "return",
    "static",
    "switch",
    "throw",
    "trait",
    "try",
    "unset",
    "use",
    "var",
    "while",
    "xor",
    "yield",
    "yield_from",
    "__CLASS__",
    "__DIR__",
    "__FILE__",
    "__FUNCTION__",
    "__LINE__",
    "__METHOD__",
    "__NAMESPACE__",
    "__TRAIT__"
  };
  public static final String[] POSTEEMET = {
    "\t <html>\n	<head>\n	<meta charset=\"utf-8\">\n	</head>\n	<body>\n	 <!-- Your Code -->\n  </body>\n</html>",
    "x"
  };
  public static final String[] GETHTML5 = {"html5", "Html5", "Spd", "!"};
  public static final String[] TagNull = {
    "area",
    "base",
    "br",
    "col",
    "embed",
    "hr",
    "img",
    "input",
    "keygen",
    "link",
    "meta",
    "param",
    "source",
    "track",
    "track",
    "wbr",
    "<!DOCTYPE html>"
  };
  public static String getClass = ".".trim();
  public static final String[] EmtClass = {
    "a".concat(getClass),
    "abbr".concat(getClass),
    "acronym".concat(getClass),
    "address".concat(getClass),
    "applet".concat(getClass),
    "article".concat(getClass),
    "aside".concat(getClass),
    "audio".concat(getClass),
    "b".concat(getClass),
    "basefont".concat(getClass),
    "bdi".concat(getClass),
    "bdo".concat(getClass),
    "bgsound".concat(getClass),
    "big".concat(getClass),
    "blink".concat(getClass),
    "blockquote".concat(getClass),
    "body".concat(getClass),
    "button".concat(getClass),
    "canvas".concat(getClass),
    "caption".concat(getClass),
    "center".concat(getClass),
    "circle".concat(getClass),
    "cite".concat(getClass),
    "clipPath".concat(getClass),
    "code".concat(getClass),
    "colgroup".concat(getClass),
    "command".concat(getClass),
    "content".concat(getClass),
    "data".concat(getClass),
    "datalist".concat(getClass),
    "dd".concat(getClass),
    "defs".concat(getClass),
    "del".concat(getClass),
    "details".concat(getClass),
    "dfn".concat(getClass),
    "dialog".concat(getClass),
    "dir".concat(getClass),
    "div".concat(getClass),
    "dl".concat(getClass),
    "dt".concat(getClass),
    "element".concat(getClass),
    "ellipse".concat(getClass),
    "em".concat(getClass),
    "fieldset".concat(getClass),
    "figcaption".concat(getClass),
    "figure".concat(getClass),
    "font".concat(getClass),
    "footer".concat(getClass),
    "foreignObject".concat(getClass),
    "form".concat(getClass),
    "frame".concat(getClass),
    "frameset".concat(getClass),
    "g".concat(getClass),
    "h1".concat(getClass),
    "h2".concat(getClass),
    "h3".concat(getClass),
    "h4".concat(getClass),
    "h5".concat(getClass),
    "h6".concat(getClass),
    "head".concat(getClass),
    "header".concat(getClass),
    "hgroup".concat(getClass),
    "html".concat(getClass),
    "i".concat(getClass),
    "iframe".concat(getClass),
    "image".concat(getClass),
    "ins".concat(getClass),
    "isindex".concat(getClass),
    "kbd".concat(getClass),
    "label".concat(getClass),
    "legend".concat(getClass),
    "li".concat(getClass),
    "line".concat(getClass),
    "linearGradient".concat(getClass),
    "listing".concat(getClass),
    "main".concat(getClass),
    "map".concat(getClass),
    "mark".concat(getClass),
    "marquee".concat(getClass),
    "mask".concat(getClass),
    "math".concat(getClass),
    "menu".concat(getClass),
    "menuitem".concat(getClass),
    "meter".concat(getClass),
    "multicol".concat(getClass),
    "nav".concat(getClass),
    "nextid".concat(getClass),
    "nobr".concat(getClass),
    "noembed".concat(getClass),
    "noframes".concat(getClass),
    "noscript".concat(getClass),
    "object".concat(getClass),
    "ol".concat(getClass),
    "optgroup".concat(getClass),
    "option".concat(getClass),
    "output".concat(getClass),
    "p".concat(getClass),
    "path".concat(getClass),
    "pattern".concat(getClass),
    "picture".concat(getClass),
    "plaintext".concat(getClass),
    "polygon".concat(getClass),
    "polyline".concat(getClass),
    "pre".concat(getClass),
    "progress".concat(getClass),
    "q".concat(getClass),
    "radialGradient".concat(getClass),
    "rb".concat(getClass),
    "rbc".concat(getClass),
    "rect".concat(getClass),
    "rp".concat(getClass),
    "rt".concat(getClass),
    "rtc".concat(getClass),
    "ruby".concat(getClass),
    "s".concat(getClass),
    "samp".concat(getClass),
    "script".concat(getClass),
    "section".concat(getClass),
    "select".concat(getClass),
    "shadow".concat(getClass),
    "slot".concat(getClass),
    "small".concat(getClass),
    "spacer".concat(getClass),
    "span".concat(getClass),
    "stop".concat(getClass),
    "strike".concat(getClass),
    "strong".concat(getClass),
    "style".concat(getClass),
    "nostyle".concat(getClass),
    "sub".concat(getClass),
    "summary".concat(getClass),
    "sup".concat(getClass),
    "svg".concat(getClass),
    "table".concat(getClass),
    "tbody".concat(getClass),
    "td".concat(getClass),
    "template".concat(getClass),
    "text".concat(getClass),
    "textarea".concat(getClass),
    "tfoot".concat(getClass),
    "th".concat(getClass),
    "thead".concat(getClass),
    "time".concat(getClass),
    "title".concat(getClass),
    "tr".concat(getClass),
    "tspan".concat(getClass),
    "tt".concat(getClass),
    "u".concat(getClass),
    "ul".concat(getClass),
    "var".concat(getClass),
    "video".concat(getClass),
    "xmp".concat(getClass)
  };
  public static String getId = "#".trim();
  public static final String[] EmtId = {
    "a".concat(getId),
    "abbr".concat(getId),
    "acronym".concat(getId),
    "address".concat(getId),
    "applet".concat(getId),
    "article".concat(getId),
    "aside".concat(getId),
    "audio".concat(getId),
    "b".concat(getId),
    "basefont".concat(getId),
    "bdi".concat(getId),
    "bdo".concat(getId),
    "bgsound".concat(getId),
    "big".concat(getId),
    "blink".concat(getId),
    "blockquote".concat(getId),
    "body".concat(getId),
    "button".concat(getId),
    "canvas".concat(getId),
    "caption".concat(getId),
    "center".concat(getId),
    "circle".concat(getId),
    "cite".concat(getId),
    "clipPath".concat(getId),
    "code".concat(getId),
    "colgroup".concat(getId),
    "command".concat(getId),
    "content".concat(getId),
    "data".concat(getId),
    "datalist".concat(getId),
    "dd".concat(getId),
    "defs".concat(getId),
    "del".concat(getId),
    "details".concat(getId),
    "dfn".concat(getId),
    "dialog".concat(getId),
    "dir".concat(getId),
    "div".concat(getId),
    "dl".concat(getId),
    "dt".concat(getId),
    "element".concat(getId),
    "ellipse".concat(getId),
    "em".concat(getId),
    "fieldset".concat(getId),
    "figcaption".concat(getId),
    "figure".concat(getId),
    "font".concat(getId),
    "footer".concat(getId),
    "foreignObject".concat(getId),
    "form".concat(getId),
    "frame".concat(getId),
    "frameset".concat(getId),
    "g".concat(getId),
    "h1".concat(getId),
    "h2".concat(getId),
    "h3".concat(getId),
    "h4".concat(getId),
    "h5".concat(getId),
    "h6".concat(getId),
    "head".concat(getId),
    "header".concat(getId),
    "hgroup".concat(getId),
    "html".concat(getId),
    "i".concat(getId),
    "iframe".concat(getId),
    "image".concat(getId),
    "ins".concat(getId),
    "isindex".concat(getId),
    "kbd".concat(getId),
    "label".concat(getId),
    "legend".concat(getId),
    "li".concat(getId),
    "line".concat(getId),
    "linearGradient".concat(getId),
    "listing".concat(getId),
    "main".concat(getId),
    "map".concat(getId),
    "mark".concat(getId),
    "marquee".concat(getId),
    "mask".concat(getId),
    "math".concat(getId),
    "menu".concat(getId),
    "menuitem".concat(getId),
    "meter".concat(getId),
    "multicol".concat(getId),
    "nav".concat(getId),
    "nextid".concat(getId),
    "nobr".concat(getId),
    "noembed".concat(getId),
    "noframes".concat(getId),
    "noscript".concat(getId),
    "object".concat(getId),
    "ol".concat(getId),
    "optgroup".concat(getId),
    "option".concat(getId),
    "output".concat(getId),
    "p".concat(getId),
    "path".concat(getId),
    "pattern".concat(getId),
    "picture".concat(getId),
    "plaintext".concat(getId),
    "polygon".concat(getId),
    "polyline".concat(getId),
    "pre".concat(getId),
    "progress".concat(getId),
    "q".concat(getId),
    "radialGradient".concat(getId),
    "rb".concat(getId),
    "rbc".concat(getId),
    "rect".concat(getId),
    "rp".concat(getId),
    "rt".concat(getId),
    "rtc".concat(getId),
    "ruby".concat(getId),
    "s".concat(getId),
    "samp".concat(getId),
    "script".concat(getId),
    "section".concat(getId),
    "select".concat(getId),
    "shadow".concat(getId),
    "slot".concat(getId),
    "small".concat(getId),
    "spacer".concat(getId),
    "span".concat(getId),
    "stop".concat(getId),
    "strike".concat(getId),
    "strong".concat(getId),
    "style".concat(getId),
    "nostyle".concat(getId),
    "sub".concat(getId),
    "summary".concat(getId),
    "sup".concat(getId),
    "svg".concat(getId),
    "table".concat(getId),
    "tbody".concat(getId),
    "td".concat(getId),
    "template".concat(getId),
    "text".concat(getId),
    "textarea".concat(getId),
    "tfoot".concat(getId),
    "th".concat(getId),
    "thead".concat(getId),
    "time".concat(getId),
    "title".concat(getId),
    "tr".concat(getId),
    "tspan".concat(getId),
    "tt".concat(getId),
    "u".concat(getId),
    "ul".concat(getId),
    "var".concat(getId),
    "video".concat(getId),
    "xmp".concat(getId)
  };
  public static String[] colorsCss = {
    "aliceblue",
    "antiquewhite",
    "aqua",
    "aquamarine",
    "azure",
    "beige",
    "bisque",
    "black",
    "blanchedalmond",
    "blue",
    "blueviolet",
    "brown",
    "burlywood",
    "cadetblue",
    "chartreuse",
    "chocolate",
    "coral",
    "cornflowerblue",
    "cornsilk",
    "crimson",
    "cyan",
    "darkblue",
    "darkcyan",
    "darkgoldenrod",
    "darkgray",
    "darkgreen",
    "darkkhaki",
    "darkmagenta",
    "darkolivegreen",
    "darkorange",
    "darkorchid",
    "darkred",
    "darksalmon",
    "darkseagreen",
    "darkslateblue",
    "darkslategray",
    "darkturquoise",
    "darkviolet",
    "deeppink",
    "deepskyblue",
    "dimgray",
    "dodgerblue",
    "firebrick",
    "floralwhite",
    "forestgreen",
    "fuchsia",
    "gainsboro",
    "ghostwhite",
    "gold",
    "goldenrod",
    "gray",
    "green",
    "greenyellow",
    "honeydew",
    "hotpink",
    "indianred",
    "indigo",
    "ivory",
    "khaki",
    "lavender",
    "lavenderblush",
    "lawngreen",
    "lemonchiffon",
    "lightblue",
    "lightcoral",
    "lightcyan",
    "lightgoldenrodyellow",
    "lightgray",
    "lightgreen",
    "lightpink",
    "lightsalmon",
    "lightseagreen",
    "lightskyblue",
    "lightslategray",
    "lightsteelblue",
    "lightyellow",
    "lime",
    "limegreen",
    "linen",
    "magenta",
    "maroon",
    "mediumaquamarine",
    "mediumblue",
    "mediumorchid",
    "mediumpurple",
    "mediumseagreen",
    "mediumslateblue",
    "mediumspringgreen",
    "mediumturquoise",
    "mediumvioletred",
    "midnightblue",
    "mintcream",
    "mistyrose",
    "moccasin",
    "navajowhite",
    "navy",
    "oldlace",
    "olive",
    "olivedrab",
    "orange",
    "orangered",
    "orchid",
    "palegoldenrod",
    "palegreen",
    "paleturquoise",
    "palevioletred",
    "papayawhip",
    "peachpuff",
    "peru",
    "pink",
    "plum",
    "powderblue",
    "purple",
    "rebeccapurple",
    "red",
    "rosybrown",
    "royalblue",
    "saddlebrown",
    "salmon",
    "sandybrown",
    "seagreen",
    "seashell",
    "sienna",
    "silver",
    "skyblue",
    "slateblue",
    "slategray",
    "snow",
    "springgreen",
    "steelblue",
    "tan",
    "teal",
    "thistle",
    "tomato",
    "turquoise",
    "violet",
    "wheat",
    "white",
    "whitesmoke",
    "yellow",
    "yellowgreen"
  };

  public static String ShowFile() {
    File file = new File("");
    return file.getParent();
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new HTMLAnalyzerCompat(editor);
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    return new HTMLAutoComplete(editor);
  }

  /** Checks if the given character is an auto complete character in HTML */
  @Override
  public boolean isAutoCompleteChar(char ch) {
    return Character.isLetter(ch)
        || Character.isDigit(ch)
        || MyCharacter.isJavaIdentifierStart(ch)
        || ch == '/'
        || ch == '-'
        || ch == '+'
        || ch == '#'
        || ch == '.';
  }

  @Override
  public int getIndentAdvance(String content) {
    try {
      HTMLLexer lexer = new HTMLLexer(CharStreams.fromReader(new StringReader(content)));
      Token token;
      int advance = 0;
      while (((token = lexer.nextToken()) != null && token.getType() != token.EOF)) {
        switch (token.getType()) {
          case HTMLLexer.LBRACE:
            advance++;
            break;
        }
      }
      advance = Math.max(0, advance);
      return advance * 2;
    } catch (Throwable e) {

    }
    return 0;
  }

  @Override
  public boolean useTab() {
    return true;
  }

  @Override
  public CharSequence format(CharSequence text) {
    return ColorChecker.fromatWeb(text.toString());
  }

  @Override
  public SymbolPairMatch getSymbolPairs() {

    return new SymbolPairMatch.DefaultSymbolPairs();
  }

  @Override
  public NewlineHandler[] getNewlineHandlers() {
    return new NewlineHandler[] {
      new StartTagHandler(),
      new EndTagHandler(),
      new EndTagAttributeHandler(),
      new Css3CodeHandler(),
      new BraceHandler()
    };
  }

  public CodeEditor getEditor() {
    return editor;
  }

  private String formatCode(String code) {
    String html = code;
    var formatSrc = "";
    var formatStyle = "";
    Document doc = Jsoup.parse(html);
    Document.OutputSettings outputSettings = new Document.OutputSettings();
    outputSettings.indentAmount(4);
    doc.outputSettings(outputSettings.prettyPrint(true));
    Elements jsElements = doc.select("script");
    for (Element jsElement : jsElements) {
      String jsCode = jsElement.html();
      String formattedJsCode = javaFormat(jsCode);
      jsElement.html("\n\n" + formattedJsCode + "\n\n");
    }

    if (doc.toString().contains("<!doctype html>")) {
      return doc.html().replace("<!doctype html>", "<!DOCTYPE html>");
    }

    return doc.html();
  }

  private void sum(StringBuilder content, int indents) {
    for (int i = 0; i < indents; i++) {
      content.append('\t');
    }
  }

  private String formattingProcess(final String s) {
    final StringBuilder sb = new StringBuilder(4096);
    final char[] charArray = s.toCharArray();
    final int length = charArray.length;
    int i = 0;
    int n = 0;
    int n2 = 0;
    int n3 = 0;
    int n4 = 0;
    int n5 = 0;
    int n6 = 0;
    while (i < length) {
      final char c = charArray[i];
      int n10 = 0;
      int n11 = 0;
      Label_0094:
      {
        Label_0082:
        {
          // n = 1 if it's a one line comment
          if (n != 0) {
            if (c == '\n') {
              sb.append(c);
              sum(sb, n4);
              n = 0;
            } else {
              sb.append(c);
            }
          } // check end of multiple lines comment
          else if (n2 != 0) {
            if (c == '*') {
              final int n7 = i + 1;
              final char c2 = charArray[n7];
              if (c2 == '/') {
                sb.append(c);
                sb.append(c2);
                n2 = 0;
                i = n7;
                break Label_0082;
              }
            }
            sb.append(c);
            // commit
            if (c == '\n') sum(sb, n4);
          } else if (n3 != 0) {
            sb.append(c);
            n3 = 0;
          } else if (c == '\\') {
            sb.append(c);
            n3 = 1;
          } else if (n5 != 0) {
            if (c == '\'') {
              sb.append(c);
              n5 = 0;
            } else {
              sb.append(c);
            }
          } else if (n6 != 0) {
            if (c == '\"') {
              sb.append(c);
              n6 = 0;
            } else {
              sb.append(c);
            }
          } else {
            // check start of comments
            if (c == '/') {
              final int n8 = i + 1;
              final char c3 = charArray[n8];
              // start of one line comment
              if (c3 == '/') {
                sb.append(c);
                sb.append(c3);
                n = 1;
                i = n8;
                break Label_0082;
              }
              // start of multiple lines comment
              if (c3 == '*') {
                sb.append(c);
                sb.append(c3);
                n2 = 1;
                i = n8;
                break Label_0082;
              }
            }
            if (c != '\n') {
              if (c == '\'') {
                n5 = 1;
              }
              int n9;
              if (c == '\"') {
                n9 = 1;
              } else {
                n9 = n6;
              }
              if (c == '{') {
                ++n4;
              }
              n10 = n4;
              if (c == '}') {
                n10 = --n4;
                if (sb.charAt(sb.length() - 1) == '\t') {
                  sb.deleteCharAt(sb.length() - 1);
                  n10 = n4;
                }
              }
              sb.append(c);
              n11 = n9;
              break Label_0094;
            }
            sb.append(c);
            sum(sb, n4);
          }
        }
        final int n12 = n6;
        n10 = n4;
        n11 = n12;
      }
      ++i;
      final int n13 = n10;
      n6 = n11;
      n4 = n13;
    }
    return sb.toString();
  }

  public String javaFormat(String text) {
    return formattingProcess(
        Arrays.stream(text.split("\n"))
            .map(s -> s.trim())
            .collect(java.util.stream.Collectors.joining("\n")));
  }

  class Css3CodeHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.endsWith("{") && afterText.startsWith("}");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceBefore = getIndentAdvance(beforeText);
      int advanceAfter = getIndentAdvance(afterText);
      String text;
      StringBuilder sb =
          new StringBuilder("\n")
              .append(TextUtils.createIndent(count + advanceBefore, tabSize, useTab()))
              .append('\n')
              .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()));
      int shiftLeft = text.length() + 1;
      return new HandleResult(sb, shiftLeft);
    }
  }

  private class EndTagHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      String trim = beforeText.trim();
      if (!trim.startsWith("<")) {
        return false;
      }
      if (!trim.endsWith(">")) {
        return false;
      }
      return afterText.trim().startsWith("</");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      String middle;
      StringBuilder sb = new StringBuilder();
      sb.append('\n');
      sb.append(TextUtils.createIndent(count + tabSize, tabSize, useTab()));
      sb.append('\n');
      sb.append(middle = TextUtils.createIndent(count, tabSize, useTab()));
      return new HandleResult(sb, middle.length() + 1);
    }
  }

  private class EndTagAttributeHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.trim().endsWith(">") && afterText.trim().startsWith("</");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      String middle;
      StringBuilder sb = new StringBuilder();
      sb.append('\n');
      sb.append(TextUtils.createIndent(count, tabSize, useTab()));
      sb.append('\n');
      sb.append(middle = TextUtils.createIndent(count - tabSize, tabSize, useTab()));
      return new HandleResult(sb, middle.length() + 1);
    }
  }

  private class StartTagHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      String trim = beforeText.trim();
      return trim.startsWith("<") && !trim.endsWith(">");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      String text;
      StringBuilder sb =
          new StringBuilder()
              .append("\n")
              .append(TextUtils.createIndent(count + tabSize, tabSize, useTab()));
      return new HandleResult(sb, 0);
    }
  }

  class JavaDocStartHandler implements NewlineHandler {

    private boolean shouldCreateEnd = true;

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.trim().startsWith("<!--");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceAfter = getIndentAdvance(afterText);
      String text = "";
      StringBuilder sb =
          new StringBuilder()
              .append("\n")
              .append(TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
              .append(" - ");
      if (shouldCreateEnd) {
        sb.append("\n")
            .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
            .append(" -->");
      }
      return new HandleResult(sb, text.length() + 4);
    }
  }

  class BraceHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.endsWith("<") && afterText.startsWith("</");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceBefore = getIndentAdvance(beforeText);
      int advanceAfter = getIndentAdvance(afterText);
      String text;
      StringBuilder sb =
          new StringBuilder("\n")
              .append(TextUtils.createIndent(count + advanceBefore, tabSize, useTab()))
              .append('\n')
              .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()));
      int shiftLeft = text.length() + 1;
      return new HandleResult(sb, shiftLeft);
    }
  }
}
