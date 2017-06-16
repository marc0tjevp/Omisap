package nl.scalda.pasimo.service;

import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOCheckIn;
import nl.scalda.pasimo.datalayer.testdao.TestDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public class StudentService {
	private static StudentService instance = null;

	public TreeSet<CheckIn> getCheckInByStudent(Student z) {
	 z.getStudentCheckIns().addAll(TestDAOCheckIn.getInstance().getCheckInsByCardId(z.getCardID()));
	 return z.studentCheckIns;
	}
	
	public TreeSet<CheckIn> getCheckInsByCardID(String cardId){
		return TestDAOCheckIn.getInstance().getCheckInsByCardId(cardId);
	}
	
	public Set<CheckIn> getCheckInsOfToday(Person p){
		//TODO verander TestDAOFactory terug naar "DAOFactory"
		return TestDAOCheckIn.getInstance().readAllCheckInsForTodayByPerson(p);
		
	}
	
	public void addStudentTestData(){
	TestDAOStudent.getInstance().addStudentTestData();
	}
	
	public Set<Student> getAllStudents(){
		return TestDAOStudent.getInstance().readAll();
	}

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

	public static void setInstance(StudentService instance) {
		StudentService.instance = instance;
	}

}
