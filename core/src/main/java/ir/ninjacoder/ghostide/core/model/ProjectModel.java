package ir.ninjacoder.ghostide.core.model;

public class ProjectModel {

  public String nameProject;
  public int iconProject;
  public boolean isWorkItem;

  public ProjectModel(String nameProject, int iconProject, boolean isWorkItem) {
    this.nameProject = nameProject;
    this.iconProject = iconProject;
    this.isWorkItem = isWorkItem;
  }

  public String getNameProject() {
    return this.nameProject;
  }

  public void setNameProject(String nameProject) {
    this.nameProject = nameProject;
  }

  public int getIconProject() {
    return this.iconProject;
  }

  public void setIconProject(int iconProject) {
    this.iconProject = iconProject;
  }

  public boolean getIsWorkItem() {
    return this.isWorkItem;
  }

  public void setIsWorkItem(boolean isWorkItem) {
    this.isWorkItem = isWorkItem;
  }
}
