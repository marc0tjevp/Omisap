package nl.scalda.pasimo.interfaces;

import java.util.TreeMap;
import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import java.util.TreeSet;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

public interface ILessonGroupService {

    void create(LessonGroup lessonGroup);
    
    TreeMap<CoachGroup, TreeSet<LessonGroup>> readAll();
    
    LessonGroup read(LessonGroup lessonGroup);

    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

}