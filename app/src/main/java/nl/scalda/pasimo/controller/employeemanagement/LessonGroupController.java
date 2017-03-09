package nl.scalda.pasimo.controller.employeemanagement;

import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

import java.util.TreeSet;

public class LessonGroupController extends ActionSupport {
	
	private TreeSet<LessonGroup> lessonGroups;

    public String execute() {
    	this.readLessonGroups();
    	return SUCCESS;
    }
    
    public String readLessonGroups() {
    	return SUCCESS;
    }
    
    public String addLessonGroup() {
    	return SUCCESS;
    }

    public String saveLessonGroup() {


        return SUCCESS;
    }
}