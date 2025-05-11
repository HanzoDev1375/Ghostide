package com.ninjacoder.jgit;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import java.nio.charset.StandardCharsets;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.lib.ObjectReader;
import android.text.style.ForegroundColorSpan;
import android.graphics.Color;
import android.text.Spannable;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.ninjacoder.jgit.databinding.LayoutGitpullBinding;
import com.ninjacoder.jgit.databinding.LayoutPushBinding;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** Helper class to handle git functions */
public class GitWrapper {

  /** Log TAG */
  private static final String TAG = GitWrapper.class.getSimpleName();

  public static boolean isPro = true;

  /**
   * git init
   *
   * @param context context to make toast
   * @param repo repo to init
   */
  public static void init(Context context, File repo) {
    try {
      Git git = Git.init().setDirectory(repo).call();
      Toast.makeText(context, "Git init from " + git.getRepository().getDirectory(), 2).show();

    } catch (GitAPIException e) {
      Log.e(TAG, e.toString());
    }
  }

  /**
   * git add -A
   *
   * @param repo repo to stage files
   */
  public static void add(File repo, Context c) {
    new GitAddTask(
            c,
            repo,
            new String[] {
              "Creating new files", "files add out successfully.", "Unable to add files."
            })
        .execute(".");
  }

  static void runOnUi(Runnable f) {
    new Handler(Looper.getMainLooper()).post(f);
  }

  public static void gotoLog(Context c, File file) {
    RecyclerView rv = new RecyclerView(c);
    List<RevCommit> commits = getCommits(file);
    RecyclerView.Adapter adapter = new GitLogsAdapter(c, commits);
    var param =
        new RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
    RecyclerView.LayoutManager manager = new LinearLayoutManager(c, RecyclerView.VERTICAL, false);
    rv.setLayoutParams(param);
    var sheet = new BottomSheetDialog(c);
    sheet.setContentView(rv);
    rv.setAdapter(adapter);
    rv.setLayoutManager(manager);
    if (sheet != null) {
      sheet.show();
    }
  }

  /**
   * git commit -m 'message'
   *
   * @param context context to make toast
   * @param repo repo to commit to
   * @param message git commit message
   */
  private static String changeTextToNone(String text) {
    if (StringUtils.isEmptyOrNull(text)) {
      return "None\n";
    }

    return text;
  }

  /**
   * git status
   *
   * @param repo repo to view status of
   * @param t text views to set status to
   */
  public static void status(File repo, TextView... t) {
    try {
      Git git = getGit(repo);
      if (git != null) {
        Status status = git.status().call();

        Set<String> conflicting = status.getConflicting();
        StringBuilder conflictingOut = new StringBuilder();
        for (String conflict : conflicting) {
          conflictingOut.append(conflict).append("\n");
        }
        t[0].setText(changeTextToNone(conflictingOut.toString()));

        Set<String> added = status.getAdded();
        StringBuilder addedOut = new StringBuilder();
        for (String add : added) {
          addedOut.append(add).append("\n");
        }
        t[1].setText(changeTextToNone(addedOut.toString()));

        Set<String> changed = status.getChanged();
        StringBuilder changedOut = new StringBuilder();
        for (String change : changed) {
          changedOut.append(change).append("\n");
        }
        t[2].setText(changeTextToNone(changedOut.toString()));

        Set<String> missing = status.getMissing();
        StringBuilder missingOut = new StringBuilder();
        for (String miss : missing) {
          missingOut.append(miss).append("\n");
        }
        t[3].setText(changeTextToNone(missingOut.toString()));

        Set<String> modified = status.getModified();
        StringBuilder modifiedOut = new StringBuilder();
        for (String mod : modified) {
          modifiedOut.append(mod).append("\n");
        }
        t[4].setText(changeTextToNone(modifiedOut.toString()));

        Set<String> removed = status.getRemoved();
        StringBuilder removedOut = new StringBuilder();
        for (String remove : removed) {
          removedOut.append(remove).append("\n");
        }
        t[5].setText(changeTextToNone(removedOut.toString()));

        Set<String> uncommitted = status.getUncommittedChanges();
        StringBuilder uncommittedOut = new StringBuilder();
        for (String uncom : uncommitted) {
          uncommittedOut.append(uncom).append("\n");
        }
        t[6].setText(changeTextToNone(uncommittedOut.toString()));

        Set<String> untracked = status.getUntracked();
        StringBuilder untrackedOut = new StringBuilder();
        for (String untrack : untracked) {
          untrackedOut.append(untrack).append("\n");
        }
        t[7].setText(changeTextToNone(untrackedOut.toString()));

        Set<String> untrackedFolders = status.getUntrackedFolders();
        StringBuilder untrackedFoldersOut = new StringBuilder();
        for (String untrackedf : untrackedFolders) {
          untrackedFoldersOut.append(untrackedf).append("\n");
        }
        t[8].setText(changeTextToNone(untrackedFoldersOut.toString()));
      }
    } catch (GitAPIException e) {
      Log.e(TAG, e.toString());
    }
  }

