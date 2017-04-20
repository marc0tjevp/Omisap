package nl.scalda.pasimo.model.employeemanagement;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.service.Service;

public class Note implements Comparable<Note> {
	static AtomicInteger count = new AtomicInteger(0);
	
	private int id;
    private String title;
    private Date creationDate;
    private String message;
    private Teacher madeBy;
    private Date lastEdit;
    private Student assignedTo;
    private int ovNumber;
    private int employeeNumber;
    /* empty constructor */
   
    public Note(){
    	
    }
    
    public Note(String title, String message, Student assignedTo, Teacher madeBy) {

        this.title = title;
        this.message = message;
        this.madeBy = madeBy;
        this.assignedTo = assignedTo;
        id = count.incrementAndGet();
        this.creationDate = new Date();
        this.lastEdit = new Date();
        assignedTo.getNoteList().add(this);
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
        return this.getId() == o.getId() ? -1 : 1;
//       return this.getCreationDate().equals(o.getCreationDate()) ? -1 : 1;
    }

}
