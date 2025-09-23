package com.ninjacoder.jgit.particle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.caverock.androidsvg.SVG;
///نویسنده نینجا کدر

// این کلاس بتا است ممکنه حافظه خور باشه در اینده ان را اصلاح میکنم
// ممکن است نال بدهد اما بزودی درستش میکنم 
public class SvgParticle extends Particle {
  private Bitmap coloredBitmap;
  private float rotation;
  private float rotationSpeed;
  private float size;
  private float dx;
  private float dy;

  public SvgParticle(
      float x,
      float y,
      SVG svg,
      float size,
      float dx,
      float dy,
      float gravity,
      float friction,
      int life,
      float rotationSpeed,
      int color) {
    super(x, y, color, life, gravity, friction);
    this.size = size;
    this.dx = dx;
    this.dy = dy;
    this.rotation = 0;
    this.rotationSpeed = rotationSpeed;

    // ایجاد Bitmap رنگی از SVG
    this.coloredBitmap = createColoredSvgBitmap(svg, color, (int) size);
  }

  private Bitmap createColoredSvgBitmap(SVG svg, int color, int bitmapSize) {
    if (svg == null) return null;

    try {
      // ایجاد Bitmap با اندازه مناسب
      Bitmap originalBitmap = Bitmap.createBitmap(bitmapSize, bitmapSize, Bitmap.Config.ARGB_8888);
      Canvas bitmapCanvas = new Canvas(originalBitmap);

      // رندر SVG روی Bitmap
      float docWidth = svg.getDocumentWidth();
      float docHeight = svg.getDocumentHeight();

      if (docWidth <= 0 || docHeight <= 0) {
        docWidth = bitmapSize;
        docHeight = bitmapSize;
      }

      float scale = bitmapSize / Math.max(docWidth, docHeight);
      bitmapCanvas.scale(scale, scale);

      // رندر SVG
      svg.renderToCanvas(bitmapCanvas);

      // ایجاد Bitmap جدید با رنگ اعمال شده
      Bitmap coloredBitmap = Bitmap.createBitmap(bitmapSize, bitmapSize, Bitmap.Config.ARGB_8888);
      Canvas coloredCanvas = new Canvas(coloredBitmap);

      Paint colorPaint = new Paint();
      colorPaint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));

      // اعمال رنگ روی Bitmap اصلی
      coloredCanvas.drawBitmap(originalBitmap, 0, 0, colorPaint);

      originalBitmap.recycle();
      return coloredBitmap;

    } catch (Exception e) {
      e.printStackTrace();
      return null;
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
  }

  @Override
  public void draw(Canvas canvas, Paint paint) {
    if (coloredBitmap == null || life <= 0) return;

    canvas.save();

    // تنظیم موقعیت و چرخش
    canvas.translate(x, y);
    canvas.rotate(rotation);

    // تنظیم شفافیت
    paint.setAlpha(alpha);

    // رسم Bitmap رنگی
    float halfSize = size / 2;
    canvas.drawBitmap(coloredBitmap, -halfSize, -halfSize, paint);

    canvas.restore();
  }

  @Override
  protected void finalize() throws Throwable {
    try {
      if (coloredBitmap != null && !coloredBitmap.isRecycled()) {
        coloredBitmap.recycle();
      }
    } finally {
      super.finalize();
    }
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
