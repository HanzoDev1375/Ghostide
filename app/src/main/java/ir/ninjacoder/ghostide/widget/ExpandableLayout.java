package ir.ninjacoder.ghostide.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

public class ExpandableLayout extends LinearLayout {

  public static final String KEY_SUPER_STATE = "super_state";
  public static final String KEY_EXPANSION = "expansion";
  public static final int HORIZONTAL = 0;
  public static final int VERTICAL = 1;
  private static final int DEFAULT_DURATION = 1000;
  private final float[] ff = {
    0.0000f, 0.0001f, 0.0002f, 0.0005f, 0.0009f, 0.0014f, 0.0020f,
    0.0027f, 0.0036f, 0.0046f, 0.0058f, 0.0071f, 0.0085f, 0.0101f,
    0.0118f, 0.0137f, 0.0158f, 0.0180f, 0.0205f, 0.0231f, 0.0259f,
    0.0289f, 0.0321f, 0.0355f, 0.0391f, 0.0430f, 0.0471f, 0.0514f,
    0.0560f, 0.0608f, 0.0660f, 0.0714f, 0.0771f, 0.0830f, 0.0893f,
    0.0959f, 0.1029f, 0.1101f, 0.1177f, 0.1257f, 0.1339f, 0.1426f,
    0.1516f, 0.1610f, 0.1707f, 0.1808f, 0.1913f, 0.2021f, 0.2133f,
    0.2248f, 0.2366f, 0.2487f, 0.2611f, 0.2738f, 0.2867f, 0.2998f,
    0.3131f, 0.3265f, 0.3400f, 0.3536f, 0.3673f, 0.3810f, 0.3946f,
    0.4082f, 0.4217f, 0.4352f, 0.4485f, 0.4616f, 0.4746f, 0.4874f,
    0.5000f, 0.5124f, 0.5246f, 0.5365f, 0.5482f, 0.5597f, 0.5710f,
    0.5820f, 0.5928f, 0.6033f, 0.6136f, 0.6237f, 0.6335f, 0.6431f,
    0.6525f, 0.6616f, 0.6706f, 0.6793f, 0.6878f, 0.6961f, 0.7043f,
    0.7122f, 0.7199f, 0.7275f, 0.7349f, 0.7421f, 0.7491f, 0.7559f,
    0.7626f, 0.7692f, 0.7756f, 0.7818f, 0.7879f, 0.7938f, 0.7996f,
    0.8053f, 0.8108f, 0.8162f, 0.8215f, 0.8266f, 0.8317f, 0.8366f,
    0.8414f, 0.8461f, 0.8507f, 0.8551f, 0.8595f, 0.8638f, 0.8679f,
    0.8720f, 0.8760f, 0.8798f, 0.8836f, 0.8873f, 0.8909f, 0.8945f,
    0.8979f, 0.9013f, 0.9046f, 0.9078f, 0.9109f, 0.9139f, 0.9169f,
    0.9198f, 0.9227f, 0.9254f, 0.9281f, 0.9307f, 0.9333f, 0.9358f,
    0.9382f, 0.9406f, 0.9429f, 0.9452f, 0.9474f, 0.9495f, 0.9516f,
    0.9536f, 0.9556f, 0.9575f, 0.9594f, 0.9612f, 0.9629f, 0.9646f,
    0.9663f, 0.9679f, 0.9695f, 0.9710f, 0.9725f, 0.9739f, 0.9753f,
    0.9766f, 0.9779f, 0.9791f, 0.9803f, 0.9815f, 0.9826f, 0.9837f,
    0.9848f, 0.9858f, 0.9867f, 0.9877f, 0.9885f, 0.9894f, 0.9902f,
    0.9910f, 0.9917f, 0.9924f, 0.9931f, 0.9937f, 0.9944f, 0.9949f,
    0.9955f, 0.9960f, 0.9964f, 0.9969f, 0.9973f, 0.9977f, 0.9980f,
    0.9984f, 0.9986f, 0.9989f, 0.9991f, 0.9993f, 0.9995f, 0.9997f,
    0.9998f, 0.9999f, 0.9999f, 1.0000f, 1.0000f
  };
  private int duration = DEFAULT_DURATION;
  private float parallax;
  private float expansion;
  private int orientation;
  private int state;
  private Interpolator interpolator = new FastOutSlowInInterpolator(ff);
  private ValueAnimator animator;
  private OnExpansionUpdateListener listener;

