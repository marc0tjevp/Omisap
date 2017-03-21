package nl.scalda.pasimo.main;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.testdao.TestDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;

/**
 *
 * @author jeroe
 */
public class Main {
	public static void main(String args[]) {
	//The database needs a password to work, so if you run it without a password you WILL get a java.sql.SQLException access denied. 
	//The methods which use a database password are in TestDAOStudent
		
	TreeSet<Student> students = new TreeSet<>();
	TreeSet<Note> notelist = new TreeSet<>();
	CoachGroup c1 = new CoachGroup(69, "it's dat boi", students);
	LessonGroup l1 = new LessonGroup("it's dat lessongroup", students);
	
	Student EdgeLord = new Student(696969, c1, l1, 420, "you can't stop me",  "klaus", "de", "man", 666, 666999420, notelist, 42069, 66669);
	
	
	//Adds a student to the database
	TestDAOStudent.getInstance().create(EdgeLord);
	
	
	//Updates the info you made to the database
	TestDAOStudent.getInstance().update(EdgeLord);
	
	
	//Deletes the object from the database (not the actual object!)
	TestDAOStudent.getInstance().delete(EdgeLord);
	}

}
