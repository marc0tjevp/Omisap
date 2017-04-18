package nl.scalda.pasimo.model.employeemanagement;

import javax.persistence.*;

import java.util.TreeSet;

@Entity
@Table(name="student")
@DiscriminatorValue(value="Student")
public class Student extends Person {

	private static final long serialVersionUID = 1L;
	private int noteListID;
	private int lessonGroupID;
	private int cardID;
	
	private TreeSet<Note> noteList = new TreeSet<>();
	private LessonGroup lessonGroup;
	private CoachGroup coachGroup;
	
	@Column(name="cohort")
	private int cohort;
	
	private int coachGroupID;

	@Column(name="ovNumber", nullable=false)
	private int studentOV;

	
	public Student(String email){
		super(email);
	}
	
	public Student(int studentOV, int cohort, String email, String firstName, String insertion, String lastName,
			int cardID, int yearOfBirth, TreeSet<Note> noteList, int monthOfBirth, int dayOfBirth) {
		super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.studentOV = studentOV;
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
		this.noteList = noteList;
	}
	

	public TreeSet<Note> getNoteList() {
		return noteList;
	}

	public LessonGroup getLessonGroup() {
		return lessonGroup;
	}

	public CoachGroup getCoachGroup() {
		return coachGroup;
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

	@Override
	public int compareTo(Person o) {
	    return getEmail().compareTo(o.getEmail());
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

	@Override
	public String toString() {
		return "Student [noteList=" + noteList + ", lessonGroup=" + lessonGroup + ", studentOV=" + studentOV
				+ ", cohort=" + cohort + ", coachGroup=" + coachGroup + "]";
	}

}
