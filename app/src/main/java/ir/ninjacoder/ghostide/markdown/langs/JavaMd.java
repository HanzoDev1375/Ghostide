package ir.ninjacoder.ghostide.markdown.langs;

import androidx.annotation.NonNull;

import io.noties.prism4j.Prism4j;

import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static java.util.regex.Pattern.compile;
import static io.noties.prism4j.Prism4j.grammar;
import static io.noties.prism4j.Prism4j.pattern;
import static io.noties.prism4j.Prism4j.token;

public class JavaMd {

    @NonNull
    public static Prism4j.Grammar create(@NonNull Prism4j prism4j) {
        return grammar(
                "java",
                token("comment", pattern(
                        compile("(//.*)|(/\\*[\\s\\S]*?\\*/)"),
                        true
                )),
                token("string", pattern(
                        compile("(\")(?:\\\\.|[^\\\\\"\\r\\n])*?(\")|(')(?:\\\\.|[^\\\\'\\r\\n])*?(')"),
                        true,
                        true
                )),
                token("class-name", pattern(
                        compile("\\b([A-Z]\\w*)\\b")
                )),
                token("keyword", pattern(
                        compile("\\b(abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while)\\b")
                )),
                token("boolean", pattern(
                        compile("\\b(true|false)\\b")
                )),
                token("number", pattern(
                        compile("\\b0x[\\dA-Fa-f]+\\b|(?:\\b\\d+(?:\\.\\d*)?|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?[DdFfLl]?")
                )),
                token("operator", pattern(
                        compile("--|\\+\\+|&&|\\|\\||>>>?|<<|[-+*/%&|^=!<>]=?|\\?|:")
                )),
                token("punctuation", pattern(
                        compile("[{}\\[\\];(),.:]")
                )),
                token("annotation", pattern(
                        compile("@\\w+")
                )),
                token("function", pattern(
                        compile("\\b\\w+(?=\\s*\\()")
                ))
        );
    }
}