package ir.ninjacoder.ghostide.core.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.color.MaterialColors;

import java.util.List;

import ir.ninjacoder.ghostide.core.databinding.ViewprojectBinding;
import ir.ninjacoder.ghostide.core.model.ProjectModel;
import ir.ninjacoder.ghostide.core.utils.ObjectUtils;
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
