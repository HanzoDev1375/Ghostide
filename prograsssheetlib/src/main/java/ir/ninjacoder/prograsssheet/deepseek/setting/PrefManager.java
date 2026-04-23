package ir.ninjacoder.prograsssheet.deepseek.setting;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class PrefManager {
  private static final String PREF_NAME = "deepseek_prefs";
  private static final String KEY_API_KEY = "api_key";
  private static final String KEY_MODEL_MODE = "model_mode"; // fast/expert
  private static final String KEY_STREAM_ENABLED = "stream_enabled";

  private SharedPreferences sharedPreferences;
  private static PrefManager instance;

  private PrefManager(Context context) {
    try {
      String masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
      sharedPreferences =
          EncryptedSharedPreferences.create(
              PREF_NAME,
              masterKeyAlias,
              context,
              EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
              EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
    } catch (GeneralSecurityException | IOException e) {
      sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
  }

  public static synchronized PrefManager getInstance(Context context) {
    if (instance == null) {
      instance = new PrefManager(context.getApplicationContext());
    }
    return instance;
  }

  public void saveApiKey(String apiKey) {
    sharedPreferences.edit().putString(KEY_API_KEY, apiKey).apply();
  }

  public String getApiKey() {
    return sharedPreferences.getString(KEY_API_KEY, "");
  }

  public void saveModelMode(boolean isExpert) {
    sharedPreferences.edit().putBoolean(KEY_MODEL_MODE, isExpert).apply();
  }

  public boolean isExpertMode() {
    return sharedPreferences.getBoolean(KEY_MODEL_MODE, false);
  }

  public void saveStreamEnabled(boolean enabled) {
    sharedPreferences.edit().putBoolean(KEY_STREAM_ENABLED, enabled).apply();
  }

  public boolean isStreamEnabled() {
    return sharedPreferences.getBoolean(KEY_STREAM_ENABLED, true);
  }

  public boolean hasApiKey() {
    String key = getApiKey();
    return key != null && !key.isEmpty();
  }
}
