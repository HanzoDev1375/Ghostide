package ir.ninjacoder.ghostide.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

public class GhostWebCustomWebView extends WebView {

  public GhostWebCustomWebView(Context context) {

    super(context);
    install();
  }

  public GhostWebCustomWebView(Context context, AttributeSet attributeSet) {

    super(context, attributeSet);
    install();
  }

  public GhostWebCustomWebView(Context context, AttributeSet attributeSet, int in) {
    super(context, attributeSet, in);
    install();
  }

  public void install() {

    getSettings().setJavaScriptEnabled(true);
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().setDomStorageEnabled(true);
    getSettings().setSaveFormData(true);
    getSettings().setSavePassword(true);
    getSettings().setBuiltInZoomControls(true);
    getSettings().setDisplayZoomControls(false);
    getSettings().setGeolocationEnabled(true);
    setWebContentsDebuggingEnabled(true);

    CookieManager.getInstance().setAcceptCookie(true);
  }

  public void Andoidvspc(boolean fff) {

    if (fff) {

      WebSettings webSettings = getSettings();
      String newUserAgent;
      newUserAgent =
          "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36";
      webSettings.setUserAgentString(newUserAgent);

    } else {
      WebSettings webSettings2 = getSettings();
      String newUserAgent2;
      newUserAgent2 =
          "Mozilla/5.0 (Linux; Android 7.0; SM-G570M Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/69.0.3497.100 Mobile Safari/537.36 [FB_IAB/FB4A;FBAV/192.0.0.34.85;]";
      webSettings2.setUserAgentString(newUserAgent2);
    }
  }

  public void WebDrakModOn() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

      ///// webview drak mod on
      if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK))
        ;
      WebSettingsCompat.setForceDark(getSettings(), WebSettingsCompat.FORCE_DARK_ON);

    } else {
      Log.w("", "");
    }
  }

  public void WebViewDrakModOff() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK))
        ;
      WebSettingsCompat.setForceDark(getSettings(), WebSettingsCompat.FORCE_DARK_OFF);
    } else {

      Log.e("Error not Runing ", "Android 10 up");
    }
  }
}

class nu {}

class prot {}
