package api;

import dto.CompanyDTO;
import model.Company;
import org.springframework.stereotype.Service;
import repository.interfaces.CompanyRepository;
import util.Adapter;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CompanyAPI {
    @Resource
    private CompanyRepository companyRepository;

    public List<CompanyDTO> findAll() throws Exception {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDTO> companiesDTO = new ArrayList<>();
        companies.forEach(company -> companiesDTO.add(Adapter.convertToDto(company)));
        return companiesDTO;
    }

    public CompanyDTO addCompany(CompanyDTO companyDTO) throws Exception {
        Company company = companyRepository.addCompany(Adapter.convertToEntity(companyDTO));
        return Adapter.convertToDto(company);
    }

    public CompanyDTO getCompanyById(String uuid) throws Exception {
        Company company = companyRepository.getCompanyById(uuid);
        return Adapter.convertToDto(company);
    }

    public CompanyDTO updateCompany(String uuid, CompanyDTO companyDTO) throws Exception {
        Company company = companyRepository.updateCompany(uuid, Adapter.convertToEntity(companyDTO));
        return Adapter.convertToDto(company);
    }

    public void deleteCompany(String uuid) throws Exception {
        companyRepository.deleteCompany(uuid);
    }

}



