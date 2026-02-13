// Inlay.java - رفع خطا
package io.github.rosemoe.sora.model;

import android.graphics.RectF;

public class Inlay {
  final int end;
  final int backgroundColor;
  final int textColor;
  final InlayAlign align; // تغییر از aling به align
  final String text;
  final String id;
  final boolean isBlock;
  RectF drawingRect;

  public Inlay(int end, int backgroundColor, int textColor, InlayAlign align, String text) {
    this(end, backgroundColor, textColor, align, text, null, false);
  }

  public Inlay(
      int end,
      int backgroundColor,
      int textColor,
      InlayAlign align,
      String text,
      String id,
      boolean isBlock) {
    this.end = end;
    this.backgroundColor = backgroundColor;
    this.textColor = textColor;
    this.align = align != null ? align : InlayAlign.LEFT; // اصلاح شده
    this.text = text;
    this.id = id != null ? id : java.util.UUID.randomUUID().toString();
    this.isBlock = isBlock;
    this.drawingRect = new RectF();
  }

  public int getEnd() {
    return this.end;
  }

  public int getBackgroundColor() {
    return this.backgroundColor;
  }

  public int getTextColor() {
    return this.textColor;
  }

  public InlayAlign getAlign() {
    return this.align;
  } // اصلاح شده

  public String getText() {
    return this.text;
  }

  public String getId() {
    return id;
  }

  public boolean isBlock() {
    return isBlock;
  }

  public RectF getDrawingRect() {
    return drawingRect;
  }

  public void setDrawingRect(RectF rect) {
    this.drawingRect.set(rect);
  }
}
