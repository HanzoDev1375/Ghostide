package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ObjectUtils;
import Ninja.coder.Ghostemane.code.widget.JsonViewLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import static com.google.android.material.R.attr.*;

public class JsonViewerActivity extends BaseCompat {

    private ExtendedFloatingActionButton _fab;
    private String str = "";
    private boolean o = false;

    private LinearLayout linear1;
    private ProgressBar progressbar1;
    private JsonViewLayout go;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.jsonviewer);
        initialize(_savedInstanceState);
        initializeLogic();
    }

    private void initialize(Bundle _savedInstanceState) {
        _fab = findViewById(R.id._fab);

        linear1 = findViewById(R.id.linear1);
        progressbar1 = findViewById(R.id.progressbar1);
        go = findViewById(R.id.go);

        _fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View _view) {
                        if (!o) {
                            o = true;
                            go.expandAll();
                            _fab.setText("Lock View");
                            _fab.setIconResource(R.drawable.okeye);
                        } else {
                            o = false;
                            go.collapseAll();
                            _fab.setText("Lock View");
                            _fab.setIconResource(R.drawable.noeye);
                        }
                    }
                });
    }

    private void initializeLogic() {
        str = getIntent().getStringExtra("g");
        JsonViewLayout go = findViewById(R.id.go);

        go.bindJson(str);
        go.ScrollView(true);
        go.setValueTextColor(MaterialColors.getColor(go, colorPrimary));
        go.setObjectKeyColor(MaterialColors.getColor(go, colorTertiary));
        go.setValueTextColor(MaterialColors.getColor(go, colorTertiaryFixed));
        go.setValueNumberColor(MaterialColors.getColor(go, colorError));
        go.setValueBooleanColor(MaterialColors.getColor(go, colorPrimaryFixed));
        go.setValueNullColor(MaterialColors.getColor(go, colorErrorContainer));
        go.setArrayLengthColor(MaterialColors.getColor(go, colorOnErrorContainer));

        _fab.setIconResource(R.drawable.noeye);
        _fab.setText("Lock View");

        progressbar1.setVisibility(View.GONE);
        ObjectUtils.setFab(_fab);
        ObjectUtils.PrograssBarColor(progressbar1);
    }

    public void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }
}
