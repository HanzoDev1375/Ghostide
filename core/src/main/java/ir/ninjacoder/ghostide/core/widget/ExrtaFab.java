package ir.ninjacoder.ghostide.core.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import ir.ninjacoder.ghostide.core.R;
import android.view.View;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;

public class ExrtaFab extends ExtendedFloatingActionButton {
  private View.OnClickListener mOnClickListener;
    
  public ExrtaFab(Context c) {
    super(c);
    init();
  }

  public ExrtaFab(Context c, AttributeSet v) {
    super(c, v);
    init();
  }

  public void init() {
    setIconResource(R.drawable.ic_fab_play);
    shrink();
  }

  public void setColorFilter(int color) {}

  public boolean isHide() {
    return getVisibility() == GONE ? true : false;
  }

  public boolean isShow() {
    return getVisibility() == VISIBLE ? true : false;
  }

  public void setFabKeyBoardAnim(boolean isKeyboardShowing) {
    if (!(getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) return;
    CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) getLayoutParams();
    int targetMargin = isKeyboardShowing ? params.bottomMargin + 300 : 55;
    if (!isKeyboardShowing) {
      targetMargin = (int) (55 * getResources().getDisplayMetrics().density);
    }
    ValueAnimator animator = ValueAnimator.ofInt(params.bottomMargin, targetMargin);
    animator.setDuration(300);
    animator.addUpdateListener(
        animation -> {
          params.bottomMargin = (int) animation.getAnimatedValue();
          setLayoutParams(params);
        });
    animator.start();
  }

    @Override
    public void setOnClickListener(View.OnClickListener l) {
        super.setOnClickListener(l);
        this.mOnClickListener = l;
    }
    
    public View.OnClickListener getOnClickListener() {
        return mOnClickListener;
    }
}
