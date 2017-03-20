package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.test.lessonGroupList;

public class LessonGroupListingController extends ActionSupport {
	
	/**
	 * 
	 */
	private static TreeSet<LessonGroup> lessonGroups;

	/**
	 * 
	 */
	private String lessonGroupName;
	
	/**
	 * 
	 */
    public String execute() {
    	if(lessonGroups == null) {
    		lessonGroups = new TreeSet<>();
    	}
    	lessonGroups = TestDAOLessonGroup.getInstance().getLessongroups();
    	return SUCCESS;
    }
    
    /**
     * Adds a lesson group
     * 
     * @return
     */
    public String addLessonGroup() {
    	if(this.lessonGroupName == null || this.lessonGroupName.equals("")) {
    		return ERROR;
    	}
    	LessonGroup previousLessonGroup = this.lessonGroups.last();
    	
    	this.lessonGroups.add(new LessonGroup(previousLessonGroup.getId() + 1, lessonGroupName));
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