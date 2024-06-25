package Ninja.coder.Ghostemane.code.project;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    private String projectName;
    private String projectDir;
    private List<ProjectManager> listProject = new ArrayList<>();

    public ProjectManager() {
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDir() {
        return this.projectDir;
    }

    public void setProjectDir(String projectDir) {
        this.projectDir = projectDir;
    }

    public List<ProjectManager> getListProject() {
        return this.listProject;
    }

    public void setListProject(List<ProjectManager> listProject) {
        this.listProject = listProject;
    }
}
