package nl.scalda.pasimo.controller.employeemanagement;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
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
	 * Lesson group details page
	 */
	public String execute() {
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
