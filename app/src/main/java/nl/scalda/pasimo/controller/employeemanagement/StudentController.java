package nl.scalda.pasimo.controller.employeemanagement;

import nl.scalda.pasimo.main.CSVReader;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class StudentController {
	private Student students = new Student();
	private CSVReader c = new CSVReader();
	
	public String AddStudentWithCSV(){
		try {
			c.readFile("importedFile", "","","");
			return "succes";
		} catch (Exception e) {
			return "error";
		}
	}
}
