package ir.ninjacoder.ghostide.widget;

import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import android.content.Context;
import android.content.Intent;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Logger {

    private static volatile boolean isRunning = false;

    public static void startLogging() {
        if (!isRunning) {
            loggerThread.start();
        } else {
            throw new IllegalStateException("Logger already running");
        }
    }    /**
     * Logcat Reader Class
     * <p>
     * Uses:
     * <br>
     * - "SketchLogger.broadcastLog(String)" to manually send a debug log that's then viewable in Logcat Reader
     * - "SketchLogger.stopLogging()" to stop logging
     */

    private static Thread loggerThread = new Thread() {
        @Override
        public void run() {
            isRunning = true;

            try {
                Runtime.getRuntime().exec("logcat -c");
                Process process = Runtime.getRuntime().exec("logcat");

                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String logTxt = bufferedReader.readLine();
                    do {
                        broadcastLog(logTxt);
                    } while (isRunning && ((logTxt = bufferedReader.readLine()) != null));

                    // Thread got stopped, restart if not stopping wantedly
                    if (isRunning) {
                        broadcastLog("Logger got killed. Restarting.");
                        startLogging();
                    } else {
                        broadcastLog("Logger stopped.");
                    }
                }
            } catch (Exception e) {
                broadcastLog(e.toString());
            }
        }
    };

    public static void broadcastLog(String log) {
        Context context = GhostIdeAppLoader.getContext();

        var intent = new Intent();
        intent.setAction("com.sketchware.remod.ACTION_NEW_DEBUG_LOG");
        intent.putExtra("log", log);
        intent.putExtra("packageName", context.getPackageName());
        context.sendBroadcast(intent);
    }

    public static void stopLogging() {
        if (isRunning) {
            isRunning = false;
            broadcastLog("Stopping logger by user request.");
        } else {
            throw new IllegalStateException("Logger not running");
        }
    }




}
