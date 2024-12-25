package ir.ninjacoder.ghostide.activities;

import ir.ninjacoder.ghostide.R;

import ir.ninjacoder.ghostide.databinding.LayoutjavamanagerBinding;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import ir.ninjacoder.ghostide.utils.DataUtil;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    _toolbar.setNavigationOnClickListener(
        new View.OnClickListener() {
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

    listview1.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
            final int _position = _param3;
            sp.edit()
                .putString("bin", javacode1.get((int) _position).get("code").toString())
                .apply();
            sp.edit()
                .putString("fb", javacode1.get((int) _position).get("title").toString())
                .apply();

            var frmanager = new DialogJavaCodeView();
            frmanager.show(getSupportFragmentManager(),"1");
          }
        });

    imageview1.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View _view) {
            onBackPressed();
          }
        });

    edittext1.addTextChangedListener(
        new TextWatcher() {
          private double d;

          @Override
          public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
            final String _charSeq = _param1.toString();
            javacode1 =
                new Gson()
                    .fromJson(
                        path, new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
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
          public void beforeTextChanged(
              CharSequence _param1, int _param2, int _param3, int _param4) {}

          @Override
          public void afterTextChanged(Editable _param1) {}
        });
  }

  private void initializeLogic() {
    try {
      java.io.InputStream inputstream1 = getAssets().open("codes.json");
      path = DataUtil.copyFromInputStream(inputstream1);
      javacode1 =
          new Gson()
              .fromJson(path, new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
    } catch (Exception e) {

    }
    listview1.setAdapter(new Listview1Adapter(javacode1));
    ((BaseAdapter) listview1.getAdapter()).notifyDataSetChanged();
    textinputlayoutsearch.setCounterMaxLength(40);
    _toolbar.setVisibility(View.GONE);
    ObjectUtils.setTextColor(textview1);
    ObjectUtils.EdittextColor(edittext1);
    ObjectUtils.setColorFilter(imageview1);
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
    getWindow()
        .setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
  }

  public void _clickAnimation(final View _view) {
    ScaleAnimation fade_in =
        new ScaleAnimation(
            0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
    fade_in.setDuration(300);
    fade_in.setFillAfter(true);
    _view.startAnimation(fade_in);
  }

  public void showMessage(String _s) {
    Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
  }

  public class Listview1Adapter extends BaseAdapter {

    private ArrayList<HashMap<String, Object>> _data;
    private LayoutjavamanagerBinding binds;

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

      binds = LayoutjavamanagerBinding.inflate(LayoutInflater.from(_container.getContext()));

      var cardview1 = binds.cardview1;
      var imageview1 = binds.imageview1;
      var getTitle = binds.getTitle;
      var getid = binds.getid;

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
      ObjectUtils.setTextColor(getTitle);
      ObjectUtils.setTextColor(getid);
      ObjectUtils.setColorFilter(imageview1);

      return binds.getRoot();
    }
  }
}
