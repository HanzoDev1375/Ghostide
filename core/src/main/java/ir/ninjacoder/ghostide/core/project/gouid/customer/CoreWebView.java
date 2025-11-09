package project.gouid.customer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.Map;

/*

code By Ninja coder

*/

public class CoreWebView extends WebView {

  public CoreWebView(Context context) {
    super(context);
    init();
  }

  public CoreWebView(Context context, AttributeSet b) {
    super(context, b);
    init();
  }

  public CoreWebView(Context context, AttributeSet b, int c) {
    super(context, b, c);
    init();
  }

  protected void init() {
    installUrl(true);
    setMobileMod(true);
  }

  public void getUrl(String url) {
    loadUrl(url);
  }

  public void getUrl(String url, Map map) {

    loadUrl(url, map);
  }

  public void getUrlDataBase(String arg0, String arg1, String arg2, String arg3, String arg4) {
    loadDataWithBaseURL(arg0, arg1, arg2, arg3, arg4);
  }

  public void installUrl(boolean br) {

    getSettings().setJavaScriptEnabled(br);
    getSettings().setBuiltInZoomControls(br);
    getSettings().setDisplayZoomControls(false);
  }

  public void setMobileMod(boolean vr) {
    getSettings().setUseWideViewPort(vr);
    getSettings().setLoadWithOverviewMode(vr);
  }

  public void setPcMode(boolean vrs) {

    getSettings().setUseWideViewPort(vrs);
    getSettings().setLoadWithOverviewMode(vrs);
  }

  public void getTitleWebView(String input, TextView tv1) {

    setWebChromeClient(
        new WebChromeClient() {
          @Override
          public void onReceivedTitle(WebView view, String sTitle) {
            super.onReceivedTitle(view, sTitle);
            if (sTitle != null && sTitle.length() > 0) {
              tv1.setText(sTitle);
            } else {
              tv1.setText(input);
            }
          }
        });
  }

  protected interface pu {

    void pro(Object b);

    void onClickWebview(View onClick);
  }
}
