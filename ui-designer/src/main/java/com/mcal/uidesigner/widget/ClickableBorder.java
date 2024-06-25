package com.mcal.uidesigner.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

@SuppressLint("ViewConstructor")
public class ClickableBorder extends LinearLayout {
    private final float radius;
    private final Paint thickPaint;
    private final Paint thinPaint;
    private boolean down;
    private boolean visible = true;

    public ClickableBorder(Context context, View view) {
        super(context);
        if (view != null) {
            addView(view, new LinearLayout.LayoutParams(-1, -1));
        }
        setWillNotDraw(false);
        setClipChildren(false);
        setEnabled(true);
        setFocusable(true);
        setOnClickListener(v -> ClickableBorder.this.onClicked());
        this.thinPaint = new Paint();
        this.thinPaint.setStyle(Paint.Style.STROKE);
        this.thinPaint.setColor(-5592406);
        this.thinPaint.setStrokeWidth(1.0f);
        this.thinPaint.setPathEffect(new DashPathEffect(new float[]{10.0f, 5.0f}, 0.0f));
        this.thickPaint = new Paint();
        this.thickPaint.setStyle(Paint.Style.STROKE);
        this.thickPaint.setColor(-13388315);
        this.thickPaint.setStrokeWidth(6.0f * getResources().getDisplayMetrics().density);
        this.radius = 2.0f * getResources().getDisplayMetrics().density;
    }

    @Override
    public View focusSearch(int direction) {
        if (direction == 130) {
            if (getChildCount() > 0 && (getChildAt(0) instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) getChildAt(0);
                if (viewGroup.getChildCount() > 0 && (viewGroup.getChildAt(0) instanceof ClickableBorder)) {
                    return viewGroup.getChildAt(0);
                }
            }
        } else if (direction == 33 && (getParent().getParent() instanceof ClickableBorder)) {
            ViewGroup parent = (ViewGroup) getParent().getParent();
            if (((ViewGroup) parent.getChildAt(0)).getChildAt(0) == this) {
                return parent;
            }
        }
        return super.focusSearch(direction);
    }

    protected void onClicked() {
    }

    public void setIsVisible(boolean visible) {
        this.visible = visible;
        invalidate();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.visible) {
            return;
        }
        if (this.down || isFocused()) {
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) (getWidth() - 1), (float) (getHeight() - 1)), this.radius, this.radius, this.thickPaint);
        } else {
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) (getWidth() - 1), (float) (getHeight() - 1)), this.radius, this.radius, this.thinPaint);
        }
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (getParent() instanceof View) {
            ((View) getParent()).invalidate();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        View child = getChildAt(0);
        if (!(child instanceof ViewGroup) || (child instanceof AdapterView)) {
            return true;
        }
        return false;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isEnabled()) {
            if (event.getAction() == 0) {
                this.down = true;
                repaint();
                postDelayed(() -> {
                    if (down) {
                        down = false;
                        repaint();
                    }
                }, 1000);
            }
            if (event.getAction() == 1 && this.down) {
                this.down = false;
                repaint();
            }
        }
        return super.onTouchEvent(event);
    }

    public void repaint() {
        invalidate(-10, -10, getWidth() + 10, getHeight() + 10);
    }
}
