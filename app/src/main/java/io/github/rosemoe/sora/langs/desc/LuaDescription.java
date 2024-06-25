/*
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/CodeEditor
 *    Copyright (C) 2020-2021  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 * add by ninjacoder full keyword
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 */
package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;

/**
 * @author Rose
 */
public class LuaDescription implements LanguageDescription {

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
                "abs", "and", "asin", "acos", "assert", "break", "byte",
                "ceil", "char", "clock", "close", "collectgarbage",
                "date", "debug", "deg", "do", "difftime",
                "else", "elseif", "end", "error", "execute", "false",
                "find", "floor", "flush", "for", "foreach", "foreachi", "getenv", "gethook", "getfenv", "getinfo", "gcinfo", "__gc", "gmatch", "getlocal", "huge", "if",
                "in", "input", "insert", "io", "ldexp", "len",
                "__len", "lines", "load", "loaded", "import",
                "match", "math", "max", "maxn", "min", "newproxy",
                "next", "nil", "not", "_VERSION", "__div", "rad",
                "random", "randomseed", "rawequal",
                "rawget", "while", "wrap", "write", "lower", "__eq",
                "seeall", "select", "self", "setfenv", "sethook",
                "package", "pairs", "path", "pcall", "pi", "xpcall",
                "exit", "tan", "table", "tanh", "then", "time", "unpack", "until", "upper", "yield", "__tonumber", "__tostring", "print"

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
