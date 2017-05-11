package nl.scalda.pasimo.service;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOEducationTeam;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;

public class EducationTeamService {

    private static EducationTeamService instance;
    private Set<EducationTeam> educationTeams;

    public EducationTeamService() {
        educationTeams = DAOFactory.getTheFactory().getDAOEducationTeam().readAll();
    }

    public Set<EducationTeam> getEducationTeams() {
        return educationTeams;
    }

    public void saveEducationTeam(EducationTeam e) throws Exception {
        if (educationTeams.add(e)) {
            DAOFactory.getTheFactory().getDAOEducationTeam().save(e);
        } else {
            throw new Exception("Cannot save educationTeam");
        }
    }
    public EducationTeam read(int Id){
    	return MYSQLDAOEducationTeam.getInstance().read(Id);
    	
    }
    

    public static EducationTeamService getInstance() {
        if (instance == null) {
            instance = new EducationTeamService();
        }
        return instance;
    }

}
