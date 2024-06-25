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
public class PullTask extends GitTask {

    private static final String TAG = PullTask.class.getSimpleName();

    PullTask(Context context, File repo, String[] values) {
        super(context, repo, values);
        id = 5;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        Git git = GitWrapper.getGit( repo);
        if (git != null) {
            try {
                git.pull()
                        .setRemote(params[0])
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
                        .setCredentialsProvider(new UsernamePasswordCredentialsProvider(params[1], params[2]))

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
