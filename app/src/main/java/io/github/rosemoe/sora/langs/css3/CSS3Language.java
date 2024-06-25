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
package io.github.rosemoe.sora.langs.css3;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.text.TextUtils;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

public class CSS3Language implements EditorLanguage {
    /**
     *
     */
    public static final String[] MCSS = {
            "align-content",
            "align-items",
            "align-self",
            "all",
            "animation",
            "animation-delay",
            "animation-direction",
            "animation-duration",
            "animation-fill-mode",
            "animation-iteration-count",
            "animation-name",
            "animation-play-state",
            "animation-timing-function",
            "backface-visibility",
            "background",
            "background-attachment",
            "background-blur",
            "background-clip",
            "background-color",
            "background-image",
            "background-origin",
            "background-position",
            "background-repeat",
            "background-size",
            "border",
            "border-bottom",
            "border-bottom-color",
            "border-bottom-left-radius",
            "border-bottom-right-radius",
            "border-bottom-style",
            "border-bottom-width",
            "border-collapse",
            "border-color",
            "border-image",
            "border-image-outset",
            "border-image-repeat",
            "border-image-slice",
            "border-image-source",
            "border-image-width",
            "border-left",
            "border-left-color",
            "border-left-style",
            "border-left-width",
            "border-radius",
            "border-right",
            "border-right-color",
            "border-right-style",
            "border-right-width",
            "border-spacing",
            "border-style",
            "border-top",
            "border-top-color",
            "border-top-left-radius",
            "border-top-right-radius",
            "border-top-style",
            "border-top-width",
            "border-width",
            "bottom",
            "box-decoration-break",
            "box-shadow",
            "box-sizing",
            "break-after",
            "break-before",
            "break-inside",
            "caption-side",
            "caret-color",
            "clear",
            "clip",
            "color",
            "column-count",
            "column-fill",
            "column-gap",
            "column-rule",
            "column-rule-color",
            "column-rule-style",
            "column-rule-width",
            "column-span",
            "column-width",
            "columns",
            "content",
            "counter-increment",
            "counter-reset",
            "cursor",
            "direction",
            "display",
            "empty-cells",
            "filter",
            "flex",
            "flex-basis",
            "flex-direction",
            "flex-flow",
            "flex-grow",
            "flex-shrink",
            "flex-wrap",
            "float",
            "font",
            "font-family",
            "font-size",
            "font-size-adjust",
            "font-stretch",
            "font-style",
            "font-variant",
            "font-variant-caps",
            "font-weight",
            "gap",
            "grid",
            "grid-area",
            "grid-auto-columns",
            "grid-auto-flow",
            "grid-auto-rows",
            "grid-column",
            "grid-column-end",
            "grid-column-gap",
            "grid-column-start",
            "grid-gap",
            "grid-row",
            "grid-row-end",
            "grid-row-gap",
            "grid-row-start",
            "grid-template",
            "grid-template-areas",
            "grid-template-columns",
            "grid-template-rows",
            "height",
            "ime-mode",
            "justify-content",
            "left",
            "letter-spacing",
            "line-break",
            "line-height",
            "list-style",
            "list-style-image",
            "list-style-position",
            "list-style-type",
            "margin",
            "margin-bottom",
            "margin-left",
            "margin-right",
            "margin-top",
            "marker-offset",
            "max-height",
            "max-width",
            "min-height",
            "min-width",
            "mix-blend-mode",
            "object-fit",
            "object-position",
            "opacity",
            "order",
            "orphans",
            "outline",
            "outline-color",
            "outline-offset",
            "outline-style",
            "outline-width",
            "overflow",
            "overflow-wrap",
            "overflow-x",
            "overflow-y",
            "padding",
            "padding-bottom",
            "padding-left",
            "padding-right",
            "padding-top",
            "page-break-after",
            "page-break-before",
            "page-break-inside",
            "perspective",
            "perspective-origin",
            "pointer-events",
            "position",
            "quotes",
            "resize",
            "right",
            "row-gap",
            "scroll-behavior",
            "speak",
            "table-layout",
            "tab-size",
            "text-align",
            "text-align-last",
            "text-decoration",
            "text-decoration-color",
            "text-decoration-line",
            "text-decoration-skip",
            "text-decoration-style",
            "text-indent",
            "text-justify",
            "text-overflow",
            "text-shadow",
            "text-transform",
            "text-underline-position",
            "top",
            "transform",
            "transform-origin",
            "transform-style",
            "transition",
            "transition-delay",
            "transition-duration",
            "transition-property",
            "transition-timing-function",
            "unicode-bidi",
            "vertical-align",
            "visibility",
            "white-space",
            "widows",
            "width",
            "will-change",
            "word-break",
            "word-spacing",
            "word-wrap",
            "writing-mode",
            "z-index"
    };
    public static final String[] cssAttr = {
            "px",
            "em",
            "flex",
            "vim",
            "rem",
            "vh",
            "vw",
            "pt",
            "cm",
            "mm",
            "in",
            "pc",
            "ex",
            "ch",
            "deg",
            "grad",
            "rad",
            "turn",
            "s",
            "ms",
            "%",
            "fr",
            "underline",
            "italic",
            "bold",
            "normal",
            "#RRGGBB",
            "rgba(R, G, B, A)",
            "hsl(H, S, L)",
            "url(\"path/to/image\")",
            "none",
            "block",
            "inline",
            "inline-block",
            "table",
            "table-cell",
            "table-row",
            "absolute",
            "relative",
            "fixed",
            "center",
            "bottom",
            "top",
            "left",
            "right",
            "none",
            "visible",
            "hidden",
            "collapse",
            "visible",
            "uppercase",
            "lowercase",
            "capitalize",
            "wrap",
            "nowrap",
            "shrink",
            "reverse",
            "nowrap",
            "horizontal",
            "vertical",
            "repeat",
            "no-repeat",
            "repeat-x",
            "repeat-y"
    };
    public static final String[] pishfarz = {"css3", "3", "?"};
    public static final String[] list = {"@import", "@salca"};
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
    private final NewlineHandler[] newLineHandlers =
            new NewlineHandler[]{
                    new BraceHandler(), new TwoIndentHandler(), new JavaDocStartHandler(), new JavaDocHandler()
            };
    protected CodeEditor soraEditor;

