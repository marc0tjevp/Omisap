package nl.scalda.pasimo.controller.employeemanagement;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.CSVFactory.*;
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.service.StudentService;

public class StudentController extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private CSVReader c = CSVReader.getInstance();
	public TreeSet<LessonGroup> lessonGroups = new TreeSet<>();
	public LessonGroup lessonGroup;
	public int lessonGroupID;
	public Set<CoachGroup> coachGroups = new TreeSet<>();
	public File csvFile;
	public int cohort;
	public String coachGroupName;
	
	public String execute(){
		return SUCCESS;
	}

	public String AddStudentWithCSV(){ // this function will extract all students that are placed in a csv file.
		try {
			StudentService.getInstance().createAll(c.readFile(csvFile,coachGroupName,lessonGroupID,cohort));
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

	public LessonGroup getLessonGroup() {
		return lessonGroup;
	}

	public void setLessonGroup(LessonGroup lessonGroup) {
		this.lessonGroup = lessonGroup;
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

	public Set<CoachGroup> getCoachGroups() {
		if(coachGroups.isEmpty()){
			coachGroups.addAll(DAOFactory.getTheFactory().getDAOCoachGroup().readAll());
		}
		System.out.println("the coach groups = "+coachGroups);
		return coachGroups;
	}

	public void setCoachGroups(Set<CoachGroup> coachGroups) {
		this.coachGroups = coachGroups;
	}
	
	
	
}

