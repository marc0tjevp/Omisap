package nl.scalda.pasimo.service;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class TeacherService {

	private static TeacherService instance;

	private TeacherService() {
	}

	public TreeSet<Teacher> readAll(){
		return DAOFactory.getTheFactory().getDAOTeacher().readAll();
	}
	
	public Teacher getTeacherByEmployeeID(int id) {
		return DAOFactory.getTheFactory().getDAOTeacher().readByEmployeeNumber(id);
	}
	
	public static TeacherService getInstance() {
		if (instance == null) {
			instance = new TeacherService();
		}
		return instance;
	}

}
