package ir.ninjacoder.ghostide.core.layoutmanager;

import android.content.Context;

public class Utils {
    public static int px2dp(Context context, int px) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px * scale + 0.5f);
    }
}