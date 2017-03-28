package nl.scalda.pasimo.interfaces;

import java.util.TreeSet;

import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

public interface ILessonGroupService {

    void create(LessonGroup lessonGroup);
    
    TreeSet<LessonGroup> readAll();

    LessonGroup read(LessonGroup lessonGroup);

    void update(LessonGroup newLessonGroup);

    void delete(LessonGroup lessonGroup);

}