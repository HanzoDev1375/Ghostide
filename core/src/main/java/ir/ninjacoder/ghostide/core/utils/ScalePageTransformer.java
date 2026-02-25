package ir.ninjacoder.ghostide.core.utils;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class ScalePageTransformer implements ViewPager2.PageTransformer {
  private static final float MIN_SCALE = 0.85f;
  private static final float MIN_ALPHA = 0.5f;

  @Override
  public void transformPage(@NonNull View page, float position) {
    if (position < -1) {
      page.setAlpha(0f);

    } else if (position <= 1) {
      float scale = Math.max(MIN_SCALE, 1 - Math.abs(position) * 0.3f);
      float alpha = Math.max(MIN_ALPHA, 1 - Math.abs(position) * 0.5f);
      page.setScaleX(scale);
      page.setScaleY(scale);
      page.setAlpha(alpha);
      page.setTranslationY(page.getHeight() * Math.abs(position) * 0.1f);
    } else {
      page.setAlpha(0f);
    }
  }
}
