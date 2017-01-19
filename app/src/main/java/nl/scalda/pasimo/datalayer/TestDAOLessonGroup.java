package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;

import java.util.TreeSet;

public class TestDAOLessonGroup implements IDAOLessonGroup {

    private static TestDAOLessonGroup instance = null;
    private TreeSet<LessonGroup> lessongroups = new TreeSet<>();

    private TestDAOLessonGroup() {

    }

    public static TestDAOLessonGroup getInstance() {
        if (instance == null) {
            instance = new TestDAOLessonGroup();
        }
        return instance;
    }

    public TreeSet<LessonGroup> getLessongroups() {
        return lessongroups;
    }

    @Override
    public void create(LessonGroup lessonGroup) {
        if (lessonGroup == null) {
            return;
        }
        this.lessongroups.add(lessonGroup);
    }

    @Override
    public LessonGroup read(LessonGroup lessonGroup) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(LessonGroup oldLessonGroup, LessonGroup newLessonGroup) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(LessonGroup lessonGroup) {
        // TODO Auto-generated method stub

    }

}
