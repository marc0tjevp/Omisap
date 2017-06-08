package nl.scalda.pasimo.service;

import java.util.GregorianCalendar;
import java.util.TreeMap;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.testdao.TestDAOCheckIn;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public class CheckInService {
	
	private static CheckInService instance = null;
	
	public void addCheckInTestData(){
		TestDAOCheckIn.getInstance().addTestData();
	}

	public TreeMap<GregorianCalendar, TreeSet<CheckIn>> getCheckInsByDateForCardId(GregorianCalendar searchDate, String cardId){ 
		return TestDAOCheckIn.getInstance().getCheckInsByDateForCardId(searchDate, cardId);
	}
	
	public static CheckInService getInstance() {
		if (instance == null) {
			instance = new CheckInService();
		}
		return instance;
	}

	public static void setInstance(CheckInService instance) {
		CheckInService.instance = instance;
	}

}
