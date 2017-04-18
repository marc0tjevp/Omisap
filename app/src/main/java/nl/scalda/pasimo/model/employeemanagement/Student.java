package nl.scalda.pasimo.model.employeemanagement;

<<<<<<< HEAD
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
=======
import java.util.TreeSet;
>>>>>>> develop

public class Student extends Person {

	private TreeSet<Note> noteList = new TreeSet<>();
	private LessonGroup lessonGroup;
	private int studentOV;
	private int cohort;
	private CoachGroup coachGroup;

	public Student(String email) {

<<<<<<< HEAD
	
	public Student(){
=======
>>>>>>> develop
	}

	public Student(int studentOV, int cohort, String email, String firstName, String insertion, String lastName,
			int cardID, int yearOfBirth, TreeSet<Note> noteList, int monthOfBirth, int dayOfBirth) {
		super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
		this.studentOV = studentOV;
		this.cohort = cohort;
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

<<<<<<< HEAD
	public void setDayOfBirth(int dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	

	  @Override
	    public int compareTo(Person o) {
	        return email.compareTo(o.getEmail());
	    }
	    public void create(){
	    	DAOFactory.getTheFactory().getDAOStudent().create(this);
	    }
	
=======
>>>>>>> develop
	@Override
	public String toString() {
		return "Student [noteList=" + noteList + ", lessonGroup=" + lessonGroup + ", studentOV=" + studentOV
				+ ", cohort=" + cohort + ", coachGroup=" + coachGroup + "]";
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> develop
