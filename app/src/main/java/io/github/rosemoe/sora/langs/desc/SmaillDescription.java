package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;

public class SmaillDescription implements LanguageDescription {
    public boolean isLineCommentStart(char c, char c2) {
        return c == '\\' && c2 == '*';
    }

    public boolean isLongCommentEnd(char c, char c2) {
        return c == '*' && c2 == '\\';
    }

    public boolean isLongCommentStart(char c, char c2) {
        return c == '/' && c2 == '*';
    }

    public boolean isSupportBlockLine() {
        return true;
    }

    public boolean useTab() {
        return false;
    }

    public boolean isOperator(char[] cArr, int i) {
        if (i != 1) {
            return false;
        }
        char c = cArr[0];
        return c == '+' || c == '-' || c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')' || c == '|' || c == ':' || c == '.' || c == ',' || c == ';' || c == '*' || c == '/' || c == '&' || c == '^' || c == '%' || c == '!' || c == '~' || c == '<' || c == '>' || c == '=' || c == '\\' || c == '#';
    }

    public String[] getKeywords() {
        return new String[]{"DEFAULT_MODE", "TRIPLE_QUOTED_GSTRING_MODE", "DOUBLE_QUOTED_GSTRING_MODE",
                "SLASHY_GSTRING_MODE", "DOLLAR_SLASHY_GSTRING_MODE", "GSTRING_TYPE_SELECTOR_MODE",
                "GSTRING_PATH", "LINE_COMMENT", "DOC_COMMENT", "BLOCK_COMMENT", "SHEBANG_COMMENT", "WS",
                "LPAREN", "RPAREN", "LBRACK", "RBRACK", "LCURVE", "RCURVE", "MULTILINE_STRING",
                "MULTILINE_GSTRING_START", "STRING", "SLASHY_STRING", "DOLLAR_SLASHY_STRING",
                "GSTRING_START", "SLASHY_GSTRING_START", "DOLLAR_SLASHY_GSTRING_START",
                "SLASHY_STRING_ELEMENT", "DOLLAR_SLASHY_STRING_ELEMENT", "TSQ_STRING_ELEMENT",
                "SQ_STRING_ELEMENT", "TDQ_STRING_ELEMENT", "DQ_STRING_ELEMENT", "TSQ",
                "TDQ", "LDS", "RDS", "IDENTIFIER_IN_GSTRING", "MULTILINE_GSTRING_END",
                "MULTILINE_GSTRING_PART", "MULTILINE_GSTRING_ELEMENT", "GSTRING_END",
                "GSTRING_PART", "GSTRING_ELEMENT", "SLASHY_GSTRING_END", "SLASHY_GSTRING_PART",
                "SLASHY_GSTRING_ELEMENT", "DOLLAR_SLASHY_GSTRING_END", "DOLLAR_SLASHY_GSTRING_PART",
                "DOLLAR_SLASHY_GSTRING_ELEMENT", "GSTRING_BRACE_L", "GSTRING_ID", "GSTRING_PATH_PART",
                "ROLLBACK_ONE", "SLASHY_ESCAPE", "DOLLAR_ESCAPE", "JOIN_LINE_ESCAPE",
                "ESC_SEQUENCE", "OCTAL_ESC_SEQ", "UNICODE_ESCAPE", "DECIMAL", "INTEGER",
                "DIGITS", "DEC_DIGITS", "OCT_DIGITS", "ZERO_TO_SEVEN", "HEX_DIGITS",
                "HEX_DIGIT", "BIN_DIGITS", "BIN_DIGIT", "SIGN", "EXP_PART", "DIGIT",
                "INTEGER_TYPE_MODIFIER", "DECIMAL_TYPE_MODIFIER", "DECIMAL_ONLY_TYPE_MODIFIER",
                "KW_CLASS", "KW_INTERFACE", "KW_TRAIT", "KW_ENUM", "KW_PACKAGE", "KW_IMPORT",
                "KW_EXTENDS", "KW_IMPLEMENTS", "KW_DEF", "KW_NULL", "KW_TRUE", "KW_FALSE",
                "KW_NEW", "KW_SUPER", "KW_THIS", "KW_IN", "KW_FOR", "KW_IF", "KW_ELSE",
                "KW_DO", "KW_WHILE", "KW_SWITCH", "KW_CASE", "KW_DEFAULT", "KW_CONTINUE",
                "KW_BREAK", "KW_RETURN", "KW_TRY", "KW_CATCH", "KW_FINALLY", "KW_THROW",
                "KW_THROWS", "KW_ASSERT", "KW_CONST", "KW_GOTO", "RUSHIFT_ASSIGN", "RSHIFT_ASSIGN",
                "LSHIFT_ASSIGN", "SPACESHIP", "ELVIS", "SAFE_DOT", "STAR_DOT", "ATTR_DOT",
                "MEMBER_POINTER", "LTE", "GTE", "CLOSURE_ARG_SEPARATOR", "DECREMENT",
                "INCREMENT", "POWER", "LSHIFT", "RANGE", "ORANGE", "EQUAL", "UNEQUAL",
                "MATCH", "FIND", "AND", "OR", "PLUS_ASSIGN", "MINUS_ASSIGN", "MULT_ASSIGN",
                "DIV_ASSIGN", "MOD_ASSIGN", "BAND_ASSIGN", "XOR_ASSIGN", "BOR_ASSIGN",
                "SEMICOLON", "DOT", "COMMA", "AT", "ASSIGN", "LT", "GT", "COLON", "BOR",
                "NOT", "BNOT", "MULT", "DIV", "MOD", "PLUS", "MINUS", "BAND", "XOR",
                "QUESTION", "ELLIPSIS", "KW_AS", "KW_INSTANCEOF", "BUILT_IN_TYPE", "VISIBILITY_MODIFIER",
                "KW_PUBLIC", "KW_PROTECTED", "KW_PRIVATE", "KW_ABSTRACT", "KW_STATIC",
                "KW_FINAL", "KW_TRANSIENT", "KW_NATIVE", "KW_VOLATILE", "KW_SYNCHRONIZED",
                "KW_STRICTFP", "KW_THREADSAFE", "IGNORE_NEWLINE", "NL", "IDENTIFIER",
                "JavaLetter", "JavaLetterOrDigit", "JavaLetterInGString", "JavaLetterOrDigitInGString",
                "JavaUnicodeChar", "SHEBANG_COMMENT", "WS", "LPAREN", "RPAREN", "LBRACK", "RBRACK",
                "LCURVE", "RCURVE", "STRING", "GSTRING_START", "GSTRING_END", "GSTRING_PART",
                "GSTRING_PATH_PART", "ROLLBACK_ONE", "DECIMAL", "INTEGER", "KW_CLASS",
                "KW_INTERFACE", "KW_TRAIT", "KW_ENUM", "KW_PACKAGE", "KW_IMPORT", "KW_EXTENDS",
                "KW_IMPLEMENTS", "KW_DEF", "KW_NULL", "KW_TRUE", "KW_FALSE", "KW_NEW",
                "KW_SUPER", "KW_THIS", "KW_IN", "KW_FOR", "KW_IF", "KW_ELSE", "KW_DO",
                "KW_WHILE", "KW_SWITCH", "KW_CASE", "KW_DEFAULT", "KW_CONTINUE", "KW_BREAK",
                "KW_RETURN", "KW_TRY", "KW_CATCH", "KW_FINALLY", "KW_THROW", "KW_THROWS",
                "KW_ASSERT", "KW_CONST", "KW_GOTO", "RUSHIFT_ASSIGN", "RSHIFT_ASSIGN",
                "LSHIFT_ASSIGN", "SPACESHIP", "ELVIS", "SAFE_DOT", "STAR_DOT", "ATTR_DOT",
                "MEMBER_POINTER", "LTE", "GTE", "CLOSURE_ARG_SEPARATOR", "DECREMENT",
                "INCREMENT", "POWER", "LSHIFT", "RANGE", "ORANGE", "EQUAL", "UNEQUAL",
                "MATCH", "FIND", "AND", "OR", "PLUS_ASSIGN", "MINUS_ASSIGN", "MULT_ASSIGN",
                "DIV_ASSIGN", "MOD_ASSIGN", "BAND_ASSIGN", "XOR_ASSIGN", "BOR_ASSIGN",
                "SEMICOLON", "DOT", "COMMA", "AT", "ASSIGN", "LT", "GT", "COLON", "BOR",
                "NOT", "BNOT", "MULT", "DIV", "MOD", "PLUS", "MINUS", "BAND", "XOR",
                "QUESTION", "ELLIPSIS", "KW_AS", "KW_INSTANCEOF", "BUILT_IN_TYPE", "VISIBILITY_MODIFIER",
                "KW_ABSTRACT", "KW_STATIC", "KW_FINAL", "KW_TRANSIENT", "KW_NATIVE",
                "KW_VOLATILE", "KW_SYNCHRONIZED", "KW_STRICTFP", "KW_THREADSAFE", "IGNORE_NEWLINE",
                "NL", "IDENTIFIER"
        };
    }

    public int getOperatorAdvance(String str) {
        str.hashCode();
        if (!str.equals(".")) {
            return !str.equals(".") ? 0 : -4;
        }
        return 4;
    }

    public boolean isBlockStart(String str) {
        return str.equals(".");
    }

    public boolean isBlockEnd(String str) {
        return str.equals(".");
    }
}
///code by ninja coder
