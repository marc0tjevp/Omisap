package nl.scalda.pasimo.controller.employeemanagement;

import java.io.File;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.CSVFactory.*;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

public class StudentController extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private CSVReader c = CSVReader.getInstance();
	public TreeSet<LessonGroup> lessonGroups = new TreeSet<>();
	public TreeSet<CoachGroup> coachGroups = new TreeSet<>();
	public File csvFile;
	public int cohort;
	public int lessonGroupID;
	public String coachGroupName;
	
	public String execute(){
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
			lessonGroups.add(new LessonGroup(0, "test"));
			lessonGroups.add(new LessonGroup(1, "test1"));
		}
		return lessonGroups;
	}

	public void setLessonGroups(TreeSet<LessonGroup> lessonGroups) {
		this.lessonGroups = lessonGroups;
	}

	public TreeSet<CoachGroup> getCoachGroups() {
		if(coachGroups.isEmpty()){
			coachGroups.add(new CoachGroup("test"));
			coachGroups.add(new CoachGroup("test1"));
		}
		return coachGroups;
	}

	public void setCoachGroups(TreeSet<CoachGroup> coachGroups) {
		this.coachGroups = coachGroups;
	}
	
	
	
}

