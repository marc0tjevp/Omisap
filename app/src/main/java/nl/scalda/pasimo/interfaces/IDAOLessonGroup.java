package nl.scalda.pasimo.interfaces;

import nl.scalda.pasimo.model.employeeManagement.LessonGroup;

public interface IDAOLessonGroup {

    void create(LessonGroup lessonGroup);

    LessonGroup read(LessonGroup lessonGroup);

    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

}
