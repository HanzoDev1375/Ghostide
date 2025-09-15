// CircleParticle.java
package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Paint;

public class CircleParticle extends Particle {
  protected float dx, dy;
  protected float size;

  public CircleParticle(
      float x,
      float y,
      float dx,
      float dy,
      int color,
      float size,
      float gravity,
      float friction,
      int life) {
    super(x, y, color, life, gravity, friction);
    this.dx = dx;
    this.dy = dy;
    this.size = size;
  }

  @Override
  public void update(float deltaTime) {
    super.update(deltaTime);

    dy += gravity;
    dx *= friction;
    dy *= friction;

    x += dx * deltaTime * 60;
    y += dy * deltaTime * 60;
  }

  @Override
  public void draw(Canvas canvas, Paint paint) {
    paint.setColor(color);
    paint.setAlpha(alpha);
    canvas.drawCircle(x, y, size, paint);
  }

  // Getter and Setter methods
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

  public float getSize() {
    return size;
  }

  public void setSize(float size) {
    this.size = size;
  }
}
