package ir.ninjacoder.prograsssheet;

import android.animation.ObjectAnimator;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.view.animation.LinearInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.GradientDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import ir.ninjacoder.prograsssheet.databinding.LayoutMusicPlayersBinding;
import ir.ninjacoder.prograsssheet.interfaces.MediaPlayerListener;
import ir.ninjacoder.prograsssheet.util.ColorPaletteUtils;
import ir.ninjacoder.prograsssheet.util.SquigglyProgress;
import java.io.File;
import java.util.Map;
import java.util.Random;

public class MusicSheet implements SeekBar.OnSeekBarChangeListener {

  private Context context;
  private String musicpatch;
  private Music md;
  private double forwardTime = 0;
  private double backwardTime = 0;
  private Sheet dialog;
  private Integer surfaceColor,
      onSurfaceColor,
      primaryColor,
      onPrimaryColor,
      outlineColor,
      tertiary,
      onTertiary,
      onSurfaceContainer;

  protected SquigglyProgress bars;
  private LayoutMusicPlayersBinding bind;
  private float shapeRotation = 0f;
  private ObjectAnimator rotateAnimation;
  private boolean isSeekBarTracking = false;

  public MusicSheet(Context context, String musicpatch) {
    this.context = context;
    this.musicpatch = musicpatch;
    md = new Music(context, musicpatch);
    md.setPathSource(new File(musicpatch));
    bind = LayoutMusicPlayersBinding.inflate(LayoutInflater.from(context));
    dialog = new Sheet(context);
    bind.titlemusic.setText(md.getNameArtist());
    bind.submusic.setText(md.getNameAlbom());
    bars = new SquigglyProgress();

    bars.setWaveLength(100);
    bars.setLineAmplitude(8);
    bars.setPhaseSpeed(25);
    bars.setStrokeWidth(convertToPx(context, 4));
    bars.setTransitionEnabled(true);
    bars.setAnimate(true);
    setMatchParentDialog(true);
    showandP(true);
    bind.musicseekbar.setProgressDrawable(bars);

    dialog
        .getBehavior()
        .addBottomSheetCallback(
            new BottomSheetBehavior.BottomSheetCallback() {

              @Override
              public void onStateChanged(View arg0, int state) {
                if (state == BottomSheetBehavior.STATE_HIDDEN) {
                  if (md != null) md.pause();
                }
              }

              @Override
              public void onSlide(View arg0, float arg1) {}
            });
    setAsPaletteBackground(true);
    bind.musicseekbar.setOnSeekBarChangeListener(this);
    Handler mHandler = new Handler(Looper.getMainLooper());
    ((Activity) context)
        .runOnUiThread(
            new Runnable() {

              @Override
              public void run() {
                if (md != null && !isSeekBarTracking) {
                  int currentPositionInMillis = md.getCurrentDuration();
                  bind.musicseekbar.setProgress(currentPositionInMillis);
                  int currentPositionInSeconds = currentPositionInMillis / 1000;
                  int minutes = currentPositionInSeconds / 60;
                  int seconds = currentPositionInSeconds % 60;
                  bind.tvtr.setText(String.format("%d:%02d", minutes, seconds));
                }
                mHandler.postDelayed(this, 90);
              }
            });

    forwardTime = 5000;
    backwardTime = 5000;
    int durationInMillis = md.getDuration();
    bind.musicseekbar.setMax(durationInMillis);
    int durationInSeconds = durationInMillis / 1000;
    int minutes = durationInSeconds / 60;
    int seconds = durationInSeconds % 60;
    bind.tvname.setText(String.format("%d:%02d", minutes, seconds));

    bind.pre.setOnClickListener(
        v -> {
          if ((md.getCurrentDuration() - backwardTime) > 0) {
            md.seekTo(md.getCurrentDuration() - (int) backwardTime);
          } else {
            md.seekTo(0);
          }
        });
    bind.next.setOnClickListener(
        v -> {
          if ((md.getCurrentDuration() + (int) forwardTime) <= md.getDuration()) {
            md.seekTo(md.getCurrentDuration() + (int) forwardTime);
          }
        });
    bind.play.setOnClickListener(
        i -> {
          if (md.isPlaying()) {
            md.pause();
            bars.setAnimate(false);
          } else {
            md.start();
            bars.setAnimate(true);
          }
        });
    start();
  }

