package com.ninjacoder.jgit;

import android.content.Context;
import android.util.Log;

import android.widget.Toast;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.revwalk.RevCommit;

public class CommitTask extends GitTask {

  private static final String TAG = CommitTask.class.getSimpleName();

  CommitTask(Context context, File repo, String[] values) {
    super(context, repo, values);
    id = 4;
  }

  @Override
  protected Boolean doInBackground(String... strings) {
    try {
      if (strings == null || strings.length < 3 || strings[0] == null) {
        return false;
      }

      Git git = GitWrapper.getGit(repo);
      if (git != null && GitUtils.isGitRepository(repo)) {
        git.commit()
            .setMessage(strings[0])
            .setCommitter(
                strings[1] != null ? strings[1] : "", strings[2] != null ? strings[2] : "")
            .call();
      }
    } catch (GitAPIException e) {
      Log.e(TAG, e.toString());
      return false;
    }
    return true;
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
    Toast.makeText(context, "Done", 2).show();
    // TODO: Implement this method
  }
}
