package io.github.rosemoe.sora.widget.power;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.text.Cursor;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import ir.ninjacoder.ghostide.R;

public class PowerModeEffectManager {

  public enum EffectType {
    NONE(getString(R.string.none)),
    PARTICLE(getString(R.string.particle)),
    LIGHTNING(getString(R.string.lightning)),
    FLAME(getString(R.string.flame)),
    SPARK(getString(R.string.spark)),
    RAIN(getString(R.string.rain)),
    MAGIC(getString(R.string.magic)),
    EXPLOSION(getString(R.string.explosion));

    private String displayName;

    EffectType(String displayName) {
      this.displayName = displayName;
    }

    public String getType() {
      return displayName;
    }

    static String getString(int resId) {
      return GhostIdeAppLoader.getContext().getString(resId);
    }

    public static String[] getAllName() {
      EffectType[] values = values();
      String[] names = new String[values.length];
      for (int i = 0; i < values.length; i++) {
        names[i] = values[i].getType();
      }
      return names;
    }

    public static EffectType fromString(String str) {
      for (EffectType type : values()) {
        if (type.displayName.equalsIgnoreCase(str)) {
          return type;
        }
      }
      return NONE;
    }
  }

  private EffectType currentEffect = EffectType.MAGIC;
  private Paint particlePaint;
  private List<Particle> particles = new ArrayList<>();
  private Random random = new Random();
  private long lastUpdateTime;
  private CodeEditor editor;

  public PowerModeEffectManager(CodeEditor editor) {
    this.editor = editor;
    init();
  }

  private void init() {
    particlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    lastUpdateTime = System.currentTimeMillis();
  }

  public void setEffect(EffectType type) {
    this.currentEffect = type;
  }

  public void spawnEffectAtCursor() {
    if (editor == null) return;

    Cursor cursor = editor.getCursor();
    int line = cursor.getLeftLine();
    int column = cursor.getLeftColumn();

    // محاسبه موقعیت cursor روی صفحه
    float[] pos = editor.getLayout().getCharLayoutOffset(line, column);
    float x = pos[1] + editor.measureTextRegionOffset() - editor.getOffsetX();
    float y = pos[0] - editor.getOffsetY() + editor.getRowBaseline(0);

    switch (currentEffect) {
      case PARTICLE:
        spawnParticles(x, y);
        break;
      case LIGHTNING:
        spawnLightning(x, y);
        break;
      case FLAME:
        spawnFlame(x, y);
        break;
      case SPARK:
        spawnSpark(x, y);
        break;
      case RAIN:
        spawnRain(x, y);
        break;
      case MAGIC:
        spawnMagic(x, y);
        break;
      case EXPLOSION:
        spawnExplosion(x, y);
        break;
      case NONE:
        clearEffects();
        break;
    }

    editor.invalidate();
  }

  public void drawEffects(Canvas canvas) {
    long currentTime = System.currentTimeMillis();
    float deltaTime = (currentTime - lastUpdateTime) / 1000.0f;
    lastUpdateTime = currentTime;

    // به روزرسانی و رسم پارتیکل‌ها
    Iterator<Particle> iterator = particles.iterator();
    while (iterator.hasNext()) {
      Particle p = iterator.next();
      p.update(deltaTime);
      if (p.life <= 0) {
        iterator.remove();
      } else {
        p.draw(canvas, particlePaint);
      }
    }

    if (!particles.isEmpty()) {
      editor.postInvalidate();
    }
  }

  public void clearEffects() {
    particles.clear();
  }

