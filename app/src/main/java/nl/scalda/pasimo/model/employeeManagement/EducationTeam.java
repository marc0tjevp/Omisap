package nl.scalda.pasimo.model.employeeManagement;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.DAOFactory;

public class EducationTeam {
	
	private TreeSet<Teacher> teachers = new TreeSet<>();
	
	public EducationTeam(){}

	public void addTeacher(Teacher t){
		if (teachers.add(t)) {
			DAOFactory.getTheFactory().getDAOTeacher().add(t, this);
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

	@Override
	public String toString() {
		return "EducationTeam [teachers=" + teachers + "]";
	}

}
