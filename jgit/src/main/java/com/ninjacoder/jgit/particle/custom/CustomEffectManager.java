package com.ninjacoder.jgit.particle.custom;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import com.ninjacoder.jgit.particle.Particle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CustomEffectManager {
  private static final String TAG = "CustomEffectManager";

  private Map<String, CustomEffect> customEffects;
  private List<Particle> activeParticles;
  private Paint particlePaint;
  private long lastUpdateTime;

  public CustomEffectManager() {
    customEffects = new HashMap<>();
    activeParticles = new ArrayList<>();
    particlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    lastUpdateTime = System.currentTimeMillis();
  }

  /** ثبت یک افکت سفارشی جدید */
  public boolean registerEffect(CustomEffect effect) {
    if (effect == null) {
      Log.e(TAG, "Effect cannot be null");
      return false;
    }

    String name = effect.getName();
    if (customEffects.containsKey(name)) {
      Log.w(TAG, "Effect already registered: " + name);
      return false;
    }

    try {
      effect.initialize();
      customEffects.put(name, effect);
      Log.i(TAG, "Custom effect registered: " + name);
      return true;
    } catch (Exception e) {
      Log.e(TAG, "Failed to initialize effect: " + name, e);
      return false;
    }
  }

  /** حذف یک افکت */
  public boolean unregisterEffect(String effectName) {
    CustomEffect effect = customEffects.get(effectName);
    if (effect != null) {
      try {
        effect.cleanup();
      } catch (Exception e) {
        Log.e(TAG, "Error cleaning up effect: " + effectName, e);
      }
      customEffects.remove(effectName);
      Log.i(TAG, "Custom effect unregistered: " + effectName);
      return true;
    }
    return false;
  }

  /** دریافت لیست تمام افکت‌های ثبت شده */
  public List<CustomEffect> getAllEffects() {
    return new ArrayList<>(customEffects.values());
  }

  /** دریافت یک افکت خاص */
  public CustomEffect getEffect(String name) {
    return customEffects.get(name);
  }

  /** فعال کردن یک افکت در موقعیت مشخص */
  public void spawnEffect(String effectName, float x, float y, float intensity) {
    CustomEffect effect = customEffects.get(effectName);
    if (effect != null) {
      try {
        List<Particle> particles = effect.spawnParticles(x, y, intensity);
        if (particles != null) {
          activeParticles.addAll(particles);
        }
      } catch (Exception e) {
        Log.e(TAG, "Error spawning effect: " + effectName, e);
      }
    } else {
      Log.w(TAG, "Effect not found: " + effectName);
    }
  }

  /** به‌روزرسانی و رسم ذرات */
  public void drawEffects(Canvas canvas) {
    long currentTime = System.currentTimeMillis();
    float deltaTime = (currentTime - lastUpdateTime) / 1000.0f;
    lastUpdateTime = currentTime;

    Iterator<Particle> iterator = activeParticles.iterator();
    while (iterator.hasNext()) {
      Particle p = iterator.next();
      p.update(deltaTime);
      if (p.life <= 0) {
        iterator.remove();
      } else {
        p.draw(canvas, particlePaint);
      }
    }
  }

  /** پاک کردن تمام ذرات فعال */
  public void clearEffects() {
    activeParticles.clear();
  }

  /** بررسی آیا ذره فعالی وجود دارد یا نه */
  public boolean hasActiveEffects() {
    return !activeParticles.isEmpty();
  }
}
