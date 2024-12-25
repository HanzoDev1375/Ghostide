package ir.ninjacoder.ghostide.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReSizeApp {
    // Resize all views in the activity to fit the screen size
    public static void resize(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        ViewGroup layout = activity.findViewById(android.R.id.content);
        scaleView(layout, width, height);
    }

    // Scale a view and its children recursively to fit the given width and height
    private static void scaleView(View view, int width, int height) {
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                View child = group.getChildAt(i);
                scaleView(child, width, height);
            }
        } else {
            float ratioX = (float) view.getWidth() / (float) 1080;
            float ratioY = (float) view.getHeight() / (float) 1920;
            view.getLayoutParams().width = (int) (width * ratioX);
            view.getLayoutParams().height = (int) (height * ratioY);
        }
    }

    public static void resize(TextView textView, Context context) {
        // بدست آوردن اندازه DPI دستگاه
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        // تنظیم سایز TextView
        float textSize = (dpWidth / 20) * (displayMetrics.densityDpi / 160f); // سایز متن
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

    }

    public static void resize(TextView textView, Context context, float customTextSize) {
        // بدست آوردن عرض و ارتفاع DPI واقعی صفحه
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        // تنظیم سایز TextView با استفاده از فرمول
        float textSize = customTextSize > 0 ? customTextSize : (dpWidth / 20);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
    }

}
