package ir.ninjacoder.ghostide.enums;

import android.content.Context;
import android.content.SharedPreferences;
import io.github.rosemoe.sora.widget.power.PowerModeEffectManager;

public class EffectTypeManager {
  public static final String PREF_NAME = "AppPreferences";
  public static final String KEY_THEME = "ef";

  public static void saveTheme(Context context, PowerModeEffectManager.EffectType theme) {
    SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    prefs.edit().putString(KEY_THEME, theme.getType()).apply();
  }

  public static PowerModeEffectManager.EffectType getCurrentTheme(Context context) {
    SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    String themeName = prefs.getString(KEY_THEME, PowerModeEffectManager.EffectType.NONE.getType());
    return PowerModeEffectManager.EffectType.fromString(themeName);
  }
}
