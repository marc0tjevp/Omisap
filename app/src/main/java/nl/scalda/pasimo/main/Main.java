package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.TestDAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOLessonGroup;
import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.employeeManagement.LessonGroup;
import nl.scalda.pasimo.model.employeeManagement.Student;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        //Call up DAO factory
        IDAOLessonGroup lessonGroupDAO = TestDAOFactory.getTheFactory().getDAOLessonGroup();

        //Lesson group adding students later
        LessonGroup lessonGroup1 = new LessonGroup(1, "ICO41D");
        Student students[] = {
                new Student("Voornaam1", "Achternaam1", "student-email-1@student.scalda.nl", 1),
                new Student("Voornaam2", "Achternaam2", "student-email-2@student.scalda.nl", 2),
                new Student("Voornaam3", "Achternaam3", "student-email-3@student.scalda.nl", 3)
        };

        for (Student student : students) {
            lessonGroup1.addStudent(student);
        }

        //Empty lesson group
        LessonGroup lessonGroup2 = new LessonGroup(1, "ICO41A");

        //Lesson group with students already added

        TreeSet<Student> studentjesVoorLessonGroup3 = new TreeSet<>();
        studentjesVoorLessonGroup3.add(new Student("Voornaam4", "Achternaam4", "student-email-4@student.scalda.nl", 4));
        studentjesVoorLessonGroup3.add(new Student("Voornaam5", "Achternaam5", "student-email-5@student.scalda.nl", 5));
        studentjesVoorLessonGroup3.add(new Student("Voornaam6", "Achternaam6", "student-email-6@student.scalda.nl", 6));

        LessonGroup lessonGroup3 = new LessonGroup(1, "ICO41B", studentjesVoorLessonGroup3);


        lessonGroupDAO.create(lessonGroup1);
        lessonGroupDAO.create(lessonGroup2);
        lessonGroupDAO.create(lessonGroup3);

        TreeSet<LessonGroup> createdLessonGroups = ((TestDAOLessonGroup) lessonGroupDAO).getLessongroups();


        //Testing delete
//        lessonGroupDAO.delete(lessonGroup1);

        TreeSet<LessonGroup> createdLessonGroups2 = ((TestDAOLessonGroup) lessonGroupDAO).getLessongroups();

        //Updating lessongroup
        lessonGroup2.setName("Een geupdatete les groep");

        lessonGroupDAO.update(lessonGroup2);

        lessonGroupDAO.read(lessonGroup2);

    }
}
