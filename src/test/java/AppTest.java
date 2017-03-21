import model.Company;
import model.Internship;
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
        Internship internship;
        for (int i = 1; i < 5; i++) {
            company = new Company("Company " + i);

            for (int j = 1; j < 4; j++) {
                internship = new Internship("Internship " + i + j);
                internship.setCompany(company);
                company.getInternships().add(internship);
            }

            session.save(company);
            company.getInternships().forEach(internship1 -> session.save(internship1));
        }

        session.getTransaction().commit();
        session.close();
    }
}
