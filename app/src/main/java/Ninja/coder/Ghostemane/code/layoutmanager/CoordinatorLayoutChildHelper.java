package Ninja.coder.Ghostemane.code.layoutmanager;

import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class CoordinatorLayoutChildHelper {

    private Integer lastYPosition;
    private View coordinatorChildView;
    private CoordinatorLayout coordinatorParentView;

    private boolean isBottomMatchingBehaviourEnabled;

    public void onViewAttached(View view) {
        lastYPosition = null;
        coordinatorChildView = null;
        coordinatorParentView = null;

        View childView = view;
        while (childView.getParent() instanceof View && coordinatorParentView == null) {
            ViewParent viewParent = childView.getParent();
            if (viewParent instanceof CoordinatorLayout) {
                coordinatorParentView = (CoordinatorLayout) viewParent;
                coordinatorChildView = childView;
            } else if (viewParent instanceof View) {
                childView = (View) viewParent;
            } else {
                childView = null;
            }
        }
    }

    public void setBottomMatchingBehaviourEnabled(boolean enabled) {
        if (isBottomMatchingBehaviourEnabled && !enabled) {
            lastYPosition = null;
            resetBottomMargin();
        }
        isBottomMatchingBehaviourEnabled = enabled;
        computeBottomMarginIfNeeded();
    }

    public void computeBottomMarginIfNeeded() {
        if (coordinatorChildView == null
                || coordinatorParentView == null
                || !isBottomMatchingBehaviourEnabled) {
            return;
        }

        int[] childBounds = new int[2];
        coordinatorChildView.getLocationOnScreen(childBounds);
        if (childBounds[1] != lastYPosition) {
            int childBottom = childBounds[1] + coordinatorChildView.getHeight();
            lastYPosition = childBounds[1];

            int[] parentBounds = new int[2];
            coordinatorParentView.getLocationOnScreen(parentBounds);
            int parentBottom = parentBounds[1] + coordinatorParentView.getHeight();

            int diff = childBottom - parentBottom;
            if (diff != 0) {
                CoordinatorLayout.LayoutParams layoutParams =
                        (CoordinatorLayout.LayoutParams) coordinatorChildView.getLayoutParams();
                layoutParams.bottomMargin += diff;
                coordinatorChildView.setLayoutParams(layoutParams);
            }
        }
    }

    private void resetBottomMargin() {
        if (coordinatorChildView != null) {
            CoordinatorLayout.LayoutParams layoutParams =
                    (CoordinatorLayout.LayoutParams) coordinatorChildView.getLayoutParams();
            layoutParams.bottomMargin = 0;
            coordinatorChildView.setLayoutParams(layoutParams);
        }
    }
}
