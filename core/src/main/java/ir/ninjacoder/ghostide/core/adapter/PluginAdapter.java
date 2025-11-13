package ir.ninjacoder.ghostide.core.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.ghostide.core.databinding.LayoutPluginAdapterBinding;
import ir.ninjacoder.ghostide.core.model.PlModel;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.prograsssheet.enums.ModBackground;
import java.util.ArrayList;
import java.util.List;

public class PluginAdapter extends RecyclerView.Adapter<PluginAdapter.ViewHolder> {

  private List<PlModel> model = new ArrayList<>();
  private List<PlModel> originalModel = new ArrayList<>();
  private OnPluginStateChangeListener listener;
  private String currentQuery = "";

  public interface OnPluginStateChangeListener {
    void onPluginStateChanged();
  }

  public PluginAdapter(List<PlModel> model, OnPluginStateChangeListener listener) {
    this.model = model;
    this.originalModel = new ArrayList<>(model);
    this.listener = listener;
  }

  public void updateList(List<PlModel> newList) {
    this.model = newList;
    notifyDataSetChanged();
  }

  public void filter(String query) {
    currentQuery = query;
    List<PlModel> filteredList = new ArrayList<>();

    if (query.isEmpty()) {
      filteredList.addAll(originalModel);
    } else {
      String lowerCaseQuery = query.toLowerCase();
      for (PlModel plugin : originalModel) {
        if (plugin.getName().toLowerCase().contains(lowerCaseQuery)
            || plugin.getDev().toLowerCase().contains(lowerCaseQuery)
            || plugin.getType().toLowerCase().contains(lowerCaseQuery)) {
          filteredList.add(plugin);
        }
      }
    }

    this.model = filteredList;
    notifyDataSetChanged();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    private final LayoutPluginAdapterBinding binding;

    public ViewHolder(LayoutPluginAdapterBinding v) {
      super(v.getRoot());
      this.binding = v;
    }

    public void bind(PlModel item) {

      ObjectUtils.setHighlightSearchText(
          binding.getRoot().getTitle(), item.getName(), currentQuery);

      binding.getRoot().setDescription(item.getDev());
      binding.getRoot().setValue(item.getIsusing());
      if (model.size() == 1) {
        binding.getRoot().setBackgroundMod(ModBackground.NONE);
      } else if (getAdapterPosition() == 0) {
        binding.getRoot().setBackgroundMod(ModBackground.TOP);
      } else if (getAdapterPosition() == model.size() - 1) {
        binding.getRoot().setBackgroundMod(ModBackground.BOTTOM);
      } else {
        binding.getRoot().setBackgroundMod(ModBackground.MIDDLE);
      }

      binding
          .getRoot()
          .setSwitchChangedListener(
              (view, isChecked) -> {
                item.setIsusing(isChecked);

                if (listener != null) {
                  listener.onPluginStateChanged();
                }
              });
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutPluginAdapterBinding binding =
        LayoutPluginAdapterBinding.inflate(
            LayoutInflater.from(parent.getContext()), parent, false);
    return new ViewHolder(binding);
  }

  @Override
  public int getItemCount() {
    return model.size();
  }

  @Override
  public void onBindViewHolder(PluginAdapter.ViewHolder holder, int position) {
    holder.bind(model.get(position));
  }
}
