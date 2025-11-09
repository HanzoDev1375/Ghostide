package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;

public class JavaScriptDescription implements LanguageDescription {

    @Override
    public boolean isOperator(char[] characters, int length) {
        if (length == 1) {
            char c = characters[0];
            return (c == '+' || c == '-' || c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')'
                    || c == '|' || c == ':' || c == '.' || c == ',' || c == ';' || c == '*' || c == '/' || c == '&'
                    || c == '^' || c == '%' || c == '!' || c == '~' || c == '<' || c == '>' || c == '=');
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
        return new String[]{"abstract", "else", "instanceof", "prompt", "alert", "super", "boolean", "enum", "int",
                "switch", "break", "export", "interface", "synchronized", "byte", "extends", "let", "this", "case",
                "false", "long", "throw", "catch", "final", "native", "throws", "char", "finally", "new", "transient",
                "class", "float", "null", "true", "const", "for", "package", "try", "continue", "function", "private",
                "typeof", "debugger", "goto", "protected", "var", "default", "if", "public", "void", "delete",
                "implements", "return", "volatile", "do", "import", "short", "while", "double", "in", "static", "with",
                "of", "console", "log", "prototype", "alert", "support.function", "yield", "async", "document",
                "arguments", "parseInt", "await", "undefined", "parseFloat", "get", "storage.type", "infinity",
                "escape", "__count__", "__parent__", "__proto__", "window", "eval", "getElementById",
                "getElementByClass"
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
