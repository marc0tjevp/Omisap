package nl.scalda.pasimo.controller.employeemanagement;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

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
	 * Adds the teacher.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String addTeacher() {
		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		teacher.setAbbreviation();
		DAOFactory.getTheFactory().getDAOTeacher().create(teacher);
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
		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
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
			}
			MYSQLDAOTeacher.getInstance().update(getTeacher());
		}
		
		
//		for (Teacher f : TeacherList.getInstance().getTeachers()) {
//			if (f.getEmployeeNumber() == teacher.getEmployeeNumber()) {
//				EducationTeam oldTeam = getOldEducationTeam(f);
//				removeTeacherFromEducationTeam(f, oldTeam);
//				f.setFirstName(teacher.getFirstName());
//				f.setInsertion(teacher.getInsertion());
//				f.setLastName(teacher.getLastName());
//				f.setAbbreviation();
//				f.setCardID(teacher.getCardID());
//				f.setEmail(teacher.getEmail());
//				EducationTeam team = getEducationTeamByAbbreviation(teamAbbreviation);
//				updateTeacherEducationTeam(f, team);
//			}
//		}
		return SUCCESS;
	}

	/**
	 * Removes the teacher.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String removeTeacher() {
		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		teacher = getTeacherByEmployeeID(id);
		DAOFactory.getTheFactory().getDAOTeacher().delete(teacher);
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
		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		try {
			return DAOFactory.getTheFactory().getDAOTeacher().getCurrentEducationTeamOfTeacher(t);
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
			DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
			return DAOFactory.getTheFactory().getDAOTeacher().readByEmployeeNumber(id);
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
		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		teachers.addAll(DAOFactory.getTheFactory().getDAOTeacher().readAll());
		return teachers;
	}
	
	/**
	 * gets all education teams
	 * 
	 * @return TreeSet<EducationTeam>
	 */
	public TreeSet<EducationTeam> getEducationTeams() {
		DAOFactory.setTheFactory(MySQLDAOFactory.getInstance());
		educationTeams.addAll(DAOFactory.getTheFactory().getEducationTeamDAO().readAll());
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
