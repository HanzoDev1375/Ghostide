package ir.ninjacoder.ghostide.git;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.ThreadUtils;
import com.bumptech.glide.Glide;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.ghostide.tasks.SecurePrefs;
import ir.ninjacoder.prograsssheet.LayoutSheetEditText;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONObject;
import ir.ninjacoder.ghostide.R;

public class GitHubProfileView {
  private Context context;
  private SecurePrefs securePrefs;
  private OkHttpClient client;

  public GitHubProfileView(Context context) {
    this.context = context;
    this.securePrefs = new SecurePrefs(context);
    this.client = new OkHttpClient();
  }

  private void showLoginDialog() {
    //    edit = new LayoutSheetEditText(context);
    //    edit.setTitle("Enter GitHub Token");
    //    edit.setokClick(
    //        v -> {
    //          if (!edit.isEmptyText()) {
    //            verifyToken(edit.getText().toString());
    //          } else {
    //            Toast.makeText(context, "Please enter your token", Toast.LENGTH_SHORT).show();
    //          }
    //        });
  }

  public void show() {
    ///  edit.show();
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

                    ThreadUtils.runOnUiThread(
                        () -> {
                          // showUserInfo();
                          Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                        });
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

  //
  //  private void showUserInfo() {
  //    String username = securePrefs.getUsername();
  //    String name = securePrefs.getName();
  //    String avatarUrl = securePrefs.getAvatarUrl();
  //
  //    if (username != null && !username.isEmpty()) {
  //      title.setText(hasUsername() ? username : context.getString(R.string.app_name));
  //    }
  //
  //    if (name != null && !name.isEmpty()) {
  //      subtitle.setText(hasName() ? name : context.getString(R.string.app_name));
  //    }
  //
  //    if (avatarUrl != null && !avatarUrl.isEmpty()) {
  //      Glide.with(context)
  //          .load(hasAvatarUrl() ? avatarUrl : R.drawable.app_icon)
  //          .circleCrop()
  //          .error(R.drawable.app_icon)
  //          .placeholder(R.drawable.app_icon)
  //          .into(iconLoader);
  //    }
  //  }

  public void logout() {
    securePrefs.clear();
    ////    title.setText("");
    ////    subtitle.setText("");
    ////    iconLoader.setImageResource(R.drawable.app_icon);
    // showLoginDialog();
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
