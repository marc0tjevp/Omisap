package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

/**
 *
 * @author jeroe
 */
public class TestDAOCoachGroup implements IDAOCoachGroup {

	private static TestDAOCoachGroup instance = null;
	private TreeSet<CoachGroup> coachGroups = new TreeSet<>();

	public TestDAOCoachGroup() {
		coachGroups.add(new CoachGroup("A1"));
		coachGroups.add(new CoachGroup("A2"));
		coachGroups.add(new CoachGroup("A3"));
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
