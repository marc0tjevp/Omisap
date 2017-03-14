package nl.scalda.pasimo.main;

import java.sql.SQLException;

import nl.scalda.pasimo.datalayer.testdao.TestDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.test.EducationTeamList;

/**
 *
 * @author jeroe
 */
public class Main {
    public static void main(String args[]) {


   Student edgelord = new Student(420, 420, 420, 420, "ditiseenemail", "edgelord2", "edgelord3", "edgelord4", 420, 420, 420, 420, 420);
	System.out.println(edgelord);
	
    	try {
			TestDAOStudent.getInstance().addtodatabase(edgelord);
			System.out.println(edgelord);
		} catch (SQLException e) {

			e.printStackTrace();
		}
    
    }

}
