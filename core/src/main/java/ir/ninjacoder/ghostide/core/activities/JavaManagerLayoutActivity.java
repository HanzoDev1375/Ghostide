package ir.ninjacoder.ghostide.core.activities;

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
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.noties.markwon.Markwon;
import ir.ninjacoder.codesnap.LangType;
import ir.ninjacoder.codesnap.LayoutGroup;
import ir.ninjacoder.ghostide.core.databinding.JavamanagerlayoutBinding;
import ir.ninjacoder.ghostide.core.model.JavaCodeViewModel;
import java.util.ArrayList;
import ir.ninjacoder.ghostide.core.databinding.LayoutjavamanagerBinding;
import ir.ninjacoder.ghostide.core.utils.DataUtil;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils; 
import java.util.List;
import java.util.Locale;

public class JavaManagerLayoutActivity extends BaseCompat {

  private String path = "";
  private List<JavaCodeViewModel> javacode1 = new ArrayList<>();
  private List<JavaCodeViewModel> originalList = new ArrayList<>(); 
  private JavamanagerlayoutBinding bind;
  private String currentSearchText = "";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    bind = JavamanagerlayoutBinding.inflate(getLayoutInflater());
    setContentView(bind.getRoot());
    init();
    initializeLogic();
  }

  private void init() {
    setSupportActionBar(bind.Toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    bind.Toolbar.setNavigationOnClickListener(v -> onBackPressed());

    bind.edittext1.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            currentSearchText = s.toString();
            filterList(s.toString());
          }

          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void afterTextChanged(Editable s) {}
        });
  }

  private void filterList(String query) {
    List<JavaCodeViewModel> filteredList = new ArrayList<>();

    if (query.isEmpty()) {
      filteredList.addAll(originalList);
    } else {
      String queryLower = query.toLowerCase(Locale.getDefault());
      for (JavaCodeViewModel item : originalList) {
        if (item.getTitle().toLowerCase(Locale.getDefault()).contains(queryLower)) {
          filteredList.add(item);
        }
      }
    }

    javacode1.clear();
    javacode1.addAll(filteredList);

    if (bind.listview1.getAdapter() != null) {
      ((BaseAdapter) bind.listview1.getAdapter()).notifyDataSetChanged();
    } else {
      bind.listview1.setAdapter(new Listview1Adapter(javacode1));
    }
  }

  private void initializeLogic() {
    try {
      var inputstream1 = getAssets().open("codes.json");
      path = DataUtil.copyFromInputStream(inputstream1);
      javacode1 = new Gson().fromJson(path, new TypeToken<List<JavaCodeViewModel>>() {}.getType());
      originalList = new ArrayList<>(javacode1); 
    } catch (Exception e) {
      e.printStackTrace();
    }

    bind.listview1.setAdapter(new Listview1Adapter(javacode1));
    bind.listview1.setHorizontalScrollBarEnabled(false);
    bind.listview1.setVerticalScrollBarEnabled(false);
    bind.listview1.setOverScrollMode(ListView.OVER_SCROLL_NEVER);

    getWindow()
        .setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
  }

  void _clickAnimation(View _view) {
    ScaleAnimation fade_in =
        new ScaleAnimation(
            0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
    fade_in.setDuration(300);
    fade_in.setFillAfter(true);
    _view.startAnimation(fade_in);
  }

  void showMessage(String s) {
    DataUtil.showMessage(this, s);
  }

  class Listview1Adapter extends BaseAdapter {
    private List<JavaCodeViewModel> _data;
    private LayoutjavamanagerBinding binds;

    public Listview1Adapter(List<JavaCodeViewModel> _arr) {
      _data = _arr;
    }

    @Override
    public int getCount() {
      return _data.size();
    }

    @Override
    public JavaCodeViewModel getItem(int _index) {
      return _data.get(_index);
    }

    @Override
    public long getItemId(int _index) {
      return _index;
    }

    @Override
    public View getView(int position, View _v, ViewGroup _container) {
      if (_v == null) {
        binds = LayoutjavamanagerBinding.inflate(LayoutInflater.from(_container.getContext()));
        _v = binds.getRoot();
        _v.setTag(binds);
      } else {
        binds = (LayoutjavamanagerBinding) _v.getTag();
      }

      var modeljavacode = _data.get(position);
      var cardview1 = binds.cardview1;
      var imageview1 = binds.imageview1;
      var getTitle = binds.getTitle;
      var getid = binds.getid;

      // استفاده از متد هایلایت کردن متن
      if (!currentSearchText.isEmpty()) {
        ObjectUtils.setHighlightSearchText(getTitle, modeljavacode.getTitle(), currentSearchText);
      } else {
        getTitle.setText(modeljavacode.getTitle());
      }

      var md = Markwon.create(getid.getContext());
      if (!modeljavacode.getId().isEmpty() && !modeljavacode.getAbout().isEmpty()) {
        var text = "**" + modeljavacode.getId() + "** " + "`" + modeljavacode.getAbout() + "`";
        md.setMarkdown(getid, text);
      } else {
        md.setMarkdown(getid, "**Id=0**");
      }

      cardview1.setCardBackgroundColor(Color.TRANSPARENT);
      cardview1.setRadius(15f);
      cardview1.setCardElevation(0);
      cardview1.setOnClickListener(v -> bindJavaManager(modeljavacode));
      cardview1.setPreventCornerOverlap(true);
      _clickAnimation(cardview1);

      return _v;
    }

    void bindJavaManager(JavaCodeViewModel model) {
      var sheet = new BottomSheetDialog(JavaManagerLayoutActivity.this);
      LayoutGroup codeSnap = new LayoutGroup(JavaManagerLayoutActivity.this);
      codeSnap.setType(LangType.JAVA);
      codeSnap.setShowHighlighterBracket(true);
      codeSnap.setText(model.getCode());
      codeSnap.setIsShowCopyIcon(true);

      int NavColor = sheet.getWindow().getNavigationBarColor();
      sheet.getWindow().setNavigationBarColor(ColorUtils.setAlphaComponent(NavColor, 20));
      sheet.setContentView(codeSnap);

      if (sheet != null) {
        sheet.show();
      }
    }
  }
}
