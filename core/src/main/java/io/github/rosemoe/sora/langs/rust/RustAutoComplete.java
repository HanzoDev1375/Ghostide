package io.github.rosemoe.sora.langs.rust;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.langs.internal.Identifiers;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import ir.ninjacoder.ghostide.core.IdeEditor;
import lsp4custom.com.ninjacoder.customhtmllsp.CodeSnippet;
import lsp4custom.com.ninjacoder.customhtmllsp.JavaCardshorts;
import lsp4custom.com.ninjacoder.customhtmllsp.TypeScriptCardshorts;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RustAutoComplete implements AutoCompleteProvider {

    private String[] mKeywords;
    private boolean mKeywordsAreLowCase;
    private JavaCardshorts shortcard;
    private IdeEditor editor;
    private List<CompletionItem> it;
    private String prf;
    private String name;
    private final WeakReference<IdeEditor> mEditorReference;

    public RustAutoComplete(IdeEditor editor) {
        mEditorReference = new WeakReference<>(editor);
    }

    public void setKeywords(String[] keywords) {
        mKeywords = keywords;
        mKeywordsAreLowCase = false;
    }

    public void setKeywords(String[] keywords, String name) {
        mKeywords = keywords;
        mKeywordsAreLowCase = false;
        this.name = name;
    }

    @Override
    public List<CompletionItem> getAutoCompleteItems(
            String prefix, TextAnalyzeResult analyzeResult, int line, int column) {

        List<CompletionItem> allItems = new ArrayList<>();
        editor = mEditorReference.get();
        prf = prefix;

        // Add keyword completions
        if (mKeywords != null) {
            for (String kw : mKeywords) {
                if (kw.startsWith(prefix) || kw.contains(prefix)) {
                    allItems.add(new CompletionItem(kw, name != null ? name : "Rust Keyword"));
                }
            }
        }

        // Add user identifiers from analysis
        Object extra = analyzeResult.getExtra();
        if (extra instanceof Identifiers) {
            Identifiers userIdentifiers = (Identifiers) extra;
            for (String word : userIdentifiers.getIdentifiers()) {
                if (word.startsWith(prefix) || word.contains(prefix)) {
                    allItems.add(new CompletionItem(word, "Identifier"));
                }
            }
        }

        // Add Rust code snippets
        allItems.addAll(getRustSnippets(prefix));

        // Add from CodeSnippet if available for Rust
   //     allItems.addAll(CodeSnippet.runasList("rust", prefix));

        // Sort alphabetically
        allItems.sort(CompletionItem.COMPARATOR_BY_NAME);
        it = new ArrayList<>(allItems);

        return allItems;
    }

    private List<CompletionItem> getRustSnippets(String prefix) {
        List<CompletionItem> snippets = new ArrayList<>();

        // Rust code snippets
        addSnippet(snippets, prefix, "fn", "fn name() {\n    \n}", "Function");
        addSnippet(snippets, prefix, "struct", "struct Name {\n    \n}", "Struct");
        addSnippet(snippets, prefix, "enum", "enum Name {\n    \n}", "Enum");
        addSnippet(snippets, prefix, "impl", "impl Type {\n    \n}", "Implementation");
        addSnippet(snippets, prefix, "trait", "trait Name {\n    \n}", "Trait");
        addSnippet(snippets, prefix, "mod", "mod name {\n    \n}", "Module");
        addSnippet(snippets, prefix, "match", "match value {\n    \n}", "Match");
        addSnippet(snippets, prefix, "if", "if condition {\n    \n}", "If");
        addSnippet(snippets, prefix, "iflet", "if let pattern = expr {\n    \n}", "If Let");
        addSnippet(snippets, prefix, "while", "while condition {\n    \n}", "While");
        addSnippet(snippets, prefix, "whilelet", "while let pattern = expr {\n    \n}", "While Let");
        addSnippet(snippets, prefix, "loop", "loop {\n    \n}", "Loop");
        addSnippet(snippets, prefix, "for", "for item in iter {\n    \n}", "For");
        addSnippet(snippets, prefix, "println", "println!(\"\");", "Println");
        addSnippet(snippets, prefix, "print", "print!(\"\");", "Print");
        addSnippet(snippets, prefix, "format", "format!(\"\");", "Format");
        addSnippet(snippets, prefix, "vec", "vec![]", "Vector");
        addSnippet(snippets, prefix, "main", "fn main() {\n    \n}", "Main Function");
        addSnippet(snippets, prefix, "test", "#[test]\nfn test_name() {\n    \n}", "Test");
        addSnippet(snippets, prefix, "derive", "#[derive()]", "Derive");
        addSnippet(snippets, prefix, "pub", "pub ", "Public");
        addSnippet(snippets, prefix, "pubfn", "pub fn name() {\n    \n}", "Public Function");
        addSnippet(snippets, prefix, "pubstruct", "pub struct Name {\n    \n}", "Public Struct");
        addSnippet(snippets, prefix, "pubenum", "pub enum Name {\n    \n}", "Public Enum");
        addSnippet(snippets, prefix, "pubtrait", "pub trait Name {\n    \n}", "Public Trait");
        addSnippet(snippets, prefix, "let", "let  = ", "Let Binding");
        addSnippet(snippets, prefix, "letmut", "let mut  = ", "Mutable Let Binding");
        addSnippet(snippets, prefix, "use", "use ;", "Use");
        addSnippet(snippets, prefix, "macro_rules", "macro_rules! name {\n    () => {\n        \n    };\n}", "Macro Rules");
        addSnippet(snippets, prefix, "unsafe", "unsafe {\n    \n}", "Unsafe Block");
        addSnippet(snippets, prefix, "type", "type  = ", "Type Alias");

        return snippets;
    }

    private void addSnippet(List<CompletionItem> list, String prefix, String label, String commit, String desc) {
        if (label.startsWith(prefix.toLowerCase()) || prefix.isEmpty()) {
            CompletionItem item = new CompletionItem(label, desc);
            item.commit = commit;
            item.cursorOffset(commit.length());
            list.add(item);
        }
    }
}