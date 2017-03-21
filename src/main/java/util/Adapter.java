package util;

import dto.CompanyDTO;
import dto.InternshipDTO;
import model.Company;
import model.Internship;
import org.modelmapper.ModelMapper;
import view.CompanyView;
import view.InternshipView;

public class Adapter {

    public static CompanyDTO convertToDto(Company company) {
        ModelMapper modelMapper = new ModelMapper();
        CompanyDTO companyDTO = modelMapper.map(company, CompanyDTO.class);

        return companyDTO;
    }

    public static CompanyDTO convertToDto(CompanyView company) {
        ModelMapper modelMapper = new ModelMapper();
        CompanyDTO companyDTO = modelMapper.map(company, CompanyDTO.class);

        return companyDTO;
    }

    public static Company convertToEntity(CompanyDTO companyDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Company company = modelMapper.map(companyDTO, Company.class);

        return company;
    }

    public static CompanyView convertToView(CompanyDTO companyDTO) {
        ModelMapper modelMapper = new ModelMapper();
        CompanyView company = modelMapper.map(companyDTO, CompanyView.class);

        return company;
    }

    public static InternshipDTO convertToDto(Internship internship) {
        ModelMapper modelMapper = new ModelMapper();
        InternshipDTO internshipDTO = modelMapper.map(internship, InternshipDTO.class);

        return internshipDTO;
    }

    public static InternshipDTO convertToDto(InternshipView internship) {
        ModelMapper modelMapper = new ModelMapper();
        InternshipDTO internshipDTO = modelMapper.map(internship, InternshipDTO.class);

        return internshipDTO;
    }

    public static Internship convertToEntity(InternshipDTO internshipDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Internship internship = modelMapper.map(internshipDTO, Internship.class);

        return internship;
    }

    public static InternshipView convertToView(InternshipDTO internshipDTO) {
        ModelMapper modelMapper = new ModelMapper();
        InternshipView internship = modelMapper.map(internshipDTO, InternshipView.class);

        return internship;
    }
}
