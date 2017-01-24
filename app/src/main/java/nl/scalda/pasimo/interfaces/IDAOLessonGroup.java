package nl.scalda.pasimo.interfaces;

import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;

public interface IDAOLessonGroup {

    public void create(LessonGroup lessonGroup);

    public LessonGroup read(LessonGroup lessonGroup) throws Exception;

    public void update(LessonGroup newLessonGroup) throws Exception;

    // TODO: fill delete parameters
    public void delete(LessonGroup lessonGroup) throws Exception;

}