    public CSS3Language() {
    }

    public CSS3Language(CodeEditor editor) {
        this.soraEditor = editor;
    }

    @Override
    public CodeAnalyzer getAnalyzer() {
        return new CSS3Analyzer(soraEditor);
    }

    @Override
    public AutoCompleteProvider getAutoCompleteProvider() {
        return new CSS3AutoComplete();
    }

    @Override
    public boolean isAutoCompleteChar(char ch) {
        return MyCharacter.isJavaIdentifierPart(ch)
                || ch == '<'
                || ch == '/'
                || ch == ':'
                || ch == '.'
                || ch == '!'
                || ch == '<'
                || ch == '?'
                || ch == '#'
                || ch == '('
                || ch == ')'
                || ch == '-'
                || ch == '\''
                || ch == '@'
                || ch == '\\';
    }

    @Override
    public int getIndentAdvance(String content) {
        try {
            css3Lexer lexer = new css3Lexer(CharStreams.fromReader(new StringReader(content)));
            Token token;
            int advance = 0;
            while (((token = lexer.nextToken()) != null && token.getType() != token.EOF)) {
                switch (token.getType()) {
                    case css3Lexer.OpenBrace:
                        advance++;
                        break;
                    case css3Lexer.CloseBrace:
                        advance--;
                        break;
                }
            }
            advance = Math.max(0, advance);
            return advance * 4;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean useTab() {
        return true;
    }

    @Override
    public CharSequence format(CharSequence text) {
        return text;
    }

    @Override
    public SymbolPairMatch getSymbolPairs() {
        return new SymbolPairMatch.DefaultSymbolPairs();
    }

    @Override
    public NewlineHandler[] getNewlineHandlers() {
        return newLineHandlers;
    }

    class BraceHandler implements NewlineHandler {

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

    class JavaDocStartHandler implements NewlineHandler {

        private boolean shouldCreateEnd = true;

        @Override
        public boolean matchesRequirement(String beforeText, String afterText) {
            return beforeText.trim().startsWith("/**");
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
                            .append(" * ");
            if (shouldCreateEnd) {
                sb.append("\n")
                        .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
                        .append(" */");
            }
            return new HandleResult(sb, text.length() + 4);
        }
    }

    class JavaDocHandler implements NewlineHandler {

        @Override
        public boolean matchesRequirement(String beforeText, String afterText) {
            return beforeText.trim().startsWith("*") && !beforeText.trim().startsWith("*/");
        }

        @Override
        public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
            int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
            int advanceAfter = getIndentAdvance(afterText);
            StringBuilder sb =
                    new StringBuilder()
                            .append("\n")
                            .append(TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
                            .append("* ");
            return new HandleResult(sb, 0);
        }
    }

    class TwoIndentHandler implements NewlineHandler {

        @Override
        public boolean matchesRequirement(String beforeText, String afterText) {
            //  Log.d("BeforeText", beforeText);
            if (beforeText.replace("\r", "").trim().startsWith(".")) {
                return false;
            }
            return beforeText.endsWith(")") && !afterText.startsWith(";");
        }

        @Override
        public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
            int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
            int advanceAfter = getIndentAdvance(afterText) + (4 * 2);
            String text;
            StringBuilder sb =
                    new StringBuilder()
                            .append('\n')
                            .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()));
            int shiftLeft = 0;
            return new HandleResult(sb, shiftLeft);
        }
    }
}
