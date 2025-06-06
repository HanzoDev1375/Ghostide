package ir.ninjacoder.ghostide.terminal;

import ir.ninjacoder.ghostide.activities.BaseCompat;
import android.view.View;
import android.os.Bundle;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.databinding.TerminalactivityBinding;

public class TerminalActivity extends BaseCompat {
  private TerminalactivityBinding bin;

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    super.onCreate(_savedInstanceState);
    bin = TerminalactivityBinding.inflate(getLayoutInflater());
    setContentView(bin.getRoot());
    String path = getIntent().getStringExtra("path");
    String phpCode = getIntent().getStringExtra("phpcode");
    TerminalTabSeasonImpl tabSystem =
        new TerminalTabSeasonImpl(
            bin.tabLayout, getSupportFragmentManager(), R.id.terminal_container);
    if (path != null || phpCode != null) {
      Bundle args = new Bundle();
      if (path != null) {
        args.putString("path", path);
      } else if (phpCode != null) {
        args.putString("phpcode", phpCode);
      }
      if (!tabSystem.fragments.isEmpty()) {
        tabSystem.fragments.get(0).setArguments(args);
      }
    }
  }
}
