package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.service.LessonGroupService;

public class LessonGroupListingAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3651415035371001870L;

	/**
	 * All the lesson groups
	 */
	private TreeSet<LessonGroup> lessonGroups;

	/**
	 * The name for adding or removing a lesson group
	 */
	private String lessonGroupName;

	/**
	 * Retrieves all the lesson groups and puts them in a list
	 */
	public String execute() {
		this.lessonGroups = LessonGroupService.getInstance().readAll();
		if (this.lessonGroups == null) {
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * Adds a lesson group
	 * 
	 * @return
	 */
	public String addLessonGroup() {
		LessonGroup lessonGroupToAdd = new LessonGroup(lessonGroupName);
		LessonGroupService.getInstance().create(lessonGroupToAdd);

		/*
		 * Add all the lesson groups to the action variable
		 */
/*		this.lessonGroups = TestDAOLessonGroup.getInstance().getLessongroups();
		LessonGroup previousLessonGroup = null;
		if (!this.lessonGroups.isEmpty()) {
			previousLessonGroup = this.lessonGroups.last();
		}*/

		/*
		 * Save the new lesson group in the DAO and in the action variable
		 */
/*		TestDAOLessonGroup.getInstance().create(lessonGroupToAdd);
		this.lessonGroups.add(lessonGroupToAdd);
*/
		return SUCCESS;
	}

	/**
	 * Deletes the lesson group via the given id and creates 1 new ajax request
	 * per press
	 * 
	 * @return
	 */
	public String deleteLessonGroup() {
		/*
		 * Add all the lesson groups to the action variable
		 */
		this.lessonGroups = LessonGroupService.getInstance().readAll();
		
		/*
		 * Gets id from lesson group
		 */
		LessonGroup lessonGroupToDelete = TestDAOLessonGroup.getInstance()
				.readLessonGroupByName(lessonGroupName);

		/*
		 * Checks if there is a lesson group to delete, If none is found return
		 * ERROR
		 */
		if (lessonGroupToDelete == null) {
			return ERROR;
		}
		/*
		 * Deletes the given ID from the DAO and from the lessongroups, In case
		 * this succeeds, return SUCCESS
		 */
		TestDAOLessonGroup.getInstance().delete(lessonGroupToDelete);
		this.lessonGroups.remove(lessonGroupToDelete);

		return SUCCESS;
		

	}

	/**
	 * 
	 * @return
	 */
	public TreeSet<LessonGroup> getLessonGroups() {
		return lessonGroups;
	}

	/**
	 * 
	 * @param lessonGroups
	 */
	public void setLessonGroups(TreeSet<LessonGroup> lessonGroups) {
		this.lessonGroups = lessonGroups;
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
	 * @param lessonGroupName
	 */
	public void setLessonGroupName(String lessonGroupName) {
		this.lessonGroupName = lessonGroupName;
	}

}