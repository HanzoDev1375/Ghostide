package io.github.rosemoe.sora.langs.css;

import java.util.ArrayList;
import java.util.List;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

public class CSSAutoComplete implements AutoCompleteProvider {
    @Override
    public List<CompletionItem> getAutoCompleteItems(String prefix, TextAnalyzeResult analyzeResult, int line,
                                                     int column) {
        List<CompletionItem> items = new ArrayList<>();
       

        return items;
    }

    private CompletionItem ColorcssAttrAsCompletion(String mcss, String desc) {
        final CompletionItem item = new CompletionItem(mcss, mcss.concat(" "), desc);
        item.cursorOffset(item.commit.length() - 1);
        return item;
    }

}
