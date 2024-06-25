package Ninja.coder.Ghostemane.code.widget;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.material.color.MaterialColors;

import java.util.Timer;
import java.util.TimerTask;

/*
 *Fix all bug by Ninja coder .ir
 * این کتابخونه برای گوست وب است
 * In library for ghost web app
 */

public class JsonView extends LinearLayout {
    protected Timer timer = new Timer();
    protected TimerTask task;
    protected ProgressBar item_prograssbar_jsonview;
    protected ObjectAnimator obj;
    protected ObjectAnimator obc;
    private ImageView imageview;
    private TextView keyTV, valueTV, commandTV;
    private View contentView;
    private Context mContext;

    public JsonView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public JsonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }

    public JsonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOrientation(VERTICAL);
        LayoutInflater.from(mContext).inflate(R.layout.item_view_jsonview_layout, this, true);
        imageview = (ImageView) findViewById(R.id.icon);
        keyTV = (TextView) findViewById(R.id.key);
        valueTV = (TextView) findViewById(R.id.value);
        commandTV = (TextView) findViewById(R.id.command);
        contentView = findViewById(R.id.content);
        item_prograssbar_jsonview = findViewById(R.id.item_prograssbar_jsonview);
        contentView.setBackgroundColor(Color.TRANSPARENT);
        setImageEffect(true, imageview);
        imageview.setVisibility(GONE);
        keyTV.setVisibility(GONE);
        valueTV.setVisibility(GONE);
        keyTV.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "ghostfont.ttf"));
        valueTV.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "ghostfont.ttf"));
        commandTV.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "ghostfont.ttf"));
        setTextSize(JsonViewLayout.TEXT_SIZE_DP);
        AnimatorSet();
    }

    public void setTextSize(float textSizeDp) {
        JsonViewLayout.TEXT_SIZE_DP = (int) textSizeDp;
        keyTV.setTextSize(JsonViewLayout.TEXT_SIZE_DP);
        valueTV.setTextSize(JsonViewLayout.TEXT_SIZE_DP);
        commandTV.setTextSize(JsonViewLayout.TEXT_SIZE_DP);
        int textSize =
                (int)
                        TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP,
                                JsonViewLayout.TEXT_SIZE_DP,
                                getResources().getDisplayMetrics());
        LinearLayout.LayoutParams layoutParams =
                (LinearLayout.LayoutParams) imageview.getLayoutParams();
        layoutParams.height = textSize;
        layoutParams.width = textSize;
        setImageEffect(true, imageview);
        int rightMargin =
                (int)
                        TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP,
                                JsonViewLayout.TEXT_SIZE_DP / 4,
                                getResources().getDisplayMetrics());
        layoutParams.rightMargin = rightMargin;
        layoutParams.gravity = Gravity.CENTER_VERTICAL;
        imageview.setLayoutParams(layoutParams);
        item_prograssbar_jsonview.setLayoutParams(layoutParams);
    }

    public void setCommand(CharSequence sequence) {
        commandTV.setText(sequence);
    }

    public void hideIcon() {
        imageview.setVisibility(GONE);
        //  item_prograssbar_jsonview.setVisibility(GONE);
    }

    public void showIcon(boolean canExpand) {

        imageview.setVisibility(VISIBLE);
        imageview.setImageResource(canExpand ? R.drawable.mr : R.drawable.md);
        //   item_prograssbar_jsonview.setVisibility(GONE);
    }

    public void hideValue() {
        valueTV.setVisibility(GONE);
    }

    public void showValue(CharSequence s) {
        valueTV.setVisibility(VISIBLE);
        valueTV.setText(s);
        valueTV.setBackgroundColor(Color.TRANSPARENT);
    }

    public void showArrayLength(int resId) {
        valueTV.setBackgroundResource(resId);
    }

    public void showKey(CharSequence s) {
        keyTV.setVisibility(VISIBLE);
        keyTV.setText(s);
    }

    public void setIconClickListener(View.OnClickListener listener) {
        imageview.setOnClickListener(listener);
    }

    public void expand() {
        imageview.setTag(false);
        imageview.callOnClick();
        imageview.animate().scaleX(10).setDuration(1000).start();
        item_prograssbar_jsonview.setVisibility(VISIBLE);
    }

    public void collapse() {
        imageview.setTag(true);
        imageview.callOnClick();
        imageview.animate().scaleY(-10).setDuration(1000).start();
        item_prograssbar_jsonview.setVisibility(GONE);
    }

    public void addViewNoInvalidate(View child) {
        try {

            ViewGroup.LayoutParams params = child.getLayoutParams();
            if (params == null) {
                params = generateDefaultLayoutParams();
                if (params == null) {
                }
            }
            addViewInLayout(child, -1, params);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    public void setImageEffect(boolean s, View view) {

        ColorStateList colorStateList =
                new ColorStateList(
                        new int[][]{new int[]{}},
                        new int[]{MaterialColors.getColor(getContext(), ColorAndroid12.TvColor, 0)});
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList, null, null);
        view.setBackground(rippleDrawable);
    }

    protected void AnimatorSet() {
    }

    public ProgressBar getItem_prograssbar_jsonview() {
        if (item_prograssbar_jsonview != null) {
            return this.item_prograssbar_jsonview;
        }
        return null;
    }

    public void showPrograssBar(boolean isShow) {
        item_prograssbar_jsonview.setVisibility(isShow ? VISIBLE : GONE);
    }
}
