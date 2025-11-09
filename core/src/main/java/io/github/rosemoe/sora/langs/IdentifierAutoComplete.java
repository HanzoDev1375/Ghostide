package io.github.rosemoe.sora.langs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

/**
 * Identifier auto-completion You can use it to provide identifiers <strong>Note:</strong> To use
 * this, you must use {@link Identifiers} to {@link TextAnalyzeResult#setExtra(Object)}
 */
public class IdentifierAutoComplete implements AutoCompleteProvider {

    private String[] mKeywords;
    private boolean mKeywordsAreLowCase;

    public IdentifierAutoComplete() {
    }

    public IdentifierAutoComplete(String[] keywords) {
        setKeywords(keywords);
    }

    public String[] getKeywords() {
        return mKeywords;
    }

    public void setKeywords(String[] keywords) {
        mKeywords = keywords;
        mKeywordsAreLowCase = false;
    }

    @Override
    public List<CompletionItem> getAutoCompleteItems(
            String prefix, TextAnalyzeResult analyzeResult, int line, int column) {
        List<CompletionItem> keywords = new ArrayList<>();
        final String[] keywordArray = mKeywords;
        final boolean lowCase = mKeywordsAreLowCase;

        String match = prefix;
        if (keywordArray != null) {
            for (String kw : keywordArray) {
                if (kw.startsWith(match)) {
                    keywords.add(new CompletionItem(kw, "null key"));
                }
            }
        }
        Collections.sort(keywords, CompletionItem.COMPARATOR_BY_NAME);
        Object extra = analyzeResult.getExtra();
        Identifiers userIdentifiers = (extra instanceof Identifiers) ? (Identifiers) extra : null;
        if (userIdentifiers != null) {
            List<CompletionItem> words = new ArrayList<>();
            for (String word : userIdentifiers.getIdentifiers()) {
                if (word.startsWith(match)) {
                    words.add(new CompletionItem(word, "Identifier"));
                }
            }
            Collections.sort(words, CompletionItem.COMPARATOR_BY_NAME);
            keywords.addAll(words);
        }
        return keywords;
    }

    public static class Identifiers {

        private static final Object SIGN = new Object();
        private final List<String> identifiers = new ArrayList<>();
        private HashMap<String, Object> cache;

        public void addIdentifier(String identifier) {
            if (cache == null) {
                throw new IllegalStateException("begin() has not been called");
            }
            if (cache.put(identifier, SIGN) == SIGN) {
                return;
            }
            identifiers.add(identifier);
        }

        public void begin() {
            cache = new HashMap<>();
        }

        public void finish() {
            cache.clear();
            cache = null;
        }

        public List<String> getIdentifiers() {
            return identifiers;
        }
    }
}
