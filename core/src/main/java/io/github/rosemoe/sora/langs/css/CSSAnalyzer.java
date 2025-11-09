package io.github.rosemoe.sora.langs.css;

import android.graphics.Color;
import android.util.Log;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class CSSAnalyzer implements CodeAnalyzer {

    @Override
    public void analyze(CharSequence content, TextAnalyzeResult result, TextAnalyzer.AnalyzeThread.Delegate delegate) {
        try {

            CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
            CSSLexer lexer = new CSSLexer(stream);

            Token token;
            boolean first = true;
            int lastLine = 1;
            int line, column;

            while (delegate.shouldAnalyze()) {
                token = lexer.nextToken();
                if (token == null)
                    break;
                if (token.getType() == CSSLexer.EOF) {
                    lastLine = token.getLine() - 1;
                    break;
                }
                line = token.getLine() - 1;
                column = token.getCharPositionInLine();
                lastLine = line;

                switch (token.getType()) {
                    case CSSLexer.TAG_WHITESPACE:
                        if (first)
                            result.addNormalIfNull();
                        break;
                    case CSSLexer.TAG_OPEN:

                        result.addIfNeeded(line, column, EditorColorScheme.BLOCK_LINE);
                        try {
                            result.markProblemRegion(Span.FLAG_ERROR, line, column, lastLine, 0);
                        } catch (Exception r) {
                            Log.i("error", r.getMessage());
                        }
                        break;
                    case CSSLexer.TAG_SLASH:
                    case CSSLexer.TAG_SLASH_CLOSE:
                    case CSSLexer.TAG_CLOSE:
                        result.addIfNeeded(line, column, EditorColorScheme.BLOCK_LINE);
                        break;
                    case CSSLexer.TAG_EQUALS:
                        result.addIfNeeded(line, column, EditorColorScheme.OPERATOR);
                        break;
                    case CSSLexer.TAG_NAME:
                    case CSSLexer.XML:
                        int a = EditorColorScheme.BLOCK_LINE;
                        int d = (int) TextStyle.makeStyle(a, a, true, false, false);
                        result.addIfNeeded(line, column, EditorColorScheme.HTML_TAG);
                        break;
                    case CSSLexer.CDATA:
                    case CSSLexer.ATTRIBUTE:
                        int c = EditorColorScheme.ATTRIBUTE_NAME;
                        int df = (int) TextStyle.makeStyle(c, c, false, true, false);
                        result.addIfNeeded(line, column, df);
                        break;
                    case CSSLexer.ATTVALUE_VALUE:
                        result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
                        break;
                    case CSSLexer.HTML_CONDITIONAL_COMMENT:
                    case CSSLexer.HTML_COMMENT:
                        int ff = EditorColorScheme.COMMENT;
                        int bd = (int) TextStyle.makeStyle(ff, ff, false, true, true);
                        result.addIfNeeded(line, column, bd);
                        break;
                    case CSSLexer.HTML_TEXT:
                        final String text = token.getText().toString();
                        if (text.contains("#")) {
                            try {
                                int color = Color.parseColor(text.substring(1, text.length() - 1));
                                result.addIfNeeded(line, column, EditorColorScheme.LITERAL);
                                Span span = Span.obtain(column + 1, EditorColorScheme.LITERAL);
                                span.setUnderlineColor(color);
                                result.add(line, span);

                            } catch (Exception ignore) {
                            }
                        }

                        break;
                    default:
                        result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
                        break;
                }

                first = false;
            }
            result.determine(lastLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
