package Ninja.coder.Ghostemane.code.widget;


import Ninja.coder.Ghostemane.code.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.textview.MaterialTextView;

public class HostItemCustom extends LinearLayoutCompat {
    public static int vertical = VERTICAL;
    public static int horizntal = HORIZONTAL;
    protected MaterialTextView textView;
    protected AppCompatImageView imageView;

    public HostItemCustom(Context context) {
        super(context);
        init();
    }

    public HostItemCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public HostItemCustom init() {
        setOrintaishan(true);

        return this;
    }

    public HostItemCustom additem(String title, int icon, View.OnClickListener listener) {
        additem(getContext(), title, icon, listener);
        return this;
    }

    public HostItemCustom additem(String title, View.OnClickListener listener) {
        //this fake icon dont add icon tnks
        additem(title, android.R.drawable.gallery_thumb, listener);
        imageView.setVisibility(View.GONE);
        return this;
    }

    public HostItemCustom additem(Context context, String name, int icon, View.OnClickListener v) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.abc_layout_nav, this, false);
        view.setOnClickListener(v);
        view.setTooltipText(name);
        imageView = view.findViewById(R.id.imgHelper);
        textView = view.findViewById(R.id.tvPass);
        textView.setText(name);
        imageView.setImageResource(icon);
        imageView.setScaleType(AppCompatImageView.ScaleType.FIT_XY);
        view.setElevation(2);
        textView.setTextColor(0xFFFFB689);
        addView(view);
        return this;
    }

    public HostItemCustom Clear() {
        removeAllViews();
        return this;
    }

    public HostItemCustom setTypeFace(Typeface face, int data) {
        textView.setTypeface(face, data);
        return this;
    }

    public HostItemCustom setTextColor(int color) {
        textView.setTextColor(color);
        return this;
    }

    public HostItemCustom setTextSize(float size) {
        textView.setTextSize(size);
        return this;
    }

    public HostItemCustom setColorFilter(int colors) {
        imageView.setColorFilter(colors, PorterDuff.Mode.SRC_IN);
        return this;
    }

    public HostItemCustom setOrintaishan(boolean mod) {
        setOrientation(mod ? vertical : horizntal);
        setGravity(mod ? Gravity.CENTER : Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        return this;
    }
}
