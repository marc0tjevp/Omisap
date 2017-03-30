package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeMap;
import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

public interface IDAOLessonGroup {

    void create(LessonGroup lessonGroup);

    TreeMap<CoachGroup, TreeSet<LessonGroup>> readAll();
   
    LessonGroup read(LessonGroup lessonGroup);
    
    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

    LessonGroup readLessonGroupByID(int lessonGroupId);
}