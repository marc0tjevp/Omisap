package nl.scalda.pasimo.datalayer.testdao;

import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

import java.util.TreeSet;

public class TestDAOLessonGroup implements IDAOLessonGroup {

    private static TestDAOLessonGroup instance = null;
    private TreeSet<LessonGroup> lessongroups = new TreeSet<>();

    private TestDAOLessonGroup() {

        LessonGroup l1 = new LessonGroup("ICO43A");
        LessonGroup l2 = new LessonGroup("ICO42A");
        LessonGroup l3 = new LessonGroup("ICO41A");
        LessonGroup l4 = new LessonGroup("ICO441G");
        
        lessongroups.add(l1);
        lessongroups.add(l2);
        lessongroups.add(l3);
        lessongroups.add(l4);
        

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
            lessonGroup.setId(newLessonGroup.getId());
            lessonGroup.setStudents(newLessonGroup.getStudents());
        }

    }

    @Override
    public void delete(LessonGroup lessonGroup) {
        this.lessongroups.remove(lessonGroup);
    }

	public static void setInstance(TestDAOLessonGroup instance) {
		TestDAOLessonGroup.instance = instance;
	}

	public void setLessongroups(TreeSet<LessonGroup> lessongroups) {
		this.lessongroups = lessongroups;
	}

}