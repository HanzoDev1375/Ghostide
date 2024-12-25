package ir.ninjacoder.ghostide.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

public class ScrollViewCustom extends HorizontalScrollView {

    public ScrollViewCustom(Context context) {
        super(context);
        init();
    }

    public ScrollViewCustom(Context context, AttributeSet a) {
        super(context, a);
        init();
    }

    public ScrollViewCustom init() {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        return this;
    }

}