  /**
   * git log
   *
   * @param repo to get commits from
   * @return list of commits
   */
  public static List<RevCommit> getCommits(File repo) {
    if (repo == null || !GitUtils.isGitRepository(repo)) return null;

    Iterable<RevCommit> log = null;
    List<RevCommit> revCommits = new ArrayList<>();

    try {
      Git git = getGit(repo);
      if (git != null) {
        log = git.log().call();
      }
    } catch (GitAPIException e) {
      Log.e(TAG, e.toString());
      return null;
    }

    if (log != null) {
      for (RevCommit commit : log) {
        revCommits.add(commit);
      }
    }

    return revCommits;
  }

  /**
   * git branch
   *
   * @param repo repo to get branches from
   * @return list of branches
   */
  public static List<Ref> getBranches(File repo) {
    List<Ref> branches = null;
    try {
      Git git = getGit(repo);
      if (git != null) {
        branches = git.branchList().call();
      }
    } catch (GitAPIException e) {
      Log.e(TAG, e.toString());
      return null;
    }

    return branches;
  }

  /**
   * git branch branchName
   *
   * @param context context to make toast
   * @param repo to create branch
   * @param branchName name of branch
   * @param checked switch to branch if it exists
   */
  public static void createBranch(Context context, File repo, String branchName, boolean checked) {
    try {
      Git git = getGit(repo);
      if (git != null) {
        // ابتدا بررسی می‌کنیم branch وجود دارد یا نه
        boolean branchExists =
            git.branchList().call().stream()
                .anyMatch(ref -> ref.getName().endsWith("/" + branchName));

        if (branchExists && checked) {
          // اگر branch وجود دارد و checked=true است، checkout می‌کنیم
          new CheckoutTask(
                  context,
                  repo,
                  new String[] {
                    "در حال تغییر به برنچ", "تغییر به برنچ با موفقیت انجام شد", "خطا در تغییر برنچ"
                  })
              .execute("false", branchName);
        } else if (!branchExists) {
          // اگر branch وجود ندارد، ایجاد می‌کنیم
          git.branchCreate().setName(branchName).call();

          if (checked) {
            // اگر checked=true است، به branch جدید checkout می‌کنیم
            new CheckoutTask(
                    context,
                    repo,
                    new String[] {
                      "در حال تغییر به برنچ جدید",
                      "برنچ جدید ایجاد و انتخاب شد",
                      "خطا در ایجاد برنچ جدید"
                    })
                .execute("false", branchName);
          }
        }
      }
    } catch (GitAPIException e) {
      Log.e(TAG, "خطا در ایجاد برنچ: " + e.toString());
      Toast.makeText(context, "خطا در ایجاد برنچ: " + e.getMessage(), Toast.LENGTH_LONG).show();
    }
  }

