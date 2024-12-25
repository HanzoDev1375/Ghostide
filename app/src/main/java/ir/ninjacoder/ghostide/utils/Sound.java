package ir.ninjacoder.ghostide.utils;

import ir.ninjacoder.ghostide.R;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.view.KeyEvent;

public class Sound {
  private SoundPool soundPool;
  private int spaceSoundId, cleanSoundId, otherSoundId;

  public Sound(Context context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      AudioAttributes audioAttributes =
          new AudioAttributes.Builder()
              .setUsage(AudioAttributes.USAGE_GAME)
              .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
              .build();
      soundPool =
          new SoundPool.Builder().setMaxStreams(3).setAudioAttributes(audioAttributes).build();
    } else {
      soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    }

    spaceSoundId = soundPool.load(context, R.raw.typespace, 1);
    cleanSoundId = soundPool.load(context, R.raw.typeremoved, 1);
    otherSoundId = soundPool.load(context, R.raw.typenormal, 1);
  }

  public boolean onKeyDown(int keyCode) {
    switch (keyCode) {
      case KeyEvent.KEYCODE_SPACE:
        soundPool.play(spaceSoundId, 1, 1, 0, 0, 1);
        return true;
      case KeyEvent.KEYCODE_DEL:
        soundPool.play(cleanSoundId, 1, 1, 0, 0, 1);
        return true;
      default:
        soundPool.play(otherSoundId, 1, 1, 0, 0, 1);
        return false;
    }
  }
}
