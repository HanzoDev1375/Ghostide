package Ninja.coder.Ghostemane.code;

import Ninja.coder.Ghostemane.code.services.DownloadService;
import Ninja.coder.Ghostemane.code.utils.Utils;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StopServiceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Utils.isMyServiceRunning(context, DownloadService.class)) {
            DownloadService.downloadAllowed = false;
            context.stopService(new Intent(context, DownloadService.class));
        }
    }
}
