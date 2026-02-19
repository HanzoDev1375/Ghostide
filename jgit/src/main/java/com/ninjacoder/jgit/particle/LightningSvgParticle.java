package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.Random;

public class LightningSvgParticle extends Particle {
  private Path lightningPath;
  private float rotation;
  private float rotationSpeed;
  private float size;
  private float dx;
  private float dy;
  private int glowColor;
  private Random random = new Random();

  public LightningSvgParticle(
      float x,
      float y,
      float size,
      float dx,
      float dy,
      float gravity,
      float friction,
      int life,
      float rotationSpeed,
      int mainColor,
      int glowColor) {
    super(x, y, mainColor, life, gravity, friction);
    this.size = size;
    this.dx = dx;
    this.dy = dy;
    this.rotation = 0;
    this.rotationSpeed = rotationSpeed;
    this.glowColor = glowColor;

    // ایجاد مسیر رعد و برق
    createLightningPath();
  }

  private void createLightningPath() {
    lightningPath = new Path();

    // ایجاد مسیر زیگزاگی شبیه رعد و برق
    lightningPath.moveTo(0, 0);

    int segments = 8 + random.nextInt(5);
    float segmentLength = size / segments;

    for (int i = 1; i <= segments; i++) {
      float offsetX = (random.nextFloat() - 0.5f) * (size * 0.3f);
      float y = i * segmentLength;
      lightningPath.lineTo(offsetX, y);
    }
  }

  @Override
  public void update(float deltaTime) {
    super.update(deltaTime);

    dy += gravity;
    dx *= friction;
    dy *= friction;

    x += dx * deltaTime * 60;
    y += dy * deltaTime * 60;

    rotation += rotationSpeed;
    alpha = (int) (255 * ((float) life / initialLife));

    // کمی تغییر شکل برای اثر طبیعی‌تر
    if (random.nextFloat() < 0.1f) {
      createLightningPath();
    }
  }

  @Override
  public void draw(Canvas canvas, Paint paint) {
    if (lightningPath == null || life <= 0) return;

    canvas.save();
    canvas.translate(x, y);
    canvas.rotate(rotation);

    // رسم درخشش (glow)
    paint.setColor(glowColor);
    paint.setAlpha((int) (alpha * 0.6f));
    paint.setStrokeWidth(size * 0.4f);
    paint.setStyle(Paint.Style.STROKE);
    canvas.drawPath(lightningPath, paint);

    // رسم خط اصلی رعد و برق
    paint.setColor(color);
    paint.setAlpha(alpha);
    paint.setStrokeWidth(size * 0.2f);
    canvas.drawPath(lightningPath, paint);

    // رسم هسته روشن
    paint.setColor(Color.WHITE);
    paint.setAlpha((int) (alpha * 0.8f));
    paint.setStrokeWidth(size * 0.1f);
    canvas.drawPath(lightningPath, paint);

    canvas.restore();
  }

  public float getDx() {
    return dx;
  }

  public void setDx(float dx) {
    this.dx = dx;
  }

  public float getDy() {
    return dy;
  }

  public void setDy(float dy) {
    this.dy = dy;
  }
}
