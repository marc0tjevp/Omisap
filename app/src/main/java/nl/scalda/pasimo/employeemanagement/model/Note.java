package nl.scalda.pasimo.employeemanagement.model;

import java.util.Date;

public class Note implements Comparable<Note>{
	
	private int id;
	private String title;
	private Date creationDate;
	private String message;
	private Teacher madeBy;
	private Date lastEdit;
	
	public Note(String title, String message, Teacher madeBy) {
		
		this.title = title;
		this.message = message;
		this.madeBy = madeBy;
		
		this.creationDate = new Date();
		this.lastEdit = this.creationDate;		
		
	}
	
	public Note editNote(String title, String message){
		
		this.title = title;
		this.message = message;
		
		this.lastEdit = new Date();
		
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
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

	public Date getLastEdit() {
		return lastEdit;
	}

	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	@Override
	public int compareTo(Note o) {
		if(this.id == o.getId())
		{
			return 0;
		}
		return 1;
	}

}
