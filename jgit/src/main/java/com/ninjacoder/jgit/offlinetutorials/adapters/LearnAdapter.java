package com.ninjacoder.jgit.offlinetutorials.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ninjacoder.jgit.databinding.LayoutLrAdBinding;
import com.ninjacoder.jgit.offlinetutorials.basiclogic.ItemConst;
import com.ninjacoder.jgit.offlinetutorials.basiclogic.OnItemChangeCallBack;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.Holders> {
  protected OnItemChangeCallBack call;
  protected List<Map<String, String>> map = new ArrayList<>();
  protected LayoutLrAdBinding bind;

  public LearnAdapter(OnItemChangeCallBack call, List<Map<String, String>> map) {
    this.call = call;
    this.map = map;
  }

  public static class Holders extends RecyclerView.ViewHolder {
    public Holders(LayoutLrAdBinding view) {
      super(view.getRoot());
    }
  }

  @Override
  public Holders onCreateViewHolder(ViewGroup parant, int viewType) {
    bind = LayoutLrAdBinding.inflate(LayoutInflater.from(parant.getContext()));
    return new Holders(bind);
  }

  @Override
  public void onBindViewHolder(Holders holder, int pos) {
    var get = map.get(pos);
    bind.itemviews.setText(get.get(ItemConst.nameitem));
    bind.getRoot()
        .setOnClickListener(
            v -> {
              if (call != null) {
                call.onLogicClick(get.get(ItemConst.code));
              }
            });
  }

  @Override
  public int getItemCount() {

    return map.size();
  }
}
