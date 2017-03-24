package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.service.LessonGroupService;
import nl.scalda.pasimo.test.lessonGroupList;

public class LessonGroupListingAction extends ActionSupport {

	/**
	 * 
	 */
	private TreeSet<LessonGroup> lessonGroups;

	/**
	 * 
	 */
	private String lessonGroupName;

	/**
	 * 
	 */
	private int deletelessongroupID;

	/**
	 * 
	 */
	public String execute() {
		this.lessonGroups = TestDAOLessonGroup.getInstance().getLessongroups();
		return SUCCESS;
	}

	/**
	 * Adds a lesson group
	 * 
	 * @return
	 */
	public String addLessonGroup() {
		if (this.lessonGroupName == null || this.lessonGroupName.equals("")) {
			return ERROR;
		}
		// Add all the lesson groups to the action variable
		this.lessonGroups = TestDAOLessonGroup.getInstance().getLessongroups();

		// Retrieve the previous lesson group for getting an lesson group id
		LessonGroup previousLessonGroup = null;
		if (!this.lessonGroups.isEmpty()) {
			previousLessonGroup = this.lessonGroups.last();
		}

		/*
		 * Create the new lesson group
		 */
		int newLessonGroupId = previousLessonGroup != null ? previousLessonGroup.getId() + 1 : 1;
		LessonGroup lessonGroupToAdd = new LessonGroup(newLessonGroupId, this.lessonGroupName);

		/*
		 * Save the new lesson group in the DAO and in the action variable
		 */
		TestDAOLessonGroup.getInstance().create(lessonGroupToAdd);
		this.lessonGroups.add(lessonGroupToAdd);

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
		this.lessonGroups = TestDAOLessonGroup.getInstance().getLessongroups();
		
		/*
		 * Gets id from lesson group
		 */
		LessonGroup lessonGroupToDelete = TestDAOLessonGroup.getInstance()
				.readLessonGroupByID(deletelessongroupID);

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

	public int getDeletelessongroupID() {
		return deletelessongroupID;
	}

	public void setDeletelessongroupID(int deletelessongroupID) {
		this.deletelessongroupID = deletelessongroupID;
	}

}