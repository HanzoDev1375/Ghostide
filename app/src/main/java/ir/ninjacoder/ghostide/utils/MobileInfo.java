package ir.ninjacoder.ghostide.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class MobileInfo {

    public static String getMobileInfo(Context context) {
        StringBuilder stringBuilder = new StringBuilder();

        // Display Metrics
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);

        stringBuilder.append("Display Metrics:");
        stringBuilder.append("\n");
        stringBuilder.append("- Width: ");
        stringBuilder.append(metrics.widthPixels);
        stringBuilder.append("px");
        stringBuilder.append("\n");
        stringBuilder.append("- Height: ");
        stringBuilder.append(metrics.heightPixels);
        stringBuilder.append("px");
        stringBuilder.append("\n");
        stringBuilder.append("- Density: ");
        stringBuilder.append(metrics.densityDpi);
        stringBuilder.append("dpi");
        stringBuilder.append("\n");
        stringBuilder.append("- Scaled Density: ");
        stringBuilder.append(metrics.scaledDensity);
        stringBuilder.append("\n");

        // Build Information
        stringBuilder.append("\n");
        stringBuilder.append("Build Information:");
        stringBuilder.append("\n");
        stringBuilder.append("- Board: ");
        stringBuilder.append(Build.BOARD);
        stringBuilder.append("\n");
        stringBuilder.append("- Brand: ");
        stringBuilder.append(Build.BRAND);
        stringBuilder.append("\n");
        stringBuilder.append("- Device ID: ");
        stringBuilder.append(Build.ID);
        stringBuilder.append("\n");
        stringBuilder.append("- Display: ");
        stringBuilder.append(Build.DISPLAY);
        stringBuilder.append("\n");
        stringBuilder.append("- Manufacturer: ");
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append("\n");
        stringBuilder.append("- Model: ");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("\n");
        stringBuilder.append("- Product: ");
        stringBuilder.append(Build.PRODUCT);
        stringBuilder.append("\n");
        stringBuilder.append("- Serial Number: ");
        stringBuilder.append(Build.SERIAL);
        stringBuilder.append("\n");

        // Telephony Manager
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        stringBuilder.append("\n");
        stringBuilder.append("Telephony Information:");
        stringBuilder.append("\n");
        stringBuilder.append("- Sim Operator Name: ");
        stringBuilder.append(telephonyManager.getSimOperatorName());
        stringBuilder.append("\n");
        stringBuilder.append("- Phone Type: ");
        int phoneType = telephonyManager.getPhoneType();
        switch (phoneType) {
            case TelephonyManager.PHONE_TYPE_NONE:
                stringBuilder.append("None");
                break;
            case TelephonyManager.PHONE_TYPE_GSM:
                stringBuilder.append("GSM");
                break;
            case TelephonyManager.PHONE_TYPE_CDMA:
                stringBuilder.append("CDMA");
                break;
            case TelephonyManager.PHONE_TYPE_SIP:
                stringBuilder.append("SIP");
                break;
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}