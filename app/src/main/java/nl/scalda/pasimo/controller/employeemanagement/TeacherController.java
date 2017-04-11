package nl.scalda.pasimo.controller.employeemanagement;

import java.io.File;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.EducationTeamService;
import nl.scalda.pasimo.service.TeacherService;

public class TeacherController extends ActionSupport {

	private static final long serialVersionUID = 1L;
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
		setTeamAbbreviation(EducationTeamService.getInstance().getOldEducationTeam(teacher).getAbbreviation());
		return SUCCESS;
	}

	/**
	 * Adds the teacher.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String addTeacher() {
		teacher.setAbbreviation();
		teacher.create();
		EducationTeam et = EducationTeamService.getInstance().getEducationTeamByAbbreviation(teamAbbreviation);
		et.addTeacher(teacher);
		return SUCCESS;
	}

	/**
	 * Gets the teachers for displaying on the webpage.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String readTeacher() {
		getTeachers();
		return SUCCESS;
	}

	/**
	 * Updates the teacher.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String updateTeacher() {
		for (Teacher f : getTeachers()) {
			if (f.getEmployeeNumber() == teacher.getEmployeeNumber()){
				f.setFirstName(teacher.getFirstName());
				f.setAbbreviation();
				f.setInsertion(teacher.getInsertion());
				f.setLastName(teacher.getLastName());
				f.setCardID(teacher.getCardID());
				if (!(EducationTeamService.getInstance().getOldEducationTeam(f).getAbbreviation().equals(teamAbbreviation))){
					EducationTeamService.getInstance().getOldEducationTeam(f).deleteTeacher(f);
					EducationTeamService.getInstance().getEducationTeamByAbbreviation(teamAbbreviation).addTeacher(f);
				}
				f.update();
			}
		}
		return SUCCESS;
	}

	/**
	 * Removes the teacher.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String removeTeacher() {
		teacher = getTeacherByEmployeeID(id);
		teacher.delete();
		return SUCCESS;
	}
	
	/**
	 * gets the teacher by employee number.
	 * 
	 * @param id
	 * @return Teacher
	 */
	private Teacher getTeacherByEmployeeID(int id) {
		try {
			return TeacherService.getInstance().getTeacherByEmployeeID(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * gets all teachers
	 * 
	 * @return TreeSet<Teacher>
	 */
	public TreeSet<Teacher> getTeachers() {
		try {
			teachers.addAll(TeacherService.getInstance().readAll());
			return teachers;
		} catch (Exception e){
			return null;
		}
	}
	
	/**
	 * gets all education teams
	 * 
	 * @return TreeSet<EducationTeam>
	 */
	public TreeSet<EducationTeam> getEducationTeams() {
		educationTeams.addAll(EducationTeamService.getInstance().getEducationTeams());
		return educationTeams;
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
