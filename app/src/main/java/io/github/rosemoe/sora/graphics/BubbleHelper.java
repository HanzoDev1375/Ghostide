package io.github.rosemoe.sora.graphics;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/**
 * Helper class for building a bubble rect
 *
 * @author
 */
public class BubbleHelper {

  private static final Matrix tempMatrix = new Matrix();

  /**
   * Build a bubble into the given Path object. Old content in given Path is cleared.
   *
   * @param path target Path object
   * @param bounds The bounds for the bubble
   */
  public static void buildBubblePath(@NonNull Path path, @NonNull RectF bounds) {
    path.reset();
    float width = bounds.width();
    float height = bounds.height();
    float r = height / 2;
    float sqrt2 = (float) Math.sqrt(2);
    // Ensure we are convex.
    width = Math.max(r + sqrt2 * r, width);
    pathArcTo(path, r, r, r, 90, 180);
    float o1X = width - sqrt2 * r;
    pathArcTo(path, o1X, r, r, -90, 45f);
    float r2 = r / 5;
    float o2X = width - sqrt2 * r2;
    pathArcTo(path, o2X, r, r2, -45, 90);
    pathArcTo(path, o1X, r, r, 45f, 45f);
    path.close();
    tempMatrix.reset();
    tempMatrix.postTranslate(bounds.left, bounds.top);
    path.transform(tempMatrix);
  }

  private static void pathArcTo(
      @NonNull Path path,
      float centerX,
      float centerY,
      float radius,
      float startAngle,
      float sweepAngle) {
    path.arcTo(
        centerX - radius,
        centerY - radius,
        centerX + radius,
        centerY + radius,
        startAngle,
        sweepAngle,
        false);
  }
}
