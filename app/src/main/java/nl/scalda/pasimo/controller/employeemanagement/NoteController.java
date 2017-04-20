package nl.scalda.pasimo.controller.employeemanagement;

import java.util.Date;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class NoteController extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String madeBy;
	private int id;
	private Teacher teacher = new Teacher("test", 1);
	private Student student;
	private String title;
	private String message;

	private TreeSet<Note> noteList = new TreeSet<>();

	public String Execute() throws Exception {

		return SUCCESS;
	}
	/*
	 * Overview of all notes Struts
	 */

	public String noteOverview() {
	
		for(Note n : teacher.readAllNotes()){
			noteList.add(n);
		}
		return SUCCESS;
	}

	public String readNote() {


		return SUCCESS;
	}

	/*
	 * Add a note Struts
	 */
	public String noteAdd() {
		Student s = new Student();
		teacher.createNote(title, message, s);
		// Teacher teacher = TestDAOTeacher.getInstance().readByAbbr(madeBy);

		return SUCCESS;
	}

	/*
	 * Deletes a note Struts
	 */
	public String noteDelete() {

		return SUCCESS;

	}

	/*
	 * Edit a note Struts
	 */
	public String noteEdit() {
		for (Note n : getNoteList()) {
				n.setTitle(title);
				n.setMessage(message);
				n.setLastEdit(new Date());
				teacher.editNote(n);
			}
		return SUCCESS;
		}
	
	

	/*
	 * Deletes all notes in the note overview Struts
	 */
	public String noteDeleteAll() {
		teacher.deleteAllNotes();

		return SUCCESS;
	}

	public TreeSet<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(TreeSet<Note> noteList) {
		this.noteList = noteList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
