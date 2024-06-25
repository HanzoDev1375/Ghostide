package io.github.rosemoe.sora.langs.css;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.stream.Collectors;


public class CSSLanguage implements EditorLanguage {

    public static final String[] MCSS = {"align-content", "align-items", "align-self", "all", "animation",
            "animation-delay", "animation-direction", "animation-duration", "animation-fill-mode",
            "animation-iteration-count", "animation-name", "animation-play-state", "animation-timing-function",
            "backface-visibility", "background", "background-attachment", "background-blur", "background-clip",
            "background-color", "background-image", "background-origin", "background-position", "background-repeat",
            "background-size", "border", "border-bottom", "border-bottom-color", "border-bottom-left-radius",
            "border-bottom-right-radius", "border-bottom-style", "border-bottom-width", "border-collapse",
            "border-color", "border-image", "border-image-outset", "border-image-repeat", "border-image-slice",
            "border-image-source", "border-image-width", "border-left", "border-left-color", "border-left-style",
            "border-left-width", "border-radius", "border-right", "border-right-color", "border-right-style",
            "border-right-width", "border-spacing", "border-style", "border-top", "border-top-color",
            "border-top-left-radius", "border-top-right-radius", "border-top-style", "border-top-width", "border-width",
            "bottom", "box-decoration-break", "box-shadow", "box-sizing", "break-after", "break-before", "break-inside",
            "caption-side", "caret-color", "clear", "clip", "color", "column-count", "column-fill", "column-gap",
            "column-rule", "column-rule-color", "column-rule-style", "column-rule-width", "column-span", "column-width",
            "columns", "content", "counter-increment", "counter-reset", "cursor", "direction", "display", "empty-cells",
            "filter", "flex", "flex-basis", "flex-direction", "flex-flow", "flex-grow", "flex-shrink", "flex-wrap",
            "float", "font", "font-family", "font-size", "font-size-adjust", "font-stretch", "font-style",
            "font-variant", "font-variant-caps", "font-weight", "gap", "grid", "grid-area", "grid-auto-columns",
            "grid-auto-flow", "grid-auto-rows", "grid-column", "grid-column-end", "grid-column-gap",
            "grid-column-start", "grid-gap", "grid-row", "grid-row-end", "grid-row-gap", "grid-row-start",
            "grid-template", "grid-template-areas", "grid-template-columns", "grid-template-rows", "height", "ime-mode",
            "justify-content", "left", "letter-spacing", "line-break", "line-height", "list-style", "list-style-image",
            "list-style-position", "list-style-type", "margin", "margin-bottom", "margin-left", "margin-right",
            "margin-top", "marker-offset", "max-height", "max-width", "min-height", "min-width", "mix-blend-mode",
            "object-fit", "object-position", "opacity", "order", "orphans", "outline", "outline-color",
            "outline-offset", "outline-style", "outline-width", "overflow", "overflow-wrap", "overflow-x", "overflow-y",
            "padding", "padding-bottom", "padding-left", "padding-right", "padding-top", "page-break-after",
            "page-break-before", "page-break-inside", "perspective", "perspective-origin", "pointer-events", "position",
            "quotes", "resize", "right", "row-gap", "scroll-behavior", "speak", "table-layout", "tab-size",
            "text-align", "text-align-last", "text-decoration", "text-decoration-color", "text-decoration-line",
            "text-decoration-skip", "text-decoration-style", "text-indent", "text-justify", "text-overflow",
            "text-shadow", "text-transform", "text-underline-position", "top", "transform", "transform-origin",
            "transform-style", "transition", "transition-delay", "transition-duration", "transition-property",
            "transition-timing-function", "unicode-bidi", "vertical-align", "visibility", "white-space", "widows",
            "width", "will-change", "word-break", "word-spacing", "word-wrap", "writing-mode", "z-index"};
    public static final String[] cssAttr = {"px", "em", "flex", "vim", "rem", "vh", "vw", "pt", "cm", "mm", "in", "pc",
            "ex", "ch", "deg", "grad", "rad", "turn", "s", "ms", "%", "fr", "underline", "italic", "bold", "normal",
            "#RRGGBB", "rgba(R, G, B, A)", "hsl(H, S, L)", "url(\"path/to/image\")", "none", "block", "inline",
            "inline-block", "table", "table-cell", "table-row", "absolute", "relative", "fixed", "center", "bottom",
            "top", "left", "right", "none", "visible", "hidden", "collapse", "visible", "uppercase", "lowercase",
            "capitalize", "wrap", "nowrap", "shrink", "reverse", "nowrap", "horizontal", "vertical", "repeat",
            "no-repeat", "repeat-x", "repeat-y"};
    public static String[] colorsCss = {"aliceblue", "antiquewhite", "aqua", "aquamarine", "azure", "beige", "bisque",
            "black", "blanchedalmond", "blue", "blueviolet", "brown", "burlywood", "cadetblue", "chartreuse",
            "chocolate", "coral", "cornflowerblue", "cornsilk", "crimson", "cyan", "darkblue", "darkcyan",
            "darkgoldenrod", "darkgray", "darkgreen", "darkkhaki", "darkmagenta", "darkolivegreen", "darkorange",
            "darkorchid", "darkred", "darksalmon", "darkseagreen", "darkslateblue", "darkslategray", "darkturquoise",
            "darkviolet", "deeppink", "deepskyblue", "dimgray", "dodgerblue", "firebrick", "floralwhite", "forestgreen",
            "fuchsia", "gainsboro", "ghostwhite", "gold", "goldenrod", "gray", "green", "greenyellow", "honeydew",
            "hotpink", "indianred", "indigo", "ivory", "khaki", "lavender", "lavenderblush", "lawngreen",
            "lemonchiffon", "lightblue", "lightcoral", "lightcyan", "lightgoldenrodyellow", "lightgray", "lightgreen",
            "lightpink", "lightsalmon", "lightseagreen", "lightskyblue", "lightslategray", "lightsteelblue",
            "lightyellow", "lime", "limegreen", "linen", "magenta", "maroon", "mediumaquamarine", "mediumblue",
            "mediumorchid", "mediumpurple", "mediumseagreen", "mediumslateblue", "mediumspringgreen", "mediumturquoise",
            "mediumvioletred", "midnightblue", "mintcream", "mistyrose", "moccasin", "navajowhite", "navy", "oldlace",
            "olive", "olivedrab", "orange", "orangered", "orchid", "palegoldenrod", "palegreen", "paleturquoise",
            "palevioletred", "papayawhip", "peachpuff", "peru", "pink", "plum", "powderblue", "purple", "rebeccapurple",
            "red", "rosybrown", "royalblue", "saddlebrown", "salmon", "sandybrown", "seagreen", "seashell", "sienna",
            "silver", "skyblue", "slateblue", "slategray", "snow", "springgreen", "steelblue", "tan", "teal", "thistle",
            "tomato", "turquoise", "violet", "wheat", "white", "whitesmoke", "yellow", "yellowgreen"};