  public ExpandableLayout(Context context) {
    this(context, null);
  }

  public ExpandableLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected Parcelable onSaveInstanceState() {
    Parcelable superState = super.onSaveInstanceState();
    Bundle bundle = new Bundle();

    expansion = isExpanded() ? 1 : 0;

    bundle.putFloat(KEY_EXPANSION, expansion);
    bundle.putParcelable(KEY_SUPER_STATE, superState);

    return bundle;
  }

  @Override
  protected void onRestoreInstanceState(Parcelable parcelable) {
    Bundle bundle = (Bundle) parcelable;
    expansion = bundle.getFloat(KEY_EXPANSION);
    state = expansion == 1 ? State.EXPANDED : ExpandableLayout.State.COLLAPSED;
    Parcelable superState = bundle.getParcelable(KEY_SUPER_STATE);

    super.onRestoreInstanceState(superState);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    int width = getMeasuredWidth();
    int height = getMeasuredHeight();

    int size = orientation == LinearLayout.HORIZONTAL ? width : height;

    setVisibility(expansion == 0 && size == 0 ? GONE : VISIBLE);

    int expansionDelta = size - Math.round(size * expansion);
    if (parallax > 0) {
      float parallaxDelta = expansionDelta * parallax;
      for (int i = 0; i < getChildCount(); i++) {
        View child = getChildAt(i);
        if (orientation == HORIZONTAL) {
          int direction = -1;
          if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1
              && getLayoutDirection() == LAYOUT_DIRECTION_RTL) {
            direction = 1;
          }
          child.setTranslationX(direction * parallaxDelta);
        } else {
          child.setTranslationY(-parallaxDelta);
        }
      }
    }

