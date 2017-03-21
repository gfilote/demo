package repository;

import model.Company;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import repository.interfaces.CompanyRepository;

import javax.annotation.Resource;
import java.util.List;

@Component
public class HibernateCompanyRepositoryImpl implements CompanyRepository {
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List findAll() throws Exception {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Company.class);
        return criteria.list();
    }

    @Override
    public Company addCompany(Company company) throws Exception {
        sessionFactory.getCurrentSession().save(company);
        return company;
    }

    @Override
    public Company getCompanyById(String uuid) throws Exception {
        return (Company) sessionFactory.getCurrentSession().get(Company.class, uuid);
    }

    @Override
    public Company updateCompany(String uuid, Company company) throws Exception {
        Company dbCompany = (Company) sessionFactory.getCurrentSession().get(Company.class, uuid);
        dbCompany.setCompanyName(company.getCompanyName());
        sessionFactory.getCurrentSession().update(dbCompany);
        return dbCompany;
    }

    @Override
    public void deleteCompany(String uuid) throws Exception {
        Company company = (Company) sessionFactory.getCurrentSession().get(Company.class, uuid);
        sessionFactory.getCurrentSession().delete(company);
    }
}
