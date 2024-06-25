package Ninja.coder.Ghostemane.code.keyboard;

import Ninja.coder.Ghostemane.code.activities.BaseCompat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.preference.PreferenceManager;

public class Save extends BaseCompat {
  public static boolean restart(Context context) {
    try {
      Intent i = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      context.startActivity(i);

      return true;
    } catch (Exception ignored) {
      return false;
    }
  }

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
   // PreferenceManager.getDefaultSharedPreferences(this).edit().apply();
    PreferenceManager.getDefaultSharedPreferences(this).edit().apply();
    Toast.makeText(getBaseContext(), "تغییرات با موفقیت ذخیره شدند", 0).show();
    restart(getBaseContext());
  }
}
