package io.github.rosemoe.sora.event;

import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorSearcher;

public class PublishSearchResultEvent extends Event {

    public PublishSearchResultEvent(CodeEditor editor) {
        super(editor);
    }

    public EditorSearcher getSearcher() {
        return ((CodeEditor) getEditor()).getSearcher();
    }
}