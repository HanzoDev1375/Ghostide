package ir.ninjacoder.ghostide.core.git;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ir.ninjacoder.ghostide.core.tasks.SecurePrefs;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GithubStarView {

  private final OkHttpClient client;
  private final Gson gson;
  private final SecurePrefs securePrefs;

  public GithubStarView(Context context) {
    this.client = new OkHttpClient();
    this.gson = new Gson();
    this.securePrefs = new SecurePrefs(context);
  }

  public static class StarredRepo {
    public String name;
    public String full_name;
    public String description;
    public int stargazers_count;
    public int forks_count;
    public String language;
    public String html_url;
    public Owner owner;

    public static class Owner {
      public String login;
      public String avatar_url;
    }
  }

  public List<StarredRepo> getStarredRepos() throws IOException {
    String token = securePrefs.getToken();

    if (token != null && !token.isEmpty()) {
      return getUserStarredRepos(token);
    }

    String username = securePrefs.getUsername();
    String targetUser = (username != null && !username.isEmpty()) ? username : "";
    return getStarredReposByUsername(targetUser);
  }

  private List<StarredRepo> getUserStarredRepos(String token) throws IOException {
    String url = "https://api.github.com/user/starred?per_page=15";
    Request request =
        new Request.Builder().url(url).header("Authorization", "token " + token).build();

    try (Response response = client.newCall(request).execute()) {
      if (response.isSuccessful() && response.body() != null) {
        String json = response.body().string();
        Type listType = new TypeToken<ArrayList<StarredRepo>>() {}.getType();
        return gson.fromJson(json, listType);
      }
      throw new IOException("HTTP " + response.code());
    }
  }

  private List<StarredRepo> getStarredReposByUsername(String username) throws IOException {
    String url = "https://api.github.com/users/" + username + "/starred?per_page=15";
    Request request = new Request.Builder().url(url).build();

    try (Response response = client.newCall(request).execute()) {
      if (response.isSuccessful() && response.body() != null) {
        String json = response.body().string();
        Type listType = new TypeToken<ArrayList<StarredRepo>>() {}.getType();
        return gson.fromJson(json, listType);
      }
      throw new IOException("HTTP " + response.code());
    }
  }
}
