package nl.scalda.pasimo.controller.employeemanagement;

import java.io.File;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOTeacher;
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
		setTeamAbbreviation(getOldEducationTeam(teacher).getAbbreviation());
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
		EducationTeam et = getEducationTeamByAbbreviation(teamAbbreviation);
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
				f.setEmail(teacher.getEmail());
				f.setCardID(teacher.getCardID());
				if (!(getOldEducationTeam(f).getAbbreviation().equals(teamAbbreviation))){
					getOldEducationTeam(f).deleteTeacher(f);
					getEducationTeamByAbbreviation(teamAbbreviation).addTeacher(f);
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
	 * updates the teachers educationteam.
	 * 
	 * @param t
	 * @param newTeam
	 * @return String
	 */
	public String updateTeacherEducationTeam(Teacher t, EducationTeam newTeam) {
		if(!(getOldEducationTeam(t).equals(newTeam))){
			getOldEducationTeam(t).deleteTeacher(t);
			newTeam.addTeacher(t);
		}
		return SUCCESS;
	}
	
	/**
	 * Removes the teacher from the old education team.
	 * 
	 * @param t
	 * @param oldTeam
	 * @return String
	 */
	public String removeTeacherFromEducationTeam(Teacher t, EducationTeam oldTeam){
		oldTeam.deleteTeacher(t);
		return SUCCESS;
	}
	
	/**
	 * returns the education team the teacher is currently in.
	 * 
	 * @param t
	 * @return EducationTeam
	 */
	public EducationTeam getOldEducationTeam(Teacher t){
		try {
			return t.getEducationTeam();
		} catch(Exception e) {
			return null;
		}
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
	
	/**
	 * gets the educationteam with the abbreviation that equals given abbreviation
	 * 
	 * @param abbr
	 * @return EducationTeam
	 */
	public EducationTeam getEducationTeamByAbbreviation(String abbr){
		for(EducationTeam et : getEducationTeams()){
			if(et.getAbbreviation().equals(abbr)){
				return et;
			}
		}
		return null;
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
