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
        coachGroups.add(new CoachGroup("A1", new Teacher()));
        coachGroups.add(new CoachGroup("A2", new Teacher()));
        coachGroups.add(new CoachGroup("A3", new Teacher()));
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
    public void update(CoachGroup coachGroup) {
        for (CoachGroup ccg : coachGroups) {
            try {
                if (coachGroup.getId() == ccg.getId()) {
                    ccg = coachGroup;
//                    ccg.setName(coachGroup.getName());
//                    ccg.setTeacher(coachGroup.getTeacher());
//                    ccg.setLessonGroups(coachGroup.getLessonGroups());
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
