package nl.scalda.pasimo.model.employeemanagement;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import nl.scalda.pasimo.service.Service;

@Entity
@Table(name="note")
public class Note implements Comparable<Note> {

	@Id
	@Column(name="noteID", nullable=false)
    private int id;
	
	@Column(name="title")
    private String title;
	
	@Column(name="creationDate", updatable=false)
    private Date creationDate;
	
	@Column(name="message")
    private String message;
	
	@Type(type="java.lang.String")
    private Teacher madeBy;
	
	@Column(name="lastEdit")
    private Date lastEdit;
	
	public Note(){}

    public Note(String title, String message, Teacher madeBy) {

        this.title = title;
        this.message = message;
        this.madeBy = madeBy;

        this.creationDate = new Date();
        this.lastEdit = this.creationDate;
        Note cNote = Service.getInstance().getNoteService().create(this);
        this.id = cNote.getId();
    }

    /**
     * Edits the note, and updates the lastEdit timestamp
     *
     * @param title   title of the note
     * @param message message of the note
     * @return Note note returns a updated note
     */
    public Note editNote(String title, String message) {

        this.title = title;
        this.message = message;

        this.lastEdit = new Date();
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
        if (this.id == o.getId()) {
            return 0;
        }
        return this.getCreationDate().before(o.getCreationDate()) ? -1 : 1;
    }

}
