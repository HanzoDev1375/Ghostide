package io.github.rosemoe.sora.langs.typescript;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

import java.util.ArrayList;
import java.util.List;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;

public class TsAuto implements AutoCompleteProvider {
    public static String[] lists = {
            "abstract",
            "any",
            "array",
            "as",
            "async",
            "await",
            "break",
            "case",
            "catch",
            "class",
            "const",
            "constructor",
            "continue",
            "declare",
            "default",
            "delete",
            "do",
            "while",
            "else",
            "enum",
            "export",
            "extends",
            "false",
            "finally",
            "for",
            "of",
            "from",
            "function",
            "if",
            "else",
            "implements",
            "import",
            "in",
            "instanceof",
            "interface",
            "keyof",
            "let",
            "module",
            "namespace",
            "never",
            "null",
            "number",
            "object",
            "of",
            "private",
            "protected",
            "public",
            "readonly",
            "require",
            "return",
            "set",
            "static",
            "string",
            "super",
            "switch",
            "symbol",
            "template",
            "this",
            "throw",
            "true",
            "try",
            "catch",
            "tuple",
            "typeof",
            "undefined",
            "unique symbol",
            "unknown",
            "var",
            "void",
            "while",
            "with"
    };
    protected List<CompletionItem> list;

    @Override
    public List<CompletionItem> getAutoCompleteItems(
            String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
        list = new ArrayList<>();
        for (String item : lists) {
            if (item.startsWith(prefix)) {
                list.add(helper(item, "Ts keywords"));
            }
        }

        return list;
    }

    private CompletionItem helper(String php, String desc) {
        final CompletionItem item = new CompletionItem(php + "  ", desc);
        item.cursorOffset(item.commit.length() - 1);
        return item;
    }
}
