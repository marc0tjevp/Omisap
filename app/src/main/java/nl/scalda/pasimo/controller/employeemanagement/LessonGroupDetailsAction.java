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
	 * The ID of the student to add to this lesson group
	 */
	private int studentId;

	/**
	 * Retrieves all the lesson groups and puts them in a list
	 */
	public String execute() {
		LessonGroup specificLessonGroup = TestDAOLessonGroup.getInstance().readLessonGroupByID(lessonGroupId);
		if (specificLessonGroup == null) {
			return ERROR;
		}
		this.name = specificLessonGroup.getName();
		this.students = specificLessonGroup.getStudents();

		/*
		 * Retrieve all the students from the student DAO and add them to the
		 * array
		 */
		this.additionalStudents = TestDAOStudent.getInstance().readAll();

		/*
		 * Filter out the students which are in the current lesson group
		 */
		Iterator<Student> currentLessonGroupStudentsIterator = additionalStudents.iterator();
		while (currentLessonGroupStudentsIterator.hasNext()) {
			Student currentStudent = currentLessonGroupStudentsIterator.next();
			if (!students.contains(currentStudent)) {
				continue;
			}
			currentLessonGroupStudentsIterator.remove();
		}

		/*
		 * Get all lesson groups for filtering out students which are in other
		 * lesson groups
		 */
		TreeSet<LessonGroup> allLessonGroups = new TreeSet<>(TestDAOLessonGroup.getInstance().getLessongroups());

		/*
		 * Loop through all other lesson groups which are not this current
		 * lesson group
		 */
		for (LessonGroup lessonGroup : allLessonGroups) {
			if (lessonGroup == specificLessonGroup) {
				continue;
			}
			TreeSet<Student> otherStudents = new TreeSet<>(lessonGroup.getStudents());

			/*
			 * Filter out students which are in other lesson groups
			 */
			Iterator<Student> otherLessonGroupsStudentsIterator = otherStudents.iterator();
			while (otherLessonGroupsStudentsIterator.hasNext()) {
				Student otherLessonGroupStudent = otherLessonGroupsStudentsIterator.next();

				this.additionalStudents.remove(otherLessonGroupStudent);
			}
		}

		if (this.students == null) {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * Updates the lesson group name
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
	 * Adds a student to the current lesson group
	 * 
	 * @return
	 */
	public String addStudent() {
		LessonGroup specificLessonGroup = TestDAOLessonGroup.getInstance().readLessonGroupByID(lessonGroupId);
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
		LessonGroup specificLessonGroup = TestDAOLessonGroup.getInstance().readLessonGroupByID(lessonGroupId);
		Student specificStudent = TestDAOStudent.getInstance().readByOvNumber(this.studentId);
		if (specificLessonGroup == null || specificStudent == null) {
			return ERROR;
		}
		specificLessonGroup.deleteStudent(specificStudent);
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
