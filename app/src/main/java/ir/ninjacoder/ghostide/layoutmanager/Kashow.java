package ir.ninjacoder.ghostide.layoutmanager;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.drawerlayout.widget.DrawerLayout;

public class Kashow extends DrawerLayout {
    private final Rect rect = new Rect();

    public Kashow(Context context) {
        super(context);
    }

    public Kashow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Kashow(Context context, AttributeSet attributeSet, int def) {
        super(context, attributeSet, def);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        View scrollingChild = findScrollingChild(this, ev.getX(), ev.getY());

        if (scrollingChild != null) {

            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    private View findScrollingChild(ViewGroup parent, float x, float y) {
        int n = parent.getChildCount();

        if (parent == this && n <= 1) {

            return null;
        }
        int start = 0;
        if (parent == this) {

            start = 1;
        }

        for (int i = start; i < n; i++) {

            View child = parent.getChildAt(i);

            if (child.getVisibility() != View.VISIBLE) {

                continue;
            }
            child.getHitRect(rect);

            if (rect.contains((int) x, (int) y)) {

                if (child.canScrollHorizontally(1)) {

                    return child;

                } else if (child instanceof ViewGroup) {

                    View v = findScrollingChild((ViewGroup) child, x - rect.left, y - rect.top);

                    if (v != null) {

                        return v;
                    }
                }
            }
        }
        return null;
    }
}
