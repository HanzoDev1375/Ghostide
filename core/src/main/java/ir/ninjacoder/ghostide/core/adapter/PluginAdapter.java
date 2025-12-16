package ir.ninjacoder.ghostide.core.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.ghostide.core.databinding.LayoutPluginAdapterBinding;
import ir.ninjacoder.ghostide.core.model.PlModel;
import ir.ninjacoder.ghostide.core.utils.AnimUtils;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.prograsssheet.enums.ModBackground;
import java.util.ArrayList;
import java.util.List;

public class PluginAdapter extends RecyclerView.Adapter<PluginAdapter.ViewHolder> {

  private List<PlModel> originalModel; // لیست اصلی
  private List<PlModel> filteredModel; // لیست فیلتر شده
  private OnPluginStateChangeListener listener;
  private String currentQuery = "";

  public interface OnPluginStateChangeListener {
    void onPluginStateChanged();
  }

  public PluginAdapter(List<PlModel> model, OnPluginStateChangeListener listener) {
    this.originalModel = model; // ارجاع مستقیم به لیست اصلی
    this.filteredModel = new ArrayList<>(model);
    this.listener = listener;
  }

  public void updateList(List<PlModel> newList) {
    this.originalModel = newList;
    this.filteredModel = new ArrayList<>(newList);
    notifyDataSetChanged();
  }

  public void filter(String query) {
    currentQuery = query;
    filteredModel.clear();

    if (query.isEmpty()) {
      filteredModel.addAll(originalModel);
    } else {
      String lowerCaseQuery = query.toLowerCase();
      for (PlModel plugin : originalModel) {
        if (plugin.getName().toLowerCase().contains(lowerCaseQuery)
            || plugin.getDev().toLowerCase().contains(lowerCaseQuery)
            || plugin.getType().toLowerCase().contains(lowerCaseQuery)) {
          filteredModel.add(plugin);
        }
      }
    }
    notifyDataSetChanged();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    private final LayoutPluginAdapterBinding binding;

    public ViewHolder(LayoutPluginAdapterBinding v) {
      super(v.getRoot());
      this.binding = v;

      // تنظیم listener برای سویچ
      binding
          .getRoot()
          .setSwitchChangedListener(
              (view, isChecked) -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                  PlModel item = filteredModel.get(position);
                  item.setIsusing(isChecked);

                  // به روزرسانی آیتم متناظر در لیست اصلی
                  int originalIndex = originalModel.indexOf(item);
                  if (originalIndex != -1) {
                    originalModel.get(originalIndex).setIsusing(isChecked);
                  }

                  if (listener != null) {
                    listener.onPluginStateChanged();
                  }
                }
              });
    }

    public void bind(PlModel item) {
      binding.getRoot().setSwitchChangedListener(null);
      ObjectUtils.setHighlightSearchText(
          binding.getRoot().getTitle(), item.getName(), currentQuery);
      AnimUtils.Sacla(binding.getRoot());
      binding.getRoot().setDescription(item.getDev());
      binding.getRoot().setValue(item.getIsusing());
      binding.getRoot().setIconPath(item.getIcon());
      binding
          .getRoot()
          .setSwitchChangedListener(
              (view, isChecked) -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                  PlModel currentItem = filteredModel.get(position);
                  currentItem.setIsusing(isChecked);
                  int originalIndex = originalModel.indexOf(currentItem);
                  if (originalIndex != -1) {
                    originalModel.get(originalIndex).setIsusing(isChecked);
                  }

                  if (listener != null) {
                    listener.onPluginStateChanged();
                  }
                }
              });

      if (filteredModel.size() == 1) {
        binding.getRoot().setBackgroundMod(ModBackground.NONE);
      } else if (getAdapterPosition() == 0) {
        binding.getRoot().setBackgroundMod(ModBackground.TOP);
      } else if (getAdapterPosition() == filteredModel.size() - 1) {
        binding.getRoot().setBackgroundMod(ModBackground.BOTTOM);
      } else {
        binding.getRoot().setBackgroundMod(ModBackground.MIDDLE);
      }
    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutPluginAdapterBinding binding =
        LayoutPluginAdapterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    return new ViewHolder(binding);
  }

  @Override
  public int getItemCount() {
    return filteredModel.size();
  }

  @Override
  public void onBindViewHolder(PluginAdapter.ViewHolder holder, int position) {
    holder.bind(filteredModel.get(position));
  }
}
