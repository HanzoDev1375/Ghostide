package ir.ninjacoder.prograsssheet.fileinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import ir.ninjacoder.prograsssheet.R;
import java.util.ArrayList;
import java.util.List;

public class FileInfoAdapter extends RecyclerView.Adapter<FileInfoAdapter.VH> {
  private List<FileInfoModel> model = new ArrayList<>();

  public FileInfoAdapter(List<FileInfoModel> model) {
    this.model = model;
  }

  class VH extends RecyclerView.ViewHolder {
    private TextInputLayout input;

    public VH(View view) {
      super(view);
      input = view.findViewById(R.id.input);
    }
    
    public void bindOf(FileInfoModel model){
      input.setHint(model.getFileHint());
      input.getEditText().setText(model.getFileName());
    }
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parant, int viewtype) {
    return new VH(
        LayoutInflater.from(parant.getContext()).inflate(R.layout.file_infolayout, parant, false));
  }

  @Override
  public void onBindViewHolder(VH holder, int pos) {
    holder.bindOf(model.get(pos));
  }

  @Override
  public int getItemCount() {
    return model.size();
  }
}
