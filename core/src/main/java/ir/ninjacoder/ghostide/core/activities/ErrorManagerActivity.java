package ir.ninjacoder.ghostide.core.activities;

import android.content.Intent;
import android.os.Bundle;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ClipboardUtils;
import ir.ninjacoder.ghostide.core.databinding.ErrormanagerBinding;
import ir.ninjacoder.ghostide.core.utils.FileUtil;

public class ErrorManagerActivity extends BaseCompat {
  private ErrormanagerBinding bind;
  private Intent i = new Intent();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bind = ErrormanagerBinding.inflate(getLayoutInflater());
    setContentView(bind.getRoot());
    bindid();
    runApp();
  }

  private void bindid() {

    setSupportActionBar(bind.Toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    bind.Toolbar.setNavigationOnClickListener(
        (__) -> {
          finishAffinity();
        });
    bind.Fab.setOnClickListener(
        (v) -> {
          ClipboardUtils.copyText(bind.result.getText().toString());
        });
    bind.result.setSelected(true);
  }

  private void runApp() {
    var error = new StringBuilder();

    error.append("\n").append(getIntent().getStringExtra("Test"));
    error.append(getIntent().getStringExtra("Software"));
    error.append("App version: " + AppUtils.getAppVersionCode());
    error.append("\n\n");
    error.append(getIntent().getStringExtra("Error"));
    error.append("\n\n");
    error.append("minsdk ").append(AppUtils.getAppTargetSdkVersion()).append('\n');
    error.append(getIntent().getStringExtra("Date"));

    bind.result.setText(error.toString());
    setTitle("app Crash");

    FileUtil.writeFile(
        FileUtil.getExternalStorageDir().concat("/GhostWebIDE/Error.log"), error.toString());
  }
}
