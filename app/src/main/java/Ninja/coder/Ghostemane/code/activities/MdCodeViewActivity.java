package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.color.MaterialColors;
import com.mukesh.MarkdownView;

public class MdCodeViewActivity extends AppCompatActivity {

    private LinearLayout linear1;
    private MarkdownView markdownview;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.mdcodeview);
        linear1 = findViewById(R.id.linear1);
        markdownview = findViewById(R.id.M);
        markdownview.setOpenUrlInBrowser(true);
        markdownview.setMarkDownText(FileUtil.readFile(getIntent().getStringExtra("v")));
        markdownview.setBackgroundTintList(
                ColorStateList.valueOf(MaterialColors.getColor(markdownview, ColorAndroid12.Back)));
    }
}
