package ir.ninjacoder.ghostide.core.activities;

import android.app.WallpaperManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ir.ninjacoder.ghostide.core.glidecompat.BlurTransformation;
import ir.ninjacoder.ghostide.core.databinding.ActivitySetWallpaperBinding;
import ir.ninjacoder.ghostide.core.marco.FileShareManager;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.prograsssheet.util.ColorPaletteUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ir.ninjacoder.ghostide.core.marco.wallpapers.WallpaperPagerAdapter;
import java.util.Map;

public class SetHomeWallpActivity extends BaseCompat {

  private List<String> images;
  private WallpaperPagerAdapter ad;
  private ActivitySetWallpaperBinding bind;
  private boolean isFabMenuVisible = false;
  private Integer primaryColor, surfaceColor;

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
    getWindow().setNavigationBarColor(Color.TRANSPARENT);
    getWindow().setStatusBarColor(Color.TRANSPARENT);
    updateFabVisibility(images.get(startIndex));
    bind.toolbar.setSubtitle(new File(images.get(startIndex)).getName());
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
            bind.toolbar.setSubtitle(new File(currentPath).getName());
            postGlide(currentPath);
            ad.resetCurrent(position);
          }
        });

    postGlide(images.get(startIndex));
    ad.setOnItemClickListener(
        (pos, view) -> {
          toggleFabMenu();
        });
    bind.fabSetWallpaper.setOnClickListener(v -> setWallpaper());
    bind.fabShare.setOnClickListener(v -> shareImage());
    bind.fabAdjust.setOnClickListener(v -> adjustImageSize());
    bind.fabMetadata.setOnClickListener(v -> showRotate());
    hideFabMenu();
  }

  private void updateFabVisibility(String currentPath) {
    boolean canSetWallpaper = canSetWallpaper(currentPath);

    if (canSetWallpaper) {
      if (isFabMenuVisible) {
        showFabMenu();
      } else {

        bind.fabSetWallpaper.setVisibility(View.VISIBLE);
        bind.fabSetWallpaper.setAlpha(1f);
        bind.fabSetWallpaper.setScaleX(1f);
        bind.fabSetWallpaper.setScaleY(1f);

        bind.toolbar.setVisibility(View.VISIBLE);
        bind.toolbar.setAlpha(1f);
        bind.toolbar.setScaleX(1f);
        bind.toolbar.setScaleY(1f);
      }
    } else {
      hideAllFabs();
    }
  }

  private void toggleFabMenu() {
    if (isFabMenuVisible) {
      hideFabMenu();
    } else {
      showFabMenu();
    }
  }

  private void showFabMenu() {
    String currentPath = images.get(bind.viewPager.getCurrentItem());
    if (!canSetWallpaper(currentPath)) return;
    isFabMenuVisible = true;
    animateToolbarOut();
    animateFabInHorizontal(bind.fabShare, 50);
    animateFabInHorizontal(bind.fabAdjust, 100);
    animateFabInHorizontal(bind.fabMetadata, 150);
    animateFabInHorizontal(bind.fabSetWallpaper, 200);
  }

  private void animateFabInHorizontal(View fab, long delay) {
    fab.setVisibility(View.VISIBLE);
    fab.setScaleX(0f);
    fab.setScaleY(0f);
    fab.setAlpha(0f);
    fab.setTranslationX(50f);

    fab.animate()
        .scaleX(1f)
        .scaleY(1f)
        .alpha(1f)
        .translationX(0f)
        .setDuration(250)
        .setInterpolator(new OvershootInterpolator(1.0f))
        .setStartDelay(delay)
        .start();
  }

  private void hideFabMenu() {
    isFabMenuVisible = false;
    animateFabOutHorizontal(bind.fabMetadata, 0);
    animateFabOutHorizontal(bind.fabAdjust, 50);
    animateFabOutHorizontal(bind.fabShare, 100);
    animateFabInHorizontal(bind.fabSetWallpaper, 150);
    animateToolbarIn();
  }

  private void animateFabOutHorizontal(View fab, long delay) {
    fab.animate()
        .scaleX(0f)
        .scaleY(0f)
        .alpha(0f)
        .translationX(50f)
        .setDuration(200)
        .setInterpolator(new AccelerateInterpolator())
        .setStartDelay(delay)
        .withEndAction(
            () -> {
              fab.setVisibility(View.GONE);
              fab.setTranslationX(0f);
            })
        .start();
  }

  private void animateToolbarOut() {
    bind.toolbar
        .animate()
        .alpha(0f)
        .setDuration(200)
        .setInterpolator(new AccelerateInterpolator())
        .withEndAction(() -> bind.toolbar.setVisibility(View.GONE))
        .start();
  }

  private void animateToolbarIn() {
    bind.toolbar.setVisibility(View.VISIBLE);
    bind.toolbar.setAlpha(0f);
    bind.toolbar
        .animate()
        .alpha(1f)
        .setDuration(250)
        .setInterpolator(new OvershootInterpolator(1.0f))
        .start();
  }

  private void hideAllFabs() {
    bind.fabSetWallpaper.setVisibility(View.GONE);
    bind.fabShare.setVisibility(View.GONE);
    bind.fabAdjust.setVisibility(View.GONE);
    bind.fabMetadata.setVisibility(View.GONE);
    bind.toolbar.setVisibility(View.GONE);
    isFabMenuVisible = false;
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

  private void shareImage() {
    var share = new FileShareManager(this);
    share.shareFile(new File(images.get(bind.viewPager.getCurrentItem())));
  }

  private void adjustImageSize() {
    ad.changeCurrentScale(bind.viewPager.getCurrentItem());
  }

  private void showRotate() {
    ad.rotateCurrent(bind.viewPager.getCurrentItem());
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

  private void postGlide(String path) {
    if (canSetWallpaper(path)) {
      // no blur
      Glide.with(this)
          .asBitmap()
          .load(path)
          .into(
              new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap map, Transition<? super Bitmap> arg1) {
                  ColorPaletteUtils.generateFromBitmap(
                      map,
                      (li, dark) -> {
                        Map<String, Integer> imap = dark;
                        if (imap != null && !imap.isEmpty()) {
                          primaryColor = imap.get("primary");
                          surfaceColor = imap.get("surface");
                          if (primaryColor == null) primaryColor = Color.parseColor("#330170");
                          if (surfaceColor == null) surfaceColor = Color.parseColor("#3e1020");
                          fabState(surfaceColor, primaryColor);
                        }
                      });
                }
              });

      Glide.with(this)
          .asBitmap()
          .load(path)
          .transform(new MultiTransformation<>(new BlurTransformation(17)))
          .into(
              new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> t) {
                  getWindow()
                      .getDecorView()
                      .setBackground(new BitmapDrawable(getResources(), resource));
                }
              });
    }
  }

  void fabState(int back, int imagecolor) {
    runOnUiThread(
        () -> {
          int colorbackal = ColorUtils.setAlphaComponent(back, 120);
          bind.fabSetWallpaper.setBackgroundTintList(ColorStateList.valueOf(colorbackal));
          bind.fabSetWallpaper.setImageTintList(ColorStateList.valueOf(imagecolor));
          bind.fabAdjust.setBackgroundTintList(ColorStateList.valueOf(colorbackal));
          bind.fabAdjust.setImageTintList(ColorStateList.valueOf(imagecolor));
          bind.fabShare.setBackgroundTintList(ColorStateList.valueOf(colorbackal));
          bind.fabShare.setImageTintList(ColorStateList.valueOf(imagecolor));
          bind.fabMetadata.setBackgroundTintList(ColorStateList.valueOf(colorbackal));
          bind.toolbar.setBackground(new ColorDrawable(colorbackal));
          bind.toolbar.setTitleTextColor(imagecolor);
          bind.toolbar.setSubtitleTextColor(imagecolor);
          bind.fabMetadata.setImageTintList(ColorStateList.valueOf(imagecolor));
          
        });
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
