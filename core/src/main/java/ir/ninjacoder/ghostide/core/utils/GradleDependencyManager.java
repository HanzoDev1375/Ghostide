package ir.ninjacoder.ghostide.core.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GradleDependencyManager {

  private Context context;
  private DependencyUpdateListener listener;
  private String gradleFileContent;
  private List<DependencyUpdate> availableUpdates = new ArrayList<>();

  public GradleDependencyManager(Context context, String gradleFileContent) {
    this.context = context;
    this.gradleFileContent = gradleFileContent;
  }

  public void setCallBack(DependencyUpdateListener listener) {
    this.listener = listener;
  }

  public void checkAllDependencies() {
    availableUpdates.clear();
    List<Dependency> dependencies = extractDependencies(gradleFileContent);
    for (Dependency dep : dependencies) {
      checkDependencyUpdate(dep);
    }
  }

  private List<Dependency> extractDependencies(String content) {
    List<Dependency> deps = new ArrayList<>();
    // الگوی بهبود یافته برای پوشش همه حالات:
    Pattern pattern =
        Pattern.compile(
            "(implementation|api|compile)\\s*(?:\\(?['\"]([^:]+):([^:]+):([^)'\"]+)['\"]\\)?)");
    Matcher matcher = pattern.matcher(content);

    while (matcher.find()) {
      Dependency dep = new Dependency();
      dep.type = matcher.group(1);
      dep.group = matcher.group(2);
      dep.artifact = matcher.group(3);
      dep.version = matcher.group(4);
      dep.fullMatch = matcher.group(0);
      dep.startPos = matcher.start();
      deps.add(dep);
    }
    return deps;
  }

  private void checkDependencyUpdate(Dependency dep) {
    new Thread(
            () -> {
              try {
                String latestVersion = getLatestVersion(dep.group, dep.artifact);
                if (latestVersion == null) {
                  new Handler(Looper.getMainLooper())
                      .post(() -> listener.onError(dep.artifact + ": Failed to get version"));
                  return;
                }

                if (!dep.version.equals(latestVersion)) {
                  synchronized (availableUpdates) {
                    availableUpdates.add(new DependencyUpdate(dep, latestVersion));
                    if (availableUpdates.size() == 1) {
                      // اولین به‌روزرسانی پیدا شده، تایمر را شروع کن
                      new Handler(Looper.getMainLooper())
                          .postDelayed(this::showBulkUpdateDialog, 500);
                    }
                  }
                } else {
                  new Handler(Looper.getMainLooper())
                      .post(() -> listener.onUpToDate(dep.artifact, dep.version));
                }
              } catch (Exception e) {
                new Handler(Looper.getMainLooper())
                    .post(() -> listener.onError(dep.artifact + ": " + e.getMessage()));
              }
            })
        .start();
  }

  private void showBulkUpdateDialog() {
    synchronized (availableUpdates) {
      if (availableUpdates.isEmpty()) {
        return;
      }

      // آماده‌سازی آرایه‌های مورد نیاز
      CharSequence[] items = new CharSequence[availableUpdates.size()];
      boolean[] checkedItems = new boolean[availableUpdates.size()];
      boolean[] isUpToDate = new boolean[availableUpdates.size()];

      for (int i = 0; i < availableUpdates.size(); i++) {
        DependencyUpdate update = availableUpdates.get(i);
        items[i] =
            String.format(
                "%s:%s (%s → %s)",
                update.dep.group, update.dep.artifact, update.dep.version, update.newVersion);
        checkedItems[i] = true;
        isUpToDate[i] = false;
      }

      new Handler(Looper.getMainLooper())
          .post(
              () -> {
                MaterialAlertDialogBuilder dialogBuilder =
                    new MaterialAlertDialogBuilder(context)
                        .setTitle("به‌روزرسانی کتابخانه‌ها (" + availableUpdates.size() + ")")
                        .setMultiChoiceItems(
                            items,
                            checkedItems,
                            (dialog, which, isChecked) -> {
                              if (!isUpToDate[which]) {
                                checkedItems[which] = isChecked;
                              }
                            })
                        .setPositiveButton(
                            "به‌روزرسانی انتخاب‌شده‌ها",
                            (d, which) -> {
                              applySelectedUpdates(checkedItems);
                            })
                        .setNegativeButton("لغو", null)
                        .setNeutralButton(
                            "انتخاب همه",
                            (d, which) -> {
                              // اعمال انتخاب همه و بستن دیالوگ
                              Arrays.fill(checkedItems, true);
                              applySelectedUpdates(checkedItems);
                            });

                var dialog = dialogBuilder.create();
                dialog.show();

                // غیرفعال کردن آیتم‌هایی که به‌روز هستند
                var listView = dialog.getListView();
                if (listView != null) {
                  for (int i = 0; i < isUpToDate.length; i++) {
                    if (isUpToDate[i]) {
                      listView.setItemChecked(i, false);
                      listView.setEnabled(false);
                    }
                  }
                }
              });
    }
  }

  private void applySelectedUpdates(boolean[] checkedItems) {
    synchronized (availableUpdates) {
      List<DependencyUpdate> updatesToApply = new ArrayList<>();

      for (int i = 0; i < checkedItems.length; i++) {
        if (checkedItems[i]) {
          updatesToApply.add(availableUpdates.get(i));
        }
      }

      if (!updatesToApply.isEmpty()) {
        for (DependencyUpdate update : updatesToApply) {
          String newDependency =
              update.dep.fullMatch.replace(
                  ":" + update.dep.version + (update.dep.fullMatch.endsWith("'") ? "'" : "\""),
                  ":" + update.newVersion + (update.dep.fullMatch.endsWith("'") ? "'" : "\""));

          gradleFileContent = gradleFileContent.replace(update.dep.fullMatch, newDependency);
        }
        listener.onBulkUpdateSuccess(gradleFileContent);
      }

      availableUpdates.clear();
    }
  }

  private void showIndividualUpdateDialogs() {
    synchronized (availableUpdates) {
      List<DependencyUpdate> updates = new ArrayList<>(availableUpdates);
      availableUpdates.clear();

      for (DependencyUpdate update : updates) {
        showSingleUpdateDialog(update);
      }
    }
  }

  private void showSingleUpdateDialog(DependencyUpdate update) {
    new Handler(Looper.getMainLooper())
        .post(
            () -> {
              var dialog =
                  new MaterialAlertDialogBuilder(context)
                      .setTitle("به‌روزرسانی موجود")
                      .setMessage(
                          String.format(
                              "%s:%s\nنسخه فعلی: %s\nنسخه جدید: %s",
                              update.dep.group,
                              update.dep.artifact,
                              update.dep.version,
                              update.newVersion))
                      .setPositiveButton(
                          "به‌روزرسانی",
                          (d, which) -> {
                            updateDependency(update.dep, update.newVersion);
                          })
                      .setNegativeButton("رد", null)
                      .create();
              dialog.show();
            });
  }

  private void updateDependency(Dependency dep, String newVersion) {
    String newDependency;
    if (dep.fullMatch.contains("(")) {
      newDependency =
          dep.fullMatch.replace(
              ":" + dep.version + (dep.fullMatch.contains("'") ? "'" : "\""),
              ":" + newVersion + (dep.fullMatch.contains("'") ? "'" : "\""));
    } else {
      
      newDependency =
          dep.fullMatch.replace(
              ":" + dep.version + (dep.fullMatch.endsWith("'") ? "'" : "\""),
              ":" + newVersion + (dep.fullMatch.endsWith("'") ? "'" : "\""));
    }

    gradleFileContent = gradleFileContent.replace(dep.fullMatch, newDependency);
    listener.onUpdateSuccess(dep.artifact, newVersion, gradleFileContent);
  }

  private String getLatestVersion(String group, String artifact) throws Exception {
    String url =
        String.format(
            "https://search.maven.org/solrsearch/select?q=g:%s+AND+a:%s&rows=1&wt=json",
            group, artifact);

    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
    conn.setRequestMethod("GET");

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
      StringBuilder response = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        response.append(line);
      }

      JSONObject json = new JSONObject(response.toString());
      return json.getJSONObject("response")
          .getJSONArray("docs")
          .getJSONObject(0)
          .getString("latestVersion");
    }
  }

  public static class Dependency {
    String type;
    String group;
    String artifact;
    String version;
    String fullMatch;
    int startPos;
  }

  private static class DependencyUpdate {
    Dependency dep;
    String newVersion;

    DependencyUpdate(Dependency dep, String newVersion) {
      this.dep = dep;
      this.newVersion = newVersion;
    }
  }

  public interface DependencyUpdateListener {
    void onUpToDate(String artifact, String currentVersion);

    void onUpdateSuccess(String artifact, String newVersion, String updatedGradleContent);

    void onBulkUpdateSuccess(String updatedGradleContent);

    void onError(String message);
  }
}
