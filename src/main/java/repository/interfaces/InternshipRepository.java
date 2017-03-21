package repository.interfaces;

import model.Internship;

import java.util.List;

public interface InternshipRepository {

    public List findAll() throws Exception;

    public Internship addInternship(Internship internship) throws Exception;

    public Internship getInternshipById(String id) throws Exception;

    public Internship updateInternship(String id, Internship internship) throws Exception;

    public void deleteInternship(String id) throws Exception;
}
