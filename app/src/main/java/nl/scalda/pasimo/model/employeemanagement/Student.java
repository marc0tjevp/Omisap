package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;

public class Student extends Person {


	private TreeSet<Note> noteList;
	private LessonGroup lessonGroup;
	private int studentOV;
	private int cohort;
	private CoachGroup coachGroup;
	
	public Student(String email){
		
	}
	public Student(){
	
	}
	
	public Student(int studentOV, CoachGroup coachGroup, LessonGroup lessonGroup, int cohort, String email, String firstName,
			String insertion, String lastName, int cardID, int yearOfBirth, TreeSet<Note> noteList, int monthOfBirth,
			int dayOfBirth) {
		super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.studentOV = studentOV;
		this.coachGroup = coachGroup;
		this.lessonGroup = lessonGroup;
		this.cohort = cohort;
		this.noteList = noteList;
	}

	public boolean deleteStudent(Student s) {
		s = null;
		return true;
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
	
	/**
     * creates the student in the (test)datalayer.
     */
	 public void create(){
    	DAOFactory.getTheFactory().getDAOStudent().create(this);
    }
	
	
}
