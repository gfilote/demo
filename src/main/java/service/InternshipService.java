package service;

import api.InternshipAPI;
import dto.InternshipDTO;
import util.Adapter;
import view.InternshipView;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/companies/{companyUuid}/internships")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InternshipService {
    @Resource
    private InternshipAPI internshipAPI;

    @GET
    public List<InternshipView> getInternships(@PathParam("companyUuid") String companyUuid) {
        List<InternshipView> internshipViews = new ArrayList<>();
        try {
            List<InternshipDTO> internshipDTOS = internshipAPI.getInternships(companyUuid);
            internshipDTOS.forEach(internshipDTO -> {
                InternshipView internshipView = Adapter.convertToView(internshipDTO);
                internshipView.setCompanyName(internshipDTO.getCompany().getCompanyName());
                internshipViews.add(internshipView);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return internshipViews;
    }

    @POST
    public InternshipView addInternship(@PathParam("companyUuid") String companyUuid, InternshipView internshipView) {
        try {
            InternshipDTO internshipDTO = internshipAPI.addInternship(companyUuid, Adapter.convertToDto(internshipView));
            internshipView = Adapter.convertToView(internshipDTO);
            internshipView.setCompanyName(internshipDTO.getCompany().getCompanyName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return internshipView;
    }

    @GET
    @Path("/{internshipUuid}")
    public InternshipView getInternship(@PathParam("internshipUuid") String internshipUuid) {
        InternshipView internshipView = null;
        try {
            InternshipDTO internshipDTO = internshipAPI.getInternshipById(internshipUuid);
            internshipView = Adapter.convertToView(internshipDTO);
            internshipView.setCompanyName(internshipDTO.getCompany().getCompanyName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return internshipView;
    }

    @PUT
    @Path("/{internshipUuid}")
    public InternshipView updateInternship(@PathParam("internshipUuid") String internshipUuid, InternshipView internshipView) {
        try {
            InternshipDTO internshipDTO = internshipAPI.updateInternship(internshipUuid, Adapter.convertToDto(internshipView));
            internshipView = Adapter.convertToView(internshipDTO);
            internshipView.setCompanyName(internshipDTO.getCompany().getCompanyName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return internshipView;
    }

    @DELETE
    @Path("/{internshipUuid}")
    public void deleteInternship(@PathParam("internshipUuid") String internshipUuid) {
        try {
            internshipAPI.deleteInternship(internshipUuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
