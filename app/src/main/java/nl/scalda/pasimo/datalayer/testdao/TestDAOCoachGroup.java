package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
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
		coachGroups.add(new CoachGroup(123, "A1"));
		coachGroups.add(new CoachGroup(124, "A2"));
		coachGroups.add(new CoachGroup(125, "A3"));
		
	}
	
	


	@Override
	public void create(CoachGroup cg) {
		try {
			coachGroups.add(cg);
			
		} catch (Exception ex) {
			System.out.println("Could not save. ended with Exception: " + ex.getMessage());
		}
	}

	@Override
	public CoachGroup read(CoachGroup coachGroup) {
		for (CoachGroup ccg : coachGroups) {
			try {
				if (coachGroup.getId() == ccg.getId()) {
					return ccg;
				}
			} catch (Exception ex) {
				System.out.println("Could not read. ended with Exception: " + ex.getMessage());
			}
		}
		return null;
=======
		coachGroups.add(new CoachGroup( 1234,"A1"));
		coachGroups.add(new CoachGroup( 12345,"A2"));
		coachGroups.add(new CoachGroup( 123456,"A3"));
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
				if (coachGroup.getId() == ccg.getId()) {
					return ccg;
				}
			} catch (Exception ex) {
			}
		}
		return null;
	}

	@Override
	public void delete(CoachGroup coachGroup) {
		try {
			coachGroups.remove(coachGroup);
		
		} catch (Exception ex) {
		}
>>>>>>> 426f123ee9dbf277c48fbaf7cb2735293db8089d
	}

	@Override
	public void update(CoachGroup coachGroup) {
		try {
<<<<<<< HEAD
			for (CoachGroup ccg : coachGroups) {
			
				if (coachGroup.getId() == ccg.getId()) {
					ccg = coachGroup;
					 ccg.setName(coachGroup.getName());
					 ccg.setTeacher(coachGroup.getTeacher());
					 ccg.setLessonGroups(coachGroup.getLessonGroups());
				}
			}
			} catch (Exception ex) {
				System.out.println("Could not update, ended with Exception: " + ex.getMessage());
			}
		
	}

	@Override
	public void delete(CoachGroup coachGroup) {
			try {
				this.coachGroups.remove(coachGroup);
				
			} catch (Exception ex) {
				System.out.println("Could not remove. ended with Exception: " + ex.getMessage());
			}

		}
	public void updateLessonGroup(CoachGroup coachGroup, LessonGroup lg) {
		try {
			for (CoachGroup ccg : coachGroups) {
			
				if (coachGroup.getId() == ccg.getId()) {
					 ccg = coachGroup;
					 ccg.addLessonGroup(lg);
				}
			}
			} catch (Exception ex) {
				System.out.println("Could not update, ended with Exception: " + ex.getMessage());
			}
		
	}
	public void delete(CoachGroup coachGroup, LessonGroup lg) {
			try {
				coachGroup.deleteLessonGroup(lg);
				
			} catch (Exception ex) {
				System.out.println("Could not remove. ended with Exception: " + ex.getMessage());
			}

		}
=======
			
			for (CoachGroup ccg : coachGroups) {

				if (coachGroup.getId() == ccg.getId()) {
					
					ccg.setName(coachGroup.getName());
					ccg.setCoach(coachGroup.getCoach());
					
					
					continue;
				}
			}
		} catch (Exception ex) {
		
		}

	}
>>>>>>> 426f123ee9dbf277c48fbaf7cb2735293db8089d

	public static TestDAOCoachGroup getInstance() {
		if (instance == null) {
			instance = new TestDAOCoachGroup();
		}
		return instance;
	}

	public TreeSet<CoachGroup> getCoachGroups() {
		return coachGroups;
	}

}
