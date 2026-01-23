package ir.ninjacoder.ghostide.core.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ir.ninjacoder.codesnap.markdownpreview.MarkDownTextHelper;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.databinding.MdcodeviewBinding;
import ir.ninjacoder.ghostide.core.utils.FileUtil;

public class MdCodeViewActivity extends BaseCompat {
  private MdcodeviewBinding bind;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bind = MdcodeviewBinding.inflate(getLayoutInflater());
    setContentView(bind.getRoot());
    setSupportActionBar(bind.mdtoolbar);
    MarkDownTextHelper.handleMarkDown(
        bind.mdview, FileUtil.readFile(getIntent().getStringExtra("v")));
  }
}
