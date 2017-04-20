package nl.scalda.pasimo.controller.employeemanagement;

import java.util.Date;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.testdao.TestDAOTeacher;
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

	public String noteOverview() {
	
		for(Note n : teacher.readAllNotes()){
			noteList.add(n);
			System.out.println("ID: " + n.getId());
			System.out.println("Notelist size: " + noteList.size());
			System.out.println(n.getCreationDate());
		}
		return SUCCESS;
	}

	public String readNote(Note note) {


		return SUCCESS;
	}


	public String noteAdd() {
		Student s = new Student();
		Teacher teacher = TestDAOTeacher.getInstance().readByAbbr(madeBy);
		teacher.createNote(title, message, s, madeBy);
		// Teacher teacher = TestDAOTeacher.getInstance().readByAbbr(madeBy);

		return SUCCESS;
	}

	public String noteDelete() {

		return SUCCESS;

	}


	public String noteEdit(Note note) {
		for (Note n : getNoteList()) {
				n.setTitle(title);
				n.setMessage(message);
				n.setLastEdit(new Date());
				teacher.editNote(n);
			}
		return SUCCESS;
		}
	
	

	public String noteDeleteAll() {
		System.out.println("Deleteall");
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
