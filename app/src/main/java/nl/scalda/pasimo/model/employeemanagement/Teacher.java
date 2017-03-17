package nl.scalda.pasimo.model.employeemanagement;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;

public class Teacher extends Person {

    private String abbreviation;
    private int employeeNumber;
    
    public Teacher(){
        
    }

    public Teacher(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Teacher(String abbreviation, int employeeNumber) {
        this.abbreviation = abbreviation;
        this.employeeNumber = employeeNumber;
    }
    
    public Teacher(String abbreviation, int employeeNumber, String email) {
    	super(email);
        this.abbreviation = abbreviation;
        this.employeeNumber = employeeNumber;
    }

    public Teacher(int employeeNumber, String email, int cardID, String firstName, String insertion, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth){
		super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.employeeNumber = employeeNumber;
		setAbbreviation();
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
    
    public CoachGroup getCoachGroup(){
    	DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
    	return DAOFactory.getTheFactory().getDAOTeacher().getCurrentCoachGroup(this);
    }
    
    public EducationTeam getEducationTeam(){
    	DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
    	return DAOFactory.getTheFactory().getDAOTeacher().getCurrentEducationTeamOfTeacher(this);
    }

    @Override
    public String toString() {
        return "Teacher [abbreviation=" + abbreviation + ", employeeNumber=" + employeeNumber
                + ", cardID=" + getCardID() + ", name=" + getFullName() + "]";
    }

}
