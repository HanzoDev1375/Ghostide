package ir.ninjacoder.ghostide.core.activities;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.marco.wallpapers.WallpaperPagerAdapter;

public class SetHomeWallpActivity extends BaseCompat {

  private ViewPager2 viewPager;
  private ExtendedFloatingActionButton fab;
  private List<String> images;

  @Override
  protected void onCreate(Bundle b) {
    super.onCreate(b);
    setContentView(R.layout.activity_set_wallpaper);

    viewPager = findViewById(R.id.viewPager);
    fab = findViewById(R.id.fab);

    String path = getIntent().getStringExtra("path");
    images = loadImages(path);

    int startIndex = findStartIndex(images, path);

    viewPager.setAdapter(new WallpaperPagerAdapter(this, images));
    viewPager.setCurrentItem(startIndex, false);
    if (!images.isEmpty()) {
      fab.setVisibility(canSetWallpaper(images.get(startIndex)) ? View.VISIBLE : View.GONE);
    }
    viewPager.registerOnPageChangeCallback(
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
            fab.setVisibility(canSetWallpaper(currentPath) ? View.VISIBLE : View.GONE);
          }
        });

    fab.setOnClickListener(v -> setWallpaper());
  }

  private void setWallpaper() {
    try {
      int pos = viewPager.getCurrentItem();
      String imgPath = images.get(pos);

      if (!canSetWallpaper(imgPath)) {
        Toast.makeText(this, "این فرمت قابل تنظیم نیست", Toast.LENGTH_SHORT).show();
        return;
      }

      Bitmap bmp = BitmapFactory.decodeFile(imgPath);
      WallpaperManager.getInstance(this).setBitmap(bmp);

      Toast.makeText(this, "Wallpaper set", Toast.LENGTH_SHORT).show();
    } catch (Exception e) {
      Toast.makeText(this, "Failed to set wallpaper", Toast.LENGTH_SHORT).show();
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
