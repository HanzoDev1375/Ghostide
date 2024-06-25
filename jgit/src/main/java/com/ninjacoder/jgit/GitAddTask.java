package com.ninjacoder.jgit;

import android.content.Context;
import java.io.File;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class GitAddTask extends GitTask {

  GitAddTask(Context context, File repo, String[] values) {
    super(context, repo, values);
    id = 8;
  }

  @Override
  protected Boolean doInBackground(String... params) {

    try {
      Git git = GitWrapper.getGit(repo);
      if (git != null) {
        git.add().addFilepattern(params[0]).call();
      }
    } catch (GitAPIException api) {
      api.printStackTrace();
      return false;
    }

    return true;
  }
}
