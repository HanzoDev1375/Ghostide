package dev.trindadedev.lib.ui.components.preference.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import dev.trindadedev.lib.ui.components.databinding.LayoutPreferenceBinding;
import java.util.List;

public class ItemLayoutAdapterMod extends RecyclerView.Adapter<ItemLayoutAdapterMod.ViewHolder> {

  private List<LayoutModel> model;
  protected LayoutPreferenceBinding bind;
  private CallBackLabel label;

  public ItemLayoutAdapterMod(List<LayoutModel> model, CallBackLabel label) {
    this.model = model;
    this.label = label;
  }

  public interface CallBackLabel {
    void click(View v, int pos);
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup group, int viewType) {
    bind = LayoutPreferenceBinding.inflate(LayoutInflater.from(group.getContext()));
    return new ViewHolder(bind.getRoot());
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int pos) {
    var it = model.get(pos);
    bind.preferenceTitle.setText(it.getTitle());
    bind.preferenceDescription.setText(it.getName());
    bind.getRoot().setOnClickListener(v ->{
      if(label instanceof CallBackLabel) {
      	label.click(v,pos);
      }
    });
  }

  @Override
  public int getItemCount() {
    return model.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View v) {
      super(v);
    }
  }
}
