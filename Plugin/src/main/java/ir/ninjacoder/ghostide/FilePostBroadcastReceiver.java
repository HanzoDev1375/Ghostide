package ir.ninjacoder.ghostide.PluginManager;

import ir.ninjacoder.ghostide.PluginManager.IntentHelper;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FilePostBroadcastReceiver extends BroadcastReceiver {

  public static final String ACTION_SEND_FILE_PATH = "Ninja.coder.code.Ghostemane.SEND_FILE_PATH";
  public static final String EXTRA_FILE_PATH = "/sdcard/";

  @Override
  public void onReceive(Context context, Intent intent) {
    if (intent != null && intent.getAction().equals(ACTION_SEND_FILE_PATH)) {
      String path = intent.getStringExtra(EXTRA_FILE_PATH);
    }
  }
}