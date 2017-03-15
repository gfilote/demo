import entity.UserDetails;
import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class AppTest extends TestCase {

    public void testApp() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        UserDetails user;
        for (int i = 1; i < 5; i++) {
            user = new UserDetails();
            user.setUserName("User " + i);
            session.save(user);
        }

        session.getTransaction().commit();
        session.close();
    }
}
