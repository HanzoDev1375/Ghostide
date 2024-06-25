package io.github.rosemoe.sora.langs.groovy;

import android.graphics.Color;
import io.github.rosemoe.sora.data.Span;
import android.util.Log;
import io.github.rosemoe.sora.text.TextStyle;

import java.util.Stack;

import io.github.rosemoe.sora.data.BlockLine;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;

public class GroovyAnalyzer implements CodeAnalyzer {

    private int COMPLETE = 25;

    private int INCOMPLETE = 24;

    @Override
    public void analyze(
            CharSequence content,
            TextAnalyzeResult result,
            TextAnalyzer.AnalyzeThread.Delegate delegate) {
        try {
            CodePointCharStream stream =
                    CharStreams.fromReader(new StringReader(content.toString()));
            GroovyLexer lexer = new GroovyLexer(stream);

            Token token, preToken = null, prePreToken = null;
            boolean first = true;
            int lastLine = 1;
            int line, column;
            var prevIsTagName = false;
            Stack<BlockLine> stack = new Stack<>();
            while (delegate.shouldAnalyze()) {
                token = lexer.nextToken();
                if (token == null) break;
                if (token.getType() == GroovyLexer.EOF) {
                    lastLine = token.getLine() - 1;
                    break;
                }
                line = token.getLine() - 1;
                column = token.getCharPositionInLine();
                lastLine = line;

                switch (token.getType()) {
                    case GroovyLexer.WS:
                        if (first) result.addNormalIfNull();
                        break;
                    case GroovyLexer.ABSTRACT:
                    case GroovyLexer.ASSERT:
                    case GroovyLexer.BREAK:
                    case GroovyLexer.CASE:
                    case GroovyLexer.CATCH:
                    case GroovyLexer.CLASS:
                    case GroovyLexer.CONST:
                    case GroovyLexer.CONTINUE:
                    case GroovyLexer.DEFAULT:
                    case GroovyLexer.DO:
                    case GroovyLexer.ELSE:
                    case GroovyLexer.EXTENDS:
                    case GroovyLexer.FINAL:
                    case GroovyLexer.FINALLY:
                    case GroovyLexer.FOR:
                    case GroovyLexer.IF:
                    case GroovyLexer.GOTO:
                    case GroovyLexer.IMPLEMENTS:
                    case GroovyLexer.IMPORT:
                    case GroovyLexer.INSTANCEOF:
                    case GroovyLexer.INTERFACE:
                    case GroovyLexer.NATIVE:
                    case GroovyLexer.NEW:
                    case GroovyLexer.PACKAGE:
                    case GroovyLexer.PRIVATE:
                    case GroovyLexer.PROTECTED:
                    case GroovyLexer.PUBLIC:
                    case GroovyLexer.RETURN:
                    case GroovyLexer.STATIC:
                    case GroovyLexer.STRICTFP:
                    case GroovyLexer.SUPER:
                    case GroovyLexer.SWITCH:
                    case GroovyLexer.SYNCHRONIZED:
                    case GroovyLexer.THIS:
                        result.addIfNeeded(
                                line,
                                column,
                                TextStyle.makeStyle(
                                        EditorColorScheme.KEYWORD, 0, false, true, false));
                        prevIsTagName = false;
                        // set block line end position
                        if (!stack.isEmpty()) {
                            BlockLine block = stack.pop();
                            block.endLine = line;
                            block.endColumn = column;
                            if (block.startLine != block.endLine) {
                                if (preToken.getLine() == token.getLine())
                                    block.toBottomOfEndLine = true;
                                result.addBlockLine(block);
                            }
                        }
                        break;

                    case GroovyLexer.THROW:
                    case GroovyLexer.THROWS:
                    case GroovyLexer.TRANSIENT:
                    case GroovyLexer.TRY:
                    case GroovyLexer.VOID:
                    case GroovyLexer.VOLATILE:
                    case GroovyLexer.WHILE:
                    case GroovyLexer.DECIMAL_LITERAL:
                    case GroovyLexer.HEX_LITERAL:
                    case GroovyLexer.OCT_LITERAL:
                    case GroovyLexer.BINARY_LITERAL:
                    case GroovyLexer.FLOAT_LITERAL:
                    case GroovyLexer.HEX_FLOAT_LITERAL:
                    case GroovyLexer.BOOL_LITERAL:
                    case GroovyLexer.CHAR_LITERAL:
                    case GroovyLexer.NULL_LITERAL:

                        result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
                        // set block line end position
                        if (!stack.isEmpty()) {
                            BlockLine block = stack.pop();
                            block.endLine = line;
                            block.endColumn = column;
                            if (block.startLine != block.endLine) {
                                if (preToken.getLine() == token.getLine())
                                    block.toBottomOfEndLine = true;
                                result.addBlockLine(block);
                            }
                        }
                        prevIsTagName = false;
                        break;


                    case GroovyLexer.SINGLE_QUOTE_STRING:
                    case GroovyLexer.STRING_LITERAL:
                    case GroovyLexer.LPAREN:
                    case GroovyLexer.RPAREN:
                    case GroovyLexer.LBRACK:
                    case GroovyLexer.RBRACK:
                    case GroovyLexer.SEMI:
                    case GroovyLexer.COMMA:
                    case GroovyLexer.ASSIGN:
                    case GroovyLexer.GT:
                    case GroovyLexer.LT:
                    case GroovyLexer.BANG:
                    case GroovyLexer.TILDE:
                    case GroovyLexer.QUESTION:
                    case GroovyLexer.COLON:
                    case GroovyLexer.EQUAL:
                    case GroovyLexer.GE:
                    case GroovyLexer.LE:
                        if (prevIsTagName) {
                            result.addIfNeeded(
                                    line,
                                    column,
                                    TextStyle.makeStyle(
                                            EditorColorScheme.LITERAL, 0, false, true, false));
                        } else {
                            result.addIfNeeded(
                                    line,
                                    column,
                                    TextStyle.makeStyle(
                                            EditorColorScheme.HTML_TAG, 0, true, false, false));
                        }
                        prevIsTagName = true;

                        break;

                    case GroovyLexer.NOTEQUAL:
                    case GroovyLexer.AND:
                    case GroovyLexer.OR:
                    case GroovyLexer.INC:
                    case GroovyLexer.DEC:
                    case GroovyLexer.ADD:
                    case GroovyLexer.SUB:
                    case GroovyLexer.MUL:
                    case GroovyLexer.DIV:
                    case GroovyLexer.BITAND:
                    case GroovyLexer.BITOR:
                    case GroovyLexer.CARET:
                    case GroovyLexer.MOD:
                    case GroovyLexer.ADD_ASSIGN:
                    case GroovyLexer.SUB_ASSIGN:
                    case GroovyLexer.MUL_ASSIGN:
                    case GroovyLexer.DIV_ASSIGN:
                    case GroovyLexer.AND_ASSIGN:
                    case GroovyLexer.OR_ASSIGN:
                    case GroovyLexer.XOR_ASSIGN:
                    case GroovyLexer.MOD_ASSIGN:
                    case GroovyLexer.LSHIFT_ASSIGN:
                    case GroovyLexer.RSHIFT_ASSIGN:
                    case GroovyLexer.URSHIFT_ASSIGN:
                    case GroovyLexer.ARROW:
                    case GroovyLexer.COLONCOLON:
                    case GroovyLexer.ELLIPSIS:
                    case GroovyLexer.LBRACE:
                    case GroovyLexer.RBRACE:
                    case GroovyLexer.DOT:

                    case GroovyLexer.BOOLEAN:
                    case GroovyLexer.BYTE:
                    case GroovyLexer.CHAR:
                    case GroovyLexer.DOUBLE:
                        prevIsTagName = false;
                        break;
                    case GroovyLexer.ENUM:
                    case GroovyLexer.FLOAT:
                    case GroovyLexer.INT:
                    case GroovyLexer.LONG:
                        String text3 = token.getText();
                        if (text3.startsWith("\"#")) {
                            try {
                                int color =
                                        Color.parseColor(text3.substring(1, text3.length() - 1));
                                result.addIfNeeded(
                                        line,
                                        column,
                                        TextStyle.makeStyle(
                                                EditorColorScheme.LITERAL, 0, true, true, false));

                                Span span =
                                        Span.obtain(
                                                column + 1,
                                                TextStyle.makeStyle(
                                                        EditorColorScheme.TEXT_NORMAL,
                                                        color,
                                                        true,
                                                        false,
                                                        false));
                                // span.setUnderlineColor(color);
                                result.add(line, span);

                                Span middle =
                                        Span.obtain(
                                                column + text3.length() - 1,
                                                EditorColorScheme.LITERAL);
                                middle.setUnderlineColor(Color.TRANSPARENT);
                                result.add(line, middle);

                                Span end =
                                        Span.obtain(
                                                column + text3.length(),
                                                TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
                                end.setUnderlineColor(Color.TRANSPARENT);
                                result.add(line, end);
                                break;
                            } catch (Exception sumError) {
                                Log.i("ColorError", sumError.getMessage());
                            }
                        }
                        result.addIfNeeded(
                                line,
                                column,
                                TextStyle.makeStyle(
                                        EditorColorScheme.ATTRIBUTE_VALUE, 0, true, false, false));
                        prevIsTagName = true;

                        break;

                    case GroovyLexer.SHORT:
                    case GroovyLexer.COMMENT:
                    case GroovyLexer.LINE_COMMENT:
                    case GroovyLexer.AT:
                        result.addIfNeeded(
                                line,
                                column,
                                TextStyle.makeStyle(
                                        EditorColorScheme.AUTO_COMP_PANEL_CORNER,
                                        0,
                                        true,
                                        false,
                                        false));
                        prevIsTagName = false;
                        break;

                    default:
                        String text2 = token.getText();
                        if (text2.startsWith("#")) {
                            try {
                                int color =
                                        Color.parseColor(text2.substring(1, text2.length() - 1));
                                result.addIfNeeded(
                                        line,
                                        column,
                                        TextStyle.makeStyle(
                                                EditorColorScheme.LITERAL, 0, true, true, false));

                                Span span = Span.obtain(column + 1, EditorColorScheme.LITERAL);
                                span.setUnderlineColor(color);
                                result.add(line, span);

                                Span middle =
                                        Span.obtain(
                                                column + text2.length() - 1,
                                                EditorColorScheme.LITERAL);
                                middle.setUnderlineColor(Color.TRANSPARENT);
                                result.add(line, middle);

                                Span end =
                                        Span.obtain(
                                                column + text2.length(),
                                                TextStyle.makeStyle(EditorColorScheme.TEXT_NORMAL));
                                end.setUnderlineColor(Color.TRANSPARENT);
                                result.add(line, end);
                                break;
                            } catch (Exception sumError) {
                                Log.i("ColorError", sumError.getMessage());
                            }
                        }
                        result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
                        prevIsTagName = false;
                        break;
                }

                first = false;
            }
            result.determine(lastLine);

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("TAG", e.getMessage());
        }
    }
}