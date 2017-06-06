package nl.scalda.pasimo.service;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class StudentService {

	private static StudentService instance;

	private StudentService() {
	}

	public TreeSet<Student> readAll(){
		return DAOFactory.getTheFactory().getDAOStudent().readAll();
	}
	
	public Student getStudentByStudentOV(int id) {
		return DAOFactory.getTheFactory().getDAOStudent().readByStudentOV(id);
	}
	
	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

}