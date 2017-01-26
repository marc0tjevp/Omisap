/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.datalayer;

import java.util.TreeSet;
import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;

/**
 *
 * @author jeroe
 */
public class TestDAOLessonGroup implements IDAOLessonGroup {

    private static TestDAOLessonGroup instance = null;
    private TreeSet<LessonGroup> lessonGroups = new TreeSet<>();

    public TestDAOLessonGroup() {
        lessonGroups.add(new LessonGroup("ICO41"));
        lessonGroups.add(new LessonGroup("ICO42"));
        lessonGroups.add(new LessonGroup("ICO43"));
        lessonGroups.add(new LessonGroup("ICO44"));
    }

    @Override
    public void create(LessonGroup lessonGroup) {
        try {
            lessonGroups.add(lessonGroup);
        } catch (Exception ex) {
            System.out.println("Could not save. ended with Exception: " + ex.getMessage());
        }
    }

    @Override
    public LessonGroup read(LessonGroup lessonGroup) {
        for (LessonGroup clg : lessonGroups) {
            try {
                if (lessonGroup.getId() == clg.getId()) {
                    return clg;
                }
            } catch (Exception ex) {
                System.out.println("Could not read. ended with Exception: " + ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public void update(LessonGroup lessonGroup) {
        for (LessonGroup clg : lessonGroups) {
            try {
                if (lessonGroup.getId() == clg.getId()) {
                    clg = lessonGroup;
                }
            } catch (Exception ex) {
                System.out.println("Could not update, ended with Exception: " + ex.getMessage());
            }
        }
    }

    @Override
    public void delete(LessonGroup lessonGroup) {
        try {
            lessonGroups.remove(lessonGroup);
        } catch (Exception ex) {
            System.out.println("Could not remove. ended with Exception: " + ex.getMessage());
        }
    }

    public static TestDAOLessonGroup getInstance() {
        if (instance == null) {
            instance = new TestDAOLessonGroup();
        }
        return instance;
    }

    public TreeSet<LessonGroup> getLessonGroups() {
        return lessonGroups;
    }

}
