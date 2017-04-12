package nl.scalda.pasimo.datalayer.testdao;

import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Student;

public class TestDAOLessonGroup implements IDAOLessonGroup {

    private static TestDAOLessonGroup instance = null;
    private TreeSet<LessonGroup> lessongroups = new TreeSet<>();

     private TestDAOLessonGroup() {
//    	TreeSet<CoachGroup> coachGroups = 
//    			DAOFactory.getTheFactory().getDAOCoachGroup().readAll();
    	
//    	for(CoachGroup coachGroup : coachGroups) {
//    		coachGroup.addLessonGroup(
//    				new LessonGroup("lesgroep" + UUID.randomUUID().toString())
//    				
//    				);
    	//}
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
	public TreeSet<LessonGroup> readAll() {
		return this.lessongroups;
	}

	@Override
	public LessonGroup read(LessonGroup lessonGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<LessonGroup> readAllByCoachGroup(CoachGroup coachGroup) {		
		TreeSet<CoachGroup> coachGroups = DAOFactory.getTheFactory().getDAOCoachGroup().readAll();
		
		for(CoachGroup loopingCoachGroup : coachGroups) {
			if(coachGroup != loopingCoachGroup) {
				continue;
			}
			return loopingCoachGroup.getLessonGroups();
			 
		}
		return null;
	}

}