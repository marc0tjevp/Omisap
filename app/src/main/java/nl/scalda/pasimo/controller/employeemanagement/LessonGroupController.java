package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.test.lessonGroupList;

public class LessonGroupController extends ActionSupport {
	
	private TreeSet<LessonGroup> lessonGroups;

    public String execute() {
    	this.readLessonGroups();
        
    	return SUCCESS;
    }
    
    public String readLessonGroups() {
    	lessonGroups = TestDAOLessonGroup.getInstance().getLessongroups();
    	
    	
    	return SUCCESS;
    }
    
    public String addLessonGroup(LessonGroup lg) {
   lessonGroupList.getInstance().addLessonGroup(lg);
   
    return SUCCESS;
    }

    public String saveLessonGroup() {

    	
        return SUCCESS;
    }

	public TreeSet<LessonGroup> getLessonGroups() {
		return lessonGroups;
	}

	public void setLessonGroups(TreeSet<LessonGroup> lessonGroups) {
		this.lessonGroups = lessonGroups;
	}

	LessonGroup i4 = new LessonGroup("TestLessonGroup");
}