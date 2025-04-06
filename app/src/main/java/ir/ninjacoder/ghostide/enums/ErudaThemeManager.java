package ir.ninjacoder.ghostide.enums;

import android.content.Context;
import android.content.SharedPreferences;

public class ErudaThemeManager {
    public static final String PREF_NAME = "AppPreferences";
    public static final String KEY_THEME = "eruda_theme";
    
    public static void saveTheme(Context context, ErudaThemes theme) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        prefs.edit().putString(KEY_THEME, theme.getThemeName()).apply();
    }
    
    public static ErudaThemes getCurrentTheme(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String themeName = prefs.getString(KEY_THEME, ErudaThemes.DARK.getThemeName());
        return ErudaThemes.fromString(themeName);
    }
}