package com.mcal.uidesigner.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

public class TrainerLogo extends Drawable {
    private final Context context;
    private final Drawable icon;
    private final String[] text;

    public TrainerLogo(@NonNull Context context, int iconRes, String[] text) {
        this.context = context;
        this.text = text;
        this.icon = context.getResources().getDrawable(iconRes);
    }

    public static void set(@NonNull ActionBar ab, int iconRes, String[] text) {
        Context context = ab.getThemedContext();
        if (AndroidHelper.isMaterialTheme(context)) {
            ab.setDisplayShowTitleEnabled(true);
            ab.setIcon(iconRes);
            ab.setTitle(text[0]);
            ab.setSubtitle(text[1]);
            return;
        }
        ab.setDisplayShowTitleEnabled(false);
        ab.setLogo(new TrainerLogo(context, iconRes, text));
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(0xFFCCCCCD);
        paint.setAntiAlias(true);
        paint.setTextSize(40.0f);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText(text[0], 120.0f, 40.0f, paint);
        paint.setTextSize(35.0f);
        paint.setTypeface(Typeface.DEFAULT);
        canvas.drawText(text[1], 120.0f, 90.0f, paint);
        icon.setBounds(0, 0, 100, 100);
        icon.draw(canvas);
    }

    @Override
    public int getIntrinsicWidth() {
        return 400;
    }

    @Override
    public int getIntrinsicHeight() {
        return 100;
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}
