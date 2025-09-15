/**
 * Comment by ghost ide
 * @author: Ninjacoder
 */
package com.ninjacoder.jgit.particle;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;

public class NeonParticle extends CircleParticle {

    protected Paint glowPaint;

    public NeonParticle(float x, float y, float dx, float dy, int color, float size, float gravity, float friction, int life) {
        super(x, y, dx, dy, color, size, gravity, friction, life);
        glowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        glowPaint.setColor(color);
        glowPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        // Draw glow
        glowPaint.setAlpha(alpha / 2);
        canvas.drawCircle(x, y, size * 2, glowPaint);
        // Draw core
        paint.setColor(color);
        paint.setAlpha(alpha);
        canvas.drawCircle(x, y, size, paint);
    }

    public Paint getGlowPaint() {
        return glowPaint;
    }

    public void setGlowPaint(Paint glowPaint) {
        this.glowPaint = glowPaint;
    }
}
