/*
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/sora-editor
 *    Copyright (C) 2020-2022  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 */
package io.github.rosemoe.sora.text;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * This class saves the text content for editor and maintains line widths
 *
 * @author Rose
 */
public class Content implements CharSequence {

  public static final int DEFAULT_MAX_UNDO_STACK_SIZE = 500;
  public static final int DEFAULT_LIST_CAPACITY = 1000;

  private static int sInitialListCapacity;

  static {
    setInitialLineCapacity(DEFAULT_LIST_CAPACITY);
  }

  private List<ContentLine> mLines;
  private int mTextLength;
  private int mNestedBatchEdit;
  private List<ContentListener> mListeners;
  private Indexer mIndexer;
  private UndoManager mUndoManager;
  private Cursor mCursor;
  private LineRemoveListener mLineListener;
  private int scrollX;
  private int scrollY;

  /** This constructor will create a Content object with no text */
  public Content() {
    this(null);
  }

  /**
   * This constructor will create a Content object with the given source If you give us null,it will
   * just create a empty Content object
   *
   * @param src The source of Content
   */
  public Content(CharSequence src) {
    if (src == null) {
      src = "";
    }
    mTextLength = 0;
    scrollX = 0;
    scrollY = 0;
    mNestedBatchEdit = 0;
    mLines = new ArrayList<>(getInitialLineCapacity());
    mLines.add(new ContentLine());
    mListeners = new ArrayList<>();
    mUndoManager = new UndoManager();
    setMaxUndoStackSize(Content.DEFAULT_MAX_UNDO_STACK_SIZE);
    mIndexer = new NoCacheIndexer(this);
    if (src.length() == 0) {
      setUndoEnabled(true);
      return;
    }
    setUndoEnabled(false);
    insert(0, 0, src);
    setUndoEnabled(true);
  }

  /**
   * Returns the default capacity of text line list
   *
   * @return Default capacity
   */
  public static int getInitialLineCapacity() {
    return Content.sInitialListCapacity;
  }

