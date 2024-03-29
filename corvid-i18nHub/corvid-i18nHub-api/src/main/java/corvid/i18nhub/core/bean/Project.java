package corvid.i18nhub.core.bean;

import jay.util.InfoBean;

public class Project extends InfoBean {
    private static final long serialVersionUID = 1L;

    private String name;
    
    private String description;

    public Project() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
