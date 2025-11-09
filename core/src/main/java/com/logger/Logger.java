package com.logger;

import android.util.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Logger {

    private static Map<String, Logger> loggerRegistry =
            Collections.synchronizedMap(new HashMap<String, Logger>());

    private String category;

    private Logger(String category) {
        this.category = category;
    }

    public static synchronized Logger getLogger(String category) {
        synchronized (loggerRegistry) {
            if (loggerRegistry.containsKey(category)) return loggerRegistry.get(category);

            Logger logger = new Logger(category);
            loggerRegistry.put(category, logger);
            return logger;
        }
    }

    public void debug(String message) {
        Log.d(category, "DEBUG: " + message);
    }

    public void info(String message) {
        Log.i(category, "INFO: " + message);
    }

    public void warn(String message) {
        Log.i(category, "INFO: " + message);
    }

    public void error(String message, Exception e) {
        Log.e(category, "ERROR: " + message);
        Log.e(category, "Stack Trace: " + Log.getStackTraceString(e));
    }
}
