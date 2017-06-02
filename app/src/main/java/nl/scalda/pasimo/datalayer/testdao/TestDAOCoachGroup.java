package nl.scalda.pasimo.datalayer.testdao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    private static Map<EducationTeam, TreeSet<CoachGroup>> eduCoachGroups = new HashMap<>();

    private TestDAOCoachGroup() {

        CoachGroup c1 = new CoachGroup("asdasd");
        EducationTeam edu = new EducationTeam("ICOb", "ICO41A", 1);

        coachGroups.add(c1);

        eduCoachGroups.put(edu, coachGroups);
    }

    @Override
    public void create(CoachGroup cg, EducationTeam edu) {

        try {
            coachGroups.add(cg);
            eduCoachGroups.get(edu).add(cg);

        } catch (Exception ex) {
        }
    }

    @Override
    public void read(CoachGroup coachGroup) {
        for (CoachGroup ccg : coachGroups) {
            try {
                if (coachGroup.getName().equals(ccg.getName())) {
                    coachGroup.setName(ccg.getName());
                    coachGroup.setCoach(ccg.getCoach());
                }
            } catch (Exception ex) {
            }

        }
    }

    @Override
    public void delete(CoachGroup coachGroup) {
        try {
            coachGroups.remove(coachGroup);

        } catch (Exception ex) {
        }
    }

    @Override
    public void update(CoachGroup coachGroup, String oldname) {
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

    @Override
    public TreeSet<CoachGroup> readAllBYTeam(EducationTeam t) {
        if (eduCoachGroups == null) {
            return coachGroups;
        } else {
            TreeSet<CoachGroup> get = eduCoachGroups.get(t);
            return eduCoachGroups.get(t);
        }

    }

    @Override
    public TreeSet<CoachGroup> readAll() {
        if (eduCoachGroups == null) {
            return coachGroups;
        } else {
            return coachGroups;
        }
    }

}