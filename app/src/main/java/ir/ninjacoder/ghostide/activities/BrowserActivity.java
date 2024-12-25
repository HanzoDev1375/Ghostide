package ir.ninjacoder.ghostide.activities;

import ir.ninjacoder.ghostide.NetworkChangeReceiver;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.layoutmanager.WebViewCompatGhostWeb;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.activity.OnBackPressedCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;

public class BrowserActivity extends BaseCompat implements NetworkChangeReceiver.CallBackNetWork {
  protected LinearLayout layout1, emptyView;
  protected ProgressBar bar;
  protected WebViewCompatGhostWeb view;
  protected AppBarLayout appbar;
  protected MaterialToolbar toolbar;
  private NetworkChangeReceiver networkChangeReceiver;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.browser);
    layout1 = findViewById(R.id.browers_main_layout);
    bar = findViewById(R.id.bar);
    view = findViewById(R.id.myweb);
    appbar = findViewById(R.id.appbar);
    toolbar = findViewById(R.id.toolbar);
    emptyView = findViewById(R.id.emptyView);
    setSupportActionBar(toolbar);
    installLoder();
    callBack();
  }

  public void callBack() {

    getOnBackPressedDispatcher()
        .addCallback(
            this,
            new OnBackPressedCallback(true) {

              @Override
              public void handleOnBackPressed() {
                if (view.canGoBack()) {
                  view.goBack();
                } else {
                  finish();
                }
              }
            });
  }

  public void installLoder() {

    toolbar.setTitleTextColor(MaterialColors.getColor(toolbar, ObjectUtils.TvColor));
    toolbar.setBackgroundTintList(
        ColorStateList.valueOf(MaterialColors.getColor(toolbar, ObjectUtils.Back)));
    toolbar.setNavigationIcon(R.drawable.closehsi);
    toolbar.setNavigationIconTint(MaterialColors.getColor(toolbar, ObjectUtils.TvColor));
    toolbar.setTitleCentered(true);
    toolbar.setNavigationOnClickListener(v -> finish());
    toolbar.setSubtitleCentered(true);

    toolbar.setOverflowIcon(getDrawable(R.drawable.border_color));
    setTitle("Ghost web Browers");
    toolbar.setTitleMargin(2, 2, 2, 2);
    view.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    view.getSettings().setJavaScriptEnabled(true);
    view.getSettings().setBuiltInZoomControls(true);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
      view.getSettings().setAlgorithmicDarkeningAllowed(true);
    }
    view.getSettings().setAllowFileAccess(true);
    view.getSettings().setLoadWithOverviewMode(true);
    networkChangeReceiver = new NetworkChangeReceiver(this);
    IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
    this.registerReceiver(networkChangeReceiver, filter);

    view.setWebViewClient(
        new WebViewClient() {
          @Override
          public void onPageStarted(WebView web, String str, Bitmap icon) {

            super.onPageStarted(web, str, icon);
          }

          @Override
          public void onPageFinished(WebView web, String strs) {
            final String url = strs;
            bar.setVisibility(View.GONE);

            toolbar.setSubtitle(web.getUrl());

            super.onPageFinished(web, strs);
          }
        });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.browersmenu_item, menu);

    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem menu) {
    // TODO: Implement this method
    int id = menu.getItemId();
    if (id == R.id.reload) {
      view.loadUrl(getIntent().getStringExtra("test"));
      bar.setVisibility(View.VISIBLE);
      return true;
    } else if (id == R.id.back_to_home) {
      callBack();
      return true;
    }

    return super.onOptionsItemSelected(menu);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    // Unregister the NetworkChangeReceiver when the activity is destroyed
    this.unregisterReceiver(networkChangeReceiver);
  }

  @Override
  public void ConnectionIS() {
    // TODO: Implement this method
    emptyView.setVisibility(View.GONE);
    view.setVisibility(View.VISIBLE);
    if (getIntent().hasExtra("test")) {
      view.loadUrl(getIntent().getStringExtra("test"));
    }
    bar.setVisibility(View.VISIBLE);
  }

  @Override
  public void ConnectionNOT() {
    // TODO: Implement this method
    emptyView.setVisibility(View.VISIBLE);
    view.setVisibility(View.GONE);
    bar.setVisibility(View.GONE);
  }
}
