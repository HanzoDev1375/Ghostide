package ir.ninjacoder.prograsssheet.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.transition.platform.MaterialSharedAxis;
import android.transition.TransitionManager;

import ir.ninjacoder.prograsssheet.R;
import ir.ninjacoder.prograsssheet.databinding.EmptystateviewBinding;
import ir.ninjacoder.prograsssheet.util.RoundedCornersTransformation;

public class EmptyState extends LinearLayout {
  private EmptystateviewBinding bin;

  public EmptyState(Context context) {
    super(context);
    init(null);
  }

  public EmptyState(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs);
  }

  public EmptyState(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs);
  }

  void init(AttributeSet attrs) {
    bin = EmptystateviewBinding.inflate(LayoutInflater.from(getContext()));
    removeAllViews();
    if (bin != null) {
      addView(bin.getRoot());
    }
    setLayoutParams(
        new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    if (attrs != null) {
      TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.EmptyState);

      try {
        int iconRes = a.getResourceId(R.styleable.EmptyState_emptyStateIcon, 0);
        if (iconRes != 0) {
          int roundSize =
              a.getDimensionPixelSize(R.styleable.EmptyState_emptyStateIconRoundSize, 0);
          if (roundSize > 0) {
            setIconResRounder(iconRes, roundSize);
          } else {
            setIconRes(iconRes);
          }
        }

        int iconColor = a.getColor(R.styleable.EmptyState_emptyStateIconColor, 0);
        if (iconColor != 0) {
          setIconColor(iconColor);
        }
        String text = a.getString(R.styleable.EmptyState_emptyStateText);
        if (text != null) {
          setText(text);
        }
        int textColor = a.getColor(R.styleable.EmptyState_emptyStateTextColor, 0);
        if (textColor != 0) {
          setTextColor(textColor);
        }
        boolean showButton = a.getBoolean(R.styleable.EmptyState_emptyStateShowButton, false);
        setshowButton(showButton);
        String buttonText = a.getString(R.styleable.EmptyState_emptyStateButtonText);
        if (buttonText != null) {
          setTextButtonShow(buttonText);
        }
        int sizedef = a.getDimensionPixelSize(R.styleable.EmptyState_iconsize, 256);
        if (sizedef > 0) setIconSize(sizedef);
        boolean show = a.getBoolean(R.styleable.EmptyState_show, false);
        if (show) show();
        boolean hide = a.getBoolean(R.styleable.EmptyState_hide, false);
        if (hide) hide();
        int scaleTypeValue = a.getInteger(R.styleable.EmptyState_IconScaleType, -1);
        if (scaleTypeValue != -1) setIconScaleType(scaleTypeValue);
      } finally {
        a.recycle();
      }
    }
  }

  public boolean isShow() {
    return getVisibility() == VISIBLE;
  }

  public void setshowButton(boolean show) {
    bin.buttonemptystate.setVisibility(show ? VISIBLE : INVISIBLE);
  }

  public void setshowButtonClick(OnClickListener v) {
    bin.buttonemptystate.setOnClickListener(v);
  }

  public void setTextButtonShow(CharSequence c) {
    bin.buttonemptystate.setText(c);
  }

  public void setIconRes(int icon) {
    bin.iconEmptystate.setImageResource(icon);
  }

  public void setIconResRounder(int resid, int roundsize) {
    Glide.with(bin.iconEmptystate.getContext())
        .load(resid)
        .placeholder(R.drawable.emptyfolder)
        .transform(new RoundedCornersTransformation(roundsize))
        .into(bin.iconEmptystate);
  }

  public void setIconColor(int color) {
    bin.iconEmptystate.setColorFilter(color, PorterDuff.Mode.SRC_IN);
  }

  public void setText(CharSequence c) {
    bin.textEmptystate.setText(c);
  }

  public void setTextColor(int color) {
    bin.textEmptystate.setTextColor(color);
  }

  public void show() {
    postDelayed(
        () -> {
          if (getVisibility() != VISIBLE) {
            animate()
                .alpha(1f)
                .setDuration(150)
                .withStartAction(
                    () -> {
                      setAlpha(0f);
                      setVisibility(VISIBLE);
                    })
                .start();
          }
        },
        600);
  }

  public void hide() {
    postDelayed(
        () -> {
          if (getVisibility() == VISIBLE) {
            animate()
                .alpha(0f)
                .setDuration(150)
                .withEndAction(
                    () -> {
                      setVisibility(GONE);
                    })
                .start();
          }
        },
        500);
  }

  public void setIconSize(int size) {
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
    if (params != null) bin.iconEmptystate.setLayoutParams(params);
  }

  public void setIconScaleType(int scaleTypeValue) {
    ImageView.ScaleType scaleType;
    switch (scaleTypeValue) {
      case 0:
        scaleType = ImageView.ScaleType.CENTER;
        break;
      case 1:
        scaleType = ImageView.ScaleType.CENTER_CROP;
        break;
      case 2:
        scaleType = ImageView.ScaleType.CENTER_INSIDE;
        break;
      case 3:
        scaleType = ImageView.ScaleType.FIT_CENTER;
        break;
      case 4:
        scaleType = ImageView.ScaleType.FIT_START;
        break;
      case 5:
        scaleType = ImageView.ScaleType.FIT_END;
        break;
      case 6:
        scaleType = ImageView.ScaleType.FIT_XY;
        break;
      case 7:
        scaleType = ImageView.ScaleType.MATRIX;
        break;
      default:
        scaleType = ImageView.ScaleType.CENTER_INSIDE; // مقدار پیش‌فرض
        break;
    }
    bin.iconEmptystate.setScaleType(scaleType);
  }
}
