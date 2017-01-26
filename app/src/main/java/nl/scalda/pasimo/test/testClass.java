package nl.scalda.pasimo.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOTeacher;
import nl.scalda.pasimo.model.*;
import nl.scalda.pasimo.service.Service;
import nl.scalda.pasimo.service.TeacherService;

public class testClass {

	public static void main(String[] args) throws ParseException{
		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		
		Teacher t = new Teacher(123456, "ikke@email.com", 654321789, "kaas","","souffle",2017,8,30);
		Teacher t2 = new Teacher(586254, "kkloet@mail.ch", 589645872, "Kevin","","Kloet",1392,11,9);
		
		System.out.println(t);
		
		EducationTeam et = new EducationTeam("","henk");
		et.addTeacher(t);
		et.addTeacher(t2);
		
		et.deleteTeacher(t);
		
		//System.out.println("Dit zit er in het team: " + et.getTeachers());	
		//System.out.println("Dit zit er in de teacher collectie: " + TestDAOTeacher.getInstance().readAll());		
		
	}

}

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
