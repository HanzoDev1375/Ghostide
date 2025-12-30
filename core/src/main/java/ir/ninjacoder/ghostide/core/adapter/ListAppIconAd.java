package ir.ninjacoder.ghostide.core.adapter;

import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Adapter;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import ir.ninjacoder.ghostide.core.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.core.model.AppIconManagerModel;
import java.util.HashMap;
import java.util.List;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.databinding.AppsBinding;

public class ListAppIconAd extends BaseAdapter implements Adapter {

  private List<AppIconManagerModel> data;

  public ListAppIconAd(List<AppIconManagerModel> data) {
    this.data = data;
  }

  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public AppIconManagerModel getItem(int index) {
    return data.get(index);
  }

  @Override
  public long getItemId(int index) {
    return index;
  }

  @Override
  public View getView(int position, View v, ViewGroup container) {
    AppsBinding bin = AppsBinding.inflate(LayoutInflater.from(container.getContext()));
    var getModel = data.get(position);
    bin.textview1.setText(getModel.getName());
    Glide.with(bin.imageview1.getContext())
        .load(getModel.getIconRes())
        .error(GlideCompat.CircelPrograssBar())
        .into(bin.imageview1);
    return bin.getRoot();
  }
}
