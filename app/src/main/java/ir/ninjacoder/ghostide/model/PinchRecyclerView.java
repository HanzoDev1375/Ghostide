package ir.ninjacoder.ghostide.model;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author yogesh (https://stackoverflow.com/a/37895783/6591585)
 */
public class PinchRecyclerView extends RecyclerView implements View.OnTouchListener {
    private static final int INVALID_POINTER_ID = -1;
    private static final String TAG = PinchRecyclerView.class.getClass().getSimpleName();
    private int mActivePointerId = INVALID_POINTER_ID;
    private ScaleGestureDetector mScaleDetector;
    private float mScaleFactor = 1.f;
    private float maxWidth = 0.0f;
    private float maxHeight = 0.0f;
    private float mLastTouchX;
    private float mLastTouchY;
    private float mPosX;
    private float mPosY;
    private float width;
    private float height;
    private boolean mClickCandidate = false;

    public PinchRecyclerView(Context context) {
        this(context, null);
    }

    public PinchRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PinchRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
        if (!isInEditMode())
            mScaleDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = View.MeasureSpec.getSize(widthMeasureSpec);
        height = View.MeasureSpec.getSize(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            boolean resp = super.onInterceptTouchEvent(ev);
            Log.d(TAG, "onInterceptTouchEvent: " + resp);
            return resp;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent ev) {
        Log.d(TAG, "onTouchEvent");
        super.onTouchEvent(ev);
        final int action = ev.getAction();
        mScaleDetector.onTouchEvent(ev);
        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                final float x = ev.getX();
                final float y = ev.getY();
                mLastTouchX = x;
                mLastTouchY = y;
                mActivePointerId = ev.getPointerId(0);
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                final int pointerIndex =
                        (action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                                >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                final float x = ev.getX(pointerIndex);
                final float y = ev.getY(pointerIndex);
                final float dx = x - mLastTouchX;
                final float dy = y - mLastTouchY;

                mPosX += dx;
                mPosY += dy;

                if (mPosX > 0.0f) mPosX = 0.0f;
                else if (mPosX < maxWidth) mPosX = maxWidth;

                if (mPosY > 0.0f) mPosY = 0.0f;
                else if (mPosY < maxHeight) mPosY = maxHeight;

                mLastTouchX = x;
                mLastTouchY = y;

                invalidate();
                break;
            }

            case MotionEvent.ACTION_UP: {
                mActivePointerId = INVALID_POINTER_ID;
                break;
            }

            case MotionEvent.ACTION_CANCEL: {
                mActivePointerId = INVALID_POINTER_ID;
                break;
            }

            case MotionEvent.ACTION_POINTER_UP: {
                final int pointerIndex =
                        (action & MotionEvent.ACTION_POINTER_INDEX_MASK)
                                >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                final int pointerId = ev.getPointerId(pointerIndex);
                if (pointerId == mActivePointerId) {
                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    mLastTouchX = ev.getX(newPointerIndex);
                    mLastTouchY = ev.getY(newPointerIndex);
                    mActivePointerId = ev.getPointerId(newPointerIndex);
                }
                break;
            }
        }

        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(mPosX, mPosY);
        canvas.scale(mScaleFactor, mScaleFactor);
        canvas.restore();
    }

    private float getScaleFactor() {
        return mScaleFactor;
    }

    private float getPosX() {
        return mPosX;
    }

    private float getPosY() {
        return mPosY;
    }

    @Override
    protected void dispatchDraw(@NonNull Canvas canvas) {
        canvas.save();
        if (mScaleFactor == 1.0f) {
            mPosX = 0.0f;
            mPosY = 0.0f;
        }
        canvas.translate(mPosX, mPosY);
        canvas.scale(mScaleFactor, mScaleFactor);
        super.dispatchDraw(canvas);
        canvas.restore();
        invalidate();
    }

    // Map what appeared to be clicked in the potentially zoomed view back to the scale = 1 view.
    private View getMappedView(float x, float y) {
        final int NO_POSITION = -1;
        View expectedView = null;
        View scanView;
        final int mappedX = (int) (getWidth() * (x - getPosX()) / (getWidth() * getScaleFactor()));
        final int mappedY = (int) (getHeight() * (y - getPosY()) / (getHeight() * getScaleFactor()));
        int foundColumn = NO_POSITION;
        int lastLeft = NO_POSITION;

        // Look for the column of the expected view.
        for (int i = 0; i < getChildCount() && foundColumn == NO_POSITION; i++) {
            scanView = getChildAt(i);
            int thisLeft = scanView.getLeft();
            if ((mappedX <= scanView.getRight()) && (mappedX >= thisLeft)) {
                foundColumn = i;
            }
            if (thisLeft < lastLeft) { // Wrapped around. Touch outside of our area.
                break;
            }
            lastLeft = scanView.getLeft();
        }
        if (foundColumn == NO_POSITION) {
            return null;
        }

        // Find out how many columns we have.
        int colCount = foundColumn;
        while (++colCount < getChildCount()) {
            if (getChildAt(colCount).getLeft() <= lastLeft) {
                break;
            }
        }

        // Look for the row.
        for (int i = foundColumn; i < getChildCount(); i += colCount) {
            scanView = getChildAt(i);
            if ((mappedY >= scanView.getTop()) && (mappedY <= scanView.getBottom())) {
                expectedView = scanView;
                break;
            }
        }
        return expectedView;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mClickCandidate = true;
                break;

            case MotionEvent.ACTION_MOVE:
                mClickCandidate = false;
                break;

            case MotionEvent.ACTION_UP:
                if (mClickCandidate) {
                    View v = getMappedView(event.getX() + view.getLeft(), event.getY() + view.getTop());
                    if (v != null && v.hasOnClickListeners()) {
                        v.performClick();
                    }
                    mClickCandidate = false;
                }
                return true;
        }
        return false;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            mScaleFactor *= detector.getScaleFactor();
            mScaleFactor = Math.max(1.0f, Math.min(mScaleFactor, 3.0f));
            maxWidth = width - (width * mScaleFactor);
            maxHeight = height - (height * mScaleFactor);
            invalidate();
            return true;
        }
    }
}
