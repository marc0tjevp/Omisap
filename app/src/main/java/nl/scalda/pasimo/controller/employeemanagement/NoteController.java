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


	private String title;
	private String message;

	private TreeSet<Note> noteList = new TreeSet<>();

	public String Execute() throws Exception {

		return SUCCESS;
	}

	public String noteOverview() {
		noteList = TestDAONote.getInstance().getNoteList();

		return SUCCESS;
	}

	public String noteAdd() {

		DAOFactory.setTheFactory(TestDAOFactory.getInstance());
		TestDAONote dao = TestDAONote.getInstance();
		Teacher teacher = TestDAOTeacher.getInstance().readByAbbr(madeBy);

		Note note = new Note(message, title, teacher);
		dao.create(note);

		return SUCCESS;

	}

	public String noteEdit() {

		return SUCCESS;
	}

	public TreeSet<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(TreeSet<Note> noteList) {
		this.noteList = noteList;
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
