package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.employeeManagement.LessonGroup;

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
        this.lessongroups.add(lessonGroup);
    }

    @Override
    public LessonGroup read(LessonGroup lessonGroup) {

        for (LessonGroup eachLessonGroup : this.lessongroups) {
            if (lessonGroup != eachLessonGroup) {
                continue;
            }
            return eachLessonGroup;
        }

        return null;
    }

    @Override
    public void update(LessonGroup newLessonGroup) {

        for (LessonGroup lessonGroup : this.lessongroups) {
            if (lessonGroup != newLessonGroup) {
                continue;
            }
            lessonGroup.setName(newLessonGroup.getName());
            lessonGroup.setID(newLessonGroup.getID());
            lessonGroup.setStudents(newLessonGroup.getStudents());
        }

    }

    @Override
    public void delete(LessonGroup lessonGroup) {
        this.lessongroups.remove(lessonGroup);
    }

}