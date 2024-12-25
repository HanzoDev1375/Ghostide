package ir.ninjacoder.ghostide;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

public class NetworkChangeReceiver extends BroadcastReceiver {
    private CallBackNetWork callback;

    public NetworkChangeReceiver() {
    }

    public NetworkChangeReceiver(CallBackNetWork callback) {
        this.callback = callback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (isOnline(context)) {
            callback.ConnectionIS();
        } else {
            callback.ConnectionNOT();
        }
    }

    private boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public interface CallBackNetWork {
        public void ConnectionIS();

        public void ConnectionNOT();
    }
}
