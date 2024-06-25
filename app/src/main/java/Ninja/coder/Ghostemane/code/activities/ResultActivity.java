package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.widget.GhostWebMaterialDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;


public class ResultActivity extends BaseCompat {

    private ArrayList<HashMap<String, Object>> cdMapResu = new ArrayList<>();

    private LinearLayout linear1;
    private LinearLayout linear2;
    private ListView listview1;
    private TextView textview1;
    private ImageView imageview1;

    private Intent i1 = new Intent();
    private Intent i2 = new Intent();
    private Intent i3 = new Intent();

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.result);
        initialize();
        initializeLogic();
    }

    private void initialize() {
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        listview1 = findViewById(R.id.listview1);
        textview1 = findViewById(R.id.textview1);
        imageview1 = findViewById(R.id.imageview1);

        listview1.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(
                            AdapterView<?> _param1, View _param2, int _param3, long _param4) {
                        final int _position = _param3;
                        if (_position == 0) {
                            i3.setClass(
                                    getApplicationContext(),
                                    Ninja.coder.Ghostemane.code.keyboard.Theme.class);
                            startActivity(i3);
                        }
                        if (_position == 1) {
                            i1.setClass(
                                    getApplicationContext(),
                                    Ninja.coder.Ghostemane.code.keyboard.Background.class);
                            startActivity(i1);
                        }
                        if (_position == 2) {
                            var di = new GhostWebMaterialDialog(ResultActivity.this);
                            di.setTitle("ذخیره و بازیابی");
                            di.setMessage(
                                    "با انتخاب یکی از گزینه ها ذخیره یا ریست کردن داده های کیبورد برنامه از اول اجرا میشود ولی همچنان تنظیمات برنامه ثابت است فقط تنظیمات کیبورد قابل تغییر است");
                            di.setNeutralButton(
                                    "ذخیره",
                                    (p, d) -> {
                                        i2.setClass(
                                                getApplicationContext(),
                                                Ninja.coder.Ghostemane.code.keyboard.Save.class);
                                        startActivity(i2);
                                    });
                            di.setPositiveButton(
                                    "ریست",
                                    (p1, d2) -> {
                                        i2.setClass(
                                                getApplicationContext(),
                                                Ninja.coder.Ghostemane.code.keyboard.Reset.class);
                                        startActivity(i2);

                                        startActivity(i2);
                                    });
                            di.show();
                        }
                        if (_position == 3) {
                            i3.setClass(
                                    getApplicationContext(),
                                    Ninja.coder.Ghostemane.code.keyboard.Setting.class);
                            startActivity(i3);
                        }
                    }
                });
    }

    private void initializeLogic() {
        for (int v = 0; v < 4; v++) {
            {
                HashMap<String, Object> _item = new HashMap<>();
                _item.put("p", "");
                cdMapResu.add(_item);
            }

        }
        listview1.setAdapter(new Listview1Adapter(cdMapResu));
        ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
        ColorAndroid12.setTextColor(textview1);
        ColorAndroid12.setColorFilter(imageview1);
    }

    @Deprecated
    public void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

    public class Listview1Adapter extends BaseAdapter {

        ArrayList<HashMap<String, Object>> _data;

        public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
            _data = _arr;
        }

        @Override
        public int getCount() {
            return _data.size();
        }

        @Override
        public HashMap<String, Object> getItem(int _index) {
            return _data.get(_index);
        }

        @Override
        public long getItemId(int _index) {
            return _index;
        }

        @Override
        public View getView(final int _position, View _v, ViewGroup _container) {
            LayoutInflater _inflater = getLayoutInflater();
            View _view = _v;
            if (_view == null) {
                _view = _inflater.inflate(R.layout.anifie, null);
            }

            final LinearLayout linear1 = _view.findViewById(R.id.linear1);
            final TextView textview1 = _view.findViewById(R.id.textview1);
            final ImageView imageview1 = _view.findViewById(R.id.imageview1);

            if (_position == 0) {
                imageview1.setImageResource(R.drawable.keyboardlisnertalluserpost_2);
                textview1.setText("تغییر تم");
            }
            if (_position == 1) {
                textview1.setText("پس زمینه شخصی");
                imageview1.setImageResource(R.drawable.keyboardlisnertalluserpost_3);
            }
            if (_position == 2) {
                imageview1.setImageResource(R.drawable.keyboardlisnertalluserpost_1);
                textview1.setText("ذخیره و بازیابی");
            }
            if (_position == 3) {
                imageview1.setImageResource(R.drawable.keyboardlisnertalluserpost_4);
                textview1.setText("بیشتر");
            }
            ColorAndroid12.setTextColor(textview1);
            ColorAndroid12.setColorFilter(imageview1);

            return _view;
        }
    }

}
