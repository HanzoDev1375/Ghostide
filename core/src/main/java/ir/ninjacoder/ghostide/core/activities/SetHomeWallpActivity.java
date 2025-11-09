package ir.ninjacoder.ghostide.core.activities;

import android.app.WallpaperManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.jsibbold.zoomage.ZoomageView;

import java.io.IOException;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;
import ir.ninjacoder.ghostide.core.utils.FileUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class SetHomeWallpActivity extends BaseCompat {

  protected ZoomageView imageView;
  protected Toolbar toolbar;
  protected ExtendedFloatingActionButton fab;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.setwalpapactivity);
    toolbar = findViewById(R.id.toolbar);
    imageView = findViewById(R.id.imgwallpaper);
    fab = findViewById(R.id.fab);
    setSupportActionBar(toolbar);
    Glide.with(this)
        .asBitmap()
        .error(android.R.drawable.gallery_thumb)
        .load(FileUtil.decodeSampleBitmapFromPath(getIntent().getStringExtra("img"), 1024, 1024))
        .into(imageView);
    // imageView.setImageBitmap(FileUtil.decodeSampleBitmapFromPath();
    fab.setText("Select to Walpaper?");
    var shap = new ShapeAppearanceModel.Builder();
    shap.setAllCorners(CornerFamily.ROUNDED, 30f);
    fab.setShapeAppearanceModel(shap.build());
    toolbar.setBackgroundTintList(
        ColorStateList.valueOf(MaterialColors.getColor(toolbar, ObjectUtils.Back)));
    toolbar.setTitleTextColor(MaterialColors.getColor(toolbar, ObjectUtils.TvColor));
    fab.setOnClickListener(v -> setWallpaperImageView(imageView));
    ClickEffcat(fab);
  }

  public void setWallpaperImageView(ImageView selectedImage) {
    WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
    try {
      Drawable drawable = selectedImage.getDrawable();
      if (drawable instanceof BitmapDrawable) {
        Bitmap wallpaperBitmap = ((BitmapDrawable) drawable).getBitmap();
        wallpaperManager.setBitmap(wallpaperBitmap);
        showMessage("Setting wallpaper completed 🖼️");
      } else {
        showMessage("No image found in ImageView 🚫");
      }
    } catch (IOException e) {
      showMessage("Error setting wallpaper ❌");
      e.printStackTrace();
    }
  }

  public void showMessage(String t) {
    Toast.makeText(this, t, 2).show();
  }
}
