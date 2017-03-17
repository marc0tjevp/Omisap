package nl.scalda.pasimo.datalayer.testdao;

import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

import java.util.TreeSet;

public class TestDAOLessonGroup implements IDAOLessonGroup {

    private static TestDAOLessonGroup instance = null;
    private TreeSet<LessonGroup> lessongroups = new TreeSet<>();

    private TestDAOLessonGroup() {

        LessonGroup l1 = new LessonGroup(1,"ICO43A");
        LessonGroup l2 = new LessonGroup(2,"ICO42A");
        LessonGroup l3 = new LessonGroup(3, "ICO41A");
        LessonGroup l4 = new LessonGroup(4, "ICO441G");
        
        Student student1 = new Student(1111, 1, 1, 2014, "bvandriel@student.scalda.nl", "Koen", "van", "driel", 201403, 1994, 1, 04, 26);
        Student student2 = new Student(2222, 2, 2, 2015, "someOtherGUy@student.scalda.nl", "Max", "van", "driel", 21235, 1994, 1, 04, 26);
        Student student3 = new Student(3333, 3, 3, 2016, "Hallo@student.scalda.nl", "Iemand", "van", "driel", 2521, 1994, 1, 04, 26);
        
        l1.addStudent(student1);
        l1.addStudent(student2);

        l2.addStudent(student3);
        
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
    
    public LessonGroup readLessonGroupByID(int lessonGroupId) {
    	for(LessonGroup lessonGroup : this.lessongroups) {
    		if(lessonGroupId != lessonGroup.getId()) {
    			continue;
    		}
    		return lessonGroup;
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