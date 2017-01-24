package nl.scalda.pasimo.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOFactory;
import nl.scalda.pasimo.employeemanagement.datalayer.test.TestDAOTeacher;
import nl.scalda.pasimo.employeemanagement.model.EducationTeam;
import nl.scalda.pasimo.employeemanagement.model.Note;
import nl.scalda.pasimo.employeemanagement.model.Teacher;

public class testClass {

	public static void main(String[] args) throws ParseException{
		
		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		
		
		
		
		Teacher t = new Teacher("lelele", 123456, "ikke@email.com", 654321789, "kaas","","souffle", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/1996"));
		Teacher t2 = new Teacher("KLOEKE", 586254, "kkloet@mail.ch", 589645872, "Kevin","","Kloet", new SimpleDateFormat("dd/MM/yyyy").parse("31/08/1999"));
		
		Note n1 = new Note("lel", "slfkjs", t);
		t2.addNote(n1);
		
		EducationTeam et = new EducationTeam();
		et.addTeacher(t);
		et.addTeacher(t2);
		
		/*edit teacher*/
//		t.setFirstName("Jos");
//		TestDAOTeacher.getInstance().edit(t, et, t.getAbbreviation());
		
		
		/*delete teacher*/
		et.deleteTeacher(t); 
		
		System.out.println("TestDAO: " + TestDAOTeacher.getInstance().readAll().toString());
		System.out.println("EducationTeam: " + et.getTeachers());
		
		
	}

}
