package ir.ninjacoder.prograsssheet.util;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.android.material.color.utilities.Score;
import com.google.android.material.color.utilities.Scheme;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ColorPaletteUtils {
  public static volatile Map<String, Integer> lightColors;
  public static volatile Map<String, Integer> darkColors;

  public static volatile Map<String, Integer> oldLightColors;
  public static volatile Map<String, Integer> oldDarkColors;

  private static final ExecutorService executor =
      Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

  private static volatile long lastBitmapHash = Long.MIN_VALUE;

  public interface ResultCallback {
    void onResult(Map<String, Integer> lightColors, Map<String, Integer> darkColors);
  }

  public static void generateFromBitmap(Bitmap bitmap, ResultCallback callback) {
    if (bitmap == null) return;

    executor.execute(
        () -> {
          try {
            long hash = hashBitmap(bitmap);

            if (hash == lastBitmapHash && lightColors != null && darkColors != null) {
              return;
            }

            Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 128, 128, false);

            int[] pixels = new int[scaled.getWidth() * scaled.getHeight()];
            scaled.getPixels(
                pixels, 0, scaled.getWidth(), 0, 0, scaled.getWidth(), scaled.getHeight());

            Map<Integer, Integer> colorMap = QuantizerCelebi.quantize(pixels, 16);

            List<Integer> ranked = Score.score(colorMap, 0, 1, false);

            int seedColor = ranked.isEmpty() ? 0xFF6750A4 : ranked.get(0);
            Hct seed = Hct.fromInt(seedColor);

            Map<String, Integer> newLight = generateMaterialTones(seed, false);
            Map<String, Integer> newDark = generateMaterialTones(seed, true);

            if (lightColors == null || darkColors == null) {
              oldLightColors = new HashMap<>(newLight);
              oldDarkColors = new HashMap<>(newDark);
            } else {
              oldLightColors = new HashMap<>(lightColors);
              oldDarkColors = new HashMap<>(darkColors);
            }

            lightColors = newLight;
            darkColors = newDark;

            lastBitmapHash = hash;

            if (callback != null) {
              callback.onResult(lightColors, darkColors);
            }

          } catch (Exception e) {
            if (callback != null) {
              callback.onResult(
                  oldLightColors != null ? oldLightColors : new HashMap<>(),
                  oldDarkColors != null ? oldDarkColors : new HashMap<>());
            }
          }
        });
  }

  public static void generateFromColor(int color, ResultCallback callback) {
    Hct seed = Hct.fromInt(color);

    Map<String, Integer> newLight = generateMaterialTones(seed, false);
    Map<String, Integer> newDark = generateMaterialTones(seed, true);

    if (lightColors == null || darkColors == null) {
      oldLightColors = new HashMap<>(newLight);
      oldDarkColors = new HashMap<>(newDark);
    } else {
      oldLightColors = new HashMap<>(lightColors);
      oldDarkColors = new HashMap<>(darkColors);
    }

    lightColors = newLight;
    darkColors = newDark;

    if (callback != null) {
      callback.onResult(lightColors, darkColors);
    }
  }

  private static long hashBitmap(Bitmap bitmap) {
    Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 64, 64, false);

    int[] pixels = new int[scaled.getWidth() * scaled.getHeight()];
    scaled.getPixels(pixels, 0, scaled.getWidth(), 0, 0, scaled.getWidth(), scaled.getHeight());

    long hash = 1125899906842597L;
    for (int p : pixels) {
      hash = 31 * hash + p;
    }
    return hash;
  }

  public static long getCurrentHash() {
    return lastBitmapHash;
  }

  private static Map<String, Integer> generateMaterialTones(@NonNull Hct hct, boolean isDark) {
    Map<String, Integer> tones = new HashMap<>();

    double hue = hct.getHue() % 360;
    double chroma = hct.getChroma();
    boolean lowChroma = chroma < 10;

    tones.put("primary", Hct.from(hue, lowChroma ? chroma : 40, isDark ? 80 : 30).toInt());
    tones.put("onPrimary", Hct.from(hue, lowChroma ? chroma : 40, isDark ? 20 : 80).toInt());
    tones.put("onPrimaryDark", Hct.from(hue, lowChroma ? chroma : 40, isDark ? 10 : 90).toInt());

    tones.put(
        "tertiary", Hct.from((hue + 25) % 360, lowChroma ? chroma : 40, isDark ? 80 : 40).toInt());
    tones.put(
        "onTertiary",
        Hct.from((hue + 25) % 360, lowChroma ? chroma : 40, isDark ? 20 : 80).toInt());

    tones.put("primaryContainer", Hct.from(hue, chroma, isDark ? 30 : 90).toInt());
    tones.put("onPrimaryContainer", Hct.from(hue, chroma, isDark ? 90 : 10).toInt());

    tones.put("surface", Hct.from(hue, lowChroma ? chroma : 25, isDark ? 7 : 92).toInt());
    tones.put("onSurface", Hct.from(hue, lowChroma ? chroma : 30, isDark ? 75 : 10).toInt());

    tones.put("surfaceContainer", Hct.from(hue, lowChroma ? chroma : 25, isDark ? 15 : 88).toInt());
    tones.put(
        "onSurfaceContainer", Hct.from(hue, lowChroma ? chroma : 30, isDark ? 60 : 10).toInt());

    tones.put("outline", Hct.from(hue, lowChroma ? chroma : 25, isDark ? 30 : 70).toInt());

    return tones;
  }
  @Deprecated
  public static Scheme generateCustomScheme(int seedColor, boolean isDarkMode) {
    return isDarkMode ? Scheme.dark(seedColor) : Scheme.light(seedColor);
  }
}