  /**
   * Set the default capacity of text line list
   *
   * @param capacity Default capacity
   */
  public static void setInitialLineCapacity(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("capacity can not be negative or zero");
    }
    sInitialListCapacity = capacity;
  }

  /**
   * Test whether the two ContentLine have the same content
   *
   * @param a ContentLine
   * @param b another ContentLine
   * @return Whether equals in content
   */
  private static boolean equals(ContentLine a, ContentLine b) {
    if (a.length() != b.length()) {
      return false;
    }
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public char charAt(int index) {
    checkIndex(index);
    CharPosition p = getIndexer().getCharPosition(index);
    return charAt(p.line, p.column);
  }

  @Override
  public int length() {
    return mTextLength;
  }

  @NonNull
  @Override
  public CharSequence subSequence(int start, int end) {
    if (start > end) {
      throw new StringIndexOutOfBoundsException("start > end");
    }
    CharPosition s = getIndexer().getCharPosition(start);
    CharPosition e = getIndexer().getCharPosition(end);
    return subContent(s.getLine(), s.getColumn(), e.getLine(), e.getColumn());
  }

  /**
   * Set a line listener
   *
   * @param lis the listener,maybe null
   * @see LineRemoveListener
   */
  public void setLineListener(LineRemoveListener lis) {
    this.mLineListener = lis;
  }

  /**
   * Get the character at the given position If (column == getColumnCount(line)),it returns '\n'
   * IndexOutOfBoundsException is thrown
   *
   * @param line The line position of character
   * @param column The column position of character
   * @return The character at the given position
   */
  public char charAt(int line, int column) {
    checkLineAndColumn(line, column, true);
    if (column == getColumnCount(line)) {
      return '\n';
    }
    return mLines.get(line).charAt(column);
  }

  /**
   * Get raw data of line The result is not expected to be modified
   *
   * @param line Line
   * @return Raw ContentLine used by Content
   */
  public ContentLine getLine(int line) {
    return mLines.get(line);
  }

  /**
   * Get how many lines there are
   *
   * @return Line count
   */
  public int getLineCount() {
    return mLines.size();
  }

  /**
   * Get how many characters is on the given line If (line < 0 or line >= getLineCount()),it will
   * throw a IndexOutOfBoundsException
   *
   * @param line The line to get
   * @return Character count on line
   */
  public int getColumnCount(int line) {
    checkLine(line);
    return mLines.get(line).length();
  }

  /**
   * Get the given line text without '\n' character
   *
   * @param line The line to get
   * @return New String object of this line
   */
  public String getLineString(int line) {
    checkLine(line);
    return mLines.get(line).toString();
  }

  /** Get characters of line */
  public void getLineChars(int line, char[] dest) {
    mLines.get(line).getChars(0, getColumnCount(line), dest, 0);
  }

  /**
   * Transform the (line,column) position to index This task will usually completed by {@link
   * Indexer}
   *
   * @param line Line of index
   * @param column Column on line of index
   * @return Transformed index for the given arguments
   */
  public int getCharIndex(int line, int column) {
    return getIndexer().getCharIndex(line, column);
  }

  /**
   * Insert content to this object
   *
   * @param line The insertion's line position
   * @param column The insertion's column position
   * @param text The text you want to insert at the position
   */
  public void insert(int line, int column, CharSequence text) {
    checkLineAndColumn(line, column, true);
    if (text == null) {
      throw new IllegalArgumentException("text can not be null");
    }

    // -----Notify------
    if (mCursor != null) mCursor.beforeInsert(line, column);
    for (var lis : mListeners) {
      lis.beforeModification(this);
    }

    int workLine = line;
    int workIndex = column;
    if (workIndex == -1) {
      workIndex = 0;
    }
    ContentLine currLine = mLines.get(workLine);
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == '\n') {
        ContentLine newLine = new ContentLine();
        newLine.append(currLine, workIndex, currLine.length());
        currLine.delete(workIndex, currLine.length());
        mLines.add(workLine + 1, newLine);
        currLine = newLine;
        workIndex = 0;
        workLine++;
      } else {
        currLine.insert(workIndex, c);
        workIndex++;
      }
    }
    mTextLength += text.length();
    this.dispatchAfterInsert(line, column, workLine, workIndex, text);
  }

  /**
   * Delete character in [start,end)
   *
   * @param start Start position in content
   * @param end End position in content
   */
  public void delete(int start, int end) {
    checkIndex(start);
    checkIndex(end);
    CharPosition startPos = getIndexer().getCharPosition(start);
    CharPosition endPos = getIndexer().getCharPosition(end);
    if (start != end) {
      delete(startPos.line, startPos.column, endPos.line, endPos.column);
    }
  }

  /**
   * Delete text in the given region
   *
   * @param startLine The start line position
   * @param columnOnStartLine The start column position
   * @param endLine The end line position
   * @param columnOnEndLine The end column position
   */
  public void delete(int startLine, int columnOnStartLine, int endLine, int columnOnEndLine) {
    try {
      StringBuilder changedContent = new StringBuilder();
      if (startLine == endLine) {
        checkLineAndColumn(endLine, columnOnEndLine, true);
        checkLineAndColumn(startLine, columnOnStartLine == -1 ? 0 : columnOnStartLine, true);
        int beginIdx = columnOnStartLine;
        if (columnOnStartLine == -1) {
          beginIdx = 0;
        }
        if (beginIdx > columnOnEndLine) {
          throw new IllegalArgumentException("start > end");
        }
        ContentLine curr = mLines.get(startLine);
        int len = curr.length();
        if (beginIdx < 0 || beginIdx > len || columnOnEndLine > len) {
          throw new StringIndexOutOfBoundsException("column start or column end is out of bounds");
        }

        // -----Notify------
        if (mCursor != null) {
          if (columnOnStartLine != -1) {
            mCursor.beforeDelete(startLine, columnOnStartLine, endLine, columnOnEndLine);
          } else {
            mCursor.beforeDelete(
                startLine == 0 ? 0 : startLine - 1,
                startLine == 0 ? 0 : getColumnCount(startLine - 1),
                endLine,
                columnOnEndLine);
          }
        }
        for (var lis : mListeners) {
          lis.beforeModification(this);
        }

        changedContent.append(curr, beginIdx, columnOnEndLine);
        curr.delete(beginIdx, columnOnEndLine);
        mTextLength -= columnOnEndLine - columnOnStartLine;
        if (columnOnStartLine == -1) {
          if (startLine == 0) {
            mTextLength++;
          } else {
            ContentLine previous = mLines.get(startLine - 1);
            columnOnStartLine = previous.length();
            previous.append(curr);
            ContentLine rm = mLines.remove(startLine);
            if (mLineListener != null) {
              mLineListener.onRemove(this, rm);
            }
            changedContent.insert(0, '\n');
            startLine--;
          }
        }
      } else if (startLine < endLine) {
        checkLineAndColumn(startLine, columnOnStartLine, true);
        checkLineAndColumn(endLine, columnOnEndLine, true);

        // -----Notify------
        if (mCursor != null)
          mCursor.beforeDelete(startLine, columnOnStartLine, endLine, columnOnEndLine);
        for (var lis : mListeners) {
          lis.beforeModification(this);
        }

        for (int i = 0; i < endLine - startLine - 1; i++) {
          ContentLine line = mLines.remove(startLine + 1);
          if (mLineListener != null) {
            mLineListener.onRemove(this, line);
          }
          mTextLength -= line.length() + 1;
          changedContent.append('\n').append(line);
        }
        int currEnd = startLine + 1;
        ContentLine start = mLines.get(startLine);
        ContentLine end = mLines.get(currEnd);
        mTextLength -= start.length() - columnOnStartLine;
        changedContent.insert(0, start, columnOnStartLine, start.length());
        start.delete(columnOnStartLine, start.length());
        mTextLength -= columnOnEndLine;
        changedContent.append('\n').append(end, 0, columnOnEndLine);
        end.delete(0, columnOnEndLine);
        mTextLength--;
        ContentLine r = mLines.remove(currEnd);
        if (mLineListener != null) {
          mLineListener.onRemove(this, r);
        }
        start.append(end);
      } else {
        throw new IllegalArgumentException("start line > end line");
      }
      this.dispatchAfterDelete(
          startLine, columnOnStartLine, endLine, columnOnEndLine, changedContent);
    } catch (Exception e) {

    }
  }

  /**
   * Replace the text in the given region This action will completed by calling {@link
   * Content#delete(int, int, int, int)} and {@link Content#insert(int, int, CharSequence)}
   *
   * @param startLine The start line position
   * @param columnOnStartLine The start column position
   * @param endLine The end line position
   * @param columnOnEndLine The end column position
   * @param text The text to replace old text
   */
  public void replace(
      int startLine, int columnOnStartLine, int endLine, int columnOnEndLine, CharSequence text) {
    if (text == null) {
      throw new IllegalArgumentException("text can not be null");
    }
    this.dispatchBeforeReplace();
    delete(startLine, columnOnStartLine, endLine, columnOnEndLine);
    insert(startLine, columnOnStartLine, text);
  }

  /**
   * When you are going to use {@link CharSequence#charAt(int)} frequently,you are required to call
   * this method.Because the way Content save text,it is usually slow to transform index to
   * (line,column) from the start of text when the text is big. By calling this method,you will be
   * able to get faster because calling this will cause the ITextContent object use a Indexer with
   * cache. The performance is highly improved while linearly getting characters.
   *
   * @param initialIndex The Indexer with cache will take it into this index to its cache
   */
  public void beginStreamCharGetting(int initialIndex) {
    mIndexer = new CachedIndexer(this);
    mIndexer.getCharPosition(initialIndex);
  }

  /**
   * When you finished calling {@link CharSequence#charAt(int)} frequently,you can call this method
   * to free the Indexer with cache. This is not forced.
   */
  public void endStreamCharGetting() {
    mIndexer = new NoCacheIndexer(this);
  }

  /**
   * Undo the last modification NOTE:When there are too much modification,old modification will be
   * deleted from UndoManager
   */
  public void undo() {
    mUndoManager.undo(this);
  }

  /** Redo the last modification */
  public void redo() {
    mUndoManager.redo(this);
  }

  /**
   * Whether we can undo
   *
   * @return Whether we can undo
   */
  public boolean canUndo() {
    return mUndoManager.canUndo();
  }

  /**
   * Whether we can redo
   *
   * @return Whether we can redo
   */
  public boolean canRedo() {
    return mUndoManager.canRedo();
  }

  /**
   * Get whether UndoManager is enabled
   *
   * @return Whether UndoManager is enabled
   */
  public boolean isUndoEnabled() {
    return mUndoManager.isUndoEnabled();
  }

  /**
   * Set whether enable the UndoManager. If false,any modification will not be taken down and
   * previous modification that is already in UndoManager will be removed.Does not make changes to
   * content.
   *
   * @param enabled New state for UndoManager
   */
  public void setUndoEnabled(boolean enabled) {
    mUndoManager.setUndoEnabled(enabled);
  }

  /**
   * Get current max stack size of UndoManager
   *
   * @return current max stack size
   */
  public int getMaxUndoStackSize() {
    return mUndoManager.getMaxUndoStackSize();
  }

  /**
   * Set the max size of stack in UndoManager
   *
   * @param maxSize New max size
   */
  public void setMaxUndoStackSize(int maxSize) {
    mUndoManager.setMaxUndoStackSize(maxSize);
  }

  /**
   * A delegate method. Notify the UndoManager to begin batch edit(enter a new layer). NOTE: batch
   * edit in Android can be nested.
   *
   * @return Whether in batch edit
   */
  public boolean beginBatchEdit() {
    mNestedBatchEdit++;
    return isInBatchEdit();
  }

  /**
   * A delegate method. Notify the UndoManager to end batch edit(exit current layer).
   *
   * @return Whether in batch edit
   */
  public boolean endBatchEdit() {
    mNestedBatchEdit--;
    if (mNestedBatchEdit < 0) {
      mNestedBatchEdit = 0;
    }
    return isInBatchEdit();
  }

  /**
   * Returns whether we are in batch edit
   *
   * @return Whether in batch edit
   */
  public boolean isInBatchEdit() {
    return mNestedBatchEdit > 0;
  }

  /**
   * Add a new {@link ContentListener} to the Content
   *
   * @param listener The listener to add
   */
  public void addContentListener(ContentListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException("listener can not be null");
    }
    if (listener instanceof Indexer) {
      throw new IllegalArgumentException("Permission denied");
    }
    if (!mListeners.contains(listener)) {
      mListeners.add(listener);
    }
  }

  public void appendToStringBuilder(StringBuilder sb) {
    sb.ensureCapacity(sb.length() + length());
    boolean first = true;
    final int lines = getLineCount();
    for (int i = 0; i < lines; i++) {
      ContentLine line = mLines.get(i);
      if (!first) {
        sb.append('\n');
      } else {
        first = false;
      }
      line.appendTo(sb);
    }
  }

  /**
   * Remove the given listener of this Content
   *
   * @param listener The listener to remove
   */
  public void removeContentListener(ContentListener listener) {
    if (listener instanceof Indexer) {
      throw new IllegalArgumentException("Permission denied");
    }
    mListeners.remove(listener);
  }

  /**
   * Get the using {@link Indexer} object
   *
   * @return Indexer for this object
   */
  public Indexer getIndexer() {
    if (mIndexer.getClass() != CachedIndexer.class && mCursor != null) {
      return mCursor.getIndexer();
    }
    return mIndexer;
  }

  /**
   * Quick method to get sub string of this object
   *
   * @param startLine The start line position
   * @param startColumn The start column position
   * @param endLine The end line position
   * @param endColumn The end column position
   * @return sub sequence of this Content
   */
  public Content subContent(int startLine, int startColumn, int endLine, int endColumn) {
    Content c = new Content();
    c.setUndoEnabled(false);
    if (startLine == endLine) {
      c.insert(0, 0, mLines.get(startLine).subSequence(startColumn, endColumn));
    } else if (startLine < endLine) {
      c.insert(
          0, 0, mLines.get(startLine).subSequence(startColumn, mLines.get(startLine).length()));
      for (int i = startLine + 1; i < endLine; i++) {
        c.mLines.add(new ContentLine(mLines.get(i)));
        c.mTextLength += mLines.get(i).length() + 1;
      }
      ContentLine end = mLines.get(endLine);
      c.mLines.add(new ContentLine().insert(0, end, 0, endColumn));
      c.mTextLength += endColumn + 1;
    } else {
      throw new IllegalArgumentException("start > end");
    }
    c.setUndoEnabled(true);
    return c;
  }

  @Override
  public boolean equals(Object anotherObject) {
    if (anotherObject instanceof Content) {
      Content content = (Content) anotherObject;
      if (content.getLineCount() != this.getLineCount()) {
        return false;
      }
      for (int i = 0; i < this.getLineCount(); i++) {
        if (!equals(mLines.get(i), content.mLines.get(i))) {
          return false;
        }
      }
      return true;
    } else {
      return false;
    }
  }

  @NonNull
  @Override
  public String toString() {
    return toStringBuilder().toString();
  }

  /**
   * Get the text in StringBuilder form
   *
   * <p>This can improve the speed in char getting for tokenizing
   *
   * @return StringBuilder form of Content
   */
  public StringBuilder toStringBuilder() {
    try {
      StringBuilder sb = new StringBuilder();
      sb.ensureCapacity(mTextLength + 10);
      boolean first = true;
      final int lines = getLineCount();
      for (int i = 0; i < lines; i++) {
        ContentLine line = mLines.get(i);
        if (!first) {
          sb.append('\n');
        } else {
          first = false;
        }
        line.appendTo(sb);
      }
      return sb;
    } catch (Exception err) {
      return null;
    }
  }

  /**
   * Get Cursor for editor (Create if there is not)
   *
   * @return Cursor
   */
  public Cursor getCursor() {
    if (mCursor == null) {
      mCursor = new Cursor(this);
    }
    return mCursor;
  }

  /** Dispatch events to listener before replacement */
  private void dispatchBeforeReplace() {
    mUndoManager.beforeReplace(this);
    if (mCursor != null) mCursor.beforeReplace();
    if (mIndexer instanceof ContentListener) {
      ((ContentListener) mIndexer).beforeReplace(this);
    }
    for (ContentListener lis : mListeners) {
      lis.beforeReplace(this);
    }
  }

  /**
   * Dispatch events to listener after deletion
   *
   * @param a Start line
   * @param b Start Column
   * @param c End line
   * @param d End column
   * @param e Text deleted
   */
  private void dispatchAfterDelete(int a, int b, int c, int d, CharSequence e) {
    mUndoManager.afterDelete(this, a, b, c, d, e);
    if (mCursor != null) mCursor.afterDelete(a, b, c, d, e);
    if (mIndexer instanceof ContentListener) {
      ((ContentListener) mIndexer).afterDelete(this, a, b, c, d, e);
    }
    for (ContentListener lis : mListeners) {
      lis.afterDelete(this, a, b, c, d, e);
    }
  }

  /**
   * Dispatch events to listener after insertion
   *
   * @param a Start line
   * @param b Start Column
   * @param c End line
   * @param d End column
   * @param e Text deleted
   */
  private void dispatchAfterInsert(int a, int b, int c, int d, CharSequence e) {
    mUndoManager.afterInsert(this, a, b, c, d, e);
    if (mCursor != null) mCursor.afterInsert(a, b, c, d, e);
    if (mIndexer instanceof ContentListener) {
      ((ContentListener) mIndexer).afterInsert(this, a, b, c, d, e);
    }
    for (ContentListener lis : mListeners) {
      lis.afterInsert(this, a, b, c, d, e);
    }
  }

  /**
   * Check whether the index is valid
   *
   * @param index Index to check
   */
  protected void checkIndex(int index) {
    if (index > length()) {
      throw new StringIndexOutOfBoundsException(
          "Index " + index + " out of bounds. length:" + length());
    }
  }

  /**
   * Check whether the line is valid
   *
   * @param line Line to check
   */
  protected void checkLine(int line) {
    if (line >= getLineCount()) {
      throw new StringIndexOutOfBoundsException(
          "Line " + line + " out of bounds. line count:" + getLineCount());
    }
  }

  /**
   * Check whether the line and column is valid
   *
   * @param line The line to check
   * @param column The column to check
   * @param allowEqual Whether allow (column == getColumnCount(line))
   */
  protected void checkLineAndColumn(int line, int column, boolean allowEqual) {
    checkLine(line);
    int len = mLines.get(line).length();
    if (column > len || (!allowEqual && column == len)) {
      throw new StringIndexOutOfBoundsException(
          "Column " + column + " out of bounds.line: " + line + " ,column count:" + len);
    }
  }

  /**
   * Copy text in this Content object. Returns a new Content object with the same text as this
   * object.
   */
  public Content copyText() {
    try {
      Content n = new Content();
      n.mLines.remove(0);
      for (int i = 0; i < getLineCount(); i++) {
        var line = mLines.get(i);
        n.mLines.add(line.subSequence(0, line.length()));
      }
      return n;
    } catch (Exception e) {
      return null;
    }
  }

  public int getScrollX() {
    return this.scrollX;
  }

  public void setScrollX(int scrollX) {
    this.scrollX = scrollX;
  }

  public int getScrollY() {
    return this.scrollY;
  }

  public void setScrollY(int scrollY) {
    this.scrollY = scrollY;
  }
}
