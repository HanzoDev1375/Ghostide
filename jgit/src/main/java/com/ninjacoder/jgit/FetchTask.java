package com.ninjacoder.jgit;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.time.Duration;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.BatchingProgressMonitor;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;

public class FetchTask extends GitTask {

  private static final String TAG = PullTask.class.getSimpleName();

  FetchTask(Context context, File repo, String[] values) {
    super(context, repo, values);
    id = 5;
  }

  @Override
  protected Boolean doInBackground(String... params) {
    Git git = GitWrapper.getGit(repo);
    if (git != null) {
      try {
        git.fetch()
            .setCheckFetchedObjects(true)
            .setRemote(params[0])
            .setCredentialsProvider(new UsernamePasswordCredentialsProvider(params[1], params[2]))
            .setProgressMonitor(
                new BatchingProgressMonitor() {
                  @Override
                  protected void onUpdate(String taskName, int workCurr, Duration arg2) {}

                  @Override
                  protected void onEndTask(String taskName, int workCurr, Duration arg2) {}

                  @Override
                  protected void onUpdate(
                      String taskName,
                      int workCurr,
                      int workTotal,
                      int percentDone,
                      Duration arg4) {
                    publishProgress(
                        taskName,
                        String.valueOf(percentDone),
                        String.valueOf(workCurr),
                        String.valueOf(workTotal));
                  }

                  @Override
                  protected void onEndTask(
                      String taskName,
                      int workCurr,
                      int workTotal,
                      int percentDone,
                      Duration arg4) {
                    publishProgress(taskName, String.valueOf(workCurr), String.valueOf(workTotal));
                  }
                })
            .call();
      } catch (GitAPIException e) {
        Log.e(TAG, e.toString());
        return false;
      }

      return true;
    }

    return false;
  }
}
