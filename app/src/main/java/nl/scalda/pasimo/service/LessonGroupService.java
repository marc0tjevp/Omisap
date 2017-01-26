/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.service;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;

/**
 *
 * @author jeroe
 */
public class LessonGroupService {

    private static LessonGroupService instance = null;

    public void create(LessonGroup lessonGroup) {
        DAOFactory.getTheFactory().getDAOLessonGroup().create(lessonGroup);

    }

    public LessonGroup read(LessonGroup lessonGroup) {
        return DAOFactory.getTheFactory().getDAOLessonGroup().read(lessonGroup);
    }

    public void update(LessonGroup lessonGroup) {
        DAOFactory.getTheFactory().getDAOLessonGroup().update(lessonGroup);
    }

    public void delete(LessonGroup lessonGroup) {
        DAOFactory.getTheFactory().getDAOLessonGroup().delete(lessonGroup);
    }

//    public TreeSet<LessonGroup> getLessonGroups() {
//        //you will only use this when testing
//        return TestDAOFactory.getTheFactory().getDAOLessonGroup().getLessonGroups();
//    }
    public static LessonGroupService getInstance() {
        if (instance == null) {
            instance = new LessonGroupService();
        }
        return instance;
    }
}
