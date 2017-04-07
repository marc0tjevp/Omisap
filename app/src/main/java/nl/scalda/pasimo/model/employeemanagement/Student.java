package nl.scalda.pasimo.model.employeemanagement;

import javax.persistence.*;

@Entity
@Table(name="student")
@DiscriminatorValue(value="Student")
public class Student extends Person {
	
//	@OneToOne
//	@PrimaryKeyJoinColumn(name="person_email", referencedColumnName="email")
//	private Person person;

	private static final long serialVersionUID = 1L;
	private int noteListID;
	private int lessonGroupID;
	private int cardID;
	
	@Column(name="cohort")
	private int cohort;
	
	private int coachGroupID;
	
	//FIXME this needs to be the pk of student table
	//@Id
	@Column(name="ovNumber", nullable=false)
	private int studentOV;

	
	public Student(String email){
		super(email);
	}
	
	public Student(int studentOV, int coachGroupID, int lessonGroupID, int cohort, String email, String firstName,
			String insertion, String lastName, int cardID, int yearOfBirth, int noteListID, int monthOfBirth,
			int dayOfBirth) {
		super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.studentOV = studentOV;
		this.coachGroupID = coachGroupID;
		this.lessonGroupID = lessonGroupID;
		this.cohort = cohort;
		this.cardID = cardID;
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

	@Override
	public int compareTo(Person o) {
	    return getEmail().compareTo(o.getEmail());
	}
	
	@Override
	public String toString() {
		return "Student [noteListID=" + getNoteListID() + ", lessonGroupID=" + getLessonGroupID() + ", cardID=" + getCardID()
				+ ", firstName=" + getFirstName() + ", insertion=" + getInsertion() + ", lastName=" + getLastName() + ", email="
				+ getEmail() + ", cohort=" + getCohort() + ", coachGroupID=" + getCoachGroupID() + ", studentOV=" + getStudentOV()
				+ "dateOfBirth=" + getDateOfBirthInString() + "]";
	}

}