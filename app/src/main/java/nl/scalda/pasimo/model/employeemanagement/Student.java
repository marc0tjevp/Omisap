package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.LessonGroupService;

@Entity
@Table(name = "student")
@DiscriminatorValue(value = "Student")
public class Student extends Person {
	private static final long serialVersionUID = 1L;
	private int noteListID;

	private int cardID;
	@Column(name = "cohort")
	private int cohort;
	@Column(name = "ovNumber")
	private int studentOV;
	private TreeSet<Note> noteList = new TreeSet<>();
	private LessonGroup lessonGroup;
	private CoachGroup coachGroup;

	public Student(int bsn) {
		super(bsn);
	}

	public Student(int bsn, int studentOV, int cohort, String email, String firstName, String insertion,
			String lastName, int cardID, int yearOfBirth, TreeSet<Note> noteList, int monthOfBirth, int dayOfBirth) {
		super(bsn, email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.studentOV = studentOV;
		this.cohort = cohort;

	}

	public Student(int bsn, int studentOV, int cohort, String email, String firstName, String insertion,
			String lastName, int cardID, int yearOfBirth, TreeSet<Note> noteList, int monthOfBirth, int dayOfBirth,
			String coachGroupName, int lessonGroupID) {
		super(bsn, email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.studentOV = studentOV;
		this.cohort = cohort;
		this.cardID = cardID;
		this.lessonGroup = LessonGroupService.getInstance().read(lessonGroupID);
		lessonGroup.addStudent(this);
		// this is null because coachGroupService readcoachgroup does use
		// hardcoded coachgroups.
		this.coachGroup = CoachGroupService.getInstance().readCoachGroup(coachGroupName);
	}

	public Student() {

	}

	/**
	 * full constructor with coachgroup id.
	 * 
	 * @param studentOV
	 * @param cohort
	 * @param email
	 * @param firstName
	 * @param insertion
	 * @param lastName
	 * @param cardID
	 * @param yearOfBirth
	 * @param noteList
	 * @param monthOfBirth
	 * @param dayOfBirth
	 * @param coachGroupID
	 */

	public void createStudent() {
		DAOFactory.getTheFactory().getDAOStudent().create(this);
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

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
		// this.noteList = noteList;
	}

	public TreeSet<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(TreeSet<Note> noteList) {
		this.noteList = noteList;
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

		return getStudentOV() + " " + super.toString();
	}
}