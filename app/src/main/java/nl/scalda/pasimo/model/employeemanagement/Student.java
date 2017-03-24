package nl.scalda.pasimo.model.employeemanagement;

import javax.persistence.*;

@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name="email", referencedColumnName="email")
public class Student extends Person {

	private static final long serialVersionUID = 1L;
	private int noteListID;
	private int lessonGroupID;
	private int cardID;
	private String firstName;
	private String insertion;
	private String lastName;
	private String email;
	
	@Column(name="cohort")
	private int cohort;
	
	private int coachGroupID;
	
	//this needs to be the pk of student table
	//@Id
	@Column(name="ovNumber")
	private int studentOV;
	
	private int yearOfBirth;
	private int monthOfBirth;
	private int dayOfBirth;

	
	public Student(String email){
		this.email = email;
	}
	
	public Student(int studentOV, int coachGroupID, int lessonGroupID, int cohort, String email, String firstName,
			String insertion, String lastName, int cardID, int yearOfBirth, int noteListID, int monthOfBirth,
			int dayOfBirth) {
		super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.studentOV = studentOV;
		this.coachGroupID = coachGroupID;
		this.lessonGroupID = lessonGroupID;
		this.cohort = cohort;
		this.email = email;
		this.firstName = firstName;
		this.insertion = insertion;
		this.lastName = lastName;
		this.cardID = cardID;
		this.yearOfBirth = yearOfBirth;
		this.noteListID = noteListID;
		this.monthOfBirth = monthOfBirth;
		this.dayOfBirth = dayOfBirth;
	}

	public boolean deleteStudent(Student s) {
		s = null;
		return true;
	}

	public int getNoteListID() {
		return noteListID;
	}

	public void setNoteListID(int noteListID) {
		this.noteListID = noteListID;
	}

	public int getLessonGroupID() {
		return lessonGroupID;
	}

	public void setLessonGroupID(int lessonGroupID) {
		this.lessonGroupID = lessonGroupID;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getInsertion() {
		return insertion;
	}

	public void setInsertion(String insertion) {
		this.insertion = insertion;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCohort() {
		return cohort;
	}

	public void setCohort(int cohort) {
		this.cohort = cohort;
	}

	public int getCoachGroupID() {
		return coachGroupID;
	}

	public void setCoachGroupID(int coachGroupID) {
		this.coachGroupID = coachGroupID;
	}

	public int getStudentOV() {
		return studentOV;
	}

	public void setStudentOV(int studentOV) {
		this.studentOV = studentOV;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getMontOfBirth() {
		return monthOfBirth;
	}

	public void setMontOfBirth(int montOfBirth) {
		this.monthOfBirth = montOfBirth;
	}

	public int getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(int dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	

	  @Override
	    public int compareTo(Person o) {
	        return email.compareTo(o.getEmail());
	    }
	
	@Override
	public String toString() {
		return "Student [noteListID=" + noteListID + ", lessonGroupID=" + lessonGroupID + ", cardID=" + cardID
				+ ", firstName=" + firstName + ", insertion=" + insertion + ", lastName=" + lastName + ", email="
				+ email + ", cohort=" + cohort + ", coachGroupID=" + coachGroupID + ", studentOV=" + studentOV
				+ ", yearOfBirth=" + yearOfBirth + ", monthOfBirth=" + monthOfBirth + ", dayOfBirth=" + dayOfBirth
				+ "]";
	}

	
	

}