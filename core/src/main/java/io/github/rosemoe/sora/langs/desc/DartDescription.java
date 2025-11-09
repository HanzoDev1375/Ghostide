package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;


public class DartDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            return (c == '+' || c == '-' || c == '{' || c == '}' || c == '[' || c == ']' ||
                    c == '(' || c == ')' || c == '|' || c == ':' || c == '.' || c == ',' ||
                    c == ';' || c == '*' || c == '/' || c == '&' || c == '^' || c == '%' ||
                    c == '!' || c == '~' || c == '<' || c == '>' || c == '=' || c == '\\' ||
                    c == '#');
        }
        return false;
    }

    @Override
    public boolean isLineCommentStart(char a, char b) {
        return a == '/' && b == '/';
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        return a == '/' && b == '*';
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        return a == '*' && b == '/';
    }

    @Override
    public String[] getKeywords() {
        //noinspection SpellCheckingInspection
        return new String[]{

                "break", "case", "continue", "default", "do", "else", "for", "goto", "if", "_Pragma",
                "return", "switch", "while", "catch", "operator", "try", "throw", "using",
                "asm", "__asm__", "auto", "bool", "_Bool", "char", "_Complex", "double", "enum", "float",
                "_Imaginary", "int", "long", "short", "signed", "struct", "typedef", "union", "unsigned", "void",
                "class", "wchar_t", "template", "char16_t", "char32_t",
                "const", "extern", "register", "restrict", "static", "volatile", "inline", "private",
                "protected", "public", "friend", "explicit", "virtual", "export", "mutable", "typename",
                "constexpr", "new", "delete", "alignas", "alignof", "decltype", "noexcept", "thread_local",
                "and", "and_eq", "bitand", "bitor", "compl", "not", "not_eq", "or", "or_eq", "typeid", "xor", "xor_eq",
                "const_cast", "dynamic_cast", "reinterpret_cast", "static_cast", "sizeof", "namespace", "false", "true"
        };
    }

    @Override
    public boolean useTab() {
        return false;
    }

    @Override
    public int getOperatorAdvance(String operator) {
        switch (operator) {
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
        return operator.equals("{");
    }

    @Override
    public boolean isBlockEnd(String operator) {
        return operator.equals("}");
    }
}
