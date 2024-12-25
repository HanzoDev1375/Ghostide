package ir.ninjacoder.ghostide.activities;

import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.widget.PdfReader;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class LeranPdfActivity extends AppCompatActivity {

    private LinearLayout linear2;
    private LinearLayout mpdfview;
    private TextView textview1;
    private ImageView imageview1;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.leranpdf);
        initialize(_savedInstanceState);
        initializeLogic();
    }

    private void initialize(Bundle _savedInstanceState) {
        linear2 = findViewById(R.id.linear2);
        mpdfview = findViewById(R.id.mpdfview);
        textview1 = findViewById(R.id.textview1);
        imageview1 = findViewById(R.id.imageview1);

        imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                onBackPressed();
            }
        });
    }

    private void initializeLogic() {
        if (getIntent().hasExtra("android")) {
            mpdfview.addView(new PdfReader(LeranPdfActivity.this, getIntent().getStringExtra("android")));
        } else {
            if (getIntent().hasExtra("css")) {
                mpdfview.addView(new PdfReader(LeranPdfActivity.this, getIntent().getStringExtra("css")));
            } else {
                if (getIntent().hasExtra("java")) {
                    mpdfview.addView(new PdfReader(LeranPdfActivity.this, getIntent().getStringExtra("java")));
                }
            }
        }
    }


    @Deprecated
    public void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

    @Deprecated
    public int getLocationX(View _v) {
        int _location[] = new int[2];
        _v.getLocationInWindow(_location);
        return _location[0];
    }

    @Deprecated
    public int getLocationY(View _v) {
        int _location[] = new int[2];
        _v.getLocationInWindow(_location);
        return _location[1];
    }

    @Deprecated
    public int getRandom(int _min, int _max) {
        Random random = new Random();
        return random.nextInt(_max - _min + 1) + _min;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
        ArrayList<Double> _result = new ArrayList<Double>();
        SparseBooleanArray _arr = _list.getCheckedItemPositions();
        for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
            if (_arr.valueAt(_iIdx))
                _result.add((double) _arr.keyAt(_iIdx));
        }
        return _result;
    }

    @Deprecated
    public float getDip(int _input) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
