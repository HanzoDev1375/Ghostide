package ir.ninjacoder.ghostide.git;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.widget.TextView;
import com.google.android.material.shape.MaterialShapes;
import com.google.android.material.slider.Slider;

public class JgitColorAnimHanlder {

  public static void animTextColor(TextView v, int start, int end) {
    var value = ValueAnimator.ofObject(new ArgbEvaluator(), start, end);
    value.setDuration(2000);
    value.setRepeatCount(ValueAnimator.INFINITE);
    value.setRepeatMode(ValueAnimator.REVERSE);
    value.addUpdateListener(
        anim -> {
          v.setTextColor((int) anim.getAnimatedValue());
        });
    if (value != null) value.start();
  }
  public static Slider getShapeSlider(Context c){
    Slider s = new Slider(c);
    s.setTrackIconActiveStart(MaterialShapes.createShapeDrawable(MaterialShapes.SOFT_BURST));
    return s;
  }
}
