package ir.ninjacoder.prograsssheet.util;

import android.graphics.*;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;

public class RoundStrokeTransform extends BitmapTransformation {
  private static final String ID = "RoundStrokeTransform";
  private static final byte[] ID_BYTES = ID.getBytes(CHARSET);

  private final int radius;
  private final int strokeWidth;
  private final int[] strokeColors;
  private final boolean instaGradient;
  private final boolean fullRound;
  public static final int[] INSTA_RAINBOW = {
    0xFFFF0000, 0xFFFFA500, 0xFFFFFF00, 0xFF00FF00, 0xFF00FFFF, 0xFF0000FF, 0xFFFF00FF,
  };

  public RoundStrokeTransform(
      int radius, int strokeWidth, int[] strokeColors, boolean instaGradient, boolean fullRound) {
    this.radius = radius;
    this.strokeWidth = strokeWidth;
    this.strokeColors = strokeColors != null ? strokeColors : new int[0];
    this.instaGradient = instaGradient;
    this.fullRound = fullRound;
  }

  public RoundStrokeTransform(int radius, int strokeWidth, int strokeColor) {
    this(radius, strokeWidth, new int[] {strokeColor}, false, false);
  }

  public RoundStrokeTransform(int radius, int strokeWidth) {
    this(radius, strokeWidth, new int[] {Color.WHITE}, false, false);
  }

  public static RoundStrokeTransform instaStyle(int radius, int strokeWidth) {
    return new RoundStrokeTransform(radius, strokeWidth, null, true, false);
  }

  public static RoundStrokeTransform multiColorStyle(int radius, int strokeWidth, int[] colors) {
    return new RoundStrokeTransform(radius, strokeWidth, colors, false, false);
  }

  public static RoundStrokeTransform fullCircleStyle(
      int strokeWidth, int[] colors, boolean instaGradient) {
    return new RoundStrokeTransform(0, strokeWidth, colors, instaGradient, true);
  }

  public static RoundStrokeTransform instaFullCircle(int strokeWidth) {
    return new RoundStrokeTransform(0, strokeWidth, null, true, true);
  }

  @Override
  protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
    Bitmap cropped = TransformationUtils.centerCrop(pool, toTransform, outWidth, outHeight);
    Bitmap bitmap = pool.get(outWidth, outHeight, Bitmap.Config.ARGB_8888);

    if (bitmap == null) {
      bitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888);
    }

    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setShader(
        new BitmapShader(cropped, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));

    float finalRadius;
    if (fullRound) {

      float minDimension = Math.min(outWidth, outHeight);
      finalRadius = (minDimension - strokeWidth * 2) / 2f;
    } else if (radius == 0) {

      finalRadius = 0;
    } else {

      finalRadius = radius;
    }

    float inset = strokeWidth;
    RectF imageRect = new RectF(inset, inset, outWidth - inset, outHeight - inset);

    if (fullRound) {
      float centerX = outWidth / 2f;
      float centerY = outHeight / 2f;
      canvas.drawCircle(centerX, centerY, finalRadius, paint);
    } else {
      canvas.drawRoundRect(imageRect, finalRadius, finalRadius, paint);
    }

    if (strokeWidth > 0) {
      drawStroke(canvas, outWidth, outHeight, finalRadius);
    }

    return bitmap;
  }

  private void drawStroke(Canvas canvas, int width, int height, float radius) {
    if (instaGradient) {
      drawGradientStroke(canvas, width, height, radius, INSTA_RAINBOW);
    } else if (strokeColors.length == 1) {

      drawSingleColorStroke(canvas, width, height, radius);
    } else if (strokeColors.length > 1) {

      drawGradientStroke(canvas, width, height, radius, strokeColors);
    }
  }

  private void drawGradientStroke(
      Canvas canvas, int width, int height, float radius, int[] colors) {
    Paint strokePaint = new Paint();
    strokePaint.setAntiAlias(true);
    strokePaint.setStyle(Paint.Style.STROKE);
    strokePaint.setStrokeWidth(strokeWidth);
    strokePaint.setStrokeCap(Paint.Cap.ROUND);

    float centerX = width / 2f;
    float centerY = height / 2f;
    SweepGradient sweepGradient = new SweepGradient(centerX, centerY, colors, null);

    Matrix matrix = new Matrix();
    matrix.setRotate(-90, centerX, centerY);
    sweepGradient.setLocalMatrix(matrix);

    strokePaint.setShader(sweepGradient);

    if (fullRound || (radius == 0 && width == height)) {

      float strokeRadius;
      if (fullRound) {
        strokeRadius = Math.min(width, height) / 2f - strokeWidth / 2f;
      } else {
        strokeRadius = width / 2f - strokeWidth / 2f;
      }
      canvas.drawCircle(centerX, centerY, strokeRadius, strokePaint);
    } else {

      float inset = strokeWidth / 2f;
      RectF strokeRect = new RectF(inset, inset, width - inset, height - inset);
      canvas.drawRoundRect(strokeRect, radius, radius, strokePaint);
    }
  }

  private void drawSingleColorStroke(Canvas canvas, int width, int height, float radius) {
    if (strokeColors[0] == Color.TRANSPARENT) return;

    Paint strokePaint = new Paint();
    strokePaint.setAntiAlias(true);
    strokePaint.setStyle(Paint.Style.STROKE);
    strokePaint.setStrokeWidth(strokeWidth);
    strokePaint.setColor(strokeColors[0]);

    if (fullRound || (radius == 0 && width == height)) {

      float centerX = width / 2f;
      float centerY = height / 2f;
      float strokeRadius;
      if (fullRound) {
        strokeRadius = Math.min(width, height) / 2f - strokeWidth / 2f;
      } else {
        strokeRadius = width / 2f - strokeWidth / 2f;
      }
      canvas.drawCircle(centerX, centerY, strokeRadius, strokePaint);
    } else {

      float inset = strokeWidth / 2f;
      RectF strokeRect = new RectF(inset, inset, width - inset, height - inset);
      canvas.drawRoundRect(strokeRect, radius, radius, strokePaint);
    }
  }

  @Override
  public void updateDiskCacheKey(MessageDigest messageDigest) {
    messageDigest.update(ID_BYTES);
    messageDigest.update(ByteBuffer.allocate(4).putInt(radius).array());
    messageDigest.update(ByteBuffer.allocate(4).putInt(strokeWidth).array());

    for (int color : strokeColors) {
      messageDigest.update(ByteBuffer.allocate(4).putInt(color).array());
    }

    messageDigest.update(ByteBuffer.allocate(1).put((byte) (instaGradient ? 1 : 0)).array());
    messageDigest.update(ByteBuffer.allocate(1).put((byte) (fullRound ? 1 : 0)).array());
    messageDigest.update(ByteBuffer.allocate(4).putInt(strokeColors.length).array());
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof RoundStrokeTransform) {
      RoundStrokeTransform other = (RoundStrokeTransform) o;
      return radius == other.radius
          && strokeWidth == other.strokeWidth
          && Arrays.equals(strokeColors, other.strokeColors)
          && instaGradient == other.instaGradient
          && fullRound == other.fullRound;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result =
        ID.hashCode()
            + radius * 1000
            + strokeWidth * 100
            + (instaGradient ? 1 : 0)
            + (fullRound ? 1 : 0);

    for (int color : strokeColors) {
      result = 31 * result + color;
    }

    return result;
  }
}
