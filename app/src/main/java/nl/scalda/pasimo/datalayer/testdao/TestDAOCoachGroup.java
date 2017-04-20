package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

/**
 *
 * @author jeroe
 */
public class TestDAOCoachGroup implements IDAOCoachGroup {

	private static TestDAOCoachGroup instance = null;
	private TreeSet<CoachGroup> coachGroups = new TreeSet<>();

	public TestDAOCoachGroup() {
<<<<<<< HEAD
		Teacher tc = new Teacher(124564, "k@k.com", 215950, "hallo", "vanerg", "klaas", 1999, 9, 15);
		coachGroups.add(new CoachGroup("A1", tc));
		coachGroups.add(new CoachGroup("A2", tc));
		coachGroups.add(new CoachGroup("A3", tc));
=======
    	CoachGroup c1 = new CoachGroup("B1");
		CoachGroup c2 = new CoachGroup("B2");
		
		TreeSet<LessonGroup> lessonGroups = 
				DAOFactory.getTheFactory().getDAOLessonGroup().readAll();
		
		for(LessonGroup lessonGroup : lessonGroups) {
			c1.addLessonGroup(lessonGroup);
		}
		
		coachGroups.add(c1);
		coachGroups.add(c2);
		
/*        LessonGroup l1 = new LessonGroup("ICO43A");
        LessonGroup l2 = new LessonGroup("ICO42A");
        LessonGroup l3 = new LessonGroup("ICO41A");*/
        
/*        c1.addLessonGroup(l1);
        c1.addLessonGroup(l2);
        c2.addLessonGroup(l3);*/
        
/*        TreeSet<Student> students = TestDAOStudent.getInstance().readAll();

        for(Student s : students) {
        	if(s == students.first()) {
        		l2.addStudent(s);
        	}
        }*/
        
		coachGroups.add(new CoachGroup("A1"));
		coachGroups.add(new CoachGroup("A2"));
		coachGroups.add(new CoachGroup("A3"));
>>>>>>> cb74bd81699c256a6f60371c10c38929fd19e0bb
	}

	@Override
	public void create(CoachGroup cg) {
		try {
			coachGroups.add(cg);
			
		} catch (Exception ex) {
		}
	}

	@Override
	public CoachGroup read(CoachGroup coachGroup) {
		for (CoachGroup ccg : coachGroups) {
			try {
				if (coachGroup.getName().equals(ccg.getName())) {
					coachGroup.setName(ccg.getName());
					coachGroup.setCoach(ccg.getCoach());
				}
			} catch (Exception ex) {
			}
		}
		return null;
	}
	
	@Override
	public TreeSet<CoachGroup> readAll() {
		return coachGroups;
	}

	@Override
	public void delete(CoachGroup coachGroup) {
		try {
			coachGroups.remove(coachGroup);
		
		} catch (Exception ex) {
		}
	}

	@Override
	public void update(CoachGroup coachGroup) {
		try {
			
			for (CoachGroup ccg : coachGroups) {

				if (coachGroup.getName().equals(ccg.getName())) {
					
					ccg.setCoach(coachGroup.getCoach());
					
					
					continue;
				}
			}
		} catch (Exception ex) {
		
		}

	}

	public static TestDAOCoachGroup getInstance() {
		if (instance == null) {
			instance = new TestDAOCoachGroup();
		}
		return instance;
	}

	public TreeSet<CoachGroup> getCoachGroups() {
		return coachGroups;
	}

	@Override
	public TreeSet<CoachGroup> readAllBYTeam(EducationTeam t) {
		return coachGroups;
	}
	
	

}
