package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.BlurMaskFilter;
import java.util.Random;

public class ThanosInfinityParticle extends Particle {
  private float dx, dy;
  private float size;
  private float originalSize;
  private float rotation;
  private float rotationSpeed;
  private Random random = new Random();
  private int stoneType; // 0-5 برای ۶ سنگ

  // رنگ‌های ۶ سنگ ابدیت
  private static final int SOUL_STONE = Color.argb(255, 255, 165, 0); // نارنجی - روح
  private static final int POWER_STONE = Color.argb(255, 128, 0, 255); // بنفش - قدرت
  private static final int TIME_STONE = Color.argb(255, 0, 255, 0); // سبز - زمان
  private static final int SPACE_STONE = Color.argb(255, 0, 0, 255); // آبی - فضا
  private static final int MIND_STONE = Color.argb(255, 255, 255, 0); // زرد - ذهن
  private static final int REALITY_STONE = Color.argb(255, 255, 0, 0); // قرمز - واقعیت

  public static final int[] INFINITY_COLORS = {
    SOUL_STONE, POWER_STONE, TIME_STONE, SPACE_STONE, MIND_STONE, REALITY_STONE
  };

  private Paint glowPaint;
  private float vaporizeProgress = 0;
  private boolean isVaporizing = false;

  private float[][] dustParticles;
  private int dustCount = 8;

  public ThanosInfinityParticle(
      float x,
      float y,
      float dx,
      float dy,
      int colorIndex,
      float size,
      float gravity,
      float friction,
      int life) {
    super(x, y, INFINITY_COLORS[colorIndex % 6], life, gravity, friction);
    this.dx = dx;
    this.dy = dy;
    this.size = size;
    this.originalSize = size;
    this.stoneType = colorIndex % 6;
    this.rotation = random.nextFloat() * 360;
    this.rotationSpeed = (random.nextFloat() - 0.5f) * 20;

    glowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    if (android.os.Build.VERSION.SDK_INT >= 11) {
      glowPaint.setMaskFilter(new BlurMaskFilter(15, BlurMaskFilter.Blur.NORMAL));
    }

    dustParticles = new float[dustCount][5]; // x, y, size, alpha, colorType
    for (int i = 0; i < dustCount; i++) {
      dustParticles[i][0] = (random.nextFloat() - 0.5f) * size * 4;
      dustParticles[i][1] = (random.nextFloat() - 0.5f) * size * 4;
      dustParticles[i][2] = size * (0.2f + random.nextFloat() * 0.4f);
      dustParticles[i][3] = 255;
      dustParticles[i][4] = random.nextInt(6); // سنگ تصادفی برای غبار
    }
  }

  @Override
  public void update(float deltaTime) {
    super.update(deltaTime);

    float lifePercent = (float) life / initialLife;

    if (lifePercent < 0.45f) {
      isVaporizing = true;
      vaporizeProgress = 1.0f - (lifePercent / 0.45f);

      size = originalSize * (1 - vaporizeProgress * 0.9f);

      for (int i = 0; i < dustCount; i++) {
        dustParticles[i][0] += (random.nextFloat() - 0.5f) * vaporizeProgress * 12;
        dustParticles[i][1] += (random.nextFloat() - 0.5f) * vaporizeProgress * 12;
        dustParticles[i][2] *= 0.97f;
        dustParticles[i][3] = 255 * (1 - vaporizeProgress);

        if (random.nextFloat() < 0.05f) {
          dustParticles[i][4] = random.nextInt(6);
        }
      }

      if (random.nextFloat() < 0.15f) {
        stoneType = random.nextInt(6);
        color = INFINITY_COLORS[stoneType];
      }
    } else {
      dx *= friction;
      dy += gravity;

      x += dx * deltaTime * 60;
      y += dy * deltaTime * 60;

      rotation += rotationSpeed;
    }
  }

  @Override
  public void draw(Canvas canvas, Paint paint) {
    if (isVaporizing) {
      for (int i = 0; i < dustCount; i++) {
        float dustX = x + dustParticles[i][0];
        float dustY = y + dustParticles[i][1];
        float dustSize = dustParticles[i][2];
        int dustAlpha = (int) dustParticles[i][3];
        int dustColorType = (int) dustParticles[i][4];

        paint.setColor(INFINITY_COLORS[dustColorType]);
        paint.setAlpha(Math.min(alpha, dustAlpha));
        canvas.drawCircle(dustX, dustY, dustSize, paint);
      }

      paint.setColor(color);
      paint.setAlpha((int) (alpha * 0.2f));
      canvas.drawCircle(x, y, size, paint);

    } else {
      canvas.save();
      canvas.rotate(rotation, x, y);

      for (int i = 0; i < 3; i++) {
        glowPaint.setColor(INFINITY_COLORS[(stoneType + i) % 6]);
        glowPaint.setAlpha(alpha / (4 + i * 2));
        canvas.drawCircle(x, y, size * (2 + i * 0.5f), glowPaint);
      }

      paint.setColor(Color.WHITE);
      paint.setAlpha(alpha);
      canvas.drawCircle(x, y, size * 0.7f, paint);

      paint.setColor(color);
      paint.setAlpha(alpha);
      canvas.drawCircle(x, y, size * 0.5f, paint);

      canvas.restore();
    }
  }
}
