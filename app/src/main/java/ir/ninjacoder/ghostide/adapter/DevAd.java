package ir.ninjacoder.ghostide.adapter;

import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.glidecompat.GlideCompat;
import ir.ninjacoder.ghostide.model.DevModel;
import ir.ninjacoder.ghostide.utils.AnimUtils;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.HashMap;
import java.util.List;

public class DevAd extends RecyclerView.Adapter<DevAd.VH> {
  private List<HashMap<String, Object>> listDev;
  private OnItemClick click;

  public DevAd(List<HashMap<String, Object>> listDev, OnItemClick click) {
    this.listDev = listDev;
    this.click = click;
  }

  @Override
  public int getItemCount() {
    return listDev.size();
  }

  @Override
  public void onBindViewHolder(VH holder, int pos) {
    var model = listDev.get(pos);
    Glide.with(holder.imageView.getContext())
        .load(Uri.parse(listDev.get(pos).get("avatar_url").toString()))
        .circleCrop()
        .into(holder.imageView);
    holder.itemView.setOnClickListener(
        x -> {
          if (click != null) {
            click.onItemChange(x, holder.getAdapterPosition());
            AnimUtils.Sacla(x);
          }
        });
  }

  @Override
  public VH onCreateViewHolder(ViewGroup pa, int arg1) {
    return new VH(
        LayoutInflater.from(pa.getContext()).inflate(R.layout.___layout_dev_libs, pa, false));
  }

  public interface OnItemClick {
    public void onItemChange(View v, int pos);
  }

  class VH extends RecyclerView.ViewHolder {
    protected ImageView imageView;

    public VH(View view) {
      super(view);
      imageView = view.findViewById(R.id.dev_user);
    }
  }
}
