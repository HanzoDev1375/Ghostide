package com.ninjacoder.jgit;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;
import com.google.android.material.snackbar.Snackbar;

import java.time.Duration;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.BatchingProgressMonitor;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;

@RequiresApi(26)
public class PushTask extends GitTask {

  private static final String TAG = PushTask.class.getSimpleName();
  private boolean[] gitOptions;
  private String userName;
  private String passwordUser;

  PushTask(Context context, File repo, String[] values, boolean[] options,String userName,String passwordUser) {
    super(context, repo, values);
   this. gitOptions = options;
    this.userName = userName;
    this.passwordUser = passwordUser;
    id = 6;
  }

  @Override
  protected Boolean doInBackground(String... params) {
    Git git = GitWrapper.getGit(repo);
    if (git != null) {
      try {
        if (gitOptions[3]) {
          git.push()
              .setRemote(params[0])
              .setDryRun(gitOptions[0])
              .setForce(gitOptions[1])
              .setThin(gitOptions[2])
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
                      publishProgress(
                          taskName, String.valueOf(workCurr), String.valueOf(workTotal));
                    }
                  })
              .setPushTags()
              .setCredentialsProvider(new UsernamePasswordCredentialsProvider(userName,passwordUser))
              .call();
        } else {
          git.push()
              .setRemote(params[0])
              .setDryRun(gitOptions[0])
              .setForce(gitOptions[1])
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
                      publishProgress(
                          taskName, String.valueOf(workCurr), String.valueOf(workTotal));
                    }
                  })
              .setThin(gitOptions[2])
             //done using param from user
              .setCredentialsProvider(new UsernamePasswordCredentialsProvider(userName,passwordUser))
              .call();
        }
      } catch (GitAPIException e) {
        Log.e(TAG, e.toString());
        return false;
      }

      return true;
    }

    return false;
  }
}
