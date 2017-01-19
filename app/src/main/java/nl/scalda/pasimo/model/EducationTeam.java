package nl.scalda.pasimo.model;

import java.util.TreeSet;

public class EducationTeam {
	
	private TreeSet<Teacher> teachers = new TreeSet<>();
	
	public EducationTeam(){}

	public void addTeacher(Teacher t){
		teachers.add(t);
	}
	
	public void deleteTeacher(Teacher t){
		teachers.remove(t);
	}
	
	public TreeSet<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(TreeSet<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "EducationTeam [teachers=" + teachers + "]";
	}

}
