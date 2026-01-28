package ir.ninjacoder.prograsssheet.search;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.style.LineBackgroundSpan;

public class RoundedBackgroundColorSpan implements LineBackgroundSpan {
  private static final float NO_INIT = -1.0F;

  private final RectF rect = new RectF();
  private final Paint paint = new Paint();
  private final Path path = new Path();

  private final float padding;
  private final float radius;

  private float prevWidth = NO_INIT;
  private float prevRight = NO_INIT;

  public RoundedBackgroundColorSpan(int backgroundColor, float padding, float radius) {
    this.padding = padding;
    this.radius = radius;

    paint.setColor(backgroundColor);
    paint.setAntiAlias(true);
  }

  @Override
  public void drawBackground(
      Canvas c,
      Paint p,
      int left,
      int right,
      int top,
      int baseline,
      int bottom,
      CharSequence text,
      int start,
      int end,
      int lineNumber) {
    float actualWidth = p.measureText(text, start, end) + 2.0F * padding;
    float widthDiff = Math.abs(prevWidth - actualWidth);
    boolean diffIsShort = widthDiff < 2.0F * radius;

    float width;
    if (lineNumber == 0) {
      width = actualWidth;
    } else if (actualWidth < prevWidth && diffIsShort) {
      width = prevWidth;
    } else if (actualWidth > prevWidth && diffIsShort) {
      width = actualWidth + (2.0F * radius - widthDiff);
    } else {
      width = actualWidth;
    }

    float shiftLeft = 0.0F - padding;
    float shiftRight = width + shiftLeft;

    rect.set(shiftLeft, (float) top, shiftRight, (float) bottom);

    c.drawRoundRect(rect, radius, radius, paint);

    if (lineNumber > 0) {
      drawLeftFillShape(c, rect, radius);

      if (prevWidth < width) {
        drawBottomFillShape(c, rect, radius);
      } else if (prevWidth > width) {
        drawTopFillShape(c, rect, radius);
      } else {
        drawRightFillShape(c, rect, radius);
      }
    }

    prevWidth = width;
    prevRight = rect.right;
  }

  private void drawLeftFillShape(Canvas c, RectF rect, float radius) {
    path.reset();
    path.moveTo(rect.left, rect.top + radius);
    path.lineTo(rect.left, rect.top - radius);
    path.lineTo(rect.left + radius, rect.top);
    path.lineTo(rect.left, rect.top + radius);

    c.drawPath(path, paint);
  }

  private void drawBottomFillShape(Canvas c, RectF rect, float radius) {
    path.reset();
    path.moveTo(prevRight + radius, rect.top);
    path.lineTo(prevRight - radius, rect.top);
    path.lineTo(prevRight, rect.top - radius);
    path.cubicTo(prevRight, rect.top - radius, prevRight, rect.top, prevRight + radius, rect.top);

    c.drawPath(path, paint);
  }

  private void drawTopFillShape(Canvas c, RectF rect, float radius) {
    path.reset();
    path.moveTo(rect.right + radius, rect.top);
    path.lineTo(rect.right - radius, rect.top);
    path.lineTo(rect.right, rect.top + radius);
    path.cubicTo(
        rect.right, rect.top + radius, rect.right, rect.top, rect.right + radius, rect.top);

    c.drawPath(path, paint);
  }

  private void drawRightFillShape(Canvas c, RectF rect, float radius) {
    path.reset();
    path.moveTo(rect.right, rect.top - radius);
    path.lineTo(rect.right, rect.top + radius);
    path.lineTo(rect.right - radius, rect.top);
    path.lineTo(rect.right, rect.top - radius);

    c.drawPath(path, paint);
  }
}