  // --- متدهای spawn افکت‌ها ---
  private void spawnParticles(float x, float y) {
    for (int i = 0; i < 15; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 8 + 2;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;
      int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
      float size = random.nextFloat() * 5 + 2;
      float gravity = 0.2f;
      float friction = 0.97f;
      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction));
    }
  }

  private void spawnLightning(float x, float y) {
    int mainBranches = 2 + random.nextInt(3);

    for (int i = 0; i < mainBranches; i++) {
      float startX = x;
      float startY = y;
      float endX = x + (random.nextFloat() - 0.5f) * 500;
      float endY = y - random.nextInt(600) - 300;

      int mainColor = Color.argb(240, 70, 130, 255);
      int segments = 15 + random.nextInt(20);

      particles.add(new LightningParticle(startX, startY, endX, endY, mainColor, segments, 4f));

      int subBranches = 3 + random.nextInt(5);
      for (int j = 0; j < subBranches; j++) {
        float splitPoint = 0.3f + random.nextFloat() * 0.5f;
        float splitX = startX + (endX - startX) * splitPoint;
        float splitY = startY + (endY - startY) * splitPoint;

        float subEndX = splitX + (random.nextFloat() - 0.5f) * 200;
        float subEndY = splitY - random.nextInt(200) - 100;

        int subColor = Color.argb(200, 100, 160, 255);
        int subSegments = 8 + random.nextInt(10);

        particles.add(
            new LightningParticle(splitX, splitY, subEndX, subEndY, subColor, subSegments, 2f));
      }

      particles.add(
          new LightningGlow(
              startX, startY, endX, endY, Color.argb(100, 100, 180, 255), 20, segments));
    }

    for (int i = 0; i < 10; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float distance = random.nextFloat() * 100 + 50;
      float sparkX = x + (float) Math.cos(angle) * distance;
      float sparkY = y + (float) Math.sin(angle) * distance;

      int sparkColor = Color.argb(220, 200, 220, 255);
      float size = random.nextFloat() * 3 + 1;

      particles.add(
          new CircleParticle(
              x, y, (sparkX - x) * 0.1f, (sparkY - y) * 0.1f, sparkColor, size, 0, 0.9f, 10));
    }
  }

  private void spawnFlame(float x, float y) {
    for (int i = 0; i < 12; i++) {
      float dx = (random.nextFloat() - 0.5f) * 4;
      float dy = -random.nextFloat() * 8 - 4;
      int color = Color.argb(200, 255, 100 + random.nextInt(156), random.nextInt(100));
      float size = random.nextFloat() * 6 + 3;
      float gravity = -0.1f;
      float friction = 0.96f;
      int life = 30 + random.nextInt(30);
      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }
  }

  private void spawnSpark(float x, float y) {
    for (int i = 0; i < 10; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 15 + 5;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;
      int color = Color.argb(220, 255, 200 + random.nextInt(55), random.nextInt(100));
      float size = random.nextFloat() * 3 + 1;
      float gravity = 0.3f;
      float friction = 0.9f;
      int life = 15 + random.nextInt(10);
      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }
  }

  private void spawnRain(float x, float y) {
    for (int i = 0; i < 15; i++) {
      float angle = (float) Math.toRadians(75 + random.nextInt(10));
      float speed = random.nextFloat() * 25 + 15;

      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int blueShade = 150 + random.nextInt(106);
      int color = Color.argb(200, 100, 100, blueShade);

      float length = random.nextFloat() * 25 + 20;
      float thickness = random.nextFloat() * 1.5f + 1f;

      particles.add(new RainParticle(x, y, dx, dy, color, length, thickness));
    }
  }

  private void spawnMagic(float x, float y) {
    for (int i = 0; i < 30; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 5;
      float speed = random.nextFloat() * 6 + 2;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int[] magicColors = {
        Color.argb(220, 180, 70, 255), Color.argb(220, 70, 130, 255), Color.argb(220, 255, 70, 220)
      };
      int color = magicColors[random.nextInt(magicColors.length)];

      float size = random.nextFloat() * 4 + 2;
      float gravity = -0.05f;
      float friction = 0.98f;
      int life = 40 + random.nextInt(30);
      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }
  }

  private void spawnExplosion(float x, float y) {
    for (int i = 0; i < 25; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 20 + 5;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int color = Color.argb(220, 255, 100 + random.nextInt(156), random.nextInt(100));

      float size = random.nextFloat() * 8 + 4;
      float gravity = 0.4f;
      float friction = 0.92f;
      int life = 25 + random.nextInt(15);
      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }
  }

  // --- کلاس‌های پارتیکل ---
  private abstract class Particle {
    float x, y;
    int life;
    int alpha;
    int color;
    float gravity;
    float friction;

    Particle(float x, float y, int color, int life, float gravity, float friction) {
      this.x = x;
      this.y = y;
      this.color = color;
      this.life = life;
      this.alpha = 255;
      this.gravity = gravity;
      this.friction = friction;
    }

    void update(float deltaTime) {
      life--;
      alpha = (int) (255 * ((float) life / getInitialLife()));
    }

    int getInitialLife() {
      return 50;
    }

    abstract void draw(Canvas canvas, Paint paint);
  }

  private class CircleParticle extends Particle {
    float dx, dy;
    float size;
    int initialLife;

    CircleParticle(
        float x,
        float y,
        float dx,
        float dy,
        int color,
        float size,
        float gravity,
        float friction) {
      this(x, y, dx, dy, color, size, gravity, friction, 50);
    }

    CircleParticle(
        float x,
        float y,
        float dx,
        float dy,
        int color,
        float size,
        float gravity,
        float friction,
        int life) {
      super(x, y, color, life, gravity, friction);
      this.dx = dx;
      this.dy = dy;
      this.size = size;
      this.initialLife = life;
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);
      dy += gravity;
      dx *= friction;
      dy *= friction;
      x += dx * deltaTime * 60;
      y += dy * deltaTime * 60;
    }

    @Override
    int getInitialLife() {
      return initialLife;
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      paint.setColor(color);
      paint.setAlpha(alpha);
      canvas.drawCircle(x, y, size, paint);
    }
  }

  private class LightningParticle extends Particle {
    float endX, endY;
    int segments;
    Path lightningPath;
    float jitter;
    float thickness;

    LightningParticle(
        float startX,
        float startY,
        float endX,
        float endY,
        int color,
        int segments,
        float thickness) {
      super(startX, startY, color, 8, 0, 1);
      this.endX = endX;
      this.endY = endY;
      this.segments = segments;
      this.thickness = thickness;
      this.jitter = 30f;
      createLightningPath();
    }

    private void createLightningPath() {
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

        midX += (random.nextFloat() - 0.5f) * currentJitter;
        midY += (random.nextFloat() - 0.5f) * currentJitter;

        lightningPath.lineTo(midX, midY);
        prevX = midX;
        prevY = midY;
      }

      lightningPath.lineTo(endX, endY);
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);
      if (life % 3 == 0) {
        createLightningPath();
      }
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
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
  }

  private class LightningGlow extends Particle {
    float endX, endY;
    int segments;
    Path lightningPath;
    float glowSize;

    LightningGlow(
        float startX,
        float startY,
        float endX,
        float endY,
        int color,
        float glowSize,
        int segments) {
      super(startX, startY, color, 5, 0, 1);
      this.endX = endX;
      this.endY = endY;
      this.glowSize = glowSize;
      this.segments = segments;
      createLightningPath();
    }

    private void createLightningPath() {
      lightningPath = new Path();
      lightningPath.moveTo(x, y);

      float dx = (endX - x) / segments;
      float dy = (endY - y) / segments;

      float prevX = x;
      float prevY = y;

      for (int i = 1; i < segments; i++) {
        float midX = prevX + dx;
        float midY = prevY + dy;

        midX += (random.nextFloat() - 0.5f) * 15;
        midY += (random.nextFloat() - 0.5f) * 15;

        lightningPath.lineTo(midX, midY);
        prevX = midX;
        prevY = midY;
      }

      lightningPath.lineTo(endX, endY);
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
      paint.setColor(color);
      paint.setAlpha(alpha);
      paint.setStrokeWidth(glowSize);
      paint.setStyle(Paint.Style.STROKE);
      canvas.drawPath(lightningPath, paint);
    }
  }

  private class RainParticle extends Particle {
    float dx, dy;
    float length;
    float thickness;

    RainParticle(float x, float y, float dx, float dy, int color, float length, float thickness) {
      super(x, y, color, (int) (30 * (length / 25)), 0.5f, 1);
      this.dx = dx;
      this.dy = dy;
      this.length = length;
      this.thickness = thickness;
    }

    @Override
    void update(float deltaTime) {
      super.update(deltaTime);
      dy += gravity * 2;
      x += dx * deltaTime * 60;
      y += dy * deltaTime * 60;
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
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

    @Override
    int getInitialLife() {
      return (int) (30 * (length / 25));
    }
  }
}
