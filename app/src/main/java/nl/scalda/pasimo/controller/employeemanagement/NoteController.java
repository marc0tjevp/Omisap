package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAONote;
import nl.scalda.pasimo.datalayer.testdao.TestDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class NoteController extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String madeBy;
	private int id;


	private String title;
	private String message;

	private TreeSet<Note> noteList = new TreeSet<>();

	public String Execute() throws Exception {

		return SUCCESS;
	}
	/*
	 * Overview of all notes
	 * Struts
	 */

	public String noteOverview() {
		noteList = TestDAONote.getInstance().getNoteList();

		return SUCCESS;
	}

	/*
	 * Add a note
	 * Struts
	 */
	public String noteAdd() {

		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		TestDAONote dao = TestDAONote.getInstance();
		
		Teacher teacher = TestDAOTeacher.getInstance().readByAbbr(madeBy);
		Note note = new Note(message, title, teacher);
		dao.create(note);

		return SUCCESS;
	}

	/*
	 *  Deletes a note
	 *  Struts
	 */
	public String noteDelete(){
		
		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		TestDAONote dao = TestDAONote.getInstance();
		
		dao.delete(dao.read(id));
		
		return SUCCESS;
		
	}
	/*
	 * Edit a note
	 * Struts
	 */
	public String noteEdit(){
		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		TestDAONote dao = TestDAONote.getInstance();
		Note note = dao.read(id);
		
		for(Note a : getNoteList()){
			if (a.getId() == note.getId()){
				a.setTitle(note.getTitle());
				a.setMessage(note.getMessage());
				
			}
		}

		return SUCCESS;
	}
	/*
	 * Deletes all notes in the note overview
	 * Struts
	 */
	public String noteDeleteAll(){
		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		TestDAONote dao = TestDAONote.getInstance();
		
		dao.deleteAll();
		
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
