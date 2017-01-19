package nl.scalda.pasimo.model;

import java.util.TreeSet;

public class Cluster {

	private static Cluster instance = null;
	private TreeSet<EducationTeam> educationTeams = new TreeSet<>();
	
	public Cluster() {}
	
	public void addEducationTeamToCollection(EducationTeam team){
		educationTeams.add(team);
	}
	
	public TreeSet<EducationTeam> getEducationTeams() {
		return educationTeams;
	}

	public void setEducationTeams(TreeSet<EducationTeam> educationTeams) {
		this.educationTeams = educationTeams;
	}

	public static Cluster getInstance() {
		if (instance == null) {
			instance = new Cluster();
		}
		return instance;
	}

}
