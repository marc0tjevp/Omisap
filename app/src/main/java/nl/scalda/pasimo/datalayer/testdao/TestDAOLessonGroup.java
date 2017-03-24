package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class TestDAOLessonGroup implements IDAOLessonGroup {

    private static TestDAOLessonGroup instance = null;
    private TreeSet<LessonGroup> lessongroups = new TreeSet<>();

    private TestDAOLessonGroup() {
        LessonGroup l1 = new LessonGroup(1,"ICO43A");
        LessonGroup l2 = new LessonGroup(2,"ICO42A");
        LessonGroup l3 = new LessonGroup(3, "ICO41A");
        LessonGroup l4 = new LessonGroup(4, "ICO441G");
        LessonGroup l5 = new LessonGroup(5,"ICOTSTCL");
        
        TreeSet<Student> students = TestDAOStudent.getInstance().readAll();

        for(Student s : students) {
        	if(s == students.first()) {
        		l2.addStudent(s);
        	}
        }
        
        lessongroups.add(l1);
        lessongroups.add(l2);
        lessongroups.add(l3);
        lessongroups.add(l4);
        lessongroups.add(l5);
    }

    public static TestDAOLessonGroup getInstance() {
        if (instance == null) {
        	System.out.println("hallo ja");
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