package nl.scalda.pasimo.service;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;

public class EducationTeamService {
	
	private static EducationTeamService instance;
	
	public EducationTeamService(){}
	
	public Set<EducationTeam> getEducationTeams(){
		return DAOFactory.getTheFactory().getDAOEducationTeam().readAll();
	}
	
	public static EducationTeamService getInstance() {
		if (instance == null) {
			instance = new EducationTeamService();
		}
		return instance;
	}

}
