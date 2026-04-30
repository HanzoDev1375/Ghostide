package com.mcal.uidesigner.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;

@SuppressLint("ViewConstructor")
public class StudioSelectionBorder extends FrameLayout {

  private static final int BLUE = 0xFF1976D2;
  private static final int LIGHT_BLUE = 0xFF64B5F6;
  private static final int CORNER_SIZE_DP = 6;
  private static final int BORDER_WIDTH_DP = 1;
  private static final int MARGIN_COLOR = 0x40FF9800;
  private static final int PADDING_COLOR = 0x4034A853;

  private final Paint borderPaint;
  private final Paint cornerPaint;
  private final Paint marginPaint;
  private final Paint paddingPaint;
  private final float cornerSize;
  private final float borderWidth;
  private final float density;

  private boolean isSelected = false;
  private boolean showSelection = true;

  public StudioSelectionBorder(Context context, View contentView) {
    super(context);
    this.density = context.getResources().getDisplayMetrics().density;
    this.cornerSize = CORNER_SIZE_DP * density;
    this.borderWidth = BORDER_WIDTH_DP * density;

    borderPaint = new Paint();
    borderPaint.setStyle(Paint.Style.STROKE);
    borderPaint.setColor(LIGHT_BLUE);
    borderPaint.setStrokeWidth(borderWidth);
    borderPaint.setAntiAlias(true);

    cornerPaint = new Paint();
    cornerPaint.setStyle(Paint.Style.FILL);
    cornerPaint.setColor(BLUE);
    cornerPaint.setAntiAlias(true);

    marginPaint = new Paint();
    marginPaint.setStyle(Paint.Style.FILL);
    marginPaint.setColor(MARGIN_COLOR);

    paddingPaint = new Paint();
    paddingPaint.setStyle(Paint.Style.FILL);
    paddingPaint.setColor(PADDING_COLOR);

    setWillNotDraw(false);
    setClipChildren(false);
    setClipToPadding(false);

    if (contentView != null) {
      addView(contentView, new LayoutParams(-1, -1));
    }

    setOnClickListener(v -> onViewClicked());
  }

  public void setSelected(boolean selected) {
    this.isSelected = selected;
    invalidate();
  }

  public void setShowSelection(boolean show) {
    this.showSelection = show;
    invalidate();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    if (!showSelection || getChildCount() == 0) return;

    View contentView = getChildAt(0);
    if (contentView == null) return;

    Rect marginRect = calculateMarginRect(contentView);

    Rect paddingRect = calculatePaddingRect(contentView);

    Rect viewRect =
        new Rect(
            contentView.getLeft(),
            contentView.getTop(),
            contentView.getRight(),
            contentView.getBottom());

    if (isSelected) {

      drawMargin(canvas, marginRect, viewRect);

      drawPadding(canvas, paddingRect, marginRect);

      drawBorder(canvas, viewRect);

      drawCorners(canvas, viewRect);
    }
  }

  private Rect calculateMarginRect(View view) {
    ViewGroup.LayoutParams params = view.getLayoutParams();
    if (params instanceof ViewGroup.MarginLayoutParams) {
      ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) params;
      return new Rect(
          view.getLeft() - marginParams.leftMargin,
          view.getTop() - marginParams.topMargin,
          view.getRight() + marginParams.rightMargin,
          view.getBottom() + marginParams.bottomMargin);
    }
    return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
  }

  private Rect calculatePaddingRect(View view) {
    return new Rect(
        view.getLeft() + view.getPaddingLeft(),
        view.getTop() + view.getPaddingTop(),
        view.getRight() - view.getPaddingRight(),
        view.getBottom() - view.getPaddingBottom());
  }

  private void drawMargin(Canvas canvas, Rect marginRect, Rect viewRect) {

    canvas.drawRect(marginRect.left, marginRect.top, marginRect.right, viewRect.top, marginPaint);

    canvas.drawRect(
        marginRect.left, viewRect.bottom, marginRect.right, marginRect.bottom, marginPaint);

    canvas.drawRect(marginRect.left, viewRect.top, viewRect.left, viewRect.bottom, marginPaint);

    canvas.drawRect(viewRect.right, viewRect.top, marginRect.right, viewRect.bottom, marginPaint);
  }

  private void drawPadding(Canvas canvas, Rect paddingRect, Rect marginRect) {

    canvas.drawRect(
        marginRect.left, marginRect.top, marginRect.right, paddingRect.top, paddingPaint);

    canvas.drawRect(
        marginRect.left, paddingRect.bottom, marginRect.right, marginRect.bottom, paddingPaint);

    canvas.drawRect(
        marginRect.left, paddingRect.top, paddingRect.left, paddingRect.bottom, paddingPaint);

    canvas.drawRect(
        paddingRect.right, paddingRect.top, marginRect.right, paddingRect.bottom, paddingPaint);
  }

  private void drawBorder(Canvas canvas, Rect rect) {
    RectF rectF =
        new RectF(
            rect.left + borderWidth / 2,
            rect.top + borderWidth / 2,
            rect.right - borderWidth / 2,
            rect.bottom - borderWidth / 2);
    canvas.drawRect(rectF, borderPaint);
  }

  private void drawCorners(Canvas canvas, Rect rect) {

    float[][] corners = {
      {rect.left, rect.top},
      {rect.right, rect.top},
      {rect.left, rect.bottom},
      {rect.right, rect.bottom},
      {(rect.left + rect.right) / 2, rect.top},
      {(rect.left + rect.right) / 2, rect.bottom},
      {rect.left, (rect.top + rect.bottom) / 2},
      {rect.right, (rect.top + rect.bottom) / 2}
    };

    for (float[] corner : corners) {
      canvas.drawRect(
          corner[0] - cornerSize / 2,
          corner[1] - cornerSize / 2,
          corner[0] + cornerSize / 2,
          corner[1] + cornerSize / 2,
          cornerPaint);
    }
  }

  protected void onViewClicked() {}

  @Override
  public boolean onInterceptTouchEvent(MotionEvent event) {
    View child = getChildAt(0);
    if (!(child instanceof ViewGroup) || child instanceof AdapterView) {
      return true;
    }
    return false;
  }
}
