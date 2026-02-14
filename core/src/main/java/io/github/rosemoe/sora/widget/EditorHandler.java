package io.github.rosemoe.sora.widget;

import android.os.Handler;
import android.os.Looper;

public final class EditorHandler {
    public static final Handler INSTANCE = new Handler(Looper.getMainLooper());
    private EditorHandler() {
    }
}