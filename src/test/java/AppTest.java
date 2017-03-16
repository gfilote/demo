import entity.CompanyDetails;
import entity.UserDetails;
import junit.framework.TestCase;
import org.hibernate.Session;
import server.util.HibernateUtil;


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

        CompanyDetails company;
        for (int i = 1; i < 5; i++) {
            company = new CompanyDetails("Company " + i);
            company.setCompanyName("Company " + i);
            session.save(company);
        }

        session.getTransaction().commit();
        session.close();
    }
}
