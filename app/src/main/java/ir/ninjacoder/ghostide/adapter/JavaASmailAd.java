package ir.ninjacoder.ghostide.adapter;

import android.content.res.ColorStateList;
import com.google.android.material.shape.CornerFamily;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import ir.ninjacoder.ghostide.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.ninjacoder.ghostide.databinding.LbsBinding;
import ir.ninjacoder.ghostide.model.JavaModel;
import ir.ninjacoder.ghostide.utils.AnimUtils;
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
    holder.normaltext.setText(iritem.getCode());
    holder.itemView.setOnClickListener(v -> item.onClick(iritem, v, holder.getAdapterPosition()));
    holder.titleview.setText(iritem.getName().substring(0, 1));
    var shap =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 23f).build());
    shap.setFillColor(ColorStateList.valueOf(iritem.getColor()));
    holder.getTag.setBackground(shap);
    AnimUtils.AutoColorSynchronizedfromTxt(iritem.getColor(), holder.titleview);
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parant, int viewType) {
    LbsBinding binding = LbsBinding.inflate(LayoutInflater.from(parant.getContext()));
    return new Holder(binding);
  }

  public class Holder extends RecyclerView.ViewHolder {

    private TextView normaltext, titleview;
    View getTag;

    public Holder(LbsBinding view) {
      super(view.getRoot());
      normaltext = view.normaltext;
      titleview = view.titleview;
      getTag = view.getTag;
    }
  }
}
