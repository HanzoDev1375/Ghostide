package io.github.rosemoe.sora.langs.glsllang;

import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.Token;

public class GLSLCodeAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {
    try {
      int line, lastline = 1, type = -1, column;
      int previous = -1;
      boolean first = true;
      CodePointCharStream stream = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new GLSLLexer(stream);
      Token token = null;

      while (delegate.shouldAnalyze()) {
        if (token == null) break;
        
        token = lexer.nextToken();
        if (type == GLSLLexer.EOF) {
          lastline = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        if (type == GLSLLexer.EOF) {
          lastline = line;
          break;
        }
        switch (type) {
          case GLSLLexer.WHITE_SPACE:
            if (first) result.addNormalIfNull();
            break;
          case GLSLLexer.ATOMIC_UINT:
          case GLSLLexer.ATTRIBUTE:
          case GLSLLexer.BOOL:
          case GLSLLexer.BREAK:
          case GLSLLexer.BUFFER:
          case GLSLLexer.BVEC2:
          case GLSLLexer.BVEC3:
          case GLSLLexer.BVEC4:
          case GLSLLexer.CASE:
          case GLSLLexer.CENTROID:
          case GLSLLexer.COHERENT:
          case GLSLLexer.CONST:
          case GLSLLexer.CONTINUE:
          case GLSLLexer.DEFAULT:
          case GLSLLexer.DISCARD:
          case GLSLLexer.DMAT2:
          case GLSLLexer.DMAT2X2:
          case GLSLLexer.DMAT2X3:
          case GLSLLexer.DMAT2X4:
          case GLSLLexer.DMAT3:
          case GLSLLexer.DMAT3X2:
          case GLSLLexer.DMAT3X3:
          case GLSLLexer.DMAT3X4:
          case GLSLLexer.DMAT4:
          case GLSLLexer.DMAT4X2:
          case GLSLLexer.DMAT4X3:
          case GLSLLexer.DMAT4X4:
          case GLSLLexer.DO:
          case GLSLLexer.DOUBLE:
          case GLSLLexer.DVEC2:
          case GLSLLexer.DVEC3:
          case GLSLLexer.DVEC4:
          case GLSLLexer.ELSE:
          case GLSLLexer.FALSE:
          case GLSLLexer.FLAT:
          case GLSLLexer.FLOAT:
          case GLSLLexer.FOR:
          case GLSLLexer.HIGHP:
          case GLSLLexer.IF:
          case GLSLLexer.IIMAGE1D:
          case GLSLLexer.IIMAGE1DARRAY:
          case GLSLLexer.IIMAGE2D:
          case GLSLLexer.IIMAGE2DARRAY:
          case GLSLLexer.IIMAGE2DMS:
          case GLSLLexer.IIMAGE2DMSARRAY:
          case GLSLLexer.IIMAGE2DRECT:
          case GLSLLexer.IIMAGE3D:
          case GLSLLexer.IIMAGEBUFFER:
          case GLSLLexer.IIMAGECUBE:
          case GLSLLexer.IIMAGECUBEARRAY:
          case GLSLLexer.IMAGE1D:
          case GLSLLexer.IMAGE1DARRAY:
          case GLSLLexer.IMAGE2D:
          case GLSLLexer.IMAGE2DARRAY:
          case GLSLLexer.IMAGE2DMS:
          case GLSLLexer.IMAGE2DMSARRAY:
          case GLSLLexer.IMAGE2DRECT:
          case GLSLLexer.IMAGE3D:
          case GLSLLexer.IMAGEBUFFER:
          case GLSLLexer.IMAGECUBE:
          case GLSLLexer.IMAGECUBEARRAY:
          case GLSLLexer.IN:
          case GLSLLexer.INOUT:
          case GLSLLexer.INT:
          case GLSLLexer.INVARIANT:
          case GLSLLexer.ISAMPLER1D:
          case GLSLLexer.ISAMPLER1DARRAY:
          case GLSLLexer.ISAMPLER2D:
          case GLSLLexer.ISAMPLER2DARRAY:
          case GLSLLexer.ISAMPLER2DMS:
          case GLSLLexer.ISAMPLER2DMSARRAY:
          case GLSLLexer.ISAMPLER2DRECT:
          case GLSLLexer.ISAMPLER3D:
          case GLSLLexer.ISAMPLERBUFFER:
          case GLSLLexer.ISAMPLERCUBE:
          case GLSLLexer.ISAMPLERCUBEARRAY:
          case GLSLLexer.ISUBPASSINPUT:
          case GLSLLexer.ISUBPASSINPUTMS:
          case GLSLLexer.ITEXTURE1D:
          case GLSLLexer.ITEXTURE1DARRAY:
          case GLSLLexer.ITEXTURE2D:
          case GLSLLexer.ITEXTURE2DARRAY:
          case GLSLLexer.ITEXTURE2DMS:
          case GLSLLexer.ITEXTURE2DMSARRAY:
          case GLSLLexer.ITEXTURE2DRECT:
          case GLSLLexer.ITEXTURE3D:
          case GLSLLexer.ITEXTUREBUFFER:
          case GLSLLexer.ITEXTURECUBE:
          case GLSLLexer.ITEXTURECUBEARRAY:
          case GLSLLexer.IVEC2:
          case GLSLLexer.IVEC3:
          case GLSLLexer.IVEC4:
          case GLSLLexer.LAYOUT:
          case GLSLLexer.LOWP:
          case GLSLLexer.MAT2:
          case GLSLLexer.MAT2X2:
          case GLSLLexer.MAT2X3:
          case GLSLLexer.MAT2X4:
          case GLSLLexer.MAT3:
          case GLSLLexer.MAT3X2:
          case GLSLLexer.MAT3X3:
          case GLSLLexer.MAT3X4:
          case GLSLLexer.MAT4:
          case GLSLLexer.MAT4X2:
          case GLSLLexer.MAT4X3:
          case GLSLLexer.MAT4X4:
          case GLSLLexer.MEDIUMP:
          case GLSLLexer.NOPERSPECTIVE:
          case GLSLLexer.OUT:
          case GLSLLexer.PATCH:
          case GLSLLexer.PRECISE:
          case GLSLLexer.PRECISION:
          case GLSLLexer.READONLY:
          case GLSLLexer.RESTRICT:
          case GLSLLexer.RETURN:
          case GLSLLexer.SAMPLE:
          case GLSLLexer.SAMPLER:
          case GLSLLexer.SAMPLER1D:
          case GLSLLexer.SAMPLER1DARRAY:
          case GLSLLexer.SAMPLER1DARRAYSHADOW:
          case GLSLLexer.SAMPLER1DSHADOW:
          case GLSLLexer.SAMPLER2D:
          case GLSLLexer.SAMPLER2DARRAY:
          case GLSLLexer.SAMPLER2DARRAYSHADOW:
          case GLSLLexer.SAMPLER2DMS:
          case GLSLLexer.SAMPLER2DMSARRAY:
          case GLSLLexer.SAMPLER2DRECT:
          case GLSLLexer.SAMPLER2DRECTSHADOW:
          case GLSLLexer.SAMPLER2DSHADOW:
          case GLSLLexer.SAMPLER3D:
          case GLSLLexer.SAMPLERBUFFER:
          case GLSLLexer.SAMPLERCUBE:
          case GLSLLexer.SAMPLERCUBEARRAY:
          case GLSLLexer.SAMPLERCUBEARRAYSHADOW:
          case GLSLLexer.SAMPLERCUBESHADOW:
          case GLSLLexer.SAMPLERSHADOW:
          case GLSLLexer.SHARED:
          case GLSLLexer.SMOOTH:
          case GLSLLexer.STRUCT:
          case GLSLLexer.SUBPASSINPUT:
          case GLSLLexer.SUBPASSINPUTMS:
          case GLSLLexer.SUBROUTINE:
          case GLSLLexer.SWITCH:
          case GLSLLexer.TEXTURE1D:
          case GLSLLexer.TEXTURE1DARRAY:
          case GLSLLexer.TEXTURE2D:
          case GLSLLexer.TEXTURE2DARRAY:
          case GLSLLexer.TEXTURE2DMS:
          case GLSLLexer.TEXTURE2DMSARRAY:
          case GLSLLexer.TEXTURE2DRECT:
          case GLSLLexer.TEXTURE3D:
          case GLSLLexer.TEXTUREBUFFER:
          case GLSLLexer.TEXTURECUBE:
          case GLSLLexer.TEXTURECUBEARRAY:
          case GLSLLexer.TRUE:
          case GLSLLexer.UIMAGE1D:
          case GLSLLexer.UIMAGE1DARRAY:
          case GLSLLexer.UIMAGE2D:
          case GLSLLexer.UIMAGE2DARRAY:
          case GLSLLexer.UIMAGE2DMS:
          case GLSLLexer.UIMAGE2DMSARRAY:
          case GLSLLexer.UIMAGE2DRECT:
          case GLSLLexer.UIMAGE3D:
          case GLSLLexer.UIMAGEBUFFER:
          case GLSLLexer.UIMAGECUBE:
          case GLSLLexer.UIMAGECUBEARRAY:
          case GLSLLexer.UINT:
          case GLSLLexer.UNIFORM:
          case GLSLLexer.USAMPLER1D:
          case GLSLLexer.USAMPLER1DARRAY:
          case GLSLLexer.USAMPLER2D:
          case GLSLLexer.USAMPLER2DARRAY:
          case GLSLLexer.USAMPLER2DMS:
          case GLSLLexer.USAMPLER2DMSARRAY:
          case GLSLLexer.USAMPLER2DRECT:
          case GLSLLexer.USAMPLER3D:
          case GLSLLexer.USAMPLERBUFFER:
          case GLSLLexer.USAMPLERCUBE:
          case GLSLLexer.USAMPLERCUBEARRAY:
          case GLSLLexer.USUBPASSINPUT:
          case GLSLLexer.USUBPASSINPUTMS:
          case GLSLLexer.UTEXTURE1D:
          case GLSLLexer.UTEXTURE1DARRAY:
          case GLSLLexer.UTEXTURE2D:
          case GLSLLexer.UTEXTURE2DARRAY:
          case GLSLLexer.UTEXTURE2DMS:
          case GLSLLexer.UTEXTURE2DMSARRAY:
          case GLSLLexer.UTEXTURE2DRECT:
          case GLSLLexer.UTEXTURE3D:
          case GLSLLexer.UTEXTUREBUFFER:
          case GLSLLexer.UTEXTURECUBE:
          case GLSLLexer.UTEXTURECUBEARRAY:
          case GLSLLexer.UVEC2:
          case GLSLLexer.UVEC3:
          case GLSLLexer.UVEC4:
          case GLSLLexer.VARYING:
          case GLSLLexer.VEC2:
          case GLSLLexer.VEC3:
          case GLSLLexer.VEC4:
          case GLSLLexer.VOID:
          case GLSLLexer.VOLATILE:
          case GLSLLexer.WHILE:
          case GLSLLexer.WRITEONLY:
            result.addIfNeeded(line, column, EditorColorScheme.KEYWORD);
            break;
          case GLSLLexer.ADD_ASSIGN:
          case GLSLLexer.AMPERSAND:
          case GLSLLexer.AND_ASSIGN:
          case GLSLLexer.AND_OP:
          case GLSLLexer.BANG:
          case GLSLLexer.CARET:
          case GLSLLexer.COLON:
          case GLSLLexer.COMMA:
          case GLSLLexer.DASH:
          case GLSLLexer.DEC_OP:
          case GLSLLexer.DIV_ASSIGN:
          case GLSLLexer.DOT:
          case GLSLLexer.EQ_OP:
          case GLSLLexer.EQUAL:
          case GLSLLexer.GE_OP:
          case GLSLLexer.INC_OP:
          case GLSLLexer.LE_OP:
          case GLSLLexer.LEFT_ANGLE:
          case GLSLLexer.LEFT_ASSIGN:
          case GLSLLexer.LEFT_BRACE:
          case GLSLLexer.LEFT_BRACKET:
          case GLSLLexer.LEFT_OP:
          case GLSLLexer.LEFT_PAREN:
          case GLSLLexer.MOD_ASSIGN:
          case GLSLLexer.MUL_ASSIGN:
          case GLSLLexer.NE_OP:
          case GLSLLexer.NUMBER_SIGN:
          case GLSLLexer.OR_ASSIGN:
          case GLSLLexer.OR_OP:
          case GLSLLexer.PERCENT:
          case GLSLLexer.PLUS:
          case GLSLLexer.QUESTION:
          case GLSLLexer.RIGHT_ANGLE:
          case GLSLLexer.RIGHT_ASSIGN:
          case GLSLLexer.RIGHT_BRACE:
          case GLSLLexer.RIGHT_BRACKET:
          case GLSLLexer.RIGHT_OP:
          case GLSLLexer.RIGHT_PAREN:
          case GLSLLexer.SEMICOLON:
          case GLSLLexer.SLASH:
          case GLSLLexer.STAR:
          case GLSLLexer.SUB_ASSIGN:
          case GLSLLexer.TILDE:
          case GLSLLexer.VERTICAL_BAR:
          case GLSLLexer.XOR_ASSIGN:
          case GLSLLexer.XOR_OP:
            result.addIfNeeded(line, column, EditorColorScheme.ATTRIBUTE_VALUE);
            break;
          case GLSLLexer.BLOCK_COMMENT:
            result.addIfNeeded(line, column, EditorColorScheme.COMMENT);
            break;
          case GLSLLexer.IDENTIFIER:
            {
              int colorid = EditorColorScheme.TEXT_NORMAL;
              if (previous == GLSLLexer.DOT) {
                colorid = EditorColorScheme.HTML_TAG;
              }

              result.addIfNeeded(line, column, colorid);
              break;
            }
          default:
            result.addIfNeeded(line, column, EditorColorScheme.TEXT_NORMAL);
            break;
        }
        if (type != GLSLLexer.WHITE_SPACE) {
          previous = type;
        }
        first = false;
      }
      result.determine(lastline);
    } catch (Exception err) {

    }
  }
}
