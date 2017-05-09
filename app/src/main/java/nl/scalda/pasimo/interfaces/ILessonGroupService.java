package nl.scalda.pasimo.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

public interface ILessonGroupService {

    void create(LessonGroup lessonGroup);
    
    TreeSet<CoachGroup> readAll();
    
    LessonGroup read(LessonGroup lessonGroup);
    
    LessonGroup readByLessonGroupName(String name, String coachGroupName );
    
    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

	TreeSet<LessonGroup> getLessongroups();

}