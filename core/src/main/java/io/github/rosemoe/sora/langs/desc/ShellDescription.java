package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;

public class ShellDescription implements LanguageDescription {
    public boolean isLineCommentStart(char c, char c2) {
        return c == '#' && c2 == '#';
    }

    public boolean isLongCommentEnd(char c, char c2) {
        return c == '#' && c2 == '#';
    }

    public boolean isLongCommentStart(char c, char c2) {
        return c == '#' && c2 == '#';
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
        return new String[]{
                "alias", "bg", "break", "case", "cd", "chdir", "command", "continue", "dirs", "echo", "elif", "else", "esac", "eval", "exec", "exit", "export", "false", "fc", "fg", "for", "function", "getopts", "hash", "help", "history", "if", "jobs", "kill", "let", "local", "logout", "popd", "printf", "pushd", "pwd", "read", "readonly", "return", "set", "shift", "shopt", "source", "suspend", "test", "then", "time", "times", "trap", "true", "type", "typeset", "ulimit", "umask", "unalias", "unset", "until", "wait", "while"
        };
    }

    public int getOperatorAdvance(String str) {
        str.hashCode();
        if (!str.equals("{")) {
            return !str.equals("}") ? 0 : -4;
        }
        return 4;
    }

    public boolean isBlockStart(String str) {
        return str.equals("{");
    }

    public boolean isBlockEnd(String str) {
        return str.equals("}");
    }
}
///code by ninja coder
