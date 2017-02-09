/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

/**
 *
 * @author jeroe
 */
public class Main {

    public static void main(String args[]) {

        LessonGroup l1 = new LessonGroup(1, "ICO43A");
        LessonGroup l2 = new LessonGroup(2, "ICO42A");
        LessonGroup l3 = new LessonGroup(3, "ICO41A");

        CoachGroup c1 = new CoachGroup(1, "A1");

        c1.addLessonGroup(l1);
        c1.addLessonGroup(l2);
        c1.addLessonGroup(l3);

    }

}
