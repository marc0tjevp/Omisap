package nl.scalda.pasimo.controller.employeemanagement;

import java.io.File;
import java.util.TreeSet;
import com.opensymphony.xwork2.ActionSupport;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;
import nl.scalda.pasimo.service.StudentService;

import nl.scalda.pasimo.datalayer.CSVFactory.*;
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

public class StudentController extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private CSVReader c = CSVReader.getInstance();
	public TreeSet<LessonGroup> lessonGroups = new TreeSet<>();
	public TreeSet<CoachGroup> coachGroups = new TreeSet<>();
	public TreeSet<CheckIn> studentCheckinz;
	public File csvFile;
	public int cohort;
	public int lessonGroupID;
	public String coachGroupName;
	
	public String execute() {
		Student z = new Student(12, 23, "student@scalda", "voornaam", "", "achternaam", 0, 1997, note, 05, 21);
		StudentService.getInstance().checkInData(z);
		studentCheckinz = z.getStudentCheckIns();

		return SUCCESS;
	}
	
	public String AddStudentWithCSV(){
		try {
			c.readFile(csvFile,coachGroupName,lessonGroupID,cohort);
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public CSVReader getC() {
		return c;
	}

	public void setC(CSVReader c) {
		this.c = c;
	}

	public File getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(File csvFile) {
		this.csvFile = csvFile;
	}

	public int getCohort() {
		return cohort;
	}

	public void setCohort(int cohort) {
		this.cohort = cohort;
	}

	public int getLessonGroupID() {
		return lessonGroupID;
	}

	public void setLessonGroupID(int lessonGroupID) {
		this.lessonGroupID = lessonGroupID;
	}

	public String getCoachGroupName() {
		return coachGroupName;
	}

	public void setCoachGroupName(String coachGroupName) {
		this.coachGroupName = coachGroupName;
	}

	public TreeSet<LessonGroup> getLessonGroups() {
		if(lessonGroups.isEmpty()){
			lessonGroups.addAll(DAOFactory.getTheFactory().getDAOLessonGroup().readAll());
		}
		return lessonGroups;
	}

	public void setLessonGroups(TreeSet<LessonGroup> lessonGroups) {
		this.lessonGroups = lessonGroups;
	}

	public TreeSet<CoachGroup> getCoachGroups() {
		if(coachGroups.isEmpty()){
			coachGroups.addAll(DAOFactory.getTheFactory().getDAOCoachGroup().readAll());
		}
		System.out.println("the coach groups = "+coachGroups);
		return coachGroups;
	}

	public void setCoachGroups(TreeSet<CoachGroup> coachGroups) {
		this.coachGroups = coachGroups;
	}
	

	TreeSet<Note> note = new TreeSet<>();



	public TreeSet<CheckIn> getStudentCheckinz() {
		return studentCheckinz;
	}

	public void setStudentCheckinz(TreeSet<CheckIn> studentCheckinz) {
		this.studentCheckinz = studentCheckinz;
	}

}

