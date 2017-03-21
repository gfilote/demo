package repository;

import model.Internship;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import repository.interfaces.InternshipRepository;

import javax.annotation.Resource;
import java.util.List;

@Component
public class HibernateInternshipRepositoryImpl implements InternshipRepository {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List findAll() throws Exception {
        return null;
    }

    @Override
    public Internship addInternship(Internship internship) throws Exception {
        sessionFactory.getCurrentSession().save(internship);
        return internship;
    }

    @Override
    public Internship getInternshipById(String internshipUuid) throws Exception {
        return (Internship) sessionFactory.getCurrentSession().get(Internship.class, internshipUuid);
    }

    @Override
    public Internship updateInternship(String internshipUuid, Internship internship) throws Exception {
        Internship dbInternship = (Internship) sessionFactory.getCurrentSession().get(Internship.class, internshipUuid);
        dbInternship.setName(internship.getName());
        dbInternship.setDescription(internship.getDescription());
        sessionFactory.getCurrentSession().update(dbInternship);

        return dbInternship;
    }

    @Override
    public void deleteInternship(String internshipUuid) throws Exception {
        Internship internship = (Internship) sessionFactory.getCurrentSession().get(Internship.class, internshipUuid);
        sessionFactory.getCurrentSession().delete(internship);
    }
}
