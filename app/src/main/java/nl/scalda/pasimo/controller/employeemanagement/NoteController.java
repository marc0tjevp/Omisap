package nl.scalda.pasimo.controller.employeemanagement;

import java.util.ArrayList;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class NoteController extends ActionSupport {
	private static final long serialVersionUID = 1L;

	ArrayList<Note> noteList = new ArrayList<>();
	ArrayList<Teacher> teachers = new ArrayList<>();
	TreeSet<Note> notes = new TreeSet<>();
	public Teacher teacher = new Teacher("gg");
	public Note note = new Note();
	public Note note1 = new Note();
	public Note note2 = new Note();
	public Note note3 = new Note();
	public String title;
	public String message;

	public String Execute() throws Exception {

		return SUCCESS;
	}

	public String noteAdd() {
		
		teacher.setFirstName("Maxim");
		teacher.setLastName("Schoonen");
		teacher.setEmployeeNumber(001);
		teacher.setCardID(553510394);
		teachers.add(teacher);
		
		note.setTitle("Peter te laat door bus");
		note.setMessage("Bus was overvol en Peter mocht niet meer mee");
		
		note1.setTitle("Sjonnie was te laat door trein");
		note1.setMessage("Trein had 25 minuten vertraging door storing");
		
		note2.setTitle("Dovidas was te laat door bus");
		note2.setMessage("Bus reed niet door te veel sneeuw");
		
		note3.setTitle("Kevin was te laat door bus");
		note3.setMessage("Bus was overvol en Kevin mocht niet mee");
	
		noteList.add(note);
		noteList.add(note1);
		noteList.add(note2);
		noteList.add(note3);
		
		

		System.out.println("noteAdd");

		return SUCCESS;

	}

	public String noteCreate() {

		Note note = new Note();
		note.setTitle(title);
		note.setMessage(message);
		note.setMadeBy(this.teacher);

		System.out.println("noteCreate");

		return SUCCESS;
	}
	
	public String noteDelete(){
		
		System.out.println("noteDelete");
		
		return SUCCESS;
	}
	
	public String noteEdit(){
		
		System.out.println("noteEdit");
		
		return SUCCESS;
	}

	public ArrayList<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(ArrayList<Note> noteList) {
		this.noteList = noteList;
	}

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers = teachers;
	}

	public TreeSet<Note> getNotes() {
		return notes;
	}

	public void setNotes(TreeSet<Note> notes) {
		this.notes = notes;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Note getNote1() {
		return note1;
	}

	public void setNote1(Note note1) {
		this.note1 = note1;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
