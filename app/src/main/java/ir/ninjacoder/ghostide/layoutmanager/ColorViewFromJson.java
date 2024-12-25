package ir.ninjacoder.ghostide.layoutmanager;

import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.adapter.ColorFromJsonAdapter;
import ir.ninjacoder.ghostide.utils.DataUtil;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.github.rosemoe.sora.widget.SymbolChannel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ColorViewFromJson extends LinearLayout {
  protected ListView rv;
  protected EditText et;
  private int d;
  private String data;
  private ArrayList<HashMap<String, Object>> mp = new ArrayList<>();

  public ColorViewFromJson(Context context) {
    super(context);
    init(context);
  }

  public ColorViewFromJson(Context context, AttributeSet set) {
    super(context, set);
    init(context);
  }

  public void init(Context context) {
    var v = LayoutInflater.from(context).inflate(R.layout.customcolors, null);
    rv = v.findViewById(R.id.recyclerview_search);
    et = v.findViewById(R.id.searchviews);
    SearchData();
    addView(v);
    try {

      InputStream inputstream1 = context.getAssets().open("m33");
      data = DataUtil.copyFromInputStream(inputstream1);
      mp =
          new Gson()
              .fromJson(data, new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
    } catch (Exception e) {

    }
    rv.setAdapter(new ColorFromJsonAdapter(mp));
    rv.setEdgeEffectColor(Color.TRANSPARENT);
    rv.setDividerHeight(0);
    rv.setScrollBarSize(0);
    rv.setHorizontalScrollBarEnabled(false);
    rv.setVerticalScrollBarEnabled(false);
  }

  public void SearchData() {
    et.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
            final String _charSeq = _param1.toString();
            mp =
                new Gson()
                    .fromJson(
                        data, new TypeToken<ArrayList<HashMap<String, Object>>>() {}.getType());
            final double length = mp.size();

            d = mp.size() - 1;
            for (int i = 0; i < (int) (length); i++) {
              final String serching = mp.get((int) d).get("ColorName").toString();
              if (serching.toLowerCase().contains(_charSeq.toLowerCase())) {

              } else {
                mp.remove((int) (d));
              }
              d--;
            }

            rv.setAdapter(new ColorFromJsonAdapter(mp));
          }

          @Override
          public void beforeTextChanged(
              CharSequence _param1, int _param2, int _param3, int _param4) {}

          @Override
          public void afterTextChanged(Editable _param1) {}
        });
  }

  public void bindByIDEEDITOR(IdeEditor editor) {
    if (rv != null) {
      rv.setOnItemClickListener(
          (view, posView, pos, vvv) -> {
            SymbolChannel ch = editor.createNewSymbolChannel();
            ch.insertSymbol(mp.get(pos).get("mycolors").toString(), 1);
          });
    }
  }
}
