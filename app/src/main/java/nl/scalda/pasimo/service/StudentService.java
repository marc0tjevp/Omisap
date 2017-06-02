package nl.scalda.pasimo.service;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class StudentService {

	private static StudentService instance;

	private StudentService() {
	}

	public TreeSet<Student> readAllStudents(){
		return DAOFactory.getTheFactory().getDAOStudent().readAll();
	}
	
	public Student getStudentByStudentOV(int studentOV) {
		return DAOFactory.getTheFactory().getDAOStudent().readByStudentOV(studentOV);
	}
	
	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

}
