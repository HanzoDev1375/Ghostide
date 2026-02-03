package ir.ninjacoder.ghostide.core.marco.binder;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.card.MaterialCardView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class BlurMaterialCardView extends MaterialCardView {

  private float blurRadius = 20f;
  private boolean isBlurring = false;
  private static final Set<String> BLUR_WHITELIST = new HashSet<>();
  private final Object blurLock = new Object();
  private String currentImagePath = "";

  static {
    BLUR_WHITELIST.add(".jpg");
    BLUR_WHITELIST.add(".png");
    BLUR_WHITELIST.add(".jpeg");
    BLUR_WHITELIST.add(".webp");
    BLUR_WHITELIST.add(".mp4");
  }

  public BlurMaterialCardView(Context context) {
    super(context);
    init();
  }

  public BlurMaterialCardView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public BlurMaterialCardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    setCardBackgroundColor(Color.TRANSPARENT);
    setPreventCornerOverlap(false);
    setUseCompatPadding(false);
  }

  public void setBlurRadius(float radius) {
    if (radius < 1f) radius = 1f;
    if (radius > 25f) radius = 25f;
    this.blurRadius = radius;
  }

  public void setBlurFromImageView(ImageView imageView, String imagePath) {

    if (!shouldBlurImage(imagePath)) {
      setBackground(null);
      return;
    }

    if (getWidth() == 0 || getHeight() == 0) {
      post(() -> setBlurFromImageView(imageView, imagePath));
      return;
    }

    currentImagePath = imagePath;

    Glide.with(getContext())
        .asBitmap()
        .load(new File(imagePath))
        .override(getWidth(), getHeight())
        .skipMemoryCache(true)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .into(
            new CustomTarget<Bitmap>() {
              @Override
              public void onResourceReady(
                  @NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {

                new Thread(
                        () -> {
                          Bitmap blurred = blurBitmap(resource);
                          if (blurred == null) return;

                          Bitmap clipped = clipToCardShape(blurred);

                          post(
                              () -> {
                                if (clipped != null) {
                                  
                                  setBackground(new BitmapDrawable(getResources(), clipped));
                                }
                              });
                        })
                    .start();
              }

              @Override
              public void onLoadCleared(@Nullable Drawable placeholder) {
                setBackground(null);
              }
            });
  }

  private boolean shouldBlurImage(String imagePath) {
    if (imagePath == null || imagePath.isEmpty()) {
      return false;
    }

    for (String extension : BLUR_WHITELIST) {
      if (imagePath.toLowerCase().endsWith(extension)) {
        return true;
      }
    }
    return false;
  }

  private void processBlur(Bitmap source) {
    if (source == null || source.isRecycled() || getWidth() == 0 || getHeight() == 0) {
      return;
    }

    try {

      new Thread(
              () -> {
                try {
                  Bitmap blurred = blurBitmap(source);
                  if (blurred != null && !blurred.isRecycled()) {
                    Bitmap clipped = clipToCardShape(blurred);

                    post(
                        () -> {
                          if (clipped != null && !clipped.isRecycled()) {
                            setBackground(new BitmapDrawable(getResources(), clipped));
                          }
                        });
                  }
                } catch (Exception e) {
                  e.printStackTrace();
                } finally {

                  if (!source.isRecycled()) {
                    source.recycle();
                  }
                }
              })
          .start();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private Bitmap blurBitmap(Bitmap source) {
    if (source == null
        || source.isRecycled()
        || source.getWidth() <= 0
        || source.getHeight() <= 0) {
      return null;
    }

    try {
      int scaledWidth = Math.max(1, getWidth() / 4);
      int scaledHeight = Math.max(1, getHeight() / 4);

      Bitmap scaled = Bitmap.createScaledBitmap(source, scaledWidth, scaledHeight, true);
      Bitmap output = Bitmap.createBitmap(scaledWidth, scaledHeight, Bitmap.Config.ARGB_8888);

      RenderScript rs = null;
      try {
        rs = RenderScript.create(getContext());
        Allocation input = Allocation.createFromBitmap(rs, scaled);
        Allocation outputAlloc = Allocation.createFromBitmap(rs, output);

        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        blur.setRadius(Math.min(blurRadius, 25f));
        blur.setInput(input);
        blur.forEach(outputAlloc);
        outputAlloc.copyTo(output);

        Bitmap finalOutput = Bitmap.createScaledBitmap(output, getWidth(), getHeight(), true);

        if (!scaled.isRecycled()) scaled.recycle();
        if (!output.isRecycled()) output.recycle();

        return finalOutput;
      } finally {
        if (rs != null) {
          rs.destroy();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private Bitmap clipToCardShape(Bitmap source) {
    if (source == null || source.isRecycled() || getWidth() == 0 || getHeight() == 0) {
      return null;
    }

    try {
      Bitmap output = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);

      Canvas canvas = new Canvas(output);
      Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

      float radius = getRadius();
      RectF rect = new RectF(0, 0, getWidth(), getHeight());

      Path path = new Path();
      path.addRoundRect(rect, radius, radius, Path.Direction.CW);

      canvas.clipPath(path);
      canvas.drawBitmap(source, 0, 0, paint);

      return output;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public void addToBlurWhitelist(String extension) {
    BLUR_WHITELIST.add(extension.toLowerCase());
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    synchronized (blurLock) {
      isBlurring = false;
    }
    currentImagePath = "";
  }

  public void cancelBlur() {
    synchronized (blurLock) {
      isBlurring = false;
    }
  }

  public boolean isBlur() {
    return this.isBlurring;
  }
}
