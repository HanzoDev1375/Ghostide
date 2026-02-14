package io.github.rosemoe.sora.event;

import io.github.rosemoe.sora.widget.CodeEditor;

public class PublishSearchResultEvent extends Event {
  private CodeEditor editor;
  private int matchCount;
  private String searchText;
  private boolean isRegex;

  public PublishSearchResultEvent(CodeEditor editor, int matchCount, String searchText, boolean isRegex) {
    super(editor);
    this.editor = editor;
    this.matchCount = matchCount;
    this.searchText = searchText;
    this.isRegex = isRegex;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public String getSearchText() {
    return searchText;
  }

  public boolean isRegex() {
    return isRegex;
  }
}