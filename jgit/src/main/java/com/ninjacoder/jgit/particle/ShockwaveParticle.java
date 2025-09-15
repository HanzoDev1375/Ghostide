/**
 * Comment by ghost ide
 * @author: Ninjacoder
 */
package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Paint;

public class ShockwaveParticle extends Particle {

    protected float radius;

    protected float maxRadius;

    public ShockwaveParticle(float x, float y, int color, float maxRadius, int life) {
        super(x, y, color, life, 0, 1);
        this.radius = 0;
        this.maxRadius = maxRadius;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        radius = maxRadius * (1 - (float) life / initialLife);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setAlpha(alpha);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawCircle(x, y, radius, paint);
    }

    // Getter and Setter methods
    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getMaxRadius() {
        return maxRadius;
    }

    public void setMaxRadius(float maxRadius) {
        this.maxRadius = maxRadius;
    }
}
