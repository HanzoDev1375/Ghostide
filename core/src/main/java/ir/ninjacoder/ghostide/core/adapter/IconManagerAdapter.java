package ir.ninjacoder.ghostide.core.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.core.model.Icons;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;

public class IconManagerAdapter extends RecyclerView.Adapter<IconManagerAdapter.ViewHolder>
    implements Filterable {

  private static final int TYPE_EMPTY = -1;
  private static final int TYPE_ITEM = 1;
  private final List<Icons> mIcons = new ArrayList<>();
  private OnIconSelectedListener mListener;
  private Filter iconsFilter =
      new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
          List<Icons> icons = new ArrayList<>();

          if (constraint == null || constraint.length() == 0) {
            icons.addAll(mIcons);
          } else {
            String filterPattern = constraint.toString().toLowerCase().trim();

            for (Icons item : mIcons) {
              if (item.getRootFile().getName().toLowerCase().contains(filterPattern)) {
                icons.add(item);
              }
            }
          }

          FilterResults results = new FilterResults();
          results.values = icons;
          return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
          mIcons.clear();
          mIcons.addAll((List<Icons>) results.values);
          notifyDataSetChanged();
        }
      };

  public IconManagerAdapter() {}

  public void setOnIconSelectedListener(OnIconSelectedListener listener) {
    mListener = listener;
  }

  public void submitList(@NonNull List<Icons> icons) {
    DiffUtil.DiffResult diffResult =
        DiffUtil.calculateDiff(
            new DiffUtil.Callback() {
              @Override
              public int getOldListSize() {
                return mIcons.size();
              }

              @Override
              public int getNewListSize() {
                return icons.size();
              }

              @Override
              public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                return mIcons.get(oldItemPosition).equals(icons.get(newItemPosition));
              }

              @Override
              public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return mIcons.get(oldItemPosition).equals(icons.get(newItemPosition));
              }
            });
    mIcons.clear();
    mIcons.addAll(icons);
    diffResult.dispatchUpdatesTo(this);
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    FrameLayout root = new FrameLayout(parent.getContext());
    root.setLayoutParams(
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    final ViewHolder holder;
    if (viewType == TYPE_EMPTY) {
      holder = new EmptyViewHolder(root);
    } else {
      holder = new ItemViewHolder(root);
    }

    root.setOnClickListener(
        v -> {
          if (mListener != null) {
            int position = holder.getBindingAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
              mListener.onIconSelect(mIcons.get(position), root);
            }
          }
        });

    return holder;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    if (holder.getItemViewType() == TYPE_ITEM) {
      ((ItemViewHolder) holder).bind(mIcons.get(position));
    }
  }

  @Override
  public int getItemCount() {
    return mIcons.size();
  }

  @Override
  public int getItemViewType(int position) {
    if (mIcons.isEmpty()) {
      return TYPE_EMPTY;
    }

    return TYPE_ITEM;
  }

  @Override
  public Filter getFilter() {
    return iconsFilter;
  }

  public interface OnIconSelectedListener {
    void onIconSelect(Icons icons, View view);
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View view) {
      super(view);
    }
  }

  private static class ItemViewHolder extends ViewHolder {

    public ImageView icon;
    public TextView title;
    private Context context;

    public ItemViewHolder(FrameLayout view) {
      super(view);
      LayoutInflater.from(view.getContext()).inflate(R.layout.icon_manager_item, view);
      icon = view.findViewById(R.id.icon);
      title = view.findViewById(R.id.title);
    }

    public void bind(Icons icons) {
      String name = icons.getRootFile().getName();

      if (name.endsWith(".svg")) {
        title.setText(name.replace(".svg", ""));
      }
      GlideCompat.LoadSvg(icons.getRootFile().getAbsolutePath(), icon);
     // ObjectUtils.setColorFilter(icon);
      ObjectUtils.setTextColor(title);
    }
  }

  private static class EmptyViewHolder extends ViewHolder {

    public final TextView text;

    public EmptyViewHolder(FrameLayout view) {
      super(view);

      text = new TextView(view.getContext());
      text.setTextSize(18);
      text.setText("Empty List");
      view.addView(
          text,
          new FrameLayout.LayoutParams(
              FrameLayout.LayoutParams.WRAP_CONTENT,
              FrameLayout.LayoutParams.WRAP_CONTENT,
              Gravity.CENTER));
    }
  }
}
