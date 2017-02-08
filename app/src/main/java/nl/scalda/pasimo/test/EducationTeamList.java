package nl.scalda.pasimo.test;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeeManagement.EducationTeam;

public class EducationTeamList extends TreeSet<EducationTeam>{
	
	private static EducationTeamList instance;
	TreeSet<EducationTeam> teams = new TreeSet<>();
	
	private EducationTeamList(){}
	
	public void addTeam(EducationTeam t){
		teams.add(t);
	}
	
	public void removeTeam(EducationTeam t) {
		teams.remove(t);
	}
	public TreeSet<EducationTeam> getTeams() {
		return teams;
	}

	public void setTeams(TreeSet<EducationTeam> teams) {
		this.teams = teams;
	}

	public static EducationTeamList getInstance() {
        if (instance == null) {
            instance = new EducationTeamList();
        }
        return instance;
    }

}
