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
  private ImageView iconLoader;
  private TextView title, subtitle;
  private SecurePrefs securePrefs;
  private OkHttpClient client;
  private LayoutSheetEditText edit;

  public GitHubProfileView(
      Context context, ImageView iconLoader, TextView title, TextView subtitle) {
    this.context = context;
    this.iconLoader = iconLoader;
    this.title = title;
    this.subtitle = subtitle;
    this.securePrefs = new SecurePrefs(context);
    this.client = new OkHttpClient();
    if (securePrefs.getToken() != null) {
      showUserInfo();
    } else {
      showLoginDialog();
    }
  }

  private void showLoginDialog() {
    edit = new LayoutSheetEditText(context);
    edit.setTitle("Enter GitHub Token");
    edit.setokClick(
        v -> {
          if (!edit.isEmptyText()) {
            verifyToken(edit.getText().toString());
          } else {
            Toast.makeText(context, "Please enter your token", Toast.LENGTH_SHORT).show();
          }
        });
  }

  public void show() {
    edit.show();
  }

  private void verifyToken(String token) {
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

                    // ذخیره اطلاعات
                    securePrefs.saveToken(token);
                    securePrefs.saveUserInfo(username, avatarUrl, name);

                    ThreadUtils.runOnUiThread(
                        () -> {
                          showUserInfo();
                          Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show();
                          if (edit != null) {
                            edit.dismiss();
                          }
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

  private void showUserInfo() {
    String username = securePrefs.getUsername();
    String name = securePrefs.getName();
    String avatarUrl = securePrefs.getAvatarUrl();

    if (username != null && !username.isEmpty()) {
      title.setText(username);
    }

    if (name != null && !name.isEmpty()) {
      subtitle.setText(name);
    }

    if (avatarUrl != null && !avatarUrl.isEmpty()) {
      Glide.with(context)
          .load(avatarUrl)
          .circleCrop()
          .placeholder(R.drawable.app_icon)
          .into(iconLoader);
    }
  }

  public void logout() {
    securePrefs.clear();
    title.setText("");
    subtitle.setText("");
    iconLoader.setImageResource(R.drawable.app_icon);
    showLoginDialog();
  }
}
