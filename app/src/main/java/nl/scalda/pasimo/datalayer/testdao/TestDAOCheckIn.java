package nl.scalda.pasimo.datalayer.testdao;

import java.util.ArrayList;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCheckIn;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;


public class TestDAOCheckIn implements IDAOCheckIn {

	private static TestDAOCheckIn instance = null;
	TreeSet<Person> cardLogs = new TreeSet<>();
	
	private TestDAOCheckIn(){
		
	    Person a = new Person(100, "Bram@scalda.nl", "Bram");
	    Person b = new Person(101, "Rens@scalda.nl", "Rens");
	    Person c = new Person(102, "Max@scalda.nl", "Max");
	    Person d = new Person(103, "Gino@scalda.nl", "Gino");
	    Person e = new Person(104, "Dragan@scalda.nl", "Dragan");
	    Person f = new Person(105, "Jordy@scalda.nl", "Jordy");

	    cardLogs.add(a);
	    cardLogs.add(b);
	    cardLogs.add(c);
	    cardLogs.add(d);
	    cardLogs.add(e);
	    cardLogs.add(f);

	}
	
	public static TestDAOCheckIn getInstance() {
		if (instance == null) {
			instance = new TestDAOCheckIn();
		}
		return instance;
	}



	@Override
	public TreeSet<Person> readAll() {
		// TODO Auto-generated method stub
		return cardLogs;
	}

}
