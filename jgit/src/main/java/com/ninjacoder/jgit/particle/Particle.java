// Particle.java
package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Particle {
  protected float x, y;
  public int life;
  protected int initialLife;
  protected int alpha;
  protected int color;
  protected float gravity;
  protected float friction;

  public Particle(float x, float y, int color, int life, float gravity, float friction) {
    this.x = x;
    this.y = y;
    this.color = color;
    this.life = life;
    this.initialLife = life;
    this.alpha = 255;
    this.gravity = gravity;
    this.friction = friction;
  }

  public void update(float deltaTime) {
    life--;
    alpha = (int) (255 * ((float) life / initialLife));
  }

  public abstract void draw(Canvas canvas, Paint paint);

  // Getter and Setter methods
  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return y;
  }

  public void setY(float y) {
    this.y = y;
  }

  public int getLife() {
    return life;
  }

  public void setLife(int life) {
    this.life = life;
  }

  public int getAlpha() {
    return alpha;
  }

  public void setAlpha(int alpha) {
    this.alpha = alpha;
  }

  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public float getGravity() {
    return gravity;
  }

  public void setGravity(float gravity) {
    this.gravity = gravity;
  }

  public float getFriction() {
    return friction;
  }

  public void setFriction(float friction) {
    this.friction = friction;
  }
}
