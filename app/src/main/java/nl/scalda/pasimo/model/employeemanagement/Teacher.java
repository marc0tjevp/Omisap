package nl.scalda.pasimo.model.employeemanagement;


import java.util.Date;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.service.NoteService;

@Entity
@Table(name="teacher")
@DiscriminatorValue(value="Teacher")
public class Teacher extends Person {

	private static final long serialVersionUID = 1L;

	@Column(name="employeeNumber", length=6, nullable=false)
	private int employeeNumber;
	
	@Column(name="abbreviation", length=6)
    private String abbreviation;
	
    /**
     * default constructor.
     */
    public Teacher(){}

    /**
     * constructor with all variables in the teacher class.
     * 
     * @param abbreviation
     * @param employeeNumber
     */
    public Teacher(String abbreviation, int employeeNumber) {
        this.abbreviation = abbreviation;
        this.employeeNumber = employeeNumber;
    }
    
    /**
     * constructor with all primary and foreign keys from teacher and person table.
     * 
     * @param abbreviation
     * @param employeeNumber
     * @param email
     */
    public Teacher(String abbreviation, int employeeNumber, int bsn) {
    	super(bsn);
        this.abbreviation = abbreviation;
        this.employeeNumber = employeeNumber;
    }

    /**
     * constructor with all variables.
     * 
     * @param employeeNumber
     * @param email
     * @param cardID
     * @param firstName
     * @param insertion
     * @param lastName
     * @param yearOfBirth
     * @param monthOfBirth
     * @param dayOfBirth
     */
    public Teacher(int bsn, int employeeNumber, String email, int cardID, String firstName, String insertion, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth){
		super(bsn, email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.employeeNumber = employeeNumber;
		setAbbreviation();
    }
    
    /**
     * creates the teacher in the (test)datalayer.
     */
    public void create(){
    	DAOFactory.getTheFactory().getDAOTeacher().create(this, null);
    }
    

    public Note createNote(String title, String message, Student s, Teacher madeBy){
    	System.out.println("test");
    	Note n = new Note(title, message, s, madeBy);
    	
    return n;
    }
   
    public void deleteNoteByID(int id){
    	NoteService.getInstance().delete(id);
        }
    
    public Note readNoteById(int id){
    	return NoteService.getInstance().readByID(id);
    }
    
    public void editNote(Note note){
    	note.setLastEdit(new Date());
    	NoteService.getInstance().update(note);
        }
    
    public void deleteAllNotes(){
    	NoteService.getInstance().deleteAll();
    }
    public TreeSet<Note> readAllNotes(){
    	return NoteService.getInstance().readAll();
    }
    /**
     * updates the teacher in the (test)datalayer.
     */
    public void update(){
    	DAOFactory.getTheFactory().getDAOTeacher().update(this, null);
    }
    
    public void delete(){
    	DAOFactory.getTheFactory().getDAOTeacher().delete(this, null);
    }
    
    /**
     * gets the coach group the teacher is currently in.
     * 
     * @return CoachGroup
     */
    public CoachGroup getCoachGroup(){
    	try{
    		return DAOFactory.getTheFactory().getDAOTeacher().getCurrentCoachGroup(this);
    	} catch(Exception e){
    		return null;
    	}
    	
    }
    
    /**
     * gets the education team the teacher is currently in.
     * 
     * @return EducationTeam
     */
    public EducationTeam getEducationTeam(){
    	try{
        	return DAOFactory.getTheFactory().getDAOTeacher().getCurrentEducationTeamOfTeacher(this);
    	} catch(Exception e){
    		return null;
    	}
    }
	
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation() {
        this.abbreviation = getLastName().substring(0, 4).toUpperCase() + getFirstName().substring(0, 2).toUpperCase();
    }
    
    public void setAbbreviation(String abbreviation){
    	this.abbreviation = abbreviation;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    
    @Override
    public String toString() {
        return "Teacher [abbreviation=" + abbreviation + ", employeeNumber=" + employeeNumber
                + ", cardID=" + getCardID() + ", name=" + getFullName() + "]";
    }
}