/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

/**
 *
 * @author jeroe
 */
public class MYSQLDAOLessonGroup implements IDAOLessonGroup {

    private static MYSQLDAOLessonGroup instance = null;

    @Override
    public void create(LessonGroup LessonGroup) {

    }

    @Override
    public LessonGroup read(LessonGroup LessonGroup) {
        return LessonGroup;
    }

    @Override
    public void update(LessonGroup lessonGroup) {

    }

    @Override
    public void delete(LessonGroup LessonGroup) {

    }

    public static MYSQLDAOLessonGroup getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOLessonGroup();
        }
        return instance;
    }

}
