package nl.scalda.pasimo.model.employeemanagement;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.service.Service;

@Entity
@Table(name="note")
public class Note implements Comparable<Note> {

	@Id
	@Column(name="noteID", nullable=false)
    private int id;
	
	static AtomicInteger count = new AtomicInteger(0);
	
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

    private Student assignedTo;
    private int ovNumber;
    private int employeeNumber;
    
    /* empty constructor */
    public Note(){
    	id = count.incrementAndGet();
    }
    
    public Note(String title, String message, Teacher madeBy) {
    	
    }
    
    public Note(int noteID,int ovNumber, String title, String message, int employeeNumber){
    	this.lastEdit = new Date();
    	this.creationDate = new Date();
    	this.employeeNumber = employeeNumber;
    	this.ovNumber = ovNumber;
    }
    
    public Note(String title, String message, Student assignedTo, Teacher madeBy) {
        this.title = title;
        this.message = message;
        this.madeBy = madeBy;
        this.assignedTo = assignedTo;
        id = count.incrementAndGet();
        this.creationDate = new Date();
        this.lastEdit = new Date();
        Service.getInstance().getNoteService().create(this, assignedTo);
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
    
    public Student getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(Student student) {
		this.assignedTo = student;
	}
	
	public int getOvNumber() {
		return ovNumber;
	}

	public void setOvNumber(int ovNumber) {
		this.ovNumber = ovNumber;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
    public int compareTo(Note o) {
        if (this.id == o.getId()) {
            return 0;
        }
        return this.getCreationDate().before(o.getCreationDate()) ? -1 : 1;
    }

}
