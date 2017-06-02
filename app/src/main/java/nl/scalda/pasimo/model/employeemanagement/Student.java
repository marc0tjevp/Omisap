package nl.scalda.pasimo.model.employeemanagement;
import java.util.TreeSet;
import javax.persistence.*;
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.LessonGroupService;

@Entity
@Table(name="student")
public class Student extends Person {
	private static final long serialVersionUID = 1L;
	
	private int cardID;
	@Column(name="cohort")
	private int cohort;
	@Column(name="ovNumber")
	private int studentOV;
	@ManyToOne
	private LessonGroup lessonGroup;
	@ManyToOne
	private CoachGroup coachGroup;
	private int DayOfBirth;
	private int MonthOfBirth;
	private int YearOfBirth;
	private TreeSet<Note> noteList;

	
	public Student(int studentOV, int cohort, String email, String firstName, String insertion, String lastName,
			int cardID, int yearOfBirth, int monthOfBirth, int dayOfBirth, String coachGroupID, int lessonGroupID, int noteListID) {
			super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
			this.studentOV = studentOV;
			this.cohort = cohort;
			this.cardID = cardID;
			this.lessonGroup = LessonGroupService.getInstance().read(lessonGroupID);
			lessonGroup.addStudent(this);
			//this is null because coachGroupService readcoachgroup does use hardcoded coachgroups.
			this.coachGroup = CoachGroupService.getInstance().readCoachGroup(coachGroupID);
		}
	
	public Student() {
		// TODO Auto-generated constructor stub
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
	 * @param lessonGroupID
	 */
	

	
	public void createStudent(){
		DAOFactory.getTheFactory().getDAOStudent().create(this);
	}
	
	public boolean deleteStudent(Student s) {
		s = null;
		return true;
	}

	public int getCardID() {
		return cardID;
	}

	public void setCardID(int cardID) {
		this.cardID = cardID;
		//this.noteList = noteList;
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
	
	public int getDayOfBirth() {
		return DayOfBirth;
	}
	public void setDayOfBirth(int dayOfBirth) {
		DayOfBirth = dayOfBirth;
	}
	public int getMonthOfBirth() {
		return MonthOfBirth;
	}
	public void setMonthOfBirth(int monthOfBirth) {
		MonthOfBirth = monthOfBirth;
	}
	public int getYearOfBirth() {
		return YearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		YearOfBirth = yearOfBirth;
	}

	
	@Override
	public String toString() {
		return "Student [noteList=" + noteList + ", lessonGroup=" + lessonGroup.getName() + ", studentOV=" + studentOV
				+ ", cohort=" + cohort + ", coachGroup=" + coachGroup.getName()+ "]";
	}
	

		
	

}
