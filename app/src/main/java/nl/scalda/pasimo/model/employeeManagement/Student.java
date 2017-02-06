package nl.scalda.pasimo.model.employeeManagement;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class Student extends Person {

	private int ovNumber;
	private GregorianCalendar cohort;

	public Student(int ovNumber, GregorianCalendar cohort) {
		this.ovNumber = ovNumber;
		this.cohort = cohort;
	}

	public Student(int ovNumber, GregorianCalendar cohort, String email, int cardID, String firstName, String insertion, String lastName, Date dateOfBirth) {
		super(email, cardID, firstName, insertion, lastName, dateOfBirth);
		this.ovNumber = ovNumber;
		this.cohort = cohort;
	}

	public int getOvNumber() {
		return ovNumber;
	}

	public void setOvNumber(int ovNumber) {
		this.ovNumber = ovNumber;
	}

	public int getCohort() {
		return cohort.get(GregorianCalendar.YEAR);
	}

	public void setCohort(GregorianCalendar cohort) {
		this.cohort = cohort;
	}

	@Override
	public String toString() {
		return "Student [ovNumber= " + ovNumber + ", cohort= " + getCohort() + ", name= " + getFullName() + "]";
	}

}