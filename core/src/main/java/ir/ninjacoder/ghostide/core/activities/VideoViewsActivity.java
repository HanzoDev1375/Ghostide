package ir.ninjacoder.ghostide.core.activities;

import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Rational;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.DrawerPopupView;
import com.lxj.xpopup.enums.PopupPosition;

import java.util.ArrayList;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.StandardVideoController;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;
import ir.ninjacoder.ghostide.core.widget.component.CompleteView;
import ir.ninjacoder.ghostide.core.widget.component.ErrorView;
import ir.ninjacoder.ghostide.core.widget.component.GestureView;
import ir.ninjacoder.ghostide.core.widget.component.PrepareView;
import ir.ninjacoder.ghostide.core.widget.component.TitleView;
import ir.ninjacoder.ghostide.core.widget.component.VodControlView;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import xyz.doikki.videoplayer.player.VideoView;

@RequiresApi(api = Build.VERSION_CODES.O)
public class VideoViewsActivity extends BaseCompat {

  private static final String ACTION_MEDIA_CONTROL = "media_control";
  private static final String EXTRA_CONTROL_TYPE = "control_type";
  private static final int REQUEST_PLAY = 1;
  private static final int REQUEST_PAUSE = 2;
  private static final int CONTROL_TYPE_PLAY = 1;
  private static final int CONTROL_TYPE_PAUSE = 2;
  private static final int CONTROL_TYPE_REPLAY = 3;
  private static final int REQUEST_REPLAY = 3;
  private final PictureInPictureParams.Builder mPictureInPictureParamsBuilder =
      new PictureInPictureParams.Builder();
  private BroadcastReceiver mReceiver;
  private StandardVideoController mController;
  private int mWidthPixels;
  private xyz.doikki.videoplayer.player.VideoView mVideoView;
  private String path = "";
  private String title = "";
  private String speed = "";
  private String proportion = "";
  private LinearLayout viewvideo;
  private MaterialToolbar toolbar;
  private SharedPreferences prf;
  private VodControlView vodControlView;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.videoviews);
    initialize(_savedInstanceState);
    initializeLogic();
    prf = getSharedPreferences("prf", MODE_PRIVATE);
  }

  private void initialize(Bundle _savedInstanceState) {

    viewvideo = findViewById(R.id.viewvideo);
    toolbar = findViewById(R.id.toolbar);
  }

  private void initializeLogic() {
    setSupportActionBar(toolbar);
    if (getIntent().hasExtra("getPath")) {
      path = getIntent().getStringExtra("getPath");
    } else {
      Uri uri = getIntent().getData();
      if (uri != null) {
        path = uri.toString();
      }
    }
    if (getIntent().hasExtra("getTitle")) {
      title = getIntent().getStringExtra("getTitle");
      toolbar.setSubtitle(getIntent().getStringExtra("getTitle"));
    } else {
      Uri uri = getIntent().getData();
      title = uri.toString();
      toolbar.setSubtitle(title);
    }

    mVideoView = new VideoView(this);
    LinearLayout.LayoutParams lpviewvideo =
        new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    viewvideo.setLayoutParams(lpviewvideo);
    mVideoView.setPadding(0,0,0,0);
    mVideoView.setClipToPadding(false);
    viewvideo.addView(mVideoView);
    mWidthPixels = getResources().getDisplayMetrics().widthPixels;
    //  mVideoView.setLayoutParams(
    //   new LinearLayout.LayoutParams(mWidthPixels, mWidthPixels * 9 / 16 + 1));
    
    //mVideoView.startFullScreen();
    mVideoView.setUrl(path);
    mController = new StandardVideoController(this);
    mController.addControlComponent(new CompleteView(this));
    mController.addControlComponent(new ErrorView(this));
    mController.addControlComponent(new PrepareView(this));
    mController.addControlComponent(new GestureView(this));
    vodControlView = new VodControlView(this);
    vodControlView
        .findViewById(R.id.speed)
        .setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                new XPopup.Builder(VideoViewsActivity.this)
                    .popupPosition(com.lxj.xpopup.enums.PopupPosition.Right) // 右边
                    // .hasStatusBarShadow(true) //启用状态栏阴影
                    .asCustom(new CustomDrawerPopupView(VideoViewsActivity.this))
                    .show();
              }
            });
    vodControlView
        .findViewById(R.id.proportion)
        .setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                new XPopup.Builder(VideoViewsActivity.this)
                    .popupPosition(PopupPosition.Right)
                    .asCustom(new CustomDrawerPopupView1(VideoViewsActivity.this))
                    .show();
              }
            });
    mController.addControlComponent(vodControlView);
    TitleView titleView = new TitleView(this);
    titleView
        .findViewById(R.id.pip)
        .setOnClickListener(
            new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                Rational aspectRatio = new Rational(16, 9);
                mPictureInPictureParamsBuilder.setAspectRatio(aspectRatio).build();
                enterPictureInPictureMode(mPictureInPictureParamsBuilder.build());
              }
            });

    titleView.setTitle(title);
    mController.addControlComponent(titleView);

    mVideoView.setVideoController(mController);
    mVideoView.addOnStateChangeListener(
        new VideoView.SimpleOnStateChangeListener() {
          @Override
          public void onPlayStateChanged(int playState) {
            switch (playState) {
              case VideoView.STATE_PAUSED:
                updatePictureInPictureActions(
                    R.drawable.dkplayer_ic_action_play_arrow,
                    "play",
                    CONTROL_TYPE_PLAY,
                    REQUEST_PLAY);
                break;
              case VideoView.STATE_PLAYING:
                updatePictureInPictureActions(
                    R.drawable.dkplayer_ic_action_pause,
                    "pause",
                    CONTROL_TYPE_PAUSE,
                    REQUEST_PAUSE);
                break;
              case VideoView.STATE_PLAYBACK_COMPLETED:
                updatePictureInPictureActions(
                    R.drawable.dkplayer_ic_action_replay,
                    "Replay",
                    CONTROL_TYPE_REPLAY,
                    REQUEST_REPLAY);
                break;
            }
          }
        });
    mVideoView.start();
  }

  void updatePictureInPictureActions(
      @DrawableRes int iconId, String title, int controlType, int requestCode) {
    final ArrayList<RemoteAction> actions = new ArrayList<>();

    // This is the PendingIntent that is invoked when a user clicks on the action item.
    // You need to use distinct request codes for play and pause, or the PendingIntent won't
    // be properly updated.
    final PendingIntent intent =
        PendingIntent.getBroadcast(
            VideoViewsActivity.this,
            requestCode,
            new Intent(ACTION_MEDIA_CONTROL).putExtra(EXTRA_CONTROL_TYPE, controlType),
            PendingIntent.FLAG_IMMUTABLE);

    final Icon icon = Icon.createWithResource(VideoViewsActivity.this, iconId);
    actions.add(new RemoteAction(icon, title, title, intent));

    mPictureInPictureParamsBuilder.setActions(actions);

    // This is how you can update action items (or aspect ratio) for Picture-in-Picture mode.
    // Note this call can happen even when the app is not in PiP mode. In that case, the
    // arguments will be used for at the next call of #enterPictureInPictureMode.
    setPictureInPictureParams(mPictureInPictureParamsBuilder.build());
  }

  @Override
  public void onBackPressed() {
    if (!mVideoView.onBackPressed()) {
      super.onBackPressed();
      if (vodControlView != null) {
        vodControlView.MatchToOnBack();
        finish();
      }
    }
  }

  @Override
  public void onPictureInPictureModeChanged(
      boolean isInPictureInPictureMode, Configuration newConfig) {
    super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
    Log.d("pip", "onPictureInPictureModeChanged: " + isInPictureInPictureMode);
    if (isInPictureInPictureMode) {
      mVideoView.setVideoController(null);
      mVideoView.setLayoutParams(
          new LinearLayout.LayoutParams(
              ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
      // Starts receiving events from action items in PiP mode.
      mReceiver =
          new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
              if (intent == null || !ACTION_MEDIA_CONTROL.equals(intent.getAction())) {
                return;
              }

              // This is where we are called mBack from Picture-in-Picture action
              // items.
              final int controlType = intent.getIntExtra(EXTRA_CONTROL_TYPE, 0);
              switch (controlType) {
                case CONTROL_TYPE_PLAY:
                  mVideoView.start();
                  break;
                case CONTROL_TYPE_PAUSE:
                  mVideoView.pause();
                  break;
                case CONTROL_TYPE_REPLAY:
                  mVideoView.replay(true);
                  break;
              }
            }
          };
      registerReceiver(mReceiver, new IntentFilter(ACTION_MEDIA_CONTROL));
    } else {
      // We are out of PiP mode. We can stop receiving events from it.
      unregisterReceiver(mReceiver);
      mReceiver = null;
      Log.d("pip", "onPictureInPictureModeChanged: " + mVideoView);
      mVideoView.setLayoutParams(
          new LinearLayout.LayoutParams(mWidthPixels, mWidthPixels * 9 / 16 + 1));
      mVideoView.setVideoController(mController);
      mVideoView.requestLayout();
    }
  }

  @Override
  public void onStop() {
    super.onStop();
    mVideoView.pause();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mVideoView.release();
  }

  public void showMessage(String _s) {
    Toast.makeText(VideoViewsActivity.this, _s, Toast.LENGTH_SHORT).show();
  }

  public class CustomDrawerPopupView extends DrawerPopupView {
    public CustomDrawerPopupView(@NonNull Context context) {
      super(context);
    }

    @Override
    protected int getImplLayoutId() {
      return R.layout.speed;
    }

    @Override
    protected void onCreate() {
      super.onCreate();

      final TextView txt1 = findViewById(R.id.textview1);
      final TextView txt2 = findViewById(R.id.textview2);
      final TextView txt3 = findViewById(R.id.textview3);
      final TextView txt4 = findViewById(R.id.textview4);
      final TextView txt5 = findViewById(R.id.textview5);

      if (speed.equals("0.75")) {
        txt1.setTextColor(
            MaterialColors.getColor(VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
      }
      if (speed.equals("1.0")) {
        txt2.setTextColor(
            MaterialColors.getColor(VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
      }
      if (speed.equals("1.25")) {
        txt3.setTextColor(
            MaterialColors.getColor(VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
      }
      if (speed.equals("1.5")) {
        txt4.setTextColor(
            MaterialColors.getColor(VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
      }
      if (speed.equals("2.0")) {
        txt5.setTextColor(
            MaterialColors.getColor(VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
      }

      findViewById(R.id.cardview1)
          .setOnClickListener(
              new OnClickListener() {
                @Override
                public void onClick(View v) {
                  mVideoView.setSpeed(0.75f);
                  speed = "0.75";
                  txt1.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt2.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt3.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt4.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt5.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                }
              });

      findViewById(R.id.cardview2)
          .setOnClickListener(
              new OnClickListener() {
                @Override
                public void onClick(View v) {
                  mVideoView.setSpeed(1.0f);
                  speed = "1.0";
                  txt2.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt1.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt3.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt4.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt5.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                }
              });

      findViewById(R.id.cardview3)
          .setOnClickListener(
              new OnClickListener() {
                @Override
                public void onClick(View v) {
                  mVideoView.setSpeed(1.25f);
                  speed = "1.25";
                  txt3.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt2.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt1.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt4.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt5.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                }
              });

      findViewById(R.id.cardview4)
          .setOnClickListener(
              new OnClickListener() {
                @Override
                public void onClick(View v) {
                  mVideoView.setSpeed(1.5f);
                  speed = "1.5";
                  txt4.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt2.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt3.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt1.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt5.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                }
              });

      findViewById(R.id.cardview5)
          .setOnClickListener(
              new OnClickListener() {
                @Override
                public void onClick(View v) {
                  mVideoView.setSpeed(2.0f);
                  speed = "2.0";
                  txt5.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt2.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt3.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt4.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt1.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                }
              });
    }
  }

  public class CustomDrawerPopupView1 extends DrawerPopupView {
    public CustomDrawerPopupView1(@NonNull Context context) {
      super(context);
    }

    @Override
    protected int getImplLayoutId() {
      return R.layout.proportion;
    }

    @Override
    protected void onCreate() {
      super.onCreate();

      final TextView txt1 = findViewById(R.id.textview1);
      final TextView txt2 = findViewById(R.id.textview2);
      final TextView txt3 = findViewById(R.id.textview3);
      final TextView txt4 = findViewById(R.id.textview4);
      final TextView txt5 = findViewById(R.id.textview5);

      if (proportion.equals("default")) {
        txt1.setTextColor(
            MaterialColors.getColor(VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
      }
      if (proportion.equals("16:9")) {
        txt2.setTextColor(
            MaterialColors.getColor(VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
      }
      if (proportion.equals("Original size")) {
        txt3.setTextColor(
            MaterialColors.getColor(VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
      }
      if (proportion.equals("filling")) {
        txt4.setTextColor(
            MaterialColors.getColor(VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
      }
      if (proportion.equals("center crop")) {
        txt5.setTextColor(
            MaterialColors.getColor(VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
      }

      findViewById(R.id.cardview1)
          .setOnClickListener(
              new OnClickListener() {
                @Override
                public void onClick(View v) {
                  mVideoView.setScreenScaleType(VideoView.SCREEN_SCALE_DEFAULT);
                  proportion = "default";
                  txt1.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt2.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt3.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt4.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt5.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                }
              });

      findViewById(R.id.cardview2)
          .setOnClickListener(
              new OnClickListener() {
                @Override
                public void onClick(View v) {
                  mVideoView.setScreenScaleType(VideoView.SCREEN_SCALE_16_9);
                  proportion = "16:9";
                  txt2.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt1.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt3.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt4.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt5.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                }
              });

      findViewById(R.id.cardview3)
          .setOnClickListener(
              new OnClickListener() {
                @Override
                public void onClick(View v) {
                  mVideoView.setScreenScaleType(VideoView.SCREEN_SCALE_ORIGINAL);
                  proportion = "Original size";
                  txt3.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt2.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt1.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt4.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt5.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                }
              });

      findViewById(R.id.cardview4)
          .setOnClickListener(
              new OnClickListener() {
                @Override
                public void onClick(View v) {
                  mVideoView.setScreenScaleType(VideoView.SCREEN_SCALE_MATCH_PARENT);
                  proportion = "filling";
                  txt4.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt2.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt3.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt1.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt5.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                }
              });

      findViewById(R.id.cardview5)
          .setOnClickListener(
              new OnClickListener() {
                @Override
                public void onClick(View v) {
                  mVideoView.setScreenScaleType(VideoView.SCREEN_SCALE_CENTER_CROP);
                  proportion = "center crop";
                  txt5.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt2.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt3.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt4.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                  txt1.setTextColor(
                      MaterialColors.getColor(
                          VideoViewsActivity.this, ObjectUtils.colorOnSurface, 0));
                }
              });
    }
  }
}
