package api;

import dto.InternshipDTO;
import model.Company;
import model.Internship;
import org.springframework.stereotype.Service;
import repository.interfaces.CompanyRepository;
import repository.interfaces.InternshipRepository;
import util.Adapter;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class InternshipAPI {
    @Resource
    private CompanyRepository companyRepository;
    @Resource
    private InternshipRepository internshipRepository;

    public List<InternshipDTO> getInternships(String companyUuid) throws Exception{
        Company company = companyRepository.getCompanyById(companyUuid);
        Collection<Internship> internships = company.getInternships();

        List<InternshipDTO> internshipsDTO = new ArrayList<>();
        internships.forEach(internship -> internshipsDTO.add(Adapter.convertToDto(internship)));
        return internshipsDTO;
    }

    public InternshipDTO addInternship(String companyUuid, InternshipDTO internshipDTO) throws Exception {
        Company company = companyRepository.getCompanyById(companyUuid);
        Internship internship = Adapter.convertToEntity(internshipDTO);
        internship.setCompany(company);
        internship = internshipRepository.addInternship(internship);
        return Adapter.convertToDto(internship);
    }

    public InternshipDTO getInternshipById(String internshipUuid) throws Exception {
        Internship internship = internshipRepository.getInternshipById(internshipUuid);
        return Adapter.convertToDto(internship);
    }

    public InternshipDTO updateInternship(String internshipUuid, InternshipDTO internshipDTO) throws Exception {
        Internship internship = internshipRepository.updateInternship(internshipUuid, Adapter.convertToEntity(internshipDTO));
        return Adapter.convertToDto(internship);
    }

    public void deleteInternship(String internshipUuid)
            throws Exception {
        internshipRepository.deleteInternship(internshipUuid);
    }
}
