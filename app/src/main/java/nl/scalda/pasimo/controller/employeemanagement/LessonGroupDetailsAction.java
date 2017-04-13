package nl.scalda.pasimo.controller.employeemanagement;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAOStudent;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.service.LessonGroupService;

public class LessonGroupDetailsAction extends ActionSupport {

	/**
	 * The lesson group name for retreiving the actions
	 */
	private String lessonGroupName;

	/**
	 * 
	 */
	private String coachGroupName;

	/**
	 * The lesson group name for updating it
	 */
	private String newLessonGroupName;

	/**
	 * The students which are in this lesson group
	 */
	private TreeSet<Student> students;

	/**
	 * The additional students which are not in this lesson group
	 */
	private TreeSet<Student> additionalStudents;

	/**
	 * The ID of the student to add to this lesson group
	 */
	private int studentId;

	/**
	 * Retrieves all the students for the current lesson group
	 */
	public String execute() {
		LessonGroup specificLessonGroup = LessonGroupService.getInstance().readByLessonGroupName(this.lessonGroupName,
				this.coachGroupName);
		
		this.students = specificLessonGroup.getStudents();

		if (specificLessonGroup == null || this.students == null) {
			return ERROR;
		}

		/*
		 * Read all the additional students which you can add to the current lesson group
		 * 
		 * These are:
		 *  - Not the students which are in the current lesson group
		 *  - Students which are already in other lesson groups
		 */
		this.additionalStudents = LessonGroupService.getInstance().readAdditionalStudents(specificLessonGroup);
		return SUCCESS;
	}

	/**
	 * Updates the lesson group name
	 * 
	 * @return
	 */
	public String updateLessonGroupName() {
		LessonGroup specificLessonGroup = LessonGroupService.getInstance().readByLessonGroupName(this.lessonGroupName,
				this.coachGroupName);

		if (specificLessonGroup == null) {
			return ERROR;
		}
		specificLessonGroup.setName(this.newLessonGroupName);
		specificLessonGroup.updateLessonGroup();

		return SUCCESS;
	}

	/**
	 * Adds a student to the current lesson group
	 * 
	 * @return
	 */
	public String addStudent() {
		// LessonGroup specificLessonGroup =
		// TestDAOLessonGroup.getInstance().readLessonGroupByID(lessonGroupId);
		LessonGroup specificLessonGroup = null;
		Student specificStudent = TestDAOStudent.getInstance().readByOvNumber(this.studentId);
		if (specificLessonGroup == null || specificStudent == null) {
			return ERROR;
		}
		specificLessonGroup.addStudent(specificStudent);
		return SUCCESS;
	}

	/**
	 * Deletes one student from the current lesson group
	 * 
	 * @return
	 */
	public String deleteStudent() {
		/*
		 * 
		 */
		LessonGroup specificLessonGroup =
				LessonGroupService.getInstance().readByLessonGroupName(this.lessonGroupName, this.coachGroupName);
		/*
		 * Get specific student which we are going to delete
		 */
		Student specificStudent = specificLessonGroup.getStudentByOv(this.studentId);
		
		/*
		 * Error checking if the lesson group or student doesn't exist
		 */
		if (specificLessonGroup == null || specificStudent == null) {
			return ERROR;
		}
		
		/*
		 * Delete the student
		 */
		specificLessonGroup.deleteStudent(specificStudent);
		specificLessonGroup.updateLessonGroup();
		return SUCCESS;
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
	public int getStudentId() {
		return this.studentId;
	}

	/**
	 * 
	 * @param studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * 
	 * @return
	 */
	public String getLessonGroupName() {
		return lessonGroupName;
	}

	/**
	 * 
	 * @param name
	 */
	public void setLessonGroupName(String name) {
		this.lessonGroupName = name;
	}

	public String getCoachGroupName() {
		return coachGroupName;
	}

	public void setCoachGroupName(String coachGroupName) {
		this.coachGroupName = coachGroupName;
	}

	public String getNewLessonGroupName() {
		return newLessonGroupName;
	}

	public void setNewLessonGroupName(String newLessonGroupName) {
		this.newLessonGroupName = newLessonGroupName;
	}

}
