package ir.ninjacoder.ghostide.core.marco.wallpapers;

import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.MainThread;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jsibbold.zoomage.ZoomageView;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.Store.BaseFragment;
import ir.ninjacoder.ghostide.core.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.core.interfaces.OnItemClickListener;

public class WallpaperFragments extends BaseFragment {

  private static final String ARG_PATH = "path";
  private static final String ARG_POSITION = "POSITION";

  private String imagePath;
  private int position;

  private ZoomageView imageView;
  private OnItemClickListener click;

  // وضعیت تصویر
  private int scaleIndex = 0;
  private float currentRotation = 0f;

  private final ImageView.ScaleType[] scaleTypes =
      new ImageView.ScaleType[] {
        ImageView.ScaleType.FIT_CENTER,
        ImageView.ScaleType.CENTER_CROP,
        ImageView.ScaleType.CENTER_INSIDE,
        ImageView.ScaleType.FIT_XY
      };

  public static WallpaperFragments newInstance(String path, int pos) {
    Bundle b = new Bundle();
    b.putString(ARG_PATH, path);
    b.putInt(ARG_POSITION, pos);
    WallpaperFragments f = new WallpaperFragments();
    f.setArguments(b);
    return f;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle state) {
    return inflater.inflate(R.layout.fragment_wallpaper, parent, false);
  }

  @Override
  @MainThread
  public void onViewCreated(View v, Bundle state) {
    super.onViewCreated(v, state);

    imageView = v.findViewById(R.id.image);

    imagePath = getArguments().getString(ARG_PATH);
    position = getArguments().getInt(ARG_POSITION, -1);

    setupImage();
    setupClickWithoutBreakingZoom();
  }

  private void setupImage() {
    if (imagePath == null) return;

    Glide.with(imageView.getContext())
        .load(imagePath)
        .placeholder(GlideCompat.CircelPrograssBar())
        .error(R.drawable.ic_image)
        .into(
            new SimpleTarget<Drawable>() {
              @Override
              public void onResourceReady(Drawable resource, Transition<? super Drawable> t) {
                crossfadeDrawable(imageView,resource,1000);
              }
            });

    resetImageState();
  }

  private void crossfadeDrawable(ImageView iv, Drawable next, int duration) {
    var td = new TransitionDrawable(new Drawable[] {new ColorDrawable(Color.TRANSPARENT), next});
    td.setCrossFadeEnabled(true);
    iv.setImageDrawable(td);
    td.startTransition(duration);
  }

  private void resetImageState() {
    scaleIndex = 0;
    currentRotation = 0f;
    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    imageView.setRotation(0f);
  }

  private void setupClickWithoutBreakingZoom() {
    imageView.setClickable(false);

    GestureDetector gestureDetector =
        new GestureDetector(
            getContext(),
            new GestureDetector.SimpleOnGestureListener() {
              @Override
              public boolean onSingleTapConfirmed(MotionEvent e) {
                if (click != null) click.onClick(imageView, position);
                return true;
              }
            });

    imageView.setOnTouchListener(
        (v, event) -> {
          v.getParent().requestDisallowInterceptTouchEvent(true);
          gestureDetector.onTouchEvent(event);
          return false;
        });
  }

  public void setClick(OnItemClickListener click) {
    this.click = click;
  }

  // ===== متدهایی که Adapter صدا می‌زند =====

  public void changeScaleType() {
    if (imageView == null) return;
    scaleIndex = (scaleIndex + 1) % scaleTypes.length;
    imageView.setScaleType(scaleTypes[scaleIndex]);
  }

  public void rotateImage() {
    if (imageView == null) return;
    currentRotation = (currentRotation + 90f) % 360f;
    imageView.animate().rotation(currentRotation).setDuration(200).start();
  }

  public void resetFromOutside() {
    if (imageView == null) return;
    resetImageState();
  }
}
