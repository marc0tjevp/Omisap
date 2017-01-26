package nl.scalda.pasimo.datalayer;

import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.scalda.pasimo.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.model.EmployeeManagement.CoachGroup;
import nl.scalda.pasimo.model.EmployeeManagement.Teacher;

/**
 *
 * @author jeroe
 */
public class TestDAOCoachGroup implements IDAOCoachGroup {

    private static TestDAOCoachGroup instance = null;
    private TreeSet<CoachGroup> coachGroups = new TreeSet<>();

    public TestDAOCoachGroup() {
        coachGroups.add(new CoachGroup("A1", new Teacher("Bram", "van Heule", "bram@scalda.nl", 1, "HUELBR")));
        coachGroups.add(new CoachGroup("A2", new Teacher("Rens", "Brandon", "rens@scalda.nl", 2, "BRANRE")));
        coachGroups.add(new CoachGroup("A3", new Teacher("Gino", "Paulo", "gino@scalda.nl", 3, "PAULGI")));
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
