package Ninja.coder.Ghostemane.code.activities;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.utils.ColorAndroid12;
import Ninja.coder.Ghostemane.code.utils.DataUtil;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class JavaManagerLayoutActivity extends BaseCompat {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;
    private String path = "";
    private HashMap<String, Object> imap = new HashMap<>();

    private ArrayList<HashMap<String, Object>> javacode1 = new ArrayList<>();

    private LinearLayout linear1;
    private LinearLayout linear3;
    private TextInputLayout textinputlayoutsearch;
    private ListView listview1;
    private TextView textview1;
    private ImageView imageview1;
    private EditText edittext1;

    private SharedPreferences sp;
    private DialogJavaCodeViewDialogFragmentActivity dialogJavaCodeViewDialogFragmentActivityN;
    private FragmentManager DialogjavacodeviewDialogFragmentActivityFM;

    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);
        setContentView(R.layout.javamanagerlayout);
        initialize(_savedInstanceState);
        initializeLogic();
    }

    private void initialize(Bundle _savedInstanceState) {
        _app_bar = findViewById(R.id._app_bar);
        _coordinator = findViewById(R.id._coordinator);
        _toolbar = findViewById(R.id._toolbar);
        setSupportActionBar(_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        _toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                onBackPressed();
            }
        });
        linear1 = findViewById(R.id.linear1);
        linear3 = findViewById(R.id.linear3);
        textinputlayoutsearch = findViewById(R.id.textinputlayoutsearch);
        listview1 = findViewById(R.id.listview1);
        textview1 = findViewById(R.id.textview1);
        imageview1 = findViewById(R.id.imageview1);
        edittext1 = findViewById(R.id.edittext1);
        sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
                final int _position = _param3;
                sp.edit().putString("bin", javacode1.get((int) _position).get("code").toString()).commit();
                sp.edit().putString("fb", javacode1.get((int) _position).get("title").toString()).commit();
                dialogJavaCodeViewDialogFragmentActivityN = new DialogJavaCodeViewDialogFragmentActivity();
                dialogJavaCodeViewDialogFragmentActivityN.show(getSupportFragmentManager(), "1");
            }
        });

        imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                onBackPressed();
            }
        });

        edittext1.addTextChangedListener(new TextWatcher() {
            private double d;

            {
            }

            @Override
            public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
                final String _charSeq = _param1.toString();
                javacode1 = new Gson().fromJson(path, new TypeToken<ArrayList<HashMap<String, Object>>>() {
                }.getType());
                final double length = javacode1.size();

                d = javacode1.size() - 1;
                for (int i = 0; i < (int) (length); i++) {
                    final String serching = javacode1.get((int) d).get("title").toString();
                    if (serching.toLowerCase().contains(_charSeq.toLowerCase())) {

                    } else {
                        javacode1.remove((int) (d));
                    }
                    d--;
                }

                listview1.setAdapter(new Listview1Adapter(javacode1));
                ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();

            }

            @Override
            public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {

            }

            @Override
            public void afterTextChanged(Editable _param1) {

            }
        });
    }

    private void initializeLogic() {
        try {
            java.io.InputStream inputstream1 = getAssets().open("codes.json");
            path = DataUtil.copyFromInputStream(inputstream1);
            javacode1 = new Gson().fromJson(path, new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType());
        } catch (Exception e) {

        }
        listview1.setAdapter(new Listview1Adapter(javacode1));
        ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
        textinputlayoutsearch.setCounterMaxLength(40);
        _toolbar.setVisibility(View.GONE);
        ColorAndroid12.setTextColor(textview1);
        ColorAndroid12.EdittextColor(edittext1);
        ColorAndroid12.setColorFilter(imageview1);
        if (textinputlayoutsearch.getCounterMaxLength() == 40) {
            textinputlayoutsearch.setCounterTextColor(ColorStateList.valueOf(0xFFFDA893));
            textinputlayoutsearch.setErrorEnabled(false);
        } else {
            textinputlayoutsearch.setErrorEnabled(true);
            textinputlayoutsearch.setError("استفاده بیش حد مجاز");
            textinputlayoutsearch.setCounterTextColor(ColorStateList.valueOf(0xFFF44336));
        }
        textinputlayoutsearch.setCounterEnabled(true);
        listview1.setHorizontalScrollBarEnabled(false);
        listview1.setVerticalScrollBarEnabled(false);
        listview1.setOverScrollMode(ListView.OVER_SCROLL_NEVER);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        imap = new HashMap<>();
        try {
            imap = new Gson().fromJson("{\n    \"ToolbarTextColor\": \"#ffffff\",\n    \"BLOCK_LINE_CURRENT\": \"#ffb9eeff\",\n    \"LINE_DIVIDER\": \"#1fffffff\",\n    \"SyombolBarTextColor\": \"#fffdffd1\",\n    \"HTML_TAG\": \"#ffffeebc\",\n    \"FabColorStroker\": \"#FFB49D\",\n    \"LINE_NUMBER\": \"#6b6b6b\",\n    \"KEYWORD\": \"#ffffffb9\",\n    \"SELECTION_HANDLE\": \"#ffffffff\",\n    \"TabImageColorFilter\": \"#ffffffff\",\n    \"COMMENT\": \"#626262\",\n    \"ToolbarColor\": \"#ff1f1a1b\",\n    \"IDENTIFIER_NAME\": \"#fff0be4b\",\n    \"DisplayTextColorTab\": \"#ffffffff\",\n    \"NON_PRINTABLE_CHAR\": \"#ffb9ffcb\",\n    \"SELECTION_INSERT\": \"#ffffffff\",\n    \"Ninja\": \"#ffff5d5d\",\n    \"TabTextColor\": \"#FFB49D\",\n    \"BLOCK_LINE\": \"#ffaea2ff\",\n    \"LITERAL\": \"#ff6bae\",\n    \"FabBackgroundColorColor\": \"#1F1A1B\",\n    \"ATTRIBUTE_VALUE\": \"#ffffdcb9\",\n    \"TabBack\": \"#FFB49D\",\n    \"ImageColor\": \"#ffffffff\",\n    \"TEXT_NORMAL\": \"#ffffffff\",\n    \"ATTRIBUTE_NAME\": \"#FF1B4AD7\",\n    \"print\": \"#ffff176e\",\n    \"OPERATOR\": \"#ffffeebc\",\n    \"CURRENT_LINE\": \"#20171717\",\n    \"WHOLE_BACKGROUND\": \"#02FFFFFF\",\n    \"BackgroundColorLinear\": \"#ff1f1a1b\",\n    \"FabImageColor\": \"#FFB49D\",\n    \"LINE_NUMBER_BACKGROUND\": \"#00FFFFFF\"\n}", new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            DataUtil.showMessage(getApplicationContext(), e.toString());
        }
    }

    public void _clickAnimation(final View _view) {
        ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
        fade_in.setDuration(300);
        fade_in.setFillAfter(true);
        _view.startAnimation(fade_in);
    }

    public void _exta() {
    }

    public void test_DialogjavacodeviewDialogFragmentActivity() {
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
                _view = _inflater.inflate(R.layout.layoutjavamanager, null);
            }

            final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
            final com.google.android.material.divider.MaterialDivider linear5 = _view.findViewById(R.id.linear5);
            final LinearLayout linear1 = _view.findViewById(R.id.linear1);
            final LinearLayout linear2 = _view.findViewById(R.id.linear2);
            final LinearLayout linear3 = _view.findViewById(R.id.linear3);
            final LinearLayout linear4 = _view.findViewById(R.id.linear4);
            final ImageView imageview1 = _view.findViewById(R.id.imageview1);
            final TextView getTitle = _view.findViewById(R.id.getTitle);
            final TextView getid = _view.findViewById(R.id.getid);

            getTitle.setText(javacode1.get((int) _position).get("title").toString());
            if (javacode1.get((int) _position).containsKey("id")) {
                getid.setText(javacode1.get((int) _position).get("id").toString());
            } else {
                getid.setTextColor(0xFFD5C3B5);
                getid.setText("Null Pull id 0");
            }
            cardview1.setCardBackgroundColor(Color.TRANSPARENT);
            cardview1.setRadius((float) 15);
            cardview1.setCardElevation((float) 0);
            cardview1.setPreventCornerOverlap(true);
            _clickAnimation(cardview1);
            _clickAnimation(linear1);
            ColorAndroid12.setTextColor(getTitle);
            ColorAndroid12.setTextColor(getid);
            ColorAndroid12.setColorFilter(imageview1);

            return _view;
        }
    }
}
