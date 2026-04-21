package ir.ninjacoder.ghostide.core.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.WallpaperManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.palette.graphics.Palette;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ir.ninjacoder.ghostide.core.databinding.ActivitySetWallpaperBinding;
import ir.ninjacoder.ghostide.core.marco.FileShareManager;
import ir.ninjacoder.ghostide.core.utils.DataUtil;

import ir.ninjacoder.prograsssheet.util.ColorPaletteUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import ir.ninjacoder.ghostide.core.marco.wallpapers.WallpaperPagerAdapter;

public class SetHomeWallpActivity extends BaseCompat {

  private List<String> images;
  private WallpaperPagerAdapter adapter;
  private ActivitySetWallpaperBinding binding;
  private boolean isFabMenuVisible = false;
  private boolean isSystemUiVisible = true;
  private Integer primaryColor, surfaceColor;
  private WindowInsetsControllerCompat insetsController;
  private Animator currentToolbarAnimator;

  private static final int ANIMATION_DURATION = 300;
  private static final int FAB_ANIMATION_DURATION = 250;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivitySetWallpaperBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    setSupportActionBar(binding.toolbar);

    setupTransparentSystemBars();

    setupImmersiveController();

    String path = getIntent().getStringExtra("path");
    images = loadImages(path);

    if (images.isEmpty()) {
      DataUtil.showMessage(this, "No images found");
      finish();
      return;
    }

    int startIndex = findStartIndex(images, path);
    adapter = new WallpaperPagerAdapter(this, images);
    binding.viewPager.setAdapter(adapter);
    binding.viewPager.setCurrentItem(startIndex, false);

    applySystemWindowInsets();

    updateToolbarTitle(images.get(startIndex));

    setupViewPagerListener();

    setupFabListeners();

    postGlide(images.get(startIndex));

    hideFabMenuImmediate();

