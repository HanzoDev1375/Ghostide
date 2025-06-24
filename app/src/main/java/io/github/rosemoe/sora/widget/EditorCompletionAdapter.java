package io.github.rosemoe.sora.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;

import io.github.rosemoe.sora.data.CompletionItem;

import java.util.List;

import io.github.rosemoe.sora.widget.EditorColorScheme;

/**
 * A class to make custom adapter for auto-completion window
 *
 * @see EditorCompletionAdapter#getItemHeight()
 * @see EditorCompletionAdapter#getView(int, View, ViewGroup, boolean)
 */
public abstract class EditorCompletionAdapter extends BaseAdapter implements Adapter {

  private EditorAutoCompleteWindow window;
  private List<CompletionItem> items;

  /** Called by {@link EditorAutoCompletion} to attach some arguments */
  public void attachValues(
      @NonNull EditorAutoCompleteWindow window, @NonNull List<CompletionItem> items) {
    this.window = window;
    this.items = items;
  }

  @Override
  public CompletionItem getItem(int position) {
    return items.get(position);
  }

  /** Get current prefix of completion */
  public String getPrefix() {
    return window.getPrefix();
  }

  @Override
  public long getItemId(int position) {
    return getItem(position).hashCode();
  }

  @Override
  public int getCount() {
    return items == null ? 0 : items.size();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    return getView(position, convertView, parent, position == window.getCurrentPosition());
  }

  /** Get color scheme in editor */
  @NonNull
  protected EditorColorScheme getColorScheme() {
    return getEditor().getColorScheme();
  }

  /**
   * Get theme color from current color scheme
   *
   * @param type Type of color. Refer to {@link EditorColorScheme}
   * @see EditorColorScheme#getColor(int)
   */
  protected int getThemeColor(int type) {
    return getColorScheme().getColor(type);
  }

  /** Get context from editor */
  @NonNull
  protected Context getContext() {
    return window.getContext();
  }

  /**
   * call in editor from color set Lang how to using! var editor = getEditor(); if(editor != null)
   * //your work....
   */
  @NonNull
  protected CodeEditor getEditor() {
    return window.getEditor();
  }
  
  protected boolean isShowing(){
	  return window.isShowing();
  }
  /**
   * Implementation of this class should provide exact height of its item
   *
   * <p>The value will be used to calculate the height of completion window
   */
  public abstract int getItemHeight();

  /**
   * @param isCurrentCursorPosition Is the {@param position} currently selected
   * @see BaseAdapter#getView(int, View, ViewGroup)
   */
  protected abstract View getView(
      int position, View convertView, ViewGroup parent, boolean isCurrentCursorPosition);
}
