/**
 * Comment by ghost ide
 * @author: Ninjacoder
 */
package com.ninjacoder.jgit.particle;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class LightningGlow extends Particle {

    protected float endX, endY;

    protected int segments;

    protected Path lightningPath;

    protected float glowSize;

    public LightningGlow(float startX, float startY, float endX, float endY, int color, float glowSize, int segments) {
        super(startX, startY, color, 5, 0, 1);
        this.endX = endX;
        this.endY = endY;
        this.glowSize = glowSize;
        this.segments = segments;
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
            midX += (Math.random() - 0.5) * 15;
            midY += (Math.random() - 0.5) * 15;
            lightningPath.lineTo(midX, midY);
            prevX = midX;
            prevY = midY;
        }
        lightningPath.lineTo(endX, endY);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setAlpha(alpha);
        paint.setStrokeWidth(glowSize);
        paint.setStyle(Paint.Style.STROKE);
        paint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
        canvas.drawPath(lightningPath, paint);
        paint.setMaskFilter(null);
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

    public float getGlowSize() {
        return glowSize;
    }

    public void setGlowSize(float glowSize) {
        this.glowSize = glowSize;
    }
}
