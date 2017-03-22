package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class LessonGroupDetailsAction extends ActionSupport {

	/**
	 * The ID of this lesson group
	 */
	private int lessonGroupId;
	
	/**
	 * The lesson group name
	 */
	private String name;
	
	/**
	 * The students which are in this lesson group
	 */
	private TreeSet<Student> students;
	
	/**
	 * The additional students which are not in this lesson group
	 */
	private static TreeSet<Student> additionalStudents;
	/**
	 * 
	 */
	public String execute() {
		LessonGroup specificLessonGroup = TestDAOLessonGroup.getInstance().readLessonGroupByID(lessonGroupId);
		if(specificLessonGroup == null) {
			return ERROR;
		}
		this.name = specificLessonGroup.getName();
		this.students = specificLessonGroup.getStudents();
		
		// Instantiate the static TreeSet of additional students
		if(additionalStudents == null) {
			additionalStudents = new TreeSet<>();
		}
		//TODO Filter out the students which are already in this lesson group
		additionalStudents = TestDAOStudent.getInstance().getStudents();
		
		if(this.students == null) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 */
	public String updateLessonGroupName() {
		LessonGroup specificLessonGroup = TestDAOLessonGroup.getInstance().readLessonGroupByID(lessonGroupId);
		if(specificLessonGroup == null) {
			return ERROR;
		}
		specificLessonGroup.setName(this.name);
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLessonGroupId() {
		return this.lessonGroupId;
	}
	
	/**
	 * 
	 * @param lessonGroupId
	 */
	public void setLessonGroupId(int lessonGroupId) {
		this.lessonGroupId = lessonGroupId;
	
	}
	
	/**
	 * 
	 * @return
	 */
	public TreeSet<Student> getStudents() {
		return this.students;
	}
	
	/**
	 * 
	 * @param students
	 */
	public void setStudents(TreeSet<Student> students) {
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
