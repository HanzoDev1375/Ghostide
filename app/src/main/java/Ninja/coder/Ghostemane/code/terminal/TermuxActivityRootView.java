package Ninja.coder.Ghostemane.code.terminal;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import androidx.annotation.Nullable;
import androidx.core.view.WindowInsetsCompat;


public class TermuxActivityRootView extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    public TerminalActivity mActivity;
    public Integer marginBottom;
    public Integer lastMarginBottom;
    public long lastMarginBottomTime;
    public long lastMarginBottomExtraTime;

    private boolean ROOT_VIEW_LOGGING_ENABLED = false;

    private static final String LOG_TAG = "TermuxActivityRootView";

    private static int mStatusBarHeight;

    public TermuxActivityRootView(Context context) {
        super(context);
    }

    public TermuxActivityRootView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TermuxActivityRootView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setActivity(TerminalActivity activity) {
        mActivity = activity;
    }

    public void setIsRootViewLoggingEnabled(boolean value) {
        ROOT_VIEW_LOGGING_ENABLED = value;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (marginBottom != null) {
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            layoutParams.setMargins(0, 0, 0, marginBottom);
            setLayoutParams(layoutParams);
            marginBottom = null;
            requestLayout();
        }
    }

    @Override
    public void onGlobalLayout() {
        if (mActivity == null || !mActivity.isVisible()) return;

        View bottomSpaceView = mActivity.getTermuxActivityBottomSpaceView();
        if (bottomSpaceView == null) return;

        boolean root_view_logging_enabled = ROOT_VIEW_LOGGING_ENABLED;

        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();

        Rect[] windowAndViewRects = ViewUtils.getWindowAndViewRects(bottomSpaceView, mStatusBarHeight);
        if (windowAndViewRects == null) return;

        Rect windowAvailableRect = windowAndViewRects[0];
        Rect bottomSpaceViewRect = windowAndViewRects[1];

        boolean isVisible = ViewUtils.isRectAbove(windowAvailableRect, bottomSpaceViewRect);
        boolean isVisibleBecauseMargin = (windowAvailableRect.bottom == bottomSpaceViewRect.bottom) && params.bottomMargin > 0;
        boolean isVisibleBecauseExtraMargin = ((bottomSpaceViewRect.bottom - windowAvailableRect.bottom) < 0);

        if (isVisible) {
            if (isVisibleBecauseMargin) {
                if ((System.currentTimeMillis() - lastMarginBottomTime) > 40) {
                    lastMarginBottomTime = System.currentTimeMillis();
                    marginBottom = 0;
                }
            } else {
                boolean setMargin = params.bottomMargin != 0;
                if (isVisibleBecauseExtraMargin) {
                    if ((System.currentTimeMillis() - lastMarginBottomExtraTime) > 40) {
                        lastMarginBottomExtraTime = System.currentTimeMillis();
                        lastMarginBottom = null;
                        setMargin = true;
                    }
                }

                if (setMargin) {
                    params.setMargins(0, 0, 0, 0);
                    setLayoutParams(params);
                } else {
                    marginBottom = lastMarginBottom;
                }
            }
        } else {
            int pxHidden = bottomSpaceViewRect.bottom - windowAvailableRect.bottom;
            boolean setMargin = params.bottomMargin != pxHidden;
            if (pxHidden > 0 && params.bottomMargin > 0) {
                if (pxHidden != params.bottomMargin) {
                    pxHidden = 0;
                }
                setMargin = true;
            }

            if (pxHidden < 0) {
                pxHidden = 0;
            }

            if (setMargin) {
                params.setMargins(0, 0, 0, pxHidden);
                setLayoutParams(params);
                lastMarginBottom = pxHidden;
            }
        }
    }

    public static class WindowInsetsListener implements View.OnApplyWindowInsetsListener {
        @Override
        public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
            mStatusBarHeight = WindowInsetsCompat.toWindowInsetsCompat(insets).getInsets(WindowInsetsCompat.Type.statusBars()).top;
            return v.onApplyWindowInsets(insets);
        }
    }

}