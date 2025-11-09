package io.github.rosemoe.sora.langs.php;

import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.langs.internal.TrieTree;

/**
 * @author Rose
 */
public class Css3TextTokenizer {

    public static String[] CodeSpamel = {
            "forEach",
            "tryCatch",
            "trycatchRes",
            "ifelse",
            "ifnotnull",
            "public_static_?",
            "public_static_String".trim()
    };
    protected static String[] sKeywords;
    private static TrieTree<TokenCss> keywords;

    static {
        doStaticInit();
    }

    protected int bufferLen;
    protected int offset;
    protected int length;
    private CharSequence source;
    private int line;
    private int column;
    private int index;
    private TokenCss currToken;
    private boolean lcCal;
    private boolean skipWS;
    private boolean skipComment;

    public Css3TextTokenizer(CharSequence src) {
        if (src == null) {
            throw new IllegalArgumentException("src can not be null");
        }
        this.source = src;
        init();
    }

    public static TrieTree<TokenCss> getTree() {
        return keywords;
    }

    protected static void doStaticInit() {
        sKeywords =
                new String[]{
                        "red",
                };
        TokenCss[] sTokenCss =
                new TokenCss[]{
                        TokenCss.RED,
                };
        keywords = new TrieTree<>();
        for (int i = 0; i < sKeywords.length; i++) {
            keywords.put(sKeywords[i], sTokenCss[i]);
        }
    }

    protected static boolean isDigit(char c) {
        return ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'));
    }

    protected static boolean isPrimeDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    protected static boolean isWhitespace(char c) {
        return (c == '\t' || c == ' ' || c == '\f' || c == '\n' || c == '\r');
    }

    private void init() {
        line = 0;
        column = 0;
        length = 0;
        index = 0;
        currToken = TokenCss.WHITESPACE;
        lcCal = false;
        skipWS = false;
        skipComment = false;
        this.bufferLen = source.length();
    }

    public void setCalculateLineColumn(boolean cal) {
        this.lcCal = cal;
    }

    public void setSkipWhitespace(boolean skip) {
        this.skipWS = skip;
    }

    public void setSkipComment(boolean skip) {
        this.skipComment = skip;
    }

    public void pushBack(int length) {
        if (length > getTokenLength()) {
            throw new IllegalArgumentException("pushBack length too large");
        }
        this.length -= length;
    }

    private boolean isIdentifierPart(char ch) {
        return MyCharacter.isJavaIdentifierPart(ch);
    }

    private boolean isIdentifierStart(char ch) {
        return MyCharacter.isJavaIdentifierStart(ch);
    }

    public CharSequence getTokenCsstring() {
        return source.subSequence(offset, offset + length);
    }

