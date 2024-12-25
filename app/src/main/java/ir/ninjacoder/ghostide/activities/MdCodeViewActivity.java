package ir.ninjacoder.ghostide.activities;

import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.utils.FileUtil;
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
                ColorStateList.valueOf(MaterialColors.getColor(markdownview, ObjectUtils.Back)));
    }
}
