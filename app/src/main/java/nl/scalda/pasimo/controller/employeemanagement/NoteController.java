package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class NoteController extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	TreeSet<Note> notelist = new TreeSet<>();
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

		notelist.add(note);

		return SUCCESS;

	}

	public String noteCreate() {

		Note note = new Note();
		note.setTitle(noteTitle);
		note.setMessage(noteMessage);
		note.setMadeBy(this.teacher);

		return SUCCESS;
	}

	public String noteDelete() {

		return SUCCESS;
	}

	public String noteEdit() {

		return SUCCESS;
	}

}
