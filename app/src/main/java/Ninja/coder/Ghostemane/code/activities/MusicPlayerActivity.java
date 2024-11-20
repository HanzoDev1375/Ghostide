package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.glidecompat.GlideCompat;
import Ninja.coder.Ghostemane.code.utils.ObjectUtils;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScrollNestedScrollView;
import Ninja.coder.Ghostemane.code.widget.component.fastscrollcompat.FastScrollerBuilder;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.palette.graphics.Palette;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;

import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class MusicPlayerActivity extends BaseCompat {

  protected CollapsingToolbarLayout collapsing;
  protected FastScrollNestedScrollView sp;
  private MaterialToolbar mtoolbar;
  private double forwardTime = 0;
  private double backwardTime = 0;
  private ImageView dev;
  private TextView tvtr;
  private SeekBar ac_musicPl_seekbar;
  private TextView tvname;
  private ImageView pre;
  private ImageView play;
  private ImageView next;
  private LinearLayout backplay;
  private Music md;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.musicplayer);
    mtoolbar = findViewById(R.id.mainToolbar);
    dev = findViewById(R.id.dev);
    tvtr = findViewById(R.id.tvtr);
    ac_musicPl_seekbar = findViewById(R.id.ac_musicplayer_seekbar);
    tvname = findViewById(R.id.tvname);
    pre = findViewById(R.id.pre);
    play = findViewById(R.id.play);
    next = findViewById(R.id.next);
    backplay = findViewById(R.id.backplay);
    setSupportActionBar(mtoolbar);
    collapsing = findViewById(R.id.capsellToolbar);
    sp = findViewById(R.id.fastBar);
    start();
    callBack();
    var fastScrollerBuilder = new FastScrollerBuilder(sp);
    fastScrollerBuilder.useMd2Style();
    fastScrollerBuilder.setPadding(3, 3, 3, 3);
    fastScrollerBuilder.build();
    next.setImageResource(R.drawable.skipnext);
    pre.setImageResource(R.drawable.skipprevious);
    play.setImageResource(R.drawable.play_audio);
    if (md.isPlaying()) {
      md.pause();
    } else {
      md.start();
    }
    mtoolbar.setVisibility(View.GONE);
    var map = md.getImageBitmap();
    if (map != null) {
      var palette = Palette.from(map).generate();
      if (palette != null) {
        /*
        Light Vibrant
        Vibrant
        Dark Vibrant
        Light Muted
        Muted
        Dark Muted
        */
        getWindow().getDecorView().setBackgroundColor(palette.getMutedColor(0));
        tvname.setTextColor(palette.getLightMutedColor(MaterialColors.getColor(tvname,ObjectUtils.TvColor)));
        tvtr.setTextColor(palette.getLightMutedColor(MaterialColors.getColor(tvtr,ObjectUtils.TvColor)));
        play.setColorFilter(palette.getLightVibrantColor(MaterialColors.getColor(play,ObjectUtils.TvColor)), PorterDuff.Mode.SRC_IN);
        next.setColorFilter(palette.getLightVibrantColor(MaterialColors.getColor(next,ObjectUtils.TvColor)), PorterDuff.Mode.SRC_IN);
        pre.setColorFilter(palette.getLightVibrantColor(MaterialColors.getColor(pre,ObjectUtils.TvColor)), PorterDuff.Mode.SRC_IN);
        mtoolbar.setTitleTextColor(palette.getDarkMutedColor(MaterialColors.getColor(mtoolbar,ObjectUtils.TvColor)));
        getWindow().setNavigationBarColor(palette.getDarkMutedColor(MaterialColors.getColor(getApplicationContext(),ObjectUtils.Back,0)));
        GradientDrawable dv = new GradientDrawable();
        
        dv.setColor(palette.getLightVibrantColor(MaterialColors.getColor(backplay,ObjectUtils.Back)));
        dv.setStroke(1, palette.getVibrantColor(MaterialColors.getColor(backplay,ObjectUtils.colorAccent)));
        dv.setCornerRadius(99);
        backplay.setBackground(dv);
        ac_musicPl_seekbar
            .getThumb()
            .setColorFilter(palette.getLightMutedColor(MaterialColors.getColor(ac_musicPl_seekbar,ObjectUtils.TvColor)), PorterDuff.Mode.SRC_IN);
        ac_musicPl_seekbar
            .getProgressDrawable()
            .setColorFilter(palette.getLightMutedColor(MaterialColors.getColor(ac_musicPl_seekbar,ObjectUtils.TvColor)), PorterDuff.Mode.SRC_IN);
        if (Build.VERSION.SDK_INT >= 28) {
          getWindow().setNavigationBarDividerColor(palette.getLightVibrantColor(MaterialColors.getColor(getApplicationContext(),ObjectUtils.colorAccent,0)));
        }
      }
    } else {
      getWindow()
          .getDecorView()
          .setBackgroundColor(
              MaterialColors.getColor(getWindow().getDecorView(), ObjectUtils.Back));
      tvname.setTextColor(MaterialColors.getColor(tvname, ObjectUtils.colorOnSurface, 0));
      tvtr.setTextColor(MaterialColors.getColor(tvtr, ObjectUtils.colorOnSurface, 0));
      play.setColorFilter(
          MaterialColors.getColor(play, ObjectUtils.colorOnSurface, 0), PorterDuff.Mode.SRC_IN);
      next.setColorFilter(
          MaterialColors.getColor(next, ObjectUtils.colorOnSurface, 0), PorterDuff.Mode.SRC_IN);
      pre.setColorFilter(
          MaterialColors.getColor(pre, ObjectUtils.colorOnSurface, 0), PorterDuff.Mode.SRC_IN);

      getWindow()
          .setNavigationBarColor(
              MaterialColors.getColor(MusicPlayerActivity.this, ObjectUtils.colorOnSurface, 0));
      GradientDrawable dv = new GradientDrawable();
      dv.setColor(MaterialColors.getColor(MusicPlayerActivity.this, ObjectUtils.ButtonBack, 0));
      dv.setStroke(
          1, MaterialColors.getColor(MusicPlayerActivity.this, ObjectUtils.colorOnSurface, 0));
      dv.setCornerRadius(99);
      backplay.setBackground(dv);
      ac_musicPl_seekbar
          .getThumb()
          .setColorFilter(
              MaterialColors.getColor(ac_musicPl_seekbar, ObjectUtils.colorOnSurface, 0),
              PorterDuff.Mode.SRC_IN);
      ac_musicPl_seekbar
          .getProgressDrawable()
          .setColorFilter(
              MaterialColors.getColor(ac_musicPl_seekbar, ObjectUtils.colorOnSurface, 0),
              PorterDuff.Mode.SRC_IN);
      if (Build.VERSION.SDK_INT >= 28) {
        getWindow()
            .setNavigationBarDividerColor(
                MaterialColors.getColor(
                    MusicPlayerActivity.this, ObjectUtils.colorOnSurface, 0));
      }
    }

    ac_musicPl_seekbar.setOnSeekBarChangeListener(
        new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar _param1, int _param2, boolean _param3) {
            final int _progressValue = _param2;
            if (md != null && _param3) {
              md.seekTo(_param2 * 90);
            }
          }

          @Override
          public void onStartTrackingTouch(SeekBar _param1) {}

          @Override
          public void onStopTrackingTouch(SeekBar _param2) {}
        });

    pre.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if ((md.getCurrentDuration() - backwardTime) > 0) {
              md.seekTo(md.getCurrentDuration() - (int) backwardTime);
            } else {
              md.seekTo(0);
            }
          }
        });

    play.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if (md.isPlaying()) {
              md.pause();
            } else {
              md.start();
            }
          }
        });

    next.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            if ((md.getCurrentDuration() + (int) forwardTime) <= md.getDuration()) {
              md.seekTo((int) md.getCurrentDuration() + (int) forwardTime);
            }
          }
        });
  }

  public void callBack() {

    getOnBackPressedDispatcher()
        .addCallback(
            this,
            new OnBackPressedCallback(true) {

              @Override
              public void handleOnBackPressed() {
                if (md.isPlaying()) {
                  md.pause();
                  //   md.release();
                }
                finish();
              }
            });
  }

  private void start() {
    md = new Music(this);
    md.setPathSource(new File(getIntent().getStringExtra("Path")));
    GlideCompat.GlideLoadMp3(dev, getIntent().getStringExtra("Path"));
    ac_musicPl_seekbar.setMax((int) md.getDuration() / 90);

    md.setMediaPlayerListener(
        new Music.MediaPlayerListener() {

          @Override
          public void isPlaying(int currentDuration) {}

          @Override
          public void onPause() {
            play.setImageResource(R.drawable.stop);
          }

          @Override
          public void onStart() {
            play.setImageResource(R.drawable.play_audio);
          }
        });

    final Handler mHandler = new Handler(Looper.getMainLooper());
    runOnUiThread(
        new Runnable() {

          @Override
          public void run() {
            if (md != null) {
              int mCurrentPosition = 0;
              ac_musicPl_seekbar.setProgress(md.getCurrentDuration() / 90);
              int currentPositionInMillis =
                  md.getCurrentDuration(); // زمان در حال پخش در میلی‌ثانیه
              int currentPositionInSeconds = currentPositionInMillis / 1000; // زمان در ثانیه
              int minutes = currentPositionInSeconds / 60;
              int seconds = currentPositionInSeconds % 60;
              tvtr.setText(String.format("%d:%02d", minutes, seconds));
            }
            mHandler.postDelayed(this, 90);
          }
        });

    forwardTime = 5000;
    backwardTime = 5000;
    int durationInMillis = md.getDuration(); // زمان در میلی‌ثانیه
    int durationInSeconds = durationInMillis / 1000; // زمان در ثانیه
    int minutes = durationInSeconds / 60;
    int seconds = durationInSeconds % 60;
    tvname.setText(String.format("%d:%02d", minutes, seconds));
  }

  public static class Music {

    public static MediaPlayerListener mpl;
    public static Timer _timer;
    public static MediaPlayer mediaplayer;
    public static TimerTask timer;
    private Context classContext;
    private Bitmap bitmap;

    public Music(Context context) {
      classContext = context;
      _timer = new Timer();
      timer =
          new TimerTask() {
            @Override
            public void run() {
              ((Activity) classContext)
                  .runOnUiThread(
                      new Runnable() {
                        @Override
                        public void run() {
                          if (mediaplayer != null) {
                            if (mediaplayer.isPlaying()) {
                              if (mpl != null) {
                                mpl.isPlaying(mediaplayer.getCurrentPosition());
                              }
                            }
                          }
                        }
                      });
            }
          };
      _timer.scheduleAtFixedRate(timer, (int) (0), (int) (100));
    }

    public void setRawSource(int rawFileName) {

      mediaplayer = MediaPlayer.create(classContext, rawFileName);

      setImageBitmap(
          Uri.parse("android.resource://" + classContext.getPackageName() + "/" + rawFileName));
    }

    public void setPathSource(java.io.File file) {

      mediaplayer = MediaPlayer.create(classContext, Uri.fromFile(file));

      setImageBitmap(Uri.fromFile(file));
    }

    public void setAssetSource(String assetFileName) {
      java.io.File mediaplayerFile = new java.io.File(classContext.getCacheDir(), assetFileName);
      try {
        java.io.InputStream mediaplayerIS = classContext.getAssets().open(assetFileName);
        java.io.FileOutputStream mediaplayerFOS = null;
        mediaplayerFOS = new java.io.FileOutputStream(mediaplayerFile);
        final byte[] mediaplayerByte = new byte[1024];
        int mediaplayerint;
        while ((mediaplayerint = mediaplayerIS.read(mediaplayerByte)) != -1) {
          mediaplayerFOS.write(mediaplayerByte, 0, mediaplayerint);
        }
        mediaplayerIS.close();
        mediaplayerFOS.close();
      } catch (Exception e) {
      }
      mediaplayer =
          MediaPlayer.create(
              classContext, Uri.fromFile(new java.io.File(mediaplayerFile.getAbsolutePath())));

      setImageBitmap(Uri.fromFile(mediaplayerFile));
    }

    public void setUrlSource(String urlSource) {
      mediaplayer = MediaPlayer.create(classContext, Uri.parse(urlSource));

      setImageBitmap(urlSource);
    }

    public void setMediaPlayerListener(MediaPlayerListener mpl) {
      this.mpl = mpl;
    }

    public void start() {
      if (mediaplayer != null) {
        mediaplayer.start();
        if (mpl != null) {
          mpl.onStart();
        }
      }
    }

    public void pause() {
      if (mediaplayer != null) {
        if (mediaplayer.isPlaying()) {
          mediaplayer.pause();
        }
        if (mpl != null) {
          mpl.onPause();
        }
      }
    }

    public void release() {
      mediaplayer.release();
      mediaplayer = null;
    }

    public boolean isPlaying() {
      return mediaplayer.isPlaying();
    }

    public void setLooping(boolean isLooping) {
      mediaplayer.setLooping(isLooping);
    }

    public int getCurrentDuration() {
      return (int) mediaplayer.getCurrentPosition();
    }

    public int getDuration() {
      return (int) mediaplayer.getDuration();
    }

    public void seekTo(int seekToValue) {
      mediaplayer.seekTo(seekToValue);
    }

    public MediaPlayer getMediaPlayer() {
      return mediaplayer;
    }

    public Bitmap getImageBitmap() {
      return bitmap;
    }

    public void setImageBitmap(Uri uri) {

      final android.media.MediaMetadataRetriever mmr = new android.media.MediaMetadataRetriever();
      mmr.setDataSource(classContext, uri);

      byte[] data = mmr.getEmbeddedPicture();

      if (data != null) {
        bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
      } else {

      }
    }

    public void setImageBitmap(String url) {

      final android.media.MediaMetadataRetriever mmr = new android.media.MediaMetadataRetriever();
      mmr.setDataSource(url, new HashMap<String, String>());

      byte[] data = mmr.getEmbeddedPicture();

      if (data != null) {
        bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

      } else {

      }
    }

    public void setSpeed(float speed) {
      if (android.os.Build.VERSION.SDK_INT >= 23) {
        mediaplayer.setPlaybackParams(mediaplayer.getPlaybackParams().setSpeed((float) speed));
      }
    }

    public void setSpeed(int speed) {
      setSpeed((float) speed);
    }

    public void setSpeed(double speed) {
      setSpeed((float) speed);
    }

    public interface MediaPlayerListener {

      void isPlaying(int currentDuration);

      void onPause();

      void onStart();
    }
  }
}
