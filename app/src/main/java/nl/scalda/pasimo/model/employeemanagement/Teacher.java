package nl.scalda.pasimo.model.employeemanagement;

import java.util.Date;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOTeacher;
import nl.scalda.pasimo.service.NoteService;

public class Teacher extends Person {

    private String abbreviation;
    private int employeeNumber;
    
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
    public Teacher(String abbreviation, int employeeNumber, String email) {
    	super(email);
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
    public Teacher(int employeeNumber, String email, int cardID, String firstName, String insertion, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth){
		super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.employeeNumber = employeeNumber;
		setAbbreviation();
    }
    
    /**
     * creates the teacher in the (test)datalayer.
     */
    public void create(){
    	DAOFactory.getTheFactory().getDAOTeacher().create(this);
    }
    
    public void createNote(String title, String message, Student s){
    Note n = new Note(title, message, s, this);
    }
    
    public void deleteNoteByID(int id){
    	NoteService.getInstance().delete(id);
        }
    
    public void editNote(Note note){
    	note.setLastEdit(new Date());
    	NoteService.getInstance().update(note);
        }
    
    public void deleteAll(){
    	NoteService.getInstance().deleteAll();
    }
    /**
     * updates the teacher in the (test)datalayer.
     */
    public void update(){
    	DAOFactory.getTheFactory().getDAOTeacher().update(this);
    }
    
    public void delete(){
    	DAOFactory.getTheFactory().getDAOTeacher().delete(this);
    }
    
    /**
     * gets the coach group the teacher is currently in.
     * 
     * @return CoachGroup
     */
    public CoachGroup getCoachGroup(){
    	DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
    	return DAOFactory.getTheFactory().getDAOTeacher().getCurrentCoachGroup(this);
    }
    
    /**
     * gets the education team the teacher is currently in.
     * 
     * @return EducationTeam
     */
    public EducationTeam getEducationTeam(){
    	DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
    	return DAOFactory.getTheFactory().getDAOTeacher().getCurrentEducationTeamOfTeacher(this);
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