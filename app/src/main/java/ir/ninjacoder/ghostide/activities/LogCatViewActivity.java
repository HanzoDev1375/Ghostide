package ir.ninjacoder.ghostide.activities;

import ir.ninjacoder.ghostide.R;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.github.pedrovgs.lynx.LynxConfig;
import com.github.pedrovgs.lynx.LynxShakeDetector;
import com.github.pedrovgs.lynx.LynxView;
import com.google.android.material.appbar.MaterialToolbar;

public class LogCatViewActivity extends BaseCompat {

  private static final String LYNX_CONFIG_EXTRA = "extra_lynx_config";
  protected MaterialToolbar logcattoolbar;
  private LynxView post;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.logcatview);
    reloadId();
    runer();
  }

  private void reloadId() {
    post = findViewById(R.id.post);
    logcattoolbar = findViewById(R.id.logcattoolbar);
    setSupportActionBar(logcattoolbar);
    post.showItems(false);
    setTitle("Log cat view");
  }

  private void runer() {
    LynxConfig lynxConfig = getLynxConfig();
    _configureLynxView(lynxConfig);
    _disableLynxShakeDetector();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    _enableLynxShakeDetector();
  }

  private LynxConfig getLynxConfig() {
    Bundle extras = getIntent().getExtras();
    LynxConfig lynxConfig = new LynxConfig();
    if (extras != null && extras.containsKey(LYNX_CONFIG_EXTRA)) {
      lynxConfig = (LynxConfig) extras.getSerializable(LYNX_CONFIG_EXTRA);
    }
    return lynxConfig;
  }

  public void _enableLynxShakeDetector() {
    LynxShakeDetector.enable();
  }

  public void _disableLynxShakeDetector() {
    LynxShakeDetector.disable();
  }

  public void _configureLynxView(final LynxConfig _lynxConfig) {
    LynxView lynxView = (LynxView) findViewById(R.id.post);
    lynxView.setLynxConfig(_lynxConfig);
  }

  public void showMessage(String _s) {
    Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // TODO: Implement this method
    getMenuInflater().inflate(R.menu.log_catmenu, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem menuitem) {
    // TODO: Implement this method
    var id = menuitem.getItemId();
    if (id == R.id.itemshow) {
      post.showItems(!menuitem.isChecked());
      menuitem.setChecked(!menuitem.isChecked());
      return true;
    } else if (id == R.id.log_cat_clear) {
      post.post(
          () -> {
            if (post != null) post.clear();
          });
      return true;
    } else if (id == R.id.autoScroll) {
      itemShowingSrc(!menuitem.isChecked());
      menuitem.setChecked(!menuitem.isChecked());
    }
    return super.onOptionsItemSelected(menuitem);
  }

  public boolean itemShowingSrc(boolean r) {
    if (r) {
      post.post(
          () -> {
            post.enableAutoScroll();
          });
      return true;
    } else {
      post.disableAutoScroll();
      return false;
    }
  }
}
