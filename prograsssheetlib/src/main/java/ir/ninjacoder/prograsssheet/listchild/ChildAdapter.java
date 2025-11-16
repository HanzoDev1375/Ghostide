package ir.ninjacoder.prograsssheet.listchild;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.Holder> {

  List<ChildIconEditorManager> model = new ArrayList<>();
  protected ImageView icon;

  public ChildAdapter(List<ChildIconEditorManager> model) {
    this.model = model;
  }

  class Holder extends RecyclerView.ViewHolder {

    public Holder(View v) {
      super(v);
      icon = new ImageView(v.getContext());
      icon.setPadding(9, 9, 9, 9);
      icon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      var param =
          new ViewGroup.LayoutParams(
              ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
      icon.setLayoutParams(param);
    }

    void bind(ChildIconEditorManager ic) {
      Glide.with(icon.getContext())
          .load(ic.getIconFile())
          .error(new ColorDrawable(Color.RED))
          .into(icon);

      icon.setOnClickListener(
          v -> {
            if (ic != null)
              ic.getClick().click(v, getAdapterPosition(), v.getId(), icon.isEnabled());
          });
    }
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup arg0, int arg1) {
    return new Holder(icon);
  }

  @Override
  public void onBindViewHolder(Holder holder, int pos) {}

  @Override
  public int getItemCount() {
    return model.size();
  }
}
