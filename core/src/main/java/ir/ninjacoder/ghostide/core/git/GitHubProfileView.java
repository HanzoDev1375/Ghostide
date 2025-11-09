package ir.ninjacoder.ghostide.core.git;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.ThreadUtils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONObject;

import java.io.IOException;

import ir.ninjacoder.ghostide.core.tasks.SecurePrefs;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GitHubProfileView {
  private Context context;
  private SecurePrefs securePrefs;
  private OkHttpClient client;

  public GitHubProfileView(Context context) {
    this.context = context;
    this.securePrefs = new SecurePrefs(context);
    this.client = new OkHttpClient();
  }

  public void verifyToken(String token) {
    Request request =
        new Request.Builder()
            .url("https://api.github.com/user")
            .header("Authorization", "token " + token)
            .build();

    client
        .newCall(request)
        .enqueue(
            new Callback() {
              @Override
              public void onFailure(@NonNull Call call, @NonNull IOException e) {
                ThreadUtils.runOnUiThread(
                    () ->
                        Toast.makeText(
                                context, "Network error: " + e.getMessage(), Toast.LENGTH_SHORT)
                            .show());
              }

              @Override
              public void onResponse(@NonNull Call call, @NonNull Response response)
                  throws IOException {
                if (response.isSuccessful()) {
                  try {
                    String responseBody = response.body().string();
                    JSONObject userJson = new JSONObject(responseBody);

                    String username = userJson.getString("login");
                    String avatarUrl = userJson.getString("avatar_url");
                    String name = userJson.optString("name", username);
                    String bio = userJson.optString("bio", "user not bio sorry!");
                    int followers = userJson.optInt("followers", 0);
                    int following = userJson.optInt("following", 0);
                    String type = userJson.optString("type", "User");

                    securePrefs.saveToken(token);
                    securePrefs.saveUserInfo(
                        username, avatarUrl, name, bio, followers, following, type);

                    // بررسی ستاره دادن کاربر به مخزن
                    checkIfUserStarredRepo(token, username);

                  } catch (Exception e) {
                    ThreadUtils.runOnUiThread(
                        () ->
                            Toast.makeText(context, "Error parsing response", Toast.LENGTH_SHORT)
                                .show());
                  }
                } else {
                  ThreadUtils.runOnUiThread(
                      () -> Toast.makeText(context, "Invalid token", Toast.LENGTH_SHORT).show());
                }
              }
            });
  }

  private void checkIfUserStarredRepo(String token, String username) {
    Request request =
        new Request.Builder()
            .url("https://api.github.com/user/starred/HanzoDev1375/Ghostide")
            .header("Authorization", "token " + token)
            .build();

    client
        .newCall(request)
        .enqueue(
            new Callback() {
              @Override
              public void onFailure(@NonNull Call call, @NonNull IOException e) {
                // در صورت خطا، می‌توانید اینجا تصمیم بگیرید که چه کاری انجام دهید
              }

              @Override
              public void onResponse(@NonNull Call call, @NonNull Response response)
                  throws IOException {
                if (response.code() == 204) {
                  // کد 204 یعنی کاربر ستاره داده است
                  securePrefs.setHasStarredRepo(true);
                } else if (response.code() == 404) {
                  // کد 404 یعنی کاربر ستاره نداده است
                  securePrefs.setHasStarredRepo(false);
                  showStarDialogOnce();
                }
              }
            });
  }

  private void showStarDialogOnce() {
    if (!securePrefs.hasShownStarDialog()) {
      ThreadUtils.runOnUiThread(
          () -> {
            new MaterialAlertDialogBuilder(context)
                .setTitle("Please support the project.")
                .setMessage(
                    "If you enjoy Ghostide, please support us by giving the repository a star on GitHub!")
                .setPositiveButton(
                    "go to github",
                    (dialog, which) -> {
                      try {
                        Intent browserIntent =
                            new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/HanzoDev1375/Ghostide"));
                        context.startActivity(browserIntent);
                      } catch (Exception e) {
                        Toast.makeText(context, "Error opening browser", Toast.LENGTH_SHORT).show();
                      }
                    })
                .setNegativeButton("no", null)
                .setOnDismissListener(dialog -> securePrefs.setHasShownStarDialog(true))
                .show();
          });
    }
  }

  public void logout() {
    securePrefs.clear();
  }

  public String getBio() {
    return securePrefs.getBio();
  }

  public int getFollowers() {
    return securePrefs.getFollowers();
  }

  public int getFollowing() {
    return securePrefs.getFollowing();
  }

  public String getType() {
    return securePrefs.getType();
  }

  public boolean hasBio() {
    return securePrefs.hasBio();
  }

  public boolean hasFollowers() {
    return securePrefs.hasFollowers();
  }

  public boolean hasFollowing() {
    return securePrefs.hasFollowing();
  }

  public boolean hasAvatarUrl() {
    return securePrefs.hasAvatarUrl();
  }

  public boolean hasName() {
    return securePrefs.hasName();
  }

  public boolean hasUsername() {
    return securePrefs.hasUsername();
  }

  public String getUsername() {
    return securePrefs.getUsername();
  }

  public String getAvatarUrl() {
    return securePrefs.getAvatarUrl();
  }

  public String getName() {
    return securePrefs.getName();
  }
}
