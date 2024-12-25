package ir.ninjacoder.ghostide.layoutmanager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ColorList {
    public static void setColorAsRandom(ImageView img, TextView tv) {
        int color = getRandomColor();
        int colorText = getRandomColors();
        setImageViewColorFilter(img, color);
        setTextColor(tv, colorText);
    }

    public static void setViewBackGround(View view) {
        int colors = getRandomColor();
        view.setBackgroundColor(colors);
    }

    public static int getRandomColor() {
        Random random = new Random();
        return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private static int getRandomColors() {
        Random random = new Random();
        return Color.rgb(random.nextInt(250), random.nextInt(200), random.nextInt(256));
    }

    private static void setImageViewColorFilter(ImageView imageView, int color) {
        imageView.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
    }

    private static void setTextColor(TextView textView, int color) {
        textView.setTextColor(color);
    }
}
