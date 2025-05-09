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

  public void saveUserInfo(
      String username,
      String avatarUrl,
      String name,
      String bio,
      int followers,
      int following,
      String type) {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("username", username);
    editor.putString("avatar_url", avatarUrl);
    editor.putString("name", name);
    editor.putString("bio", bio);
    editor.putInt("followers", followers);
    editor.putInt("following", following);
    editor.putString("type", type);
    editor.apply();
  }

  public String getBio() {
    return sharedPreferences.getString("bio", "");
  }

  public int getFollowers() {
    return sharedPreferences.getInt("followers", 0);
  }

  public boolean hasBio() {
    return sharedPreferences.contains("bio");
  }

  public boolean hasFollowers() {
    return sharedPreferences.contains("followers");
  }

  public boolean hasFollowing() {
    return sharedPreferences.contains("following");
  }

  public boolean hasAvatarUrl() {
    return sharedPreferences.contains("avatar_url");
  }

  public boolean hasName() {
    return sharedPreferences.contains("name");
  }

  public boolean hasUsername() {
    return sharedPreferences.contains("username");
  }

  public int getFollowing() {
    return sharedPreferences.getInt("following", 0);
  }

  public String getType() {
    return sharedPreferences.getString("type", "");
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

  public void setHasStarredRepo(boolean hasStarred) {
    sharedPreferences.edit().putBoolean("has_starred_repo", hasStarred).apply();
  }

  public boolean hasStarredRepo() {
    return sharedPreferences.getBoolean("has_starred_repo", false);
  }

  public void setHasShownStarDialog(boolean hasShown) {
    sharedPreferences.edit().putBoolean("has_shown_star_dialog", hasShown).apply();
  }

  public boolean hasShownStarDialog() {
    return sharedPreferences.getBoolean("has_shown_star_dialog", false);
  }
}
