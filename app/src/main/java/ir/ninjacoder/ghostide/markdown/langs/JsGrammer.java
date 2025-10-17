package ir.ninjacoder.ghostide.markdown.langs;

import androidx.annotation.NonNull;
import io.noties.prism4j.Prism4j;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import static io.noties.prism4j.Prism4j.*;

public class JsGrammer {

  @NonNull
  public static Prism4j.Grammar create(@NonNull Prism4j prism4j) {
    return grammar(
        "javascript",
        token("comment", pattern(compile("(//.*)|(/\\*[\\s\\S]*?\\*/)"), true)),
        token(
            "string",
            pattern(
                compile(
                    "(`)(?:\\\\.|[^\\\\`])*?(`)|(\")(?:\\\\.|[^\\\\\"\\r\\n])*?(\")|(')(?:\\\\.|[^\\\\'\\r\\n])*?(')"),
                true,
                true)),
        token(
            "keyword",
            pattern(
                compile(
                    "\\b(var|let|const|function|return|if|else|for|while|do|switch|case|break|continue|default|try|catch|finally|throw|new|typeof|instanceof|void|delete|in|of|yield|await|async|export|import|from|as|class|extends|super|this|static|public|private|protected|implements|interface|package)\\b"))),
        token("class-name", pattern(compile("\\b([A-Z][A-Za-z0-9_]*)\\b"))),
        token("boolean", pattern(compile("\\b(true|false)\\b"))),
        token(
            "number",
            pattern(
                compile(
                    "\\b0x[\\dA-Fa-f]+\\b|(?:\\b\\d+(?:\\.\\d*)?|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))),
        token("function", pattern(compile("\\b\\w+(?=\\s*\\()"))),
        token("operator", pattern(compile("--|\\+\\+|&&|\\|\\||>>>?|<<|[-+*/%&|^=!<>]=?|\\?|:|~"))),
        token("punctuation", pattern(compile("[{}\\[\\];(),.:]"))),
        token("null", pattern(compile("\\b(null|undefined)\\b"))));
  }
}
