package corvid.i18nhub.core;

import java.util.List;
import java.util.Set;

import corvid.i18nhub.core.bean.BundleEntries;
import corvid.i18nhub.core.bean.Collaborator;
import corvid.i18nhub.core.bean.CollaboratorRole;
import corvid.i18nhub.core.bean.Project;
import corvid.i18nhub.core.search.BundleSearchCriteria;

public interface ProjectService {
    Project createProject(Project project);
    
    Project getProjectById(long projectId);
    
    void updateProject(Project project);
    
    void deleteProjectById(long projectId);
    
    void deleteProjectsById(long [] projectIds);
    
    List<Project> getProjects();
    
    void addCollaborator(long projectId, Collaborator collaborator);
    
    List<Collaborator> getCollaborators(long projectId);
    
    List<Collaborator> getCollaboratorsByRole(long projectId, CollaboratorRole role);
    
    void updateCollaborator(long projectId, Collaborator collaborator);
    
    void deleteCollaboratorByName(long projectId, String name);
    
    Set<String> getBundleNames(long projectId);
    
    BundleEntries getBundleEntries(String bundleName);
    
    BundleEntries getBundleEntriesByCriteria(BundleSearchCriteria criteria);
}
