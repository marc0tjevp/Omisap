package nl.scalda.pasimo.service;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class StudentService {

	private static StudentService instance;

	private StudentService() {
	}

	public TreeSet<Student> readAll(){
		return DAOFactory.getTheFactory().getDAOStudent().readAll();
	}
	
	public Student getStudentByEmployeeID(int id) {
		return DAOFactory.getTheFactory().getDAOStudent().readByCardID(id);
	}
	
	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}
    public Set<LessonGroup> getLessonGroup() {
        return getLessonGroup();
    }

}
