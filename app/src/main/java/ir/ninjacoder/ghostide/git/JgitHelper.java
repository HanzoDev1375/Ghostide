package ir.ninjacoder.ghostide.git;

import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import androidx.annotation.MainThread;
import ir.ninjacoder.ghostide.tasks.AsyncTaskCompat;
import java.lang.ref.WeakReference;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.color.MaterialColors;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.util.Collections;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.lib.Repository;
import java.io.File;
import java.util.Set;
import java.util.HashSet;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class JgitHelper {
  private static final String TAG = "JgitHelper";
  private Status status;
  private boolean initialized = false;
  private File gitDir;
  private String filePath;
  private Repository repository;

  public JgitHelper(File file) {
    this.filePath = file.getAbsolutePath();

    try {
      this.gitDir = findGitDir(file);
      if (this.gitDir == null || !isValidGitRepository(gitDir)) {
        Log.w(TAG, "No valid .git directory found for: " + filePath);
        this.initialized = false;
        return;
      }

      this.repository = new FileRepositoryBuilder().setGitDir(gitDir).build();
      if (!repository.getObjectDatabase().exists()) {
        Log.w(TAG, "Invalid Git repository: " + gitDir.getAbsolutePath());
        repository.close();
        return;
      }

      try (Git git = new Git(repository)) {
        this.status = git.status().call();
        this.initialized = true;
        Log.d(TAG, "Initialized successfully for: " + filePath);
      }
    } catch (Exception e) {
      Log.e(TAG, "Error initializing repository", e);
      closeRepository();
    }
  }

  private boolean isValidGitRepository(File gitDir) {
    try {
      Repository repo = new FileRepositoryBuilder().setGitDir(gitDir).build();
      boolean isValid = repo.getObjectDatabase().exists();
      repo.close();
      return isValid;
    } catch (Exception e) {
      return false;
    }
  }

  private File findGitDir(File file) {
    if (file == null) {
      return null;
    }

    File current = file.isDirectory() ? file : file.getParentFile();
    while (current != null) {
      File gitDir = new File(current, ".git");
      if (gitDir.exists()) {
        return gitDir;
      }
      current = current.getParentFile();
    }
    return null;
  }

  private void closeRepository() {
    if (repository != null) {
      repository.close();
    }
  }

  public boolean isInitialized() {
    return initialized;
  }

  public String getModified() {
    if (!initialized || status == null || status.getModified().isEmpty()) {
      return "";
    }
    return String.join("\n", status.getModified());
  }

  public String getChanged() {
    if (!initialized || status == null || status.getChanged().isEmpty()) {
      return "";
    }
    return String.join("\n", status.getChanged());
  }

  public boolean isModified() {
    return initialized && status != null && !status.getModified().isEmpty();
  }

  public boolean isChanged() {
    return initialized && status != null && !status.getChanged().isEmpty();
  }

  public boolean isAdded() {
    return initialized && status != null && !status.getAdded().isEmpty();
  }

  public boolean isUntracked() {
    return initialized && status != null && !status.getUntracked().isEmpty();
  }

  public Set<String> getAllModified() {
    return initialized && status != null ? status.getModified() : Collections.emptySet();
  }

  public Set<String> getAllChanged() {
    return initialized && status != null ? status.getChanged() : Collections.emptySet();
  }

  public Set<String> getAllAdded() {
    return initialized && status != null ? status.getAdded() : Collections.emptySet();
  }

  public Set<String> getAllUntracked() {
    return initialized && status != null ? status.getUntracked() : Collections.emptySet();
  }

  private String getRelativePath() {
    if (gitDir == null || gitDir.getParentFile() == null) {
      return filePath;
    }
    String repoPath = gitDir.getParentFile().getAbsolutePath();
    return filePath.replace(repoPath + File.separator, "");
  }

  public static void initbylazy(File file, TextView textView) {
    if (file.isFile()) {
      new GitStatusChecker(textView).execute(file);
    }
  }

  class GitTextSub extends AsyncTaskCompat<File, Void, String> {
    private final WeakReference<TextView> textViewRef;

    public GitTextSub(TextView textView) {
      this.textViewRef = new WeakReference<>(textView);
      textView.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(File... params) {
      try {
        File file = params[0];
        JgitHelper gitHelper = new JgitHelper(file);

        if (!gitHelper.isInitialized()) {
          return null; // Not a valid Git repository
        }

        String fileName = file.getName();

        if (gitHelper.getAllModified().stream().anyMatch(s -> s.endsWith(fileName))) {
          return "C"; // Changed
        } else if (gitHelper.getAllAdded().stream().anyMatch(s -> s.endsWith(fileName))) {
          return "A"; // Added
        } else if (gitHelper.getAllUntracked().stream().anyMatch(s -> s.endsWith(fileName))) {
          return "U"; // Untracked
        }
      } catch (Exception e) {
        Log.e(TAG, "Error checking git status", e);
      }
      return null;
    }

    @MainThread
    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      TextView textView = textViewRef.get();
      if (textView != null) {
        textView.setVisibility(View.GONE);
      }
    }

    @Override
    protected void onPostExecute(String result) {
      TextView textView = textViewRef.get();
      if (textView != null) {
        if (result != null) {
          textView.setVisibility(View.VISIBLE);
          textView.setText(result);
        } else {
          textView.setVisibility(View.GONE);
        }
      }
    }
  }

  static class GitStatusChecker extends AsyncTaskCompat<File, Void, Integer> {
    private final WeakReference<TextView> textViewRef;

    public GitStatusChecker(TextView textView) {
      this.textViewRef = new WeakReference<>(textView);
    }

    @Override
    protected void onPreExecute() {
      super.onPreExecute();
      TextView textView = textViewRef.get();
      if (textView != null) {
        textView.setTextColor(MaterialColors.getColor(textView, ObjectUtils.colorOnSurface, 0));
      }
    }

    @Override
    protected Integer doInBackground(File... files) {
      try {
        File file = files[0];
        JgitHelper gitHelper = new JgitHelper(file);

        if (!gitHelper.isInitialized()) {
          return null;
        }

        String fileName = file.getName();

        if (gitHelper.getAllModified().stream().anyMatch(s -> s.endsWith(fileName))) {
          return Color.parseColor("#FFA500");
        } else if (gitHelper.getAllAdded().stream().anyMatch(s -> s.endsWith(fileName))) {
          return Color.parseColor("#008000");
        } else if (gitHelper.getAllUntracked().stream().anyMatch(s -> s.endsWith(fileName))) {
          return Color.parseColor("#FF0000");
        }
      } catch (Exception e) {
        Log.e("GitStatus", "Error checking git status", e);
      }
      return null;
    }

    @Override
    protected void onPostExecute(Integer color) {
      TextView textView = textViewRef.get();
      if (textView != null && color != null) {
        int startcolor = color;
        int endcolor = MaterialColors.getColor(textView, ObjectUtils.colorOnSurface, 0);
        JgitColorAnimHanlder.animTextColor(textView, startcolor, endcolor);
      }
    }
  }
}
