package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

public class Student extends Person {

    private TreeSet<Note> noteList = new TreeSet<>();
	private LessonGroup lessonGroup;
	private int cohort;
	private int coachGroupID;
	


	public boolean deleteStudent(Student s) {
		s = null;
		return true;
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

}




	
	

