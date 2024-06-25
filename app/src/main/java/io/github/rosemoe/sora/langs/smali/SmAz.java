package io.github.rosemoe.sora.langs.smali;

import io.github.rosemoe.sora.data.BlockLine;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import org.antlr.runtime.Token;

import java.io.StringReader;

import org.jf.smali.smaliFlexLexer;
import org.jf.smali.smaliParser;

public class SmAz implements CodeAnalyzer {

    @Override
    public void analyze(
            CharSequence content,
            TextAnalyzeResult colors,
            TextAnalyzer.AnalyzeThread.Delegate delegate) {
        StringBuilder text = new StringBuilder(content);

        // For completion TODO

        // For drawing lines between '.method' and '.end method' directives
        BlockLine lastBlockline = null;

        // Set the apiLevel to 31 so that
        // most recent dex opcodes are also supported.
        smaliFlexLexer lexer = new smaliFlexLexer(new StringReader(text.toString()), 31);
        lexer.setSuppressErrors(false);

        Token token;
        int lastLine = 1;

        while (delegate.shouldAnalyze()) {
            token = lexer.nextToken();

            if (token == null || token.getType() == smaliParser.EOF) break;
            if (token.getType() == smaliParser.WHITE_SPACE) continue;

            int line = token.getLine() - 1;
            lastLine = line;
            int column = token.getCharPositionInLine();

            switch (token.getType()) {
                case smaliParser.METHOD_DIRECTIVE:
                case smaliParser.CLASS_DIRECTIVE:
                case smaliParser.SUPER_DIRECTIVE:
                case smaliParser.SOURCE_DIRECTIVE:
                case smaliParser.IMPLEMENTS_DIRECTIVE:
                case smaliParser.FIELD_DIRECTIVE:
                case smaliParser.END_FIELD_DIRECTIVE:
                case smaliParser.END_METHOD_DIRECTIVE:
                case smaliParser.CATCH_DIRECTIVE:
                case smaliParser.LOCAL_DIRECTIVE:
                case smaliParser.LINE_DIRECTIVE:
                case smaliParser.RESTART_LOCAL_DIRECTIVE:
                case smaliParser.END_LOCAL_DIRECTIVE:
                case smaliParser.SUBANNOTATION_DIRECTIVE:
                case smaliParser.END_SUBANNOTATION_DIRECTIVE:
                case smaliParser.ARRAY_DATA_DIRECTIVE:
                    colors.addIfNeeded(
                            line,
                            column,
                            TextStyle.makeStyle(
                                    EditorColorScheme.ATTRIBUTE_NAME, 0, true, false, false));

                    break;

                case smaliParser.ANNOTATION_VISIBILITY:
                case smaliParser.ACCESS_SPEC:
                    colors.addIfNeeded(
                            line,
                            column,
                            TextStyle.makeStyle(
                                    EditorColorScheme.ATTRIBUTE_VALUE, 0, true, false, false));
                    break;

                case smaliParser.CLASS_DESCRIPTOR:
                case smaliParser.ARRAY_TYPE_PREFIX:
                case smaliParser.PRIMITIVE_TYPE:
                case smaliParser.PARAM_LIST_OR_ID_PRIMITIVE_TYPE:
                case smaliParser.VOID_TYPE:
                    colors.addIfNeeded(
                            line,
                            column,
                            TextStyle.makeStyle(EditorColorScheme.KEYWORD, 0, true, false, false));

                    break;

                case smaliParser.POSITIVE_INTEGER_LITERAL:
                case smaliParser.NEGATIVE_INTEGER_LITERAL:
                case smaliParser.INTEGER_LITERAL:
                    colors.addIfNeeded(
                            line,
                            column,
                            TextStyle.makeStyle(EditorColorScheme.LITERAL, 0, true, false, false));
                    break;

                case smaliParser.REGISTER:
                    colors.addIfNeeded(
                            line,
                            column,
                            TextStyle.makeStyle(EditorColorScheme.HTML_TAG, 0, true, false, false));
                    break;

                case smaliParser.ARROW:
                case smaliParser.MEMBER_NAME:
                case smaliParser.SIMPLE_NAME:
                    colors.addIfNeeded(
                            line,
                            column,
                            TextStyle.makeStyle(
                                    EditorColorScheme.BLOCK_LINE_CURRENT, 0, true, false, false));
                    break;

                case smaliParser.STRING_LITERAL:
                    colors.addIfNeeded(
                            line,
                            column,
                            TextStyle.makeStyle(
                                    EditorColorScheme.BLOCK_LINE, 0, true, false, false));
                    break;

                case smaliParser.LINE_COMMENT:
                    colors.addIfNeeded(
                            line,
                            column,
                            TextStyle.makeStyle(EditorColorScheme.COMMENT, 0, true, false, false));
                    break;

                default:
                    colors.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
                    break;
            }
        }

        colors.determine(lastLine);
    }
}
