package ir.ninjacoder.ghostide;

import ir.ninjacoder.ghostide.services.DownloadService;
import ir.ninjacoder.ghostide.utils.Utils;
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
