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
/*
    public CompletionItem shiftCount(int shiftCount) {
        return cursorOffset(commit.length() - shiftCount);
    }

    public CompletionItem cursorOffset(int offset) {
        if (offset < 0 || offset > commit.length()) {
            throw new IllegalArgumentException();
        }
        cursorOffset = offset;
        return this;
    }
    public final static Comparator<CompletionItem> COMPARATOR_BY_NAME = (p1, p2) -> p1.label.compareTo(p2.label);
*/
package io.github.rosemoe.sora.data;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.util.Comparator;
import com.ninjacoder.jgit.CompletionItemKind;

/**
 * The class used to save auto complete result items
 *
 * @author Rose
 */
@SuppressWarnings("CanBeFinal")
public class CompletionItem {

  public static final Comparator<CompletionItem> COMPARATOR_BY_NAME =
      (p1, p2) -> p1.label.compareTo(p2.label);

  /** Icon for displaying in adapter */
  public Drawable icon;

  public String commit;
  public String label;
  public String desc;
  public String jdir;  

  /** Cursor offset in {@link CompletionItem#commit} */
  public int cursorOffset;

  /** From Read File */
  public File file;

  @SerializedName("prefix")
  public String prefix;
  @SerializedName("body")
  public String body;
  @SerializedName("description")
  public String description;


  public String getPrefix() {
    return prefix;
  }

  public String getBody() {
    return body;
  }

  public String getDescription() {
    return description;
  }

  @Nullable protected CompletionItemKind kinds;

  public CompletionItem() {}

  public CompletionItem(String str, String desc) {
    this(str, desc, (Drawable) null);
  }

  public CompletionItem(String label, String commit, String desc) {
    this(label, commit, desc, null);
  }

  public CompletionItem(String label, String desc, Drawable icon) {
    this(label, label, desc, icon);
  }

  public CompletionItem(String label, String commit, String desc, Drawable icon) {
    this.label = label;
    this.commit = commit;
    this.desc = desc;
    this.icon = icon;
    cursorOffset = commit.length();
  }

  public CompletionItem kind(CompletionItemKind kinds) {
    this.kinds = kinds;
    return this;
  }

  public CompletionItem shiftCount(int shiftCount) {
    return cursorOffset(commit.length() - shiftCount);
  }

  public CompletionItem cursorOffset(int offset) {
    if (offset < 0 || offset > commit.length()) {
      throw new IllegalArgumentException();
    }
    cursorOffset = offset;
    return this;
  }

  public String getCommit() {
    return this.commit;
  }

  public void setCommit(String commit) {
    this.commit = commit;
  }

  public String getLabel() {
    return this.label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getDesc() {
    return this.desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  
}
