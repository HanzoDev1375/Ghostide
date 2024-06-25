package io.github.rosemoe.sora.langs.css;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

import java.util.ArrayList;
import java.util.List;

public class CSSAutoComplete implements AutoCompleteProvider {
    @Override
    public List<CompletionItem> getAutoCompleteItems(String prefix, TextAnalyzeResult analyzeResult, int line,
                                                     int column) {
        List<CompletionItem> items = new ArrayList<>();
        for (String tag : CSSLanguage.MCSS)
            if (tag.startsWith(prefix))
                items.add(ColorcssAttrAsCompletion(tag, "CSS KeyWord"));

        for (String attr : CSSLanguage.colorsCss)
            if (attr.startsWith(prefix))
                items.add(ColorcssAttrAsCompletion(attr, "Parperty"));

        for (String attr : CSSLanguage.cssAttr)
            if (attr.startsWith(prefix))
                items.add(ColorcssAttrAsCompletion(attr, "Css Attr"));

        return items;
    }

    private CompletionItem ColorcssAttrAsCompletion(String mcss, String desc) {
        final CompletionItem item = new CompletionItem(mcss, mcss.concat(" "), desc);
        item.cursorOffset(item.commit.length() - 1);
        return item;
    }

}
