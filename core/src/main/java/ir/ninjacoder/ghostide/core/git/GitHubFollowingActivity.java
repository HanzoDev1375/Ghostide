package ir.ninjacoder.ghostide.core.git;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.ThreadUtils;
import ir.ninjacoder.ghostide.core.tasks.SecurePrefs;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GitHubFollowingActivity {
  private Context context;
  private SecurePrefs securePrefs;
  private OkHttpClient client;

  public GitHubFollowingActivity(Context context) {
    this.context = context;
    this.securePrefs = new SecurePrefs(context);
    this.client = new OkHttpClient();
  }

  // مدل برای رویداد
  public static class ActivityEvent {
    public String username;
    public String avatarUrl;
    public String type;
    public String repoName;
    public String repoFullName;
    public String time;
    public String description;
  }

  // مدل برای فالوینگ
  public static class FollowingUser {
    public String login;
    public String avatar_url;
    public String html_url;
  }

  // اینترفیس برای callback
  public interface FollowingActivitiesCallback {
    void onSuccess(List<ActivityEvent> events);

    void onError(String error);
  }

  public interface StargazersCallback {
    void onSuccess(Map<String, List<FollowingUser>> stargazersMap);

    void onError(String error);
  }

  /** دریافت فیـد فعالیت‌های کاربر */
  public void getFollowingActivities(FollowingActivitiesCallback callback) {
    String token = securePrefs.getToken();

    if (token == null || token.isEmpty()) {
      callback.onError("User not logged in");
      return;
    }

    // اول نام کاربری رو از توکن بگیر
    getUsernameFromToken(
        token,
        new UsernameCallback() {
          @Override
          public void onSuccess(String username) {
            // حالا با نام کاربری فید رو بگیر
            getCurrentUserEvents(username, token, callback);
          }

          @Override
          public void onError(String error) {
            callback.onError("Failed to get username: " + error);
          }
        });
  }

  /** گرفتن نام کاربری از توکن */
  private void getUsernameFromToken(String token, UsernameCallback callback) {
    String url = "https://api.github.com/user";

    Request request =
        new Request.Builder()
            .url(url)
            .header("Authorization", "token " + token)
            .header("User-Agent", "GhostIDE-App")
            .header("Accept", "application/vnd.github.v3+json")
            .build();

    client
        .newCall(request)
        .enqueue(
            new Callback() {
              @Override
              public void onFailure(@NonNull Call call, @NonNull IOException e) {
                ThreadUtils.runOnUiThread(
                    () -> callback.onError("Network error: " + e.getMessage()));
              }

              @Override
              public void onResponse(@NonNull Call call, @NonNull Response response) {
                try {
                  if (!response.isSuccessful()) {
                    callback.onError("HTTP " + response.code());
                    return;
                  }

                  String responseBody = response.body().string();
                  JSONObject userJson = new JSONObject(responseBody);
                  String username = userJson.getString("login");

                  ThreadUtils.runOnUiThread(() -> callback.onSuccess(username));

                } catch (Exception e) {
                  ThreadUtils.runOnUiThread(() -> callback.onError("Error: " + e.getMessage()));
                } finally {
                  if (response.body() != null) {
                    response.body().close();
                  }
                }
              }
            });
  }

  /** دریافت رویدادهای فیـد کاربر جاری */
  private void getCurrentUserEvents(
      String username, String token, FollowingActivitiesCallback callback) {
    String url = "https://api.github.com/users/" + username + "/received_events?per_page=30";

    Log.d("GitHubAPI", "Getting events for user: " + username);

    Request request =
        new Request.Builder()
            .url(url)
            .header("Authorization", "token " + token)
            .header("User-Agent", "GhostIDE-App")
            .header("Accept", "application/vnd.github.v3+json")
            .build();

    client
        .newCall(request)
        .enqueue(
            new Callback() {
              @Override
              public void onFailure(@NonNull Call call, @NonNull IOException e) {
                ThreadUtils.runOnUiThread(
                    () -> callback.onError("Network error: " + e.getMessage()));
              }

              @Override
              public void onResponse(@NonNull Call call, @NonNull Response response) {
                try {
                  if (!response.isSuccessful()) {
                    String errorMsg = "HTTP " + response.code();
                    if (response.code() == 401) {
                      errorMsg = "Invalid token";
                    } else if (response.code() == 403) {
                      errorMsg = "Rate limit exceeded";
                    }
                    throw new IOException(errorMsg);
                  }

                  String responseBody = response.body().string();
                  JSONArray eventsArray = new JSONArray(responseBody);
                  List<ActivityEvent> allEvents = new ArrayList<>();

                  for (int i = 0; i < eventsArray.length(); i++) {
                    JSONObject eventJson = eventsArray.getJSONObject(i);

                    ActivityEvent event = new ActivityEvent();

                    // actor: کسی که action را انجام داده
                    if (eventJson.has("actor")) {
                      JSONObject actor = eventJson.getJSONObject("actor");
                      event.username = actor.optString("login", "Unknown");
                      event.avatarUrl = actor.optString("avatar_url", "");
                    } else {
                      event.username = "Unknown";
                      event.avatarUrl = "";
                    }

                    event.type = eventJson.optString("type", "UnknownEvent");

                    // repo
                    if (eventJson.has("repo")) {
                      JSONObject repo = eventJson.getJSONObject("repo");
                      String repoFullName = repo.optString("name", "");
                      event.repoFullName = repoFullName;

                      // استخراج نام مخزن از full name
                      if (repoFullName.contains("/")) {
                        event.repoName = repoFullName.substring(repoFullName.lastIndexOf("/") + 1);
                      } else {
                        event.repoName = repoFullName;
                      }
                    } else {
                      event.repoName = "Unknown";
                      event.repoFullName = "Unknown";
                    }

                    event.time = eventJson.optString("created_at", "");

                    // ایجاد توضیح بر اساس نوع رویداد
                    try {
                      event.description = createEventDescription(eventJson);
                    } catch (Exception e) {
                      event.description = event.type.replace("Event", "") + " activity";
                    }

                    allEvents.add(event);
                  }

                  ThreadUtils.runOnUiThread(() -> callback.onSuccess(allEvents));

                } catch (Exception e) {
                  ThreadUtils.runOnUiThread(() -> callback.onError("Error: " + e.getMessage()));
                } finally {
                  if (response.body() != null) {
                    response.body().close();
                  }
                }
              }
            });
  }

  /** ایجاد توضیح برای رویداد */
  private String createEventDescription(JSONObject eventJson) throws Exception {
    String type = eventJson.optString("type", "");
    JSONObject payload = eventJson.optJSONObject("payload");

    switch (type) {
      case "WatchEvent":
        return "starred repository";

      case "ForkEvent":
        if (payload != null) {
          JSONObject forkee = payload.optJSONObject("forkee");
          if (forkee != null) {
            String fullName = forkee.optString("full_name");
            if (!fullName.isEmpty()) {
              return "forked to " + fullName;
            }
          }
        }
        return "forked repository";

      case "CreateEvent":
        if (payload != null) {
          String refType = payload.optString("ref_type", "repository");
          String ref = payload.optString("ref", "");
          return "created " + refType + (ref.isEmpty() ? "" : " " + ref);
        }
        return "created something";

      case "PushEvent":
        if (payload != null) {
          int commits = payload.optInt("size", 0);
          return "pushed " + commits + " commits";
        }
        return "pushed commits";

      case "IssuesEvent":
        if (payload != null) {
          String action = payload.optString("action", "updated");
          JSONObject issue = payload.optJSONObject("issue");
          if (issue != null) {
            String title = issue.optString("title", "");
            if (title.length() > 30) {
              title = title.substring(0, 30) + "...";
            }
            return action + " issue: " + title;
          }
        }
        return "issue activity";

      case "PullRequestEvent":
        if (payload != null) {
          String action = payload.optString("action", "updated");
          JSONObject pr = payload.optJSONObject("pull_request");
          if (pr != null) {
            String title = pr.optString("title", "");
            if (title.length() > 30) {
              title = title.substring(0, 30) + "...";
            }
            return action + " PR: " + title;
          }
        }
        return "pull request activity";

      case "ReleaseEvent":
        return "released new version";

      case "PublicEvent":
        return "made repository public";

      default:
        return type.replace("Event", "") + " activity";
    }
  }

  /** دریافت ستاره‌دهندگان به رپوهای کاربر */
  public void getMyRepoStargazers(StargazersCallback callback) {
    String token = securePrefs.getToken();

    if (token == null) {
      callback.onError("User not logged in");
      return;
    }

    // اول نام کاربری رو بگیر
    getUsernameFromToken(
        token,
        new UsernameCallback() {
          @Override
          public void onSuccess(String username) {
            // 1. لیست رپوهای کاربر رو بگیر
            getMyRepos(
                username,
                token,
                new MyReposCallback() {
                  @Override
                  public void onSuccess(List<String> repos) {
                    // 2. برای هر رپو، ستاره‌دهندگان رو بگیر
                    fetchRepoStargazers(username, token, repos, callback);
                  }

                  @Override
                  public void onError(String error) {
                    callback.onError(error);
                  }
                });
          }

          @Override
          public void onError(String error) {
            callback.onError("Failed to get username: " + error);
          }
        });
  }

  /** دریافت لیست رپوهای کاربر */
  private void getMyRepos(String username, String token, MyReposCallback callback) {
    String url = "https://api.github.com/users/" + username + "/repos?per_page=10";

    Request request =
        new Request.Builder()
            .url(url)
            .header("Authorization", "token " + token)
            .header("User-Agent", "GhostIDE-App")
            .header("Accept", "application/vnd.github.v3+json")
            .build();

    client
        .newCall(request)
        .enqueue(
            new Callback() {
              @Override
              public void onFailure(@NonNull Call call, @NonNull IOException e) {
                ThreadUtils.runOnUiThread(
                    () -> callback.onError("Network error: " + e.getMessage()));
              }

              @Override
              public void onResponse(@NonNull Call call, @NonNull Response response)
                  throws IOException {
                try {
                  if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    JSONArray reposArray = new JSONArray(responseBody);
                    List<String> repos = new ArrayList<>();

                    for (int i = 0; i < reposArray.length(); i++) {
                      JSONObject repoJson = reposArray.getJSONObject(i);
                      String repoName = repoJson.optString("name", "");
                      if (!repoName.isEmpty()) {
                        repos.add(repoName);
                      }
                    }

                    ThreadUtils.runOnUiThread(() -> callback.onSuccess(repos));
                  } else {
                    ThreadUtils.runOnUiThread(
                        () -> callback.onError("Failed to get repos: " + response.code()));
                  }
                } catch (Exception e) {
                  ThreadUtils.runOnUiThread(
                      () -> callback.onError("Error parsing repos: " + e.getMessage()));
                } finally {
                  if (response.body() != null) {
                    response.body().close();
                  }
                }
              }
            });
  }

  /** دریافت ستاره‌دهندگان همه رپوها */
  private void fetchRepoStargazers(
      String owner, String token, List<String> repos, StargazersCallback callback) {
    Map<String, List<FollowingUser>> stargazersMap = new HashMap<>();

    if (repos.isEmpty()) {
      ThreadUtils.runOnUiThread(() -> callback.onSuccess(stargazersMap));
      return;
    }

    AtomicInteger completedRequests = new AtomicInteger(0);
    int totalRequests = repos.size();

    for (String repo : repos) {
      fetchRepoStargazersForRepo(
          owner, token, repo, stargazersMap, callback, completedRequests, totalRequests);
    }
  }

  private void fetchRepoStargazersForRepo(
      String owner,
      String token,
      String repo,
      Map<String, List<FollowingUser>> stargazersMap,
      StargazersCallback callback,
      AtomicInteger completedRequests,
      int totalRequests) {

    String url = "https://api.github.com/repos/" + owner + "/" + repo + "/stargazers";

    Request request =
        new Request.Builder()
            .url(url)
            .header("Authorization", "token " + token)
            .header("User-Agent", "GhostIDE-App")
            .header("Accept", "application/vnd.github.v3+json")
            .build();

    client
        .newCall(request)
        .enqueue(
            new Callback() {
              @Override
              public void onFailure(@NonNull Call call, @NonNull IOException e) {
                handleCompletion();
              }

              @Override
              public void onResponse(@NonNull Call call, @NonNull Response response)
                  throws IOException {
                try {
                  if (response.isSuccessful()) {
                    String responseBody = response.body().string();
                    JSONArray stargazersArray = new JSONArray(responseBody);
                    List<FollowingUser> stargazers = new ArrayList<>();

                    for (int i = 0; i < stargazersArray.length(); i++) {
                      JSONObject userJson = stargazersArray.getJSONObject(i);
                      FollowingUser user = new FollowingUser();
                      user.login = userJson.optString("login", "");
                      user.avatar_url = userJson.optString("avatar_url", "");
                      user.html_url = userJson.optString("html_url", "");
                      if (!user.login.isEmpty()) {
                        stargazers.add(user);
                      }
                    }

                    synchronized (stargazersMap) {
                      stargazersMap.put(repo, stargazers);
                    }
                  }
                } catch (Exception e) {
                  // Skip parsing errors
                } finally {
                  if (response.body() != null) {
                    response.body().close();
                  }
                }
                handleCompletion();
              }

              private void handleCompletion() {
                int completed = completedRequests.incrementAndGet();
                if (completed == totalRequests) {
                  ThreadUtils.runOnUiThread(() -> callback.onSuccess(stargazersMap));
                }
              }
            });
  }

  // Callback interfaces
  private interface MyReposCallback {
    void onSuccess(List<String> repos);

    void onError(String error);
  }

  private interface UsernameCallback {
    void onSuccess(String username);

    void onError(String error);
  }
}
