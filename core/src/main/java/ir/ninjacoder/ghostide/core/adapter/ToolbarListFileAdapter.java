package ir.ninjacoder.ghostide.core.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
import ir.ninjacoder.prograsssheet.perfence.DrawableUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import ir.ninjacoder.ghostide.core.R;

public class ToolbarListFileAdapter extends RecyclerView.Adapter<ToolbarListFileAdapter.VH> {
  protected CallBack back;
  private List<String> data;
  private Context context;
  private int normalColor, normalBackground, lastitemColor, lastitemBackground;
  private DrawableUtil drawableutil = new DrawableUtil();

  public ToolbarListFileAdapter(List<String> data, Context context, CallBack back) {
    this.data = data;
    this.context = context;
    this.back = back;
  }

  @Override
  public void onBindViewHolder(VH holder, int position) {

    String fullPath = data.get(position);
    String displayName = new File(fullPath).getName();

    if (displayName.isEmpty()) {
      displayName = fullPath;
    }

    holder.tvtitle.setText(displayName);

    holder.contentview.setOnClickListener(
        v -> {
          if (back != null) {
            back.GoToDir(v, position, fullPath);
          }
        });

    holder.contentview.setOnLongClickListener(
        longClick -> {
          if (back != null) {
            back.GoToTreeFile(holder.itemView, position, fullPath);
          }
          return true;
        });
    normalColor = ObjectUtils.colorSecondary;
    normalBackground = ObjectUtils.colorOnSecondary;
    lastitemColor = ObjectUtils.colorOnPrimary;
    lastitemBackground = ObjectUtils.colorPrimary;
    drawableutil.setColorByPosition(
        data,
        position,
        holder.contentview,
        holder.tvtitle,
        lastitemColor,
        lastitemBackground,
        normalColor,
        normalBackground);
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public void updateItems(List<String> newItems) {
    this.data = new ArrayList<>(newItems);
    notifyDataSetChanged();
  }

  public void bindColor(
      int normalColor, int normalBackground, int lastitemColor, int lastitemBackground) {
    this.normalColor = normalColor;
    this.normalBackground = normalBackground;
    this.lastitemColor = lastitemColor;
    this.lastitemBackground = lastitemBackground;
  }

  public interface CallBack {
    void GoToDir(View view, int pos, String dir);

    void GoToTreeFile(View view, int pos, String dir);
  }

  public class VH extends RecyclerView.ViewHolder {
    protected TextView tvtitle;
    protected ImageView iconarrow;
    protected View contentview;

    public VH(View v) {
      super(v);
      tvtitle = v.findViewById(R.id.tvtitle);
      contentview = v.findViewById(R.id.contentview);
      iconarrow = v.findViewById(R.id.iconarrow);
    }
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parent, int typeview) {
    return new VH(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.instettab, parent, false));
  }

  public void submitList(List<String> list) {
    if (list == null) {
      data = new ArrayList<>();
    } else data = new ArrayList<>(list);
    notifyDataSetChanged();
  }
}
