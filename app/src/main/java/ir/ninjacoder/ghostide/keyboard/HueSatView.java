/*
 * Copyright (C) 2015 Martin Stone
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ir.ninjacoder.ghostide.keyboard;

import android.content.Context;
import android.graphics.*;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

public class HueSatView extends SquareView implements ColorObserver {

    // Bitmap is generated once and shared across instances.
    private static Bitmap bitmap;
    private final Paint borderPaint;
    private final Paint pointerPaint;
    private final Path pointerPath;
    private final Path borderPath;
    private final Rect viewRect = new Rect();
    private final PointF pointer = new PointF();
    private int w;
    private int h;
    private ObservableColor observableColor = new ObservableColor(0);

    public HueSatView(Context context) {
        this(context, null);
    }

    public HueSatView(Context context, AttributeSet attrs) {
        super(context, attrs);

        borderPaint = Resources.makeLinePaint(context);
        pointerPaint = Resources.makeLinePaint(context);
        pointerPaint.setColor(0xff000000);
        pointerPath = Resources.makePointerPath(context);
        borderPath = new Path();
        if (bitmap == null) {
            bitmap = makeBitmap(optimalBitmapSize());
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            // Need clipPath() and setLayerType()...
            throw new UnsupportedOperationException("Android API 10 and below is not supported.");
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            // clipPath() is only supported on a software layer.
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        }
    }

    private static void makeBorderPath(Path borderPath, int w, int h, float inset) {
        w -= inset;
        h -= inset;
        borderPath.reset();
        borderPath.moveTo(w, inset);
        borderPath.lineTo(w, h);
        borderPath.lineTo(inset, h);
        borderPath.addArc(new RectF(inset, inset, 2 * w, 2 * h), 180, 270);
        borderPath.close();
    }

    private static Bitmap makeBitmap(int radiusPx) {
        int[] colors = new int[radiusPx * radiusPx];
        float[] hsv = new float[]{0f, 0f, 1f};
        for (int y = 0; y < radiusPx; ++y) {
            for (int x = 0; x < radiusPx; ++x) {
                final int i = x + y * radiusPx;
                final float sat = satForPos(x, y, radiusPx);
                final float arcBleed = 2f / radiusPx; // extend curved edge pixels just outside clip area.
                if (sat <= 1 + arcBleed) {
                    hsv[0] = hueForPos(x, y, radiusPx);
                    hsv[1] = sat;
                    colors[i] = Color.HSVToColor(0xff, hsv);
                }
            }
        }
        return Bitmap.createBitmap(colors, radiusPx, radiusPx, Bitmap.Config.ARGB_8888);
    }

    private static float hueForPos(float x, float y, float radiusPx) {
        final double r = radiusPx - 1; // gives values 0...1 inclusive
        final double dx = (r - x) / r;
        final double dy = (r - y) / r;
        final double angle = Math.atan2(dy, dx);
        final double hue = 360 * angle / (Math.PI / 2);
        return (float) hue;
    }

    private static float satForPos(float x, float y, float radiusPx) {
        final double r = radiusPx - 1; // gives values 0...1 inclusive
        final double dx = (r - x) / r;
        final double dy = (r - y) / r;
        final double sat = dx * dx + dy * dy; // leave it squared -- exaggerates pale colors
        return (float) sat;
    }

    private static void setPointer(PointF pointer, float hue, float sat, float radiusPx) {
        final float r = radiusPx - 1; // for values 0...1 inclusive
        final double distance = r * Math.sqrt(sat);
        final double angle = hue / 360 * Math.PI / 2;
        final double dx = distance * Math.cos(angle);
        final double dy = distance * Math.sin(angle);
        pointer.set(r - (float) dx, r - (float) dy);
    }

    private int optimalBitmapSize() {
        final int scale = 2;
        final int maxBitmapSize = 128;
        final DisplayMetrics dm = getResources().getDisplayMetrics();
        return Math.min(maxBitmapSize, Math.min(dm.widthPixels, dm.heightPixels) / scale);
    }

    public void observeColor(ObservableColor observableColor) {
        this.observableColor = observableColor;
        observableColor.addObserver(this);
    }

    @Override
    public void updateColor(ObservableColor observableColor) {
        setPointer(pointer, observableColor.getHue(), observableColor.getSat(), w);
        optimisePointerColor();
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
        viewRect.set(0, 0, w, h);

        float inset = borderPaint.getStrokeWidth() / 2;
        makeBorderPath(borderPath, w, h, inset);

        // Sets pointer position
        updateColor(observableColor);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                boolean withinPicker = clamp(pointer, event.getX(), event.getY(), true);
                if (withinPicker) update();
                return withinPicker;
            case MotionEvent.ACTION_MOVE:
                clamp(pointer, event.getX(), event.getY(), false);
                update();
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
        }
        return super.onTouchEvent(event);
    }

    private void update() {
        observableColor.updateHueSat(
                hueForPos(pointer.x, pointer.y, w),
                satForPos(pointer.x, pointer.y, w),
                this);
        optimisePointerColor();
        invalidate();
    }

    private boolean clamp(PointF pointer, float x, float y, boolean rejectOutside) {
        x = Math.min(x, w);
        y = Math.min(y, h);
        final float dx = w - x;
        final float dy = h - y;
        final float r = (float) Math.sqrt(dx * dx + dy * dy);
        boolean outside = r > w;
        if (!outside || !rejectOutside) {
            if (outside) {
                x = w - dx * w / r;
                y = w - dy * w / r;
            }
            pointer.set(x, y);
        }
        return !outside;
    }

    private void optimisePointerColor() {
        pointerPaint.setColor(
                observableColor.getLightnessWithValue(1) > 0.5
                        ? 0xff000000 : 0xffffffff);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        canvas.clipPath(borderPath);
        canvas.drawBitmap(bitmap, null, viewRect, null);
        canvas.translate(pointer.x, pointer.y);
        canvas.drawPath(pointerPath, pointerPaint);

        canvas.restore();

        canvas.drawPath(borderPath, borderPaint);
    }
}
