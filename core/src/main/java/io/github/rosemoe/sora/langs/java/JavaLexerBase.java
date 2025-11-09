package io.github.rosemoe.sora.langs.java;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

public abstract class JavaLexerBase extends Lexer {
    public static String user = "";

    public JavaLexerBase(CharStream input) {
        super(input);
    }

    public boolean Check1() {
        return Character.isJavaIdentifierStart(_input.LA(-1));
    }

    public boolean Check2() {
        return Character.isJavaIdentifierStart(
                Character.toCodePoint((char) _input.LA(-2), (char) _input.LA(-1)));
    }

    public boolean Check3() {
        return Character.isJavaIdentifierPart(_input.LA(-1));
    }

    public boolean Check4() {
        return Character.isJavaIdentifierPart(
                Character.toCodePoint((char) _input.LA(-2), (char) _input.LA(-1)));
    }
}
