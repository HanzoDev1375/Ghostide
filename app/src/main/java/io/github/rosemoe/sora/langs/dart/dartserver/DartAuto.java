package io.github.rosemoe.sora.langs.dart.dartserver;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

import java.util.ArrayList;
import java.util.List;

public class DartAuto implements AutoCompleteProvider {
    private List<CompletionItem> list = new ArrayList<>();

    @Override
    public List<CompletionItem> getAutoCompleteItems(
            String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
        for (var item : HotserverDart.keyword) {
            if (item.startsWith(prefix)) {
                list.add(dhelper(item, HotserverDart.KEYPATHLIST));
            }
        }

        return list;
    }

    protected CompletionItem dhelper(String dec, String word) {
        var mylist = new CompletionItem(dec, word);
        var u = mylist.commit;
        mylist.cursorOffset(u.length() - 1);
        return mylist;
    }
}
