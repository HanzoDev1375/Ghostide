package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;

public class GoDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            return (c == '+' || c == '-' || c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')'
                    || c == '|' || c == ':' || c == '.' || c == ',' || c == ';' || c == '*' || c == '/' || c == '&'
                    || c == '^' || c == '%' || c == '!' || c == '~' || c == '<' || c == '>' || c == '=' || c == '\\'
                    || c == '#');
        }
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        return a == '/' && b == '/';
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        return a == '/' && b == '#';
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        return a == '#' && b == '/';
    }

    @Override
    public String[] getKeywords() {
        //noinspection SpellCheckingInspection
        return new String[]{"append", "bool", "break", "byte", "cap", "case", "copy", "chan", "close", "complex128",
                "default", "defer", "defer", "delete", "else", "error", "fallthrough", "false", "float32", "float64",
                "for", "go", "goto", "if", "imag", "import", "int", "int8", "int16", "int32", "len", "make", "map",
                "new", "nil", "package", "panic", "print", "println", "panicln", "real", "range", "recover", "return",
                "uint", "uint8", "uint16", "uint32", "uint64", "uintptr", "var"};
    }

    @Override
    public boolean useTab() {
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        switch (operator) {
            case "(":
                return 4;
            case ")":
                return -4;
            case "{":
                return 4;
            case "}":
                return -4;
        }
        return 0;
    }

    @Override
    public boolean isSupportBlockLine() {
        return true;
    }

    @Override
    public boolean isBlockStart(String operator) {
        return operator.equals("(");
    }

    @Override
    public boolean isBlockEnd(String operator) {
        return operator.equals(")");
    }
}
