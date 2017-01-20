package nl.scalda.pasimo.main;

import nl.scalda.pasimo.datalayer.TestDAOFactory;
import nl.scalda.pasimo.datalayer.TestDAOLessonGroup;
import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;
import nl.scalda.pasimo.model.EmployeeManagement.Student;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        //Call up DAO factory
        IDAOLessonGroup daoFactory = TestDAOFactory.getTheFactory().getDAOLessonGroup();

        //Lesson group adding students later
        LessonGroup lessonGroup1 = new LessonGroup(1, "ICO41D");
        Student students[] = {
                new Student("Bas", "vanDriel", "basvandriel94@gmail.com", 1),
                new Student("Max", "vanDriel", "basvandriel94@gmail.com", 1),
                new Student("Martin", "vanDriel", "basvandriel94@gmail.com", 1)
        };

        for (Student student : students) {
            lessonGroup1.addStudent(student);
        }

        //Empty lesson group
        LessonGroup lessonGroup2 = new LessonGroup(1, "ICO41A");

        //Lesson group with students already added

        TreeSet<Student> studentjesVoorLessonGroup3 = new TreeSet<>();
        studentjesVoorLessonGroup3.add(new Student("Hendriiiik", "vanDriel", "basvandriel94@gmail.com", 1));
        studentjesVoorLessonGroup3.add(new Student("HendriiiikJuuuuh", "vanDriel", "basvandriel94@gmail.com", 2));
        studentjesVoorLessonGroup3.add(new Student("Koen", "vanDriel", "basvandriel94@gmail.com", 2));

        LessonGroup lessonGroup3 = new LessonGroup(1, "ICO41B", studentjesVoorLessonGroup3);


        daoFactory.create(lessonGroup1);
        daoFactory.create(lessonGroup2);
        daoFactory.create(lessonGroup3);

        TreeSet<LessonGroup> createdLessonGroups = ((TestDAOLessonGroup) daoFactory).getLessongroups();


        //Testing delete
        daoFactory.delete(lessonGroup2);

        TreeSet<LessonGroup> createdLessonGroups2 = ((TestDAOLessonGroup) daoFactory).getLessongroups();


    }
}
