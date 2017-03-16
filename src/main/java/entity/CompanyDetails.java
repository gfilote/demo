package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity(name="company")
@XmlRootElement(name = "CompanyDetails")
public class CompanyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private int companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "created_date")
    private Date createdDate;

    public CompanyDetails() {}

    public CompanyDetails(String companyName) {
        this.companyName = companyName;
        this.createdDate = new Date();
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
