package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

public class Student extends Person {


	private TreeSet<Note> noteList;
	private LessonGroup lessonGroup;
	private int cardID;
	private String firstName;
	private String insertion;
	private String lastName;
	private String email;
	private int cohort;
	private int studentOV;
	private int yearOfBirth;
	private int monthOfBirth;
	private int dayOfBirth;
	private CoachGroup coachGroup;
	
	public Student(String email) {
		this.email = email;
	}

	public Student(int studentOV, CoachGroup coachGroup, LessonGroup lessonGroup, int cohort, String email, String firstName,
			String insertion, String lastName, int cardID, int yearOfBirth, TreeSet<Note> noteList, int monthOfBirth,
			int dayOfBirth) {
		super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.studentOV = studentOV;
		this.coachGroup = coachGroup;
		this.lessonGroup = lessonGroup;
		this.cohort = cohort;
		this.email = email;
		this.firstName = firstName;
		this.insertion = insertion;
		this.lastName = lastName;
		this.cardID = cardID;
		this.yearOfBirth = yearOfBirth;
		this.noteList = noteList;
		this.monthOfBirth = monthOfBirth;
		this.dayOfBirth = dayOfBirth;
		this.addToCoachGroup(coachGroup);
	}

	public boolean deleteStudent(Student s) {
		s = null;
		return true;
	}
		
	public boolean addToCoachGroup(CoachGroup c){
		c.addStudent(this, c);
			return true;
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

	public void setNoteList(TreeSet<Note> noteList) {
		this.noteList = noteList;
	}

	public String getNameOfLessonGroup() {
		return lessonGroup.getName();
	}

	public void setLessonGroup(LessonGroup lessonGroup) {
		this.lessonGroup = lessonGroup;
	}

	public String getNameOfCoachGroup() {
		return coachGroup.getName();
	}

	public void setCoachGroup(CoachGroup coachGroup) {
		this.coachGroup = coachGroup;
	}

	public int getMonthOfBirth() {
		return monthOfBirth;
	}

	public void setMonthOfBirth(int monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}

	@Override
	public int compareTo(Person o) {
		return email.compareTo(o.getEmail());
	}

	@Override
	public String toString() {
		return "Student [noteList=" + noteList + ", lessonGroup=" + lessonGroup + ", cardID=" + cardID + ", firstName="
				+ firstName + ", insertion=" + insertion + ", lastName=" + lastName + ", email=" + email + ", cohort="
				+ cohort + ", coachGroup=" + coachGroup + ", studentOV=" + studentOV + ", yearOfBirth=" + yearOfBirth
				+ ", monthOfBirth=" + monthOfBirth + ", dayOfBirth=" + dayOfBirth + ", CoachGroup=" + coachGroup + "]";
	}

	
}
