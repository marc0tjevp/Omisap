package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public class TestDAOCheckIn {

	private static TestDAOCheckIn instance = null;
	private TreeSet<CheckIn> checkIn = new TreeSet<>();
	
	private TestDAOCheckIn() {}
	
	public TreeSet<CheckIn> readAll() {
		return checkIn;
	}

	public TreeSet<CheckIn> readAllForEducationTeam(EducationTeam t) {
		return null;
	}

	public static TestDAOCheckIn getInstance() {
		if (instance == null) {
			instance = new TestDAOCheckIn();
		}
		return instance;
	}
	
	public void update(CheckIn c, EducationTeam team) {
		
	}

}
