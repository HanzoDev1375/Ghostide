package ir.ninjacoder.prograsssheet;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.color.MaterialColors;
import java.io.IOException;

public class VideoSurfaceView extends SurfaceView
    implements SurfaceHolder.Callback, DefaultLifecycleObserver {

  private MediaPlayer mediaPlayer;
  private String path;
  private int currentPosition = 0;
  private boolean isPrepared = false;
  private Lifecycle lifecycle;

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
    getHolder().addCallback(this);
    
  }
  
  
  public void setLifecycle(Lifecycle lifecycle) {
    if (this.lifecycle != null) {
      this.lifecycle.removeObserver(this);
    }
    this.lifecycle = lifecycle;
    this.lifecycle.addObserver(this);
  }

  @Override
  public void surfaceCreated(@NonNull SurfaceHolder holder) {
    if (path != null) {
      setupPlayer(holder);
    }
  }

  @Override
  public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {}

  @Override
  public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
    releasePlayer();
  }

  private void setupPlayer(SurfaceHolder holder) {
    if (mediaPlayer == null) {
      mediaPlayer = new MediaPlayer();
    }
    try {
      mediaPlayer.setDataSource(getContext(), Uri.parse(path));
      mediaPlayer.setDisplay(holder);
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
            return true;
          });
    } catch (IOException e) {
      e.printStackTrace();
      releasePlayer();
    }
  }

  public void releasePlayer() {
    if (mediaPlayer != null) {
      if (mediaPlayer.isPlaying()) {
        mediaPlayer.stop();
      }
      currentPosition = mediaPlayer.getCurrentPosition();
      mediaPlayer.release();
      mediaPlayer = null;
      isPrepared = false;
    }
  }

  public void setPath(String path) {
    this.path = path;
    if (getHolder().getSurface().isValid()) {
      setupPlayer(getHolder());
    }
  }

  public String getPath() {
    return path;
  }

  // متدهای DefaultLifecycleObserver
  @Override
  public void onPause(@NonNull LifecycleOwner owner) {
    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
      mediaPlayer.pause();
      currentPosition = mediaPlayer.getCurrentPosition();
    }
  }

  @Override
  public void onResume(@NonNull LifecycleOwner owner) {
    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
      mediaPlayer.start();
    } else if (mediaPlayer == null && path != null && getHolder().getSurface().isValid()) {
      setupPlayer(getHolder());
    }
  }

  @Override
  public void onStart(@NonNull LifecycleOwner owner) {
    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
      mediaPlayer.start();
    } else if (mediaPlayer == null && path != null && getHolder().getSurface().isValid()) {
      setupPlayer(getHolder());
    }
  }

  @Override
  public void onStop(@NonNull LifecycleOwner owner) {
    if (mediaPlayer != null) {
      if (mediaPlayer.isPlaying()) {
        mediaPlayer.stop();
      }
      currentPosition = 0;
    }
  }

  @Override
  public void onDestroy(@NonNull LifecycleOwner owner) {
    releasePlayer();
    if (lifecycle != null) {
      lifecycle.removeObserver(this);
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

  public void setBackgroundColor(int color) {
    super.setBackgroundColor(color);
  }
}
