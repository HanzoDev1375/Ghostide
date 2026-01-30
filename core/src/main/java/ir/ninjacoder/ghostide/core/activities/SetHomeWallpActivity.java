package ir.ninjacoder.ghostide.core.activities;

import android.app.WallpaperManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;
import androidx.core.graphics.ColorUtils;
import androidx.viewpager2.widget.ViewPager2;
import ir.ninjacoder.ghostide.core.databinding.ActivitySetWallpaperBinding;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ir.ninjacoder.ghostide.core.marco.wallpapers.WallpaperPagerAdapter;

public class SetHomeWallpActivity extends BaseCompat {

  private List<String> images;
  private WallpaperPagerAdapter ad;
  private ActivitySetWallpaperBinding bind;

  @Override
  protected void onCreate(Bundle b) {
    super.onCreate(b);
    bind = ActivitySetWallpaperBinding.inflate(getLayoutInflater());
    setContentView(bind.getRoot());
    setSupportActionBar(bind.toolbar);

    String path = getIntent().getStringExtra("path");
    images = loadImages(path);

    int startIndex = findStartIndex(images, path);
    ad = new WallpaperPagerAdapter(this, images);
    bind.viewPager.setAdapter(ad);
    bind.viewPager.setCurrentItem(startIndex, false);
    if (!images.isEmpty()) {
      bind.fab.setVisibility(canSetWallpaper(images.get(startIndex)) ? View.VISIBLE : View.GONE);
    }
    bind.viewPager.registerOnPageChangeCallback(
        new ViewPager2.OnPageChangeCallback() {

          @Override
          public void onPageScrollStateChanged(int arg0) {
            super.onPageScrollStateChanged(arg0);
          }

          @Override
          public void onPageScrolled(int arg0, float arg1, int arg2) {
            super.onPageScrolled(arg0, arg1, arg2);
          }

          @Override
          public void onPageSelected(int position) {
            String currentPath = images.get(position);
            bind.fab.setVisibility(canSetWallpaper(currentPath) ? View.VISIBLE : View.GONE);
            bind.toolbar.setSubtitle(currentPath);
          }
        });
    Drawable bg = bind.toolbar.getBackground();
    int originalColor =
        (bg instanceof ColorDrawable)
            ? ((ColorDrawable) bg).getColor()
            : getResources().getColor(android.R.color.black);

    bind.toolbar.setBackgroundTintList(
        ColorStateList.valueOf(ColorUtils.setAlphaComponent(originalColor, 40)));

    ad.setOnItemClickListener(
        (pos, view) -> {
          
          if (bind.toolbar.getVisibility() == View.VISIBLE) {
            bind.toolbar
                .animate()
                .scaleX(0f)
                .scaleY(0f)
                .alpha(0f)
                .setDuration(300)
                .setInterpolator(new AccelerateInterpolator())
                .withEndAction(() -> bind.toolbar.setVisibility(View.GONE))
                .start();
            bind.fab
                .animate()
                .scaleX(0f)
                .scaleY(0f)
                .alpha(0f)
                .setDuration(300)
                .setInterpolator(new AccelerateInterpolator())
                .withEndAction(() -> bind.fab.setVisibility(View.GONE))
                .start();

          } else {
            bind.toolbar.setVisibility(View.VISIBLE);
            bind.toolbar.setScaleX(0f);
            bind.toolbar.setScaleY(0f);
            bind.toolbar.setAlpha(0f);

            bind.toolbar
                .animate()
                .scaleX(1f)
                .scaleY(1f)
                .alpha(1f)
                .setDuration(300)
                .setInterpolator(new OvershootInterpolator(1.0f))
                .start();
            String currentPath = images.get(bind.viewPager.getCurrentItem());
            if (canSetWallpaper(currentPath)) {
              bind.fab.setVisibility(View.VISIBLE);
              bind.fab.setScaleX(0f);
              bind.fab.setScaleY(0f);
              bind.fab.setAlpha(0f);

              bind.fab
                  .animate()
                  .scaleX(1f)
                  .scaleY(1f)
                  .alpha(1f)
                  .setDuration(300)
                  .setInterpolator(new OvershootInterpolator(1.0f))
                  .setStartDelay(100)
                  .start();
            }
          }
        });
    bind.fab.setOnClickListener(v -> setWallpaper());
  }

  private void setWallpaper() {
    try {

      int pos = bind.viewPager.getCurrentItem();
      String imgPath = images.get(pos);

      if (!canSetWallpaper(imgPath)) {
        DataUtil.showMessage(this, "Error");
        return;
      }

      Bitmap bmp = BitmapFactory.decodeFile(imgPath);
      WallpaperManager.getInstance(this).setBitmap(bmp);

      DataUtil.showMessage(this, "Wallpaper set");
    } catch (Exception e) {
      DataUtil.showMessage(this, "Failed to set wallpaper");
    }
  }

  private int findStartIndex(List<String> list, String path) {
    if (path == null) return 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(path)) {
        return i;
      }
    }
    return 0;
  }

  private boolean canSetWallpaper(String path) {
    if (path == null) return false;
    String p = path.toLowerCase();
    return !(p.endsWith(".svg") || p.endsWith(".gif"));
  }

  private List<String> loadImages(String path) {
    List<String> list = new ArrayList<>();
    if (path == null) return list;

    File file = new File(path);
    if (!file.exists()) return list;

    File dir = file.isFile() ? file.getParentFile() : file;
    if (dir == null || !dir.exists()) return list;

    File[] files = dir.listFiles();
    if (files == null) return list;

    Arrays.sort(files, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

    for (File f : files) {
      String name = f.getName().toLowerCase();
      if (name.endsWith(".jpg")
          || name.endsWith(".png")
          || name.endsWith(".webp")
          || name.endsWith(".gif")
          || name.endsWith(".svg")) {
        list.add(f.getAbsolutePath());
      }
    }
    return list;
  }
}
