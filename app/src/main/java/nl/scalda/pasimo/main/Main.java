package nl.scalda.pasimo.main;

import java.sql.SQLException;

import nl.scalda.pasimo.datalayer.testdao.TestDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.Student;

/**
 *
 * @author jeroe
 */
public class Main {
	public static void main(String args[]) {

		Student edgelord = new Student(1, 2, 3, 4, "nee", "koi",
				"", "karper", 5, 6, 7, 8, 9);
	
		
			try {
				TestDAOStudent.getInstance().addtodatabase(edgelord);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		 
		 }


	}


