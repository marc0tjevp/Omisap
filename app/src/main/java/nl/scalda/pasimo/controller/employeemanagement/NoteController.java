package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAONote;
import nl.scalda.pasimo.datalayer.testdao.TestDAONote;
import nl.scalda.pasimo.datalayer.testdao.TestDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.NoteService;

public class NoteController extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String madeBy;
	private int id;
	private Note note = new Note();
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

		teacher.readNoteById(note.getId());
		return SUCCESS;
	}

	/*
	 * Add a note Struts
	 */
	public String noteAdd() {
		Student s = new Student();
		teacher.createNote("test", "test", s);
		// Teacher teacher = TestDAOTeacher.getInstance().readByAbbr(madeBy);

		return SUCCESS;
	}

	/*
	 * Deletes a note Struts
	 */
	public String noteDelete() {
		teacher.deleteNoteByID(this.getId());
		return SUCCESS;

	}

	/*
	 * Edit a note Struts
	 */
	public String noteEdit() {
		for (Note n : getNoteList()) {
			if (n.getId() == note.getId()) {
				n.setOvNumber(note.getOvNumber());
				n.setTitle(note.getTitle());
				n.setMessage(note.getMessage());
				n.setEmployeeNumber(note.getEmployeeNumber());
				n.setCreationDate(note.getCreationDate());
				n.setLastEdit(note.getCreationDate());
				teacher.editNote(n);
			}
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
