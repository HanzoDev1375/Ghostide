package com.mcal.webview.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;

public class WebViewNestedScroll extends WebView implements NestedScrollingChild {
  private int mLastMotionY = 0;
  private int[] mScrollOffset = new int[2];
  private int[] mScrollConsumed = new int[2];
  private int mNestedYOffset = 0;
  private NestedScrollingChildHelper mChildHelper;

  public WebViewNestedScroll(Context context) {
    super(context);
    mChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
    initialize();
  }

  public WebViewNestedScroll(Context context, AttributeSet attrs) {
    super(context, attrs);
    mChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
    initialize();
  }

  public WebViewNestedScroll(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mChildHelper = new NestedScrollingChildHelper(this);
    setNestedScrollingEnabled(true);
    initialize();
  }

  @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
  private void initialize() {
    WebSettings settings = getSettings();
    if (settings != null) {
      settings.setAllowFileAccess(true);
      settings.setAllowContentAccess(true);
      settings.setJavaScriptEnabled(true);
      settings.setJavaScriptCanOpenWindowsAutomatically(true);
      settings.setDisplayZoomControls(false);
      settings.setBuiltInZoomControls(true);
      // setUserAgentString(USER_AGENT)
      settings.setSerifFontFamily("sans-serif");

      settings.setUseWideViewPort(true);
      settings.setLoadWithOverviewMode(true);
      settings.setPluginState(WebSettings.PluginState.ON);
      settings.setMediaPlaybackRequiresUserGesture(true);
      settings.setDomStorageEnabled(true);
      settings.setDatabaseEnabled(true);
      settings.setGeolocationEnabled(true);
      settings.setGeolocationDatabasePath(getContext().getFilesDir().getPath());
      settings.setAllowFileAccessFromFileURLs(true);
      settings.setAllowUniversalAccessFromFileURLs(true);
      settings.setSupportMultipleWindows(true);
      settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
      settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
    }

    CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
    CookieManager.getInstance().setAcceptCookie(true);
    setLayerType(LAYER_TYPE_HARDWARE, null);
  }

  @SuppressLint("ClickableViewAccessibility")
  @Override
  public boolean onTouchEvent(MotionEvent event) {
    boolean result = false;
    MotionEvent trackedEvent = MotionEvent.obtain(event);
    int action = MotionEventCompat.getActionMasked(event);
    if (action == MotionEvent.ACTION_DOWN) {
      mNestedYOffset = 0;
    }
    int y = (int) event.getY();
    event.offsetLocation(0f, mNestedYOffset);
    switch (action) {
      case MotionEvent.ACTION_DOWN:
        {
          mLastMotionY = y;
          startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL);
          result = super.onTouchEvent(event);
          break;
        }
      case MotionEvent.ACTION_MOVE:
        {
          int deltaY = mLastMotionY - y;
          if (dispatchNestedPreScroll(0, deltaY, mScrollConsumed, mScrollOffset)) {
            deltaY -= mScrollConsumed[1];
            trackedEvent.offsetLocation(0f, mScrollOffset[1]);
            mNestedYOffset += mScrollOffset[1];
          }
          mLastMotionY = y - mScrollOffset[1];

          int oldY = getScrollY();
          int newScrollY = Math.max(0, oldY + deltaY);
          int dyConsumed = newScrollY - oldY;
          int dyUnconsumed = deltaY - dyConsumed;
          if (dispatchNestedScroll(0, dyConsumed, 0, dyUnconsumed, mScrollOffset)) {
            mLastMotionY -= mScrollOffset[1];
            trackedEvent.offsetLocation(0f, mScrollOffset[1]);
            mNestedYOffset += mScrollOffset[1];
          }
          result = super.onTouchEvent(trackedEvent);
          trackedEvent.recycle();
          break;
        }
      case MotionEvent.ACTION_POINTER_DOWN:
      case MotionEvent.ACTION_POINTER_UP:
      case MotionEvent.ACTION_UP:
      case MotionEvent.ACTION_CANCEL:
        {
          stopNestedScroll();
          result = super.onTouchEvent(event);
          break;
        }
    }
    return result;
  }

  @Override
  public void setNestedScrollingEnabled(boolean enabled) {
    mChildHelper.setNestedScrollingEnabled(enabled);
  }

  @Override
  public boolean isNestedScrollingEnabled() {
    return mChildHelper.isNestedScrollingEnabled();
  }

  @Override
  public boolean startNestedScroll(int axes) {
    return mChildHelper.startNestedScroll(axes);
  }

  @Override
  public void stopNestedScroll() {
    mChildHelper.stopNestedScroll();
  }

  @Override
  public boolean hasNestedScrollingParent() {
    return mChildHelper.hasNestedScrollingParent();
  }

  @Override
  public boolean dispatchNestedScroll(
      int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
    return mChildHelper.dispatchNestedScroll(
        dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
  }

  @Override
  public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
    return mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
  }

  @Override
  public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
    return mChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
  }

  @Override
  public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
    return mChildHelper.dispatchNestedPreFling(velocityX, velocityY);
  }
}
