package com.ninjacoder.jgit;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;

public class PushTask extends GitTask {

  private static final String TAG = PushTask.class.getSimpleName();
  private final boolean[] gitOptions;
  private final String userName;
  private final String passwordUser;
  private String[] values;  

  PushTask(
      Context context,
      File repo,
      String[] values,
      boolean[] options,
      String userName,
      String passwordUser) {
    super(context, repo, values);
    this.gitOptions = options;
    this.userName = userName;
    this.passwordUser = passwordUser;
    this.values = values;
    id = 6;
  }

  @Override
  protected Boolean doInBackground(String... params) {
    if (params == null || params.length == 0) {
      Log.e(TAG, "Remote name not provided");
      return false;
    }

    Git git = GitWrapper.getGit(repo);
    if (git == null) {
      Log.e(TAG, "Git repository is null");
      return false;
    }

    try {
      UsernamePasswordCredentialsProvider credentials =
          new UsernamePasswordCredentialsProvider(userName, passwordUser);

      org.eclipse.jgit.api.PushCommand pushCommand =
          git.push()
              .setRemote(params[0])
              .setDryRun(gitOptions[0])
              .setForce(gitOptions[1])
              .setThin(gitOptions[2])
              .setCredentialsProvider(credentials);

      if (gitOptions[3]) { // اگر تیک تگ‌ها زده شده باشد
        pushCommand.setPushTags();
      }

      // اضافه کردن مانیتور پیشرفت ساده
      pushCommand.setProgressMonitor(new SimpleProgressMonitor());

      pushCommand.call();

      return true;

    } catch (TransportException e) {
      Log.e(TAG, "خطا در ارتباط با ریموت: " + e.getMessage());
      return false;
    } catch (GitAPIException e) {
      Log.e(TAG, "خطای گیت در عملیات پوش: " + e.getMessage());
      return false;
    } catch (Exception e) {
      Log.e(TAG, "خطای ناشناخته: " + e.getMessage());
      return false;
    }
  }

  @Override
  protected void onPostExecute(Boolean success) {
    super.onPostExecute(success);
    if (context != null) {
      String message = success ? values[1] : values[2];
      Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
  }

  private static class SimpleProgressMonitor implements ProgressMonitor {
    @Override
    public void start(int totalTasks) {
      Log.d(TAG, "شروع عملیات پوش با " + totalTasks + " تسک");
    }

    @Override
    public void beginTask(String title, int totalWork) {
      Log.d(TAG, "شروع تسک: " + title + " (" + totalWork + " واحد کار)");
    }

    @Override
    public void update(int completed) {
      Log.d(TAG, "پیشرفت: " + completed + " واحد تکمیل شد");
    }

    @Override
    public void endTask() {
      Log.d(TAG, "تسک تکمیل شد");
    }

    @Override
    public boolean isCancelled() {
      return false;
    }

    @Override
    public void showDuration(boolean arg0) {}
  }
}
