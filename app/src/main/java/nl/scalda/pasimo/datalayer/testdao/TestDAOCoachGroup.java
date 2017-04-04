package nl.scalda.pasimo.datalayer.testdao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

/**
 *
 * @author jeroe
 */
public class TestDAOCoachGroup implements IDAOCoachGroup {

	private static TestDAOCoachGroup instance = null;
	private TreeSet<CoachGroup> coachGroups = new TreeSet<>();

	public TestDAOCoachGroup() {
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
	}

	@Override
	public void update(CoachGroup coachGroup) {
		try {
			
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
