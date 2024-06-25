package Ninja.coder.Ghostemane.code.adapter;

import Ninja.coder.Ghostemane.code.R;
import Ninja.coder.Ghostemane.code.model.ProjectModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProjectManagerAdapter extends RecyclerView.Adapter<ProjectManagerAdapter.ViewHolder> {
    protected List<ProjectModel> projectModel;
    protected OnProjectClick projectClickItem;

    public ProjectManagerAdapter(List<ProjectModel> projectModel, OnProjectClick projectClickItem) {
        this.projectModel = projectModel;
        this.projectClickItem = projectClickItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View _v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewproject, parent, false);
        RecyclerView.LayoutParams _lp =
                new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        _v.setLayoutParams(_lp);
        return new ViewHolder(_v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        View views = holder.itemView;

        ProjectModel md = projectModel.get(position);

        holder.nameIcon.setText(md.nameProject);
        holder.iconProject.setImageResource(md.iconProject);
        holder.root.setEnabled(!md.isWorkItem);
        if (projectClickItem != null) {
            views.setOnClickListener(v -> projectClickItem.onClick(v, position));
        }
    }

    @Override
    public int getItemCount() {
        return projectModel.size();
    }

    public interface OnProjectClick {
        public void onClick(View view, int pos);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView iconProject;
        protected TextView nameIcon;
        private LinearLayout root;

        public ViewHolder(View v) {
            super(v);
            root = v.findViewById(R.id.root_layout_project);
            iconProject = v.findViewById(R.id.icon_project_name);
            nameIcon = v.findViewById(R.id.tv_model_item_project);

        }
    }
}
