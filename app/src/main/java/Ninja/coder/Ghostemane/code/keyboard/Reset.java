package Ninja.coder.Ghostemane.code.keyboard;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.activities.BaseCompat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import androidx.preference.PreferenceFragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceGroup;
import androidx.preference.EditTextPreference;

public class Reset extends BaseCompat {

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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit().clear().commit();
    getFragmentManager().beginTransaction().replace(16908290, new SettingsFragment()).commit();
    Toast.makeText(getBaseContext(), "بازنشانی تنظیمات انجام شد", 0).show();
    restart(getBaseContext());
  }

  public static class SettingsFragment extends PreferenceFragment
      implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreatePreferences(Bundle arg0, String arg1) {
      // TODO: Implement this method
    }

    @Override
    public void onCreate(Bundle bundle) {
      super.onCreate(bundle);
      addPreferencesFromResource(R.xml.setting);
      initSummary(getPreferenceScreen());
    }

    @Override
    public void onResume() {
      super.onResume();
      getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
      super.onPause();
      getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    private void initSummary(Preference preference) {
      if (preference instanceof PreferenceGroup) {
        PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
        for (int i = 0; i < preferenceGroup.getPreferenceCount(); i++) {
          initSummary(preferenceGroup.getPreference(i));
        }
        return;
      }
      updatePrefSummary(preference);
    }

    private void updatePrefSummary(Preference preference) {
      if (preference instanceof EditTextPreference) {
        preference.setSummary(((EditTextPreference) preference).getText());
      }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
      updatePrefSummary(findPreference(str));
    }
  }
}
