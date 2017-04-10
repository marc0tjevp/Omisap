package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeMap;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.service.LessonGroupService;

public class LessonGroupListingAction extends ActionSupport {
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 3651415035371001870L;
	
	/**
	 * All the coach groups with lesson groups in them
	 */
	private TreeSet<CoachGroup> coachGroupsWithLessonGroups;

	/**
	 * The name for adding or removing a lesson group
	 */
	private String lessonGroupName;

	/**
	 * Retrieves all the lesson groups and puts them in a list
	 */
	public String execute() {
		this.coachGroupsWithLessonGroups = LessonGroupService.getInstance().readAll();
		if (this.coachGroupsWithLessonGroups == null) {
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
    //this.lessonGroups = LessonGroupService.getInstance().create(lessonGroups);
	
	
	
	
		/*
		 * When the lesson group name is not filled in or empty
		 */
/*		if (this.lessonGroupName == null || this.lessonGroupName.equals("")) {
			return ERROR;
		}*/

		/*
		 * Add all the lesson groups to the action variable
		 */
/*		this.lessonGroups = TestDAOLessonGroup.getInstance().getLessongroups();
		LessonGroup previousLessonGroup = null;
		if (!this.lessonGroups.isEmpty()) {
			prleviousLessonGroup = this.lessonGroups.last();
		}*/

		/*
		 * Create the new lesson group
		 */
		/*int newLessonGroupId = previousLessonGroup != null ? previousLessonGroup.getId() + 1 : 1;
		LessonGroup lessonGroupToAdd = new LessonGroup(newLessonGroupId, this.lessonGroupName);
*/
		/*
		 * Save the new lesson group in the DAO and in the action variable
		 */
/*		TestDAOLessonGroup.getInstance().create(lessonGroupToAdd);
		this.lessonGroups.add(lessonGroupToAdd);*/

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
		//this.lessonGroups = TestDAOLessonGroup.getInstance().getLessongroups();
		
		/*
		 * Gets id from lesson group
		 */
		//LessonGroup lessonGroupToDelete = TestDAOLessonGroup.getInstance()
		//		.readLessonGroupByID(deletelessongroupID);

		/*
		 * Checks if there is a lesson group to delete, If none is found return
		 * ERROR
		 */
		//if (lessonGroupToDelete == null) {
		//	return ERROR;
		//}
		/*
		 * Deletes the given ID from the DAO and from the lessongroups, In case
		 * this succeeds, return SUCCESS
		 */
		//TestDAOLessonGroup.getInstance().delete(lessonGroupToDelete);
		//this.lessonGroups.remove(lessonGroupToDelete);

		return SUCCESS;
		

	}


	/**
	 * 
	 * @return
	 */
	public TreeSet<CoachGroup> getCoachGroupsWithLessonGroups() {
		return coachGroupsWithLessonGroups;
	}
	
	/**
	 * 
	 * @param coachGroupsWithLessonGroups
	 */
	public void setCoachGroupsWithLessonGroups(TreeSet<CoachGroup> coachGroupsWithLessonGroups) {
		this.coachGroupsWithLessonGroups = coachGroupsWithLessonGroups;
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