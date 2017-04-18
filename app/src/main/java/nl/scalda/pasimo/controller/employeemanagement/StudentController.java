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
	private String LessonGroup;

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
		Student.getCardID();
		Student.getLessonGroupID();
		Student.getCoachGroupID();
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
		LessonGroup et = getLessonGroupbyID(Lessongroup);
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
				if (!(getOldEducationTeam(f).getAbbreviation().equals(LessonGroup))){
					getOldEducationTeam(f).deleteStudent(f);
					getEducationTeamByAbbreviation(LessonGroup).addStudent(f);
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
		Student = getStudentByCardID(id);
		Student.deleteStudent(Student);
		return SUCCESS;
	}

	/**
	 * updates the Students educationteam.
	 * 
	 * @param t
	 * @param newTeam
	 * @return String
	 */
	public String updateStudentEducationTeam(Student t, LessonGroup newTeam) {
		if(!(getLessonGroup(t).equals(newTeam))){
			(() getLessonGroup(t)).deleteStudent(t);
			newTeam.addStudent(t);
		}
		return SUCCESS;
	}
	
	private Object getLessonGroup(nl.scalda.pasimo.model.employeemanagement.Student t) {
		// TODO Auto-generated method stub
		return null;
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
	private Student getStudentByCardID(int id) {
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
	public TreeSet<LessonGroup> getLessonGroups() {
		LessonGroup.addAll(EducationTeamService.getInstance().getEducationTeams());
		return educationTeams;
	}
	
	/**
	 * gets the LessonGroup with the Card id that equals given ID
	 * 
	 * @param abbr
	 * @return EducationTeam
	 */

	
	public void setStudents(TreeSet<Student> Students) {
		this.Students = Students;
	}

	public Student getStudent() {
		return Student;
	}

	public void setStudent(Student Student) {
		this.Student = Student;
	}

	public String getLessenGroup() {
		return Lessongroup;
	}

	public void setLessonGroup(String LessonGroup) {
		this.LessonGroup = LessonGroup;
	}

	public void setEducationTeams(TreeSet<LessonGroup> educationTeams) {
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
	private nl.scalda.pasimo.model.employeemanagement.LessonGroup getLessonGroupbyID(String lessongroup2) {
		// TODO Auto-generated method stub
		return null;
	}
	private void delete
	delete Student student();
}
