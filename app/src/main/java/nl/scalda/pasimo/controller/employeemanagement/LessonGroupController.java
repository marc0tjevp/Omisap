package nl.scalda.pasimo.controller.employeemanagement;

import com.opensymphony.xwork2.ActionSupport;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

import java.util.TreeSet;

public class LessonGroupController extends ActionSupport {
    public int id;
    public String name;
    public TreeSet<Student> students = new TreeSet<>();
    public LessonGroup lessonGroup;

    public String execute(){
        //actions
        return SUCCESS;
    }

    public String saveLessonGroup(){


        return SUCCESS;
    }
}
