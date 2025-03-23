package ir.ninjacoder.prograsssheet;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;
import java.io.IOException;
import static com.google.android.material.R.attr.colorSurface;

/**
 * code by ninja coder This class is created for Ghost IDE application but you can still use it for
 * your own applications. You need to add a layout frame and add this layout to your xml and then
 * findviewbyid or if you are using the binding system, use the bind and call the setPath method and
 * pass the path of the mp4 file. <?xml version="1.0" encoding="utf-8"?> <FrameLayout
 * xmlns:android="http://schemas.android.com/apk/res/android"
 * xmlns:app="http://schemas.android.com/apk/res-auto" android:layout_height="match_parent"
 * android:layout_width="match_parent"
 *
 * <p>android:orientation="vertical">
 *
 * <p><ir.ninjacoder.prograsssheet.VideoSurfaceView android:layout_height="match_parent"
 * android:layout_width="match_parent" android:id="@+id/videoview" />
 *
 * <p><LinearLayout android:layout_height="match_parent" android:layout_width="match_parent"
 * android:gravity="center" android:orientation="vertical">
 *
 * <p><EditText android:layout_height="wrap_content" android:layout_width="wrap_content"
 * android:hint="add music file" android:layout_marginTop="9dp" android:id="@+id/musicfile" />
 *
 * <p><Button android:layout_height="wrap_content" android:layout_width="wrap_content"
 * android:text="Click!" android:id="@+id/btn" />
 *
 * <p><Button android:layout_height="wrap_content" android:layout_width="wrap_content"
 * android:text="Click!" android:id="@+id/btn2" />
 *
 * <p></LinearLayout>
 *
 * <p></FrameLayout>
 *
 * <p>deom layout
 */
public class VideoSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

  private MediaPlayer mediaPlayer;
  private String path;
  private int currentPosition = 0;
  private boolean isPrepared = false;

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
    setBackgroundColor(MaterialColors.getColor(this, colorSurface));
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
            setBackgroundColor(MaterialColors.getColor(getContext(), colorSurface, 0));
            return true;
          });
    } catch (IOException e) {
      e.printStackTrace();
      setBackgroundColor(Color.GRAY);
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

  public void pause() {
    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
      mediaPlayer.pause();
      currentPosition = mediaPlayer.getCurrentPosition();
    }
  }

  public void resume() {
    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
      mediaPlayer.start();
    } else if (mediaPlayer == null && path != null && getHolder().getSurface().isValid()) {
      setupPlayer(getHolder());
    }
  }

  public void start() {
    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
      mediaPlayer.start();
    } else if (mediaPlayer == null && path != null && getHolder().getSurface().isValid()) {
      setupPlayer(getHolder());
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

  public void setBackgroundColor(int color) {
    super.setBackgroundColor(color);
  }
}
