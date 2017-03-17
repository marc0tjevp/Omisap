package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class LessonGroupDetailsAction extends ActionSupport {

	/**
	 * 
	 */
	private int lessonGroupId;
	
	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
	 */
	private TreeSet<Student> students;
	
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
		
		if(this.students == null) {
			return ERROR;
		}
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
