package nl.scalda.pasimo.model.employeemanagement;

import java.util.GregorianCalendar;

import nl.scalda.pasimo.service.Service;

public class Note implements Comparable<Note>{

	private int id;
	private String title;
	private GregorianCalendar creationDate;
	private String message;
	private Teacher madeBy;
	private GregorianCalendar lastEdit;

	public Note(String title, String message, Teacher madeBy) {

		this.title = title;
		this.message = message;
		this.madeBy = madeBy;

		this.creationDate = new GregorianCalendar();
		this.lastEdit = this.creationDate;
		Note cNote = Service.getInstance().getNoteService().create(this);
		this.id = cNote.getId();
	}

	/**
	 * Edits the note, and updates the lastEdit timestamp
	 * 
	 * @param title
	 *            title title of the note
	 * @param message
	 *            message message of the note
	 * @return Note note returns a updated note
	 * 
	 */
	public Note editNote(String title, String message) {

		this.title = title;
		this.message = message;

		this.lastEdit = new GregorianCalendar();
		Service.getInstance().getNoteService().update(this);
		return this;
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

	public GregorianCalendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(GregorianCalendar creationDate) {
		this.creationDate = creationDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Teacher getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(Teacher madeBy) {
		this.madeBy = madeBy;
	}

	public GregorianCalendar getLastEdit() {
		return lastEdit;
	}

	public void setLastEdit(GregorianCalendar lastEdit) {
		this.lastEdit = lastEdit;
	}

        @Override
	public int compareTo(Note o) {
		//Check if the note is the same
		if(this.id == o.getId())
		{
			return 0;
		}
		//if not, check if its before or after the this.getCreationDate
		if(this.getCreationDate().compareTo(o.getCreationDate()) != 0){
			return this.getCreationDate().compareTo(o.getCreationDate());
		}else {
			return -1;
		}

	}

}
