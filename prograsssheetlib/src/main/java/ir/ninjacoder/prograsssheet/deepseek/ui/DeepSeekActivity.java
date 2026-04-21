package ir.ninjacoder.prograsssheet.deepseek.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import ir.ninjacoder.prograsssheet.R;
import androidx.fragment.app.Fragment;
import com.google.android.material.snackbar.Snackbar;
import ir.ninjacoder.prograsssheet.deepseek.setting.PrefManager;

public class DeepSeekActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_deepseek);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    if (savedInstanceState == null) {
      loadChatFragment();
    }
    checkApiKeyOnFirstRun();
  }

  private void loadChatFragment() {
    ChatFragment chatFragment = new ChatFragment();
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.fragmentContainer, chatFragment)
        .commit();
  }

  private void checkApiKeyOnFirstRun() {
    PrefManager prefManager = PrefManager.getInstance(this);
    if (!prefManager.hasApiKey()) {
      Snackbar.make(
              findViewById(android.R.id.content),
              "برای شروع، لطفاً API Key را در تنظیمات وارد کنید",
              Snackbar.LENGTH_INDEFINITE)
          .setAction(
              "setting",
              v -> {
                
                Fragment fragment =
                    getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
                if (fragment instanceof ChatFragment) {
                  ((ChatFragment) fragment).openSettings();
                }
              })
          .show();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menudeepseek, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
     if (item.getItemId() == R.id.action_clear_all) {
      clearAllConversations();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
  private void clearAllConversations() {
    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
    if (fragment instanceof ChatFragment) {
      ((ChatFragment) fragment).clearConversation();
      Toast.makeText(this, "مکالمات پاک شدند", Toast.LENGTH_SHORT).show();
    }
  }

  
  @Override
  public void onBackPressed() {
    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);

    if (fragment instanceof ChatFragment && ((ChatFragment) fragment).hasMessages()) {
      new MaterialAlertDialogBuilder(this)
          .setTitle("خروج از برنامه")
          .setMessage("آیا مطمئن هستید میخواهید خارج شوید؟")
          .setPositiveButton("بله", (dialog, which) -> finish())
          .setNegativeButton("خیر", null)
          .show();
    } else {
      super.onBackPressed();
    }
  }
}
