package nl.scalda.pasimo.datalayer.testdao;

import java.util.ArrayList;
import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public class TestDAOCheckIn {

	private static TestDAOCheckIn instance = null;
	private ArrayList<CheckIn> checkIn = new ArrayList<>();
	
	private TestDAOCheckIn() {}
	
	public ArrayList<CheckIn> readAll() {
		return checkIn;
	}

	public ArrayList<CheckIn> readAllForEducationTeam(EducationTeam t) {
		return null;
	}

	public static TestDAOCheckIn getInstance() {
		if (instance == null) {
			instance = new TestDAOCheckIn();
		}
		return instance;
	}
	
	public void update(CheckIn c) {
		for (c ci : checkIn)
			try {
				if (c.getCardID() == ci.getCardID())
				{
					ci = c;
				}
			}
	}

}
