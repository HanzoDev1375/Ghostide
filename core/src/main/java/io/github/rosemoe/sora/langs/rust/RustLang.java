package io.github.rosemoe.sora.langs.rust;

import com.ninjacoder.jgit.childer.CharParser;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import ir.ninjacoder.ghostide.core.IdeEditor;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import org.antlr.v4.runtime.CharStreams;
import java.io.StringReader;
import org.antlr.v4.runtime.Token;

public class RustLang implements EditorLanguage {
    private IdeEditor editor;
    private RustAutoComplete autoComplete;
    public String[] keywords = {
            "as", "break", "const", "continue", "crate", "else", "enum", "extern",
            "false", "fn", "for", "if", "impl", "in", "let", "loop", "match",
            "mod", "move", "mut", "pub", "ref", "return", "self", "Self",
            "static", "struct", "super", "trait", "true", "type", "unsafe",
            "use", "where", "while", "async", "await", "dyn", "abstract",
            "become", "box", "do", "final", "macro", "override", "priv",
            "typeof", "unsized", "virtual", "yield", "try", "union",
            "macro_rules", "dyn", "impl", "where", "for", "loop"
    };

    public RustLang(IdeEditor editor) {
        this.editor = editor;
    }

    @Override
    public CharSequence format(CharSequence text) {
        return text;
    }

    @Override
    public CodeAnalyzer getAnalyzer() {
        return new RustCodeAnalyzer(editor);
    }

    @Override
    public AutoCompleteProvider getAutoCompleteProvider() {
        autoComplete = new RustAutoComplete(editor);
        autoComplete.setKeywords(keywords, "RustKeyword");
        return autoComplete;
    }

    @Override
    public int getIndentAdvance(String content) {
        try {
            RustLexer lexer = new RustLexer(CharStreams.fromReader(new StringReader(content)));
            int advance = 0;
            Token token;

            while (true) {
                token = lexer.nextToken();
                if (token.getType() == RustLexer.EOF) {
                    break;
                }
                switch (token.getType()) {
                    case RustLexer.LCURLYBRACE:
                        advance++;
                        break;
                    case RustLexer.RCURLYBRACE:
                        advance--;
                        break;
                }
            }
            advance = Math.max(0, advance);
            return advance * 2;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public NewlineHandler[] getNewlineHandlers() {
        return new NewlineHandler[]{
                new BraceHandler(),
                new TwoIndentHandler()
        };
    }

    @Override
    public SymbolPairMatch getSymbolPairs() {
        return new SymbolPairMatch.DefaultSymbolPairs();
    }

    @Override
    public boolean isAutoCompleteChar(char ch) {
        return CharParser.parserChar(ch);
    }

    @Override
    public boolean useTab() {
        return true;
    }

    class BraceHandler implements NewlineHandler {
        @Override
        public boolean matchesRequirement(String beforeText, String afterText) {
            return beforeText.endsWith("{") && afterText.startsWith("}");
        }

        @Override
        public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
            int count = io.github.rosemoe.sora.text.TextUtils.countLeadingSpaceCount(beforeText, tabSize);
            int advanceBefore = getIndentAdvance(beforeText);
            int advanceAfter = getIndentAdvance(afterText);
            StringBuilder sb = new StringBuilder("\n")
                    .append(io.github.rosemoe.sora.text.TextUtils.createIndent(count + advanceBefore, tabSize, useTab()))
                    .append('\n')
                    .append(io.github.rosemoe.sora.text.TextUtils.createIndent(count + advanceAfter, tabSize, useTab()));
            int shiftLeft = io.github.rosemoe.sora.text.TextUtils.createIndent(count + advanceAfter, tabSize, useTab()).length() + 1;
            return new HandleResult(sb, shiftLeft);
        }
    }

    class TwoIndentHandler implements NewlineHandler {
        @Override
        public boolean matchesRequirement(String beforeText, String afterText) {
            if (beforeText.replace("\r", "").trim().startsWith(".")) {
                return false;
            }
            return beforeText.endsWith("{") && !afterText.startsWith("}");
        }

        @Override
        public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
            int count = io.github.rosemoe.sora.text.TextUtils.countLeadingSpaceCount(beforeText, tabSize);
            int advanceAfter = getIndentAdvance(afterText) + (4 * 2);
            String text = io.github.rosemoe.sora.text.TextUtils.createIndent(count + advanceAfter, tabSize, useTab());
            StringBuilder sb = new StringBuilder().append('\n').append(text);
            return new HandleResult(sb, 0);
        }
    }
}