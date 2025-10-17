package ir.ninjacoder.ghostide.activities;

import ir.ninjacoder.ghostide.R;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import ir.ninjacoder.ghostide.markdown.MarkDownTextHelper;
import ir.ninjacoder.ghostide.utils.FileUtil;

public class MdCodeViewActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle _savedInstanceState) {
    super.onCreate(_savedInstanceState);
    setContentView(R.layout.mdcodeview);

    TextView markdownview = findViewById(R.id.mdview);
    MarkDownTextHelper.handleMarkDown(
        markdownview, FileUtil.readFile(getIntent().getStringExtra("v")));
  }
}
