package Ninja.coder.Ghostemane.code.marco.binder.bindchilder;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.databinding.CustomToastBinding;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;

public class GhostToast {

  public static void showToast(@NonNull Context context, String message) {
    CustomToastBinding bind = CustomToastBinding.inflate(LayoutInflater.from(context));
   // ObjectUtils.shp(bind.getRoot());
    
 //   bind.layoutBack.setBackground(shape);
     Glide.with(context).load(R.drawable.app_icon).circleCrop().into(bind.toastIcon);
    bind.toastMessage.setText(message);
    Toast toast = new Toast(context);
    toast.setDuration(Toast.LENGTH_SHORT);
    toast.setView(bind.getRoot());
    toast.show();
    RotateAnimation rotateAnimation =
        new RotateAnimation(
            0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    rotateAnimation.setDuration(1000);
    rotateAnimation.setRepeatCount(Animation.INFINITE);
    rotateAnimation.setInterpolator(context, android.R.interpolator.linear);
    bind.toastIcon.startAnimation(rotateAnimation);
  }
}
