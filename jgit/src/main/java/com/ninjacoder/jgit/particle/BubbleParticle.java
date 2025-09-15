/**
 * Comment by ghost ide
 * @author: Ninjacoder
 */
package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BubbleParticle extends CircleParticle {

    protected float waveAmount;

    protected float waveSpeed;

    public BubbleParticle(float x, float y, float dx, float dy, int color, float size, float gravity, float friction, int life) {
        super(x, y, dx, dy, color, size, gravity, friction, life);
        this.waveAmount = (float) (Math.random() * 0.5);
        this.waveSpeed = (float) (Math.random() * 2 + 1);
    }

    @Override
    public void update(float deltaTime) {
        // Add horizontal wave motion
        x += (float) Math.sin(waveSpeed * life * 0.1) * waveAmount;
        super.update(deltaTime);
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        // Draw bubble with highlight
        paint.setColor(color);
        paint.setAlpha(alpha);
        canvas.drawCircle(x, y, size, paint);
        // Draw highlight
        paint.setColor(Color.argb(alpha / 2, 255, 255, 255));
        canvas.drawCircle(x - size / 3, y - size / 3, size / 4, paint);
    }

    // Getter and Setter methods
    public float getWaveAmount() {
        return waveAmount;
    }

    public void setWaveAmount(float waveAmount) {
        this.waveAmount = waveAmount;
    }

    public float getWaveSpeed() {
        return waveSpeed;
    }

    public void setWaveSpeed(float waveSpeed) {
        this.waveSpeed = waveSpeed;
    }
}
