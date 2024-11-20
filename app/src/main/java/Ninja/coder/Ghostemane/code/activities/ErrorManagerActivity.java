package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ObjectUtils;
import Ninja.coder.Ghostemane.code.utils.FileUtil;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.ClipboardUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ErrorManagerActivity extends BaseCompat {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;
    private FloatingActionButton _fab;

    private LinearLayout linear1;
    private LinearLayout linear2;
    private ScrollView vscroll1;
    private TextView textview2;
    private LinearLayout linear3;
    private TextView result;
    private Intent i = new Intent();

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.errormanager);
        bindid();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
                    },
                    1000);
        } else {
            runApp();
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            runApp();
        }
    }

    private void bindid() {
        _app_bar = findViewById(R.id._app_bar);
        _coordinator = findViewById(R.id._coordinator);
        _toolbar = findViewById(R.id._toolbar);
        setSupportActionBar(_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        _toolbar.setNavigationOnClickListener(
                (__) -> {
                    finishAffinity();
                });
        _fab = findViewById(R.id._fab);

        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        vscroll1 = findViewById(R.id.vscroll1);
        textview2 = findViewById(R.id.textview2);
        linear3 = findViewById(R.id.linear3);
        result = findViewById(R.id.result);

        _fab.setOnClickListener(
                (v) -> {
                    ClipboardUtils.copyText(result.getText().toString());
                });
        result.setSelected(true);
    }

    private void runApp() {
        var error = new StringBuilder();
        error.append("\n").append(getIntent().getStringExtra("Test"));
        error.append(getIntent().getStringExtra("Software"));
        error.append("App version: " + "1.6.1");
        error.append("\n\n");
        error.append(getIntent().getStringExtra("Error"));
        error.append("\n\n");
        error.append(getIntent().getStringExtra("Date"));

        result.setText(error.toString());
        _toolbar.setSubtitleTextColor(MaterialColors.getColor(_toolbar, ObjectUtils.colorOnSurface));
        _toolbar.setNavigationIcon(R.drawable.closecompat);
        _toolbar.setTitleTextColor(MaterialColors.getColor(_toolbar, ObjectUtils.colorOnSurface));
        setTitle("app Crash");
        ObjectUtils.setTextColor(textview2);
        ObjectUtils.setTextColor(result);
        ObjectUtils.setFabColor(_fab);
        ObjectUtils.setToolbarinit(_toolbar);
        FileUtil.writeFile(
                FileUtil.getExternalStorageDir().concat("/GhostWebIDE/Error.log"), error.toString());
    }
}