    @Override
    public CodeAnalyzer getAnalyzer() {
        return new CSSAnalyzer();
    }

    @Override
    public AutoCompleteProvider getAutoCompleteProvider() {
        return new CSSAutoComplete();
    }

    /**
     * Checks if the given character is an auto complete character in HTML
     */
    @Override
    public boolean isAutoCompleteChar(char ch) {
        // isDigit -> required to complete tags which may contain a number
        // For example -> h1, h2, h3, h4...
        // Better solution?
        return Character.isLetter(ch) || Character.isDigit(ch);
    }

    @Override
    public int getIndentAdvance(String content) {
        try {
            CSSLexer lexer = new CSSLexer(CharStreams.fromReader(new StringReader(content)));
            Token token;
            int advance = 0;
            while (((token = lexer.nextToken()) != null && token.getType() != token.EOF)) {
                switch (token.getType()) {
                    case CSSLexer.TAG_OPEN:
                        advance++;
                        break;
                    case CSSLexer.TAG_SLASH:
                    case CSSLexer.TAG_SLASH_CLOSE:
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
        return cssFormat(text.toString());
    }

    @Override
    public SymbolPairMatch getSymbolPairs() {

        return new SymbolPairMatch.DefaultSymbolPairs();
    }

    @Override
    public NewlineHandler[] getNewlineHandlers() {
        return new NewlineHandler[0];
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
                    //n = 1 if it's a one line comment
                    if (n != 0) {
                        if (c == '\n') {
                            sb.append(c);
                            sum(sb, n4);
                            n = 0;
                        } else {
                            sb.append(c);
                        }
                    } //check end of multiple lines comment
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
                        //commit
                        if (c == '\n')
                            sum(sb, n4);
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
                        //check start of comments
                        if (c == '/') {
                            final int n8 = i + 1;
                            final char c3 = charArray[n8];
                            //start of one line comment
                            if (c3 == '/') {
                                sb.append(c);
                                sb.append(c3);
                                n = 1;
                                i = n8;
                                break Label_0082;
                            }
                            //start of multiple lines comment
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

    public String cssFormat(String text) {
        return formattingProcess(Arrays.stream(text.split("\n")).map(s -> s.trim()).collect(Collectors.joining("\n")));
    }

}
