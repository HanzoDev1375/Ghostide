package ir.ninjacoder.ghostide.core.adapter;

import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import ir.ninjacoder.ghostide.core.R;
import ir.ninjacoder.ghostide.core.model.TextActionModel;

public class TextActionAd extends RecyclerView.Adapter<TextActionAd.ViewHolder> {

  protected List<TextActionModel> listmodel;
  protected OnItemClick onItemClick;
  protected CodeEditor editor;

  public TextActionAd(List<TextActionModel> listmodel, OnItemClick onItemClick, CodeEditor editor) {
    this.listmodel = listmodel;
    this.onItemClick = onItemClick;
    this.editor = editor;
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
    holder.icon.setColorFilter(
        editor.getColorScheme().getColor(EditorColorScheme.AUTO_COMP_PANEL_CORNER), PorterDuff.Mode.SRC_IN);
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
