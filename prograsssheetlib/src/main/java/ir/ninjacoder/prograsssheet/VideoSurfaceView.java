package ir.ninjacoder.prograsssheet;

import android.content.Context;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.NonNull;
import java.io.IOException;

public class VideoSurfaceView extends TextureView implements TextureView.SurfaceTextureListener {

  private MediaPlayer mediaPlayer;
  private String path;
  private int currentPosition = 0;
  private boolean isPrepared = false;
  private Surface videoSurface;

  public VideoSurfaceView(Context context) {
    super(context);
    init();
  }

  public VideoSurfaceView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public VideoSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    setSurfaceTextureListener(this);
  }

  @Override
  public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
    if (path != null) {
      setupPlayer(surface);
    }
  }

  @Override
  public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {
    if (mediaPlayer != null) {
      mediaPlayer.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
    }
  }

  @Override
  public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
    releasePlayer();
    if (videoSurface != null) {
      videoSurface.release();
      videoSurface = null;
    }
    return true;
  }

  @Override
  public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {}

  private void setupPlayer(SurfaceTexture surfaceTexture) {
    try {
      if (mediaPlayer == null) {
        mediaPlayer = new MediaPlayer();
      }

      if (videoSurface != null) {
        videoSurface.release();
      }
      videoSurface = new Surface(surfaceTexture);

      mediaPlayer.setDataSource(getContext(), Uri.parse(path));
      mediaPlayer.setSurface(videoSurface);
      mediaPlayer.prepareAsync();

      mediaPlayer.setOnPreparedListener(
          mp -> {
            isPrepared = true;
            mediaPlayer.seekTo(currentPosition);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            mediaPlayer.setVolume(0, 0);
            setBackgroundColor(Color.TRANSPARENT);
          });

      mediaPlayer.setOnErrorListener(
          (mp, what, extra) -> {
            releasePlayer();
            setBackgroundColor(Color.TRANSPARENT);
            return true;
          });

    } catch (IOException e) {
      e.printStackTrace();
      setBackgroundColor(Color.TRANSPARENT);
      releasePlayer();
    }
  }

  public void releasePlayer() {
    if (mediaPlayer != null) {
      if (mediaPlayer.isPlaying()) {
        mediaPlayer.stop();
      }
      currentPosition = mediaPlayer.getCurrentPosition();
      mediaPlayer.reset();
      mediaPlayer.release();
      mediaPlayer = null;
      isPrepared = false;
    }
    if (videoSurface != null) {
      videoSurface.release();
      videoSurface = null;
    }
  }

  public void setPath(String path) {
    this.path = path;
    if (isSurfaceTextureAvailable()) {
      setupPlayer(getSurfaceTexture());
    }
  }

  private boolean isSurfaceTextureAvailable() {
    return getSurfaceTexture() != null;
  }

  // بقیه متدها مانند قبل بدون تغییر می‌مانند
  public String getPath() {
    return path;
  }

  public void pause() {
    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
      mediaPlayer.pause();
      currentPosition = mediaPlayer.getCurrentPosition();
    }
  }

  public void resume() {
    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
      mediaPlayer.start();
    } else if (mediaPlayer == null && path != null && isSurfaceTextureAvailable()) {
      setupPlayer(getSurfaceTexture());
    }
  }

  public void start() {
    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
      mediaPlayer.start();
    } else if (mediaPlayer == null && path != null && isSurfaceTextureAvailable()) {
      setupPlayer(getSurfaceTexture());
    }
  }

  public void stop() {
    if (mediaPlayer != null) {
      if (mediaPlayer.isPlaying()) {
        mediaPlayer.stop();
      }
      currentPosition = 0;
    }
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

  public void setCurrentPosition(int position) {
    this.currentPosition = position;
  }

  public boolean isPlaying() {
    return mediaPlayer != null && mediaPlayer.isPlaying();
  }

  public boolean isPrepared() {
    return isPrepared;
  }

  @Override
  public void setBackgroundColor(int color) {
    super.setBackgroundColor(color);
  }

  @Override
  public void setBackgroundDrawable(Drawable arg0) {}
}
