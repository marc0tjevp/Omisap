<<<<<<< HEAD
package nl.scalda.pasimo.model.employeemanagement;


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

    @Override
    public String toString() {
        return "Teacher [abbreviation=" + abbreviation + ", employeeNumber=" + employeeNumber
                + ", cardID=" + getCardID() + ", name=" + getFullName() + "]";
    }

}
=======
package nl.scalda.pasimo.model.employeemanagement;

import nl.scalda.pasimo.test.EducationTeamList;
import nl.scalda.pasimo.test.TeacherList;

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
    	//TODO
    	return null;
    }
    
    public EducationTeam getEducationTeam(){
    	for(EducationTeam et : EducationTeamList.getInstance().getTeams()){
			if(et.getTeachers().contains(this)){
				return et;
			}
		}
    	return null;
    }

    @Override
    public String toString() {
        return "Teacher [abbreviation=" + abbreviation + ", employeeNumber=" + employeeNumber
                + ", cardID=" + getCardID() + ", name=" + getFullName() + "]";
    }

}
>>>>>>> develop
