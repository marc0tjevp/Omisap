package nl.scalda.pasimo.controller.employeemanagement;

import java.io.File;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;


import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.service.EducationTeamService;
import nl.scalda.pasimo.service.StudentService;


public class StudentController extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static final String Lessongroup = null;
	public Student Student = new Student();
	public TreeSet<Student> Students = new TreeSet<>();
	public TreeSet<LessonGroup> educationTeams = new TreeSet<>();
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
	 * Sets the Student variable according to the id parameter in the URL.
	 * 
	 * @return String
	 */
	public String loadStudentInfo() {
		Student = getStudentByEmployeeID(id);
		setTeamAbbreviation(getOldEducationTeam(Student).getAbbreviation());
		return SUCCESS;
	}

	/**
	 * Adds the Student.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String addStudent() {
		setId(id);
		Student.create();
		EducationTeam et = getLessongroupbyID(Lessongroup);
		et.addStudent(Student);
		return SUCCESS;
	}



	/**
	 * Gets the Students for displaying on the webpage.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String readStudent() {
		getStudents();
		return SUCCESS;
	}

	/**
	 * Updates the Student.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String updateStudent() {
		for (Student f : getStudents()) {
			if (f.getEmployeeNumber() == Student.getEmployeeNumber()){
				f.setFirstName(Student.getFirstName());
				f.setAbbreviation();
				f.setInsertion(Student.getInsertion());
				f.setLastName(Student.getLastName());
				f.setEmail(Student.getEmail());
				f.setCardID(Student.getCardID());
				if (!(getOldEducationTeam(f).getAbbreviation().equals(teamAbbreviation))){
					getOldEducationTeam(f).deleteStudent(f);
					getEducationTeamByAbbreviation(teamAbbreviation).addStudent(f);
				}
				f.update();
			}
		}
		return SUCCESS;
	}

	/**
	 * Removes the Student.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String removeStudent() {
		Student = getStudentByEmployeeID(id);
		Student.delete();
		return SUCCESS;
	}

	/**
	 * updates the Students educationteam.
	 * 
	 * @param t
	 * @param newTeam
	 * @return String
	 */
	public String updateStudentEducationTeam(Student t, EducationTeam newTeam) {
		if(!(getOldEducationTeam(t).equals(newTeam))){
			getOldEducationTeam(t).deleteStudent(t);
			newTeam.addStudent(t);
		}
		return SUCCESS;
	}
	
	/**
	 * Removes the Student from the old education team.
	 * 
	 * @param t
	 * @param oldTeam
	 * @return String
	 */
	public String removeStudentFromEducationTeam(Student t, EducationTeam oldTeam){
		oldTeam.deleteStudent(t);
		return SUCCESS;
	}
	
	/**
	 * returns the education team the Student is currently in.
	 * 
	 * @param t
	 * @return EducationTeam
	 */
	public EducationTeam getOldEducationTeam(Student t){
		try {
			return t.getEducationTeam();
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * gets the Student by employee number.
	 * 
	 * @param id
	 * @return Student
	 */
	private Student getStudentByEmployeeID(int id) {
		try {
			return StudentService.getInstance().getStudentByEmployeeID(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * gets all Students
	 * 
	 * @return TreeSet<Student>
	 */
	public TreeSet<Student> getStudents() {
		try {
			Students.addAll(StudentService.getInstance().readAll());
			return Students;
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

	public void setStudents(TreeSet<Student> Students) {
		this.Students = Students;
	}

	public Student getStudent() {
		return Student;
	}

	public void setStudent(Student Student) {
		this.Student = Student;
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
