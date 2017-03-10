package nl.scalda.pasimo.controller.employeemanagement;


import java.util.ArrayList;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class NoteController extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	TreeSet<Note> noteList = new TreeSet<>();
	public Teacher teacher = new Teacher();
	public Note note = new Note();
	public String noteTitle;
	public String noteMessage;

	public String Execute() throws Exception {

		return SUCCESS;
	}

	public String noteAdd() {

		System.out.println(note.getTitle());
		System.out.println(note.getMessage());

		noteList.add(note);
		
		System.out.println("noteAdd");

		return SUCCESS;

	}

	public String noteCreate() {

		Note note = new Note();
		note.setTitle(noteTitle);
		note.setMessage(noteMessage);
		note.setMadeBy(this.teacher);
		
		
		System.out.println("noteCreate");

		return SUCCESS;
	}

	public String noteDelete() {

		System.out.println("noteDelete");
		
		return SUCCESS;
	}

	public String noteEdit() {

	
		System.out.println("noteEdit");
		
		return SUCCESS;
	}

}
