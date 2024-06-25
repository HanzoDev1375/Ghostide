package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;

/**
 * @author Rose
 */

public class JSONDescription implements LanguageDescription {

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
        return a == '*' && b == '/';
    }

    @Override
    public boolean isLongCommentStart(char a, char b) {
        return a == '*' && b == '/';
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        return a == '/' && b == '*';
    }

    @Override
    public String[] getKeywords() {
        //noinspection SpellCheckingInspection
        return new String[]{"true", "false", "null"};
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
            case "[":
                return 4;
            case "]":
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
        return operator.equals("{") || operator.equals("[");
    }

    @Override
    public boolean isBlockEnd(String operator) {
        return operator.equals("}") || operator.equals("]");
    }
}
