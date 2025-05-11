package ir.ninjacoder.prograsssheet;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.slider.Slider;
import ir.ninjacoder.prograsssheet.databinding.LayoutMusicPlayersBinding;
import ir.ninjacoder.prograsssheet.interfaces.MediaPlayerListener;
import java.io.File;
import java.util.Random;

public class MusicSheet implements Slider.OnChangeListener {

  private Context context;
  private String musicpatch;
  private Music md;
  private double forwardTime = 0;
  private double backwardTime = 0;
  private Sheet dialog;
  private LayoutMusicPlayersBinding bind;

  // در constructor بعد از مقداردهی اولیه:

  public MusicSheet(Context context, String musicpatch) {
    this.context = context;
    this.musicpatch = musicpatch;
    md = new Music(context, musicpatch);
    md.setPathSource(new File(musicpatch));
    bind = LayoutMusicPlayersBinding.inflate(LayoutInflater.from(context));
    dialog = new Sheet(context);
    bind.titlemusic.setText(md.getNameArtist());
    bind.submusic.setText(md.getNameAlbom());
    setMatchParentDialog(true);
    showandP(true);
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
    bind.musicseekbar.addOnChangeListener(this);
    Handler mHandler = new Handler(Looper.getMainLooper());
    ((Activity) context)
        .runOnUiThread(
            new Runnable() {

              @Override
              public void run() {
                if (md != null) {
                  int mCurrentPosition = 0;
                  bind.musicseekbar.setValue(md.getCurrentDuration() / 90);
                  int currentPositionInMillis = md.getCurrentDuration();
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

          } else {
            md.start();
          }
        });
    bind.musicseekbar.setValueTo(md.getDuration() / 90);
    start();
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
    if (md.isPlaying()) md.pause();
    dialog.dismiss();
    return this;
  }

  public void playMusic() {
    if (dialog.isShowing()) {
      md.start();
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

  @Override
  public void onValueChange(Slider arg0, float progressValue, boolean arg2) {
    if (md != null && arg2) {
      md.seekTo((int) progressValue * 90);
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
                  generatePalette(bitmap);
                }

                @Override
                public void onLoadCleared(@Nullable Drawable placeholder) {
                  bind.musicicon.setImageDrawable(placeholder);
                }
              });
    }
  }

  private void generatePalette(Bitmap bitmap) {
    Palette.from(bitmap)
        .generate(
            palette -> {
              // دریافت رنگ‌ها از پالت
              int dominantColor = palette.getDarkMutedColor(Color.WHITE);
              int vibrantColor = palette.getDarkVibrantColor(Color.WHITE);
              int mutedColor = palette.getDarkMutedColor(Color.BLACK);

              // محاسبه رنگ‌های تیره‌تر
              int darkenedMutedColor = darkenColor(mutedColor, 5.0f);
              int darkenedDominantColor = darkenColor(dominantColor, 0.4f);

              // اعمال به پس‌زمینه
              bind.getRoot().setBackgroundColor(darkenedDominantColor);
              bind.play.setIconTint(ColorStateList.valueOf(mutedColor));
              bind.next.setColorFilter(darkenedMutedColor);
              bind.pre.setColorFilter(darkenedMutedColor);
              bind.play.setBackgroundTintList(ColorStateList.valueOf(darkenedMutedColor));
              // SeekBar customization
              ColorStateList thumbColor = ColorStateList.valueOf(darkenedMutedColor);
              bind.musicseekbar.setThumbTintList(thumbColor);
              bind.musicseekbar.setTrackActiveTintList(thumbColor);

              // متن‌ها
              bind.submusic.setTextColor(darkenedMutedColor);
              bind.tvname.setTextColor(darkenedMutedColor);
              bind.tvtr.setTextColor(darkenedMutedColor);
              bind.titlemusic.setTextColor(darkenedMutedColor);

              // نوار نویگیشن دیالوگ
              if (dialog != null && dialog.getWindow() != null) {
                dialog.getWindow().setNavigationBarColor(darkenedDominantColor);
                dialog.setTitle("Hello");
              }
            });
  }

  private int darkenColor(int color, float factor) {

    int a = Color.alpha(color);
    int r = (int) (Color.red(color) * factor);
    int g = (int) (Color.green(color) * factor);
    int b = (int) (Color.blue(color) * factor);

    r = Math.max(0, Math.min(r, 255));
    g = Math.max(0, Math.min(g, 255));
    b = Math.max(0, Math.min(b, 255));
    return Color.argb(a, r, g, b);
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
}
