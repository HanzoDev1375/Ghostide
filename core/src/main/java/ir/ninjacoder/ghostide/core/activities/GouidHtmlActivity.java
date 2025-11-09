package ir.ninjacoder.ghostide.core.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ir.ninjacoder.ghostide.core.R;

public class GouidHtmlActivity extends AppCompatActivity {

    private project.gouid.customer.CoreWebView run;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.gouidhtml);
        run = findViewById(R.id.run);
        run.getUrl("file:///android_asset/index.html");
    }
}
