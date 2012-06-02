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

public class TestEntities {

    private static void fillAvailableLocale() {
        Session session = HibernateUtil.getSession();
        
        
        Transaction txn = session.beginTransaction();
        
        try {
            String [] languages = {"en","ko","ta","zh" };
            
            for(String language:languages) {
                LocaleEntity localeEntity = new LocaleEntity();
                localeEntity.setCode(language);
                session.save(localeEntity);
            }
            
            txn.commit();
            
            session.flush();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void fillUsers() {
        Session session = HibernateUtil.getSession();
        
        
        Transaction txn = session.beginTransaction();
        
        try {
            String [] users = {"priya","priya","rsdurai" };
            
            for(String user:users) {
                UserEntity userEntity = new UserEntity();
                userEntity.setName(user);
                userEntity.setEmailAddress(user+"@corvid.in");
                session.save(userEntity);
            }
            
            txn.commit();
            
            session.flush();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }        
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        HibernateUtil.configure();

        Session session = HibernateUtil.getSession();
        
        ProjectEntity project;
        Transaction txn;

        fillAvailableLocale();
        fillUsers();
        
        session = HibernateUtil.getSession();
        
        txn = session.beginTransaction();
       
        project = new ProjectEntity();
        project.setName("i18nHub21");
        
        LocaleEntity en = (LocaleEntity)session.get(LocaleEntity.class, 1L);
        LocaleEntity ko = (LocaleEntity)session.get(LocaleEntity.class, 2L);
        project.setSupportedLocales(Arrays.asList(en,ko));
        project.setDefaultLocale(en);
        
        Serializable projectId = session.save(project);
        
        project = (ProjectEntity)session.get(ProjectEntity.class, projectId);
        
        CollaboratorEntity sangeeth = new CollaboratorEntity();
        sangeeth.setProject(project);
        sangeeth.setRole("Moderator");
        sangeeth.setUser((UserEntity)session.get(UserEntity.class, 1L));
        session.save(sangeeth);
        
        CollaboratorEntity priya = new CollaboratorEntity();
        priya.setProject(project);
        priya.setRole("Member");
        priya.setUser((UserEntity)session.get(UserEntity.class, 2L));
        session.save(priya);
        
        session.flush();
        
        BundleEntity bundleEntity = new BundleEntity();
        
        project = (ProjectEntity)session.get(ProjectEntity.class, projectId);
        bundleEntity.setProject(project);
        bundleEntity.setBundleName("AdminSnippet");
        Serializable bundleId = session.save(bundleEntity);
        
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setBundle((BundleEntity)session.get(BundleEntity.class, bundleId));
        messageEntity.setKey("greet");
        messageEntity.setValue("Hello {0}");
        messageEntity.setLanguageCode("en");
        session.save(messageEntity);
        
        bundleEntity = new BundleEntity();
        
        project = (ProjectEntity)session.get(ProjectEntity.class, projectId);
        bundleEntity.setProject(project);
        bundleEntity.setBundleName("SummarySnippet");
        bundleId = session.save(bundleEntity);        
        
        messageEntity = new MessageEntity();
        messageEntity.setBundle((BundleEntity)session.get(BundleEntity.class, bundleId));
        messageEntity.setKey("greet");
        messageEntity.setValue("Hello {0}");
        messageEntity.setLanguageCode("en");
        session.save(messageEntity);
        
        session.flush();
        
        txn.commit();
        
        
        
        session = HibernateUtil.getSession();
        
        txn = session.beginTransaction();
        
        Query q = session.createQuery("from ProjectEntity where name = 'i18nHub20'");
        List<ProjectEntity> entities = (List<ProjectEntity>)q.list();
        if (!entities.isEmpty()) {
            project = entities.get(0);
            if (project!=null) {
                List<BundleEntity> bundles = project.getBundles();
                
                if (bundles!=null) {
                    for(BundleEntity bundle:bundles) {
                         System.out.println("Bundle: "+ bundle.getBundleName());
                         
                         List<MessageEntity> messages = bundle.getMessages();
                         for(MessageEntity message:messages) {
                             System.out.println(message.getKey() + " = " + message.getValue());
                         }
                         
                         System.out.println();
                    }
                }
                
                List<CollaboratorEntity> collaborators = project.getCollaborators();
                if (collaborators!=null) {
                    System.out.println("Collaborators");
                    for(CollaboratorEntity collaborator:collaborators) {
                        System.out.printf("User: %s; Project: %s: Role: %s\n", collaborator.getUser().getName(), collaborator.getProject().getName(), collaborator.getRole());
                    }
                }
                
                List<LocaleEntity> supportedLocales = project.getSupportedLocales();
                if (supportedLocales!=null) {
                    System.out.println("Supported Locales");
                    for(LocaleEntity locale:supportedLocales) {
                        System.out.printf("Code: %s\n", locale.getCode());
                    }
                }
                
                System.out.println("Default Locale: " + project.getDefaultLocale().getCode());
            }        
        }
        
        txn.commit();
    }

}
