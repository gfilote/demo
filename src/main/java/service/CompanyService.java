package service;

import manager.CompanyManager;
import model.Company;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/companies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyService {
    CompanyManager companyManager = new CompanyManager();

    @GET
    public List<Company> getCompanies() {
        List<Company> companies = null;
        try {
            return companyManager.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @POST
    public Company addCompany(Company company) {
        Company newCompany = null;
        try {
            newCompany = companyManager.addCompany(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newCompany;
    }

    @GET
    @Path("/{id}")
    public Company getCompany(@PathParam("id") String uuid) {
        Company company = null;
        try {
            company = companyManager.getCompanyById(uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @PUT
    @Path("/{id}")
    public Company updateCompany(@PathParam("id") String uuid, Company company) {
        Company updatedCompany = null;
        try {
            return companyManager.updateCompany(uuid, company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updatedCompany;
    }

    @DELETE
    @Path("/{id}")
    public void deleteCompany(@PathParam("id") String uuid) {

        try {
            companyManager.deleteCompany(uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

