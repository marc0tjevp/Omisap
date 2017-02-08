package nl.scalda.pasimo.controller;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOFactory;
import nl.scalda.pasimo.model.employeeManagement.EducationTeam;
import nl.scalda.pasimo.model.employeeManagement.Teacher;
import nl.scalda.pasimo.service.Service;
import nl.scalda.pasimo.test.EducationTeamList;
import nl.scalda.pasimo.test.TeacherList;

public class TeacherController extends ActionSupport {

	public Teacher teacher = new Teacher();
	public String teamAbbreviation;
	public TreeSet<Teacher> teachers = new TreeSet<>();
	public TreeSet<EducationTeam> educationTeams = new TreeSet<>();
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private int id;

	/**
	 * Default execution method.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String execute() {
		return SUCCESS;
	}

	/**
	 * Sets the teacher variable according to the id parameter in the URL.
	 * 
	 * @return String
	 */
	public String loadTeacherInfo() {
		teacher = getTeacherByEmployeeID(id);
		setTeamAbbreviation(getOldEducationTeam(teacher).getAbbreviation());
		return SUCCESS;
	}

	/**
	 * Adds the teacher to the Teacher list.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String addTeacher() {
		// EducationTeam team =
		// getEducationTeamByTeamAbbreviation(teamAbbreviation);
		teacher.setAbbreviation();
		TeacherList.getInstance().addTeacher(teacher);
		EducationTeam et = getEducationTeamByAbbreviation(teamAbbreviation);
		et.addTeacher(teacher);
		// getTeachers();
		// team.addTeacher(teacher);
		return SUCCESS;
	}

	/**
	 * Gets the teachers for displaying on the webpage.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String readTeacher() {
		// Teacher t = new Teacher(123456, "email@myemaildomain.com", 654321789,
		// "henk", "de", "alien", 1965, 7, 23);
		// Teacher t1 = new Teacher(876543, "perkamentus@zweinstein.uk",
		// 635685473, "Hermelien", "", "Griffel", 1990, 5, 20);
		// TeacherList.getInstance().addTeacher(t);
		// TeacherList.getInstance().addTeacher(t1);
		return SUCCESS;
	}

	/**
	 * Updates the teacher.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String updateTeacher() {
		for (Teacher f : TeacherList.getInstance().getTeachers()) {
			if (f.getEmployeeNumber() == teacher.getEmployeeNumber()) {
				EducationTeam oldTeam = getOldEducationTeam(f);
				removeTeacherFromEducationTeam(f, oldTeam);
				f.setFirstName(teacher.getFirstName());
				f.setInsertion(teacher.getInsertion());
				f.setLastName(teacher.getLastName());
				f.setAbbreviation();
				f.setCardID(teacher.getCardID());
				f.setEmail(teacher.getEmail());
				EducationTeam team = getEducationTeamByAbbreviation(teamAbbreviation);
				updateTeacherEducationTeam(f, team);
			}
		}
		return SUCCESS;
	}

	/**
	 * Removes the teacher from the Teacher list.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String removeTeacher() {
		teacher = getTeacherByEmployeeID(id);
		TeacherList.getInstance().removeTeacher(teacher);
		return SUCCESS;
	}

	/**
	 * updates the teachers educationteam.
	 * 
	 * @param t
	 * @param newTeam
	 * @return String
	 */
	public String updateTeacherEducationTeam(Teacher t, EducationTeam newTeam) {
		newTeam.addTeacher(t);
		return SUCCESS;
	}
	
	public String removeTeacherFromEducationTeam(Teacher t, EducationTeam oldTeam){
		oldTeam.deleteTeacher(t);
		return SUCCESS;
	}
	
	public EducationTeam getOldEducationTeam(Teacher t){
		
		for(EducationTeam et : getEducationTeams()){
			if(et.getTeachers().contains(t)){
				return et;
			}
		}
		return null;
	}

	/**
	 * gets the teacher by employee number.
	 * 
	 * @param id
	 * @return Teacher
	 */
	private Teacher getTeacherByEmployeeID(int id) {
		for (Teacher t : getTeachers()) {
			if (t.getEmployeeNumber() == id) {
				return t;
			}
		}
		return null;
	}

	public TreeSet<Teacher> getTeachers() {
		teachers.addAll(TeacherList.getInstance().getTeachers());
		return teachers;
	}

	public void setTeachers(TreeSet<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getTeamAbbreviation() {
		return teamAbbreviation;
	}

	public void setTeamAbbreviation(String teamAbbreviation) {
		this.teamAbbreviation = teamAbbreviation;
	}

	public TreeSet<EducationTeam> getEducationTeams() {
		// ONLY FOR TESTING
		if(EducationTeamList.getInstance().getTeams().isEmpty()){
			EducationTeam et = new EducationTeam("TET", "Test Team");
			EducationTeam et1 = new EducationTeam("TEAMAN", "Ander Team");

			EducationTeamList.getInstance().addTeam(et);
			EducationTeamList.getInstance().addTeam(et1);
		}
		educationTeams.addAll(EducationTeamList.getInstance().getTeams());
		// ONLY FOR TESTING
		return educationTeams;
	}
	
	public EducationTeam getEducationTeamByAbbreviation(String abbr){
		for(EducationTeam et : getEducationTeams()){
			if(et.getAbbreviation().equals(abbr)){
				return et;
			}
		}
		return null;
	}

	public void setEducationTeams(TreeSet<EducationTeam> educationTeams) {
		this.educationTeams = educationTeams;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
