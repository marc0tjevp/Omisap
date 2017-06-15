package nl.scalda.pasimo.datalayer.interfaces;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;

import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

public interface IDAOLessonGroup {

    void create(LessonGroup lessonGroup, CoachGroup coachGroup);

    Set<LessonGroup> readAll();
    
    TreeSet<LessonGroup> readAllByCoachGroup(CoachGroup coachGroup);
   
    
    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

    LessonGroup readLessonGroupByName(String lessonGroupName);
}