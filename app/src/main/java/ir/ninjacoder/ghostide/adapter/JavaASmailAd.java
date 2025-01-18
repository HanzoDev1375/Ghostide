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
  protected LbsBinding binding;

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
    binding.normaltext.setText(iritem.getCode());
    binding.normaltext.setOnClickListener(
        v -> item.onClick(iritem, v, holder.getAdapterPosition()));
    binding.titleview.setText(iritem.getName().substring(0, 1));
    var shap =
        new MaterialShapeDrawable(
            ShapeAppearanceModel.builder().setAllCorners(CornerFamily.ROUNDED, 23f).build());
    shap.setFillColor(ColorStateList.valueOf(iritem.getColor()));
    binding.getTag.setBackground(shap);
    AnimUtils.AutoColorSynchronizedfromTxt(iritem.getColor(),binding.titleview);
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parant, int viewType) {
    binding = LbsBinding.inflate(LayoutInflater.from(parant.getContext()));
    return new Holder(binding.getRoot());
  }

  public class Holder extends RecyclerView.ViewHolder {

    public Holder(View view) {
      super(view);
    }
  }
}
