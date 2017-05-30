package nl.scalda.pasimo.datalayer.testdao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCheckIn;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;


public class TestDAOCheckIn implements IDAOCheckIn {

	private static TestDAOCheckIn instance = null;
	private TreeSet<CheckIn> checkIn = new TreeSet<>();
	
	private TestDAOCheckIn() {}

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
				System.out.println("Could not update, ended with Exception: " + ex.getMessage());
			}
		}
	}
	
	public TreeSet<CheckIn> getCheckInsByCardId(String cardID){
		
		TreeSet<CheckIn> filteredCheckInList = new TreeSet<>(Collections.reverseOrder());
		
		for(CheckIn c : checkIn){
			if(c.getCardID().equals(cardID)){
				filteredCheckInList.add(c);
			}			
		}
		return filteredCheckInList;
	}
	
	public void add(CheckIn c){
		checkIn.add(c);
	}

	public void addTestData(){
		if(checkIn.isEmpty()){	
			
		CheckIn c = new CheckIn(0, "211543", 2017, 05, 30, 8, 30, 43);
		CheckIn d = new CheckIn(0, "211543", 2017, 05, 30, 12, 06, 11);
		CheckIn e = new CheckIn(0, "211543", 2017, 05, 30, 12, 35, 43);
		CheckIn f = new CheckIn(0, "211543", 2017, 05, 30, 14, 15, 11);
		
		CheckIn y = new CheckIn(0, "211544", 2017, 05, 30, 8, 29, 43);
		CheckIn u = new CheckIn(0, "211544", 2017, 05, 30, 12, 05, 11);
		CheckIn i = new CheckIn(0, "211544", 2017, 05, 30, 12, 37, 43);
		CheckIn o = new CheckIn(0, "211544", 2017, 05, 30, 14, 13, 11);
		
		checkIn.add(f);
		checkIn.add(e);
		checkIn.add(d);
		checkIn.add(c);
		checkIn.add(y);
		checkIn.add(u);
		checkIn.add(i);
		checkIn.add(o);
		}
	}

	@Override
	public TreeSet<CheckIn> readAll() {
		return checkIn;
	}

	@Override
	public TreeSet<CheckIn> readAllForEducationTeam(EducationTeam t) {
		return null;
	}

	@Override
	public CheckIn readByCardID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public TreeSet<CheckIn> getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(TreeSet<CheckIn> checkIn) {
		this.checkIn = checkIn;
	}

	@Override
	public TreeSet<CheckIn> readAllCheckInsForTodayByPerson(Person p) {
		TreeSet<CheckIn> checkInsToday = new TreeSet<>( Collections.reverseOrder() );
		GregorianCalendar date = new GregorianCalendar();
		for(CheckIn c : checkIn){
			if(p.getCardID().equals(c.getCardID())){
			if(c.getDate().get(GregorianCalendar.DAY_OF_YEAR) + c.getDate().get(GregorianCalendar.YEAR) == (date.get(GregorianCalendar.DAY_OF_YEAR) + date.get(GregorianCalendar.YEAR))){
				checkInsToday.add(c);
			}
		}
		}
		return checkInsToday;
	}
	
}
