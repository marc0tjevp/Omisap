package nl.scalda.pasimo.service;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public class TeacherService {

	private static TeacherService instance;

	private TeacherService() {
	}

//	public TreeSet<CheckIn> readAllCheckedIn(){
//		return DAOFactory.getTheFactory().getDAOCheckIn().readAll();
//	}
	
	public TreeSet<Teacher> readAll(){
		return null;
	}
//	public TreeSet<Teacher> readAll(){
//		return DAOFactory.getTheFactory().getDAOTeacher().readAll();
//	}
	
//	public Teacher getTeacherByEmployeeID(int id) {
//		return DAOFactory.getTheFactory().getDAOTeacher().readByEmployeeNumber(id);
//	}
	public Teacher getTeacherByEmployeeID(int id) {
		return null;
	}
	
	public static TeacherService getInstance() {
		if (instance == null) {
			instance = new TeacherService();
		}
		return instance;
	}

}
