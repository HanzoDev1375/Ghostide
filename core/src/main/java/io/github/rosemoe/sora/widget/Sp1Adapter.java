package io.github.rosemoe.sora.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.android.material.color.MaterialColors;

import java.util.ArrayList;
import java.util.HashMap;

import ir.ninjacoder.ghostide.core.databinding.KthBinding;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class Sp1Adapter extends BaseAdapter {

  private KthBinding binding;
  private ArrayList<HashMap<String, Object>> data;
  private Context context;
  public Sp1Adapter(ArrayList<HashMap<String, Object>> data, Context context) {
    this.data = data;
    this.context = context;
  }

  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public HashMap<String, Object> getItem(int index) {
    return data.get(index);
  }

  @Override
  public long getItemId(int index) {
    return index;
  }

  @Override
  public View getView(final int position, View v, ViewGroup container) {
    binding = KthBinding.inflate(LayoutInflater.from(container.getContext()));
    var get = data.get(position).get("key").toString();
    binding.textview1.setText(get);
    binding.textview1.setTextColor(
        ColorStateList.valueOf(MaterialColors.getColor(binding.textview1, ObjectUtils.TvColor)));
        AnimUtils.Sacla(binding.getRoot());
    return binding.getRoot();
  }
}
