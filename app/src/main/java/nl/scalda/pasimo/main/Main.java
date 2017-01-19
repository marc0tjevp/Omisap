/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.DAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOFactory;
import nl.scalda.pasimo.model.EmployeeManagement.CoachGroup;
import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;
import nl.scalda.pasimo.model.EmployeeManagement.Student;
import nl.scalda.pasimo.model.EmployeeManagement.Teacher;

/**
 *
 * @author jeroe
 */
public class Main {
    
    public static void main(String args[]) {
        
        DAOFactory.setTheFactory(TestDAOFactory.getInstance());
        
        Teacher bram = new Teacher("Bram", "van Huele", "bram@scalda.nl", 201111, "HEULBR");
        Teacher rens = new Teacher("Rens", "Brandon", "rens@scalda.nl", 202222, "BRANRE");
        Teacher gino = new Teacher("Gino", "Palo", "gino@scalda.nl", 203333, "PALOGI");
        
        Student didi = new Student("Didi", "zaadlikker", "Didi@student.scalda.nl", 206004);
        Student bas = new Student("Bas", "van Driel", "bas@student.scalda.nl", 206008);
        Student joost = new Student("Joost", "Leunen", "joost@student.scalda.nl", 206009);
        
        Student jeroen = new Student("Jeroen", "van Loon", "jeroen@student.scalda.nl", 206005);
        Student armando = new Student("Armando", "van oeffelen", "armando@student.scalda.nl", 206006);
        Student stein = new Student("Stein", "Shotgun", "stein@student.scalda.nl", 206010);
        
        Student kevin = new Student("Kevin", "Geertse", "kevin@student.scalda.nl", 206003);
        Student niek = new Student("Niek", "Flipse", "niek@student.scalda.nl", 206007);
        Student liam = new Student("Liam", "Achternaam", "liam@student.scalda.nl", 206011);
        
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
        
        ico411.addStudent(didi);
        ico411.addStudent(jeroen);
        
        ico412.addStudent(bas);
        ico412.addStudent(armando);
        
        ico413.addStudent(liam);
        ico413.addStudent(kevin);
        
        ico421.addStudent(liam);
        ico421.addStudent(niek);
        
        ico422.addStudent(armando);
        ico422.addStudent(joost);
        
        ico423.addStudent(stein);
        ico423.addStudent(didi);
        
        ico431.addStudent(kevin);
        ico431.addStudent(armando);
        
        ico432.addStudent(niek);
        ico432.addStudent(bas);
        
        ico433.addStudent(joost);
        ico433.addStudent(liam);
        
        a1.addLessonGroup(ico411);
        a1.addLessonGroup(ico421);
        a1.addLessonGroup(ico431);
        
        a2.addLessonGroup(ico412);
        a2.addLessonGroup(ico422);
        a2.addLessonGroup(ico432);
        
        a3.addLessonGroup(ico413);
        a3.addLessonGroup(ico423);
        a3.addLessonGroup(ico433);
        
        System.out.println("Coachgroep A1: " + a1);
        
    }
    
}
