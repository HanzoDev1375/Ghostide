package com.mcal.uidesigner.view;

import static com.mcal.uidesigner.utils.Utils.toHexColor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;

import com.mcal.uidesigner.common.AndroidHelper;

public class ColorPickerView extends View {
    private final int[] hueBarColors;
    private final int[] derivedColors;
    private int currentColor;
    private float currentHue;
    private int currentX;
    private int currentY;
    private int initialColor;
    private OnColorChangedListener listener;
    private Paint paint;
    private float scale;

    public ColorPickerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        currentHue = 0.0f;
        currentX = 0;
        currentY = 0;
        hueBarColors = new int[258];
        derivedColors = new int[65536];
        init();
    }

    public ColorPickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        currentHue = 0.0f;
        currentX = 0;
        currentY = 0;
        hueBarColors = new int[258];
        derivedColors = new int[65536];
        init();
    }

    public ColorPickerView(Context c) {
        super(c);
        currentHue = 0.0f;
        currentX = 0;
        currentY = 0;
        hueBarColors = new int[258];
        derivedColors = new int[65536];
        init();
    }

    public static int parseColor(String hexColor) {
        if (hexColor != null && hexColor.length() == 9 && hexColor.startsWith("#")) {
            return (int) Long.parseLong(hexColor.substring(1), 16);
        }
        if (hexColor == null || hexColor.length() != 7 || !hexColor.startsWith("#")) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        return -16777216 | ((int) Long.parseLong(hexColor.substring(1), 16));
    }

    private void init() {
        updateMainColors();
        Context c = getContext();
        scale = c.getResources().getDisplayMetrics().density * (Math.min(300.0f, AndroidHelper.getScreenSizeDip(c) - 150.0f) / 256.0f);
        paint = new Paint(1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(12.0f);
    }

    public void setCurrentColor(String hexColor) {
        currentColor = parseColor(hexColor);
        float[] hsv = new float[3];
        Color.colorToHSV(currentColor | ViewCompat.MEASURED_STATE_MASK, hsv);
        currentHue = hsv[0];
        updateDerivedColors();
        getCurrentXY();
        invalidate();
        listener.colorChanged(currentColor, toHexColor(currentColor));
    }

    public void setInitialColor(String hexColor) {
        initialColor = parseColor(hexColor);
    }

    public void setOnColorChangedListener(OnColorChangedListener l) {
        listener = l;
    }

    private void updateMainColors() {
        int index = 0;
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            hueBarColors[index] = Color.rgb(MotionEventCompat.ACTION_MASK, 0, (int) i);
            index++;
        }
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            hueBarColors[index] = Color.rgb(255 - ((int) i), 0, MotionEventCompat.ACTION_MASK);
            index++;
        }
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            hueBarColors[index] = Color.rgb(0, (int) i, MotionEventCompat.ACTION_MASK);
            index++;
        }
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            hueBarColors[index] = Color.rgb(0, MotionEventCompat.ACTION_MASK, 255 - ((int) i));
            index++;
        }
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            hueBarColors[index] = Color.rgb((int) i, MotionEventCompat.ACTION_MASK, 0);
            index++;
        }
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            hueBarColors[index] = Color.rgb(MotionEventCompat.ACTION_MASK, 255 - ((int) i), 0);
            index++;
        }
    }

    private void getCurrentXY() {
        int minDist = 1000;
        for (int x = 0; x < 256; x++) {
            for (int y = 0; y < 256; y++) {
                int dist = getColorDist(getDerivedColorForXY(x, y), currentColor | ViewCompat.MEASURED_STATE_MASK);
                if (dist == 0) {
                    currentX = x;
                    currentY = y;
                    return;
                }
                if (dist < minDist) {
                    currentX = x;
                    currentY = y;
                    minDist = dist;
                }
            }
        }
    }

    private int getColorDist(int c1, int c2) {
        return Math.abs(Color.red(c1) - Color.red(c2)) + Math.abs(Color.green(c1) - Color.green(c2)) + Math.abs(Color.blue(c1) - Color.blue(c2));
    }

    @SuppressLint("RestrictedApi")
    private int getCurrentMainColor() {
        int translatedHue = 255 - ((int) ((currentHue * 255.0f) / 360.0f));
        int index = 0;
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            if (index == translatedHue) {
                return Color.rgb(MotionEventCompat.ACTION_MASK, 0, (int) i);
            }
            index++;
        }
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            if (index == translatedHue) {
                return Color.rgb(255 - ((int) i), 0, MotionEventCompat.ACTION_MASK);
            }
            index++;
        }
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            if (index == translatedHue) {
                return Color.rgb(0, (int) i, MotionEventCompat.ACTION_MASK);
            }
            index++;
        }
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            if (index == translatedHue) {
                return Color.rgb(0, MotionEventCompat.ACTION_MASK, 255 - ((int) i));
            }
            index++;
        }
        for (float i = 0.0f; i < 256.0f; i += 6.0f) {
            if (index == translatedHue) {
                return Color.rgb((int) i, MotionEventCompat.ACTION_MASK, 0);
            }
            index++;
        }
        for (float i6 = 0.0f; i6 < 256.0f; i6 += 6.0f) {
            if (index == translatedHue) {
                return Color.rgb(MotionEventCompat.ACTION_MASK, 255 - ((int) i6), 0);
            }
            index++;
        }
        return SupportMenu.CATEGORY_MASK;
    }

    private void updateDerivedColors() {
        int mainColor = getCurrentMainColor();
        int index = 0;
        int[] topColors = new int[256];
        for (int y = 0; y < 256; y++) {
            for (int x = 0; x < 256; x++) {
                if (y == 0) {
                    derivedColors[index] = Color.rgb(255 - (((255 - Color.red(mainColor)) * x) / MotionEventCompat.ACTION_MASK), 255 - (((255 - Color.green(mainColor)) * x) / MotionEventCompat.ACTION_MASK), 255 - (((255 - Color.blue(mainColor)) * x) / MotionEventCompat.ACTION_MASK));
                    topColors[x] = derivedColors[index];
                } else {
                    derivedColors[index] = Color.rgb(((255 - y) * Color.red(topColors[x])) / MotionEventCompat.ACTION_MASK, ((255 - y) * Color.green(topColors[x])) / MotionEventCompat.ACTION_MASK, ((255 - y) * Color.blue(topColors[x])) / MotionEventCompat.ACTION_MASK);
                }
                index++;
            }
        }
    }

    private int getDerivedColorForXY(int x, int y) {
        int index = (y * 256) + x;
        if (index < 0 || index >= derivedColors.length) {
            return 0;
        }
        return derivedColors[index];
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        int translatedHue = 255 - ((int) ((currentHue * 255.0f) / 360.0f));
        for (int i = 0; i < 256; i++) {
            paint.setStrokeWidth(2.0f * scale);
            paint.setColor(hueBarColors[i]);
            canvas.drawLine(((float) (i + 10)) * scale, 0.0f, ((float) (i + 10)) * scale, 40.0f * scale, paint);
        }
        paint.setStrokeWidth(3.0f * scale);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawLine(((float) (translatedHue + 10)) * scale, 0.0f, ((float) (translatedHue + 10)) * scale, 40.0f * scale, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStrokeWidth(1.0f);
        canvas.drawRect(9.5f * scale, 0.0f * scale, 266.5f * scale, 40.0f * scale, paint);
        for (int i2 = 0; i2 < 256; i2++) {
            paint.setShader(new LinearGradient(0.0f, 50.0f * scale, 0.0f, 306.0f * scale, new int[]{derivedColors[i2], ViewCompat.MEASURED_STATE_MASK}, null, Shader.TileMode.REPEAT));
            paint.setStrokeWidth(2.0f * scale);
            canvas.drawLine(((float) (i2 + 10)) * scale, 50.0f * scale, ((float) (i2 + 10)) * scale, 306.0f * scale, paint);
        }
        paint.setShader(null);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStrokeWidth(2.0f * scale);
        canvas.drawCircle(((float) (currentX + 10)) * scale, ((float) (currentY + 50)) * scale, 6.0f * scale, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStrokeWidth(1.0f);
        canvas.drawRect(9.5f * scale, 50.0f * scale, 266.5f * scale, 306.0f * scale, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(currentColor | ViewCompat.MEASURED_STATE_MASK);
        canvas.drawRect(9.5f * scale, 316.0f * scale, 139.0f * scale, 356.0f * scale, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(initialColor | ViewCompat.MEASURED_STATE_MASK);
        canvas.drawRect(138.0f * scale, 316.0f * scale, 266.5f * scale, 356.0f * scale, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStrokeWidth(1.0f);
        canvas.drawRect(9.5f * scale, 316.0f * scale, 266.5f * scale, 356.0f * scale, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int) (276.0f * scale), (int) (366.0f * scale));
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        if (event.getAction() == 0 || event.getAction() == 2) {
            float x = (event.getX() / scale) - 10.0f;
            if (x < 0.0f) {
                x = 0.0f;
            }
            if (x > 255.0f) {
                x = 255.0f;
            }
            float y = event.getY() / scale;
            if (y < 40.0f) {
                currentHue = ((255.0f - x) * 360.0f) / 255.0f;
                updateDerivedColors();
            } else {
                currentX = (int) x;
                currentY = ((int) y) - 50;
                if (currentY < 0) {
                    currentY = 0;
                }
                if (currentY > 255) {
                    currentY = MotionEventCompat.ACTION_MASK;
                }
            }
            int color = getDerivedColorForXY(currentX, currentY);
            currentColor = Color.argb(Color.alpha(currentColor), Color.red(color), Color.green(color), Color.blue(color));
            listener.colorChanged(currentColor, toHexColor(currentColor));
            invalidate();
        }
        return true;
    }

    public interface OnColorChangedListener {
        void colorChanged(int i, String str);
    }
}
