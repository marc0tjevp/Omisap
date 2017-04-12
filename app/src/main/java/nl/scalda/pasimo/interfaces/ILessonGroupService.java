package nl.scalda.pasimo.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

public interface ILessonGroupService {

    void create(LessonGroup lessonGroup);
    
    TreeSet<CoachGroup> readAll();
    
    LessonGroup read(LessonGroup lessonGroup);
    
    LessonGroup readByLessonGroupName(String name);

    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

}