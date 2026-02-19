package ir.ninjacoder.prograsssheet.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticleDisintegrationView extends View {

  private static class Particle {
    float x, y;
    float velocityX, velocityY;
    int color;
    float alpha = 1f;
  }

  private final List<Particle> particles = new ArrayList<>();
  private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
  private ValueAnimator animator;

  public ParticleDisintegrationView(Context context) {
    super(context);
  }

  /**
   * شروع افکت با یک bitmap از view
   *
   * @param snapshot bitmap آماده شده از ListItemView
   * @param offsetX x موقعیت view در parent
   * @param offsetY y موقعیت view در parent
   */
  public void startDisintegration(Bitmap snapshot, float offsetX, float offsetY) {
    if (snapshot == null) return;

    createParticles(snapshot, offsetX, offsetY);

    animator = ValueAnimator.ofFloat(0f, 1f);
    animator.setDuration(900);
    animator.setInterpolator(new AccelerateInterpolator());
    animator.addUpdateListener(
        animation -> {
          float progress = (float) animation.getAnimatedValue();
          updateParticles(progress);
          invalidate();
        });

    animator.start();
  }

  private void createParticles(Bitmap bitmap, float offsetX, float offsetY) {
    particles.clear();
    Random random = new Random();

    int step = 6; 
    for (int y = 0; y < bitmap.getHeight(); y += step) {
      for (int x = 0; x < bitmap.getWidth(); x += step) {
        int pixel = bitmap.getPixel(x, y);
        if ((pixel >>> 24) == 0) continue; 

        Particle p = new Particle();
        p.x = x + offsetX;
        p.y = y + offsetY;
        p.color = pixel;
        p.velocityX = (random.nextFloat() - 0.5f) * 20f;
        p.velocityY = (random.nextFloat() - 0.5f) * 20f;

        particles.add(p);
      }
    }
  }

  private void updateParticles(float progress) {
    for (Particle p : particles) {
      p.x += p.velocityX * progress;
      p.y += p.velocityY * progress;
      p.alpha = 1f - progress;
    }

    if (progress >= 1f && getParent() != null) {
      ((ViewGroup) getParent()).removeView(this);
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    for (Particle p : particles) {
      paint.setColor(p.color);
      paint.setAlpha((int) (p.alpha * 255));
      canvas.drawRect(p.x, p.y, p.x + 6, p.y + 6, paint);
    }
  }
}
