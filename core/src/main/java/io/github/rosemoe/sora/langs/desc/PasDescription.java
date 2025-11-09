package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;


public class PasDescription implements LanguageDescription {

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
        return a == '/' && b == '#';
    }

    @Override
    public boolean isLongCommentEnd(char a, char b) {
        return a == '#' && b == '/';
    }

    @Override
    public String[] getKeywords() {
        //noinspection SpellCheckingInspection
        return new String[]{"absolute", "abstract", "all", "and", "and_then", "array", "as", "asm", "attribute", "begin", "bindable", "case", "class",
                "const", "constructor", "destructor", "div", "do", "do", "else", "end", "except", "export", "exports", "external", "far", "file", "finalization",
                "finally", "for", "forward", "goto", "if", "implementation", "import", "in", "inherited", "initialization", "interface", "interrupt", "is",
                "label", "library", "mod", "module", "name", "near", "nil", "not", "object", "of", "only", "operator", "or", "or_else", "otherwise", "packed", "pow", "private",
                "program", "property", "protected", "public", "published", "qualified", "record", "repeat", "resident", "restricted", "segment", "set", "shl", "shr",
                "then", "to", "try", "type", "unit", "until", "uses", "value", "var", "view", "virtual", "while", "with", "xor", "identifier"
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
