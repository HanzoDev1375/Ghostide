// SparkleParticle.java
package com.ninjacoder.jgit.particle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class SparkleParticle extends CircleParticle {
  protected Bitmap sparkleBitmap;
  protected Matrix matrix = new Matrix();
  protected float rotation;
  protected float rotationSpeed;

  public SparkleParticle(
      float x,
      float y,
      float dx,
      float dy,
      int color,
      float size,
      float gravity,
      float friction,
      int life,
      Bitmap sparkleBitmap) {
    super(x, y, dx, dy, color, size, gravity, friction, life);
    this.sparkleBitmap = sparkleBitmap;
    this.rotation = (float) (Math.random() * 360);
    this.rotationSpeed = (float) (Math.random() * 10 - 5);
  }

  @Override
  public void update(float deltaTime) {
    super.update(deltaTime);
    rotation += rotationSpeed;
  }

  @Override
  public void draw(Canvas canvas, Paint paint) {
    matrix.reset();
    matrix.postTranslate(-sparkleBitmap.getWidth() / 2, -sparkleBitmap.getHeight() / 2);
    matrix.postRotate(rotation);
    matrix.postScale(size * 2 / sparkleBitmap.getWidth(), size * 2 / sparkleBitmap.getHeight());
    matrix.postTranslate(x, y);

    paint.setAlpha(alpha);
    canvas.drawBitmap(sparkleBitmap, matrix, paint);
  }

  // Getter and Setter methods
  public Bitmap getSparkleBitmap() {
    return sparkleBitmap;
  }

  public void setSparkleBitmap(Bitmap sparkleBitmap) {
    this.sparkleBitmap = sparkleBitmap;
  }

  public float getRotation() {
    return rotation;
  }

  public void setRotation(float rotation) {
    this.rotation = rotation;
  }

  public float getRotationSpeed() {
    return rotationSpeed;
  }

  public void setRotationSpeed(float rotationSpeed) {
    this.rotationSpeed = rotationSpeed;
  }
}
