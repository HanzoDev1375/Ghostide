package ir.ninjacoder.ghostide.marco.binder.bindchilder;

import android.graphics.drawable.GradientDrawable;
import com.google.android.material.color.MaterialColors;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.databinding.CustomToastBinding;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import ir.ninjacoder.ghostide.utils.ObjectUtils;

public class GhostToast {

  public static void showToast(@NonNull Context context, String message) {
    CustomToastBinding bind = CustomToastBinding.inflate(LayoutInflater.from(context));
    Glide.with(context).load(R.drawable.app_icon).circleCrop().into(bind.toastIcon);
    bind.toastMessage.setText(message);
    Toast toast = new Toast(context);
    toast.setDuration(Toast.LENGTH_SHORT);
    toast.setView(bind.getRoot());
    toast.show();
    GradientDrawable d = new GradientDrawable();
    d.setColor(MaterialColors.getColor(context, ObjectUtils.Back, 0));
    d.setStroke(1, MaterialColors.getColor(context, ObjectUtils.ColorNormal, 0));
    d.setCornerRadius(55);
    if (bind != null) {
      bind.getRoot().setBackground(d);
    }
    RotateAnimation rotateAnimation =
        new RotateAnimation(
            0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    rotateAnimation.setDuration(1000);
    rotateAnimation.setRepeatCount(Animation.INFINITE);
    rotateAnimation.setInterpolator(context, android.R.interpolator.linear);
    bind.toastIcon.startAnimation(rotateAnimation);
  }
}
