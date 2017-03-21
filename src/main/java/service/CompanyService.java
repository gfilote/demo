package service;

import api.CompanyAPI;
import dto.CompanyDTO;
import util.Adapter;
import view.CompanyView;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/companies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyService {
    @Resource
    private CompanyAPI companyAPI;

    @GET
    public List<CompanyView> getCompanies(@Context UriInfo uriInfo) {
        List<CompanyView> companyViews = new ArrayList<>();
        try {
            List<CompanyDTO> companyDTOS = companyAPI.findAll();
            companyDTOS.forEach(companyDTO -> {
                CompanyView companyView = Adapter.convertToView(companyDTO);
                companyView.addLink(getUriForSelf(uriInfo, companyView), "self");
                companyViews.add(companyView);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyViews;
    }

    @POST
    public CompanyView addCompany(CompanyView companyView) {
        try {
            companyView = Adapter.convertToView(companyAPI.addCompany(Adapter.convertToDto(companyView)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyView;
    }

    @GET
    @Path("/{companyUuid}")
    public CompanyView getCompany(@PathParam("companyUuid") String companyUuid, @Context UriInfo uriInfo) {
        CompanyView companyView = null;
        try {
            companyView = Adapter.convertToView(companyAPI.getCompanyById(companyUuid));
            companyView.addLink(getUriForSelf(uriInfo, companyView), "self");
            companyView.addLink(getUriForInternships(uriInfo, companyView), "internships");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyView;
    }

    @PUT
    @Path("/{companyUuid}")
    public CompanyView updateCompany(@PathParam("companyUuid") String companyUuid, CompanyView companyView) {
        try {
            CompanyDTO companyDTO = companyAPI.updateCompany(companyUuid, Adapter.convertToDto(companyView));
            companyView = Adapter.convertToView(companyDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyView;
    }

    @DELETE
    @Path("/{companyUuid}")
    public void deleteCompany(@PathParam("companyUuid") String companyUuid) {
        try {
            companyAPI.deleteCompany(companyUuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getUriForSelf(UriInfo uriInfo, CompanyView companyView) {
        String uri = uriInfo.getBaseUriBuilder()
                .path(CompanyService.class)
                .path(companyView.getUuid())
                .build()
                .toString();
        return uri;
    }

    private String getUriForInternships(UriInfo uriInfo, CompanyView companyView) {
        URI uri = uriInfo.getBaseUriBuilder()
                .path(InternshipService.class)
                .resolveTemplate("companyUuid", companyView.getUuid())
                .build();
        return uri.toString();
    }

}

