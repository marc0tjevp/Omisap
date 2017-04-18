package nl.scalda.pasimo.controller.employeemanagement;

import java.io.File;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;


import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.service.EducationTeamService;
import nl.scalda.pasimo.service.LessonGroupService;
import nl.scalda.pasimo.service.StudentService;

public class StudentController extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public Student student = new Student();
	public TreeSet<Student> Students = new TreeSet<>();
	public TreeSet<LessonGroup> lessonGroups = new TreeSet<>();
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
		student.getCardID();
		student.getLessonGroup();
		student.getCoachGroup();
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
		student.create();
		LessonGroup et = getLessonGroupByName(LessonGroup);
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
	public String updateStudent() {
		for (Student f : getStudents()) {
			if (f.getCardID() == student.getCardID()){
				f.setFirstName(student.getFirstName());
				f.setInsertion(student.getInsertion());
				f.setLastName(student.getLastName());
				f.setEmail(student.getEmail());
				f.setCardID(student.getCardID());
				if (!(getOldLessonGroup(f).getName().equals(LessonGroup))){
					getOldLessonGroup(f).deleteStudent(f);
					getLessonGroupByName(LessonGroup).addStudent(f);
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
		student = getStudentByCardID(id);
		student.delete();
		return SUCCESS;
	}

	/**
	 * updates the Students Lessongroup.
	 * 
	 * @param t
	 * @param newTeam
	 * @return String
	 */
	public String updateStudentLessonGroup(Student t, LessonGroup newTeam) {
		if(!(getLessonGroup().equals(newTeam))){
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
	public String removeStudentFromLessonGroup(Student t, LessonGroup oldLessonGroup){
		oldLessonGroup.deleteStudent(t);
		return SUCCESS;
	}
	
	/**
	 * returns the education team the Student is currently in.
	 * 
	 * @param t
	 * @return EducationTeam
	 */
	public LessonGroup getOldLessonGroup(Student t){
		try {
			return t.getLessonGroup();
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
	public TreeSet<LessonGroup> getLessonGroups() {
		lessonGroups.addAll(LessonGroupService.getInstance().getLessongroups());
		return lessonGroups;
	}
	
	
	/**
	 * gets the LessonGroup with the Card id that equals given name
	 * 
	 * @param lessonGroup
	 * @return EducationTeam
	 */
	
	public LessonGroup getLessonGroupByName(String lessonGroup){
		for(LessonGroup lg : getLessonGroups()){
			if(lg.getName().equals(lessonGroup)){
				return lg;
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

	public String getLessonGroup() {
		return LessonGroup;
	}

	public void setLessonGroup(String LessonGroup) {
		this.LessonGroup = LessonGroup;
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
