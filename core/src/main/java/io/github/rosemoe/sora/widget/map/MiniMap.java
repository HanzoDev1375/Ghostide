package io.github.rosemoe.sora.widget.map;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.widget.CodeEditor;

public class MiniMap {
  private CodeEditor mMainEditor;
  private CodeEditor mMiniMapEditor;
  private FrameLayout mMiniMapContainer;
  private boolean mVisible = true;
  private boolean mIsInitialized = false;

  public MiniMap(CodeEditor mainEditor) {
    mMainEditor = mainEditor;
  }

  public void initialize() {
    if (mIsInitialized) return;

    setupMiniMap();
    mIsInitialized = true;
  }

  private void setupMiniMap() {
    Context context = mMainEditor.getContext();

    mMiniMapContainer = new FrameLayout(context);
    FrameLayout.LayoutParams params =
        new FrameLayout.LayoutParams(
            200, // عرض
            ViewGroup.LayoutParams.MATCH_PARENT);
    params.gravity = Gravity.RIGHT;
    mMiniMapContainer.setLayoutParams(params);

    // ایجاد یک CodeEditor ساده برای مینی‌مپ
    mMiniMapEditor = new CodeEditor(context);

    FrameLayout.LayoutParams editorParams =
        new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    editorParams.setMargins(4, 4, 4, 4);
    mMiniMapEditor.setLayoutParams(editorParams);

    // اضافه کردن ادیتور به کانتینر
    mMiniMapContainer.addView(mMiniMapEditor);
    mMiniMapContainer.setBackgroundColor(Color.parseColor("#14636262"));
    // اضافه کردن به والد اصلی (با بررسی null)
    ViewGroup parent = (ViewGroup) mMainEditor.getParent();
    if (parent != null) {
      parent.addView(mMiniMapContainer);
    }
    setupMiniMapEditor();
  }

  private void setupMiniMapEditor() {
    if (mMiniMapEditor == null) return;

    mMiniMapEditor.setText(mMainEditor.getTextAsString());
    mMiniMapEditor.setColorScheme(mMainEditor.getColorScheme());
    mMiniMapEditor.setEditorLanguage(mMainEditor.getEditorLanguage());
    mMiniMapEditor.setTypefaceText(mMainEditor.getTypefaceText());
    mMiniMapEditor.setTextSizePx(mMainEditor.getTextSizePx() * 0.1f);
    mMiniMapEditor.setLineNumberEnabled(false);
    mMiniMapEditor.setEditable(false);
    mMiniMapEditor.setAutoCompletionEnabled(false);
    mMiniMapEditor.setWordwrap(false);
    mMiniMapEditor.setScrollBarEnabled(false);
    mMiniMapEditor.setFocusable(false);
    mMiniMapEditor.setAutoCompletionEnabled(false);
    mMiniMapEditor.setClickable(false);
    mMiniMapEditor.setLongClickable(false);
    mMiniMapEditor.setMiniMapEnabled(false);
    mMainEditor.subscribeEvent(
        ContentChangeEvent.class,
        (c, d) -> {
          update();
        });
    update();
  }

  public void update() {
    if (mMiniMapEditor != null && mMainEditor != null) {
      mMiniMapEditor.setText(mMainEditor.getTextAsString());
      mMiniMapEditor.setScrollX((int) (mMainEditor.getOffsetX() * 0.1f));
      mMiniMapEditor.setScrollY((int) (mMainEditor.getOffsetY() * 0.1f));
    }
  }

  public boolean onTouchEvent(MotionEvent event) {
    if (!mVisible || mMiniMapContainer == null || mMainEditor == null) return false;

    float x = event.getX();
    float y = event.getY();

    // بررسی آیا ضربه در ناحیه مینی‌مپ است
    if (x < mMainEditor.getWidth() - mMiniMapContainer.getWidth()) return false;

    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
      case MotionEvent.ACTION_MOVE:
        float relativeY = y / mMainEditor.getHeight();
        int newScrollY =
            (int)
                (relativeY * mMainEditor.getLayout().getLayoutHeight()
                    - mMainEditor.getHeight() / 2);
        newScrollY = Math.max(0, Math.min(newScrollY, mMainEditor.getScrollMaxY()));

        mMainEditor
            .getScroller()
            .startScroll(
                mMainEditor.getOffsetX(),
                mMainEditor.getOffsetY(),
                0,
                newScrollY - mMainEditor.getOffsetY());
        mMainEditor.invalidate();
        return true;
    }
    return false;
  }

  public void setVisible(boolean visible) {
    mVisible = visible;
    if (mMiniMapContainer != null) {
      mMiniMapContainer.setVisibility(visible ? View.VISIBLE : View.GONE);
    }
  }

  public boolean isVisible() {
    return mVisible;
  }
}
