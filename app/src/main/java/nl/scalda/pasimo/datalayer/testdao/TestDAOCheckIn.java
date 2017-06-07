package nl.scalda.pasimo.datalayer.testdao;


import java.util.Date;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCheckIn;

import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;


public class TestDAOCheckIn implements IDAOCheckIn {

	private static TestDAOCheckIn instance = null;
	TreeSet<CheckIn> cardLogs = new TreeSet<>();
	
	private TestDAOCheckIn(){
		

		//CheckIn(logID, hourOfCheckIn, minuteOfCheckIn, secondOfCheckIn, isCheckIn)
		CheckIn a = new CheckIn(10, 5, 55, 55, true);
		cardLogs.add(a);


	}
	
	public CheckIn read(int id){
		for(CheckIn checkIn : cardLogs){
			if(checkIn.getLogID() == id){
				return checkIn;
			}
		}
		return null;
	}
	
	public static TestDAOCheckIn getInstance() {
		if (instance == null) {
			instance = new TestDAOCheckIn();
		}
		return instance;
	}



	@Override
	public TreeSet<CheckIn> readAll() {
		// TODO Auto-generated method stub
		return cardLogs;
	}

}
