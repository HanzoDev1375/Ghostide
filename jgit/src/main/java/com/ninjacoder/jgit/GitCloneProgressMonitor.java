package com.ninjacoder.jgit;

import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import org.eclipse.jgit.lib.ProgressMonitor;

/** private class dont call other */
class GitCloneProgressMonitor implements ProgressMonitor {
  private final LinearProgressIndicator progress;
  private final TextView message;
  private boolean cancelled = false;

  private final Handler handler = new Handler(Looper.getMainLooper());

  public GitCloneProgressMonitor(LinearProgressIndicator progress, TextView message) {
    this.progress = progress;
    this.message = message;
  }

  public void cancel() {
    cancelled = true;
  }

  @Override
  public void start(int totalTasks) {
    handler.post(() -> progress.setMax(totalTasks));
  }

  @Override
  public void beginTask(String title, int totalWork) {
    handler.post(() -> message.setText(title + " " + String.valueOf(totalWork)));
  }

  @Override
  public void update(int completed) {
    handler.post(() -> progress.setProgress(completed));
  }

  @Override
  public void showDuration(boolean enabled) {}

  @Override
  public void endTask() {
    // call.onEndWork();
  }

  @Override
  public boolean isCancelled() {
    return cancelled || Thread.currentThread().isInterrupted();
  }
}
