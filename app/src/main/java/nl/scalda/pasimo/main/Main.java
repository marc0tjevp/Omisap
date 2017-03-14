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


 Student edgelord = new Student(51125, 69, 666, 1234, "nee", "johan", "archibald klasdf sadfsad fasdfsaaus johan", "goudvis", 1567, 6969, 666, 89, 69 );
//    	try {
//			TestDAOStudent.getInstance().addtodatabase(edgelord);
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
    
    	
    	System.out.println(edgelord.getCoachGroupID());
    	
   edgelord.editCardID(edgelord, 2592);
   System.out.println(edgelord.getCardID());
    }

}
