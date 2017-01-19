package nl.scalda.pasimo.model;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.DAOFactory;

public class EducationTeam implements Comparable<EducationTeam> {
	
	private String name;
	private TreeSet<Teacher> teachers = new TreeSet<>();
	
	public EducationTeam(){}
	
	public EducationTeam(String name){
		this.name = name;
		Cluster.getInstance().addEducationTeamToCollection(this);
	}

	public void addTeacher(Teacher t){
		if (teachers.add(t)) {
			System.out.println("Is teacher null: " + t);
			System.out.println("en this: " + this);
			System.out.println(DAOFactory.getTheFactory());
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

	@Override
	public String toString() {
		return "EducationTeam [teachers=" + teachers + "]";
	}

	@Override
	public int compareTo(EducationTeam o) {
		return name.compareTo(o.getName());
	}

}
