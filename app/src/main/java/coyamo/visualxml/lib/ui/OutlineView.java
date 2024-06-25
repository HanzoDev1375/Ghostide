package coyamo.visualxml.lib.ui;
/**
 * Copyright (C) 2020 Coyamo
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OutlineView extends LinearLayout {
    public static final int DISPLAY_VIEW = 0;
    public static final int DISPLAY_DESIGN = 1;
    public static final int DISPLAY_BLUEPRINT = 2;
    private Paint paint;
    private boolean interceptTouchEvent = true;
    private int displayType = DISPLAY_DESIGN;

    private OnOutlineClickListener outlineClickListener;
    // private OnOutlineLongClickListener outlineLongClickListener;
    //排序后作为标记 防止多余的排序
    private boolean isSorted;
    private boolean isSelect;
    private boolean isHoldOutline = true;
    private View selectView;
    private Rect selectedRect;
    private List<Pair<View, Rect>> pairArrayList = new ArrayList<>();

    public OutlineView(Context ctx) {
        super(ctx);
        init();
    }

    public OutlineView(Context ctx, AttributeSet a) {
        super(ctx, a);
        init();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return interceptTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //允许传递点击事件时不触发选中事件
                if (!interceptTouchEvent) return super.onTouchEvent(event);
                if (!isSorted) sort(pairArrayList);
                for (Pair<View, Rect> pair : pairArrayList) {
                    if (isInRect(pair.second, event.getRawX(), event.getRawY())) {
                        selectedRect = pair.second;
                        isSelect = true;
                        selectView = pair.first;
                        if (outlineClickListener != null)
                            outlineClickListener.onDown(selectView, displayType);
                        invalidate();
                        return true;
                    }
                }
                isSelect = false;
                break;
            case MotionEvent.ACTION_CANCEL:
                if (isSelect) {
                    if (outlineClickListener != null)
                        outlineClickListener.onCancel(selectView, displayType);
                    if (!isHoldOutline) {
                        removeSelect();
                    }

                }
                break;
            case MotionEvent.ACTION_UP:
                //在松手时触发
                //必须是在rect内
                if (isSelect) {
                    if (isInRect(selectedRect, event.getRawX(), event.getRawY()) && outlineClickListener != null) {
                        outlineClickListener.onClick(selectView, displayType);
                    } else {
                        if (outlineClickListener != null)
                            outlineClickListener.onCancel(selectView, displayType);
                    }


                }
                if (!isHoldOutline) {
                    removeSelect();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    //xy相对于屏幕
    private boolean isInRect(Rect rect, float x, float y) {
        Rect r = new Rect();
        getGlobalVisibleRect(r);

        //转化为相对OutlineView的坐标
        x = x - r.left;
        y = y - r.top;

        return x > rect.left && x < rect.right && y > rect.top && y < rect.bottom;
    }


    //按面积排序，小的在前
    private void sort(List<Pair<View, Rect>> pairArrayList) {
        Collections.sort(pairArrayList, new Comparator<Pair<View, Rect>>() {
            @Override
            public int compare(Pair<View, Rect> o1, Pair<View, Rect> o2) {
                int w1 = o1.second.right - o1.second.left;
                int h1 = o1.second.bottom - o1.second.top;
                int size1 = w1 * h1;

                int w2 = o2.second.right - o2.second.left;
                int h2 = o2.second.bottom - o2.second.top;
                int size2 = w2 * h2;

                return size1 - size2;
            }
        });
        //标记
        isSorted = true;
       /* for(Pair<View,Rect> pair:pairArrayList){
            int w1=pair.second.right-pair.second.left;
            int h1=pair.second.bottom-pair.second.top;
            int size1=w1*h1;
            Log.d("debug",w1+"*"+h1+"="+size1);
        }*/

    }

    /**
     * 判断在触发选中边框后是否保留边框
     *
     * @return
     */
    public boolean isHoldOutline() {
        return isHoldOutline;
    }

    /**
     * 设置在触发选中边框后是否保留边框
     *
     * @param holdOutline
     */
    public void setHoldOutline(boolean holdOutline) {
        isHoldOutline = holdOutline;
    }


    /**
     * 获取显示的类型
     *
     * @return
     */
    public int getDisplayType() {
        return displayType;
    }

    /**
     * 设置显示的类型
     *
     * @param displayType
     */
    public void setDisplayType(int displayType) {
        switch (displayType) {
            case DISPLAY_BLUEPRINT:
            case DISPLAY_DESIGN:
                setInterceptTouchEvent(true);
                break;
            case DISPLAY_VIEW:
                setInterceptTouchEvent(false);
                break;
        }
        this.displayType = displayType;
        invalidate();
    }

    /**
     * 是否拦截子View触摸事件
     *
     * @return
     */
    public boolean isInterceptTouchEvent() {
        return interceptTouchEvent;
    }

    /**
     * 设置是否拦截子View触摸事件
     *
     * @param interceptTouchEvent
     */
    public void setInterceptTouchEvent(boolean interceptTouchEvent) {
        this.interceptTouchEvent = interceptTouchEvent;
    }

    private void init() {
        setWillNotDraw(false);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        setFocusable(true);
    }

    /**
     * 如果View在group内。就显示选中的边框
     *
     * @param v
     */
    public void select(View v) {
        for (Pair<View, Rect> pair : pairArrayList) {
            if (v == pair.first) {
                selectedRect = pair.second;
                selectView = v;
            }
        }

    }

    /**
     * 移除选中状态
     */
    public void removeSelect() {
        selectedRect = null;
        selectView = null;
        invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {

        switch (displayType) {
            case DISPLAY_BLUEPRINT:
                toBlueprintPaint();
                for (Pair<View, Rect> bound : pairArrayList) {
                    canvas.drawRect(fixRect(bound.second), paint);
                }
                break;
            case DISPLAY_DESIGN:
                super.dispatchDraw(canvas);
                for (Pair<View, Rect> bound : pairArrayList) {
                    if (selectedRect != null && selectedRect.equals(bound.second)) {
                        toSelectPaint();
                        //绘制4个球球
                        int r = 10;
                        int cx = (selectedRect.left + selectedRect.right) / 2;
                        int cy = (selectedRect.bottom + selectedRect.top) / 2;
                        //top
                        canvas.drawCircle(cx, selectedRect.top + paint.getStrokeWidth() / 2, r, paint);
                        //bottom
                        canvas.drawCircle(cx, selectedRect.bottom - paint.getStrokeWidth() / 2, r, paint);
                        //left
                        canvas.drawCircle(selectedRect.left + paint.getStrokeWidth() / 2, cy, r, paint);
                        //right
                        canvas.drawCircle(selectedRect.right - paint.getStrokeWidth() / 2, cy, r, paint);

                        paint.setStyle(Paint.Style.STROKE);
                    } else {
                        toDesignPaint();
                    }
                    canvas.drawRect(fixRect(bound.second), paint);
                }
                break;
            case DISPLAY_VIEW:
                super.dispatchDraw(canvas);
                break;
        }
    }

    private Rect fixRect(Rect rect) {
        Rect r = new Rect(rect);
        int half = (int) paint.getStrokeWidth() / 2;
        r.left += half;
        r.top += half;
        r.right -= half;
        r.bottom -= half;
        return r;
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        refreshOutline();
        //重置标记
        isSorted = false;
        selectedRect = null;
    }

    private void refreshOutline() {
        pairArrayList.clear();
        refreshOutline(OutlineView.this, OutlineView.this);
    }

    //递归查找view位置
    private void refreshOutline(ViewGroup v, ViewGroup topView) {
        for (int i = 0; i < v.getChildCount(); i++) {
            View child = v.getChildAt(i);
            Rect rect = new Rect();
            Rect topRect = new Rect();
            child.getGlobalVisibleRect(rect);
            topView.getGlobalVisibleRect(topRect);
            //相对于屏幕的坐标
            //要限制在OutlineView内
            //所以要减去偏移的坐标得到真实位置
            rect.top -= topRect.top;
            rect.left -= topRect.left;
            rect.right -= topRect.left;
            rect.bottom -= topRect.top;

            pairArrayList.add(new Pair<>(child, rect));
            if (child instanceof ViewGroup) {
                refreshOutline((ViewGroup) child, topView);
            }
        }

    }

    private void toBlueprintPaint() {
        paint.setStyle(Paint.Style.STROKE);
        paint.setPathEffect(new DashPathEffect(new float[]{5, 5}, 0));
        paint.setStrokeWidth(2);
        paint.setColor(0xff40c4ff);
    }

    private void toDesignPaint() {
        paint.setStyle(Paint.Style.STROKE);
        paint.setPathEffect(new DashPathEffect(new float[]{5, 5}, 0));
        paint.setStrokeWidth(1);
        paint.setColor(Color.GRAY);
    }

    private void toSelectPaint() {
        paint.setStyle(Paint.Style.FILL);
        paint.setPathEffect(null);
        paint.setStrokeWidth(4);
        paint.setColor(0xFF1886f7);
    }

    public OnOutlineClickListener getOutlineClickListener() {
        return outlineClickListener;
    }

    public void setOutlineClickListener(OnOutlineClickListener outlineClickListener) {
        this.outlineClickListener = outlineClickListener;
    }

    public interface OnOutlineClickListener {
        void onDown(View v, int displayType);

        void onCancel(View v, int displayType);

        void onClick(View v, int displayType);
    }


   /* public OnOutlineLongClickListener getOutlineLongClickListener() {
        return outlineLongClickListener;
    }

    public void setOutlineLongClickListener(OnOutlineLongClickListener outlineLongClickListener) {
        this.outlineLongClickListener = outlineLongClickListener;
    }

    public interface OnOutlineLongClickListener {
        boolean onLongClick(View v, int displayType);
    }*/

}
