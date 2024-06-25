package Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.EdgeEffectCompat;


public class BouncyView extends View {
    private EdgeEffectCompat edgeEffectTop;
    private EdgeEffectCompat edgeEffectBottom;
    private float lastTouchY;

    public BouncyView(Context context) {
        super(context);
        init();
    }

    public BouncyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BouncyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        edgeEffectTop = new EdgeEffectCompat(getContext());
        edgeEffectBottom = new EdgeEffectCompat(getContext());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float currentY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastTouchY = currentY;
                break;
            case MotionEvent.ACTION_MOVE:
                float deltaY = currentY - lastTouchY;
                scrollBy(0, (int) -deltaY);
                lastTouchY = currentY;
                updateEdgeEffects();
                break;
            case MotionEvent.ACTION_UP:
                if (getScrollY() != 0) {
                    edgeEffectTop.onRelease();
                    edgeEffectBottom.onRelease();
                }
                break;
        }

        return true;
    }

    private void updateEdgeEffects() {
        int height = getHeight();
        int scrollY = getScrollY();

        if (scrollY < 0) {
            edgeEffectTop.onPull(-scrollY / (float) height);
        } else if (scrollY > 0) {
            edgeEffectBottom.onPull(scrollY / (float) height);
        }

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!edgeEffectTop.isFinished()) {
            int restoreCount = canvas.save();
            canvas.translate(0, getScrollY());
            edgeEffectTop.setSize(getWidth(), getHeight());
            if (edgeEffectTop.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(restoreCount);
        }

        if (!edgeEffectBottom.isFinished()) {
            int restoreCount = canvas.save();
            canvas.translate(0, getScrollY() + getHeight());
            canvas.rotate(180, getWidth() / 2f, 0);
            edgeEffectBottom.setSize(getWidth(), getHeight());
            if (edgeEffectBottom.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(restoreCount);
        }
    }
}
