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
package io.github.rosemoe.sora.data;

import android.graphics.Paint;
import androidx.annotation.NonNull;
import io.github.rosemoe.sora.interfaces.ExternalRenderer;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * The span model
 *
 * @author Rose
 */
public class Span {

  /**
   * Flag for {@link Span#problemFlags}.
   *
   * <p>Indicates this span is in ERROR region
   */
  public static final int FLAG_ERROR = 1 << 3;

  /**
   * Flag for {@link Span#problemFlags}.
   *
   * <p>Indicates this span is in WARNING region
   */
  public static final int FLAG_WARNING = 1 << 2;

  /**
   * Flag for {@link Span#problemFlags}.
   *
   * <p>Indicates this span is in TYPO region
   */
  public static final int FLAG_TYPO = 1 << 1;

  /**
   * Flag for {@link Span#problemFlags}.
   *
   * <p>Indicates this span is in DEPRECATED region
   */
  public static final int FLAG_DEPRECATED = 1;

  private static final BlockingQueue<Span> cacheQueue = new ArrayBlockingQueue<>(8192 * 2);

  public int column;

  public long style;

  public int underlineColor;

  public int backgroundColorMy;

  public int alpha;

  public int alphacompat;

  public String drawminiText;

  /**
   * Set this value to draw curly lines for this span to indicates code problems.
   *
   * @see Span#FLAG_ERROR
   * @see Span#FLAG_WARNING
   * @see Span#FLAG_TYPO
   * @see Span#FLAG_DEPRECATED
   * @see io.github.rosemoe.sora.text.TextAnalyzeResult#markProblemRegion(int, int, int, int, int)
   */
  public int problemFlags = 0;

  public ExternalRenderer renderer = null;

  /**
   * Create a new span
   *
   * @param column Start column of span
   * @param style Style made from {@link io.github.rosemoe.sora.text.TextStyle}
   * @see Span#obtain(int, long)
   */
  private Span(int column, long style) {
    this.column = column;
    this.style = style;
  }

  /**
   * Get an available Span object from either cache or new instance. The result object will be
   * initialized with the given arguments.
   */
  public static Span obtain(int column, long style) {
    Span span = cacheQueue.poll();
    if (span == null) {
      return new Span(column, style);
    } else {
      span.column = column;
      span.style = style;
      return span;
    }
  }

  public static void recycleAll(Collection<Span> spans) {
    for (Span span : spans) {
      if (!span.recycle()) {
        return;
      }
    }
  }

  /**
   * Set a underline for this region Zero for no underline
   *
   * @param color Color for this underline (not color id of {@link EditorColorScheme})
   */
  public void setUnderlineColor(int color) {
    underlineColor = color;
  }

  /**
   * Get span start column
   *
   * @return Start column
   */
  public int getColumn() {
    return column;
  }

  /** Set column of this span */
  public Span setColumn(int column) {
    this.column = column;
    return this;
  }

  /** Make a copy of this span */
  public Span copy() {
    Span copy = obtain(column, style);
    copy.setUnderlineColor(underlineColor);
    copy.setBackgroundColorMy(backgroundColorMy);
    copy.setAlpha(alpha);
    copy.setDrawminiText(drawminiText);
    copy.problemFlags = problemFlags;
    copy.renderer = renderer;
    return copy;
  }

  public boolean recycle() {
    problemFlags = column = underlineColor = backgroundColorMy = 0;
    style = 0;
    alpha = 1;
    alphacompat = 0;
    drawminiText = null;
    renderer = null;
    return cacheQueue.offer(this);
  }

  public int getForegroundColorId() {
    return TextStyle.getForegroundColorId(style);
  }

  public int getBackgroundColorId() {
    return TextStyle.getBackgroundColorId(style);
  }

  public long getStyleBits() {
    return TextStyle.getStyleBits(style);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Span span = (Span) o;
    return column == span.column
        && style == span.style
        && underlineColor == span.underlineColor
        && problemFlags == span.problemFlags
        && alpha == span.alpha
        && alphacompat == span.alphacompat
        && backgroundColorMy == span.backgroundColorMy
        && Objects.equals(drawminiText, span.drawminiText)
        && Objects.equals(renderer, span.renderer);
  }

  @Override
  public int hashCode() {
    int hash = 31 * column;
    hash = 31 * hash + Long.hashCode(style);
    hash = 31 * hash + underlineColor;
    hash = 31 * hash + backgroundColorMy;
    hash = 31 * hash + alpha;
    hash = 31 * hash + alphacompat;
    hash = 31 * hash + problemFlags;
    hash = 31 * hash + (drawminiText == null ? 0 : drawminiText.hashCode());
    hash = 31 * hash + (renderer == null ? 0 : renderer.hashCode());
    return hash;
  }

  @NonNull
  @Override
  public String toString() {
    return "Span{"
        + "column="
        + column
        + ", style="
        + style
        + ", underline="
        + isUnderline()
        + ", underlineColor="
        + underlineColor
        + ", backgroundColorMy="
        + backgroundColorMy
        + ", problemFlags="
        + problemFlags
        + ", alpha="
        + alpha
        + ", alphacompat="
        + alphacompat
        + ", drawminiText='"
        + drawminiText
        + '\''
        + ", renderer="
        + renderer
        + '}';
  }

  public int getBackgroundColorMy() {
    return this.backgroundColorMy;
  }

  public void setBackgroundColorMy(int backgroundColorMy) {
    this.backgroundColorMy = backgroundColorMy;
  }

  public int getAlpha() {
    return this.alpha;
  }

  public void setAlpha(int alpha) {
    this.alpha = alpha;
  }

  public void setAlphaCompat(int alphacompat) {
    this.alphacompat = alphacompat;
  }

  public int getAlphacompat() {
    return this.alphacompat;
  }

  public String getDrawminiText() {
    return this.drawminiText;
  }

  public void setDrawminiText(String drawminiText) {
    this.drawminiText = drawminiText;
  }

  public void setUnderline(boolean underline) {
    if (underline) {
      style |= TextStyle.UNDERLINE_BIT;
    } else {
      style &= ~TextStyle.UNDERLINE_BIT;
    }
  }

  public boolean isUnderline() {
    return TextStyle.isUnderline(style);
  }

}
