package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class JavaASmailAd extends RecyclerView.Adapter<JavaASmailAd.Holder> {
  protected List<String> codeInfo;
  protected OnClickItem item;

  public JavaASmailAd(List<String> codeInfo, OnClickItem item) {
    this.codeInfo = codeInfo;
    this.item = item;
  }

  public interface OnClickItem {
    public void onClick(String info, View v, int pos);
  }

  @Override
  public int getItemCount() {
    return codeInfo.size();
  }

  @Override
  public void onBindViewHolder(Holder holder, int pos) {
    var iritem = codeInfo.get(holder.getAdapterPosition());
    /** holder match */
    holder.tvnormaltext.setText(iritem);
    holder.itemView.setOnClickListener(v -> item.onClick(iritem,v,holder.getAdapterPosition()));
    holder.tvtitle.setText(holder.tvnormaltext.getText().toString().substring(0,1));
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
