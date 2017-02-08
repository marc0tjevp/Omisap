package nl.scalda.pasimo.test;
import java.text.ParseException;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;


public class testClass {

	public static void main(String[] args) throws ParseException{
		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
//		
//		Teacher t = new Teacher("lelele", 123456, "ikke@email.com", 654321789, "kaas","","souffle", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1996"));
//		Teacher t2 = new Teacher("KLOEKE", 586254, "kkloet@mail.ch", 589645872, "Kevin","","Kloet", new SimpleDateFormat("dd/MM/yyyy").parse("31/08/1999"));
//		
//		Note n1 = new Note("lel", "slfkjs", t);
//		t2.addNote(n1);
//		
//		EducationTeam et = new EducationTeam();
//		et.addTeacher(t);
//		et.addTeacher(t2);
//		
//		/*edit teacher*/
//		t.setFirstName("Jos");
//		TestDAOTeacher.getInstance().edit(t, et, t.getAbbreviation());
//		
//		
//		/*delete teacher*/
//		et.deleteTeacher(t); 
//		
//		System.out.println("TestDAO: " + TestDAOTeacher.getInstance().readAll().toString());
//		System.out.println("EducationTeam: " + et.getTeachers());
		
		/*
		// create a GregorianCalendar with the Pacific Daylight time zone
		// and the current date and time
		Calendar calendar = new GregorianCalendar(pdt);
		Date trialTime = new Date();
		calendar.setTime(trialTime);

		// print out a bunch of interesting things
		System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		System.out.println("DATE: " + calendar.get(Calendar.DATE));
		System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		*/
	}
}