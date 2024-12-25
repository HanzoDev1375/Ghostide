package ir.ninjacoder.ghostide.adapter;

import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.folder.FileIconHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class ZipListFileShowAd extends RecyclerView.Adapter<ZipListFileShowAd.VH> {

  protected List<String> listModel;

  public ZipListFileShowAd(List<String> listModel) {
    this.listModel = listModel;
  }

  @Override
  public int getItemCount() {
    return listModel.size();
  }

  @Override
  public void onBindViewHolder(VH viewHolder, int pos) {
    View view = viewHolder.itemView;
    RecyclerView.LayoutParams layoutParams =
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    view.setLayoutParams(layoutParams);
    var fileHeader = listModel.get(pos);
    
    File file = new File(fileHeader);
    String displayName = file.getName();
    FileIconHelper helper = new FileIconHelper(fileHeader);
    helper.setDynamicFolderEnabled(true);
    helper.setEnvironmentEnabled(true);

    if (file.isDirectory()) {
      viewHolder.tvTools.setVisibility(View.GONE);
      viewHolder.icon.setImageResource(R.drawable.folder);
    } else {
      viewHolder.icon.setImageResource(helper.getFileIcon());
      
      viewHolder.icon.setImageResource(R.drawable.file);
    }

    viewHolder.folderName.setText(displayName);

    
  }

  @Override
  public VH onCreateViewHolder(ViewGroup parnt, int pos) {
    View view =
        LayoutInflater.from(parnt.getContext()).inflate(R.layout.folder_remster, parnt, false);
    RecyclerView.LayoutParams _lp =
        new RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    view.setLayoutParams(_lp);
    return new VH(view);
  }

  
  public class VH extends RecyclerView.ViewHolder {
    protected TextView folderName, tvTools;
    protected LinearLayout roots;
    protected ImageView icon;

    public VH(View view) {
      super(view);
      folderName = view.findViewById(R.id.folderName);
      tvTools = view.findViewById(R.id.tvTools);
      roots = view.findViewById(R.id.roots);
      icon = view.findViewById(R.id.icon);
    }
  }
}
