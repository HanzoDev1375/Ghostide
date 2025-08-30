package io.github.rosemoe.sora.langs.java;

import com.github.javaparser.ParserConfiguration;
import com.ninjacoder.jgit.childer.CharParser;
import ir.ninjacoder.ghostide.IdeEditor;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.printer.configuration.DefaultPrinterConfiguration;
import com.github.javaparser.printer.DefaultPrettyPrinter;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.text.TextUtils;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.lang.ref.WeakReference;

public class JavaLanguage implements EditorLanguage {
  private final WeakReference<IdeEditor> mEditorReference;

  public JavaLanguage(IdeEditor editor) {
    mEditorReference = new WeakReference<>(editor);
    editor = mEditorReference.get();
    if (editor == null) {
      return;
    }
  }

  private final NewlineHandler[] newLineHandlers =
      new NewlineHandler[] {
        new BraceHandler(), new TwoIndentHandler(), new JavaDocStartHandler(), new JavaDocHandler()
      };

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new JavaCodeAnalyzer(mEditorReference.get());
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    JavaAutoComplete auto = new JavaAutoComplete(mEditorReference.get());
    auto.setMd(true);

    try {
      String[] combinedArray =
          new String[keywords.length + ObjectUtils.getClassNameObject().length];
      System.arraycopy(keywords, 0, combinedArray, 0, keywords.length);
      System.arraycopy(
          ObjectUtils.getClassNameObject(),
          0,
          combinedArray,
          keywords.length,
          ObjectUtils.getClassNameObject().length);
      boolean isJavaKeyword = keywords.length > 0;
      // auto.setKeywords(combinedArray, isJavaKeyword ? "JavaKeyWords" : "JavaClass");
      auto.setKeywords(keywords);
    } catch (Exception err) {

    }
    return auto;
  }

  @Override
  public boolean isAutoCompleteChar(char ch) {
    return CharParser.parserChar(ch);
  }

  @Override
  public int getIndentAdvance(String content) {
    JavaTextTokenizer t = new JavaTextTokenizer(content);
    Tokens token;
    int advance = 0;
    while ((token = t.directNextToken()) != Tokens.EOF) {
      switch (token) {
        case LBRACE:
          advance++;
          break;
          /*case RBRACE:
          advance--;
          break;*/
      }
    }
    advance = Math.max(0, advance);
    return advance * 4;
  }

  @Override
  public boolean useTab() {
    return true;
  }

  @Override
  public SymbolPairMatch getSymbolPairs() {
    return new SymbolPairMatch.DefaultSymbolPairs();
  }

  @Override
  public CharSequence format(CharSequence text) {
    return JavaCodeFormat.format(text.toString());
  }

  @Override
  public NewlineHandler[] getNewlineHandlers() {
    return newLineHandlers;
  }

  class BraceHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.endsWith("{") && afterText.startsWith("}");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceBefore = getIndentAdvance(beforeText);
      int advanceAfter = getIndentAdvance(afterText);
      String text;
      StringBuilder sb =
          new StringBuilder("\n")
              .append(TextUtils.createIndent(count + advanceBefore, tabSize, useTab()))
              .append('\n')
              .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()));
      int shiftLeft = text.length() + 1;
      return new HandleResult(sb, shiftLeft);
    }
  }

  class JavaDocStartHandler implements NewlineHandler {

    private boolean shouldCreateEnd = true;

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.trim().startsWith("/**");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceAfter = getIndentAdvance(afterText);
      String text = "";
      StringBuilder sb =
          new StringBuilder()
              .append("\n")
              .append(TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
              .append(" * ");
      if (shouldCreateEnd) {
        sb.append("\n")
            .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
            .append(" */");
      }
      return new HandleResult(sb, text.length() + 4);
    }
  }

  class JavaDocHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.trim().startsWith("*") && !beforeText.trim().startsWith("*/");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceAfter = getIndentAdvance(afterText);
      StringBuilder sb =
          new StringBuilder()
              .append("\n")
              .append(TextUtils.createIndent(count + advanceAfter, tabSize, useTab()))
              .append("* ");
      return new HandleResult(sb, 0);
    }
  }

  class TwoIndentHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      //  Log.d("BeforeText", beforeText);
      if (beforeText.replace("\r", "").trim().startsWith(".")) {
        return false;
      }
      return beforeText.endsWith(")") && !afterText.startsWith(";");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceAfter = getIndentAdvance(afterText) + (4 * 2);
      String text;
      StringBuilder sb =
          new StringBuilder()
              .append('\n')
              .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()));
      int shiftLeft = 0;
      return new HandleResult(sb, shiftLeft);
    }
  }

  public class JavaCodeFormat {
    /** lib implementation 'com.github.javaparser:javaparser-core:3.25.10' */
    public static String format(String code) {
      try {
        CompilationUnit cu = StaticJavaParser.parse(code);
        StaticJavaParser.getConfiguration().setLanguageLevel(ParserConfiguration.LanguageLevel.BLEEDING_EDGE);
        DefaultPrinterConfiguration configuration = new DefaultPrinterConfiguration();
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(configuration);
        String formattedCode = printer.print(cu);
        System.out.println(formattedCode);
        return formattedCode;
      } catch (Throwable t) {
        System.err.println("An error occurred during code formatting: " + t.getMessage());
        return code; // Return the original code if an error occurs
      }
    }
  }

  public static String[] keywords = {
    "assert",
    "abstract",
    "boolean",
    "byte",
    "char",
    "class",
    "do",
    "double",
    "final",
    "float",
    "for",
    "if",
    "int",
    "long",
    "new",
    "public",
    "private",
    "protected",
    "package",
    "return",
    "static",
    "short",
    "super",
    "switch",
    "else",
    "volatile",
    "synchronized",
    "strictfp",
    "goto",
    "continue",
    "break",
    "transient",
    "void",
    "try",
    "catch",
    "finally",
    "while",
    "case",
    "default",
    "const",
    "enum",
    "extends",
    "implements",
    "import",
    "instanceof",
    "interface",
    "native",
    "this",
    "throw",
    "throws",
    "true",
    "false",
    "null",
    "var",
    "system",
    "out",
    "println",
    "format",
    "permits",
    "sealed"
  };
}
