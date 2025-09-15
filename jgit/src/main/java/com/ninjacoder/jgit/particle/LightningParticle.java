/**
 * Comment by ghost ide
 * @author: Ninjacoder
 */
package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class LightningParticle extends Particle {

    protected float endX, endY;

    protected int segments;

    protected Path lightningPath;

    protected float jitter;

    protected float thickness;

    public LightningParticle(float startX, float startY, float endX, float endY, int color, int segments, float thickness) {
        super(startX, startY, color, 8, 0, 1);
        this.endX = endX;
        this.endY = endY;
        this.segments = segments;
        this.thickness = thickness;
        this.jitter = 30f;
        createLightningPath();
    }

    protected void createLightningPath() {
        lightningPath = new Path();
        lightningPath.moveTo(x, y);
        float dx = (endX - x) / segments;
        float dy = (endY - y) / segments;
        float prevX = x;
        float prevY = y;
        for (int i = 1; i < segments; i++) {
            float midX = prevX + dx;
            float midY = prevY + dy;
            float segmentProgress = (float) i / segments;
            float currentJitter = jitter * (1.0f - segmentProgress * 0.7f);
            midX += (Math.random() - 0.5) * currentJitter;
            midY += (Math.random() - 0.5) * currentJitter;
            lightningPath.lineTo(midX, midY);
            prevX = midX;
            prevY = midY;
        }
        lightningPath.lineTo(endX, endY);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        if (life % 3 == 0) {
            createLightningPath();
        }
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setAlpha(alpha);
        paint.setStrokeWidth(thickness);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(lightningPath, paint);
        if (thickness > 2) {
            paint.setColor(Color.WHITE);
            paint.setAlpha(alpha / 2);
            paint.setStrokeWidth(thickness / 3);
            canvas.drawPath(lightningPath, paint);
        }
    }

    // Getter and Setter methods
    public float getEndX() {
        return endX;
    }

    public void setEndX(float endX) {
        this.endX = endX;
    }

    public float getEndY() {
        return endY;
    }

    public void setEndY(float endY) {
        this.endY = endY;
    }

    public int getSegments() {
        return segments;
    }

    public void setSegments(int segments) {
        this.segments = segments;
    }

    public Path getLightningPath() {
        return lightningPath;
    }

    public void setLightningPath(Path lightningPath) {
        this.lightningPath = lightningPath;
    }

    public float getJitter() {
        return jitter;
    }

    public void setJitter(float jitter) {
        this.jitter = jitter;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }
}
