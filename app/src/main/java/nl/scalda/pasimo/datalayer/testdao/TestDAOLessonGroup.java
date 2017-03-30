package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeMap;
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
        LessonGroup l1 = new LessonGroup("ICO43A");
        LessonGroup l2 = new LessonGroup("ICO42A");
        LessonGroup l3 = new LessonGroup("ICO41A");
        LessonGroup l4 = new LessonGroup("ICO441G");
        LessonGroup l5 = new LessonGroup("ICOTSTCL");
        
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
            instance = new TestDAOLessonGroup();
        }
        return instance;
    }
    
    @Override
    public void create(LessonGroup lessonGroup) {
        this.lessongroups.add(lessonGroup);
    }
    
    public LessonGroup readLessonGroupByName(String lessonGroupName) {
    	for(LessonGroup lessonGroup : this.lessongroups) {
    		if(lessonGroupName != lessonGroup.getName()) {
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

	@Override
	public TreeMap<CoachGroup, TreeSet<LessonGroup>> readAll() {
		return null;
	}

	@Override
	public LessonGroup read(LessonGroup lessonGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}