package nl.scalda.pasimo.employeeManagement.service;

import nl.scalda.pasimo.employeeManagement.datalayer.IEducationTeamDAO;
import nl.scalda.pasimo.employeeManagement.model.EducationTeam;
import nl.scalda.pasimo.foundation.service.Service;

import java.util.TreeSet;

public class EducationTeamDAOService {

    public void create(EducationTeam educationTeam)
    {
        this.getDAO().create(educationTeam);
    }

    public void update(EducationTeam educationTeam)
    {
        this.getDAO().update(educationTeam);
    }

    public void save(EducationTeam educationTeam)
    {
        this.getDAO().save(educationTeam);
    }

    public void delete(EducationTeam educationTeam)
    {
        this.getDAO().delete(educationTeam);
    }

    public EducationTeam read(String abbreviation)
    {
        return this.getDAO().read(abbreviation);
    }

    public TreeSet<EducationTeam> readAll()
    {
        return this.getDAO().readAll();
    }

    public boolean exist(EducationTeam educationTeam)
    {
        return this.getDAO().exist(educationTeam);
    }

    public boolean exist(String abbreviation)
    {
        return this.getDAO().exist(abbreviation);
    }

    private IEducationTeamDAO getDAO()
    {
        return Service.getDAOFactoryService().getFactory().getEducationTeamDAO();
    }

    private static EducationTeamDAOService instance;

    public static EducationTeamDAOService getInstance()
    {
        if (instance == null)
            instance = new EducationTeamDAOService();
        return instance;
    }

}
