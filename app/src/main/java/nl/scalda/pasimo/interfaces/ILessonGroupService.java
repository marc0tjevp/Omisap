package nl.scalda.pasimo.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

/**
 * Created by Gebruiker on 25-1-2017.
 */
public interface ILessonGroupService {

    void create(LessonGroup lessonGroup);

    LessonGroup read(LessonGroup lessonGroup);

    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

	TreeSet<LessonGroup> getLessongroups();

}