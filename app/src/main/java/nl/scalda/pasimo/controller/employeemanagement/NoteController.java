package nl.scalda.pasimo.controller.employeemanagement;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class NoteController extends ActionSupport {
	HttpServletRequest request;

	public String noteAdd() {

		Teacher teachertest = new Teacher("GG");
		
		
		String title = request.getParameter("inputTitle");
		String message = request.getParameter("inputMessage");

		Note notetest = new Note(title, message, teachertest);

		System.out.println(notetest.getMessage());
		return SUCCESS;

	}

	public String noteDelete() {

		return SUCCESS;
	}

	public String noteEdit() {

		return SUCCESS;
	}
}
