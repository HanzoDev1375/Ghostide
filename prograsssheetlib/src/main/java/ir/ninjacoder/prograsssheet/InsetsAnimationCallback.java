package ir.ninjacoder.prograsssheet;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimationUtils;
import java.util.List;

class InsetsAnimationCallback extends WindowInsetsAnimationCompat.Callback {

  private final View view;

  private int startY;
  private int startTranslationY;

  private final int[] tmpLocation = new int[2];

  public InsetsAnimationCallback(View view) {
    super(DISPATCH_MODE_STOP);
    this.view = view;
  }

  @Override
  public void onPrepare(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    view.getLocationOnScreen(tmpLocation);
    startY = tmpLocation[1];
  }

  @NonNull
  @Override
  public BoundsCompat onStart(
      @NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat,
      @NonNull BoundsCompat boundsCompat) {
    view.getLocationOnScreen(tmpLocation);
    int endY = tmpLocation[1];
    startTranslationY = startY - endY;

    view.setTranslationY(startTranslationY);

    return boundsCompat;
  }

  @NonNull
  @Override
  public WindowInsetsCompat onProgress(
      @NonNull WindowInsetsCompat insets,
      @NonNull List<WindowInsetsAnimationCompat> animationList) {
    for (WindowInsetsAnimationCompat animation : animationList) {
      if ((animation.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
        float translationY =
            AnimationUtils.lerp(startTranslationY, 0, animation.getInterpolatedFraction());
        view.setTranslationY(translationY);
        break;
      }
    }
    return insets;
  }

  @Override
  public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    view.setTranslationY(0f);
  }
}
