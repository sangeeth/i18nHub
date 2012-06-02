import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import corvid.i18nhub.core.entity.BundleEntity;
import corvid.i18nhub.core.entity.CollaboratorEntity;
import corvid.i18nhub.core.entity.LocaleEntity;
import corvid.i18nhub.core.entity.MessageEntity;
import corvid.i18nhub.core.entity.ProjectEntity;
import corvid.i18nhub.core.entity.UserEntity;

public class TestEntities2 {

    
    private static void fillUsers() {
        Session session = HibernateUtil.getSession();
        
        
        Transaction txn = session.beginTransaction();
        
        try {
            String [] users = {"sangeeth","priya","rsdurai" };
            
            for(String user:users) {
                UserEntity userEntity = new UserEntity();
                userEntity.setName(user);
                userEntity.setEmailAddress(user+"@corvid.in");
                session.save(userEntity);
            }
            
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        txn.commit();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        HibernateUtil.configure();

        Session session = HibernateUtil.getSession();
        
        ProjectEntity project;
        Transaction txn;

        //fillUsers();
        
        session = HibernateUtil.getSession();
        
        txn = session.beginTransaction();
        
        String projectName = "i18nHub31";
       
        project = new ProjectEntity();
        project.setName(projectName);
        
        LocaleEntity en = (LocaleEntity)session.get(LocaleEntity.class, 1L);
        LocaleEntity ko = (LocaleEntity)session.get(LocaleEntity.class, 2L);
        project.setSupportedLocales(Arrays.asList(en,ko));
        project.setDefaultLocale(en);
        
        Serializable projectId = session.save(project);
        
        txn.commit();
        
        session = HibernateUtil.getSession();
        
        txn = session.beginTransaction();
        
        project = (ProjectEntity)session.get(ProjectEntity.class, projectId);
        
        CollaboratorEntity sangeeth = new CollaboratorEntity();
        sangeeth.setProject(project);
        sangeeth.setRole("Moderator");
        sangeeth.setUser((UserEntity)session.get(UserEntity.class, 3L));
        session.save(sangeeth);
        
        CollaboratorEntity priya = new CollaboratorEntity();
        priya.setProject(project);
        priya.setRole("Member");
        priya.setUser((UserEntity)session.get(UserEntity.class, 4L));
        session.save(priya);
        
        txn.commit();
        
        session = HibernateUtil.getSession();
        
        txn = session.beginTransaction();
        
        Query q = session.createQuery(String.format("from ProjectEntity where name = '%s'",projectName));
        List<ProjectEntity> entities = (List<ProjectEntity>)q.list();
        if (!entities.isEmpty()) {
            project = entities.get(0);
            if (project!=null) {
                List<CollaboratorEntity> collaborators = project.getCollaborators();
                if (collaborators!=null) {
                    System.out.println("Collaborators");
                    for(CollaboratorEntity collaborator:collaborators) {
                        System.out.printf("User: %s; Project: %s: Role: %s\n", collaborator.getUser().getName(), collaborator.getProject().getName(), collaborator.getRole());
                    }
                }
                System.out.println("Default Locale: " + project.getDefaultLocale().getCode());
            }        
        }
        
        txn.commit();
    }

}
