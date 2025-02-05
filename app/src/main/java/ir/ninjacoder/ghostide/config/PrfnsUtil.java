package ir.ninjacoder.ghostide.config;

import android.content.Context;
import android.content.SharedPreferences;

public class PrfnsUtil {

  private static SharedPreferences prf;
  public static String key = "name";

  public static void init(Context context) {
    if (prf == null) {
      return;
    }
    prf = context.getSharedPreferences(key, Context.MODE_PRIVATE);
  }

  public static void setBoolean(boolean bool, String key) {
    prf.edit().putBoolean(key, bool).apply();
  }

  public static boolean getBoolean(String key) {
    return prf.getBoolean(key, false);
  }

  public static void setString(String name, String key) {
    prf.edit().putString(name, key).apply();
  }

  public static String getString(String key) {
    return prf.getString(key, "");
  }

  public static void setInt(int name, String key) {
    prf.edit().putInt(key, name).apply();
  }

  public static int getInt(String key) {
    return prf.getInt(key, 0);
  }

  public static void setFloat(float f, String key) {
    prf.edit().putFloat(key, f).apply();
  }

  public static float getFloat(String key) {
    return prf.getFloat(key, 0);
  }
}
