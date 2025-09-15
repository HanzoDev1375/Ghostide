/**
 * Comment by ghost ide
 *
 * @author: Ninjacoder
 */
package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;

public class TrailParticle extends Particle {

  protected float size;

  protected List<float[]> previousPositions = new ArrayList<>();

  public TrailParticle(float x, float y, int color, int life, float size) {
    super(x, y, color, life, 0, 1);
    this.size = size;
  }

  @Override
  public void update(float deltaTime) {
    super.update(deltaTime);
    // Store current position
    previousPositions.add(0, new float[] {x, y});
    // Remove old positions
    if (previousPositions.size() > 10) {
      previousPositions.remove(previousPositions.size() - 1);
    }
  }

  @Override
  public void draw(Canvas canvas, Paint paint) {
    if (previousPositions.size() < 2) return;
    paint.setColor(color);
    for (int i = 0; i < previousPositions.size() - 1; i++) {
      float[] point = previousPositions.get(i);
      float trailAlpha = alpha * (1 - (float) i / previousPositions.size());
      paint.setAlpha((int) trailAlpha);
      float trailSize = size * (1 - (float) i / previousPositions.size());
      canvas.drawCircle(point[0], point[1], trailSize, paint);
    }
  }

  // Getter and Setter methods
  public float getSize() {
    return size;
  }

  public void setSize(float size) {
    this.size = size;
  }

  public List<float[]> getPreviousPositions() {
    return previousPositions;
  }

  public void setPreviousPositions(List<float[]> previousPositions) {
    this.previousPositions = previousPositions;
  }
}
