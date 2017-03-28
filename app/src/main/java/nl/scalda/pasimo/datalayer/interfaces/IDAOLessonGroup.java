package nl.scalda.pasimo.datalayer.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

public interface IDAOLessonGroup {

    void create(LessonGroup lessonGroup);

    TreeSet<LessonGroup> readAll();

    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

    LessonGroup readLessonGroupByName(String lessonGroupName);
}