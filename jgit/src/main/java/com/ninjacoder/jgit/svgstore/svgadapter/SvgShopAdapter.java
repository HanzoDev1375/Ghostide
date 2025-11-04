package com.ninjacoder.jgit.svgstore.svgadapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.caverock.androidsvg.SVG;
import com.ninjacoder.jgit.R;
import com.ninjacoder.jgit.svgstore.svgmodel.SvgShopModel;
import java.io.InputStream;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.net.URL;
import java.util.ArrayList;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.graphics.Typeface;
import java.util.List;

public class SvgShopAdapter extends RecyclerView.Adapter<SvgShopAdapter.Holder> {
  private List<SvgShopModel> originalList;
  private List<SvgShopModel> list;
  private OnDownloadSvg download;
  private String currentSearchText = "";

  public SvgShopAdapter(List<SvgShopModel> list, OnDownloadSvg download) {
    this.originalList = new ArrayList<>(list);
    this.list = list;
    this.download = download;
  }

  public void filter(String query) {
    currentSearchText = query;
    list.clear();
    if (query.isEmpty()) {
      list.addAll(originalList);
    } else {
      String lowerCaseQuery = query.toLowerCase();
      for (SvgShopModel item : originalList) {
        if (item.getName().toLowerCase().contains(lowerCaseQuery)) {
          list.add(item);
        }
      }
    }
    notifyDataSetChanged();
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup p, int arg1) {
    return new Holder(
        LayoutInflater.from(p.getContext()).inflate(R.layout.layout_svg_view, p, false));
  }

  @Override
  public void onBindViewHolder(Holder holder, int pos) {
    var ir = list.get(pos);
    holder.bind(ir, currentSearchText);
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  class Holder extends RecyclerView.ViewHolder {
    TextView titleName;
    ImageView iconName;
    View v;

    public Holder(View v) {
      super(v);
      v = v;
      titleName = v.findViewById(R.id.titles);
      iconName = v.findViewById(R.id.iconshop);
    }

    public void bind(SvgShopModel model, String searchText) {
      try {
        String svgUrl = model.getIcon();
        iconName.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Glide.with(iconName.getContext()).load(svgUrl).error(Color.CYAN).into(iconName);
        String name = model.getName();
        SpannableString spannableString = new SpannableString(name);

        if (searchText != null && !searchText.isEmpty()) {
          String lowerCaseName = name.toLowerCase();
          String lowerCaseSearch = searchText.toLowerCase();

          int startPos = lowerCaseName.indexOf(lowerCaseSearch);
          while (startPos >= 0) {
            int endPos = startPos + searchText.length();
            spannableString.setSpan(
                new ForegroundColorSpan(Color.RED),
                startPos,
                endPos,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableString.setSpan(
                new StyleSpan(Typeface.BOLD), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            startPos = lowerCaseName.indexOf(lowerCaseSearch, endPos);
          }
        }

        titleName.setText(spannableString);
        iconName.setOnClickListener(
            x -> {
              download.onDownload(x, model);
            });
      } catch (Exception err) {
        Log.e("SVGLoadError", "Error loading SVG", err);
        iconName.setImageDrawable(new ColorDrawable(Color.CYAN));
      }
    }
  }

  public interface OnDownloadSvg {
    void onDownload(View v, SvgShopModel m);
  }
}
