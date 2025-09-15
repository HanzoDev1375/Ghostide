/**
 * Comment by ghost ide
 * @author: Ninjacoder
 */
package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GlitchParticle extends Particle {

    protected float dx, dy;

    protected float size;

    public GlitchParticle(float x, float y, float dx, float dy, int color, float size, int life) {
        super(x, y, color, life, 0, 1);
        this.dx = dx;
        this.dy = dy;
        this.size = size;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        // Glitch particles don't move smoothly
        if (life % 3 == 0) {
            x += dx;
            y += dy;
        }
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setAlpha(alpha);
        // Draw glitch as a rectangle
        canvas.drawRect(x - size / 2, y - size / 2, x + size / 2, y + size / 2, paint);
    }

    // Getter and Setter methods
    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
