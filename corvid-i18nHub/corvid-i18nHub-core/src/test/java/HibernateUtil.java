import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public static void configure() {
        AnnotationConfiguration configuration = new AnnotationConfiguration().configure("hibernate_cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }
}
