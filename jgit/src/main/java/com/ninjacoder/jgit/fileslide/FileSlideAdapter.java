package com.ninjacoder.jgit.fileslide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.ninjacoder.jgit.databinding.LayoutFileadSlidesheetBinding;
import java.util.List;

public class FileSlideAdapter extends RecyclerView.Adapter<FileSlideAdapter.Holder> {

  private List<SlideModel> listSlideModel;
  private LayoutFileadSlidesheetBinding bind;
  private OnItemCallBacks call;
  private Custom custom;

  public FileSlideAdapter(List<SlideModel> listSlideModel, OnItemCallBacks call) {
    this.listSlideModel = listSlideModel;
    this.call = call;
  }

  public static class Holder extends RecyclerView.ViewHolder {
    public Holder(View view) {
      super(view);
    }
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    bind = LayoutFileadSlidesheetBinding.inflate(LayoutInflater.from(parent.getContext()));
    return new Holder(bind.getRoot());
  }

  @Override
  public void onBindViewHolder(Holder holder, int pos) {
    var it = listSlideModel.get(pos);
    bind.slideFileText.setText(it.getFile().getName());
    bind.slideFileIcon.setImageResource(it.getIcon());
    bind.getRoot()
        .setOnClickListener(
            i -> {
              if (it.getFile().isDirectory()) {
                if (custom != null) custom.click(it.getFile(), holder.getAdapterPosition(), i);
              } else if (call != null) {
                call.onClickItem(holder.getAdapterPosition(), it, i);
              }
            });
  }

  @Override
  public int getItemCount() {
    return listSlideModel.size();
  }

  public void setCallCustom(Custom custom) {
    this.custom = custom;
  }
}
