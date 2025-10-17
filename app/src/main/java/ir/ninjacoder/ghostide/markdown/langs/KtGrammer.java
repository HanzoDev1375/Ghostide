package ir.ninjacoder.ghostide.markdown.langs;

import androidx.annotation.NonNull;
import io.noties.prism4j.Prism4j;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import static io.noties.prism4j.Prism4j.*;

public class KtGrammer {

  @NonNull
  public static Prism4j.Grammar create(@NonNull Prism4j prism4j) {
    return grammar(
        "kotlin",
        token("comment", pattern(compile("(//.*)|(/\\*[\\s\\S]*?\\*/)"), true)),
        token(
            "string",
            pattern(
                compile(
                    "(\"\"\"[\\s\\S]*?\"\"\")|(\")(?:\\\\.|[^\\\\\"\\r\\n])*?(\")|(')(?:\\\\.|[^\\\\'\\r\\n])*?(')"),
                true,
                true)),
        token(
            "keyword",
            pattern(
                compile(
                    "\\b(fun|val|var|class|object|interface|typealias|typeof|this|super|if|else|when|for|while|do|try|catch|finally|throw|return|continue|break|as|is|in|!in|!is|package|import|constructor|by|get|set|where|actual|abstract|annotation|companion|const|crossinline|data|enum|expect|external|final|infix|inline|inner|internal|lateinit|noinline|open|operator|out|override|private|protected|public|reified|sealed|suspend|tailrec|vararg)\\b"))),
        token("class-name", pattern(compile("\\b([A-Z][A-Za-z0-9_]*)\\b"))),
        token("boolean", pattern(compile("\\b(true|false)\\b"))),
        token(
            "number",
            pattern(
                compile(
                    "\\b0x[\\dA-Fa-f]+\\b|(?:\\b\\d+(?:\\.\\d*)?|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?[FL]?"))),
        token("function", pattern(compile("\\b\\w+(?=\\s*\\()"))),
        token("operator", pattern(compile("--|\\+\\+|&&|\\|\\||!!|::|[+\\-*/%&|^=!<>]=?|\\?|:"))),
        token("punctuation", pattern(compile("[{}\\[\\];(),.:]"))),
        token("null", pattern(compile("\\bnull\\b"))),
        token("annotation", pattern(compile("@\\w+"))));
  }
}
