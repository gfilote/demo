package util;

import dto.CompanyDTO;
import model.Company;
import org.modelmapper.ModelMapper;
import view.CompanyView;

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
}
