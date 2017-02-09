package nl.scalda.pasimo.service;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.interfaces.ILessonGroupService;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;


public class LessonGroupService implements ILessonGroupService {

    private static LessonGroupService instance = null;

    private LessonGroupService() {
        DAOFactory.setTheFactory(TestDAOFactory.getInstance());
    }

    public static LessonGroupService getInstance() {
        if (instance == null) {
            instance = new LessonGroupService();
        }

        return instance;
    }

    @Override
    public void create(LessonGroup lessonGroup) {
        DAOFactory.getTheFactory().getDAOLessonGroup().create(lessonGroup);
    }

    @Override
    public LessonGroup read(LessonGroup lessonGroup) {
        return DAOFactory.getTheFactory().getDAOLessonGroup().read(lessonGroup);
    }

    @Override
    public void update(LessonGroup newLessonGroup) {
        DAOFactory.getTheFactory().getDAOLessonGroup().update(newLessonGroup);
    }

    @Override
    public void delete(LessonGroup lessonGroup) {
        DAOFactory.getTheFactory().getDAOLessonGroup().delete(lessonGroup);
    }
}