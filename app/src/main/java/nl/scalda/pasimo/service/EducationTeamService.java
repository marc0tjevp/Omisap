package nl.scalda.pasimo.service;

import java.util.List;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class EducationTeamService {
	
	private static EducationTeamService instance;
	public EducationTeamService(){}
	
	public List<EducationTeam> getEducationTeams(){
		return DAOFactory.getTheFactory().getDAOEducationTeam().readAll();
	}
	
	public static EducationTeamService getInstance() {
		if (instance == null) {
			instance = new EducationTeamService();
		}
		return instance;
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

}
