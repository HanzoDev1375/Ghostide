package ir.ninjacoder.ghostide.core.keyboard;

import android.app.Activity;
import android.os.Bundle;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.keyboard.ColorPickerView;

public class ViewDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_demo);

        ColorPickerView picker = (ColorPickerView) findViewById(R.id.colorPicker);
        picker.setColor(0xffff0000);
    }
}
