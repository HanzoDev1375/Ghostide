/**
 * Comment by ghost ide
 * @author: Ninjacoder
 */
package com.ninjacoder.jgit.particle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;

public class RadialGlowParticle extends Particle {

    protected float radius;

    public RadialGlowParticle(float x, float y, int color, float radius, int life) {
        super(x, y, color, life, 0, 1);
        this.radius = radius;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        RadialGradient gradient = new RadialGradient(x, y, radius, Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color)), Color.TRANSPARENT, Shader.TileMode.CLAMP);
        paint.setShader(gradient);
        canvas.drawCircle(x, y, radius, paint);
        paint.setShader(null);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
