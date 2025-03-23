package ir.ninjacoder.ghostide.adapter;

import com.google.android.material.color.MaterialColors;
import ir.ninjacoder.ghostide.databinding.ViewprojectBinding;
import ir.ninjacoder.ghostide.model.ProjectModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import ir.ninjacoder.ghostide.utils.ObjectUtils;
import java.util.List;
public class ProjectManagerAdapter extends RecyclerView.Adapter<ProjectManagerAdapter.ViewHolder> {
  protected List<ProjectModel> projectModel;
  protected OnProjectClick projectClickItem;
  private ViewprojectBinding binding;

  public ProjectManagerAdapter(List<ProjectModel> projectModel, OnProjectClick projectClickItem) {
    this.projectModel = projectModel;
    this.projectClickItem = projectClickItem;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    binding = ViewprojectBinding.inflate(LayoutInflater.from(parent.getContext()));
    return new ViewHolder(binding.getRoot());
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    View views = holder.itemView;

    ProjectModel md = projectModel.get(position);
    
    binding.tvModelItemProject.setText(md.nameProject);
    binding.iconProjectName.setImageResource(md.iconProject);
    binding.getRoot().setEnabled(!md.isWorkItem);
    if (projectClickItem != null) {
      views.setOnClickListener(v -> projectClickItem.onClick(v, position));
    }
    binding.iconProjectName.setColorFilter(
        MaterialColors.getColor(binding.iconProjectName, ObjectUtils.ColorFilter));
    binding.tvModelItemProject.setTextColor(MaterialColors.getColor(binding.tvModelItemProject, ObjectUtils.TvColor));
  }

  @Override
  public int getItemCount() {
    return projectModel.size();
  }

  public interface OnProjectClick {
    public void onClick(View view, int pos);
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View v) {
      super(v);
    }
  }
}
