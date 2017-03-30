package nl.scalda.pasimo.interfaces;

import java.util.TreeMap;
import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

/**
 * Created by Gebruiker on 25-1-2017.
 */
public interface ILessonGroupService {

    void create(LessonGroup lessonGroup);
    
    TreeMap<CoachGroup, TreeSet<LessonGroup>> readAll();
    
    LessonGroup read(LessonGroup lessonGroup);

    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

}