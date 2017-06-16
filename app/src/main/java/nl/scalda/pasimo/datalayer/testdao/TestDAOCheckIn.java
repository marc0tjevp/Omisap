package nl.scalda.pasimo.datalayer.testdao;

import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCheckIn;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public class TestDAOCheckIn implements IDAOCheckIn{

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
	
	public TreeMap<GregorianCalendar, TreeSet<CheckIn>> getCheckInsByDateForCardId(GregorianCalendar searchDate, String cardId){
		
		TreeMap<GregorianCalendar, TreeSet<CheckIn>> dateCheckins = new TreeMap<>();
		TreeSet<CheckIn>allCheckIns = getCheckInsByCardId(cardId);
		TreeSet<CheckIn> selectedCheckIns  = new TreeSet<>();
		// loop door alle checkins
		for(CheckIn c : allCheckIns)
		{
			//kijk of datum van de checkin gelijk is aan de searchdate
			if(c.getFormattedDate().contentEquals(formatSearchDate(searchDate)))
			{
				//zo ja voeg de checkin toe aan de Treeset<CheckIn>

				selectedCheckIns.add(c);
			}
			dateCheckins.put(searchDate, selectedCheckIns);
		}
		return dateCheckins;	
	}
	
	public String formatSearchDate(GregorianCalendar date) {
		
		return String.valueOf(date.get(GregorianCalendar.DAY_OF_MONTH)) + "-"
				+ String.valueOf(date.get(GregorianCalendar.MONTH) +1) + "-"
				+ String.valueOf(date.get(GregorianCalendar.YEAR));
	}

	
	public void add(CheckIn c){
		checkIn.add(c);
	}

	public void addTestData(){
		if(checkIn.isEmpty()){	
			
		Teacher yo = new Teacher(213456, 213456, "fhjrgjrew", "123456", "kek", "", "qwre", 2017, 11, 23);	
		CoachGroup co = new CoachGroup("kappa", yo);
		LessonGroup xo = new LessonGroup(213, "kappa123");	
		co.addLessonGroup(xo, false);
		EducationTeam ed = new EducationTeam("kek", "Praise kek", 69);
		ed.addCoachGroup(co);
			
		CheckIn c = new CheckIn(0, "211543", 2017, 06, 16, 8,  30, 43);
		CheckIn d = new CheckIn(0, "211543", 2017, 06, 16, 12, 06, 11);
		CheckIn e = new CheckIn(0, "211543", 2017, 06, 16, 12, 35, 43);
		CheckIn f = new CheckIn(0, "211543", 2017, 06, 16, 14, 15, 11);
		
		CheckIn y = new CheckIn(0, "211544", 2017, 06, 16, 8,  29, 43);
		CheckIn u = new CheckIn(0, "211544", 2017, 06, 16, 12, 05, 11);
		CheckIn i = new CheckIn(0, "211544", 2017, 06, 16, 12, 37, 43);
		CheckIn o = new CheckIn(0, "211544", 2017, 06, 16, 14, 13, 11);
		
		CheckIn yi = new CheckIn(0, "211544", 2017, 07, 30, 8,  28, 43);
		CheckIn ui = new CheckIn(0, "211544", 2017, 07, 30, 12, 00, 11);
		CheckIn ii = new CheckIn(0, "211544", 2017, 07, 30, 12, 40, 43);
		CheckIn oi = new CheckIn(0, "211544", 2017, 07, 30, 14, 13, 11);
		
//		CheckIn yii = new CheckIn(0, "211544", 2017, 07, 30, 8,  18, 43);
//		CheckIn uii = new CheckIn(0, "211544", 2017, 07, 30, 12, 52, 11);
//		CheckIn iii = new CheckIn(0, "211544", 2017, 07, 30, 12, 02, 43);
//		CheckIn oii = new CheckIn(0, "211544", 2017, 07, 30, 14, 30, 11);
//		
//		checkIn.add(yii);
//		checkIn.add(uii);
//		checkIn.add(iii);
//		checkIn.add(oii);
		TestDAOTeacher.getInstance().create(yo);
		TestDAOCoachGroup.getInstance().create(co, new EducationTeam());
		TestDAOLessonGroup.getInstance().create(xo, co);
		TestDAOEducationTeam.getInstance().create(ed);
		
		checkIn.add(yi);
		checkIn.add(ui);
		checkIn.add(ii);
		checkIn.add(oi);
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
	public Set<CheckIn> readAllCheckInsForTodayByPerson(Person p) {
		Set<CheckIn> checkInsToday = new TreeSet<>( Collections.reverseOrder() );
		GregorianCalendar date = new GregorianCalendar();
		for(CheckIn c : checkIn){
			if(p.getCardID().equals(c.getCardID())){
				//check if checkIn date == today
				if(c.getDate().get(GregorianCalendar.DAY_OF_YEAR) + c.getDate().get(GregorianCalendar.YEAR) == (date.get(GregorianCalendar.DAY_OF_YEAR) + date.get(GregorianCalendar.YEAR))){
					checkInsToday.add(c);
				}
			}
		}
		return checkInsToday;
	}

}
