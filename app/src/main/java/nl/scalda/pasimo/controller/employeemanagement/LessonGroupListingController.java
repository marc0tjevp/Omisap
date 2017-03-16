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
    public String execute() {
    	if(lessonGroups == null) {
    		lessonGroups = new TreeSet<>();
    	}
    	lessonGroups = TestDAOLessonGroup.getInstance().getLessongroups();
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

}