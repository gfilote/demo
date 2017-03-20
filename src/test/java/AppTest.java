import model.Company;
import model.UserDetails;
import junit.framework.TestCase;
import org.hibernate.Session;
import util.HibernateUtil;


public class AppTest extends TestCase {

    public void testApp() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        UserDetails user;
        for (int i = 1; i < 5; i++) {
            user = new UserDetails();
            user.setUserName("User " + i);
            session.save(user);
        }

        Company company;
        for (int i = 1; i < 5; i++) {
            company = new Company("Company " + i);
            session.save(company);
        }

        session.getTransaction().commit();
        session.close();
    }
}
