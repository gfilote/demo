package repository;

import model.Company;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class HibernateCompanyRepositoryImpl implements CompanyRepository {
    Session session = null;

    @Override
    public List findAll() throws Exception {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        List companyList = session.createCriteria(Company.class)
                .list();
        session.getTransaction().commit();
        session.close();
        return companyList;
    }

    @Override
    public Company addCompany(Company company) throws Exception {
        session = HibernateUtil.getSession();
        session.beginTransaction();

        company.setCreatedDate(new Date());
        session.save(company);

        session.getTransaction().commit();
        session.close();

        return company;
    }

    @Override
    public Company getCompanyById(String uuid) throws Exception {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        Company company = (Company) session.get(Company.class,
                uuid);
        session.getTransaction().commit();
        session.close();
        return company;
    }

    @Override
    public Company updateCompany(String uuid, Company company) throws Exception {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        Company repositoryCompany = (Company) session.get(Company.class,
                uuid);
        repositoryCompany.setCompanyName(company.getCompanyName());
        session.update(repositoryCompany);

        session.getTransaction().commit();
        session.close();
        return repositoryCompany;
    }

    @Override
    public boolean deleteCompany(String uuid)
            throws Exception {
        session = HibernateUtil.getSession();
        session.beginTransaction();

        Company company = (Company) session.get(Company.class, uuid);
        session.delete(company);

        session.getTransaction().commit();
        session.close();
        return false;
    }
}
