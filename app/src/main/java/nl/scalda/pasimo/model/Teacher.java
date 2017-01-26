package nl.scalda.pasimo.model;

import java.util.Date;

public class Teacher extends Person {

	private String abbreviation;
	private int employeeNumber;

	public Teacher(String abbreviation){
		this.abbreviation = abbreviation;
	}

	public Teacher(String abbreviation, int employeeNumber) {
		this.abbreviation = abbreviation;
		this.employeeNumber = employeeNumber;
	}
	
	public Teacher(String abbreviation, int employeeNumber, String email, int cardID, String firstName, String insertion, String lastName, Date dateOfBirth){
		super(email, cardID, firstName, insertion, lastName, dateOfBirth);
		this.abbreviation = abbreviation;
		this.employeeNumber = employeeNumber;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
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
