package Ninja.coder.Ghostemane.code.widget;

import Ninja.coder.Ghostemane.code.R;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonViewLayout extends ScrollView {

    public static float TEXT_SIZE_DP = 18;
    int mode;
    float oldDist;
    private int ITEM_KEY_COLOR = Color.parseColor("#FF71CA35");
    private int OBJECT_KEY_COLOR = Color.parseColor("#FFFFFFFF");
    private int TEXT_COLOR = Color.parseColor("#FFF89978");
    private int NUMBER_COLOR = Color.parseColor("#FFDB8DFE");
    private int ARRAY_LENGTH_COLOR = Color.parseColor("#FFA9CEFF");
    private int BOOLEAN_COLOR = Color.parseColor("#FFCBA84A");
    private int NULL_COLOR = Color.parseColor("#FFC3928F");
    private int TEXT_SIZE_DP_MAX = 32;
    private int TEXT_SIZE_DP_MIN = 12;
    private int ARRAY_LENGTH_BACKGROUND = R.drawable.jsonview_select_bg;
    private Context mContext;
    private JSONObject mJSONObject;
    private JSONArray mJSONArray;
    private JsonView mjsonView;
    private LinearLayout contentView;
    private HorizontalScrollView horizontalScrollView;

    public JsonViewLayout(Context context) {
        super(context);
        initView(context);

    }

    public JsonViewLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        mjsonView = new JsonView(context, attrs);
    }

    public JsonViewLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        contentView = new LinearLayout(mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        contentView.setLayoutParams(layoutParams);
        contentView.setOrientation(LinearLayout.VERTICAL);
        horizontalScrollView = new HorizontalScrollView(mContext);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setLayoutParams(layoutParams);
        horizontalScrollView.setPadding(12, 12, 12, 0);
        horizontalScrollView.addView(contentView);
        this.addView(horizontalScrollView);

    }

    public void bindJson(String jsonStr) {
        if (canBindData()) {
            throw new IllegalArgumentException("JsonViweLayout can not bind again.");
        }
        Object object = null;
        try {
            object = new JSONTokener(jsonStr).nextValue();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (object != null && object instanceof JSONObject) {
            mJSONObject = (JSONObject) object;
        } else if (object != null && object instanceof JSONArray) {
            mJSONArray = (JSONArray) object;
        } else {
            throw new IllegalArgumentException("jsonStr is illegal.");
        }
        createView();
    }

    public void bindJson(JSONObject mJSONObject) {
        if (canBindData()) {
            throw new IllegalArgumentException("JsonViweLayout can not bind again.");
        }
        this.mJSONObject = mJSONObject;
        if (mJSONObject == null) {
            throw new IllegalArgumentException("jsonObject can not be null.");
        }
        createView();
    }

    public void bindJson(JSONArray mJSONArray) {
        if (canBindData()) {
            throw new IllegalArgumentException("JsonViweLayout can not bind again.");
        }
        this.mJSONArray = mJSONArray;
        if (mJSONArray == null) {
            throw new IllegalArgumentException("jsonArray can not be null.");
        }
        createView();
    }

    private boolean canBindData() {
        return null != mJSONObject || null != mJSONArray;
    }

    private void createView() {
        JsonView jsonView = new JsonView(mContext);
        //	jsonView.setImageEffect(true , "FFFF6760" , null);
        jsonView.showIcon(true);
        jsonView.hideValue();
        SpannableStringBuilder keyBuilder = new SpannableStringBuilder();

        keyBuilder.append("GhostWebJsonView");
        keyBuilder.setSpan(new ForegroundColorSpan(OBJECT_KEY_COLOR), 0, keyBuilder.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        jsonView.showKey(keyBuilder);
        Object value = null != mJSONObject ? mJSONObject : mJSONArray;
        jsonView.setIconClickListener(new JsonViewOnClickListener(value, jsonView, 0));
        contentView.addView(jsonView);
    }

    private void handleJsonObject(String key, Object value, JsonView itemView, int hierarchy) {
        SpannableStringBuilder keyBuilder = new SpannableStringBuilder();
        SpannableStringBuilder valueBuilder = new SpannableStringBuilder();
        itemView.hideIcon();
        //	itemView.setImageEffect(true , "FFFF6760" , itemView);
        if (value instanceof JSONObject) {
            itemView.showIcon(true);
            itemView.setIconClickListener(new JsonViewOnClickListener(value, itemView, hierarchy + 1));
            keyBuilder.append(key);
            keyBuilder.setSpan(new ForegroundColorSpan(OBJECT_KEY_COLOR), 0, keyBuilder.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            itemView.setCommand(getHierarchyStr(hierarchy + 1));
        } else {
            keyBuilder.append("\"").append(key).append("\"").append(":");
            keyBuilder.setSpan(new ForegroundColorSpan(ITEM_KEY_COLOR), 0, keyBuilder.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            if (value instanceof JSONArray) {
                itemView.showIcon(true);
                itemView.setIconClickListener(new JsonViewOnClickListener(value, itemView, hierarchy + 1));
                itemView.setCommand(getHierarchyStr(hierarchy));
                valueBuilder.append("\"" + ((JSONArray) value).length() + "\"");
                valueBuilder.setSpan(new ForegroundColorSpan(ARRAY_LENGTH_COLOR), 0, valueBuilder.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                itemView.showValue(valueBuilder);
                itemView.showArrayLength(ARRAY_LENGTH_BACKGROUND);
            } else {
                itemView.hideIcon();
                valueBuilder.append(value.toString());
                int valueColor;
                if (value instanceof String) {
                    valueColor = TEXT_COLOR;

                } else if (value instanceof Boolean) {
                    valueColor = BOOLEAN_COLOR;
                } else if (value instanceof Number) {
                    valueColor = NUMBER_COLOR;
                } else {
                    valueColor = NULL_COLOR;
                }
                valueBuilder.setSpan(new ForegroundColorSpan(valueColor), 0, valueBuilder.length(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                itemView.showValue(valueBuilder);
                itemView.setCommand(getHierarchyStr(hierarchy + 1));
            }
        }
        itemView.showKey(keyBuilder);
    }

    public void setTextSize(float sizeDP) {
        if (sizeDP < TEXT_SIZE_DP_MIN) {
            sizeDP = TEXT_SIZE_DP_MIN;
        } else if (sizeDP > TEXT_SIZE_DP_MAX) {
            sizeDP = TEXT_SIZE_DP_MAX;
        }
        if (TEXT_SIZE_DP != sizeDP) {
            TEXT_SIZE_DP = sizeDP;
            updateAll(sizeDP);
        }
    }

    public void updateAll(float textSize) {
        int count = this.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = contentView.getChildAt(i);
            loop(view, textSize);
        }
    }

    private void loop(View view, float textSize) {
        if (view instanceof JsonView) {
            JsonView group = (JsonView) view;
            group.setTextSize(textSize);
            int childCount = group.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view1 = group.getChildAt(i);
                loop(view1, textSize);
            }
        }
    }

    private void zoom(float f) {
        Log.d("tanzhenxing", "zoom = " + f);
        setTextSize(TEXT_SIZE_DP * (f / 100 + 1));
    }

    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean intercept = false;
        switch (event.getAction() & event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mode = 1;
                break;
            case MotionEvent.ACTION_UP:
                mode = 0;
                break;
            case MotionEvent.ACTION_POINTER_UP:
                intercept = true;
                mode -= 1;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                intercept = false;
                oldDist = spacing(event);
                mode += 1;
                break;

            case MotionEvent.ACTION_MOVE:
                if (mode >= 2) {
                    float newDist = spacing(event);
                    if (Math.abs(newDist - oldDist) > 3f) {
                        zoom(newDist - oldDist);
                        oldDist = newDist;
                    }
                }
                break;
        }
        return intercept ? intercept : super.dispatchTouchEvent(event);
    }

    public void setKeyColor(int color) {
        ITEM_KEY_COLOR = color;
    }

    public void setObjectKeyColor(int color) {
        OBJECT_KEY_COLOR = color;
    }

    public void setValueTextColor(int color) {
        TEXT_COLOR = color;
    }

    public void setValueNumberColor(int color) {
        NUMBER_COLOR = color;
    }

    public void setValueBooleanColor(int color) {
        BOOLEAN_COLOR = color;
    }

    public void setValueNullColor(int color) {
        NUMBER_COLOR = color;
    }

    public void setArrayLengthColor(int color) {
        ARRAY_LENGTH_COLOR = color;
    }

    private String getHierarchyStr(int hierarchy) {
        StringBuilder levelStr = new StringBuilder();
        for (int levelI = 0; levelI < hierarchy; levelI++) {
            levelStr.append("      ");
        }
        return levelStr.toString();
    }

    public void expandAll() {
        if (contentView != null) {
            clickAllView(contentView, false);
        }
    }

    public void collapseAll() {
        if (contentView != null) {
            clickAllView(contentView, true);
        }
    }

    private void clickAllView(ViewGroup viewGroup, boolean collapse) {
        if (viewGroup instanceof JsonView) {
            JsonView jsonView = (JsonView) viewGroup;
            operationJsonView(jsonView, collapse);
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View view = viewGroup.getChildAt(i);
            if (viewGroup instanceof JsonView) {
                JsonView jsonView = (JsonView) viewGroup;
                operationJsonView(jsonView, collapse);
            }
            if (view instanceof ViewGroup) {
                clickAllView((ViewGroup) view, collapse);
            }
        }
    }

    private void operationJsonView(JsonView jsonView, boolean collapse) {
        if (jsonView != null) {
            if (collapse) {
                jsonView.expand();
            } else {
                jsonView.collapse();
            }
        }
    }

    public void ScrollView(boolean f) {

        if (f) {
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
        } else {
            setHorizontalScrollBarEnabled(true);
            setVerticalScrollBarEnabled(true);
            setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);

        }

    }

    class JsonViewOnClickListener implements View.OnClickListener {
        private Object value;
        private JsonView itemView;
        private int hierarchy;

        private boolean isexpand = true;
        private boolean isJsonArray;

        public JsonViewOnClickListener(Object value, JsonView itemView, int hierarchy) {
            this.value = value;
            this.itemView = itemView;
            this.hierarchy = hierarchy;
            this.isJsonArray = value != null && value instanceof JSONArray;
        }

        @Override
        public void onClick(View v) {
            Object obj = v.getTag();
            if (obj != null && obj instanceof Boolean) {
                this.isexpand = (boolean) obj;
                v.setTag(null);
            }
            if (itemView.getChildCount() == 1) {
                JSONArray array = isJsonArray ? (JSONArray) value : ((JSONObject) value).names();
                if (null != array) {
                    this.isexpand = false;
                    if (!isJsonArray && array.length() == 1 && "nameValuePairs".equals(array.opt(0).toString())) {
                        Object nameValuePairs = ((JSONObject) value).opt("nameValuePairs");
                        if (null != nameValuePairs) {
                            value = nameValuePairs;
                            isJsonArray = value instanceof JSONArray;
                            array = isJsonArray ? (JSONArray) value : ((JSONObject) value).names();
                        }
                    }
                    for (int i = 0; array != null && i < array.length(); i++) {
                        JsonView childItemView = new JsonView(itemView.getContext());
                        Object childValue = array.opt(i);
                        if (isJsonArray) {
                            handleJsonObject(String.valueOf(i), childValue, childItemView, hierarchy);
                        } else {
                            handleJsonObject((String) childValue, ((JSONObject) value).opt((String) childValue),
                                    childItemView, hierarchy);
                        }
                        itemView.addViewNoInvalidate(childItemView);
                    }
                } else {
                    this.isexpand = !isexpand;
                }
                itemView.showIcon(isexpand);
                itemView.showPrograssBar(!isexpand);
                itemView.requestLayout();
                itemView.invalidate();
            } else {
                isexpand = !isexpand;
                itemView.showIcon(isexpand);
                itemView.showPrograssBar(isexpand);
                for (int i = 1; i < itemView.getChildCount(); i++) {
                    itemView.getChildAt(i).setVisibility(!isexpand ? View.VISIBLE : View.GONE);

                }
            }
        }
    }

}
