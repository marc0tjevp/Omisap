package nl.scalda.pasimo.model;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOFactory;

public class EducationTeam implements Comparable<EducationTeam> {
	
	private String abbreviation;
	private String name;
	private TreeSet<Teacher> teachers = new TreeSet<>();
	
	public EducationTeam(){}
	
	public EducationTeam(String abbreviation, String name){
		this.name = name;
		this.abbreviation = abbreviation;
		Cluster.getInstance().addEducationTeamToCollection(this);
	}

	public void addTeacher(Teacher t){
		if (teachers.add(t)) {
			
			
			DAOFactory.setTheFactory(TestDAOFactory.getInstance());
			
			DAOFactory.getTheFactory().getDAOTeacher().create(t, this);
		}
		
	}
	
	public void deleteTeacher(Teacher t){
		if (teachers.remove(t)) {
			DAOFactory.getTheFactory().getDAOTeacher().delete(t, this);
		}		
		
	}
	
	public TreeSet<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(TreeSet<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Override
	public String toString() {
		return "EducationTeam [teachers=" + teachers + "]";
	}

	@Override
	public int compareTo(EducationTeam o) {
		return name.compareTo(o.getName());
	}

}
