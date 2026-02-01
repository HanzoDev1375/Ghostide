package ir.ninjacoder.prograsssheet.util;

import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalculationUtils {

  public static String convertDurationToTimeStamp(long duration) {
    long minutes = duration / 1000 / 60;
    long seconds = duration / 1000 - minutes * 60;
    if (seconds < 10) {
      return String.format(Locale.getDefault(), "%d:0%d", minutes, seconds);
    }
    return String.format(Locale.getDefault(), "%d:%d", minutes, seconds);
  }

  public static String convertUnixTimestampToMonthDay(long unixTimestamp) {
    return new SimpleDateFormat("MM-dd", Locale.getDefault())
        .format(new Date(unixTimestamp * 1000));
  }

  @ColorInt
  public static int setAlphaComponent(
      @ColorInt int color, @IntRange(from = 0x0, to = 0xFF) int alpha) {
    if (alpha < 0 || alpha > 255) {
      throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
    return color & 0x00ffffff | (alpha << 24);
  }

  public static float constrain(float amount, float low, float high) {
    return amount < low ? low : Math.min(amount, high);
  }

  public static float lerp(float start, float stop, float amount) {
    return start + (stop - start) * amount;
  }

  public static float lerp(int start, int stop, float amount) {
    return lerp((float) start, (float) stop, amount);
  }

  public static float lerpInv(float a, float b, float value) {
    return a != b ? (value - a) / (b - a) : 0.0f;
  }

  public static float saturate(float value) {
    return constrain(value, 0.0f, 1.0f);
  }

  public static float lerpInvSat(float a, float b, float value) {
    return saturate(lerpInv(a, b, value));
  }
}
