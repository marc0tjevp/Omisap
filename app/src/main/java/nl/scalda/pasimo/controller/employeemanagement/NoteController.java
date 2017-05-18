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

	private String employeeFirstName;
	private String madeBy;
	private int id;
	private Teacher teacher = new Teacher("test", 1);
	private Student student;
	private String title;
	private String message;
	private Note note;

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
		Student s = new Student("push it to the limit");
		Teacher teacher = TestDAOTeacher.getInstance().readByAbbr(madeBy);
		teacher.createNote(title, message, s, teacher);

		 

		return SUCCESS;
	}

	public String noteDelete() {
		teacher.deleteNoteByID(id);
		return SUCCESS;
	}


	public String noteEditView() {
		note = teacher.readNoteById(id);
		return SUCCESS;
	}
	
	public String noteEdit(){
		note = teacher.readNoteById(id);
		teacher.editNote(note);
		return SUCCESS;
	}

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

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	
}
