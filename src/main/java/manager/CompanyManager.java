package manager;

import model.Company;
import org.hibernate.Session;
import repository.CompanyRepository;
import repository.HibernateCompanyRepositoryImpl;
import util.HibernateUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyManager {
    private CompanyRepository companyRepository = new HibernateCompanyRepositoryImpl();

    public List<Company> findAll() throws Exception {
        return companyRepository.findAll();
    }

    public Company addCompany(Company company) throws Exception {
        companyRepository.addCompany(company);
        return company;
    }

    public Company getCompanyById(String uuid) throws Exception {
        Company company = companyRepository.getCompanyById(uuid);
        return company;
    }

    public Company updateCompany(String uuid, Company company) throws Exception {
        Company newCompany = companyRepository.updateCompany(uuid, company);
        return newCompany;
    }

    public boolean deleteCompany(String uuid)
            throws Exception {
        companyRepository.deleteCompany(uuid);
        return false;
    }

}



