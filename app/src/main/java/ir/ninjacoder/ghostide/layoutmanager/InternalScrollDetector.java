package ir.ninjacoder.ghostide.layoutmanager;

import android.view.MotionEvent;

public class InternalScrollDetector {
    private static final int INVALID_POINTER = -1;
    private boolean isScrolling = false;
    private boolean pageScrollChangedWhileScrolling = false;
    private Float initialX = null;
    private Float initialY = null;
    private int activePointerId = INVALID_POINTER;

    private boolean isEnabled = true;

    public void setEnabled(boolean enabled) {
        if (isEnabled != enabled) {
            reset();
        }
        isEnabled = enabled;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled) {
            return false;
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                reset();
                initialX = event.getX();
                initialY = event.getY();
                activePointerId = event.getPointerId(0);
                return false;
            case MotionEvent.ACTION_MOVE:
                int activePointerIndex = event.findPointerIndex(activePointerId);
                Float initialEventY = initialY;
                Float initialEventX = initialX;
                if (activePointerIndex == -1 || initialEventY == null || initialEventX == null) {
                    return false;
                } else {
                    float y = event.getY(activePointerIndex);
                    float x = event.getX(activePointerIndex);
                    float deltaY = initialEventY - y;
                    float deltaX = initialEventX - x;
                    boolean anyMovement = deltaX != 0f || deltaY != 0f;
                    if (!isScrolling && anyMovement) {
                        isScrolling = true;
                    }
                    return isInternalScroll();
                }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                boolean internalScroll = isInternalScroll();
                reset();
                return internalScroll;
            default:
                return false;
        }
    }

    public void onPageScrolled() {
        if (isEnabled && isScrolling) {
            pageScrollChangedWhileScrolling = true;
        }
    }

    private void reset() {
        initialX = null;
        initialY = null;
        activePointerId = INVALID_POINTER;
        isScrolling = false;
        pageScrollChangedWhileScrolling = false;
    }

    private boolean isInternalScroll() {
        return isScrolling && !pageScrollChangedWhileScrolling;
    }
}
