package nl.scalda.pasimo.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import nl.scalda.pasimo.datalayer.TestDAOTeacher;
import nl.scalda.pasimo.model.*;

public class testClass {

	public static void main(String[] args) throws ParseException{
		Teacher t = new Teacher("lelele", 123456, "ikke@email.com", 654321789, "kaas","","souffle", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1996"));
		Teacher t2 = new Teacher("KLOEKE", 586254, "kkloet@mail.ch", 589645872, "Kevin","","Kloet", new SimpleDateFormat("dd/MM/yyyy").parse("31/08/1999"));
		
		EducationTeam et = new EducationTeam();
		et.addTeacher(t);
		et.addTeacher(t2);
		
		/*add teacher*/
		TestDAOTeacher.getInstance().add(t, et);
		System.out.println(TestDAOTeacher.getInstance().readAll());
		
		/*edit teacher*/
		t.setFirstName("Jos");
		TestDAOTeacher.getInstance().edit(t, et, t.getAbbreviation());
		System.out.println(TestDAOTeacher.getInstance().readAll().toString());
		
		/*delete teacher*/
		et.deleteTeacher(t);
		TestDAOTeacher.getInstance().delete(t, et);
		
		System.out.println(TestDAOTeacher.getInstance().readAll().toString());
		System.out.println(et.getTeachers());
		
		
	}

}
