package io.github.rosemoe.sora.widget.power;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.util.SparseArray;
import com.caverock.androidsvg.SVG;
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
import com.ninjacoder.jgit.particle.*;
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
    TYPING(getString(R.string.typing)),
    LIGHTNING_SVG("Lightning SVG"),
    GHOST("ghost");

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
  private SVG ghostSvg;

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
    String svgcode =
        """
    <!-- Created with Ghost ide -->
    <svg
      xmlns="http://www.w3.org/2000/svg"
      viewBox="0 0 64 64">
      <path
        fill="#000000"
        d="M 60.985 33.653 c-1.303-1.516-2.152-1.709-3.5-.789 c -.632.432-1.648 1.12-4.208 1.022 c .085-1.651.166-3.357.241-5.172 l .07-1.609 c .352-6.754-2.137-13.46-6.826-18.398 C 42.657 4.383 37.413 2 31.997 2 c-5.418 0-10.662 2.383-14.768 6.707 c-4.688 4.938-7.176 11.645-6.826 18.398 c .02.343.043.907.072 1.651 c .074 1.792.155 3.476.239 5.108 c-2.55.102-3.563-.579-4.192-1.007 c-1.346-.912-2.197-.721-3.506.802 c-1.025 1.195-1.291 2.842-.725 4.519 c 1.035 3.07 4.377 5.72 9.211 7.437 c .751 8.43 1.73 13.334 2.992 15.073 c .632.872 1.398 1.312 2.275 1.312 c 1.314 0 2.496-1.012 3.748-2.084 c 1.271-1.088 2.584-2.213 3.887-2.213 c 1.455 0 2.162.78 3.057 1.768 c .98 1.08 2.197 2.424 4.541 2.424 c 2.34 0 3.557-1.344 4.535-2.423 c .895-.988 1.602-1.769 3.061-1.769 c 1.299 0 2.611 1.125 3.883 2.213 C 44.729 60.988 45.913 62 47.228 62 c .877 0 1.641-.441 2.271-1.313 c 1.264-1.747 2.244-6.654 2.993-15.086 c 5.54-1.997 8.388-5.01 9.212-7.462 c .568-1.691.313-3.285-.719-4.486 m-1.177 3.85 c -.795 2.364-4.377 5.698-11.855 7.313 a 1 1 0 1 0 .422 1.955 c .717-.155 1.392-.33 2.046-.514 c -.828 8.859-1.777 12.202-2.542 13.258 c -.352.485-.576.485-.65.485 c -.576 0-1.57-.853-2.447-1.604 c-1.475-1.263-3.145-2.693-5.184-2.693 c-2.346 0-3.564 1.345-4.543 2.426 c -.895.986-1.6 1.766-3.053 1.766 c-1.457 0-2.164-.78-3.059-1.768 c -.979-1.08-2.197-2.424-4.539-2.424 c-2.041 0-3.713 1.431-5.188 2.693 c -.877.752-1.873 1.604-2.447 1.604 c -.074 0-.301 0-.654-.486 c -.762-1.051-1.711-4.388-2.537-13.247 c .662.184 1.339.354 2.043.505 a 1.002 1.002 0 0 0 1.188-.771 a 1.003 1.003 0 0 0-.771-1.187 C 8.567 43.222 4.985 39.9 4.188 37.539 c -.24-.712-.375-1.736.348-2.576 c .32-.372.508-.543.607-.619 c .078.047.178.115.258.17 c 1.16.785 3.318 2.25 10.084.631 a 1 1 0 1 0-.465-1.945 c -.859.206-1.62.352-2.311.459 a 494.637 494.637 0 0 1-.232-4.986 c -.031-.752-.057-1.324-.074-1.671 c -.322-6.209 1.967-12.375 6.279-16.918 c 3.725-3.923 8.453-6.083 13.316-6.083 c 4.861 0 9.592 2.16 13.316 6.083 c 4.313 4.543 6.602 10.709 6.277 16.918 c -.018.341-.039.897-.068 1.63 a 530.934 530.934 0 0 1-.235 5.053 a 28.427 28.427 0 0 1-2.278-.447 a 1.002 1.002 0 0 0-1.205.743 a 1.002 1.002 0 0 0 .744 1.204 c 6.754 1.593 8.908.123 10.066-.669 c .08-.055.178-.122.256-.17 c .1.078.283.246.596.61 c .71.827.577 1.842.341 2.547" />
      <path
        fill="#000000"
        d="M 41.403 16.707 c-3.759 0-6.816 3.412-6.816 7.606 c 0 4.191 3.058 7.601 6.816 7.601 c 3.76 0 6.818-3.409 6.818-7.601 c .001-4.194-3.058-7.606-6.818-7.606 m 0 13.707 c-2.932 0-5.316-2.736-5.316-6.101 c 0-3.367 2.385-6.106 5.316-6.106 c 2.933 0 5.318 2.739 5.318 6.106 c .001 3.365-2.385 6.101-5.318 6.101" />
      <path
        fill="#000000"
        d="M 41.403 19.811 c-2.199 0-3.984 2.011-3.984 4.499 c 0 2.484 1.785 4.501 3.984 4.501 s 3.982-2.017 3.982-4.501 c .001-2.489-1.782-4.499-3.982-4.499" />
      <path
        fill="#f1877"
        d="M 34.261 22.286 c 0-5.455-4.146-9.893-9.244-9.893 c-5.095 0-9.24 4.438-9.24 9.893 c 0 5.449 4.146 9.882 9.24 9.882 c 5.097 0 9.244-4.433 9.244-9.882 m-16.985 0 c 0-4.628 3.473-8.393 7.74-8.393 c 4.271 0 7.744 3.765 7.744 8.393 c 0 4.622-3.474 8.382-7.744 8.382 c-4.267 0-7.74-3.76-7.74-8.382" />
      <path
        fill="#000"
        d="M 30.595 22.28 c 0-3.317-2.498-6-5.578-6 s-5.576 2.683-5.576 6 c 0 3.314 2.496 6 5.576 6 s 5.578-2.685 5.578-6" />
      <path
        fill="#000000"
        d="M 20.624 35.367 c 0 2.238 1.419 4.303 3.688 5.793 c -.087.701-.088 1.585-.088 2.679 c 0 5.471 3.329 9.006 8.482 9.006 c 5.154 0 8.484-3.535 8.484-9.01 c 0-1.194-.001-2.037-.078-2.68 c 2.262-1.491 3.678-3.553 3.678-5.788 c 0 0-5.754 1.284-12.084 1.284 s-12.082-1.284-12.082-1.284 m 12.082 15.978 c-3.376 0-6.982-1.972-6.982-7.506 c 0-3.304 0-3.304 1.091-3.304 c .419 0 .936.035 1.574.078 c .814.055 1.871.123 3.165.152 l 1.152 8.688 l 1.152-8.688 a 68.935 68.935 0 0 0 3.168-.152 c .639-.043 1.155-.078 1.574-.078 c .805 0 .854.126.911.272 c .179.455.179 1.479.179 3.031 c 0 5.535-3.608 7.507-6.984 7.507" />
    </svg>
    """;
    try {
      ghostSvg = SVG.getFromString(svgcode);
    } catch (Exception err) {
      Log.e("Svg render Error:", err.getLocalizedMessage());
    }
  }

  private void spawnGhostEffect(float x, float y) {
    if (ghostSvg == null) return;

    // آرایه‌ای از رنگ‌های زیبا
    int[] ghostColors = {
      Color.argb(220, 255, 100, 100), // قرمز
      Color.argb(220, 100, 255, 100), // سبز
      Color.argb(220, 100, 100, 255), // آبی
      Color.argb(220, 255, 255, 100), // زرد
      Color.argb(220, 255, 100, 255), // بنفش
      Color.argb(220, 100, 255, 255), // فیروزه‌ای
      Color.argb(220, 255, 150, 50), // نارنجی
      Color.argb(220, 200, 100, 255) // ارغوانی
    };

    int count = (int) (10 * effectIntensity);
    for (int i = 0; i < count; i++) {
      float angle = random.nextFloat() * (float) Math.PI * 2;
      float speed = random.nextFloat() * 6 * effectIntensity + 2;
      float dx = (float) Math.cos(angle) * speed;
      float dy = (float) Math.sin(angle) * speed - 3;

      float size = random.nextFloat() * 60 * effectIntensity + 30;
      float gravity = 0.1f * effectIntensity;
      float friction = 0.97f;
      int life = (int) (40 + random.nextInt(30) * effectIntensity);
      float rotationSpeed = (random.nextFloat() - 0.5f) * 8 * effectIntensity;

      // انتخاب رنگ رندوم از آرایه
      int ghostColor = ghostColors[random.nextInt(ghostColors.length)];

      particles.add(
          new SvgParticle(
              x, y, ghostSvg, size, dx, dy, gravity, friction, life, rotationSpeed, ghostColor));
    }
  }

  private void spawnLightningSvgEffect(float x, float y) {
    if (ghostSvg == null) return;

    // رنگ‌های رعد و برق
    int[] lightningColors = {
      Color.argb(220, 70, 130, 255), // آبی
      Color.argb(220, 100, 160, 255), // آبی روشن
      Color.argb(220, 140, 190, 255) // آبی خیلی روشن
    };

    int[] glowColors = {
      Color.argb(150, 50, 100, 255), // درخشش آبی
      Color.argb(150, 80, 150, 255), // درخشش آبی روشن
      Color.argb(150, 120, 200, 255) // درخشش آبی خیلی روشن
    };

    int count = (int) (8 * effectIntensity);

    for (int i = 0; i < count; i++) {
      // جهت‌های مختلف: بالا، پایین، چپ، راست
      float direction = random.nextFloat() * (float) Math.PI * 2;
      boolean isUpDown = random.nextBoolean();

      float speed;
      if (isUpDown) {
        // بالا یا پایین
        speed = random.nextFloat() * 12 * effectIntensity + 6;
      } else {
        // چپ یا راست
        speed = random.nextFloat() * 8 * effectIntensity + 4;
      }

      float dx = (float) Math.cos(direction) * speed;
      float dy = (float) Math.sin(direction) * speed;

      float size = random.nextFloat() * 40 * effectIntensity + 20;
      float gravity = 0.05f * effectIntensity;
      float friction = 0.97f;
      int life = (int) (25 + random.nextInt(15) * effectIntensity);
      float rotationSpeed = (random.nextFloat() - 0.5f) * 15 * effectIntensity;

      int colorIndex = random.nextInt(lightningColors.length);
      int mainColor = lightningColors[colorIndex];
      int glowColor = glowColors[colorIndex];
      particles.add(
          new LightningSvgParticle(
              x, y, size, dx, dy, gravity, friction, life, rotationSpeed, mainColor, glowColor));
    }
    spawnGhostEffect(x, y);
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
      case GHOST:
        spawnGhostEffect(x, y);
        break;

      case LIGHTNING_SVG:
        spawnLightningSvgEffect(x, y);
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
