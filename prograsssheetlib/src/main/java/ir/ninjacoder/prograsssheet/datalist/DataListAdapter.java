package ir.ninjacoder.prograsssheet.datalist;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.VH> {
  private List<DataListModel> model;

  public DataListAdapter(List<DataListModel> model) {
    this.model = model;
  }

  class VH extends RecyclerView.ViewHolder {
    public VH(View v) {
      super(v);
    }
  }

  @Override
  public VH onCreateViewHolder(ViewGroup arg0, int arg1) {
    return null; // not implements
  }

  @Override
  public void onBindViewHolder(VH arg0, int arg1) {}

  @Override
  public int getItemCount() {
    return model.size();
  }
}
