/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import java.util.TreeSet;
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

/**
 *
 * @author jeroe
 */
public class Main {

    public static void main(String args[]) {

        CSVReader CSVReader = new CSVReader();
//        TreeSet<Student> students
//        System.out.println("students: " + CSVReader.readFile("C:\\Users\\jeroe\\Downloads\\pasimo bestanden\\csv\\ICOA1 - ICT mentor groep Bram van Huelen_5839196583067931640.csv"));

        DAOFactory.setTheFactory(TestDAOFactory.getInstance());
        
        EducationTeam ED = new EducationTeam("Applicatie Ontwikkeling", "AO");

        Teacher bram = new Teacher("Bram", "van Huele", "bram@scalda.nl", 201111, "HEULBR");
        Teacher rens = new Teacher("Rens", "Brandon", "rens@scalda.nl", 202222, "BRANRE");
        Teacher gino = new Teacher("Gino", "Palo", "gino@scalda.nl", 203333, "PALOGI");

        LessonGroup ico411 = new LessonGroup("ICO41");
        LessonGroup ico412 = new LessonGroup("ICO41");
        LessonGroup ico413 = new LessonGroup("ICO41");

        LessonGroup ico421 = new LessonGroup("ICO42");
        LessonGroup ico422 = new LessonGroup("ICO42");
        LessonGroup ico423 = new LessonGroup("ICO42");

        LessonGroup ico431 = new LessonGroup("ICO43");
        LessonGroup ico432 = new LessonGroup("ICO43");
        LessonGroup ico433 = new LessonGroup("ICO43");

        CoachGroup a1 = new CoachGroup("A1", bram);
        CoachGroup a2 = new CoachGroup("A2", rens);
        CoachGroup a3 = new CoachGroup("A3", gino);

        for (Student cs : CSVReader.readFile("C:\\Users\\jeroe\\Downloads\\pasimo bestanden\\csv\\ICOA1 - ICT mentor groep Bram van Huelen_5839196583067931640.csv")) {
            ico411.addStudent(cs);
            ico412.addStudent(cs);
            ico413.addStudent(cs);
            ico421.addStudent(cs);
            ico422.addStudent(cs);
            ico423.addStudent(cs);
            ico431.addStudent(cs);
            ico432.addStudent(cs);
            ico433.addStudent(cs);
        }

        a1.addLessonGroup(ico411);
        a1.addLessonGroup(ico421);
        a1.addLessonGroup(ico431);

        a2.addLessonGroup(ico412);
        a2.addLessonGroup(ico422);
        a2.addLessonGroup(ico432);

        a3.addLessonGroup(ico413);
        a3.addLessonGroup(ico423);
        a3.addLessonGroup(ico433);
        
        ED.addCoachGroup(a1);
        ED.addCoachGroup(a2);
        ED.addCoachGroup(a3);

        System.out.println("Coachgroep A1: " + a1);

    }

}
