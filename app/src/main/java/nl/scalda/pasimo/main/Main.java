package nl.scalda.pasimo.main;

import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;
import nl.scalda.pasimo.model.EmployeeManagement.Student;
import nl.scalda.pasimo.service.LessonGroupService;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // Call LessonGroupService
        LessonGroupService lessonGroupService = LessonGroupService.getInstance();

        //Lesson group adding students later
        LessonGroup lessonGroup1 = new LessonGroup(1, "ICO41D");
        /*Student students[] = {
                new Student("Voornaam1", "Achternaam1", "student-email-1@student.scalda.nl", 1),
                new Student("Voornaam2", "Achternaam2", "student-email-2@student.scalda.nl", 2),
                new Student("Voornaam3", "Achternaam3", "student-email-3@student.scalda.nl", 3)
        };

        for (Student student : students) {
            lessonGroup1.addStudent(student);
        }*/

        //Empty lesson group
        LessonGroup lessonGroup2 = new LessonGroup(1, "ICO41A");

        //Lesson group with students already added

        /*TreeSet<Student> studentsForLessonGroup = new TreeSet<>();
        studentsForLessonGroup.add(new Student("Voornaam4", "Achternaam4", "student-email-4@student.scalda.nl", 4));
        studentsForLessonGroup.add(new Student("Voornaam5", "Achternaam5", "student-email-5@student.scalda.nl", 5));
        studentsForLessonGroup.add(new Student("Voornaam6", "Achternaam6", "student-email-6@student.scalda.nl", 6));*/

//        LessonGroup lessonGroup3 = new LessonGroup(1, "ICO41B", studentsForLessonGroup);

        lessonGroupService.create(lessonGroup1);
        lessonGroupService.create(lessonGroup2);
//        lessonGroupService.create(lessonGroup3);

        // Delete specific LessonGroup
        lessonGroupService.delete(lessonGroup1);

        // Updating LessonGroup
        lessonGroup2.setName("Een geupdatete les groep");

        lessonGroupService.update(lessonGroup2);

        // Reading specific LessonGroup
        lessonGroupService.read(lessonGroup2);

    }
}
