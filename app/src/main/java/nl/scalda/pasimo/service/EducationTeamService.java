package nl.scalda.pasimo.service;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOEducationTeam;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class EducationTeamService {
	
	private static EducationTeamService instance;
	private Set<EducationTeam> educationTeams;
	
	public EducationTeamService() {
        educationTeams = DAOFactory.getTheFactory().getDAOEducationTeam().readAll();
    }
	
	/**
	 * gets the educationteam with the abbreviation that equals given abbreviation
	 * 
	 * @param abbr
	 * @return EducationTeam
	 */
	public EducationTeam getEducationTeamByAbbreviation(String abbr){
		for(EducationTeam et : getEducationTeams()){
			if(et.getAbbreviation().equals(abbr)){
				return et;
			}
		}
		return null;
	}
	
	/**
	 * returns the education team the teacher is currently in.
	 * 
	 * @param t
	 * @return EducationTeam
	 */
	public EducationTeam getOldEducationTeam(Teacher t){
		try {
			return t.getEducationTeam();
		} catch(Exception e) {
			return null;
		}
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
    	return DAOFactory.getTheFactory().getDAOEducationTeam().read(Id);
    	
    }
    

    public static EducationTeamService getInstance() {
        if (instance == null) {
            instance = new EducationTeamService();
        }
        return instance;
    }

}
