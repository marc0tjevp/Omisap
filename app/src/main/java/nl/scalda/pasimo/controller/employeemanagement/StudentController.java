package nl.scalda.pasimo.controller.employeemanagement;

import java.io.File;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.service.LessonGroupService;
import nl.scalda.pasimo.service.StudentService;

public class StudentController extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public Student student = new Student();
	public String teamAbbreviation;
	public TreeSet<Student> Students = new TreeSet<>();
	public TreeSet<LessonGroup> LessonGroup = new TreeSet<>();
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
		student = getStudentByStudentOv(id);
		return SUCCESS;
	}

	/**
	 * Adds the Student.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String addStudent() {
		Student.create();
		LessonGroup et = getLessonGroupByAbbreviation(teamAbbreviation);
		et.addStudent(student);
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
//	public String updateStudent() {
//		for (Student f : getStudents()) {
//			if (f.getStudentOV() == Student.getStudentOV()){
//				f.setFirstName(Student.getFirstName());
//				f.setInsertion(Student.getInsertion());
//				f.setLastName(Student.getLastName());
//				f.setEmail(Student.getEmail());
//				f.setCardID(Student.getCardID());
//				if (!(getOldLessonGroup(f).getAbbreviation().equals(teamAbbreviation))){
//					getOldLessonGroup(f).deleteStudent(f);
//					getLessonGroupByAbbreviation(teamAbbreviation).addStudent(f);
//				}
//				f.update();
//			}
//		}
//		return SUCCESS;
//	}

	/**
	 * Removes the Student.
	 * Called from Struts.xml file
	 * 
	 * @return String
	 */
	public String removeStudent(Student s) {
		student = getStudentByEmployeeID(id);
		student.deleteStudent(s);
		return SUCCESS;
	}

	/**
	 * updates the Students LessonGroup.
	 * 
	 * @param t
	 * @param newTeam
	 * @return String
	 */
	public String updateStudentLessonGroup(Student t, LessonGroup newTeam) {
		if(!(getOldLessonGroup(t).equals(newTeam))){
			getOldLessonGroup(t).deleteStudent(t);
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
	public String removeStudentFromLessonGroup(Student t, LessonGroup oldTeam){
		oldTeam.deleteStudent(t);
		return SUCCESS;
	}
	
	/**
	 * returns the education team the Student is currently in.
	 * 
	 * @param s
	 * @return LessonGroup
	 */
	public LessonGroup getOldLessonGroup(Student s){
		try {
			return s.getLessonGroup();
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
			return StudentService.getInstance().getStudentById(id);
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
	 * @return TreeSet<LessonGroup>
	 */
	public TreeSet<LessonGroup> getLessonGroups() {
		LessonGroups.addAll(LessonGroupService.getInstance().getLessonGroups());
		return LessonGroups;
	}
	
	/**
	 * gets the LessonGroup with the abbreviation that equals given abbreviation
	 * 
	 * @param abbr
	 * @return LessonGroup
	 */
	public LessonGroup getLessonGroupByAbbreviation(String abbr){
		for(LessonGroup et : getLessonGroups()){
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
		return student;
	}

	public void setStudent(Student Student) {
		this.student = Student;
	}

	public String getTeamAbbreviation() {
		return teamAbbreviation;
	}

	public void setTeamAbbreviation(String teamAbbreviation) {
		this.teamAbbreviation = teamAbbreviation;
	}

	public void setLessonGroups(TreeSet<LessonGroup> LessonGroups) {
		this.LessonGroups = LessonGroups;
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
