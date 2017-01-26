package nl.scalda.pasimo.model;

import java.text.SimpleDateFormat;

public class Teacher extends Person {

	private String abbreviation;
	private int employeeNumber;
	
	public Teacher() {}
	
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
