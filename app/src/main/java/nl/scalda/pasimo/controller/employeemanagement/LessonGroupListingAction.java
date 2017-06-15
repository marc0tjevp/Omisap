package nl.scalda.pasimo.controller.employeemanagement;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.LessonGroupService;

public class LessonGroupListingAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3651415035371001870L;

	/**
	 * All the available coach groups for adding lesson groups to them
	 */
	private Set<CoachGroup> coachGroups;

	/**
	 * All the coach groups with lesson groups in them
	 */
	private Set<CoachGroup> coachGroupsWithLessonGroups;

	/**
	 * The name for adding or removing a lesson group
	 */
	private String lessonGroupName;

	/**
	 * The coach group name for adding or removing a lesson group
	 */
	private String coachGroupName;

	/**
	 * Retrieves all the lesson groups and puts them in a list
	 */
	public String execute() {
		this.coachGroups = CoachGroupService.getInstance().readAll();
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
		CoachGroup coachGroup = CoachGroupService.getInstance().readCoachGroup(this.coachGroupName);
		/*
		 * When the lesson group name is not filled in or empty
		 */
		if (this.lessonGroupName == null || this.lessonGroupName.equals("") || coachGroup == null) {
			return ERROR;
		}

		/*
		 * Create the new lesson group
		 */
		LessonGroup lessonGroupToAdd = new LessonGroup(this.lessonGroupName);

		/*
		 * Save the new lesson group in the coach group and update it in the DAO
		 */
		coachGroup.addLessonGroup(lessonGroupToAdd, true);

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
		 * Find the coach group the lesson group gets deleted from
		 */
		CoachGroup coachGroup = CoachGroupService.getInstance().readCoachGroup(this.coachGroupName);

		/*
		 * Find the lesson group which gets deleted from the coach group
		 */
		LessonGroup lessonGroup = coachGroup.getLessonGroupByName(this.lessonGroupName);

		/*
		 * Checks if the lesson group exists in the coach group, If it isn't found return
		 * ERROR
		 */
		if (lessonGroup == null) {
			return ERROR;
		}

		/*
		 * Delete the lesson group
		 */
		coachGroup.deleteLessonGroup(lessonGroup);
		
		return SUCCESS;

	}

	/**
	 * 
	 * @return
	 */
	public Set<CoachGroup> getCoachGroupsWithLessonGroups() {
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

	/**
	 * 
	 * @return
	 */
	public String getCoachGroupName() {
		return this.coachGroupName;
	}

	/**
	 * 
	 * @param coachGroupName
	 */
	public void setCoachGroupName(String coachGroupName) {
		this.coachGroupName = coachGroupName;
	}

	public Set<CoachGroup> getCoachGroups() {
		return coachGroups;
	}

	public void setCoachGroups(TreeSet<CoachGroup> coachGroups) {
		this.coachGroups = coachGroups;
	}

}