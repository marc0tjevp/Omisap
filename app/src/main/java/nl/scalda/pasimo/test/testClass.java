package nl.scalda.pasimo.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOTeacher;
import nl.scalda.pasimo.model.*;
import nl.scalda.pasimo.service.Service;
import nl.scalda.pasimo.service.TeacherService;

public class testClass {

	public static void main(String[] args) throws ParseException{
		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		
		Teacher t = new Teacher(123456, "ikke@email.com", 654321789, "kaas","","souffle", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1996"));
		Teacher t2 = new Teacher(586254, "kkloet@mail.ch", 589645872, "Kevin","","Kloet", new SimpleDateFormat("dd/MM/yyyy").parse("31/08/1999"));
		
		EducationTeam et = new EducationTeam("henk");
		et.addTeacher(t);
		et.addTeacher(t2);
		
		et.deleteTeacher(t);
		TestDAOTeacher.getInstance().delete(t, et);
		
		System.out.println("Dit zit er in het team: " + et.getTeachers());	
		System.out.println("Dit zit er in de teacher collectie: " + TestDAOTeacher.getInstance().readAll());		
		
	}

}
