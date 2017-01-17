package nl.scalda.pasimo.datalayer;

import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.scalda.pasimo.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.model.EmployeeManagement.CoachGroup;

/**
 *
 * @author jeroe
 */
public class TestDAOCoachGroup implements IDAOCoachGroup {

    private static TestDAOCoachGroup instance = null;
    private TreeSet<CoachGroup> coachGroups = new TreeSet<>();

    private TestDAOCoachGroup() {
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
    }

    @Override
    public void update(CoachGroup oldCoachGroup, CoachGroup newCoachGroup) {
        for (CoachGroup ccg : coachGroups) {
            try {
                if (oldCoachGroup.getId() == ccg.getId()) {
                    ccg.setName(newCoachGroup.getName());
                    ccg.setTeacher(newCoachGroup.getTeacher());
                    ccg.setStudents(newCoachGroup.getStudents());
                }
            } catch (Exception ex) {
                System.out.println("Could not update, ended with Exception: " + ex.getMessage());
            }
        }
    }

    @Override
    public void delete(CoachGroup coachGroup) {
        try {
            coachGroups.remove(coachGroup);
        } catch (Exception ex) {
            System.out.println("Could not remove. ended with Exception: " + ex.getMessage());
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
