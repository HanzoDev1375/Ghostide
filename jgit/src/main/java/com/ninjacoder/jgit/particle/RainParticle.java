/**
 * Comment by ghost ide
 * @author: Ninjacoder
 */
package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Paint;

public class RainParticle extends Particle {

    protected float dx, dy;

    protected float length;

    protected float thickness;

    public RainParticle(float x, float y, float dx, float dy, int color, float length, float thickness) {
        super(x, y, color, (int) (30 * (length / 25)), 0.5f, 1);
        this.dx = dx;
        this.dy = dy;
        this.length = length;
        this.thickness = thickness;
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        dy += gravity * 2;
        x += dx * deltaTime * 60;
        y += dy * deltaTime * 60;
        // Note: getHeight() method should be implemented in the parent class or passed as parameter
        // if (y >= getHeight() && life > 5) {
        //     life = 5;
        // }
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setAlpha(alpha);
        paint.setStrokeWidth(thickness);
        float endX = x - dx * 0.3f;
        float endY = y - length;
        canvas.drawLine(x, y, endX, endY, paint);
        if (life > 5) {
            paint.setStrokeWidth(thickness * 1.5f);
            canvas.drawPoint(endX, endY, paint);
        }
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

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }
}
