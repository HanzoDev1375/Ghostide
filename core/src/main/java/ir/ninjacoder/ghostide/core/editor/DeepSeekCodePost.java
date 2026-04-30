package ir.ninjacoder.ghostide.core.editor;

import io.github.rosemoe.sora.langs.Javacc.JavaccLang;
import io.github.rosemoe.sora.langs.antlrlang.ANTLRV4Lang;
import io.github.rosemoe.sora.langs.cpp.CppLanguage;
import io.github.rosemoe.sora.langs.csharp.CSharpLanguage;
import io.github.rosemoe.sora.langs.css3.CSS3Language;
import io.github.rosemoe.sora.langs.dart.DartLang;
import io.github.rosemoe.sora.langs.groovy.lang.GroovyLanguage;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLanguage;
import io.github.rosemoe.sora.langs.kotlin.KotlinLanguage;
import io.github.rosemoe.sora.langs.less.LessLang;
import io.github.rosemoe.sora.langs.markdown.MarkDownLang;
import io.github.rosemoe.sora.widget.CodeEditor;

public class DeepSeekCodePost {
  private CodeEditor editor;

  public DeepSeekCodePost(CodeEditor editor) {
    this.editor = editor;
  }

  String builderCodeEx() {
    StringBuilder builder = new StringBuilder();
    builder.append("```");
    if (editor.getEditorLanguage() instanceof JavaLanguage) {
      builder.append("java");
    } else if (editor.getEditorLanguage() instanceof KotlinLanguage) {
      builder.append("kt");
    } else if (editor.getEditorLanguage() instanceof LessLang) {
      builder.append("less");
    } else if (editor.getEditorLanguage() instanceof JavaScriptLanguage) {
      builder.append("js");
    } else if (editor.getEditorLanguage() instanceof CSS3Language) {
      builder.append("css");
    } else if (editor.getEditorLanguage() instanceof CppLanguage) {
      builder.append("cpp");
    } else if (editor.getEditorLanguage() instanceof DartLang) {
      builder.append("dart");
    } else if (editor.getEditorLanguage() instanceof CSharpLanguage) {
      builder.append("cs");
    } else if (editor.getEditorLanguage() instanceof ANTLRV4Lang) {
      builder.append("g4");
    } else if (editor.getEditorLanguage() instanceof JavaccLang) {
      builder.append("jj");
    } else if (editor.getEditorLanguage() instanceof GroovyLanguage) {
      builder.append("gradle");
    } else if (editor.getEditorLanguage() instanceof HTMLLanguage) {
      builder.append("html");
    } else if (editor.getEditorLanguage() instanceof MarkDownLang) {
      builder.append("md");
    }
    // soon add all lang...

    return builder.toString();
  }

  public String putCode() {
    return builderCodeEx() + '\n' + editor.getSelectedText() + "\n ```";
  }
}
