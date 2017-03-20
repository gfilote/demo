package service;

import api.CompanyAPI;
import dto.CompanyDTO;
import util.Adapter;
import view.CompanyView;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/companies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyService {
    @Resource
    private CompanyAPI companyAPI;

    @GET
    public List<CompanyView> getCompanies() {
        List<CompanyView> companies = new ArrayList<>();
        try {
            List<CompanyDTO> companiesDTO = companyAPI.findAll();
            companiesDTO.forEach(company -> companies.add(Adapter.convertToView(company)));
            return companies;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companies;
    }

    @POST
    public CompanyView addCompany(CompanyView company) {
        CompanyView newCompany = null;
        try {
            companyAPI.addCompany(Adapter.convertToDto(company));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newCompany;
    }

    @GET
    @Path("/{id}")
    public CompanyView getCompany(@PathParam("id") String uuid) {
        CompanyView company = null;
        try {
            company = Adapter.convertToView(companyAPI.getCompanyById(uuid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    @PUT
    @Path("/{id}")
    public CompanyView updateCompany(@PathParam("id") String uuid, CompanyView company) {
        CompanyView updatedCompany = null;
        try {
            CompanyDTO newCompany = companyAPI.updateCompany(uuid, Adapter.convertToDto(company));
            return Adapter.convertToView(newCompany);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updatedCompany;
    }

    @DELETE
    @Path("/{id}")
    public void deleteCompany(@PathParam("id") String uuid) {
        try {
            companyAPI.deleteCompany(uuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

