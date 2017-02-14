package nl.scalda.pasimo.test;
import java.text.ParseException;
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

/**
 * TOD: Remove t
 * @deprecated
 */
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
        CoachGroup c1 = new CoachGroup(1, "A1");
        CoachGroup c2 = new CoachGroup(2, "A2");

        LessonGroup l1 = new LessonGroup(1, "ICO41A");
        LessonGroup l2 = new LessonGroup(2, "ICO42A");
        LessonGroup l3 = new LessonGroup(3, "ICO43A");

        c1.addLessonGroup(l1);
        c1.addLessonGroup(l2);
        c1.addLessonGroup(l3);

        c2.addLessonGroup(l1);
        c2.addLessonGroup(l2);
        c2.addLessonGroup(l3);

//        c1.deleteLessonGroup(l2);

        l2.setName("Mijn mama");
        c1.updateLessonGroup(l2);

     }

		// print out a bunch of interesting things
		System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		System.out.println("DATE: " + calendar.get(Calendar.DATE));
		System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		*/
	}
}