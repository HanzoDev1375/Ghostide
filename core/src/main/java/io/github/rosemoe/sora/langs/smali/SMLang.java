package io.github.rosemoe.sora.langs.smali;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.widget.SymbolPairMatch;

public class SMLang implements EditorLanguage {
    public SMLang() {
    }

    @Override
    public CodeAnalyzer getAnalyzer() {
        return new SmAz();
    }

    @Override
    public AutoCompleteProvider getAutoCompleteProvider() {
        return new SmAuto();
    }

    @Override
    public boolean isAutoCompleteChar(char ch) {
        return MyCharacter.isJavaIdentifierPart(ch) || ch == '-' || ch == ',' || ch == '.' || getNumber(ch);
    }

    @Override
    public int getIndentAdvance(String content) {
        return 0;
    }

    @Override
    public boolean useTab() {
        return true;
    }

    @Override
    public CharSequence format(CharSequence text) {
        return text;
    }

    @Override
    public SymbolPairMatch getSymbolPairs() {
        return new SymbolPairMatch.DefaultSymbolPairs();
    }

    @Override
    public NewlineHandler[] getNewlineHandlers() {
        return new NewlineHandler[0];
    }

    boolean getNumber(char n) {
        return n == '1' || n == '2' || n == '3' || n == '4' || n == '5' || n == '6' || n == '7'
                || n == '8' || n == '9' || n == '0' || n == '/';
    }
}
