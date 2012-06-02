package corvid.i18nhub.core.bean;

import java.util.Set;

import jay.util.DataBean;

public class ProjectDetails extends DataBean {
    private static final long serialVersionUID = 1L;

    private String name;
    
    private String description;
    
    private Set<Collaborator> collaborators;
    
    private Set<String> supportedLocales;
    
    private String defaultLocale;
    
    public ProjectDetails() {
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

    public Set<Collaborator> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(Set<Collaborator> collaborators) {
        this.collaborators = collaborators;
    }

    public Set<String> getSupportedLocales() {
        return supportedLocales;
    }

    public void setSupportedLocales(Set<String> supportedLocales) {
        this.supportedLocales = supportedLocales;
    }

    public String getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }
}
