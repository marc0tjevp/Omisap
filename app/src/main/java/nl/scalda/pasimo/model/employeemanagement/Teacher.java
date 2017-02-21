package nl.scalda.pasimo.model.employeemanagement;

<<<<<<< HEAD
import java.util.Date;

=======
>>>>>>> develop
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

<<<<<<< HEAD
    public Teacher(String abbreviation, int employeeNumber, String email, int cardID, String firstName, String insertion, String lastName, Date dateOfBirth) {
        super(email, cardID, firstName, insertion, lastName, dateOfBirth);
        this.abbreviation = abbreviation;
        this.employeeNumber = employeeNumber;
    }
=======
    public Teacher(int employeeNumber, String email, int cardID, String firstName, String insertion, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth){
		super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.employeeNumber = employeeNumber;
		setAbbreviation();
	}
>>>>>>> develop

    public String getAbbreviation() {
        return abbreviation;
    }

<<<<<<< HEAD
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
=======
    public void setAbbreviation() {
        this.abbreviation = getLastName().substring(0, 4).toUpperCase() + getFirstName().substring(0, 2).toUpperCase();
    }
    
    public void setAbbreviation(String abbreviation){
    	this.abbreviation = abbreviation;
>>>>>>> develop
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