  /**
   * git branch -d branches
   *
   * @param repo to delete branches from
   * @param branches to delete
   */
  public static void deleteBranch(File repo, String... branches) {
    try {
      Git git = getGit(repo);
      if (git != null) {
        git.branchDelete().setBranchNames(branches).call();
      }
    } catch (GitAPIException e) {
      Log.e(TAG, e.toString());
    }
  }

  /**
   * git checkout branch
   *
   * @param context context to make toast
   * @param repo to checkout to branch
   * @param branch to checkout to
   */
  public static void checkout(Context context, File repo, String branch) {
    new CheckoutTask(
            context,
            repo,
            new String[] {"Checking out", "Checked out successfully.", "Unable to checkout."})
        .execute(String.valueOf(false), branch);
  }

  public static String getCurrentBranch(File repo) {
    String branch = "";
    try {
      Git git = getGit(repo);
      if (git != null) {
        branch = git.getRepository().getFullBranch();
      }
    } catch (IOException e) {
      Log.e(TAG, e.toString());
      return null;
    }

    return branch;
  }

  /**
   * git clone remoteUrl
   *
   * @param context context to make toast
   * @param repo to clone
   * @param adapter to refresh
   * @param remoteUrl to clone from
   */
  public static void push(Context context, File repo) {
    LayoutPushBinding bin = LayoutPushBinding.inflate(LayoutInflater.from(context));
    bin.remotesSpinner.setAdapter(
        new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, getRemotes(repo)));
    new MaterialAlertDialogBuilder(context)
        .setTitle("Push")
        .setView(bin.getRoot())
        .setNegativeButton(
            "Push",
            (c, f) -> {
              new PushTask(
                      context,
                      repo,
                      new String[] {
                        "Pushing changes",
                        "Successfully pushed commits to remote.",
                        "There was a problem while pushing commits."
                      },
                      new boolean[] {
                        bin.dryRun.isChecked(),
                        bin.force.isChecked(),
                        bin.thin.isChecked(),
                        bin.tags.isChecked()
                      },
                      bin.pushUsername.getText().toString(),
                      bin.pushPassword.getText().toString())
                  .execute((String) bin.remotesSpinner.getSelectedItem());
            })
        .show();
  }

  public static void pull(Context context, File repo) {
    LayoutGitpullBinding bin = LayoutGitpullBinding.inflate(LayoutInflater.from(context));
    var rm = bin.remote.getEditText().getText().toString();
    var user = bin.userName.getEditText().getText().toString();
    var pass = bin.token.getEditText().getText().toString();

    ArrayList<String> rem = getRemotes(repo);
    if (rem != null) {
      for (var txt : rem) {
        String table = getRemoteUrl(repo, txt);
        if (!rem.isEmpty()) bin.remote.getEditText().setText(table == null ? "" : table);
      }
    }
    new MaterialAlertDialogBuilder(context)
        .setTitle("Git Pull")
        .setView(bin.getRoot())
        .setPositiveButton(
            "pull",
            (c, cc) -> {
              for (String string : rem) {
                new PullTask(
                        context,
                        repo,
                        new String[] {
                          "Pulling changes",
                          "Successfully pulled commits from remote.",
                          "There was a problem while pulling commits."
                        })
                    .execute(string, user, pass);
              }
            })
        .show();
  }

  public static void commit(Context context, File repo) {
    LayoutGitpullBinding bin = LayoutGitpullBinding.inflate(LayoutInflater.from(context));

    // Configure the layout for commit
    bin.remote.setHint("Commit message*");
    bin.userName.setHint("Your name*");
    bin.token.setHint("Your email*");
    bin.userName.setVisibility(View.VISIBLE);
    bin.token.setVisibility(View.VISIBLE);

    // Get default values from git config
    try {
      StoredConfig config = getConfig(repo);
      if (config != null) {
        // Get user.name
        String userName = config.getString("user", null, "name");
        if (userName != null) {
          bin.userName.getEditText().setText(userName);
        }

        // Get user.email
        String userEmail = config.getString("user", null, "email");
        if (userEmail != null) {
          bin.token.getEditText().setText(userEmail);
        }
      }
    } catch (Exception e) {
      Log.e(TAG, "Error getting git config", e);
    }

    new MaterialAlertDialogBuilder(context)
        .setTitle("Git Commit")
        .setPositiveButton(
            "commit",
            (c, cc) -> {
              String message = bin.remote.getEditText().getText().toString();
              String name = bin.userName.getEditText().getText().toString();
              String email = bin.token.getEditText().getText().toString();

              if (message.isEmpty()) {
                Toast.makeText(context, "Commit message cannot be empty", Toast.LENGTH_SHORT)
                    .show();
                return;
              }

              if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(context, "Please provide your name and email", Toast.LENGTH_SHORT)
                    .show();
                return;
              }

              new CommitTask(
                      context,
                      repo,
                      new String[] {
                        "Committing changes", "Committed successfully", "Failed to commit"
                      })
                  .execute(message, name, email);
            })
        .setNegativeButton("Cancel", null)
        .setView(bin.getRoot())
        .show();
  }

  public static void fetch(Context context, File repo) {
    LayoutGitpullBinding bin = LayoutGitpullBinding.inflate(LayoutInflater.from(context));
    var rm = bin.remote.getEditText().getText().toString();
    var user = bin.userName.getEditText().getText().toString();
    var pass = bin.token.getEditText().getText().toString();
    ArrayList<String> rem = getRemotes(repo);
    for (var txt : rem) {
      String table = getRemoteUrl(repo, txt);
      if (!rem.isEmpty()) bin.remote.getEditText().setText(table == null ? "" : table);
      new MaterialAlertDialogBuilder(context)
          .setTitle("Git Fetch")
          .setMessage("")
          .setPositiveButton(
              "fetch",
              (c, cc) -> {
                new FetchTask(
                        context,
                        repo,
                        new String[] {
                          "Fetching remote " + rm,
                          "Successfully fetched from " + rm + ".",
                          "There was a problem while fetching from " + rm + "."
                        })
                    .execute(txt, user, pass);
              })
          .setView(bin.getRoot())
          .show();
    }
  }

  public static Git getGit(File repo) {
    try {
      return Git.open(repo);
    } catch (IOException e) {
      Log.e(TAG, e.toString());
    }

    return null;
  }

  private static StoredConfig getConfig(File repo) {
    Git git = getGit(repo);
    if (git != null) {
      return git.getRepository().getConfig();
    }

    return null;
  }

  public static String getRemoteUrl(File repo, String remote) {
    String url = "";
    StoredConfig config = getConfig(repo);
    if (config != null) {
      url = config.getString("remote", remote, "url");
    }

    return url;
  }

  public static ArrayList<String> getRemotes(File repo) {
    ArrayList<String> remotes = null;
    StoredConfig config = getConfig(repo);
    if (config != null) {
      remotes = new ArrayList<>(config.getSubsections("remote"));
    }

    return remotes;
  }

  public static void addRemote(Context context, File repo) {
    LayoutGitpullBinding bin = LayoutGitpullBinding.inflate(LayoutInflater.from(context));
    var remote = bin.remote.getEditText().getText().toString();
    var url = bin.userName.getEditText().getText().toString();
    var pass = bin.token.getEditText().getText().toString();
    bin.token.setVisibility(View.GONE);
    bin.remote.setHint("Remote Name");
    bin.userName.setHint("Url Name");
    new MaterialAlertDialogBuilder(context)
        .setTitle("Remote")
        .setView(bin.getRoot())
        .setPositiveButton(
            "ok",
            (c, x) -> {
              StoredConfig config = getConfig(repo);
              if (config != null) {
                config.setString("remote", remote, "url", url);
                try {
                  config.save();
                } catch (IOException e) {
                  Log.e(TAG, e.toString());
                }
              }
            })
        .show();
  }

  public static void removeRemote(File repo, String remote) {
    StoredConfig config = getConfig(repo);
    if (config != null) {
      config.unsetSection("remote", remote);
      try {
        config.save();
      } catch (IOException e) {
        Log.e(TAG, e.toString());
      }
    }
  }

  public static boolean canCommit(File repo) {
    try {
      Git git = getGit(repo);
      if (git != null) {
        return git.getRepository().getRepositoryState().canCommit()
            && git.status().call().hasUncommittedChanges();
      }
    } catch (GitAPIException e) {
      Log.e(TAG, e.toString());
    }

    return false;
  }

  public static boolean canCheckout(File repo) {
    Git git = getGit(repo);
    return git != null && git.getRepository().getRepositoryState().canCheckout();
  }

  public static SpannableStringBuilder diff(File repo, ObjectId oldCommit, ObjectId newCommit) {
    SpannableStringBuilder builder = new SpannableStringBuilder();
    Git git = getGit(repo);

    if (git == null) {
      return builder;
    }

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        DiffFormatter formatter = new DiffFormatter(out)) {

      formatter.setRepository(git.getRepository());

      // اگر یکی از کامیت‌ها null باشد، با working tree مقایسه می‌شود
      List<DiffEntry> diffs;
      if (newCommit == null) {
        diffs = git.diff().setOldTree(prepareTreeParser(git, oldCommit)).call();
      } else {
        diffs =
            git.diff()
                .setOldTree(prepareTreeParser(git, oldCommit))
                .setNewTree(prepareTreeParser(git, newCommit))
                .call();
      }

      for (DiffEntry entry : diffs) {
        formatter.format(entry);
        String diffText = out.toString(StandardCharsets.UTF_8.name());
        applyDiffStyles(builder, diffText);
        out.reset();
      }
    } catch (Exception e) {
      Log.e(TAG, "خطا در محاسبه تفاوت‌ها", e);
    }

    return builder;
  }

  private static AbstractTreeIterator prepareTreeParser(Git git, ObjectId commitId)
      throws IOException {
    CanonicalTreeParser treeParser = new CanonicalTreeParser();
    try (ObjectReader reader = git.getRepository().newObjectReader()) {
      // روش جایگزین برای parseTree
      RevWalk revWalk = new RevWalk(reader);
      RevCommit commit = revWalk.parseCommit(commitId);
      RevTree tree = commit.getTree();

      treeParser.reset(reader, tree.getId());
    }
    return treeParser;
  }

  private static void applyDiffStyles(SpannableStringBuilder builder, String diffText) {
    String[] lines = diffText.split("\n");

    for (String line : lines) {
      int start = builder.length();
      builder.append(line).append("\n");
      int end = builder.length();

      if (line.startsWith("+")) {
        // خطوط اضافه شده (سبز)
        builder.setSpan(
            new ForegroundColorSpan(Color.GREEN), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
      } else if (line.startsWith("-")) {
        // خطوط حذف شده (قرمز با خط خورده)
        builder.setSpan(
            new ForegroundColorSpan(Color.RED), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
      } else if (line.startsWith("@@")) {
        // هدر diff (آبی)
        builder.setSpan(
            new ForegroundColorSpan(Color.BLUE), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
      }
    }
  }

  public static void diffImpl(File file, Context c) {
    try {
      if (!GitUtils.isGitRepository(file)) {
        GitWrapper.init(c, file);
      }

      var git = getGit(file);
      if (git == null) {
        Toast.makeText(c, "Error to open rep", Toast.LENGTH_SHORT).show();
        return;
      }

      ObjectId commit1 = git.getRepository().resolve("HEAD~1");
      ObjectId commit2 = git.getRepository().resolve("HEAD");

      if (commit1 == null || commit2 == null) {
        Toast.makeText(c, "commit not found", Toast.LENGTH_SHORT).show();
        return;
      }
      var diffText = diff(file, commit1, commit2);
      new MaterialAlertDialogBuilder(c).setMessage(diffText).show();
    } catch (Exception err) {
      Toast.makeText(c, err.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
  }

  void msg(Context c, String ec) {
    Toast.makeText(c, ec, 2).show();
  }
}
