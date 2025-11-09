package io.github.rosemoe.sora.langs.cpp;

import java.util.ArrayList;
import java.util.List;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

public class CppAuto implements AutoCompleteProvider {
    private List<CompletionItem> item;


    @Override
    public List<CompletionItem> getAutoCompleteItems(
            String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
        item = new ArrayList<>();


        for (var ib : CppTextTokenizer.sKeywords) {
            if (ib.startsWith(prefix)) {
                item.add(CppAsCompletion(ib, "Cpp Keyword"));
            }
        }
        return item;
    }

    private CompletionItem CppAsCompletion(String php, String desc) {
        final CompletionItem item = new CompletionItem(php + " ", desc);
        item.cursorOffset(item.commit.length() - 1);
        return item;
    }

    private CompletionItem CodeSampel(String em, String desc, String codeS) {
        final var open = codeS;
        final CompletionItem item = new CompletionItem(em + " ", desc);
        item.commit = open;
        item.cursorOffset(item.commit.length() - 1);
        return item;
    }
}
