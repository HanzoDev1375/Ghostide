package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.model.TextActionModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TextActionAd extends RecyclerView.Adapter<TextActionAd.ViewHolder> {

  protected List<TextActionModel> listmodel;
  protected OnItemClick onItemClick;

  public TextActionAd(List<TextActionModel> listmodel, OnItemClick onItemClick) {
    this.listmodel = listmodel;
    this.onItemClick = onItemClick;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.helper, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    TextActionModel model = listmodel.get(position);
    holder.icon.setImageResource(model.getIcomName());
    holder.tv.setVisibility(View.GONE);

    if (onItemClick != null) {
      holder.itemView.setOnClickListener(
          v -> onItemClick.onItemClickChange(position, v, holder.icon));
    }
  }

  @Override
  public int getItemCount() {
    return listmodel.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView icon;
    TextView tv;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      icon = itemView.findViewById(R.id.iconNameH);
      tv = itemView.findViewById(R.id.tvHelper);
    }
  }

  public interface OnItemClick {
    void onItemClickChange(int posNow, View myview, ImageView img);
  }
}
