/**
 * Comment by ghost ide
 * @author: Ninjacoder
 */
package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class SpiralParticle extends Particle {

    protected float radius;

    protected float angle;

    protected float maxRadius;

    public SpiralParticle(float x, float y, int color, float maxRadius, int life) {
        super(x, y, color, life, 0, 1);
        this.radius = 0;
        this.angle = 0;
        this.maxRadius = maxRadius;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        radius = maxRadius * (1 - (float) life / initialLife);
        angle += 0.1;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setAlpha(alpha);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        Path path = new Path();
        int points = 50;
        for (int i = 0; i <= points; i++) {
            float progress = (float) i / points;
            float currentRadius = radius * progress;
            float currentAngle = angle + progress * 10;
            float px = x + (float) Math.cos(currentAngle) * currentRadius;
            float py = y + (float) Math.sin(currentAngle) * currentRadius;
            if (i == 0) {
                path.moveTo(px, py);
            } else {
                path.lineTo(px, py);
            }
        }
        canvas.drawPath(path, paint);
    }

    // Getter and Setter methods
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getMaxRadius() {
        return maxRadius;
    }

    public void setMaxRadius(float maxRadius) {
        this.maxRadius = maxRadius;
    }
}
