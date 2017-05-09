package nl.scalda.pasimo.test;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class lessonGroupList {

private static lessonGroupList instance;


private lessonGroupList() {}

public void addLessonGroup(LessonGroup lg){
//lessonGroupList.getInstance().addLessonGroup(lg);
addLessonGroup(lg);
}
public static lessonGroupList getInstance() {
    if (instance == null) {
        instance = new lessonGroupList();
    }
    return instance;
}
}