  @Override
  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    if (fromUser && md != null) {
      int currentPositionInSeconds = progress / 1000;
      int minutes = currentPositionInSeconds / 60;
      int seconds = currentPositionInSeconds % 60;
      bind.tvtr.setText(String.format("%d:%02d", minutes, seconds));
    }
  }

  @Override
  public void onStartTrackingTouch(SeekBar seekBar) {
    isSeekBarTracking = true;
  }

  @Override
  public void onStopTrackingTouch(SeekBar seekBar) {
    if (md != null) {
      md.seekTo(seekBar.getProgress());
    }
    isSeekBarTracking = false;
  }

  void showandP(boolean isPlaying) {
    bind.play.setBackground(
        AppCompatResources.getDrawable(
            context, isPlaying ? R.drawable.bg_play_anim : R.drawable.bg_pause_anim));
    bind.play.setIcon(
        AppCompatResources.getDrawable(
            context, isPlaying ? R.drawable.musicstop : R.drawable.musicplay));
    Drawable icon = bind.play.getBackground();
    var icons = bind.play.getIcon();
    startAnimation(icon);
    startAnimation(icons);
  }

  void start() {
    md.setMediaPlayerListener(
        new MediaPlayerListener() {

          @Override
          public void isPlaying(int currentDuration) {}

          @Override
          public void onStart() {
            showandP(true);           
          }

          @Override
          public void onPause() {
            showandP(false);
          }
        });
  }

  public MusicSheet show() {
    dialog.show();
    return this;
  }

  public MusicSheet dismiss() {
    if (md.isPlaying()) {
      md.pause();
    }
    dialog.dismiss();
    return this;
  }

  public void playMusic() {
    if (dialog.isShowing()) {
      md.start();
      bars.setAnimate(true);
      
    }
  }

  class Sheet extends CustomSheet {

    public Sheet(Context c) {
      super(c);
    }

    @Override
    public View getView() {
      return bind.getRoot();
    }
  }

  public void setMusicDead() {
    if (md != null) {
      md.pause();
      md.release();
      md = null;
      
    }
  }

  void setAsPaletteBackground(boolean is) {
    if (is) {
      var imageSource =
          md.getImageBitmap() != null ? md.getImageBitmap() : getRandomBackgroundMusic();
      Glide.with(bind.musicicon.getContext())
          .asBitmap()
          .load(imageSource)
          .into(
              new CustomTarget<Bitmap>() {
                @Override
                public void onResourceReady(
                    @NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                  bind.musicicon.setImageBitmap(bitmap);
                  generatePaletteFromUtils(bitmap);
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {
                  bind.musicicon.setImageDrawable(placeholder);
                }
              });
    }
  }

  private void generatePaletteFromUtils(Bitmap bitmap) {

    ColorPaletteUtils.generateFromBitmap(
        bitmap,
        new ColorPaletteUtils.ResultCallback() {
          @Override
          public void onResult(Map<String, Integer> lightColors, Map<String, Integer> darkColors) {

            Map<String, Integer> darkPalette = darkColors;

            if (darkPalette != null && !darkPalette.isEmpty()) {
              applyColorsFromPalette(darkPalette);
            }
          }
        });
  }

  private void applyColorsFromPalette(Map<String, Integer> palette) {

    surfaceColor = palette.get("surface");
    onSurfaceContainer = palette.get("onSurfaceContainer");
    onSurfaceColor = palette.get("onSurface");
    primaryColor = palette.get("primary");
    onPrimaryColor = palette.get("onPrimary");
    outlineColor = palette.get("outline");
    tertiary = palette.get("tertiary");
    onTertiary = palette.get("onTertiary");
    if (onSurfaceContainer == null) onSurfaceContainer = Color.parseColor("#ff4820");
    if (tertiary == null) tertiary = Color.YELLOW;
    if (onTertiary == null) onTertiary = Color.parseColor("#293810");
    if (surfaceColor == null) surfaceColor = Color.parseColor("#121212");
    if (onSurfaceColor == null) onSurfaceColor = Color.WHITE;
    if (primaryColor == null) primaryColor = Color.parseColor("#BB86FC");
    if (onPrimaryColor == null) onPrimaryColor = Color.TRANSPARENT;
    if (outlineColor == null) outlineColor = Color.parseColor("#333333");
    new Handler(Looper.getMainLooper())
        .post(
            () -> {
              bind.getRoot().setBackgroundColor(surfaceColor);
              bind.play.setIconTint(ColorStateList.valueOf(primaryColor));
              bind.play.setBackgroundTintList(ColorStateList.valueOf(onPrimaryColor));
              bind.next.setColorFilter(tertiary);
              bind.pre.setColorFilter(tertiary);
              bind.pre.setBackground(get(onTertiary));
              bind.next.setBackground(get(onTertiary));
              var thumbColor = ColorStateList.valueOf(primaryColor);
              bind.musicseekbar.setThumbTintList(thumbColor);
              bind.musicseekbar.setProgressTintList(thumbColor);
              bars.setTintList(ColorStateList.valueOf(primaryColor));
              bind.submusic.setTextColor(onSurfaceContainer);
              bind.tvname.setTextColor(onSurfaceContainer);
              bind.tvtr.setTextColor(onSurfaceContainer);
              bind.titlemusic.setTextColor(onSurfaceContainer);
              if (dialog != null && dialog.getWindow() != null) {
                dialog.getWindow().setStatusBarColor(surfaceColor);
                dialog.getWindow().setNavigationBarColor(surfaceColor);
              }
            });
  }

  void autoColor(int colors, ImageView views) {
    if (ColorUtils.calculateLuminance(colors) > 0.5) {
      views.setColorFilter(Color.BLACK);
    } else if (ColorUtils.calculateLuminance(colors) <= 0.5) {
      views.setColorFilter(Color.WHITE);
    }
  }

  void setMatchParentDialog(boolean is) {
    if (is) dialog.setFullScreen();
  }

  void startAnimation(@NonNull Drawable drawable) {
    if (drawable instanceof AnimatedVectorDrawable) {
      ((AnimatedVectorDrawable) drawable).start();
    } else if (drawable instanceof AnimatedVectorDrawableCompat) {
      ((AnimatedVectorDrawableCompat) drawable).start();
    } else {
      throw new IllegalArgumentException(
          "Drawable must be an AnimatedVectorDrawable or AnimatedVectorDrawableCompat");
    }
  }

  private int getRandomBackgroundMusic() {
    int[] musicListIcon = {
      R.drawable.musicerror,
      R.drawable.music1,
      R.drawable.music2,
      R.drawable.music3,
      R.drawable.music4,
      R.drawable.music5,
      R.drawable.music6
    };
    Random rand = new Random();
    int index = rand.nextInt(musicListIcon.length);
    return musicListIcon[index];
  }

  int convertToPx(Context context, float dp) {
    float density = context.getResources().getDisplayMetrics().density;
    return (int) (dp * density + 0.5f);
  }

  @NonNull
  GradientDrawable get(int color) {
    var shape = new GradientDrawable();
    shape.setColor(color);
    shape.setCornerRadius(99);
    return shape;
  }
}
