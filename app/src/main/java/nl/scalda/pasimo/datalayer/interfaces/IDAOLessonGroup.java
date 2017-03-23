package nl.scalda.pasimo.datalayer.interfaces;

import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

public interface IDAOLessonGroup {

    void create(LessonGroup lessonGroup);

    LessonGroup read(LessonGroup lessonGroup);

    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

    LessonGroup readLessonGroupByID(int lessonGroupId);
}