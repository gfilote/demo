package model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity(name = "company")
public class Company {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    @JsonIgnore
    private String uuid;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "created_date")
    private Date createdDate;
    @OneToMany(mappedBy = "company")
    private Collection<Internship> internships = new ArrayList<>();


    public Company() {
        this.createdDate = new Date();
    }

    public Company(String companyName) {
        this.companyName = companyName;
        this.createdDate = new Date();
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Collection<Internship> getInternships() {
        return internships;
    }

    public void setInternships(Collection<Internship> internships) {
        this.internships = internships;
    }
}
