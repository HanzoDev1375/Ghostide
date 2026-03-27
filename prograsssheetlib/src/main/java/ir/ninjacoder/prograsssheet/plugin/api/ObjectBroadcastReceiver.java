package ir.ninjacoder.prograsssheet.plugin.api;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.Context;

public abstract class ObjectBroadcastReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    onReceiveCall(context,intent);
  }
  
  public abstract void onReceiveCall(Context context, Intent intent);
}
