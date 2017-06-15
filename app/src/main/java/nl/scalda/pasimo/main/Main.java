package nl.scalda.pasimo.main;


import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;


public class Main {

	public static void main(String args[]) {

		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		
		TreeSet<LessonGroup> lessonGroups = DAOFactory.getTheFactory().getDAOLessonGroup().readAll();
		
		TreeSet<CoachGroup> coachGroups = DAOFactory.getTheFactory().getDAOCoachGroup().readAll();
		
		System.out.println(coachGroups);

		LessonGroup lg = lessonGroups.first();
		
		

//		
//		LessonGroup.first().addStudent(s);
//		System.out.println(LessonGroup);
//		LessonGroup.first().deleteStudent(s);
//		System.out.println(LessonGroup);
//		LessonGroup.first().addStudent(s);
		
	}
}

