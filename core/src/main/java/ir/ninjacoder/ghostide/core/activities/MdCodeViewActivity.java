package ir.ninjacoder.ghostide.core.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ir.ninjacoder.codesnap.markdownpreview.MarkDownTextHelper;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.utils.FileUtil;

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
