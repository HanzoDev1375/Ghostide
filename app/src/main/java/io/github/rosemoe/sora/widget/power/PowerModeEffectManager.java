package io.github.rosemoe.sora.widget.power;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.SparseArray;
import com.ninjacoder.jgit.particle.Particle;
import android.graphics.Bitmap;
import com.ninjacoder.jgit.particle.SparkleParticle;
import com.ninjacoder.jgit.particle.CircleParticle;
import com.ninjacoder.jgit.particle.LightningParticle;
import com.ninjacoder.jgit.particle.LightningGlow;
import com.ninjacoder.jgit.particle.SmokeParticle;
import com.ninjacoder.jgit.particle.RainParticle;
import com.ninjacoder.jgit.particle.StarParticle;
import com.ninjacoder.jgit.particle.ShockwaveParticle;
import com.ninjacoder.jgit.particle.BubbleParticle;
import com.ninjacoder.jgit.particle.NeonParticle;
import com.ninjacoder.jgit.particle.RadialGlowParticle;
import com.ninjacoder.jgit.particle.GlitchParticle;
import com.ninjacoder.jgit.particle.SpiralParticle;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.text.Cursor;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
    EXPLOSION(getString(R.string.explosion)),
    BUBBLES(getString(R.string.bubbles)),
    NEON(getString(R.string.neon)),
    GLITCH(getString(R.string.glitch)),
    GALAXY(getString(R.string.galaxy)),
    TYPING(getString(R.string.typing));

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
  private boolean enableScreenShake = true;
  private float shakeIntensity = 1.0f;
  private boolean enableSoundEffects = false;
  private boolean enableColorCycling = true;
  private float effectIntensity = 1.0f;
  private Map<Character, Integer> charColors = new HashMap<>();
  private SparseArray<Long> lastCharTime = new SparseArray<>();
  private int[] rainbowColors;
  private int colorIndex = 0;
  private long lastColorChangeTime = 0;
  private Bitmap sparkleBitmap;
  private Bitmap starBitmap;

  public PowerModeEffectManager(CodeEditor editor) {
    this.editor = editor;
    init();
  }

  private void init() {
    particlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    lastUpdateTime = System.currentTimeMillis();
    rainbowColors = new int[] {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
    sparkleBitmap = createSparkleBitmap(20);
    starBitmap = createStarBitmap(15);
  }

  public void setEffect(EffectType type) {
    this.currentEffect = type;
  }

  public void spawnEffectAtCursor() {
    if (editor == null) return;

    Cursor cursor = editor.getCursor();
    int line = cursor.getLeftLine();
    int column = cursor.getLeftColumn();

    float[] pos = editor.getLayout().getCharLayoutOffset(line, column);
    float x = editor.getOffset(line, column);
    float y = editor.getRowTop(line) - editor.getOffsetY() + editor.getRowHeight() / 2f;

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
      case BUBBLES:
        spawnBubbles(x, y);
        break;
      case NEON:
        spawnNeonEffect(x, y);
        break;
      case GLITCH:
        spawnGlitchEffect(x, y);
        break;
      case GALAXY:
        spawnGalaxyEffect(x, y);
        break;
      case TYPING:
        spawnTypingEffect(x, y);
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

  private void spawnParticles(float x, float y) {
    int count = (int) (15 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 8 * effectIntensity + 2;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int color;
      if (enableColorCycling) {
        color = getCyclingColor();
      } else {
        color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
      }

      float size = random.nextFloat() * 5 * effectIntensity + 2;
      float gravity = 0.2f * effectIntensity;
      float friction = 0.97f;
      int life = (int) (30 + random.nextInt(20) * effectIntensity);

      if (random.nextFloat() < 0.3f) {
        particles.add(
            new SparkleParticle(x, y, dx, dy, color, size, gravity, friction, life, sparkleBitmap));
      } else {
        particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
      }
    }
  }

  private void spawnLightning(float x, float y) {
    int mainBranches = (int) (2 + random.nextInt(3) * effectIntensity);

    for (int i = 0; i < mainBranches; i++) {
      float startX = x;
      float startY = y;
      float endX = x + (random.nextFloat() - 0.5f) * 200 * effectIntensity;
      float endY = y - random.nextInt((int) (600 * effectIntensity)) - 300;

      int mainColor = Color.argb(240, 70, 130, 255);
      int segments = (int) (15 + random.nextInt(10) * effectIntensity);

      particles.add(
          new LightningParticle(
              startX, startY, endX, endY, mainColor, segments, 4f * effectIntensity));

      int subBranches = (int) (3 + random.nextInt(5) * effectIntensity);
      for (int j = 0; j < subBranches; j++) {
        float splitPoint = 0.3f + random.nextFloat() * 0.5f;
        float splitX = startX + (endX - startX) * splitPoint;
        float splitY = startY + (endY - startY) * splitPoint;

        float subEndX = splitX + (random.nextFloat() - 0.5f) * 200 * effectIntensity;
        float subEndY = splitY - random.nextInt((int) (200 * effectIntensity)) - 100;

        int subColor = Color.argb(200, 100, 160, 255);
        int subSegments = (int) (8 + random.nextInt(10) * effectIntensity);

        particles.add(
            new LightningParticle(
                splitX, splitY, subEndX, subEndY, subColor, subSegments, 2f * effectIntensity));
      }

      particles.add(
          new LightningGlow(
              startX,
              startY,
              endX,
              endY,
              Color.argb(100, 100, 180, 255),
              20 * effectIntensity,
              segments));
    }

    for (int i = 0; i < 4 * effectIntensity; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float distance = random.nextFloat() * 100 * effectIntensity + 50;
      float sparkX = x + (float) Math.cos(angle) * distance;
      float sparkY = y + (float) Math.sin(angle) * distance;

      int sparkColor = Color.argb(220, 200, 220, 255);
      float size = random.nextFloat() * 3 * effectIntensity + 1;

      particles.add(
          new CircleParticle(
              x, y, (sparkX - x) * 0.1f, (sparkY - y) * 0.1f, sparkColor, size, 0, 0.9f, 10));
    }
  }

  private void spawnFlame(float x, float y) {
    int count = (int) (12 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float dx = (random.nextFloat() - 0.5f) * 4 * effectIntensity;
      float dy = -random.nextFloat() * 8 * effectIntensity - 4;

      int color = Color.argb(200, 255, 100 + random.nextInt(156), random.nextInt(100));

      float size = random.nextFloat() * 6 * effectIntensity + 3;
      float gravity = -0.1f * effectIntensity;
      float friction = 0.96f;
      int life = (int) (30 + random.nextInt(30) * effectIntensity);

      if (random.nextFloat() < 0.2f) {
        particles.add(
            new SmokeParticle(
                x,
                y,
                dx * 0.5f,
                dy * 0.7f,
                Color.argb(150, 100, 100, 100),
                size * 1.5f,
                gravity * 0.3f,
                friction,
                life * 2));
      } else {
        particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
      }
    }
  }

  private void spawnSpark(float x, float y) {
    int count = (int) (10 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 15 * effectIntensity + 5;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int color = Color.argb(220, 255, 200 + random.nextInt(55), random.nextInt(100));
      float size = random.nextFloat() * 3 * effectIntensity + 1;
      float gravity = 0.3f * effectIntensity;
      float friction = 0.9f;
      int life = (int) (15 + random.nextInt(10) * effectIntensity);

      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }
  }

  private void spawnRain(float x, float y) {
    int count = (int) (20 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = (float) Math.toRadians(75 + random.nextInt(10));
      float speed = random.nextFloat() * 25 * effectIntensity + 15;

      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int blueShade = 150 + random.nextInt(106);
      int color = Color.argb(200, 100, 100, blueShade);

      float length = random.nextFloat() * 25 * effectIntensity + 20;
      float thickness = random.nextFloat() * 1.5f * effectIntensity + 1f;

      particles.add(new RainParticle(x, y, dx, dy, color, length, thickness));
    }

    spawnRainSplash(x, editor.getHeight());
  }

  private void spawnRainSplash(float x, float groundLevel) {
    for (int i = 0; i < 5 * effectIntensity; i++) {
      float splashX = x + (random.nextFloat() - 0.5f) * 30 * effectIntensity;
      float splashY = groundLevel - 5;

      for (int j = 0; j < 3 * effectIntensity; j++) {
        float angle = (float) (Math.PI / 2 + (random.nextFloat() - 0.5f) * Math.PI / 4);
        float speed = random.nextFloat() * 5 * effectIntensity + 2;

        float dx = (float) Math.cos(angle) * speed;
        float dy = -(float) Math.sin(angle) * speed;

        int color = Color.argb(180, 150, 150, 255);
        float size = random.nextFloat() * 2 * effectIntensity + 1;

        particles.add(new CircleParticle(splashX, splashY, dx, dy, color, size, 0.4f, 0.9f, 15));
      }
    }
  }

  private void spawnMagic(float x, float y) {
    int count = (int) (20 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 6 * effectIntensity + 2;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int[] magicColors = {
        Color.argb(220, 180, 70, 255), Color.argb(220, 70, 130, 255), Color.argb(220, 255, 70, 220)
      };
      int color = magicColors[random.nextInt(magicColors.length)];

      float size = random.nextFloat() * 4 * effectIntensity + 2;
      float gravity = -0.05f * effectIntensity;
      float friction = 0.98f;
      int life = (int) (40 + random.nextInt(30) * effectIntensity);

      if (random.nextFloat() < 0.15f) {
        particles.add(
            new StarParticle(
                x, y, dx, dy, color, size * 1.5f, gravity, friction, life, starBitmap));
      } else {
        particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
      }
    }
  }

  private void spawnExplosion(float x, float y) {
    int count = (int) (25 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 20 * effectIntensity + 5;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int color = Color.argb(220, 255, 100 + random.nextInt(156), random.nextInt(100));

      float size = random.nextFloat() * 8 * effectIntensity + 4;
      float gravity = 0.4f * effectIntensity;
      float friction = 0.92f;
      int life = (int) (25 + random.nextInt(15) * effectIntensity);

      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }

    particles.add(
        new ShockwaveParticle(x, y, Color.argb(150, 255, 200, 50), 100 * effectIntensity, 30));
  }

  private void spawnBubbles(float x, float y) {
    int count = (int) (13 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float dx = (random.nextFloat() - 0.5f) * 2 * effectIntensity;
      float dy = -random.nextFloat() * 6 * effectIntensity - 2;

      int color = Color.argb(180, 150, 220, 255);
      float size = random.nextFloat() * 15 * effectIntensity + 5;
      float gravity = -0.15f * effectIntensity;
      float friction = 0.99f;
      int life = (int) (60 + random.nextInt(40) * effectIntensity);

      particles.add(new BubbleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }
  }

  private void spawnNeonEffect(float x, float y) {
    int count = (int) (15 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 4 * effectIntensity + 1;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int[] neonColors = {
        Color.argb(220, 255, 50, 50),
        Color.argb(220, 50, 255, 50),
        Color.argb(220, 50, 50, 255),
        Color.argb(220, 255, 50, 255),
        Color.argb(220, 50, 255, 255),
        Color.argb(220, 255, 255, 50)
      };
      int color = neonColors[random.nextInt(neonColors.length)];

      float size = random.nextFloat() * 6 * effectIntensity + 3;
      float gravity = 0.05f * effectIntensity;
      float friction = 0.95f;
      int life = (int) (40 + random.nextInt(20) * effectIntensity);

      particles.add(new NeonParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }

    particles.add(
        new RadialGlowParticle(x, y, Color.argb(100, 100, 255, 255), 80 * effectIntensity, 20));
  }

  private void spawnGlitchEffect(float x, float y) {
    int count = (int) (10 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float dx = (random.nextFloat() - 0.5f) * 10 * effectIntensity;
      float dy = (random.nextFloat() - 0.5f) * 10 * effectIntensity;

      int color =
          Color.argb(
              200, random.nextInt(100) + 155, random.nextInt(100) + 50, random.nextInt(100) + 155);

      float size = random.nextFloat() * 8 * effectIntensity + 4;
      int life = (int) (15 + random.nextInt(10) * effectIntensity);

      particles.add(new GlitchParticle(x, y, dx, dy, color, size, life));
    }

    if (enableScreenShake) {
      editor.postDelayed(() -> shakeScreen(5 * shakeIntensity), 10);
    }
  }

  private void spawnGalaxyEffect(float x, float y) {
    int count = (int) (20 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 5 * effectIntensity + 1;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed;

      int[] galaxyColors = {
        Color.argb(220, 150, 100, 255),
        Color.argb(220, 100, 150, 255),
        Color.argb(220, 255, 100, 200),
        Color.argb(220, 100, 255, 200)
      };
      int color = galaxyColors[random.nextInt(galaxyColors.length)];

      float size = random.nextFloat() * 4 * effectIntensity + 2;
      float gravity = -0.02f * effectIntensity;
      float friction = 0.98f;
      int life = (int) (50 + random.nextInt(30) * effectIntensity);

      if (random.nextFloat() < 0.25f) {
        particles.add(
            new StarParticle(x, y, dx, dy, color, size * 2, gravity, friction, life, starBitmap));
      } else {
        particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
      }
    }

    particles.add(
        new SpiralParticle(x, y, Color.argb(150, 200, 150, 255), 100 * effectIntensity, 40));
  }

  private void spawnTypingEffect(float x, float y) {
    int count = (int) (10 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float dx = (random.nextFloat() - 0.5f) * 3 * effectIntensity;
      float dy = -random.nextFloat() * 5 * effectIntensity - 2;

      int color = getCyclingColor();
      float size = random.nextFloat() * 4 * effectIntensity + 2;
      float gravity = 0.1f * effectIntensity;
      float friction = 0.95f;
      int life = (int) (20 + random.nextInt(10) * effectIntensity);

      particles.add(new CircleParticle(x, y, dx, dy, color, size, gravity, friction, life));
    }
  }

  private int getCyclingColor() {
    if (System.currentTimeMillis() - lastColorChangeTime > 100) {
      colorIndex = (colorIndex + 1) % rainbowColors.length;
      lastColorChangeTime = System.currentTimeMillis();
    }
    return rainbowColors[colorIndex];
  }

  private void shakeScreen(float intensity) {
    if (!enableScreenShake) return;

    final float shakeRange = intensity * 5f;
    final int duration = 300;
    final long startTime = System.currentTimeMillis();

    final Runnable shakeRunnable =
        new Runnable() {
          @Override
          public void run() {
            long elapsed = System.currentTimeMillis() - startTime;
            if (elapsed < duration) {
              float progress = (float) elapsed / duration;
              float offsetX = (random.nextFloat() - 0.5f) * shakeRange * (1 - progress);
              float offsetY = (random.nextFloat() - 0.5f) * shakeRange * (1 - progress);

              editor.setTranslationX(offsetX);
              editor.setTranslationY(offsetY);

              editor.postDelayed(this, 16);
            } else {
              editor.setTranslationX(0);
              editor.setTranslationY(0);
            }
          }
        };

    editor.post(shakeRunnable);
  }

  private Bitmap createSparkleBitmap(int size) {
    Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    paint.setColor(Color.WHITE);
    canvas.drawCircle(size / 2, size / 2, size / 4, paint);

    for (int i = 0; i < 8; i++) {
      float angle = (float) (i * Math.PI / 4);
      float x1 = (float) (size / 2 + Math.cos(angle) * size / 4);
      float y1 = (float) (size / 2 + Math.sin(angle) * size / 4);
      float x2 = (float) (size / 2 + Math.cos(angle) * size / 2);
      float y2 = (float) (size / 2 + Math.sin(angle) * size / 2);

      paint.setStrokeWidth(2);
      canvas.drawLine(x1, y1, x2, y2, paint);
    }

    return bitmap;
  }

  private Bitmap createStarBitmap(int size) {
    Bitmap bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bitmap);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    paint.setColor(Color.WHITE);

    Path path = new Path();
    path.moveTo(size / 2, 0);
    path.lineTo(size * 0.6f, size * 0.4f);
    path.lineTo(size, size * 0.4f);
    path.lineTo(size * 0.7f, size * 0.6f);
    path.lineTo(size * 0.8f, size);
    path.lineTo(size / 2, size * 0.7f);
    path.lineTo(size * 0.2f, size);
    path.lineTo(size * 0.3f, size * 0.6f);
    path.lineTo(0, size * 0.4f);
    path.lineTo(size * 0.4f, size * 0.4f);
    path.close();

    canvas.drawPath(path, paint);
    return bitmap;
  }
}
