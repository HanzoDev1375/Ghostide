package ir.ninjacoder.ghostide.core.widget.component;

import ir.ninjacoder.prograsssheet.util.SquigglyProgress;
import static xyz.doikki.videoplayer.util.PlayerUtils.stringForTime;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import xyz.doikki.videoplayer.controller.ControlWrapper;
import xyz.doikki.videoplayer.controller.IControlComponent;
import xyz.doikki.videoplayer.player.VideoView;
import xyz.doikki.videoplayer.util.PlayerUtils;

/** On-demand control bar at the bottom */
public class VodControlView extends FrameLayout
    implements IControlComponent, View.OnClickListener, SeekBar.OnSeekBarChangeListener {

  protected ControlWrapper mControlWrapper;
  protected OnClick click;
  private TextView mTotalTime, mCurrTime;
  private ImageView mFullScreen;
  private LinearLayout mBottomContainer;
  private SeekBar mVideoProgress;
  private ProgressBar mBottomProgress;
  private ImageView mPlayButton;
  private ImageView speed;
  private ImageView proportion;
  private boolean mIsDragging;
  private SharedPreferences prf;
  protected SquigglyProgress bars;
  private boolean mIsShowBottomProgress = true;

  public VodControlView(@NonNull Context context) {
    super(context);
    init(context);
  }

  public VodControlView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public VodControlView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  protected int getLayoutId() {
    return R.layout.dkplayer_layout_vod_control_view;
  }

  void init(Context context) {
    setVisibility(GONE);
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
    mFullScreen = findViewById(R.id.fullscreen);
    mFullScreen.setOnClickListener(this);
    mBottomContainer = findViewById(R.id.bottom_container);
    mVideoProgress = findViewById(R.id.seekBar);
    mVideoProgress.setOnSeekBarChangeListener(this);
    mTotalTime = findViewById(R.id.total_time);
    mCurrTime = findViewById(R.id.curr_time);
    mPlayButton = findViewById(R.id.iv_play);
    mPlayButton.setOnClickListener(this);
    mBottomProgress = findViewById(R.id.bottom_progress);
    speed = findViewById(R.id.speed);
    speed.setOnClickListener(this);
    proportion = findViewById(R.id.proportion);
    proportion.setOnClickListener(this);
    ObjectUtils.setColorFilter(speed);
    ObjectUtils.setColorFilter(mFullScreen);
    ObjectUtils.setTextColor(mTotalTime);
    ObjectUtils.setTextColor(mCurrTime);
    ObjectUtils.setColorFilter(proportion);
    ObjectUtils.setColorFilter(mPlayButton);
    bars = new SquigglyProgress();
    bars.setWaveLength(100);
    bars.setLineAmplitude(8);
    bars.setPhaseSpeed(25);
    if (bars != null) bars.setStrokeWidth(convertToPx(context, 4));
    bars.setTransitionEnabled(true);
    bars.setAnimate(true);
    mVideoProgress.setProgressDrawable(bars);

    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
      mVideoProgress.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
    }
    prf = getContext().getSharedPreferences("prf", Context.MODE_PRIVATE);
  }

  public void MatchToOnBack() {
    if (!(prf.getInt("prf", 0) == 0)) {
      mVideoProgress.setProgress(prf.getInt("prf", 0));
    }
  }

  public void showBottomProgress(boolean isShow) {
    mIsShowBottomProgress = isShow;
  }

  @Override
  public void attach(@NonNull ControlWrapper controlWrapper) {
    mControlWrapper = controlWrapper;
  }

  @Override
  public View getView() {
    return this;
  }

  @Override
  public void onVisibilityChanged(boolean isVisible, Animation anim) {
    if (isVisible) {
      mBottomContainer.setVisibility(VISIBLE);
      if (anim != null) {
        mBottomContainer.startAnimation(anim);
      }
      if (mIsShowBottomProgress) {
        mBottomProgress.setVisibility(GONE);
      }
    } else {
      mBottomContainer.setVisibility(GONE);
      if (anim != null) {
        mBottomContainer.startAnimation(anim);
      }
      if (mIsShowBottomProgress) {
        mBottomProgress.setVisibility(VISIBLE);
        AlphaAnimation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(300);
        mBottomProgress.startAnimation(animation);
      }
    }
  }

  @Override
  public void onPlayStateChanged(int playState) {
    switch (playState) {
      case VideoView.STATE_IDLE:
      case VideoView.STATE_PLAYBACK_COMPLETED:
        setVisibility(GONE);
        mBottomProgress.setProgress(0);
        mBottomProgress.setSecondaryProgress(0);
        mVideoProgress.setProgress(0);
        mVideoProgress.setSecondaryProgress(0);
        break;
      case VideoView.STATE_START_ABORT:
      case VideoView.STATE_PREPARING:
      case VideoView.STATE_PREPARED:
      case VideoView.STATE_ERROR:
        setVisibility(GONE);
        break;
      case VideoView.STATE_PLAYING:
        mPlayButton.setSelected(true);
        bars.setAnimate(true);
        if (mIsShowBottomProgress) {
          if (mControlWrapper.isShowing()) {
            mBottomProgress.setVisibility(GONE);
            mBottomContainer.setVisibility(VISIBLE);
          } else {
            mBottomContainer.setVisibility(GONE);
            mBottomProgress.setVisibility(VISIBLE);
          }
        } else {
          mBottomContainer.setVisibility(GONE);
        }
        setVisibility(VISIBLE);
        mControlWrapper.startProgress();
        break;
      case VideoView.STATE_PAUSED:
        bars.setAnimate(false);
        mPlayButton.setSelected(false);
        break;
      case VideoView.STATE_BUFFERING:
      case VideoView.STATE_BUFFERED:
        bars.setAnimate(mControlWrapper.isPlaying());
        mPlayButton.setSelected(mControlWrapper.isPlaying());
        break;
    }
  }

  @Override
  public void onPlayerStateChanged(int playerState) {
    switch (playerState) {
      case VideoView.PLAYER_NORMAL:
        /*test*/ mFullScreen.setSelected(true /*last false*/);
        speed.setVisibility(GONE);
        proportion.setVisibility(GONE);
        break;
      case VideoView.PLAYER_FULL_SCREEN:
        mFullScreen.setSelected(true);
        speed.setVisibility(VISIBLE);
        proportion.setVisibility(VISIBLE);
        break;
    }

    Activity activity = PlayerUtils.scanForActivity(getContext());
    if (activity != null && mControlWrapper.hasCutout()) {
      int orientation = activity.getRequestedOrientation();
      int cutoutHeight = mControlWrapper.getCutoutHeight();
      if (orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
        mBottomContainer.setPadding(0, 0, 0, 0);
        mBottomProgress.setPadding(0, 0, 0, 0);
      } else if (orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
        mBottomContainer.setPadding(cutoutHeight, 0, 0, 0);
        mBottomProgress.setPadding(cutoutHeight, 0, 0, 0);
      } else if (orientation == ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE) {
        mBottomContainer.setPadding(0, 0, cutoutHeight, 0);
        mBottomProgress.setPadding(0, 0, cutoutHeight, 0);
      }
    }
  }

  @Override
  public void setProgress(int duration, int position) {
    if (mIsDragging) {
      return;
    }

    if (mVideoProgress != null) {
      if (duration > 0) {
        mVideoProgress.setEnabled(true);
        int pos = (int) (position * 1.0 / duration * mVideoProgress.getMax());
        mVideoProgress.setProgress(pos);
        mBottomProgress.setProgress(pos);
      } else {
        mVideoProgress.setEnabled(false);
      }
      int percent = mControlWrapper.getBufferedPercentage();
      if (percent >= 95) { // 解决缓冲进度不能100%问题
        mVideoProgress.setSecondaryProgress(mVideoProgress.getMax());
        mBottomProgress.setSecondaryProgress(mBottomProgress.getMax());
      } else {
        mVideoProgress.setSecondaryProgress(percent * 10);
        mBottomProgress.setSecondaryProgress(percent * 10);
      }
    }

    if (mTotalTime != null) mTotalTime.setText(stringForTime(duration));
    if (mCurrTime != null) mCurrTime.setText(stringForTime(position));
  }

  @Override
  public void onLockStateChanged(boolean isLocked) {
    onVisibilityChanged(!isLocked, null);
  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.fullscreen) {
      toggleFullScreen();
    } else if (id == R.id.iv_play) {
      mControlWrapper.togglePlay();
    } else if (id == R.id.speed) {

    } else if (id == R.id.proportion) {

    }
  }

  /** 横竖屏切换 */
  public void toggleFullScreen() {
    Activity activity = PlayerUtils.scanForActivity(getContext());
    mControlWrapper.toggleFullScreen(activity);
  }

  @Override
  public void onStartTrackingTouch(SeekBar seekBar) {
    mIsDragging = true;
    mControlWrapper.stopProgress();
    mControlWrapper.stopFadeOut();
  }

  @Override
  public void onStopTrackingTouch(SeekBar seekBar) {
    long duration = mControlWrapper.getDuration();
    long newPosition = (duration * seekBar.getProgress()) / mVideoProgress.getMax();
    mControlWrapper.seekTo((int) newPosition);
    mIsDragging = false;
    mControlWrapper.startProgress();
    mControlWrapper.startFadeOut();
  }

  @Override
  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    if (!fromUser) {
      return;
    }
    prf.edit().putInt("prf", progress).apply();
    long duration = mControlWrapper.getDuration();
    long newPosition = (duration * progress) / mVideoProgress.getMax();
    if (mCurrTime != null) mCurrTime.setText(stringForTime((int) newPosition));
  }

  public void setCallBack(OnClick click) {
    if (click instanceof OnClick) {
      this.click = click;
    }
  }

  public interface OnClick {
    public void click();
  }

  int convertToPx(Context context, float dp) {
    float density = context.getResources().getDisplayMetrics().density;
    return (int) (dp * density + 0.5f);
  }
}
