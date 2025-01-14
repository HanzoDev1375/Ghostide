package ir.ninjacoder.ghostide.adapter;

import ir.ninjacoder.ghostide.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.ghostide.model.JavaModel;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.util.List;

public class JavaASmailAd extends RecyclerView.Adapter<JavaASmailAd.Holder> {
  protected List<JavaModel> codeInfo;
  protected OnClickItem item;

  public JavaASmailAd(List<JavaModel> codeInfo, OnClickItem item) {
    this.codeInfo = codeInfo;
    this.item = item;
  }

  public interface OnClickItem {
    public void onClick(JavaModel info, View v, int pos);
  }

  @Override
  public int getItemCount() {
    return codeInfo.size();
  }

  @Override
  public void onBindViewHolder(Holder holder, int pos) {
    var iritem = codeInfo.get(holder.getAdapterPosition());
    /** holder match */
    holder.tvnormaltext.setText(iritem.getCode());
    holder.itemView.setOnClickListener(v -> item.onClick(iritem,v,holder.getAdapterPosition()));
    holder.tvtitle.setText(iritem.getName().substring(0,1));
    ObjectUtils.shapeView(holder.tvtitle);
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parant, int viewType) {
    return new Holder(
        LayoutInflater.from(parant.getContext()).inflate(R.layout.lbs, parant, false));
  }

  public class Holder extends RecyclerView.ViewHolder {
    private TextView tvtitle, tvnormaltext;

    public Holder(View view) {
      super(view);
      tvtitle = view.findViewById(R.id.titleview);
      tvnormaltext = view.findViewById(R.id.normaltext);
    }
  }
}
