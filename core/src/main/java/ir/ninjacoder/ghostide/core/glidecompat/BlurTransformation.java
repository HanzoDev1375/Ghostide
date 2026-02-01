package ir.ninjacoder.ghostide.core.glidecompat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

import java.security.MessageDigest;

import ir.ninjacoder.ghostide.core.glidecompat.RSBlur;

public class BlurTransformation
    extends ir.ninjacoder.ghostide.core.glidecompat.BitmapTransformation {

  private static final int VERSION = 1;
  private static final String ID =
      "ir.ninjacoder.ghostide.core.glidecompat.BlurTransformation." + VERSION;

  private static final int MAX_RADIUS = 25;
  private static final int DEFAULT_DOWN_SAMPLING = 4;

  private final int radius;
  private final int sampling;

  public BlurTransformation() {
    this(MAX_RADIUS, DEFAULT_DOWN_SAMPLING);
  }

  public BlurTransformation(int radius) {
    this(radius, DEFAULT_DOWN_SAMPLING);
  }

  public BlurTransformation(int radius, int sampling) {
    this.radius = radius;
    this.sampling = sampling;
  }

  @Override
  protected Bitmap transform(
      @NonNull Context context,
      @NonNull BitmapPool pool,
      @NonNull Bitmap toTransform,
      int outWidth,
      int outHeight) {
    int scaledWidth = toTransform.getWidth() / sampling;
    int scaledHeight = toTransform.getHeight() / sampling;
    Bitmap scaledBitmap = Bitmap.createScaledBitmap(toTransform, scaledWidth, scaledHeight, false);
    try {
      scaledBitmap = RSBlur.blur(context, scaledBitmap, radius);
    } catch (RSRuntimeException e) {
      scaledBitmap = FastBlur.blur(scaledBitmap, radius, true);
    }

    return scaledBitmap;
  }

  @Override
  public String toString() {
    return "BlurTransformation(radius=" + radius + ", sampling=" + sampling + ")";
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof BlurTransformation
        && ((BlurTransformation) o).radius == radius
        && ((BlurTransformation) o).sampling == sampling;
  }

  @Override
  public int hashCode() {
    return ID.hashCode() + radius * 1000 + sampling * 10;
  }

  @Override
  public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    messageDigest.update((ID + radius + sampling).getBytes(CHARSET));
  }
}
