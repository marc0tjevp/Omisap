package nl.scalda.pasimo.datalayer.testdao;

import java.util.ArrayList;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
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
		for (CheckIn ci : checkIn) {
			try {
				if (c.getCardID() == ci.getCardID())
				{
					ci = c;
				}
			} catch (Exception ex) {
				System.err.println("Could not update, ended with Exception: " + ex.getMessage());
			}
		}
	}

}
