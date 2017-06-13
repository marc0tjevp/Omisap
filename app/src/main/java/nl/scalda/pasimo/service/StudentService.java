package nl.scalda.pasimo.service;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class StudentService {
	private static StudentService instance;

	public StudentService(){
		
	}
	public void createAll(Set<Student> student){
//		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		DAOFactory.getTheFactory().getDAOStudent().createAll(student);
//		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
	}
	public static StudentService getInstance() {
		if (instance==null){
			instance = new StudentService();
		}
		return instance;
	}
	
}
