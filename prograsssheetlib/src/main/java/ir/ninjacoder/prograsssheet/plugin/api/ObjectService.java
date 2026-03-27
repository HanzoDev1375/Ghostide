package ir.ninjacoder.prograsssheet.plugin.api;

import android.app.Service;
import android.os.IBinder;
import android.content.Intent;

public abstract class ObjectService extends Service {

  @Override
  public IBinder onBind(Intent intent) {
    return onBind(intent);
  }

  public abstract IBinder onBindCall(Intent i);
}
