package Ninja.coder.Ghostemane.code.widget.component;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import xyz.doikki.videoplayer.controller.ControlWrapper;
import xyz.doikki.videoplayer.controller.IGestureComponent;
import xyz.doikki.videoplayer.player.VideoView;

import static xyz.doikki.videoplayer.util.PlayerUtils.stringForTime;

/**
 * Gesture control
 */
public class GestureView extends FrameLayout implements IGestureComponent {

    private ControlWrapper mControlWrapper;
    private ImageView mIcon;
    private ProgressBar mProgressPercent;
    private TextView mTextPercent;
    private LinearLayout mCenterContainer;

    {
        setVisibility(GONE);
        LayoutInflater.from(getContext()).inflate(R.layout.dkplayer_layout_gesture_control_view, this, true);
        mIcon = findViewById(R.id.iv_icon);
        mProgressPercent = findViewById(R.id.pro_percent);
        mTextPercent = findViewById(R.id.tv_percent);
        mCenterContainer = findViewById(R.id.center_container);
        ColorAndroid12.setTextColor(mTextPercent);
        ColorAndroid12.setColorFilter(mIcon);
    }

    public GestureView(@NonNull Context context) {
        super(context);
    }

    public GestureView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public GestureView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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

    }

    @Override
    public void onPlayerStateChanged(int playerState) {

    }

    @Override
    public void onStartSlide() {
        mControlWrapper.hide();
        mCenterContainer.setVisibility(VISIBLE);
        mCenterContainer.setAlpha(1f);
    }

    @Override
    public void onStopSlide() {
        mCenterContainer.animate()
                .alpha(0f)
                .setDuration(300)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mCenterContainer.setVisibility(GONE);
                    }
                })
                .start();
    }

    @Override
    public void onPositionChange(int slidePosition, int currentPosition, int duration) {
        mProgressPercent.setVisibility(GONE);
        if (slidePosition > currentPosition) {
            mIcon.setImageResource(R.drawable.dkplayer_ic_action_fast_forward);
        } else {
            mIcon.setImageResource(R.drawable.dkplayer_ic_action_fast_rewind);
        }
        mTextPercent.setText(String.format("%s/%s", stringForTime(slidePosition), stringForTime(duration)));
    }

    @Override
    public void onBrightnessChange(int percent) {
        mProgressPercent.setVisibility(VISIBLE);
        mIcon.setImageResource(R.drawable.dkplayer_ic_action_brightness);
        mTextPercent.setText(percent + "%");
        mProgressPercent.setProgress(percent);
    }

    @Override
    public void onVolumeChange(int percent) {

        mProgressPercent.setVisibility(VISIBLE);
        if (percent <= 0) {
            mIcon.setImageResource(R.drawable.dkplayer_ic_action_volume_off);
        } else {
            mIcon.setImageResource(R.drawable.dkplayer_ic_action_volume_up);
        }
        mTextPercent.setText(percent + "%");
        mProgressPercent.setProgress(percent);
    }

    @Override
    public void onPlayStateChanged(int playState) {
        if (playState == VideoView.STATE_IDLE
                || playState == VideoView.STATE_START_ABORT
                || playState == VideoView.STATE_PREPARING
                || playState == VideoView.STATE_PREPARED
                || playState == VideoView.STATE_ERROR
                || playState == VideoView.STATE_PLAYBACK_COMPLETED) {
            setVisibility(GONE);
        } else {
            setVisibility(VISIBLE);
        }
    }

    @Override
    public void setProgress(int duration, int position) {

    }

    @Override
    public void onLockStateChanged(boolean isLock) {

    }

}