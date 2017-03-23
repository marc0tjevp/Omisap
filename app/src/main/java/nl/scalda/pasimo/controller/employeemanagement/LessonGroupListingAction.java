package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.service.LessonGroupService;
import nl.scalda.pasimo.test.lessonGroupList;

public class LessonGroupListingAction extends ActionSupport {

	/**
	 * 
	 */
	private TreeSet<LessonGroup> lessonGroups = new TreeSet<>();

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
		System.out.println("gewoon hier ");
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
		this.lessonGroups = TestDAOLessonGroup.getInstance().getLessongroups();
		LessonGroup previousLessonGroup = this.getLessonGroups().last();

		LessonGroup lessonGroupToAdd = new LessonGroup(previousLessonGroup.getId() + 1,
				this.lessonGroupName);
		this.lessonGroups.add(lessonGroupToAdd);
		TestDAOLessonGroup.getInstance().create(lessonGroupToAdd);
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 */
	public String deleteLessonGroup() {
		TestDAOLessonGroup.getInstance().readLessonGroupByID(deletelessongroupID);
		int deleteLessonGroupByID;
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