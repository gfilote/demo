package server.service;

import entity.CompanyDetails;
import org.hibernate.Session;
import server.util.HibernateUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("/companies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyService {

    @GET
    public List<CompanyDetails> getCompanyDetails() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        List<CompanyDetails> companies = session.createCriteria(CompanyDetails.class).list();

        session.getTransaction().commit();
        session.close();
        return companies;
    }

    @POST
    public CompanyDetails updateCompanyDetails(CompanyDetails company) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        company.setCreatedDate(new Date());
        session.save(company);

        session.getTransaction().commit();
        session.close();
        return company;
    }

    @GET
    @Path("/{id}")
    public CompanyDetails getCompanyDetails(@PathParam("id") String id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        CompanyDetails company = (CompanyDetails) session.get(CompanyDetails.class, id);

        session.getTransaction().commit();
        session.close();

        return company;
    }



    @PUT
    @Path("/{id}")
    public CompanyDetails addCompanyDetails(@PathParam("id") String id, CompanyDetails company) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        CompanyDetails originalCompany = (CompanyDetails) session.get(CompanyDetails.class, id);
        originalCompany.setCompanyName(company.getCompanyName());
        session.update(originalCompany);

        session.getTransaction().commit();
        session.close();
        return company;
    }

    @DELETE
    @Path("/{id}")
    public void deleteCompany(@PathParam("id") String id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        CompanyDetails company = (CompanyDetails) session.get(CompanyDetails.class, id);
        session.delete(company);

        session.getTransaction().commit();
        session.close();
    }
}
