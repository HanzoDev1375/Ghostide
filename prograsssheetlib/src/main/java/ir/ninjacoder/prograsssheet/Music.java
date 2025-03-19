package ir.ninjacoder.prograsssheet;

import android.app.Activity;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import ir.ninjacoder.prograsssheet.interfaces.MediaPlayerListener;
import ir.ninjacoder.prograsssheet.util.Utils;
import java.io.File;
import java.util.Timer;
import android.media.MediaPlayer;
import java.util.TimerTask;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.graphics.BitmapFactory;
import java.util.HashMap;

public class Music {

  MediaPlayerListener mpl;
  Timer _timer;
  MediaPlayer mediaplayer;
  TimerTask timer;
  private Context classContext;
  private Bitmap bitmap;
  private String path;

  public Music(Context context, String path) {
    classContext = context;
    _timer = new Timer();
    timer =
        new TimerTask() {
          @Override
          public void run() {
            ((Activity) context)
                .runOnUiThread(
                    () -> {
                      if (mediaplayer != null) {
                        if (mediaplayer.isPlaying()) {
                          if (mpl != null) {
                            mpl.isPlaying(mediaplayer.getCurrentPosition());
                          }
                        }
                      }
                    });
          }
        };
    this.path = path;
    _timer.scheduleAtFixedRate(timer, 0, 100);
  }

  public void setPathSource(File file) {

    mediaplayer = MediaPlayer.create(classContext, Uri.fromFile(file));

    setImageBitmap(Uri.fromFile(file));
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
    return mediaplayer.getCurrentPosition();
  }

  public int getDuration() {
    return mediaplayer.getDuration();
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
    }
  }

  public void setImageBitmap(String url) {

    var mediameta = new MediaMetadataRetriever();
    mediameta.setDataSource(url, new HashMap<String, String>());

    byte[] data = mediameta.getEmbeddedPicture();

    if (data != null) {
      bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
    }
  }

  public String getNameArtist() {
    MediaMetadataRetriever meta = new MediaMetadataRetriever();
    try {
      meta.setDataSource(path);
      String artist = meta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
      return artist != null ? artist : "نام هنرمند موجود نیست";
    } catch (Exception e) {
      e.printStackTrace();

      return "خطا در بارگذاری";
    }
  }
  
  public String getNameAlbom() {
    MediaMetadataRetriever meta = new MediaMetadataRetriever();
    try {
      meta.setDataSource(path);
      String artist = meta.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
      return artist != null ? artist : "نام البوم موجود نیست";
    } catch (Exception e) {
      e.printStackTrace();

      return "خطا در بارگذاری";
    }
  }

  public void setSpeed(float speed) {
    if (Build.VERSION.SDK_INT >= 23) {
      mediaplayer.setPlaybackParams(mediaplayer.getPlaybackParams().setSpeed(speed));
    }
  }

  public void setSpeed(int speed) {
    setSpeed((float) speed);
  }

  public void setSpeed(double speed) {
    setSpeed((float) speed);
  }
}
