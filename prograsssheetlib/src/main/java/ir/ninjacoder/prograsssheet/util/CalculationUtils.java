package ir.ninjacoder.prograsssheet.util;

import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/** [CalculationUtils] contains some methods for internal calculation. */
public final class CalculationUtils {

  /**
   * [convertDurationToTimeStamp] makes a string format of duration (presumably long) converts into
   * timestamp like 300 to 5:00.
   *
   * @param duration
   * @return
   */
  public static String convertDurationToTimeStamp(long duration) {
    long minutes = duration / 1000 / 60;
    long seconds = duration / 1000 - minutes * 60;
    if (seconds < 10) {
      return minutes + ":0" + seconds;
    }
    return minutes + ":" + seconds;
  }

  /** convertUnixTimestampToMonthDay: Converts unix timestamp to Month - Day format. */
  public static String convertUnixTimestampToMonthDay(long unixTimestamp) {
    return new SimpleDateFormat("MM-dd", Locale.getDefault())
        .format(new Date(unixTimestamp * 1000));
  }

  /** Set the alpha component of `color` to be `alpha`. */
  @ColorInt
  public static int setAlphaComponent(
      @ColorInt int color, @IntRange(from = 0x0, to = 0xFF) int alpha) {
    if (alpha < 0 || alpha > 255) {
      throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
    return (color & 0x00ffffff) | (alpha << 24);
  }

  public static float lerp(float start, float stop, float amount) {
    return start + (stop - start) * amount;
  }

  /**
   * Returns the interpolation scalar (s) that satisfies the equation: `value = lerp(a, b, s)`
   *
   * <p>If `a == b`, then this function will return 0.
   */
  public static float lerpInv(float a, float b, float value) {
    return (a != b) ? (value - a) / (b - a) : 0.0f;
  }

  /** Returns the single argument constrained between [0.0, 1.0]. */
  private static float saturate(float value) {
    return Math.max(0f, Math.min(1f, value));
  }

  /** Returns the saturated (constrained between [0, 1]) result of lerpInv. */
  public static float lerpInvSat(float a, float b, float value) {
    return saturate(lerpInv(a, b, value));
  }
}
