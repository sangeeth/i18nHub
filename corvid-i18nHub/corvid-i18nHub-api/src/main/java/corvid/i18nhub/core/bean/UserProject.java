package corvid.i18nhub.core.bean;

import java.io.Serializable;

public class UserProject implements Serializable {
    private static final long serialVersionUID = 1L;

    private long projectId;
    
    private String projectName;
    
    private String projectDescription;
    
    private CollaboratorRole role;

    public UserProject() {
        super();
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public CollaboratorRole getRole() {
        return role;
    }

    public void setRole(CollaboratorRole role) {
        this.role = role;
    }
}
