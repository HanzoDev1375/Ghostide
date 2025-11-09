package ir.ninjacoder.ghostide.core.marco;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.style.ReplacementSpan;

public class WavyUnderlineSpan extends ReplacementSpan {

  private boolean enabled;
  private int colorText = Color.RED; // default
  private float amplitude = 3f;
  private float halfWaveLength = 5f;
  private StatosMod mod = StatosMod.DEFAULT;

  public enum StatosMod {
    ERROR(0),
    WARNING(1),
    TYPO(2),
    DEFAULT(3);

    final int value;

    StatosMod(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  public WavyUnderlineSpan() {}

  private void init() {
    switch (mod) {
      case ERROR:
        colorText = Color.RED;
        break;
      case WARNING:
        colorText = Color.YELLOW;
        break;
      case TYPO:
        colorText = Color.GREEN;
        break;
      case DEFAULT:
        colorText = Color.WHITE;
        break;
    }
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public void setMod(StatosMod mod) {
    this.mod = mod;
    init();
  }

  public void setColorText(int colorText) {
    this.colorText = colorText;
  }

  @Override
  public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
    return Math.round(paint.measureText(text, start, end));
  }

  @Override
  public void draw(
      Canvas canvas,
      CharSequence text,
      int start,
      int end,
      float x,
      int top,
      int y,
      int bottom,
      Paint paint) {

    canvas.drawText(text, start, end, x, y, paint);
    if (!enabled) return;

    float textWidth = paint.measureText(text, start, end);
    float waveY = y + 4;

    Paint wavePaint = new Paint(paint);
    wavePaint.setColor(colorText);
    wavePaint.setStyle(Paint.Style.STROKE);
    wavePaint.setStrokeWidth(2f);
    wavePaint.setAntiAlias(true);

    Path path = new Path();
    path.moveTo(x, waveY);

    for (float dx = x; dx <= x + textWidth; dx += 2 * halfWaveLength) {
      path.rQuadTo(halfWaveLength, -amplitude, 2 * halfWaveLength, 0);
      path.rQuadTo(halfWaveLength, amplitude, 2 * halfWaveLength, 0);
    }

    canvas.drawPath(path, wavePaint);
  }

  public float getAmplitude() {
    return this.amplitude;
  }

  public void setAmplitude(float amplitude) {
    this.amplitude = amplitude;
  }

  public float getHalfWaveLength() {
    return this.halfWaveLength;
  }

  public void setHalfWaveLength(float halfWaveLength) {
    this.halfWaveLength = halfWaveLength;
  }
}
