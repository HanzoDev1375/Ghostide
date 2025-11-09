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
package io.github.rosemoe.sora.widget;

/**
 * This class is used to control cursor visibility
 *
 * @author Rose & Ghost
 */

// برای دست رسی کلاس رو عمومی میکنیم
public class CursorBlink implements Runnable {

  final CodeEditor editor;
  long lastSelectionModificationTime = 0;
  long lastTypingTime = 0;
  int period;
  boolean visibility;
  boolean valid;
  private float[] buffer;

  // متغیرهای انیمیشن
  private CursorAnimationModel model = CursorAnimationModel.BLINK;
  private float animationValue = 1.0f;
  private boolean increasing = false;

  CursorBlink(CodeEditor editor, int period) {
    visibility = true;
    this.editor = editor;
    this.period = period;
  }

  public void setModel(CursorAnimationModel model) {
    this.model = model;
    this.animationValue = 1.0f;
    this.increasing = false;
    // برای BLINK باید visibility رو ریست کنیم
    if (model == CursorAnimationModel.BLINK) {
      visibility = true;
    }
    onSelectionChanged();
  }

  void setPeriod(int period) {
    this.period = period;
    if (period <= 0) {
      visibility = true;
      valid = false;
    } else {
      valid = true;
    }
  }

  void onSelectionChanged() {
    lastSelectionModificationTime = System.currentTimeMillis();
    lastTypingTime = System.currentTimeMillis();
    visibility = true;
    animationValue = 1.0f;
    increasing = false;
  }

  void onTyping() {
    lastTypingTime = System.currentTimeMillis();
    if (model == CursorAnimationModel.TYPING) {
      visibility = true;
      animationValue = 1.0f;
    }
  }

  boolean isSelectionVisible() {
    if (buffer == null) {
      buffer = new float[2];
    }
    buffer =
        editor.mLayout.getCharLayoutOffset(
            editor.getCursor().getLeftLine(), editor.getCursor().getLeftColumn(), buffer);
    return (buffer[0] >= editor.getOffsetY()
        && buffer[0] - editor.getRowHeight() <= editor.getOffsetY() + editor.getHeight()
        && buffer[1] >= editor.getOffsetX()
        && buffer[1] - 100f <= editor.getOffsetX() + editor.getWidth());
  }

  @Override
  public void run() {
    if (!valid || period <= 0) {
      visibility = true;
      animationValue = 1.0f;
      return;
    }

    long currentTime = System.currentTimeMillis();
    long timeSinceLastAction = currentTime - lastSelectionModificationTime;

    // فقط اگر کاربر فعال نباشد انیمیشن اجرا شود
    if (timeSinceLastAction >= period) {
      updateAnimation();

      if (!editor.getCursor().isSelected() && isSelectionVisible()) {
        invalidateCursorRegion();
      }
    } else {
      // کاربر فعال است - کورسور کامل نشان داده شود
      animationValue = 1.0f;
      visibility = true;
    }

    editor.postDelayed(this, period); // با دوره اصلی
  }

  private void updateAnimation() {
    switch (model) {
      case BLINK:
        handleBlinkAnimation();
        break;
      case SMOOTH:
        handleSmoothAnimation();
        break;
      case PULSE:
        handlePulseAnimation();
        break;
      case EXPAND:
        handleExpandAnimation();
        break;
      case TYPING:
        handleTypingAnimation();
        break;
    }
  }

  private void handleBlinkAnimation() {
    // حالت سنتی اصلی - دقیقاً مثل قبل
    if (System.currentTimeMillis() - lastSelectionModificationTime >= period * 2L) {
      visibility = !visibility;
    }
    animationValue = 1.0f; // همیشه کامل
  }

  private void handleSmoothAnimation() {
    // فیدینگ نرم
    visibility = true;
    if (increasing) {
      animationValue += 0.08f;
      if (animationValue >= 1.0f) {
        animationValue = 1.0f;
        increasing = false;
      }
    } else {
      animationValue -= 0.05f;
      if (animationValue <= 0.3f) {
        animationValue = 0.3f;
        increasing = true;
      }
    }
  }

  private void handlePulseAnimation() {
    // اثر پالسی با سینوس
    visibility = true;
    animationValue = (float) ((Math.sin(System.currentTimeMillis() * 0.01f) + 1.0f) * 0.5f);
    animationValue = 0.4f + animationValue * 0.6f;
  }

  private void handleExpandAnimation() {
    // انبساط و انقباض
    visibility = true;
    if (increasing) {
      animationValue += 0.1f;
      if (animationValue >= 1.5f) {
        animationValue = 1.5f;
        increasing = false;
      }
    } else {
      animationValue -= 0.1f;
      if (animationValue <= 0.7f) {
        animationValue = 0.7f;
        increasing = true;
      }
    }
  }

  private void handleTypingAnimation() {
    // فقط هنگام تایپ نشان داده شود
    long timeSinceLastTyping = System.currentTimeMillis() - lastTypingTime;
    if (timeSinceLastTyping > 1000) {
      if (System.currentTimeMillis() - lastSelectionModificationTime >= period * 2L) {
        visibility = !visibility;
      }
      animationValue = 1.0f;
    } else {
      visibility = true;
      animationValue = 1.0f;
    }
  }

  private void invalidateCursorRegion() {
    if (buffer == null) {
      buffer = new float[2];
    }
    buffer =
        editor.mLayout.getCharLayoutOffset(
            editor.getCursor().getLeftLine(), editor.getCursor().getLeftColumn(), buffer);

    var delta = (int) (editor.getDpUnit() * 10);
    var l = (int) buffer[1] - delta;
    var r = l + delta * 2;
    var b = (int) buffer[0] + delta;
    var t = b - delta * 2;
    editor.postInvalidate(l, t, r, b);
  }

  // متدهای کمکی
  public float getAnimationValue() {
    return animationValue;
  }

  public CursorAnimationModel getModel() {
    return model;
  }

  public boolean shouldDrawCursor() {
    return visibility;
  }

  public float getCursorScale() {
    return model == CursorAnimationModel.EXPAND ? animationValue : 1.0f;
  }

  public float getCursorAlpha() {
    return model == CursorAnimationModel.SMOOTH ? animationValue : 1.0f;
  }

  public float getCursorWidthFactor() {
    return model == CursorAnimationModel.PULSE ? animationValue : 1.0f;
  }
}
