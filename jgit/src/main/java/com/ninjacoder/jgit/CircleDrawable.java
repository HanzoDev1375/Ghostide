package com.ninjacoder.jgit;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.content.res.Resources;

public class CircleDrawable extends Drawable {
  private Paint mPaint;
  private Paint mTextPaint;
  private boolean mCircle;
  private String name;

  public CircleDrawable(int kind, boolean circle, String name) {
    mCircle = circle;
    this.name = name;
    mPaint = new Paint();
    mPaint.setAntiAlias(true);
    mPaint.setColor(kind);

    mTextPaint = new Paint();
    mTextPaint.setColor(Color.BLACK); // معادل -0x1
    mTextPaint.setAntiAlias(true);
    mTextPaint.setTextSize(Resources.getSystem().getDisplayMetrics().density * 14);
    mTextPaint.setTextAlign(Paint.Align.CENTER);
  }

  @Override
  public void draw(Canvas canvas) {
    float width = getBounds().right;
    float height = getBounds().bottom;

    if (mCircle) {
      int ir = name.equals("v") ? 1 : name.equals("m") ? 2 : 4;
      float radius = Math.min(width, height) / ir;
      canvas.drawRoundRect(0f, 0f, width, height, radius, radius, mPaint);
    } else {
      canvas.drawRect(0f, 0f, width, height, mPaint);
    }

    // متن
    canvas.save();
    canvas.translate(width / 2f, height / 2f);
    float textCenter = -(mTextPaint.descent() + mTextPaint.ascent()) / 2f;
    canvas.drawText(name.substring(0, 1), 0f, textCenter, mTextPaint);
    canvas.restore();
  }

  @Override
  public void setAlpha(int alpha) {
    mPaint.setAlpha(alpha);
    mTextPaint.setAlpha(alpha);
  }

  @Override
  public void setColorFilter(ColorFilter colorFilter) {
    mTextPaint.setColorFilter(colorFilter);
  }

  @Override
  public int getOpacity() {
    return PixelFormat.OPAQUE;
  }
}
