package nl.scalda.pasimo.main;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

/**
 *
 * @author jeroe
 */
public class Main {
	public static void main(String args[]) {

		TreeSet<Student> students = new TreeSet<>();
		CoachGroup c1 = new CoachGroup(2, "ICOTEST", students );
		
		Student edgelord = new Student(1, 2, 3, 4, "nee", "koi",
				"", "karper", 5, 6, 7, 8, 9);
	
		
		System.out.println(c1.getStudents());
		
		 
		 }


	}


