package io.github.rosemoe.sora.langs.ghostthemelang.ghostlang;

import io.github.rosemoe.sora.langs.ghostthemelang.TokenCompat;
import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.langs.internal.TrieTree;

/**
 * @author Rose
 */
public class GhostTextTokenizer {

    protected static String[] sKeywords;
    private static TrieTree<TokenCompat> keywords;

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
    private TokenCompat currToken;
    private boolean lcCal;
    private boolean skipWS;
    private boolean skipComment;

    public GhostTextTokenizer(CharSequence src) {
        if (src == null) {
            throw new IllegalArgumentException("src can not be null");
        }
        this.source = src;
        init();
    }

    public static TrieTree<TokenCompat> getTree() {
        return keywords;
    }

    protected static void doStaticInit() {
        sKeywords = new String[]{};

        TokenCompat[] sTokenCompat = new TokenCompat[]{};

        keywords = new TrieTree<>();
        for (int i = 0; i < sKeywords.length; i++) {
            keywords.put(sKeywords[i], sTokenCompat[i]);
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
        currToken = TokenCompat.WHITESPACE;
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

    public CharSequence getTokenCompattring() {
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

    public TokenCompat getToken() {
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

    public TokenCompat nextToken() {
        TokenCompat token;
        do {
            token = directNextToken();
        } while ((skipWS && token == TokenCompat.WHITESPACE)
                || (skipComment
                && (token == TokenCompat.LINE_COMMENT || token == TokenCompat.LONG_COMMENT)));
        currToken = token;
        return token;
    }

    public TokenCompat directNextToken() {
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
            return TokenCompat.EOF;
        }
        char ch = source.charAt(offset);
        length = 1;
        if (ch == '\n') {
            return TokenCompat.NEWLINE;
        } else if (ch == '\r') {
            scanNewline();
            return TokenCompat.NEWLINE;
        } else if (isWhitespace(ch)) {
            char chLocal;
            while (offset + length < bufferLen && isWhitespace(chLocal = charAt(offset + length))) {
                if (chLocal == '\r' || chLocal == '\n') {
                    break;
                }
                length++;
            }
            return TokenCompat.WHITESPACE;
        } else {
            if (isIdentifierStart(ch)) {
                return scanIdentifier(ch);
            }
            if (isPrimeDigit(ch)) {
                return scanNumber();
            }
            /* Scan usual symbols first */
            if (ch == ';') {
                return TokenCompat.SEMICOLON;
            } else if (ch == '(') {
                return TokenCompat.LPAREN;
            } else if (ch == ')') {
                return TokenCompat.RPAREN;
            } else if (ch == ':') {
                return TokenCompat.COLON;
            } else if (ch == '<') {
                return scanLT();
            } else if (ch == '>') {
                return scanGT();
            }
            /* Scan secondly symbols */
            switch (ch) {
                case '=':
                    return scanOperatorTwo(TokenCompat.EQ);
                case '.':
                    return TokenCompat.DOT;
                case '@':
                    return TokenCompat.AT;
                case '{':
                    return TokenCompat.LBRACE;
                case '}':
                    return TokenCompat.RBRACE;
                case '/':
                    return scanDIV();
                case '*':
                    return scanOperatorTwo(TokenCompat.MULT);
                case '-':
                    return scanOperatorTwo(TokenCompat.MINUS);
                case '+':
                    return scanOperatorTwo(TokenCompat.PLUS);
                case '[':
                    return TokenCompat.LBRACK;
                case ']':
                    return TokenCompat.RBRACK;
                case ',':
                    return TokenCompat.COMMA;
                case '!':
                    return TokenCompat.NOT;
                case '~':
                    return TokenCompat.COMP;
                case '?':
                    return TokenCompat.QUESTION;
                case '&':
                    return scanOperatorTwo(TokenCompat.AND);
                case '|':
                    return scanOperatorTwo(TokenCompat.OR);
                case '^':
                    return scanOperatorTwo(TokenCompat.XOR);
                case '%':
                    return scanOperatorTwo(TokenCompat.MOD);
                case '\'':
                    scanCharLiteral();
                    return TokenCompat.CHARACTER_LITERAL;
                case '\"':
                    scanStringLiteral();
                    return TokenCompat.STRING;
                default:
                    // error("没有匹配的Token : '" + ch + " '", new
                    // StringAdvice("检查是否使用了非法的符号，比如误使用了中文符号代替英文符号等"));
                    return TokenCompat.UNKNOWN;
            }
        }
    }

    protected final void throwIfNeeded() {
        if (offset + length == bufferLen) {
            throw new RuntimeException("Token too long");
        }
    }

    protected void scanNewline() {
        if (offset + length < bufferLen && charAt(offset + length) == '\n') {
            length++;
        }
    }

    /* The following methods have been simplified for syntax high light */

    protected TokenCompat scanIdentifier(char ch) {
        TrieTree.Node<TokenCompat> n = keywords.root.map.get(ch);
        while (offset + length < bufferLen && isIdentifierPart(ch = charAt(offset + length))) {
            length++;
            n = n == null ? null : n.map.get(ch);
        }
        return n == null
                ? TokenCompat.IDENTIFIER
                : (n.token == null ? TokenCompat.IDENTIFIER : n.token);
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

    protected TokenCompat scanNumber() {
        if (offset + length == bufferLen) {
            return TokenCompat.INTEGER_LITERAL;
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
            return TokenCompat.INTEGER_LITERAL;
        }
        ch = charAt();
        if (ch == '.') {
            if (flag) {
                return TokenCompat.INTEGER_LITERAL;
            }
            if (offset + length + 1 == bufferLen) {
                return TokenCompat.INTEGER_LITERAL;
            }
            length++;
            throwIfNeeded();
            while (offset + length < bufferLen && isDigit(charAt())) {
                length++;
            }
            if (offset + length == bufferLen) {
                return TokenCompat.FLOATING_POINT_LITERAL;
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
                    return TokenCompat.FLOATING_POINT_LITERAL;
                }
                ch = charAt();
            }
            if (ch == 'f' || ch == 'F' || ch == 'D' || ch == 'd') {
                length++;
            }
            return TokenCompat.FLOATING_POINT_LITERAL;
        } else if (ch == 'l' || ch == 'L') {
            length++;
            return TokenCompat.INTEGER_LITERAL;
        } else if (ch == 'F' || ch == 'f' || ch == 'D' || ch == 'd') {
            length++;
            return TokenCompat.FLOATING_POINT_LITERAL;
        } else {
            return TokenCompat.INTEGER_LITERAL;
        }
    }

    protected TokenCompat scanDIV() {
        if (offset + 1 == bufferLen) {
            return TokenCompat.DIV;
        }
        char ch = charAt();
        if (ch == '/') {
            length++;
            while (offset + length < bufferLen && charAt() != '\n') {
                length++;
            }
            return TokenCompat.LINE_COMMENT;
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
            return TokenCompat.LONG_COMMENT;
        } else {
            return TokenCompat.DIV;
        }
    }

    @SuppressWarnings("SameReturnValue")
    protected TokenCompat scanLT() {
        return TokenCompat.LT;
    }

    @SuppressWarnings("SameReturnValue")
    protected TokenCompat scanGT() {
        return TokenCompat.GT;
    }

    protected TokenCompat scanOperatorTwo(TokenCompat ifWrong) {
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
        currToken = TokenCompat.WHITESPACE;
        bufferLen = src.length();
    }
}
