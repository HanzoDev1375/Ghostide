package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.model.TextActionModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TextActionAd extends BaseAdapter {

  protected List<TextActionModel> listmodel;
  protected OnItemClick onItemClick;

  public TextActionAd(List<TextActionModel> listmodel, OnItemClick onItemClick) {
    this.listmodel = listmodel;
    this.onItemClick = onItemClick;
  }

  @Override
  public int getCount() {
    return listmodel.size();
  }

  @Override
  public Object getItem(int arg0) {
    return listmodel.get(arg0);
  }

  @Override
  public long getItemId(int arg0) {
    return arg0;
  }

  @Override
  public View getView(int pos, View view, ViewGroup parant) {
    view = LayoutInflater.from(parant.getContext()).inflate(R.layout.helper, parant, false);
    ImageView icon = view.findViewById(R.id.iconNameH);
    TextView tv = view.findViewById(R.id.tvHelper);
    TextActionModel model = listmodel.get(pos);
    icon.setImageResource(model.getIcomName());
    tv.setText(model.getName());
    if (onItemClick != null) {
      view.setOnClickListener(v -> onItemClick.onItemClickChange(pos, v, icon));
    }
    return view;
  }

  public interface OnItemClick {
    public void onItemClickChange(int posNow, View myview, ImageView img);
  }
}
