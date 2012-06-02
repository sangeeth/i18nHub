package corvid.i18nhub.core.bean;

import java.io.Serializable;

public class Collaborator implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    
    private CollaboratorRole role;

    public Collaborator() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CollaboratorRole getRole() {
        return role;
    }

    public void setRole(CollaboratorRole role) {
        this.role = role;
    }
}
