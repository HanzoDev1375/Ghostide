package ir.ninjacoder.ghostide.layoutmanager;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.Gravity;
import android.widget.RelativeLayout;

public class WP10Indicator extends RelativeLayout {
    private Base10Indicator base10Indicator;
    private ObjectAnimator objectAnimator;
    private int number;

    public WP10Indicator(Context context, int indicatorHeight, int color, int radius, int number) {
        super(context);
        initialize(indicatorHeight, color, radius, number);
    }

    private void initialize(int indicatorHeight, int color, int radius, int number) {
        this.number = number;
        this.base10Indicator = new Base10Indicator(getContext(), indicatorHeight, color, radius);
        RelativeLayout.LayoutParams layoutParams = new LayoutParams(Utils.px2dp(getContext(), indicatorHeight * 8),
                Utils.px2dp(getContext(), indicatorHeight * 8));
        this.setLayoutParams(layoutParams);
        this.setGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT);
        this.addView(base10Indicator);
        startAnim(0, 0);
        removeAnim();
        this.setAlpha(0f);
    }

    public void startAnim(final long animationDuration, final long delay) {
        objectAnimator = ObjectAnimator.ofFloat(this, "rotation", (number * 15), -360 + (number * 15));
        objectAnimator.setInterpolator(new WPInterpolator());
        objectAnimator.setDuration(animationDuration);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setRepeatCount(2);
        objectAnimator.addListener(new android.animation.Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(android.animation.Animator animator) {
                WP10Indicator.this.setAlpha(1f);
                startAlphaAnimation(animationDuration);
            }

            @Override
            public void onAnimationEnd(android.animation.Animator animator) {
                removeAnim();
                startAnim(animationDuration, 0);
            }

            @Override
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override
            public void onAnimationRepeat(android.animation.Animator animator) {
            }
        });
        objectAnimator.setStartDelay(delay);
        objectAnimator.start();
    }

    public void startAlphaAnimation(long animationDuration) {
        this.animate().alpha(0).setDuration(animationDuration / 12).setStartDelay(2 * animationDuration);
    }

    public void removeAnim() {
        this.animate().alpha(0f).setDuration(0).setStartDelay(0);
        objectAnimator.removeAllListeners();
        objectAnimator.cancel();
        objectAnimator.end();
    }
}