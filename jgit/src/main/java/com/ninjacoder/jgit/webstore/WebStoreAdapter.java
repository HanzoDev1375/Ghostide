package com.ninjacoder.jgit.webstore;

import android.graphics.Color;
import com.bumptech.glide.Glide;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.graphics.Typeface;
import android.util.Log;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ninjacoder.jgit.R;
import java.util.ArrayList;
import java.util.List;

public class WebStoreAdapter extends RecyclerView.Adapter<WebStoreAdapter.Holder> {

  private List<WebModel> originalList;
  private List<WebModel> list;
  private OnDownloadSvg download;
  private String currentSearchText = "";

  public WebStoreAdapter(List<WebModel> list, OnDownloadSvg download) {
    this.originalList = new ArrayList<>(list);
    this.list = list;
    this.download = download;
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup p, int arg1) {
    return new Holder(
        LayoutInflater.from(p.getContext()).inflate(R.layout.layout_webstore_adapter, p, false));
  }

  @Override
  public void onBindViewHolder(Holder holder, int pos) {
    WebModel ir = list.get(pos);
    holder.bind(ir, currentSearchText);
    holder.size.setText(ir.getSize());
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public void filter(String query) {
    currentSearchText = query;
    list.clear();
    if (query.isEmpty()) {
      list.addAll(originalList);
    } else {
      String lowerCaseQuery = query.toLowerCase();
      for (var item : originalList) {
        if (item.getName().toLowerCase().contains(lowerCaseQuery)) {
          list.add(item);
        }
      }
    }
    notifyDataSetChanged();
  }

  class Holder extends RecyclerView.ViewHolder {
    private TextView size, names;
    private ImageView icons;

    public Holder(View v) {
      super(v);
      size = v.findViewById(R.id.size);
      names = v.findViewById(R.id.name);
      icons = v.findViewById(R.id.icon);
    }

    public void bind(WebModel model, String searchText) {
      try {
        String img = model.getImage();

        Glide.with(icons.getContext()).load(img).error(Color.CYAN).into(icons);
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

        names.setText(spannableString);
        icons.setOnClickListener(
            x -> {
              download.onDownload(x, model);
            });
      } catch (Exception err) {
        Log.e("SVGLoadError", "Error loading SVG", err);
        icons.setImageDrawable(new ColorDrawable(Color.CYAN));
      }
    }
  }

  public interface OnDownloadSvg {
    void onDownload(View v, WebModel m);
  }
}
