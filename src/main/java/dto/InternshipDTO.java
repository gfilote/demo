package dto;
import model.Company;

public class InternshipDTO {

    private String internshipUuid;
    private String name;
    private String description;
    private Company company;

    public String getInternshipUuid() {
        return internshipUuid;
    }

    public void setInternshipUuid(String internshipUuid) {
        this.internshipUuid = internshipUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
