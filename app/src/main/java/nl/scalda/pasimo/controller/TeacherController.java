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

	public String execute() {
		return SUCCESS;
	}
	
	/**
	 * Sets the teacher variable according to the id parameter in the URL.
	 * @return String
	 */
	public String loadTeacherInfo() {
		teacher = getTeacherByEmployeeID(id);
		return SUCCESS;
	}

	/**
	 * Adds the teacher to the Teacher list.
	 * @return String
	 */
	public String addTeacher() {
		// EducationTeam team =
		// getEducationTeamByTeamAbbreviation(teamAbbreviation);
		teacher.setAbbreviation();
		TeacherList.getInstance().addTeacher(teacher);
		// getTeachers();
		// team.addTeacher(teacher);
		return SUCCESS;
	}

	/**
	 * Gets the teachers for displaying on the webpage.
	 * @return String
	 */
	public String readTeacher() {
		Teacher t = new Teacher(123456, "email@myemaildomain.com", 654321789, "henk", "de", "alien", 1965, 7, 23);
		Teacher t1 = new Teacher(876543, "perkamentus@zweinstein.uk", 635685473, "Hermelien", "", "Griffel", 1990, 5, 20);
		TeacherList.getInstance().addTeacher(t);
		TeacherList.getInstance().addTeacher(t1);
		return SUCCESS;
	}

	/**
	 * Updates the teacher. 
	 * @return String
	 */
	public String updateTeacher() {
		return SUCCESS;
	}

	/**
	 * Removes the teacher from the Teacher list.
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
		return SUCCESS;
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
	
	// public EducationTeam getEducationTeamByID(String abbreviation){
	// for (EducationTeam ct : Cluster.getInstance().getEducationTeams()) {
	// for(Teacher cte : ct.getTeachers()){
	// if(cte.getAbbreviation().equals(abbreviation)){
	// return ct;
	// }
	// }
	// }
	// return null;
	// }

	// public EducationTeam getEducationTeamByTeamAbbreviation(String
	// abbreviation){
	// for(EducationTeam e : Cluster.getInstance().getEducationTeams()){
	// if(e.getAbbreviation().equals(abbreviation)){
	// return e;
	// }
	// }
	// return null;
	// }
	
	public TreeSet<Teacher> getTeachers() {
		System.out.println(TeacherList.getInstance().getTeachers());
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
		EducationTeam et = new EducationTeam("TET", "Test Team");

		educationTeams.add(et);

		// Cluster.getInstance().addEducationTeamToCollection(et);
		// ONLY FOR TESTING
		return educationTeams;
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