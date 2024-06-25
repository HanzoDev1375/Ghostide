package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.R;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import project.gouid.customer.CoreWebView;

public class GouidHtmlActivity extends AppCompatActivity {

    private CoreWebView run;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.gouidhtml);
        run = findViewById(R.id.run);
        run.getUrl("file:///android_asset/index.html");
    }
}
