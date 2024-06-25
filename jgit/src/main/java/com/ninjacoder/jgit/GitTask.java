package com.ninjacoder.jgit;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import androidx.core.app.NotificationCompat;
import java.io.File;

public abstract class GitTask extends AsyncTaskCompat<String, String, Boolean> {

  public NotificationManager manager;
  public NotificationCompat.Builder builder;
  public int id = 1;

  public Context context;
  public File repo;
  public String[] messages;

  public GitTask(Context context, File repo, String[] values) {
    this.context = context;
    
    this.repo = repo;
    messages = values;
    manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    String id = "hyper_git_channel";
    if (Build.VERSION.SDK_INT >= 26) {
      CharSequence name = "Ghost web ide";
      String description = "Jgit";
      int importance = NotificationManager.IMPORTANCE_HIGH;
      NotificationChannel channel = new NotificationChannel(id, name, importance);
      channel.setDescription(description);
      manager.createNotificationChannel(channel);
    }

    builder = new NotificationCompat.Builder(context, id);
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
    builder
        .setContentTitle(messages[0])
        .setAutoCancel(false)
        .setSmallIcon(android.R.drawable.gallery_thumb)
        .setOngoing(true);
  }

  @Override
  protected void onProgressUpdate(final String... values) {
    super.onProgressUpdate(values);
    builder
        .setContentText(values[0])
        .setProgress(Integer.valueOf(values[2]), Integer.valueOf(values[1]), false);
    builder.setStyle(new NotificationCompat.BigTextStyle().bigText(values[0]));
    manager.notify(id, builder.build());
  }

  @Override
  protected void onPostExecute(Boolean aBoolean) {
    super.onPostExecute(aBoolean);
    if (aBoolean) {
      builder.setContentText(messages[1]);
    } else {
      builder.setContentText(messages[2]);
    }

    builder.setProgress(0, 0, false).setAutoCancel(true).setOngoing(false);
    manager.notify(id, builder.build());
  }
}
