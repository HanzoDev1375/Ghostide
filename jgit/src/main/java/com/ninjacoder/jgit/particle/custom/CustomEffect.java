package com.ninjacoder.jgit.particle.custom;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.List;
import com.ninjacoder.jgit.particle.Particle;

/** نویسنده نینجا کدر ایجاد شده برای پلاگین کاستوم */
public interface CustomEffect {
  /** نام نمایشی افکت */
  String getName();

  /** توضیحات افکت */
  String getDescription();

  /**
   * ایجاد ذرات جدید برای افکت
   *
   * @param x موقعیت X
   * @param y موقعیت Y
   * @param intensity شدت افکت
   * @return لیست ذرات ایجاد شده
   */
  List<Particle> spawnParticles(float x, float y, float intensity);

  /** تنظیمات اولیه افکت */
  void initialize();

  /** پاک کردن منابع افکت */
  void cleanup();
}
