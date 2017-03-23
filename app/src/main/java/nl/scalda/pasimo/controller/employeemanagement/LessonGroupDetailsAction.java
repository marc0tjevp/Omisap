package nl.scalda.pasimo.controller.employeemanagement;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAOStudent;
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
	private TreeSet<Student> additionalStudents;

	/**
	 * 
	 */
	public String execute() {
		LessonGroup specificLessonGroup = TestDAOLessonGroup.getInstance().readLessonGroupByID(lessonGroupId);
		if (specificLessonGroup == null) {
			return ERROR;
		}
		this.name = specificLessonGroup.getName();
		this.students = specificLessonGroup.getStudents();
	
		/*
		 * Retrieve all the students from the student DAO and add them to the array
		 */
		this.additionalStudents = TestDAOStudent.getInstance().readAll();
		
		/*
		 * Filter out the students which are in the current lesson group
		 */
		Iterator<Student> iterator = additionalStudents.iterator();
		while(iterator.hasNext()) {
			Student currentStudent = iterator.next();
			if(!students.contains(currentStudent)) {
				continue;
			}
			iterator.remove();
		}
				
		if (this.students == null) {
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
		if (specificLessonGroup == null) {
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

	/**
	 * 
	 * @return
	 */
	public TreeSet<Student> getAdditionalStudents() {
		return additionalStudents;
	}

	/**
	 * 
	 * @param additionalStudents
	 */
	public void setAdditionalStudents(TreeSet<Student> additionalStudents) {
		this.additionalStudents = additionalStudents;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}