    public int getTokenLength() {
        return length;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public int getIndex() {
        return index;
    }

    public TokenCss getToken() {
        return currToken;
    }

    public String yyDesc() {
        return " Line：" + line + " Column：" + column;
    }

    private char charAt(int i) {
        return source.charAt(i);
    }

    private char charAt() {
        return source.charAt(offset + length);
    }

    public TokenCss nextToken() {
        TokenCss token;
        do {
            token = directNextToken();
        } while ((skipWS && token == TokenCss.WHITESPACE)
                || (skipComment && (token == TokenCss.LINE_COMMENT || token == TokenCss.LONG_COMMENT)));
        currToken = token;
        return token;
    }

    public TokenCss directNextToken() {
        if (lcCal) {
            boolean r = false;
            for (int i = offset; i < offset + length; i++) {
                char ch = charAt(i);
                if (ch == '\r') {
                    r = true;
                    line++;
                    column = 0;
                } else if (ch == '\n') {
                    if (r) {
                        r = false;
                        continue;
                    }
                    line++;
                    column = 0;
                } else {
                    r = false;
                    column++;
                }
            }
        }
        index = index + length;
        offset = offset + length;
        if (offset == bufferLen) {
            return TokenCss.EOF;
        }
        char ch = source.charAt(offset);
        length = 1;
        if (ch == '\n') {
            return TokenCss.NEWLINE;
        } else if (ch == '\r') {
            scanNewline();
            return TokenCss.NEWLINE;
        } else if (isWhitespace(ch)) {
            char chLocal;
            while (offset + length < bufferLen && isWhitespace(chLocal = charAt(offset + length))) {
                if (chLocal == '\r' || chLocal == '\n') {
                    break;
                }
                length++;
            }
            return TokenCss.WHITESPACE;
        } else {
            if (isIdentifierStart(ch)) {
                return scanIdentifier(ch);
            }
            if (isPrimeDigit(ch)) {
                return scanNumber();
            }
            /* Scan usual symbols first */
            if (ch == ';') {
                return TokenCss.SEMICOLON;
            } else if (ch == '(') {
                return TokenCss.LPAREN;
            } else if (ch == ')') {
                return TokenCss.RPAREN;
            } else if (ch == ':') {
                return TokenCss.COLON;
            } else if (ch == '<') {
                return scanLT();
            } else if (ch == '>') {
                return scanGT();
            }
            /* Scan secondly symbols */
            switch (ch) {
                case '=':
                    return scanOperatorTwo(TokenCss.EQ);
                case '.':
                    return TokenCss.DOT;
                case '@':
                    return TokenCss.AT;
                case '{':
                    return TokenCss.LBRACE;
                case '}':
                    return TokenCss.RBRACE;
                case '/':
                    return scanDIV();
                case '*':
                    return scanOperatorTwo(TokenCss.MULT);
                case '-':
                    return scanOperatorTwo(TokenCss.MINUS);
                case '+':
                    return scanOperatorTwo(TokenCss.PLUS);
                case '[':
                    return TokenCss.LBRACK;
                case ']':
                    return TokenCss.RBRACK;
                case ',':
                    return TokenCss.COMMA;
                case '!':
                    return TokenCss.NOT;
                case '~':
                    return TokenCss.COMP;
                case '?':
                    return TokenCss.QUESTION;
                case '&':
                    return scanOperatorTwo(TokenCss.AND);
                case '|':
                    return scanOperatorTwo(TokenCss.OR);
                case '^':
                    return scanOperatorTwo(TokenCss.XOR);
                case '%':
                    return scanOperatorTwo(TokenCss.MOD);
                case '\'':
                    scanCharLiteral();
                    return TokenCss.CHARACTER_LITERAL;
                case '\"':
                    scanStringLiteral();
                    return TokenCss.STRING;
                default:
                    // error("没有匹配的Token : '" + ch + " '", new
                    // StringAdvice("检查是否使用了非法的符号，比如误使用了中文符号代替英文符号等"));
                    return TokenCss.UNKNOWN;
            }
        }
    }

    protected final void throwIfNeeded() {
        if (offset + length == bufferLen) {
            throw new RuntimeException("Token too long");
        }
    }

    /* The following methods have been simplified for syntax high light */

    protected void scanNewline() {
        if (offset + length < bufferLen && charAt(offset + length) == '\n') {
            length++;
        }
    }

    protected TokenCss scanIdentifier(char ch) {
        TrieTree.Node<TokenCss> n = keywords.root.map.get(ch);
        while (offset + length < bufferLen && isIdentifierPart(ch = charAt(offset + length))) {
            length++;
            n = n == null ? null : n.map.get(ch);
        }
        return n == null ? TokenCss.IDENTIFIER : (n.token == null ? TokenCss.IDENTIFIER : n.token);
    }

    protected void scanTrans() {
        throwIfNeeded();
        char ch = charAt();
        if (ch == '\\'
                || ch == 't'
                || ch == 'f'
                || ch == 'n'
                || ch == 'r'
                || ch == '0'
                || ch == '\"'
                || ch == '\''
                || ch == 'b') {
            length++;
        } else if (ch == 'u') {
            length++;
            for (int i = 0; i < 4; i++) {
                throwIfNeeded();
                if (!isDigit(charAt(offset + length))) {
                    return;
                }
                length++;
            }
        }
    }

    protected void scanStringLiteral() {
        throwIfNeeded();
        char ch;
        while (offset + length < bufferLen && (ch = charAt(offset + length)) != '\"') {
            if (ch == '\\') {
                length++;
                scanTrans();
            } else {
                if (ch == '\n') {

                    return;
                }
                length++;
                throwIfNeeded();
            }
        }
        if (offset + length != bufferLen) {
            length++;
        }
    }

    protected void scanCharLiteral() {
        throwIfNeeded();
        char ch = charAt();
        if (ch == '\\') {
            length++;
            scanTrans();
        } else if (ch == '\'') {
            length++;
            return;
        } else {
            if (ch == '\n') {
                return;
            }
            length++;
        }
        throwIfNeeded();
        if (charAt() == '\'') {
            length++;
        }
    }

    protected TokenCss scanNumber() {
        if (offset + length == bufferLen) {
            return TokenCss.INTEGER_LITERAL;
        }
        boolean flag = false;
        char ch = charAt(offset);
        if (ch == '0') {
            if (charAt() == 'x') {
                length++;
            }
            flag = true;
        }
        while (offset + length < bufferLen && isDigit(charAt())) {
            length++;
        }
        if (offset + length == bufferLen) {
            return TokenCss.INTEGER_LITERAL;
        }
        ch = charAt();
        if (ch == '.') {
            if (flag) {
                return TokenCss.INTEGER_LITERAL;
            }
            if (offset + length + 1 == bufferLen) {
                return TokenCss.INTEGER_LITERAL;
            }
            length++;
            throwIfNeeded();
            while (offset + length < bufferLen && isDigit(charAt())) {
                length++;
            }
            if (offset + length == bufferLen) {
                return TokenCss.FLOATING_POINT_LITERAL;
            }
            ch = charAt();
            if (ch == 'e' || ch == 'E') {
                length++;
                throwIfNeeded();
                if (charAt() == '-' || charAt() == '+') {
                    length++;
                    throwIfNeeded();
                }
                while (offset + length < bufferLen && isPrimeDigit(charAt())) {
                    length++;
                }
                if (offset + length == bufferLen) {
                    return TokenCss.FLOATING_POINT_LITERAL;
                }
                ch = charAt();
            }
            if (ch == 'f' || ch == 'F' || ch == 'D' || ch == 'd') {
                length++;
            }
            return TokenCss.FLOATING_POINT_LITERAL;
        } else if (ch == 'l' || ch == 'L') {
            length++;
            return TokenCss.INTEGER_LITERAL;
        } else if (ch == 'F' || ch == 'f' || ch == 'D' || ch == 'd') {
            length++;
            return TokenCss.FLOATING_POINT_LITERAL;
        } else {
            return TokenCss.INTEGER_LITERAL;
        }
    }

    protected TokenCss scanDIV() {
        if (offset + 1 == bufferLen) {
            return TokenCss.DIV;
        }
        char ch = charAt();
        if (ch == '/') {
            length++;
            while (offset + length < bufferLen && charAt() != '\n') {
                length++;
            }
            return TokenCss.LINE_COMMENT;
        } else if (ch == '*') {
            length++;
            char pre, curr = '?';
            while (offset + length < bufferLen) {
                pre = curr;
                curr = charAt();
                if (curr == '/' && pre == '*') {
                    length++;
                    break;
                }
                length++;
            }
            return TokenCss.LONG_COMMENT;
        } else {
            return TokenCss.DIV;
        }
    }

    @SuppressWarnings("SameReturnValue")
    protected TokenCss scanLT() {
        return TokenCss.LT;
    }

    @SuppressWarnings("SameReturnValue")
    protected TokenCss scanGT() {
        return TokenCss.GT;
    }

    protected TokenCss scanOperatorTwo(TokenCss ifWrong) {
        return ifWrong;
    }

    public void reset(CharSequence src) {
        if (src == null) {
            throw new IllegalArgumentException();
        }
        this.source = src;
        line = 0;
        column = 0;
        length = 0;
        index = 0;
        offset = 0;
        currToken = TokenCss.WHITESPACE;
        bufferLen = src.length();
    }
}
