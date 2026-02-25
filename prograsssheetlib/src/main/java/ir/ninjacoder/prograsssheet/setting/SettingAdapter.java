package ir.ninjacoder.prograsssheet.setting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.prograsssheet.perfence.PerfenceLayoutSubTitle;
import java.util.ArrayList;
import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.Holder> {

  private OnClickItemCallBack call;
  private List<String> list = new ArrayList<>();

  public SettingAdapter(OnClickItemCallBack call, List<String> list) {
    this.call = call;
    this.list = list != null ? list : new ArrayList<>();
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    PerfenceLayoutSubTitle view = new PerfenceLayoutSubTitle(parent.getContext());
    var param =
        new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    param.topMargin = 3;
    view.setLayoutParams(param);

    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    String item = list.get(position);
    holder.titles.setTextSetting(item);
    holder.itemView.setOnClickListener(
        v -> {
          if (call != null) {
            call.clickItem(position, v, item);
          }
        });
    holder.titles.setBackground(holder.titles.get(list, position));
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  static class Holder extends RecyclerView.ViewHolder {
    PerfenceLayoutSubTitle titles;

    public Holder(@NonNull View itemView) {
      super(itemView);
      if (itemView instanceof PerfenceLayoutSubTitle) {
        titles = (PerfenceLayoutSubTitle) itemView;
      } else {
        throw new IllegalArgumentException("View must be an instance of PerfenceLayoutSubTitle");
      }
    }
  }
}
