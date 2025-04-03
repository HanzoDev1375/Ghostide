package ir.ninjacoder.ghostide.tasks;

import android.content.SharedPreferences;
import android.content.Context;
import androidx.security.crypto.MasterKeys;
import androidx.security.crypto.EncryptedSharedPreferences;

public class SecurePrefs {
  private SharedPreferences sharedPreferences;

  public SecurePrefs(Context context) {
    try {
      String masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
      sharedPreferences =
          EncryptedSharedPreferences.create(
              "github_auth_prefs",
              masterKeyAlias,
              context,
              EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
              EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
    } catch (Exception e) {
      e.printStackTrace();
      // Fallback to regular SharedPreferences if encryption fails
      sharedPreferences = context.getSharedPreferences("github_auth_prefs", Context.MODE_PRIVATE);
    }
  }

  public void saveToken(String token) {
    sharedPreferences.edit().putString("github_token", token).apply();
  }

  public String getToken() {
    return sharedPreferences.getString("github_token", null);
  }

  public void saveUserInfo(String username, String avatarUrl, String name) {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("username", username);
    editor.putString("avatar_url", avatarUrl);
    editor.putString("name", name);
    editor.apply();
  }

  public String getUsername() {
    return sharedPreferences.getString("username", "");
  }

  public String getAvatarUrl() {
    return sharedPreferences.getString("avatar_url", "");
  }

  public String getName() {
    return sharedPreferences.getString("name", "");
  }

  public void clear() {
    sharedPreferences.edit().clear().apply();
  }
}
