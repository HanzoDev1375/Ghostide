package ir.ninjacoder.prograsssheet.listchild;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ir.ninjacoder.prograsssheet.R;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.Holder> {

  List<ChildIconEditorManager> model = new ArrayList<>();

  public ChildAdapter(List<ChildIconEditorManager> model) {
    this.model = model;
  }

  class Holder extends RecyclerView.ViewHolder {
    ImageView icon;

    public Holder(View v) {
      super(v);
      icon = v.findViewById(R.id.icon);
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
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child, parent, false);
    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(Holder holder, int pos) {
    holder.bind(model.get(pos));
  }

  @Override
  public int getItemCount() {
    return model.size();
  }
}
