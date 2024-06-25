package Ninja.coder.Ghostemane.code.utils;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import java.util.Random;

public class Utils {
    public static boolean isMyServiceRunning(Context context, Class<?> cls) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo :
                ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE))
                        .getRunningServices(Integer.MAX_VALUE)) {
            if (cls.getName().equals(runningServiceInfo.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static int getRandom(int i, int i2) {
        return new Random().nextInt(i2 - i) + i;
    }

    public static void startService(Context context, Class<? extends Service> cls) {
        Intent intent = new Intent(context, cls);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void startService(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }
}
