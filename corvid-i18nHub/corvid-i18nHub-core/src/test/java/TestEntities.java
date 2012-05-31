import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import corvid.i18nhub.core.entity.BundleEntity;
import corvid.i18nhub.core.entity.MessageEntity;
import corvid.i18nhub.core.entity.ProjectEntity;


public class TestEntities {

    /**
     * @param args
     */
    public static void main(String[] args) {
        HibernateUtil.configure();

        Session session = HibernateUtil.getSession();
        
        Transaction txn = session.beginTransaction();
        
        System.out.println(session.get(ProjectEntity.class, 1L));
        
        Query query;

        query = session.createQuery("delete from ProjectEntity");
        query.executeUpdate();

        query = session.createQuery("delete from BundleEntity");
        query.executeUpdate();
        
        ProjectEntity project = new ProjectEntity();
        project.setName("i18nHub");
        Serializable projectId = session.save(project);
        
        BundleEntity bundleEntity = new BundleEntity();
        
        project = (ProjectEntity)session.get(ProjectEntity.class, projectId);
        System.out.println(project.getId());
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
        System.out.println(project.getId());
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
    }

}
