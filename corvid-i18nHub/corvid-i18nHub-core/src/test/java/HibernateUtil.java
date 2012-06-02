import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public static void configure() throws Exception {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure();
        
        sessionFactory = configuration.buildSessionFactory();
    }
}
