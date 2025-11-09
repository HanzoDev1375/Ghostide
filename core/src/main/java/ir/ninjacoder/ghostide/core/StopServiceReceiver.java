package ir.ninjacoder.ghostide.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import ir.ninjacoder.ghostide.core.services.DownloadService;
import ir.ninjacoder.ghostide.core.utils.Utils;

public class StopServiceReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Utils.isMyServiceRunning(context, DownloadService.class)) {
            DownloadService.downloadAllowed = false;
            context.stopService(new Intent(context, DownloadService.class));
        }
    }
}
