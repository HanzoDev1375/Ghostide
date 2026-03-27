package ir.ninjacoder.ghostide.core.marco.binder.bindchilder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.google.android.material.color.MaterialColors;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.databinding.CustomToastBinding;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class GhostToast {

  public static enum MsgState {
    Error(0, "#FF5252", "#FF1744", "#ff000000"),
    Success(1, "#4CAF50", "#2E7D32", "#ff424242"),
    Warning(2, "#FFC107", "#FF6F00", "#ff000000"),
    None(3);

    private int value;
    private int backgroundColor;
    private int strokeColor;
    private int textColor;

    MsgState(int value) {
      this.value = value;
      this.backgroundColor = 0;
      this.strokeColor = 0;
      this.textColor = 0;
    }

    MsgState(int value, String backgroundColor, String strokeColor, String textColor) {
      this.value = value;
      this.backgroundColor = Color.parseColor(backgroundColor);
      this.strokeColor = Color.parseColor(strokeColor);
      this.textColor = Color.parseColor(textColor);
    }

    public int getValue() {
      return value;
    }

    public int getBackgroundColor() {
      return backgroundColor;
    }

    public int getStrokeColor() {
      return strokeColor;
    }

    public int getTextColor() {
      return textColor;
    }
  }

  private static void setupToastView(
      @NonNull Context context, @NonNull CustomToastBinding bind, @NonNull MsgState state) {
    Glide.with(context).load(R.drawable.app_icon).circleCrop().into(bind.toastIcon);
    int backgroundColor = Color.BLACK;
    int strokeColor = Color.GRAY;
    int textColorMsg = Color.CYAN;

    if (state == MsgState.Error) {
      backgroundColor = state.getBackgroundColor();
      strokeColor = state.getStrokeColor();
      textColorMsg = state.getTextColor();
    } else if (state == MsgState.Success) {
      backgroundColor = state.getBackgroundColor();
      strokeColor = state.getStrokeColor();
      textColorMsg = state.getTextColor();
    } else if (state == MsgState.Warning) {
      backgroundColor = state.getBackgroundColor();
      strokeColor = state.getStrokeColor();
      textColorMsg = state.getTextColor();
    } else if (state == MsgState.None) {
      textColorMsg = MaterialColors.getColor(context, ObjectUtils.colorOnSurface, 0);
      backgroundColor = MaterialColors.getColor(context, ObjectUtils.Back, 0);
      strokeColor = MaterialColors.getColor(context, ObjectUtils.ColorNormal, 0);
    }

    // ایجاد و تنظیم GradientDrawable
    GradientDrawable gradientDrawable = new GradientDrawable();
    gradientDrawable.setColor(backgroundColor);
    gradientDrawable.setStroke(2, strokeColor);
    gradientDrawable.setCornerRadius(55);
    bind.getRoot().setBackground(gradientDrawable);
    RotateAnimation rotateAnimation =
        new RotateAnimation(
            0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

    rotateAnimation.setDuration(1000);
    rotateAnimation.setRepeatCount(Animation.INFINITE);
    rotateAnimation.setInterpolator(context, android.R.interpolator.linear);
    bind.toastMessage.setTextColor(textColorMsg);
    bind.toastIcon.startAnimation(rotateAnimation);
  }

  public static void showToast(
      @NonNull Context context, @NonNull CharSequence message, MsgState state) {

    CustomToastBinding bind = CustomToastBinding.inflate(LayoutInflater.from(context));
    bind.toastMessage.setText(message);

    setupToastView(context, bind, state);

    Toast toast = new Toast(context);
    toast.setDuration(Toast.LENGTH_SHORT);
    toast.setView(bind.getRoot());
    toast.show();
  }

  public static void showToast(@NonNull Context context, @NonNull String message) {
    showToast(context, (CharSequence) message, MsgState.None);
  }

  public static void showToast(@NonNull Context context, @NonNull CharSequence message) {
    showToast(context, message, MsgState.None);
  }

  public static void showToast(@NonNull Context context, @NonNull Spanned message) {
    showToast(context, (CharSequence) message, MsgState.None);
  }

  public static void showError(@NonNull Context context, @NonNull String message) {
    showToast(context, message, MsgState.Error);
  }

  public static void showError(@NonNull Context context, @NonNull Spanned message) {
    showToast(context, message, MsgState.Error);
  }

  public static void showSuccess(@NonNull Context context, @NonNull String message) {
    showToast(context, message, MsgState.Success);
  }

  public static void showSuccess(@NonNull Context context, @NonNull Spanned message) {
    showToast(context, message, MsgState.Success);
  }

  public static void showWarning(@NonNull Context context, @NonNull String message) {
    showToast(context, message, MsgState.Warning);
  }

  public static void showWarning(@NonNull Context context, @NonNull Spanned message) {
    showToast(context, message, MsgState.Warning);
  }
}