    adapter.setOnItemClickListener((pos, view) -> toggleUiVisibility());
  }

  private void setupTransparentSystemBars() {
    getWindow().setStatusBarColor(Color.TRANSPARENT);
    getWindow().setNavigationBarColor(Color.TRANSPARENT);

    WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
  }

  private void setupImmersiveController() {
    insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
    insetsController.setSystemBarsBehavior(
        WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
  }

  private void applySystemWindowInsets() {
    ViewCompat.setOnApplyWindowInsetsListener(
        binding.getRoot(),
        (v, insets) -> {
          int statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top;
          int navigationBarHeight =
              insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;

          ViewGroup.MarginLayoutParams toolbarParams =
              (ViewGroup.MarginLayoutParams) binding.appBar.getLayoutParams();
          toolbarParams.topMargin = statusBarHeight;
          binding.appBar.setLayoutParams(toolbarParams);

          binding.viewPager.setPadding(0, 0, 0, navigationBarHeight);

          return insets;
        });
  }

  private void setupViewPagerListener() {
    binding.viewPager.registerOnPageChangeCallback(
        new ViewPager2.OnPageChangeCallback() {
          @Override
          public void onPageSelected(int position) {
            String currentPath = images.get(position);
            updateToolbarTitle(currentPath);
            postGlide(currentPath);
            adapter.resetCurrent(position);
            updateFabVisibility(currentPath);
          }
        });
  }

  private void setupFabListeners() {
    binding.fabSetWallpaper.setOnClickListener(v -> setWallpaper());
    binding.fabShare.setOnClickListener(v -> shareImage());
    binding.fabAdjust.setOnClickListener(v -> adjustImageSize());
    binding.fabMetadata.setOnClickListener(v -> showRotate());
  }

  private void updateToolbarTitle(String path) {
    if (path != null) {
      File file = new File(path);
      binding.toolbar.setTitle(file.getName());

      int currentIndex = binding.viewPager.getCurrentItem() + 1;
      int totalCount = images.size();
      if (totalCount > 1) {
        binding.toolbar.setSubtitle(currentIndex + " از " + totalCount);
      } else {
        binding.toolbar.setSubtitle(null);
      }
    }
  }

  private void toggleUiVisibility() {
    String currentPath = images.get(binding.viewPager.getCurrentItem());
    if (!canSetWallpaper(currentPath)) {
      return;
    }

    if (isSystemUiVisible) {
      hideSystemUi();
      hideFabMenu();
    } else {
      showSystemUi();
      showFabMenu();
    }
  }

  private void hideSystemUi() {
    isSystemUiVisible = false;

    insetsController.hide(WindowInsetsCompat.Type.systemBars());

    animateToolbarOut();
  }

  private void showSystemUi() {
    isSystemUiVisible = true;

    insetsController.show(WindowInsetsCompat.Type.systemBars());

    animateToolbarIn();
  }

  private void animateToolbarOut() {
    if (currentToolbarAnimator != null) {
      currentToolbarAnimator.cancel();
    }

    binding
        .appBar
        .animate()
        .alpha(0f)
        .translationY(-binding.appBar.getHeight())
        .setDuration(ANIMATION_DURATION)
        .setInterpolator(new FastOutSlowInInterpolator())
        .setListener(
            new AnimatorListenerAdapter() {
              @Override
              public void onAnimationEnd(Animator animation) {
                binding.appBar.setVisibility(View.GONE);
              }
            })
        .start();
  }

  private void animateToolbarIn() {
    if (currentToolbarAnimator != null) {
      currentToolbarAnimator.cancel();
    }

    binding.appBar.setVisibility(View.VISIBLE);
    binding.appBar.setAlpha(0f);

    binding.appBar.setTranslationY(-binding.appBar.getHeight());

    binding
        .appBar
        .animate()
        .alpha(1f)
        .translationY(0f)
        .setDuration(ANIMATION_DURATION)
        .setInterpolator(new FastOutSlowInInterpolator())
        .setListener(null)
        .start();
  }

  private void showFabMenu() {
    String currentPath = images.get(binding.viewPager.getCurrentItem());
    if (!canSetWallpaper(currentPath)) return;

    isFabMenuVisible = true;

    animateFabIn(binding.fabShare, 50);
    animateFabIn(binding.fabAdjust, 100);
    animateFabIn(binding.fabMetadata, 150);
    animateFabIn(binding.fabSetWallpaper, 200);
  }

  private void hideFabMenu() {
    isFabMenuVisible = false;

    animateFabOut(binding.fabMetadata, 0);
    animateFabOut(binding.fabAdjust, 50);
    animateFabOut(binding.fabShare, 100);

    animateFabIn(binding.fabSetWallpaper, 150);
  }

  private void hideFabMenuImmediate() {
    isFabMenuVisible = false;
    binding.fabShare.setVisibility(View.GONE);
    binding.fabAdjust.setVisibility(View.GONE);
    binding.fabMetadata.setVisibility(View.GONE);
    binding.fabSetWallpaper.setVisibility(View.GONE);
  }

  private void animateFabIn(FloatingActionButton fab, long delay) {
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
        .setDuration(FAB_ANIMATION_DURATION)
        .setInterpolator(new OvershootInterpolator(1.0f))
        .setStartDelay(delay)
        .start();
  }

  private void animateFabOut(FloatingActionButton fab, long delay) {
    fab.animate()
        .scaleX(0f)
        .scaleY(0f)
        .alpha(0f)
        .translationX(50f)
        .setDuration(200)
        .setInterpolator(new AccelerateInterpolator())
        .setStartDelay(delay)
        .withEndAction(() -> fab.setVisibility(View.GONE))
        .start();
  }

  private void updateFabVisibility(String currentPath) {
    boolean canSet = canSetWallpaper(currentPath);

    if (canSet) {
      if (isSystemUiVisible) {
        binding.fabSetWallpaper.setVisibility(View.VISIBLE);
      }
    } else {
      hideFabMenuImmediate();
    }
  }

  private void setWallpaper() {
    try {
      int pos = binding.viewPager.getCurrentItem();
      String imgPath = images.get(pos);

      if (!canSetWallpaper(imgPath)) {
        DataUtil.showMessage(this, "این فایل قابل تنظیم به عنوان والپیپر نیست");
        return;
      }

      Bitmap bmp = BitmapFactory.decodeFile(imgPath);
      WallpaperManager.getInstance(this).setBitmap(bmp);
      DataUtil.showMessage(this, "والپیپر با موفقیت تنظیم شد");

      if (!isSystemUiVisible) {
        showSystemUi();
        showFabMenu();
      }

    } catch (Exception e) {
      DataUtil.showMessage(this, "خطا در تنظیم والپیپر: " + e.getMessage());
    }
  }

  private void shareImage() {
    FileShareManager share = new FileShareManager(this);
    share.shareFile(new File(images.get(binding.viewPager.getCurrentItem())));
  }

  private void adjustImageSize() {
    adapter.changeCurrentScale(binding.viewPager.getCurrentItem());
  }

  private void showRotate() {
    adapter.rotateCurrent(binding.viewPager.getCurrentItem());
  }

  private void postGlide(String path) {
    if (!canSetWallpaper(path)) {

      applyDefaultColors();
      return;
    }

    Glide.with(this)
        .asBitmap()
        .load(path)
        .into(
            new SimpleTarget<Bitmap>() {
              @Override
              public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                ColorPaletteUtils.generateFromBitmap(
                    bitmap,
                    (li, dark) -> {
                      Map<String, Integer> colorMap = dark;
                      if (colorMap != null && !colorMap.isEmpty()) {
                        primaryColor = colorMap.get("primary");
                        surfaceColor = colorMap.get("surface");

                        if (primaryColor == null) primaryColor = Color.parseColor("#330170");
                        if (surfaceColor == null) surfaceColor = Color.parseColor("#3e1020");

                        applyColorsToUi(surfaceColor, primaryColor);
                      }
                    });
              }
            });
  }

  private void applyDefaultColors() {
    primaryColor = Color.parseColor("#330170");
    surfaceColor = Color.parseColor("#3e1020");
    applyColorsToUi(surfaceColor, primaryColor);
  }

  private void applyColorsToUi(int backgroundColor, int contentColor) {
    runOnUiThread(
        () -> {
          int transparentBg = ColorUtils.setAlphaComponent(backgroundColor, 120);

          tintFab(binding.fabSetWallpaper, transparentBg, contentColor);
          tintFab(binding.fabAdjust, transparentBg, contentColor);
          tintFab(binding.fabShare, transparentBg, contentColor);
          tintFab(binding.fabMetadata, transparentBg, contentColor);

          binding.toolbar.setBackground(new ColorDrawable(transparentBg));
          binding.toolbar.setTitleTextColor(contentColor);
          binding.toolbar.setSubtitleTextColor(ColorUtils.setAlphaComponent(contentColor, 200));
        });
  }

  private void tintFab(FloatingActionButton fab, int bgColor, int iconColor) {
    fab.setBackgroundTintList(ColorStateList.valueOf(bgColor));
    fab.setImageTintList(ColorStateList.valueOf(iconColor));
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
    String lower = path.toLowerCase();
    return lower.endsWith(".jpg")
        || lower.endsWith(".jpeg")
        || lower.endsWith(".png")
        || lower.endsWith(".webp")
        || lower.endsWith(".bmp");
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
      if (isImageFile(name)) {
        list.add(f.getAbsolutePath());
      }
    }
    return list;
  }

  private boolean isImageFile(String fileName) {
    return fileName.endsWith(".jpg")
        || fileName.endsWith(".jpeg")
        || fileName.endsWith(".png")
        || fileName.endsWith(".webp")
        || fileName.endsWith(".gif")
        || fileName.endsWith(".bmp")
        || fileName.endsWith(".svg")
        || fileName.endsWith(".xml");
  }

  @Override
  public void onBackPressed() {
    if (!isSystemUiVisible) {
      showSystemUi();
      showFabMenu();
    } else if (isFabMenuVisible) {
      hideFabMenu();
    } else {
      super.onBackPressed();
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    if (currentToolbarAnimator != null) {
      currentToolbarAnimator.cancel();
    }
  }
}
