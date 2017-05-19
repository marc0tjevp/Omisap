package nl.scalda.pasimo.controller.employeemanagement;

import java.util.GregorianCalendar;
import java.util.TreeMap;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.service.StudentService;

public class StudentController extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TreeMap<String, GregorianCalendar>studentCheckinz;
	TreeSet<Note>note = new TreeSet<>();
	
	public String execute() {
		Student z = new Student(12, 23, "student@scalda", "voornaam", "", "achternaam", 211543, 1997, note, 05, 21);
		StudentService.getInstance().checkInData(z);
		studentCheckinz = z.studentCheckIns;
		
		return SUCCESS;
	}
}