    if (orientation == HORIZONTAL) {
      setMeasuredDimension(width - expansionDelta, height);
    } else {
      setMeasuredDimension(width, height - expansionDelta);
    }
  }

  public void setOrientatin(int orientation) {
    this.orientation = orientation;
  }

  @Override
  protected void onConfigurationChanged(Configuration newConfig) {
    if (animator != null) {
      animator.cancel();
    }
    super.onConfigurationChanged(newConfig);
  }

  /**
   * Get expansion state
   *
   * @return one of {@link State}
   */
  public int getState() {
    return state;
  }

  public boolean isExpanded() {
    return state == ExpandableLayout.State.EXPANDING || state == State.EXPANDED;
  }

  /** Convenience method - same as calling setExpanded(expanded, true) */
  public void setExpanded(boolean expand) {
    setExpanded(expand, true);
  }

  public void toggle() {
    toggle(true);
  }

  public void toggle(boolean animate) {
    if (isExpanded()) {
      collapse(animate);
    } else {
      expand(animate);
    }
  }

  public void expand() {
    expand(true);
  }

  public void expand(boolean animate) {
    setExpanded(true, animate);
  }

  public void collapse() {
    collapse(true);
  }

  public void collapse(boolean animate) {
    setExpanded(false, animate);
  }

  public void setExpanded(boolean expand, boolean animate) {
    if (expand == isExpanded()) {
      return;
    }

    int targetExpansion = expand ? 1 : 0;
    if (animate) {
      animateSize(targetExpansion);
    } else {
      setExpansion(targetExpansion);
    }
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public void setInterpolator(Interpolator interpolator) {
    this.interpolator = interpolator;
  }

  public float getExpansion() {
    return expansion;
  }

  public void setExpansion(boolean yes) {
    float expansion = 0;
    if (yes) {
      state = ExpandableLayout.State.EXPANDED;
      expansion = 1;
    } else {
      state = ExpandableLayout.State.COLLAPSED;
      expansion = 0;
    }
    setVisibility(state == ExpandableLayout.State.COLLAPSED ? GONE : VISIBLE);
    this.expansion = expansion;
    requestLayout();

    if (listener != null) {
      listener.onExpansionUpdate(expansion, state);
    }
  }

  public void setExpansion(float expansion) {
    if (this.expansion == expansion) {
      return;
    }

    // Infer state from previous value
    float delta = expansion - this.expansion;
    if (expansion == 0) {
      state = ExpandableLayout.State.COLLAPSED;
    } else if (expansion == 1) {
      state = State.EXPANDED;
    } else if (delta < 0) {
      state = State.COLLAPSING;
    } else if (delta > 0) {
      state = ExpandableLayout.State.EXPANDING;
    }

    setVisibility(state == ExpandableLayout.State.COLLAPSED ? GONE : VISIBLE);
    this.expansion = expansion;
    requestLayout();

    if (listener != null) {
      listener.onExpansionUpdate(expansion, state);
    }
  }

  public float getParallax() {
    return parallax;
  }

  public void setParallax(float parallax) {
    // Make sure parallax is between 0 and 1
    parallax = Math.min(1, Math.max(0, parallax));
    this.parallax = parallax;
  }

  public int getOrientation() {
    return orientation;
  }

  public void setOrientation(int orientation) {
    if (orientation < 0 || orientation > 1) {
      throw new IllegalArgumentException(
          "Orientation must be either 0 (horizontal) or 1 (vertical)");
    }
    this.orientation = orientation;
  }

  public void setOnExpansionUpdateListener(OnExpansionUpdateListener listener) {
    this.listener = listener;
  }

  private void animateSize(int targetExpansion) {
    if (animator != null) {
      animator.cancel();
      animator = null;
    }

    animator = ValueAnimator.ofFloat(expansion, targetExpansion);
    animator.setInterpolator(interpolator);
    animator.setDuration(duration);

    animator.addUpdateListener(
        new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator valueAnimator) {
            setExpansion((float) valueAnimator.getAnimatedValue());
          }
        });

    animator.addListener(new ExpansionListener(targetExpansion));

    animator.start();
  }

  public interface State {
    int COLLAPSED = 0;
    int COLLAPSING = 1;
    int EXPANDING = 2;
    int EXPANDED = 3;
  }

  public interface OnExpansionUpdateListener {

    void onExpansionUpdate(float expansionFraction, int state);
  }

  private class ExpansionListener implements Animator.AnimatorListener {
    private int targetExpansion;
    private boolean canceled;

    public ExpansionListener(int targetExpansion) {
      this.targetExpansion = targetExpansion;
    }

    @Override
    public void onAnimationStart(Animator animation) {
      state = targetExpansion == 0 ? State.COLLAPSING : ExpandableLayout.State.EXPANDING;
    }

    @Override
    public void onAnimationEnd(Animator animation) {
      if (!canceled) {
        state = targetExpansion == 0 ? ExpandableLayout.State.COLLAPSED : State.EXPANDED;
        setExpansion(targetExpansion);
      }
    }

    @Override
    public void onAnimationCancel(Animator animation) {
      canceled = true;
    }

    @Override
    public void onAnimationRepeat(Animator animation) {}
  }

  public class FastOutSlowInInterpolator extends LookupTableInterpolator {
    public FastOutSlowInInterpolator(float[] values) {
      super(values);
    }
  }

  abstract class LookupTableInterpolator implements Interpolator {

    private float[] mValues;
    private float mStepSize;

    public LookupTableInterpolator(float[] values) {
      mValues = values;
      mStepSize = 1f / (mValues.length - 1);
    }

    @Override
    public float getInterpolation(float input) {
      if (input >= 1.0f) {
        return 1.0f;
      }
      if (input <= 0f) {
        return 0f;
      }

      // Calculate index - We use min with length - 2 to avoid IndexOutOfBoundsException when
      // we lerp (linearly interpolate) in the return statement
      int position = Math.min((int) (input * (mValues.length - 1)), mValues.length - 2);

      // Calculate values to account for small offsets as the lookup table has discrete values
      float quantized = position * mStepSize;
      float diff = input - quantized;
      float weight = diff / mStepSize;

      // Linearly interpolate between the table values
      return mValues[position] + weight * (mValues[position + 1] - mValues[position]);
    }
  }
}
