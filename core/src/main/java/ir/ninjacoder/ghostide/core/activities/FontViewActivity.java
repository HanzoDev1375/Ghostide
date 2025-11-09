package ir.ninjacoder.ghostide.core.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.activities.BaseCompat;

public class FontViewActivity extends BaseCompat {

    private TextView font01,
            fontsymbol,
            ifont01,
            ifont02,
            ifont03,
            ifont04,
            textview8,
            textview9,
            textview1;

    private ImageView imageview1;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.fontview);
        initialize(_savedInstanceState);
        initializeLogic();
    }

    private void initialize(Bundle _savedInstanceState) {

        font01 = findViewById(R.id.font01);
        fontsymbol = findViewById(R.id.fontsymbol);
        ifont01 = findViewById(R.id.ifont01);
        ifont02 = findViewById(R.id.ifont02);
        ifont03 = findViewById(R.id.ifont03);
        ifont04 = findViewById(R.id.ifont04);
        textview8 = findViewById(R.id.textview8);
        textview9 = findViewById(R.id.textview9);
        textview1 = findViewById(R.id.textview1);
        imageview1 = findViewById(R.id.imageview1);

        imageview1.setOnClickListener(
                (c) -> {
                    onBackPressed();
                });
    }

    private void initializeLogic() {
        font01.setTypeface(Typeface.createFromFile(new File(getIntent().getStringExtra("font"))));
        fontsymbol.setTypeface(Typeface.createFromFile(new File(getIntent().getStringExtra("font"))));
        ifont01.setTypeface(Typeface.createFromFile(new File(getIntent().getStringExtra("font"))));
        ifont02.setTypeface(Typeface.createFromFile(new File(getIntent().getStringExtra("font"))));
        ifont03.setTypeface(Typeface.createFromFile(new File(getIntent().getStringExtra("font"))));
        ifont04.setTypeface(Typeface.createFromFile(new File(getIntent().getStringExtra("font"))));
        textview8.setTypeface(Typeface.createFromFile(new File(getIntent().getStringExtra("font"))));
        textview9.setTypeface(Typeface.createFromFile(new File(getIntent().getStringExtra("font"))));
    }
}
